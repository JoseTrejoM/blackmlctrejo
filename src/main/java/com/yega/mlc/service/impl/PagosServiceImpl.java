package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PagosDTO;
import com.yega.mlc.entity.PagosEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.PagosRepository;
import com.yega.mlc.service.PagosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PagosServiceImpl implements PagosService{
    @Autowired
    private PagosRepository pagosRepository;

    @Override
    public PagosDTO crear(PagosDTO objIn) throws ServiceException {
        try {
            var entity = mapper(objIn, PagosEntity.class);
            var entityNew = pagosRepository.save(entity);
            return mapper(entityNew, PagosDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PagosDTO getById(Integer id) throws ServiceException {
        try {
            var opEntity = pagosRepository.findById(id);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("Pago not found with id %d", id));
            var entity = opEntity.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(entity, PagosDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PagosDTO> getAll() throws ServiceException {
        try {
            var list = pagosRepository.findAll();
            list.sort((a, b) -> a.getPagoId().compareTo(b.getPagoId()));
            return list.stream().map(element -> mapper(element, PagosDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PagosDTO actualizar(PagosDTO objIn) throws ServiceException {
        getById(objIn.getMembresiaId());
        try {
            var entity = mapper(objIn, PagosEntity.class);
            var entityUpdated = pagosRepository.save(entity);
            return mapper(entityUpdated, PagosDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PagosDTO eliminar(Integer id) throws ServiceException {
        var dto = getById(id);
        try {
            pagosRepository.deleteById(id);
            return dto;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PagosDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = pagosRepository.getResultSet(fields, PagosEntity.class);
            return listResulSet.stream().map(element -> mapper(element, PagosDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    
}
