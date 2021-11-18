/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.common.Decrypt;
import com.yega.mlc.constants.EnumEstatusUsuario;
import com.yega.mlc.constants.EnumRolUsuario;
import com.yega.mlc.constants.EnumTipoUsuario;
import com.yega.mlc.constants.SystemConstants;
import com.yega.mlc.dto.ContactoPersonaDTO;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PersonaResDTO;
import com.yega.mlc.dto.UsuarioDTO;
import com.yega.mlc.entity.UsuarioEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.UserRepository;
import com.yega.mlc.service.UserService;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author greser69
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UsuarioDTO crear(UsuarioDTO user) throws ServiceException {
        try {
            Optional<UsuarioEntity> opUsuario = userRepository.findByUsuario(user.getUsuario());
            if (opUsuario.isPresent()) {
                if (user.getPersonaFisicaId() == opUsuario.get().getPersonaFisicaId()) {
                    user.setEstatusUsuarioId(11);
                    user.setIntentos(0);
                    user.setArea(opUsuario.get().getArea());
                    user.setFoto(opUsuario.get().getFoto());
                    user.setIniciales(opUsuario.get().getIniciales());
                    user.setFechaAlta(opUsuario.get().getFechaAlta());
                    user.setUsuarioId(opUsuario.get().getUsuarioId());
                } else {
                    var message = String.format("Usuario existe %s", user.getUsuario());
                    var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
                    throw new ServiceException(errorCode, errorCode.getMessage());

                }
            }

            String passBCrypt = generatePasswordToSave(user);
            user.setContrasena(passBCrypt);

            var userEntity = mapper(user, UsuarioEntity.class);
            var userNew = userRepository.save(userEntity);
            return mapper(userNew, UsuarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    public UsuarioDTO crearUsuario(PersonaResDTO persona) {
        UsuarioEntity usuario = new UsuarioEntity();

        usuario.setContrasena(SystemConstants.PASSWORD_USUARIO_ALTA_DEFAULT);
        usuario.setArea(EnumRolUsuario.CLIENTE.name());
        usuario.setEstatusUsuarioId(EnumEstatusUsuario.ACTIVO.getValue());
        usuario.setRolId(EnumRolUsuario.CLIENTE.getValue());
        usuario.setArea("Cliente");
        usuario.setIniciales("");
        usuario.setPuesto("Cliente");
        usuario.setTipoUsuarioId(EnumTipoUsuario.EXTERNO.getValue());
        String email = "";
        Date hoy = new Date();
        for (ContactoPersonaDTO contacto : persona.getContactos()) {
            if (contacto.getPrincipal() && contacto.getActivo() && contacto.getTipoContactoId() == 47) {
                email = contacto.getContacto();
                break;
            }
        }
        UsuarioDTO userDto = new UsuarioDTO(null, usuario.getRolId(), usuario.getTipoUsuarioId(),
                usuario.getEstatusUsuarioId(), persona.getPersonaFisica().getPersonaFisicaId(),
                email, usuario.getIniciales(), usuario.getContrasena(), usuario.getPuesto(),
                usuario.getArea(), 0, hoy, hoy, usuario.getFoto());
        userDto = crear(userDto);

        return userDto;
    }

    @Override
    public UsuarioDTO getById(Integer idUsuario) throws ServiceException {
        try {
            Optional<UsuarioEntity> opUser = userRepository.findById(idUsuario);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("User not found with id %d", idUsuario));
            var userEntity = opUser.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(userEntity, UsuarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public UsuarioDTO getUserByPersonaFisicaId(Integer personaFisicaId) throws ServiceException {
        try {
            Optional<UsuarioEntity> opUser = userRepository.findByPersonaFisicaId(personaFisicaId);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("User not found with personaFisica id %d", personaFisicaId));
            var userEntity = opUser.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(userEntity, UsuarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<UsuarioDTO> getAll() throws ServiceException {
        try {
            var list = userRepository.findAll();
            list.sort((a, b) -> a.getUsuario().compareTo(b.getUsuario()));
            return list.stream().map(element -> mapper(element, UsuarioDTO.class)).collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public UsuarioDTO actualizar(UsuarioDTO user) throws ServiceException {
        var userDTO = getById(user.getUsuarioId());
        try {
            validateIfCanUpdate(user, userDTO);
            String passBCrypt = !StringUtils.hasText(user.getContrasena()) ? generatePasswordToSave(user) : userDTO.getContrasena();
            user.setContrasena(passBCrypt);

            var userEntity = mapper(user, UsuarioEntity.class);
            var userUpdated = userRepository.save(userEntity);
            return mapper(userUpdated, UsuarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    private void validateIfCanUpdate(UsuarioDTO userToUpdate, UsuarioDTO userById) {
        UsuarioDTO userByUsuario = null;
        boolean canUpdate = false;
        try {
            userByUsuario = getUserByUsuario(userToUpdate.getUsuario());
            canUpdate = userById.getUsuarioId() == userByUsuario.getUsuarioId();
        } catch (Exception e) {
            canUpdate = true;
        }

        if (!canUpdate) {
            var message = String.format("User exists %s", userToUpdate.getUsuario());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    private String generatePasswordToSave(UsuarioDTO user) {
        var passDecrypt = Decrypt.decrypt(user.getContrasena());
        if (!StringUtils.hasText(passDecrypt)) {
            var message = "Invalid format password Encrypt";
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }

        var passwordMix = user.getUsuario() + passDecrypt;
        return BCrypt.hashpw(passwordMix, BCrypt.gensalt());
    }

    @Override
    public UsuarioDTO eliminar(Integer idUsuario) throws ServiceException {
        var userDTO = getById(idUsuario);
        try {
            userRepository.deleteById(idUsuario);
            return userDTO;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<UsuarioDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = userRepository.getResultSet(fields, UsuarioEntity.class);
            return listResulSet.stream().map(element -> mapper(element, UsuarioDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public UsuarioDTO getUserByUsuario(String usuario) throws ServiceException {
        try {
            var opUsuario = userRepository.findByUsuario(usuario);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("User not found %s", usuario));
            var userEntity = opUsuario.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(userEntity, UsuarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }
}
