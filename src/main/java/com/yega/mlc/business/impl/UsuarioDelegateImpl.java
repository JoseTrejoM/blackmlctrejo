package com.yega.mlc.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yega.mlc.business.UsuarioDelegate;
import com.yega.mlc.constants.EnumContactoPersona;
import com.yega.mlc.constants.SystemConstants;
import com.yega.mlc.dto.ContactoPersonaDTO;
import com.yega.mlc.dto.DataUsuarioSysDTO;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.PersonaDTO;
import com.yega.mlc.dto.PersonaFisicaDTO;
import com.yega.mlc.dto.PersonaReqDTO;
import com.yega.mlc.dto.PersonaResDTO;
import com.yega.mlc.dto.UsuarioDTO;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.service.ContactoPersonaService;
import com.yega.mlc.service.PersonaFisicaService;
import com.yega.mlc.service.PersonaService;
import com.yega.mlc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component("usuarioDelegateCore")
public class UsuarioDelegateImpl extends UsuarioDelegate {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private PersonaFisicaService personaFisicaService;

    @Autowired
    private UserService userService;

    @Autowired
    private ContactoPersonaService contactoPersonaService;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public PersonaResDTO crear(PersonaReqDTO persona) throws ServiceException {
        var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
        var esapplogin = Boolean.parseBoolean(byapplogin);
        var hoy = new Date();
        var dataUserSys = persona.getDataUserSys();

        var personaDto = new PersonaDTO(null, dataUserSys.getTipoPersonaId(), hoy, null, dataUserSys.getRfc(), true);
        var personaNew = personaService.crear(personaDto);

        var personaFisicaDto = new PersonaFisicaDTO(personaNew.getPersonaId(), persona.getNombre(),
                persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getSexo(),
                persona.getFechaNacimiento(), hoy, dataUserSys.getCurp(), dataUserSys.getNss());
        var personaFisNew = personaFisicaService.crear(personaFisicaDto);

        UsuarioDTO userNew = null;
        if (!esapplogin && StringUtils.hasText(persona.getEmail())) {
            var userDto = new UsuarioDTO(null, dataUserSys.getRolId(), dataUserSys.getTipoUsuarioId(),
                    dataUserSys.getEstatusUsuarioId(), personaFisNew.getPersonaFisicaId(), persona.getEmail(),
                    dataUserSys.getIniciales(), dataUserSys.getContrasena(), dataUserSys.getPuesto(),
                    dataUserSys.getArea(), 0, hoy, hoy, dataUserSys.getFoto());
            userNew = userService.crear(userDto);
        }

        var listaContactoPersona = crearContactos(persona, personaNew, dataUserSys);
        return new PersonaResDTO(personaNew, personaFisNew, userNew,
                CollectionUtils.isEmpty(listaContactoPersona) ? null : listaContactoPersona);
    }

    private List<ContactoPersonaDTO> crearContactos(PersonaReqDTO personaReq, PersonaDTO personaDTO,
            DataUsuarioSysDTO dataUserSys) {
        try {
            var hoy = new Date();

            var listaContactoPersona = new ArrayList<ContactoPersonaDTO>();
            if (StringUtils.hasText(personaReq.getEmail())) {
                var contacto = new ContactoPersonaDTO(null, personaDTO.getPersonaId(),
                        EnumContactoPersona.CORREO.getValue(), personaReq.getEmail(), true, hoy,
                        SystemConstants.USUARIO_SISTEMA, hoy, null, true);
                var contactoNew = contactoPersonaService.crear(contacto);
                listaContactoPersona.add(contactoNew);
            }

            if (StringUtils.hasText(personaReq.getTelefono())) {
                var contacto = new ContactoPersonaDTO(null, personaDTO.getPersonaId(),
                        EnumContactoPersona.TELEFONO.getValue(), personaReq.getTelefono(), true, hoy,
                        SystemConstants.USUARIO_SISTEMA, hoy, null, true);
                var contactoNew = contactoPersonaService.crear(contacto);
                listaContactoPersona.add(contactoNew);
            }
            return listaContactoPersona;
        } catch (Exception e) {
            var message = String.format("Cann't create contact %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    @Override
    public PersonaResDTO getById(Integer personaId) throws ServiceException {
        try {
            var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
            var esapplogin = byapplogin != null && Boolean.parseBoolean(byapplogin);

            var persona = personaService.getById(personaId);
            var personaFis = personaFisicaService.getById(personaId);
            var user = esapplogin ? null : userService.getUserByPersonaFisicaId(personaId);
            var listContacto = contactoPersonaService.getAllByPersonaId(personaId);
            return new PersonaResDTO(persona, personaFis, user, listContacto);
        } catch (Exception e) {
            var message = String.format("Cann't get person by id %d , %s", personaId, e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }
    
    

    @Override
    public List<PersonaResDTO> getAll() throws ServiceException {
        try {
            var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
            var esapplogin = byapplogin != null && Boolean.parseBoolean(byapplogin);

            var listPersonas = new ArrayList<PersonaResDTO>();
            var personasFisicas = personaFisicaService.getAll();

            var usuarios = esapplogin ? null : userService.getAll();
            personaService.getAll().forEach(persona -> {
                var personaFis = personasFisicas.stream()
                        .filter(pf -> pf.getPersonaFisicaId() == persona.getPersonaId()).findFirst().get();
                var user = CollectionUtils.isEmpty(usuarios) ? null
                        : usuarios.stream().filter(us -> us.getPersonaFisicaId() == persona.getPersonaId()).findFirst()
                                .get();
                var listContacto = contactoPersonaService.getAllByPersonaId(persona.getPersonaId());
                var personaRes = new PersonaResDTO(persona, personaFis, user, listContacto);
                listPersonas.add(personaRes);
            });

            return listPersonas;
        } catch (Exception e) {
            var message = String.format("Cann't get all data person %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PersonaResDTO actualizar(PersonaReqDTO persona) throws ServiceException {
        var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
        var esapplogin = Boolean.parseBoolean(byapplogin);

        var hoy = new Date();
        var dataUserSys = persona.getDataUserSys();

        var personaCompleto = getById(persona.getPersonaId());
        var personaDB = personaCompleto.getPersona();
        personaDB.setRfc(dataUserSys.getRfc());
        var personaUp = personaService.actualizar(personaDB);

        var personaFiscicaDB = personaCompleto.getPersonaFisica();
        var personaFisicaDto = new PersonaFisicaDTO(personaFiscicaDB.getPersonaFisicaId(), persona.getNombre(),
                persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getSexo(),
                persona.getFechaNacimiento(), personaFiscicaDB.getFechaAlta(), dataUserSys.getCurp(),
                dataUserSys.getNss());
        var personaFiscicaUp = personaFisicaService.actualizar(personaFisicaDto);

        var usuarioDB = personaCompleto.getUsuario();
        UsuarioDTO usuarioUp = null;
        if (!esapplogin && usuarioDB != null) {
            var userDto = new UsuarioDTO(usuarioDB.getUsuarioId(), dataUserSys.getRolId(),
                    dataUserSys.getTipoUsuarioId(), dataUserSys.getEstatusUsuarioId(),
                    personaFiscicaDB.getPersonaFisicaId(), persona.getEmail(), dataUserSys.getIniciales(),
                    dataUserSys.getContrasena(), dataUserSys.getPuesto(), dataUserSys.getArea(), 0,
                    usuarioDB.getFechaAlta(), hoy, dataUserSys.getFoto());
            usuarioUp = userService.actualizar(userDto);
        }

        final List<ContactoPersonaDTO> listaContactoUp = new ArrayList<ContactoPersonaDTO>();
        var listContacto = contactoPersonaService.getAllByPersonaId(persona.getPersonaId());
        if (!CollectionUtils.isEmpty(listContacto)) {
            listContacto.forEach(contacto -> {
                if (contacto.getTipoContactoId() == EnumContactoPersona.CORREO.getValue()) {
                    contacto.setContacto(persona.getEmail());
                } else if (contacto.getTipoContactoId() == EnumContactoPersona.TELEFONO.getValue()) {
                    contacto.setContacto(persona.getTelefono());
                }
                contacto.setFechaModificacion(hoy);
                var contactoUp = contactoPersonaService.actualizar(contacto);
                listaContactoUp.add(contactoUp);
            });
        } else {
            var lista = crearContactos(persona, personaDB, dataUserSys);
            listaContactoUp.addAll(lista);
        }
        return new PersonaResDTO(personaUp, personaFiscicaUp, usuarioUp,
                CollectionUtils.isEmpty(listaContactoUp) ? null : listaContactoUp);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public PersonaResDTO eliminar(Integer personaId) throws ServiceException {
        var byapplogin = configServiceMap.get(SystemConstants.BY_APP_LOGIN);
        var esapplogin = Boolean.parseBoolean(byapplogin);

        UsuarioDTO userDel = null;
        if (!esapplogin) {
            var user = userService.getUserByPersonaFisicaId(personaId);
            userDel = userService.eliminar(user.getUsuarioId());
        }
        var listContacto = contactoPersonaService.eliminarByPersonaId(personaId);

        var personaFisDel = personaFisicaService.eliminar(personaId);
        var personaDel = personaService.eliminar(personaId);

        return new PersonaResDTO(personaDel, personaFisDel, userDel, listContacto);
    }

}
