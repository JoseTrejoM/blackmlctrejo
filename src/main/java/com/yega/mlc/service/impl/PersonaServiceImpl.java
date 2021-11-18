package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PersonaDTO;
import com.yega.mlc.entity.PersonaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.PersonaRepository;
import com.yega.mlc.service.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public PersonaDTO crear(PersonaDTO persona) throws ServiceException {
        try {
            var personaEntity = mapper(persona, PersonaEntity.class);
            var personaNew = personaRepository.save(personaEntity);
            return mapper(personaNew, PersonaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PersonaDTO getById(Integer personaId) throws ServiceException {
        try {
            var opUser = personaRepository.findById(personaId);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("Person not found with id %d", personaId));
            var personaEntity = opUser.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(personaEntity, PersonaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PersonaDTO> getAll() throws ServiceException {
        try {
            var list = personaRepository.findAll();
            list.sort((a, b) -> a.getPersonaId().compareTo(b.getPersonaId()));
            return list.stream().map(element -> mapper(element, PersonaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PersonaDTO actualizar(PersonaDTO persona) throws ServiceException {
        try {
            var personaEntity = mapper(persona, PersonaEntity.class);
            var personaUpdated = personaRepository.save(personaEntity);
            return mapper(personaUpdated, PersonaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PersonaDTO eliminar(Integer personaId) throws ServiceException {
        var persona = getById(personaId);
        try {
            personaRepository.deleteById(personaId);
            return persona;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PersonaDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = personaRepository.getResultSet(fields, PersonaEntity.class);
            return listResulSet.stream().map(element -> mapper(element, PersonaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

}
