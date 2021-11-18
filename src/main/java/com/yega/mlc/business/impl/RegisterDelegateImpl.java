package com.yega.mlc.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.business.RegisterDelegate;
import com.yega.mlc.constants.BusinessConstants;
import com.yega.mlc.constants.EnumBeneficio;
import com.yega.mlc.constants.EnumEstatusPropuesta;
import com.yega.mlc.constants.EnumFieldQuery;
import com.yega.mlc.constants.EnumTipoBeneficiario;
import com.yega.mlc.constants.SystemConstants;
import com.yega.mlc.dto.AceptarPropResponseDTO;
import com.yega.mlc.dto.AceptarPropuestaDTO;
import com.yega.mlc.dto.BeneficiarioDTO;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PropuestaDTO;
import com.yega.mlc.dto.PropuestaPersistDTO;
import com.yega.mlc.dto.RegistroDTO;
import com.yega.mlc.dto.RegistroResponseDTO;
import com.yega.mlc.dto.RespuestaDTO;
import com.yega.mlc.dto.ServicioBeneficiarioDTO;
import com.yega.mlc.dto.ServicioContratadoDTO;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.service.BeneficiaryService;
import com.yega.mlc.service.BenefitService;
import com.yega.mlc.service.PlanBeneficiosBeneficiariosService;
import com.yega.mlc.service.ProposalService;
import com.yega.mlc.service.PropuestaService;
import com.yega.mlc.service.QuestionSheetService;
import com.yega.mlc.service.ServicioContratadoService;
import com.yega.mlc.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Component("registerDelegateCore")
public class RegisterDelegateImpl extends RegisterDelegate {

        @Autowired
        protected ProposalService proposalService;

        @Autowired
        @Qualifier("propuestaServiceWeb")
        private PropuestaService propuestaService;

        @Autowired
        protected BeneficiaryService beneficiaryService;

        @Autowired
        @Qualifier("benefitServiceCore")
        private BenefitService benefitService;

        @Autowired
        private QuestionSheetService questionSheetService;

        @Autowired
        private PlanBeneficiosBeneficiariosService planBeneficiosBeneficiariosService;

        @Autowired
        private ServicioContratadoService servicioContratadoService;

        @Override
        @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
        public RegistroResponseDTO createRegister(RegistroDTO registro) {

                if (registro.getPropuestaId() == null) {
                        var propuesta = guardarPropuesta(registro);
                        registro.setPropuestaId(propuesta.getPropuestaId());
                } else {
                        limpiarRegistro(registro);
                }

                var listBeneficiariosNew = guardarBeneficiario(registro);

                var beneficiosDtoNew = guardarBeneficios(registro, listBeneficiariosNew);

                var fechaNac = DateUtils.allowSegVida(registro.getCurp());
                if(fechaNac){
                        guardarRespuestasQ(registro, listBeneficiariosNew, beneficiosDtoNew);
                }                

                var beneficioBeneficiarios = new HashMap<Integer, List<Integer>>();
                registro.getBeneficios().forEach(beneficio->{
                        beneficioBeneficiarios.put(beneficio.getBeneficioId(), beneficio.getBeneficiarios());
                });
                var plan = planBeneficiosBeneficiariosService.getPlan(registro.getCurp(), beneficioBeneficiarios);

                var prop = new PropuestaDTO(registro.getPropuestaId(), null, registro.getCurp(), null, null);
                return new RegistroResponseDTO(prop, plan, listBeneficiariosNew);
        }

        private PropuestaPersistDTO guardarPropuesta(RegistroDTO registro) {
                try {
                        var hoy = new Date();
                        var activo = true;
                        var propu = propuestaService.getPropuestaByCurp(registro.getCurp());

                        if (propu.getPropuestaid() != null && propu.getPropuestaid() > 0) {
                                var message = String.format("CURP exists %s", registro.getCurp());
                                var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
                                throw new ServiceException(errorCode, errorCode.getMessage());
                        }

                        var edad = DateUtils.calcularEdadByCurp(registro.getCurp());
                        var esMenor56 = (edad.getYears() < BusinessConstants.EDAD_PLAN_ACCESO);
                        var propuestaPersis = new PropuestaPersistDTO(null, null, null,
                                        EnumEstatusPropuesta.PROCESO.getValue(), registro.getCurp(), esMenor56, activo,
                                        null, hoy, SystemConstants.USUARIO_SISTEMA, hoy, null, activo);

                        return proposalService.crear(propuestaPersis);
                } catch (Exception e) {
                        var message = String.format("Cann't save proposal %s", e.toString());
                        var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
                        throw new ServiceException(errorCode, errorCode.getMessage());
                }
        }

        private List<BeneficiarioDTO> guardarBeneficiario(RegistroDTO registro) {
                try {
                        var hoy = new Date();
                        var activo = true;
                        var listBeneficiarios = registro.getBeneficiarios().stream()
                                        .map(tipoBeneficiarioId -> new BeneficiarioDTO(null, null,
                                                        registro.getPropuestaId(), tipoBeneficiarioId, hoy,
                                                        SystemConstants.USUARIO_SISTEMA, hoy, null, activo))
                                        .collect(Collectors.toList());
                        return beneficiaryService.createBeneficiary(listBeneficiarios);
                } catch (Exception e) {
                        var message = String.format("Cann't save beneficiary %s", e.toString());
                        var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
                        throw new ServiceException(errorCode, errorCode.getMessage());
                }
        }

        private List<ServicioBeneficiarioDTO> guardarBeneficios(RegistroDTO registro,
                        List<BeneficiarioDTO> listBeneficiariosNew) {
                try {
                        var hoy = new Date();
                        var activo = 1;
                        var beneficiosDto = new ArrayList<ServicioBeneficiarioDTO>();
                        var listBeneficios = registro.getBeneficios();
                        listBeneficios.forEach(element -> {
                                element.getBeneficiarios().forEach(tipoBeneficiarioId -> {
                                        var beneficiario = listBeneficiariosNew.stream().filter(
                                                        ele -> ele.getTipoBeneficiarioId() == tipoBeneficiarioId)
                                                        .findAny().orElse(null);
                                        var servBen = new ServicioBeneficiarioDTO(null,
                                                        beneficiario.getBeneficiarioId(), null,
                                                        element.getBeneficioId(), null, hoy,
                                                        SystemConstants.USUARIO_SISTEMA, hoy, null, activo);
                                        beneficiosDto.add(servBen);
                                });
                        });

                        return benefitService.createBenefit(beneficiosDto);
                } catch (Exception e) {
                        var message = String.format("Cann't save benefit %s", e.toString());
                        var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
                        throw new ServiceException(errorCode, errorCode.getMessage());
                }
        }

        private void guardarRespuestasQ(RegistroDTO registro, List<BeneficiarioDTO> listBeneficiariosNew,
                        List<ServicioBeneficiarioDTO> beneficiosDtoNew) {
                var listPreguntas = registro.getRespuestas();
                try {
                if(CollectionUtils.isEmpty(listPreguntas)){
                        return;
                }
                        var hoy = new Date();
                        var beneficiarioTitular = listBeneficiariosNew.stream().filter(benef -> benef
                                        .getTipoBeneficiarioId() == EnumTipoBeneficiario.TITULAR.getValue()).findAny()
                                        .orElse(null);

                        var servBen = beneficiosDtoNew.stream().filter(beneficio -> EnumBeneficio.REPATRIACION_A_MEXICO
                                        .getValue() == beneficio.getBeneficioId()
                                        && beneficio.getBeneficiarioId() == beneficiarioTitular.getBeneficiarioId())
                                        .findAny().orElse(null);

                        var listRespuestas = new ArrayList<RespuestaDTO>();
                        listPreguntas.forEach(resp -> {
                                var respuesta = new RespuestaDTO(null, resp.getPreguntaId(),
                                                servBen.getServicioBeneficiarioId(), resp.getRespuesta(), hoy,
                                                SystemConstants.USUARIO_SISTEMA, hoy, null, true);
                                listRespuestas.add(respuesta);
                        });
                        questionSheetService.saveAnswers(listRespuestas);
                } catch (Exception e) {
                        var message = String.format("Cann't save questionSheet %s", e.toString());
                        var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
                        throw new ServiceException(errorCode, errorCode.getMessage());
                }
        }

        @Override
        @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
        public AceptarPropResponseDTO acceptProposal(AceptarPropuestaDTO aceptarPropuesta) {
                var hoy = new Date();
                var prop = proposalService.getById(aceptarPropuesta.getPropuestaId());
                prop.setUsuarioModificacion(SystemConstants.USUARIO_SISTEMA);
                prop.setFechaModificacion(hoy);
                proposalService.actualizar(prop);

                ServicioContratadoDTO servNew = getServicioContratadoByPropuestaId(aceptarPropuesta.getPropuestaId());

                if(servNew == null){
                        var serConDTO = new ServicioContratadoDTO(null, aceptarPropuesta.getFrecuenciaPagoId(),
                                        aceptarPropuesta.getPropuestaId(), aceptarPropuesta.getTipoPlanId(),
                                        aceptarPropuesta.getFormaPagoId(), hoy, SystemConstants.USUARIO_SISTEMA, hoy, null,
                                        true);
                        servNew = servicioContratadoService.crear(serConDTO);
                }else{
                        servNew.setFrecuenciaPagoId(aceptarPropuesta.getFrecuenciaPagoId());
                        servNew.setTipoPlanId(aceptarPropuesta.getTipoPlanId());
                        servNew.setFormaPagoId(aceptarPropuesta.getFormaPagoId());
                        servNew.setFechaModificacion(hoy);
                        servNew.setUsuarioModificacion(SystemConstants.USUARIO_SISTEMA);
                        servicioContratadoService.actualizar(servNew);
                }

                return new AceptarPropResponseDTO(prop.getPropuestaId(), prop.getCurp(),
                                servNew.getServicioContratadoId());
        }

        private ServicioContratadoDTO getServicioContratadoByPropuestaId(Integer propuestaId){
                Set<FieldQueryDTO> fieldsQuery = new HashSet<FieldQueryDTO>();
                fieldsQuery.clear();
                fieldsQuery.add(new FieldQueryDTO("propuestaId", propuestaId, EnumFieldQuery.EQUALS));
                var listServContratado = servicioContratadoService.getResultSet(fieldsQuery);                
                return listServContratado.stream().findFirst().orElse(null);
        }

        protected void limpiarRegistro(RegistroDTO registro) {
                try {
                        Set<FieldQueryDTO> fieldsQuery = new HashSet<FieldQueryDTO>();
                        var beneficiariosIds = new ArrayList<Integer>();

                        fieldsQuery.clear();
                        fieldsQuery.add(new FieldQueryDTO("propuestaId", registro.getPropuestaId(),
                                        EnumFieldQuery.EQUALS));
                        var listBeneficiarios = beneficiaryService.getResultSet(fieldsQuery);

                        listBeneficiarios.forEach(ele -> {
                                beneficiariosIds.add(ele.getBeneficiarioId());
                        });
                        var sortedList = beneficiariosIds.stream().sorted().collect(Collectors.toList());

                        fieldsQuery.clear();
                        fieldsQuery.add(new FieldQueryDTO("beneficiarioId", sortedList.get(sortedList.size() - 1),
                                        EnumFieldQuery.LESS_OR_EQUALS));
                        fieldsQuery.add(new FieldQueryDTO("beneficiarioId", sortedList.stream().findFirst().get(),
                                        EnumFieldQuery.GREATER_OR_EQUALS));
                        var listServBenef = benefitService.getResultSet(fieldsQuery);

                        var benefIds = new ArrayList<Integer>();
                        listServBenef.forEach(servBenef -> {
                                benefIds.add(servBenef.getServicioBeneficiarioId());
                        });

                        var respIds = new ArrayList<Integer>();
                        var lisRespuestas = registro.getRespuestas();
                        if (!CollectionUtils.isEmpty(lisRespuestas)) {
                                lisRespuestas.forEach(resp -> {
                                        respIds.add(resp.getRespuestaId());
                                });
                        }
                        if (!CollectionUtils.isEmpty(respIds)) {
                                questionSheetService.deleteByIds(respIds);
                        }

                        if (!CollectionUtils.isEmpty(benefIds)) {
                                benefitService.deleteByIds(benefIds);
                        }

                        if (!CollectionUtils.isEmpty(beneficiariosIds)) {
                                beneficiaryService.deleteByIds(beneficiariosIds);
                        }
                } catch (Exception e) {
                        var message = String.format("Cann't clear register (p) %s", e.toString());
                        var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
                        throw new ServiceException(errorCode, errorCode.getMessage());
                }
        }

}
