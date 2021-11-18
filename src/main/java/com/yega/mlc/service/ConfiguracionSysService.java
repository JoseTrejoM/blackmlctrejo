package com.yega.mlc.service;

import java.util.HashMap;
import java.util.Map;

import com.yega.mlc.entity.ConfiguracionSysEntity;
import com.yega.mlc.exception.ServiceException;

public abstract class ConfiguracionSysService {
    protected Map<String, String> configServiceMap;

    public abstract ConfiguracionSysEntity parameterById(Integer configuracionId) throws ServiceException;

    public abstract ConfiguracionSysEntity parameterByName(String name) throws ServiceException;
    
    public ConfiguracionSysService setConfig(Map<String, String> headers) {
        configServiceMap = new HashMap<String, String>();
        headers.forEach((k, v) -> configServiceMap.put(k, v));
        return this;
    }
}
