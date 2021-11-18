package com.yega.mlc.service;

import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.MembresiaDTO;
import com.yega.mlc.exception.ServiceException;
import java.util.List;
import java.util.Set;

public interface MembresiaService extends ServiceBase, ServiceCRUD<MembresiaDTO, MembresiaDTO> {

    public MembresiaDTO crear(MembresiaDTO objIn) throws ServiceException;

    public MembresiaDTO getById(Integer id) throws ServiceException;

    public List<MembresiaDTO> getAll() throws ServiceException;

    public MembresiaDTO actualizar(MembresiaDTO objIn) throws ServiceException;

    public MembresiaDTO eliminar(Integer id) throws ServiceException;

    public List<MembresiaDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException;

}
