package com.yega.mlc.controller;

import java.util.Map;

import com.yega.mlc.dto.RegistroDTO;

import org.springframework.http.ResponseEntity;

public interface RegisterController {
    ResponseEntity<Object> createRegister (Map<String, String> headers, RegistroDTO registro);
}
