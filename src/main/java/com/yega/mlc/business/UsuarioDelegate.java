package com.yega.mlc.business;

import java.util.HashMap;
import java.util.Map;

import com.yega.mlc.dto.PersonaReqDTO;
import com.yega.mlc.dto.PersonaResDTO;

public abstract class UsuarioDelegate implements DelegateCRUD<PersonaReqDTO, PersonaResDTO>{
    protected Map<String, String> configServiceMap = new HashMap<String, String>();
        
    public UsuarioDelegate setConfig(Map<String, String> headers) {
        configServiceMap.clear();
        configServiceMap.putAll(headers);
        return this;
    }
}