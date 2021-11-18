package com.yega.mlc.controller;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PasswordRecoveryController {

    ResponseEntity<Object> sendEmail(Map<String, String> headers, String curp) throws Exception;
}
