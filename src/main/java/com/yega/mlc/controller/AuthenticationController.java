package com.yega.mlc.controller;

import java.util.Map;

import com.yega.mlc.dto.LoginAppDTO;
import com.yega.mlc.dto.LoginRequestDTO;

import org.springframework.http.ResponseEntity;

public interface AuthenticationController {
    ResponseEntity<Object> validateUser(Map<String, String> headers, LoginRequestDTO userLogin);

    ResponseEntity<Object> validateByApp(Map<String, String> headers, LoginAppDTO appLogin);
        
}
