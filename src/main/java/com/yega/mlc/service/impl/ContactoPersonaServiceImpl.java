package com.yega.mlc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ContactoPersonaDTO;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.entity.ContactoPersonaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.ContactoPersonaRepository;
import com.yega.mlc.service.ContactoPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ContactoPersonaServiceImpl implements ContactoPersonaService{

    @Autowired
    private ContactoPersonaRepository contactoPersonaRepository;

    @Override
    public ContactoPersonaDTO crear(ContactoPersonaDTO contactoPersona) throws ServiceException {
        try {            
            var entity = mapper(contactoPersona, ContactoPersonaEntity.class);
            var entityNew = contactoPersonaRepository.save(entity);
            return mapper(entityNew, ContactoPersonaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public ContactoPersonaDTO getById(Integer id) throws ServiceException {
        try {
            var opEntity = contactoPersonaRepository.findById(id);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("User not found with id %d", id));            
            var entity = opEntity.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));            
            return mapper(entity, ContactoPersonaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<ContactoPersonaDTO> getAll() throws ServiceException {
        try {
            var list = contactoPersonaRepository.findAll();
            list.sort((a, b) -> a.getContactoPersonaId().compareTo(b.getContactoPersonaId()));
            return list.stream().map(element -> mapper(element, ContactoPersonaDTO.class)).collect(Collectors.toList());            
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public ContactoPersonaDTO actualizar(ContactoPersonaDTO contactoPersona) throws ServiceException {
        getById(contactoPersona.getContactoPersonaId());
        try {            
            var entity = mapper(contactoPersona, ContactoPersonaEntity.class);
            var entityNew = contactoPersonaRepository.save(entity);
            return mapper(entityNew, ContactoPersonaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public ContactoPersonaDTO eliminar(Integer id) throws ServiceException {
        var dto = getById(id);
        try {
            contactoPersonaRepository.deleteById(id);
            return dto;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<ContactoPersonaDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = contactoPersonaRepository.getResultSet(fields, ContactoPersonaEntity.class);
            return listResulSet.stream().map(element -> mapper(element, ContactoPersonaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<ContactoPersonaDTO> getAllByPersonaId(Integer personaId) {
        try {
            var list = contactoPersonaRepository.getByPersonaId(personaId);
            return list.stream().map(element -> mapper(element, ContactoPersonaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<ContactoPersonaDTO> eliminarByPersonaId(Integer personaId) {
        try {
            var list = getAllByPersonaId(personaId);
            var listIds = new ArrayList<Integer>();
            list.forEach(contacto ->{
                listIds.add(contacto.getContactoPersonaId());
            });
            contactoPersonaRepository.deleteAllById(listIds);

            return list;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }
    
}
