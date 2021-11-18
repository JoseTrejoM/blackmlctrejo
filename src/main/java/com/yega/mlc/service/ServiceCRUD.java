package com.yega.mlc.service;

import java.util.List;
import java.util.Set;

import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.exception.ServiceException;

public interface ServiceCRUD<T, S> {
    S crear(T objIn) throws ServiceException;
    
    S getById(Integer id) throws ServiceException;
    
    List<S> getAll() throws ServiceException;
    
    S actualizar(T objIn) throws ServiceException;

    S eliminar(Integer id) throws ServiceException;

    List<S> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException;
}
