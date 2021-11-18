package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.EstadoOrigenDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.entity.EstadoOrigenEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.EstadoOrigenRepository;
import com.yega.mlc.service.EstadoOrigenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EstadoOrigenServiceImpl implements EstadoOrigenService{

    @Autowired
    private EstadoOrigenRepository estadoOrigenRepository;

    @Override
    public EstadoOrigenDTO crear(EstadoOrigenDTO estadoOrigen) throws ServiceException {
        try {            
            var entity = mapper(estadoOrigen, EstadoOrigenEntity.class);
            var entityNew = estadoOrigenRepository.save(entity);
            return mapper(entityNew, EstadoOrigenDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public EstadoOrigenDTO getById(Integer id) throws ServiceException {
        try {
            var opEntity = estadoOrigenRepository.findById(id);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("User not found with id %d", id));            
            var entity = opEntity.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));            
            return mapper(entity, EstadoOrigenDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<EstadoOrigenDTO> getAll() throws ServiceException {
        try {
            var list = estadoOrigenRepository.findAll();
            list.sort((a, b) -> a.getEstadoOrigenId().compareTo(b.getEstadoOrigenId()));
            return list.stream().map(element -> mapper(element, EstadoOrigenDTO.class)).collect(Collectors.toList());            
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public EstadoOrigenDTO actualizar(EstadoOrigenDTO estadoOrigen) throws ServiceException {
        getById(estadoOrigen.getEstadoOrigenId());
        try {            
            var entity = mapper(estadoOrigen, EstadoOrigenEntity.class);
            var entityNew = estadoOrigenRepository.save(entity);
            return mapper(entityNew, EstadoOrigenDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public EstadoOrigenDTO eliminar(Integer id) throws ServiceException {
        var dto = getById(id);
        try {
            estadoOrigenRepository.deleteById(id);
            return dto;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<EstadoOrigenDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = estadoOrigenRepository.getResultSet(fields, EstadoOrigenEntity.class);
            return listResulSet.stream().map(element -> mapper(element, EstadoOrigenDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }
    
}
