package com.yega.mlc.business.impl;

import java.util.HashMap;
import java.util.Map;

import com.yega.mlc.business.UsuarioDelegate;
import com.yega.mlc.constants.SystemConstants;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.PersonaReqDTO;
import com.yega.mlc.dto.PersonaResDTO;
import com.yega.mlc.dto.PropuestaBeneficiariosDTO;
import com.yega.mlc.dto.RegistroDTO;
import com.yega.mlc.dto.RegistroResponseDTO;
import com.yega.mlc.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component("registerDelegateByAppKey")
public class RegisterDelegateByAppKeyImpl extends RegisterDelegateImpl {

    @Autowired
    @Qualifier("usuarioDelegateByAppKey")
    private UsuarioDelegate usuarioDelegate;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public RegistroResponseDTO createRegister(RegistroDTO registro) {
        var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);

        Map<Integer, Object> datosBeneficiarios = null;
        if (Boolean.parseBoolean(byapplogin) && registro.getPropuestaId() != null) {
            datosBeneficiarios = getDatosBeneficiario(registro);
        }

        var reg = super.createRegister(registro);

        if (Boolean.parseBoolean(byapplogin) && registro.getPropuestaId() != null && datosBeneficiarios != null) {
            restaurarDatosBeneficiario(registro, datosBeneficiarios, reg);
        }
        return reg;
    }

    private Map<Integer, Object> getDatosBeneficiario(RegistroDTO registro) {
        try {
            var datosBeneficiarios = new HashMap<Integer, Object>();
            var info = proposalService.getAllDataById(registro.getPropuestaId());
            info.getBeneficiario().forEach(beneficiario -> {
                if (beneficiario.getPersonaId() != null) {
                    datosBeneficiarios.put(beneficiario.getTipoBeneficiarioId(), beneficiario);
                }
            });

            return datosBeneficiarios;
        } catch (Exception e) {
            var message = String.format("Cann't get data beneficiaty %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    private void eliminarDatosBeneficiario(RegistroDTO registro) {
        try {
            var info = proposalService.getAllDataById(registro.getPropuestaId());
            info.getBeneficiario().forEach(beneficiario -> {
                if (beneficiario.getPersonaId() != null) {
                    usuarioDelegate.setConfig(configServiceMap).eliminar(beneficiario.getPersonaId());
                }
            });
        } catch (Exception e) {
            var message = String.format("Cann't delete data beneficiaty %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    private void restaurarDatosBeneficiario(RegistroDTO registro, Map<Integer, Object> datosBeneficiarios,
            RegistroResponseDTO registroResponse) {
        try {
            var mapPersona = new HashMap<Integer, PersonaResDTO>();
            registro.getBeneficiarios().forEach(tipoBeneficiarioId -> {
                var benef = (PropuestaBeneficiariosDTO.BeneficiarioV) datosBeneficiarios.get(tipoBeneficiarioId);
                if (benef != null) {
                    var personaReq = new PersonaReqDTO(registro.getPropuestaId(), null, tipoBeneficiarioId,
                            benef.getNombre(), benef.getApellidoPaterno(), benef.getApellidoMaterno(),
                            benef.getTelefono(), benef.getCorreo(), benef.getFechaNacimiento(), benef.getSexoId(), null,
                            null, null, null, null);
                    var persona = usuarioDelegate.setConfig(configServiceMap).crear(personaReq);
                    mapPersona.put(tipoBeneficiarioId, persona);
                }
            });

            registroResponse.getBeneficiarios().forEach(beneficiario -> {
                var persona = mapPersona.get(beneficiario.getTipoBeneficiarioId());
                if (persona != null) {
                    beneficiario.setPersonaId(persona.getPersona().getPersonaId());
                    beneficiaryService.actualizar(beneficiario);
                }
            });
        } catch (Exception e) {
            var message = String.format("Cann't restore data beneficiaty %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    @Override
    protected void limpiarRegistro(RegistroDTO registro) {
        var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
        if (Boolean.parseBoolean(byapplogin) && registro.getPropuestaId() != null) {
            eliminarDatosBeneficiario(registro);
        }
        super.limpiarRegistro(registro);
    }
}
