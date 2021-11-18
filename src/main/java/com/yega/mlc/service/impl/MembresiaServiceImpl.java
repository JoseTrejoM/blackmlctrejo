package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.MembresiaDTO;
import com.yega.mlc.entity.MembresiaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.MembresiaRespository;
import com.yega.mlc.service.MembresiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MembresiaServiceImpl implements MembresiaService{

    @Autowired
    private MembresiaRespository membresiaRespository;

    @Override
    public MembresiaDTO crear(MembresiaDTO objIn) throws ServiceException {
        try {
            var entity = mapper(objIn, MembresiaEntity.class);
            var entityNew = membresiaRespository.save(entity);
            return mapper(entityNew, MembresiaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public MembresiaDTO getById(Integer id) throws ServiceException {
        try {
            var opEntity = membresiaRespository.findById(id);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("Membresia not found with id %d", id));
            var entity = opEntity.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(entity, MembresiaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<MembresiaDTO> getAll() throws ServiceException {
        try {
            var list = membresiaRespository.findAll();
            list.sort((a, b) -> a.getMembresiaId().compareTo(b.getEstatusMembresiaId()));
            return list.stream().map(element -> mapper(element, MembresiaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public MembresiaDTO actualizar(MembresiaDTO objIn) throws ServiceException {
        getById(objIn.getMembresiaId());
        try {
            var entity = mapper(objIn, MembresiaEntity.class);
            var entityUpdated = membresiaRespository.save(entity);
            return mapper(entityUpdated, MembresiaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public MembresiaDTO eliminar(Integer id) throws ServiceException {
        var dto = getById(id);
        try {
            membresiaRespository.deleteById(id);
            return dto;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<MembresiaDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = membresiaRespository.getResultSet(fields, MembresiaEntity.class);
            return listResulSet.stream().map(element -> mapper(element, MembresiaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }
    
}
