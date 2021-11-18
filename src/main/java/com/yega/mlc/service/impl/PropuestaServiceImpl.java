package com.yega.mlc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.yega.mlc.dto.BeneficiarioBeneficiosDTO;
import com.yega.mlc.dto.BeneficioSimpleDTO;
import com.yega.mlc.dto.BeneficiosBeneficiariosDTO;
import com.yega.mlc.dto.BeneficiosBeneficiariosResponseDTO;
import com.yega.mlc.dto.GetPropuestaResponseDTO;
import com.yega.mlc.dto.PropBeneficiarioBeneficioDTO;
import com.yega.mlc.dto.PropuestaCuestionarioDTO;
import com.yega.mlc.entity.Cbeneficios;
import com.yega.mlc.entity.CuestionarioEntity;
import com.yega.mlc.entity.PreguntaEntity;
import com.yega.mlc.entity.PropuestaNativeQuery;
import com.yega.mlc.entity.VbeneficiosBeneficiarios;
import com.yega.mlc.entity.VpropuestaBeneficiariosBeneficios;
import com.yega.mlc.entity.VpropuestaCuestionario;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.BeneficiosRepository;
import com.yega.mlc.repository.QuestionSheetRepository;
import com.yega.mlc.repository.VbeneficiosBeneficiariosRepository;
import com.yega.mlc.repository.VpropuestaBeneficiariosBeneficiosRepository;
import com.yega.mlc.repository.VpropuestaCuestionarioRepository;
import com.yega.mlc.service.PropuestaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("propuestaServiceCore")
public class PropuestaServiceImpl implements PropuestaService {

    @Autowired
    protected VpropuestaBeneficiariosBeneficiosRepository vpropuestaBeneficiariosBeneficiosRepository;

    @Autowired
    private VpropuestaCuestionarioRepository vpropuestaCuestionarioRepository;

    @Autowired
    private VbeneficiosBeneficiariosRepository vbeneficiosBeneficiariosRepository;

    @Autowired
    private QuestionSheetRepository questionSheetRepository;

    @Autowired
    private BeneficiosRepository beneficiosRepository;

    public PropBeneficiarioBeneficioDTO getResumenPropuesta(String curp) {
        try {
            PropBeneficiarioBeneficioDTO propBeneficiarioBeneficioDTO;
            List<VpropuestaBeneficiariosBeneficios> vPropuestaBBList = vpropuestaBeneficiariosBeneficiosRepository
                    .findByCurp(curp);
            BeneficiarioBeneficiosDTO beneficiarioBeneficiosDTO = new BeneficiarioBeneficiosDTO();

            List<Cbeneficios> beneficiosList = beneficiosRepository.findAll();
            List<BeneficioSimpleDTO> beneficioLista = new ArrayList<>();
            BeneficioSimpleDTO beneficioSimpleDTO;

            for (Cbeneficios beneficio : beneficiosList) {
                if (beneficio.getCltipobeneficio().getCatalogodetalleid() == 66) {
                    beneficioSimpleDTO = new BeneficioSimpleDTO();
                    beneficioSimpleDTO.setBeneficioId(beneficio.getBeneficioid());
                    beneficioSimpleDTO.setTitulobeneficio(beneficio.getTitulobeneficio());
                    beneficioSimpleDTO.setActivo(false);
                    System.out.println("Beneficio :"+beneficioSimpleDTO.getBeneficioId()+" - "+beneficioSimpleDTO.getTitulobeneficio()+" - "+beneficioSimpleDTO.isActivo());
                    beneficioLista.add(beneficioSimpleDTO);
                    
                }
            }
            propBeneficiarioBeneficioDTO = new PropBeneficiarioBeneficioDTO();
            if (!vPropuestaBBList.isEmpty() || null != vPropuestaBBList) {
                
                VpropuestaBeneficiariosBeneficios vPropuestaBB = vPropuestaBBList.get(0);
                propBeneficiarioBeneficioDTO.setPropuestaid(vPropuestaBB.getPropuestaid());
                 propBeneficiarioBeneficioDTO.setClFormaPagoId(vPropuestaBB.getClFormaPagoId());
                 propBeneficiarioBeneficioDTO.setFormaPago(vPropuestaBB.getFormaPago());
                 propBeneficiarioBeneficioDTO.setFormaPago(vPropuestaBB.getFormaPago());
                 propBeneficiarioBeneficioDTO.setClFrecuenciaPagoId(vPropuestaBB.getClFrecuenciaPagoId());
                 propBeneficiarioBeneficioDTO.setFrecuenciaPago(vPropuestaBB.getFrecuenciaPago());
                 propBeneficiarioBeneficioDTO.setClMonedaId(vPropuestaBB.getClMonedaId());
                 propBeneficiarioBeneficioDTO.setMoneda(vPropuestaBB.getMoneda());
                 propBeneficiarioBeneficioDTO.setTipoPlanId(vPropuestaBB.getTipoPlanId());
                 propBeneficiarioBeneficioDTO.setClavePlan(vPropuestaBB.getClavePlan());
                 propBeneficiarioBeneficioDTO.setDescripcionPlan(vPropuestaBB.getDescripcionPlan());
                 propBeneficiarioBeneficioDTO.setCosto(vPropuestaBB.getCosto());
                 propBeneficiarioBeneficioDTO.setGastoAdmon(vPropuestaBB.getGastoAdmon());
                 propBeneficiarioBeneficioDTO.setTotal(vPropuestaBB.getTotal());
                 propBeneficiarioBeneficioDTO.setMensual(vPropuestaBB.getMensual());
                 propBeneficiarioBeneficioDTO.setAnual(vPropuestaBB.getAnual());
                
                propBeneficiarioBeneficioDTO.setBeneficiarios(new ArrayList<>());
                vPropuestaBBList.sort(Comparator.comparing(VpropuestaBeneficiariosBeneficios::getBeneficiarioid));
                // Collections.sort(vPropuestaBBList, (x,y) ->
                // (Integer.parseInt(x.getBeneficiarioid())).compareTo(y.getBeneficiarioid()));
                int beneficiarioidInicial = 0;
                int beneficiarioActual = 0;
                List<BeneficioSimpleDTO> beneficioSimpleDTOActualizado;
                for (VpropuestaBeneficiariosBeneficios propuesta : vPropuestaBBList) {
                    beneficiarioidInicial = propuesta.getBeneficiarioid();
                    System.out.println("Beneficiario:"+ propuesta.getTipobeneficiario());
                    if (beneficiarioActual != beneficiarioidInicial) {

                        if (beneficiarioActual > 0) {
                            propBeneficiarioBeneficioDTO.getBeneficiarios().add(beneficiarioBeneficiosDTO);
                        }
                        beneficiarioActual = beneficiarioidInicial;
                        beneficioSimpleDTOActualizado =  new ArrayList<>();
                        for (Cbeneficios beneficio : beneficiosList) {
                            if (beneficio.getCltipobeneficio().getCatalogodetalleid() == 66) {
                                beneficioSimpleDTO = new BeneficioSimpleDTO();
                                beneficioSimpleDTO.setBeneficioId(beneficio.getBeneficioid());
                                beneficioSimpleDTO.setTitulobeneficio(beneficio.getTitulobeneficio());
                                beneficioSimpleDTO.setActivo(false);
                                System.out.println("Beneficio :"+beneficioSimpleDTO.getBeneficioId()+" - "+beneficioSimpleDTO.getTitulobeneficio()+" - "+beneficioSimpleDTO.isActivo());
                                beneficioSimpleDTOActualizado.add(beneficioSimpleDTO);
                                
                            }
                        }
                        //beneficioSimpleDTOActualizado.addAll(beneficioLista);
                        beneficiarioBeneficiosDTO = new BeneficiarioBeneficiosDTO();
                      
                        beneficiarioBeneficiosDTO.setBeneficiarioid(propuesta.getBeneficiarioid());
                        beneficiarioBeneficiosDTO.setImagenactivo(propuesta.getImagenactivo());
                        beneficiarioBeneficiosDTO.setImageninactivo(propuesta.getImageninactivo());
                        beneficiarioBeneficiosDTO.setImagendefault(propuesta.getImagendefault());
                        beneficiarioBeneficiosDTO.setEsseleccionado(propuesta.getEsseleccionado());
                        beneficiarioBeneficiosDTO.setTipobeneficiario(propuesta.getTipobeneficiario());
                        beneficiarioBeneficiosDTO.setTipobeneficiarioid(propuesta.getTipobeneficiarioid());
                        beneficiarioBeneficiosDTO.setBeneficioSimpleDTO(beneficioSimpleDTOActualizado);
                      
                        
                    }
                    for (BeneficioSimpleDTO beneficio : beneficiarioBeneficiosDTO.getBeneficioSimpleDTO()) {
                         if (propuesta.getBeneficioid() == beneficio.getBeneficioId()) {
                            beneficio.setActivo(true);
                
                        }
                    }
                }
                propBeneficiarioBeneficioDTO.getBeneficiarios().add(beneficiarioBeneficiosDTO);
            }
            return propBeneficiarioBeneficioDTO;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    public GetPropuestaResponseDTO getPropuestaByCurp(String curp) {
        try {
            GetPropuestaResponseDTO propuestaResponseDTO;
            List<VpropuestaBeneficiariosBeneficios> vPropuestaBBList = vpropuestaBeneficiariosBeneficiosRepository
                    .findByCurp(curp);
            if (null == vPropuestaBBList || vPropuestaBBList.isEmpty()) {

                propuestaResponseDTO = getPropuestaDefault();
                propuestaResponseDTO.setCurp(curp);

                return propuestaResponseDTO;
            }

            VpropuestaBeneficiariosBeneficios vPropuestaBB = vPropuestaBBList.get(0);
            Integer propuestaId = vPropuestaBB.getPropuestaid();
            propuestaResponseDTO = GetPropuestaResponseDTO.builder().propuestaid(vPropuestaBB.getPropuestaid())
                    .curp(vPropuestaBB.getCurp()).estatuspropuesta(vPropuestaBB.getEstatuspropuesta())
                    .clestatuspropuestaid(vPropuestaBB.getClestatuspropuestaid()).flag(vPropuestaBB.getFlag())
                    .beneficios(getBeneficiosBeneficiarios(propuestaId)).cuestionario(getCuestionario(propuestaId))
                    .build();

            for (VpropuestaBeneficiariosBeneficios propuesta : vPropuestaBBList) {
                if (!propuestaResponseDTO.getBeneficios().stream()
                        .filter(b -> b.getBeneficioid().equals(propuesta.getBeneficioid())).findAny().isPresent()) {
                    propuestaResponseDTO.getBeneficios()
                            .add(new ModelMapper().map(propuesta, BeneficiosBeneficiariosResponseDTO.class));
                }
                BeneficiosBeneficiariosResponseDTO beneficiosBeneficiariosDTO = propuestaResponseDTO.getBeneficios()
                        .stream().filter(b -> b.getBeneficioid().equals(propuesta.getBeneficioid())).findAny().get();
                if (beneficiosBeneficiariosDTO.getBeneficioid() == propuesta.getBeneficioid())
                    beneficiosBeneficiariosDTO.getBeneficiosbeneficiarios()
                            .add(new ModelMapper().map(propuesta, BeneficiosBeneficiariosDTO.class));
            }

            return propuestaResponseDTO;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    private List<BeneficiosBeneficiariosResponseDTO> getBeneficiosBeneficiarios(Integer propuestaId) {
        var vPRopuestaBeneficioList = vpropuestaBeneficiariosBeneficiosRepository
                .getPropuestaBeneficioByPropuestaid(propuestaId);
        List<BeneficiosBeneficiariosResponseDTO> beneficiosBeneficiarioList = new ArrayList<>();
        for (PropuestaNativeQuery propuesta : vPRopuestaBeneficioList) {
            Integer beneficioId = propuesta.getBeneficioid();
            if (!beneficiosBeneficiarioList.stream().filter(b -> b.getBeneficioid() == beneficioId).findAny()
                    .isPresent()) {
                beneficiosBeneficiarioList
                        .add(new ModelMapper().map(propuesta, BeneficiosBeneficiariosResponseDTO.class));
            }
            BeneficiosBeneficiariosResponseDTO beneficiosBeneficiariosDTO = beneficiosBeneficiarioList.stream()
                    .filter(b -> b.getBeneficioid().equals(beneficioId)).findAny().get();
            beneficiosBeneficiariosDTO.getBeneficiosbeneficiarios()
                    .add(new ModelMapper().map(propuesta, BeneficiosBeneficiariosDTO.class));
        }
        return beneficiosBeneficiarioList;
    }

    @SuppressWarnings("unchecked")
    private List<PropuestaCuestionarioDTO> getCuestionario(Integer propuestaId) {
        ModelMapper mapper = new ModelMapper();
        List<VpropuestaCuestionario> vCuestionarioList = vpropuestaCuestionarioRepository.findByPropuestaid(propuestaId);
        List<PropuestaCuestionarioDTO> cuestionario = vCuestionarioList.stream().map(c -> mapper.map(c, PropuestaCuestionarioDTO.class))
                .collect(Collectors.toList());
        return cuestionario;
    }

    private List<PropuestaCuestionarioDTO> getCuestionario() {

        Optional<CuestionarioEntity> vCuestionarioList = questionSheetRepository.findById(1);
        // var cuestionario = vCuestionarioList.get(0).getPreguntas();
        List<PropuestaCuestionarioDTO> cuestionario = new ArrayList<>();
        PropuestaCuestionarioDTO propuestaCuestionarioDTO;
        for (PreguntaEntity pregunta : vCuestionarioList.get().getPreguntas()) {
            propuestaCuestionarioDTO = new PropuestaCuestionarioDTO();
            propuestaCuestionarioDTO.setPropuestaid(0);
            propuestaCuestionarioDTO.setBeneficiarioid(0);
            propuestaCuestionarioDTO.setPreguntaid(pregunta.getPreguntaId());
            propuestaCuestionarioDTO.setDescripcionpregunta(pregunta.getDescripcionPregunta());
            propuestaCuestionarioDTO.setRespuestaid(0);
            propuestaCuestionarioDTO.setRespuesta("");
            cuestionario.add(propuestaCuestionarioDTO);
        }

        return cuestionario;
    }

    private GetPropuestaResponseDTO getPropuestaDefault() {
        GetPropuestaResponseDTO propuestaResponseDTO = new GetPropuestaResponseDTO();

        List<VbeneficiosBeneficiarios> vbeneficiosBeneficiariosList = vbeneficiosBeneficiariosRepository.findAll();
        List<BeneficiosBeneficiariosResponseDTO> beneficiosBeneficiarioList = new ArrayList<>();
        for (VbeneficiosBeneficiarios beneficioBeneficiario : vbeneficiosBeneficiariosList) {
            Integer beneficioId = beneficioBeneficiario.getBeneficioid();
            if (!beneficiosBeneficiarioList.stream().filter(b -> b.getBeneficioid().equals(beneficioId)).findAny()
                    .isPresent()) {
                beneficiosBeneficiarioList
                        .add(new ModelMapper().map(beneficioBeneficiario, BeneficiosBeneficiariosResponseDTO.class));
            }
            BeneficiosBeneficiariosResponseDTO beneficiosBeneficiariosDTO = beneficiosBeneficiarioList.stream()
                    .filter(b -> b.getBeneficioid().equals(beneficioId)).findAny().get();
            beneficiosBeneficiariosDTO.getBeneficiosbeneficiarios()
                    .add(new ModelMapper().map(beneficioBeneficiario, BeneficiosBeneficiariosDTO.class));
        }
        propuestaResponseDTO.setBeneficios(beneficiosBeneficiarioList);
        propuestaResponseDTO.setPropuestaid(0);
        propuestaResponseDTO.setEstatuspropuesta("0");
        propuestaResponseDTO.setClestatuspropuestaid(0);
        propuestaResponseDTO.setFlag(0);
        propuestaResponseDTO.setCuestionario(getCuestionario());

        return propuestaResponseDTO;
    }
}
