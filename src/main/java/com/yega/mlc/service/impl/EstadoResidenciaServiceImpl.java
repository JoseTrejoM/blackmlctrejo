package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.EstadoResidenciaDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.entity.EstadoResidenciaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.EstadoResidenciaRepository;
import com.yega.mlc.service.EstadoResidenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EstadoResidenciaServiceImpl implements EstadoResidenciaService{

    @Autowired
    private EstadoResidenciaRepository estadoResidenciaRepository;

    @Override
    public EstadoResidenciaDTO crear(EstadoResidenciaDTO estadoResidencia) throws ServiceException {
        try {            
            var entity = mapper(estadoResidencia, EstadoResidenciaEntity.class);
            var entityNew = estadoResidenciaRepository.save(entity);
            return mapper(entityNew, EstadoResidenciaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public EstadoResidenciaDTO getById(Integer id) throws ServiceException {
        try {
            var opEntity = estadoResidenciaRepository.findById(id);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("User not found with id %d", id));            
            var entity = opEntity.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));            
            return mapper(entity, EstadoResidenciaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<EstadoResidenciaDTO> getAll() throws ServiceException {
        try {
            var list = estadoResidenciaRepository.findAll();
            list.sort((a, b) -> a.getEstadoResidenciaId().compareTo(b.getEstadoResidenciaId()));
            return list.stream().map(element -> mapper(element, EstadoResidenciaDTO.class)).collect(Collectors.toList());            
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public EstadoResidenciaDTO actualizar(EstadoResidenciaDTO estadoOrigen) throws ServiceException {
        getById(estadoOrigen.getEstadoResidenciaId());
        try {            
            var entity = mapper(estadoOrigen, EstadoResidenciaEntity.class);
            var entityNew = estadoResidenciaRepository.save(entity);
            return mapper(entityNew, EstadoResidenciaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public EstadoResidenciaDTO eliminar(Integer id) throws ServiceException {
        var dto = getById(id);
        try {
            estadoResidenciaRepository.deleteById(id);
            return dto;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<EstadoResidenciaDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = estadoResidenciaRepository.getResultSet(fields, EstadoResidenciaEntity.class);
            return listResulSet.stream().map(element -> mapper(element, EstadoResidenciaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }
    
}
