package com.yega.mlc.business;

import java.util.HashMap;
import java.util.Map;

import com.yega.mlc.dto.AceptarPropResponseDTO;
import com.yega.mlc.dto.AceptarPropuestaDTO;
import com.yega.mlc.dto.RegistroDTO;
import com.yega.mlc.dto.RegistroResponseDTO;

public abstract class RegisterDelegate {
    protected Map<String, String> configServiceMap = new HashMap<String, String>();
    
    public abstract RegistroResponseDTO createRegister(RegistroDTO registro);

    public abstract AceptarPropResponseDTO acceptProposal(AceptarPropuestaDTO ceptarPropuesta);

    public RegisterDelegate setConfig(Map<String, String> headers) {
        configServiceMap.clear();
        configServiceMap.putAll(headers);
        return this;
    }
}
