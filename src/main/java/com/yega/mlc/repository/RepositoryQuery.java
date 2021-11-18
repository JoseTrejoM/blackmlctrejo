package com.yega.mlc.repository;

import java.util.List;
import java.util.Set;

import com.yega.mlc.dto.FieldQueryDTO;

public interface RepositoryQuery <T> {
    List<T> getResultSet(Set<FieldQueryDTO> fields, Class<T> resultClass);
    //List<T> getResultSet(Set<FieldQueryDTO> fields);
}
