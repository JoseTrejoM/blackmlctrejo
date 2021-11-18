package com.yega.mlc.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface AuthorizationController {
    ResponseEntity<Object> modulesUser(Map<String, String> headers, Integer idSistemaPadre, Integer idUsuario);

    ResponseEntity<Object> permissionUser(Map<String, String> headers, Integer idSistema, Integer idUsuario);
    
}
