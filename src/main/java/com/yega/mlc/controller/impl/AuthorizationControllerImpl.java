package com.yega.mlc.controller.impl;

import java.util.Map;

import com.yega.mlc.controller.AuthorizationController;
import com.yega.mlc.service.AuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") // esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
@CrossOrigin
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthorizationControllerImpl implements AuthorizationController{
    
    @Autowired
    @Qualifier("authorizationServiceCore")
    private AuthorizationService authService;
    
    @Override
    @GetMapping("/auth/modules/{idSistemaPadre}/{idUsuario}")
    public ResponseEntity<Object> modulesUser(@RequestHeader Map<String, String> headers, @PathVariable Integer idSistemaPadre, @PathVariable Integer idUsuario) {
        var modulesGet = authService.setConfig(headers).modulesUser(idSistemaPadre, idUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(modulesGet);
    }

    @Override
    @GetMapping("/auth/permission/{idSistema}/{idUsuario}")
    public ResponseEntity<Object> permissionUser(@RequestHeader Map<String, String> headers, @PathVariable Integer idSistema, @PathVariable Integer idUsuario) {
        var permissionsGet = authService.setConfig(headers).permissionUser(idSistema, idUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(permissionsGet);
    }
}
