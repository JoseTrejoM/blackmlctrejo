package com.yega.mlc.business.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.yega.mlc.constants.EnumEstatusUsuario;
import com.yega.mlc.constants.EnumFieldQuery;
import com.yega.mlc.constants.EnumRolUsuario;
import com.yega.mlc.constants.EnumTipoBeneficiario;
import com.yega.mlc.constants.EnumTipoPersona;
import com.yega.mlc.constants.EnumTipoUsuario;
import com.yega.mlc.constants.SystemConstants;
import com.yega.mlc.dto.BeneficiarioDTO;
import com.yega.mlc.dto.DataUsuarioSysDTO;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.EstadoOrigenDTO;
import com.yega.mlc.dto.EstadoResidenciaDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PersonaReqDTO;
import com.yega.mlc.dto.PersonaResDTO;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.service.BeneficiaryService;
import com.yega.mlc.service.EstadoOrigenService;
import com.yega.mlc.service.EstadoResidenciaService;
import com.yega.mlc.service.ProposalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("usuarioDelegateByAppKey")
public class UsuarioDelegateByAppKeyImpl extends UsuarioDelegateImpl {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private EstadoOrigenService estadoOrigenService;

    @Autowired
    private EstadoResidenciaService estadoResidenciaService;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public PersonaResDTO crear(PersonaReqDTO persona) throws ServiceException {
        var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
        if (byapplogin != null && Boolean.parseBoolean(byapplogin)) {
            getDataUserSys(persona);
        }

        var personaNew = super.crear(persona);
        if (byapplogin != null && Boolean.parseBoolean(byapplogin)) {
            guardaDatos(persona, personaNew);
        }
        return personaNew;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PersonaResDTO actualizar(PersonaReqDTO persona) throws ServiceException {
        var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
        if (byapplogin != null && Boolean.parseBoolean(byapplogin)) {
            getDataUserSys(persona);
        }

        var personaUp = super.actualizar(persona);
        if (byapplogin != null && Boolean.parseBoolean(byapplogin)) {
            actualizarEstados(persona);
        }
        return personaUp;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public PersonaResDTO eliminar(Integer personaId) throws ServiceException {
        var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
        if (Boolean.parseBoolean(byapplogin)) {
            eliminarEstados(personaId);
        }
        return super.eliminar(personaId);
    }

    private DataUsuarioSysDTO getDataUserSys(PersonaReqDTO persona) {
        if (persona.getDataUserSys() == null) {
            persona.setDataUserSys(new DataUsuarioSysDTO());
        }
        var dataUserSys = persona.getDataUserSys();
        var propuesta = proposalService.getById(persona.getPropuestaId());
        var esTitular = EnumTipoBeneficiario.TITULAR.getValue() == persona.getTipoBeneficiarioId();

        var estatusUsuario = EnumEstatusUsuario.BLOQUEADO.getValue();
        if (esTitular) {
            estatusUsuario = EnumEstatusUsuario.ACTIVO.getValue();
            dataUserSys.setCurp(propuesta.getCurp());
        }
        dataUserSys.setTipoPersonaId(EnumTipoPersona.FISICA.getValue());
        dataUserSys.setContrasena(SystemConstants.PASSWORD_USUARIO_ALTA_DEFAULT);
        dataUserSys.setArea(EnumRolUsuario.CLIENTE.name());
        dataUserSys.setEstatusUsuarioId(estatusUsuario);
        dataUserSys.setRolId(EnumRolUsuario.CLIENTE.getValue());
        dataUserSys.setTipoUsuarioId(EnumTipoUsuario.EXTERNO.getValue());

        return dataUserSys;
    }

    private void guardaDatos(PersonaReqDTO persona, PersonaResDTO personaNew) {
        try {
            var beneficiario = getBeneficiario(persona.getPropuestaId(), persona.getTipoBeneficiarioId());
            actualizarBeneficiario(beneficiario, personaNew.getPersona().getPersonaId());

            var esTitular = EnumTipoBeneficiario.TITULAR.getValue() == persona.getTipoBeneficiarioId();
            var esPareja = EnumTipoBeneficiario.PAREJA.getValue() == persona.getTipoBeneficiarioId();
            if (esTitular || esPareja) {
                if (persona.getEstadoOrigenId() != null) {
                    guardarEstado(persona.getEstadoOrigenId(), beneficiario.getBeneficiarioId(), true);
                }
                if (esTitular && persona.getEstadoResidenciaId() != null) {
                    guardarEstado(persona.getEstadoResidenciaId(), beneficiario.getBeneficiarioId(), false);
                }
            }
        } catch (Exception e) {
            var message = String.format("Cann't save data %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    private void actualizarEstados(PersonaReqDTO persona) {
        try {
            var esTitular = EnumTipoBeneficiario.TITULAR.getValue() == persona.getTipoBeneficiarioId();
            var esPareja = EnumTipoBeneficiario.PAREJA.getValue() == persona.getTipoBeneficiarioId();
            if (esTitular || esPareja) {
                var beneficiario = getBeneficiario(persona.getPropuestaId(), persona.getTipoBeneficiarioId());
                var estadoOrigen = getEstadoOrigen(beneficiario.getBeneficiarioId());
                if (persona.getEstadoOrigenId() != null) {
                    if (estadoOrigen != null) {
                        estadoOrigen.setEstadoId(persona.getEstadoOrigenId());
                        estadoOrigenService.actualizar(estadoOrigen);
                    } else {
                        guardarEstado(persona.getEstadoOrigenId(), beneficiario.getBeneficiarioId(), true);
                    }
                }

                if (esTitular) {
                    var estadoResidencia = getEstadoResidencia(beneficiario.getBeneficiarioId());
                    if (persona.getEstadoResidenciaId() != null) {
                        if (estadoResidencia != null) {
                            estadoResidencia.setEstadoId(persona.getEstadoResidenciaId());
                            estadoResidenciaService.actualizar(estadoResidencia);
                        } else {
                            guardarEstado(persona.getEstadoResidenciaId(), beneficiario.getBeneficiarioId(), false);
                        }
                    }
                }
            }
        } catch (Exception e) {
            var message = String.format("Cann't update state %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    private void eliminarEstados(Integer personaId) {
        try {
            var beneficiario = getBeneficiario(personaId);
            actualizarBeneficiario(beneficiario, null);
            var esTitular = EnumTipoBeneficiario.TITULAR.getValue() == beneficiario.getTipoBeneficiarioId();
            var esPareja = EnumTipoBeneficiario.PAREJA.getValue() == beneficiario.getTipoBeneficiarioId();
            if (esTitular || esPareja) {
                var estadoOrigen = getEstadoOrigen(beneficiario.getBeneficiarioId());
                if (estadoOrigen != null) {
                    estadoOrigenService.eliminar(estadoOrigen.getEstadoOrigenId());
                }

                if (esTitular) {
                    var estadoResidencia = getEstadoResidencia(beneficiario.getBeneficiarioId());
                    if (estadoResidencia != null) {
                        estadoResidenciaService.eliminar(estadoResidencia.getEstadoResidenciaId());
                    }
                }
            }
        } catch (Exception e) {
            var message = String.format("Cann't delete state %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    private void actualizarBeneficiario(BeneficiarioDTO beneficiario, Integer personaId) {
        try {
            beneficiario.setPersonaId(personaId);
            beneficiaryService.actualizar(beneficiario);
        } catch (Exception e) {
            var message = String.format("Cann't update beneficiaty %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    private BeneficiarioDTO getBeneficiario(Integer propuestaId, Integer tipoBeneficiarioId) {
        Set<FieldQueryDTO> fields = new HashSet<FieldQueryDTO>();
        fields.add(new FieldQueryDTO("propuestaId", propuestaId, EnumFieldQuery.EQUALS));
        fields.add(new FieldQueryDTO("tipoBeneficiarioId", tipoBeneficiarioId, EnumFieldQuery.EQUALS));
        var listBeneficiarios = beneficiaryService.getResultSet(fields);

        var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                String.format("Beneficay not exists %d with proposal %d", propuestaId, tipoBeneficiarioId));

        long count = listBeneficiarios.stream().count();
        Stream<BeneficiarioDTO> stream = listBeneficiarios.stream();
        return stream.skip(count - 1).findFirst()
                .orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
    }

    private BeneficiarioDTO getBeneficiario(Integer personaId) {
        Set<FieldQueryDTO> fields = new HashSet<FieldQueryDTO>();
        fields.add(new FieldQueryDTO("personaId", personaId, EnumFieldQuery.EQUALS));
        var listBeneficiarios = beneficiaryService.getResultSet(fields);

        var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("Beneficay not exists %d", personaId));

        long count = listBeneficiarios.stream().count();
        Stream<BeneficiarioDTO> stream = listBeneficiarios.stream();
        return stream.skip(count - 1).findFirst()
                .orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
    }

    private EstadoOrigenDTO getEstadoOrigen(Integer beneficiarioId) {
        Set<FieldQueryDTO> fields = new HashSet<FieldQueryDTO>();
        fields.add(new FieldQueryDTO("beneficiarioId", beneficiarioId, EnumFieldQuery.EQUALS));
        fields.add(new FieldQueryDTO("activo", true, EnumFieldQuery.EQUALS));
        var listBeneficiarios = estadoOrigenService.getResultSet(fields);
        return listBeneficiarios.stream().findFirst().orElse(null);
    }

    private EstadoResidenciaDTO getEstadoResidencia(Integer beneficiarioId) {
        Set<FieldQueryDTO> fields = new HashSet<FieldQueryDTO>();
        fields.add(new FieldQueryDTO("beneficiarioId", beneficiarioId, EnumFieldQuery.EQUALS));
        fields.add(new FieldQueryDTO("activo", true, EnumFieldQuery.EQUALS));
        var listBeneficiarios = estadoResidenciaService.getResultSet(fields);
        return listBeneficiarios.stream().findFirst().orElse(null);

    }

    private void guardarEstado(Integer estadoId, Integer beneficiarioId, boolean origen) {
        try {
            var hoy = new Date();
            if (origen) {
                var estado = new EstadoOrigenDTO(null, estadoId, beneficiarioId, hoy, SystemConstants.USUARIO_SISTEMA,
                        hoy, null, true);
                estadoOrigenService.crear(estado);
            } else {
                var estado = new EstadoResidenciaDTO(null, estadoId, beneficiarioId, hoy,
                        SystemConstants.USUARIO_SISTEMA, hoy, null, true);
                estadoResidenciaService.crear(estado);
            }
        } catch (Exception e) {
            var message = String.format("Cann't save state %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }
}
