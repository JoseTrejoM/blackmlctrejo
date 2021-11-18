package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PersonaFisicaDTO;
import com.yega.mlc.entity.PersonaFisicaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.PersonaFisicaRepository;
import com.yega.mlc.service.PersonaFisicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonaFisicaServiceImpl implements PersonaFisicaService {

    @Autowired
    private PersonaFisicaRepository personaFisicaRepository;

    @Override
    public PersonaFisicaDTO crear(PersonaFisicaDTO persona) throws ServiceException {
        try {
            var personaEntity = mapper(persona, PersonaFisicaEntity.class);
            var personaNew = personaFisicaRepository.save(personaEntity);
            return mapper(personaNew, PersonaFisicaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PersonaFisicaDTO getById(Integer personaId) throws ServiceException {
        try {
            var opUser = personaFisicaRepository.findById(personaId);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("Person not found with id %d", personaId));
            var personaEntity = opUser.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(personaEntity, PersonaFisicaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PersonaFisicaDTO> getAll() throws ServiceException {
        try {
            var list = personaFisicaRepository.findAll();
            list.sort((a, b) -> a.getPersonaFisicaId().compareTo(b.getPersonaFisicaId()));
            return list.stream().map(element -> mapper(element, PersonaFisicaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PersonaFisicaDTO actualizar(PersonaFisicaDTO persona) throws ServiceException {
        getById(persona.getPersonaFisicaId());
        try {
            var personaEntity = mapper(persona, PersonaFisicaEntity.class);
            var personaUpdated = personaFisicaRepository.save(personaEntity);
            return mapper(personaUpdated, PersonaFisicaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PersonaFisicaDTO eliminar(Integer personaId) throws ServiceException {
        var persona = getById(personaId);
        try {
            personaFisicaRepository.deleteById(personaId);
            return persona;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PersonaFisicaDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = personaFisicaRepository.getResultSet(fields, PersonaFisicaEntity.class);
            return listResulSet.stream().map(element -> mapper(element, PersonaFisicaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

}
