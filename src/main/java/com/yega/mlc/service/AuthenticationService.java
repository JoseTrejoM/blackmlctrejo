package com.yega.mlc.service;

import java.util.HashMap;
import java.util.Map;

import com.yega.mlc.dto.LoginAppDTO;
import com.yega.mlc.dto.LoginRequestDTO;
import com.yega.mlc.dto.LoginResponseDTO;
import com.yega.mlc.exception.ServiceException;

public abstract class AuthenticationService {
    protected Map<String, String> configServiceMap;

    public abstract LoginResponseDTO validateUser(LoginRequestDTO userLogin) throws ServiceException;

    public abstract LoginResponseDTO validateByApp(LoginAppDTO appLogin) throws ServiceException;
        
    public AuthenticationService setConfig(Map<String, String> headers) {
        configServiceMap = new HashMap<String, String>(headers);
        return this;
    }
}
