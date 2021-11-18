package com.yega.mlc.controller;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface BeneficiosController {


    ResponseEntity<Object> getBeneficiosBeneficiarios(Map<String, String> headers);
}
