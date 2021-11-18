package com.yega.mlc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yega.mlc.dto.ModuloDTO;
import com.yega.mlc.dto.PermisoDTO;
import com.yega.mlc.exception.ServiceException;

public abstract class AuthorizationService {
    protected Map<String, String> configServiceMap;

    public abstract List<ModuloDTO> modulesUser(Integer idSistemaPadre, Integer idUsuario) throws ServiceException;

    public abstract List<PermisoDTO> permissionUser(Integer idSistema, Integer idUsuario) throws ServiceException;
        
    public AuthorizationService setConfig(Map<String, String> headers) {
        configServiceMap = new HashMap<String, String>();
        headers.forEach((k, v) -> configServiceMap.put(k, v));
        return this;
    }
}
