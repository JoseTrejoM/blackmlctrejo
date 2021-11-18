package com.yega.mlc.controller;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CatalogoController {

    ResponseEntity<Object> getCatPaises(Map<String, String> headers);
    ResponseEntity<Object> getCatEstados(Map<String, String> headers, short paisid);
}
