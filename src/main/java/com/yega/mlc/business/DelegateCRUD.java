package com.yega.mlc.business;

import java.util.List;

import com.yega.mlc.exception.ServiceException;

public interface DelegateCRUD<T, S> {
    S crear(T t) throws ServiceException;

    S getById(Integer id) throws ServiceException;

    List<S> getAll() throws ServiceException;

    S actualizar(T t) throws ServiceException;

    S eliminar(Integer id) throws ServiceException;
}
