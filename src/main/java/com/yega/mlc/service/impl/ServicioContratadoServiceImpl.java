package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.ServicioContratadoDTO;
import com.yega.mlc.entity.ServicioContratadoEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.ServicioContratadoRepository;
import com.yega.mlc.service.ServicioContratadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServicioContratadoServiceImpl implements ServicioContratadoService {

    @Autowired
    private ServicioContratadoRepository servicioContratadoRepository;

    @Override
    public ServicioContratadoDTO crear(ServicioContratadoDTO servicioContratado)
            throws ServiceException {
        try {
            var servContEntity = mapper(servicioContratado, ServicioContratadoEntity.class);            
            var servContNew = servicioContratadoRepository.save(servContEntity);
            return mapper(servContNew, ServicioContratadoDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public ServicioContratadoDTO getById(Integer id) throws ServiceException {
        try {
            var opEntity = servicioContratadoRepository.findById(id);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("ServicioContratado not found with id %d", id));            
            var entity = opEntity.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return mapper(entity, ServicioContratadoDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<ServicioContratadoDTO> getAll() throws ServiceException {
        try {
            var list = servicioContratadoRepository.findAll();
            list.sort((a, b) -> a.getServicioContratadoId().compareTo(b.getServicioContratadoId()));
            return list.stream().map(element -> mapper(element, ServicioContratadoDTO.class)).collect(Collectors.toList());            
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public ServicioContratadoDTO actualizar(ServicioContratadoDTO servCont) throws ServiceException {
        getById(servCont.getServicioContratadoId());
        try {
            return crear(servCont);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public ServicioContratadoDTO eliminar(Integer id) throws ServiceException {
        var dto = getById(id);
        try {
            servicioContratadoRepository.deleteById(id);
            return dto;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<ServicioContratadoDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = servicioContratadoRepository.getResultSet(fields, ServicioContratadoEntity.class);
            return listResulSet.stream().map(element -> mapper(element, ServicioContratadoDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

}
