package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PeriodoVigenciaDTO;
import com.yega.mlc.entity.PeriodoVigenciaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.PeriodoVigenciaRepository;
import com.yega.mlc.service.PeriodoVigenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PeriodoVigenciaServiceImpl implements PeriodoVigenciaService{
    @Autowired
    private PeriodoVigenciaRepository periodoVigenciaRepository;

    @Override
    public PeriodoVigenciaDTO crear(PeriodoVigenciaDTO objIn) throws ServiceException {
        try {
            var entity = mapper(objIn, PeriodoVigenciaEntity.class);
            var entityNew = periodoVigenciaRepository.save(entity);
            return mapper(entityNew, PeriodoVigenciaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PeriodoVigenciaDTO getById(Integer id) throws ServiceException {
        try {
            var opEntity = periodoVigenciaRepository.findById(id);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("PeriodoVigencia not found with id %d", id));
            var entity = opEntity.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(entity, PeriodoVigenciaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PeriodoVigenciaDTO> getAll() throws ServiceException {
        try {
            var list = periodoVigenciaRepository.findAll();
            list.sort((a, b) -> a.getPeriodoVigenciaId().compareTo(b.getPeriodoVigenciaId()));
            return list.stream().map(element -> mapper(element, PeriodoVigenciaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PeriodoVigenciaDTO actualizar(PeriodoVigenciaDTO objIn) throws ServiceException {
        getById(objIn.getPeriodoVigenciaId());
        try {
            var entity = mapper(objIn, PeriodoVigenciaEntity.class);
            var entityUpdated = periodoVigenciaRepository.save(entity);
            return mapper(entityUpdated, PeriodoVigenciaDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PeriodoVigenciaDTO eliminar(Integer id) throws ServiceException {
        var dto = getById(id);
        try {
            periodoVigenciaRepository.deleteById(id);
            return dto;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PeriodoVigenciaDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = periodoVigenciaRepository.getResultSet(fields, PeriodoVigenciaEntity.class);
            return listResulSet.stream().map(element -> mapper(element, PeriodoVigenciaDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }
    
}
