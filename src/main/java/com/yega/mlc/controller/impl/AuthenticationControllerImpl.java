package com.yega.mlc.controller.impl;

import java.util.Map;

import com.yega.mlc.controller.AuthenticationController;
import com.yega.mlc.dto.LoginAppDTO;
import com.yega.mlc.dto.LoginRequestDTO;
import com.yega.mlc.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") // esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
@CrossOrigin
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthenticationControllerImpl implements AuthenticationController {

    @Autowired
    @Qualifier("authenticationServiceCore")
    private AuthenticationService authService;

    @Override
    @PostMapping("/auth/login")
    public ResponseEntity<Object> validateUser(@RequestHeader Map<String, String> headers, @RequestBody LoginRequestDTO userLogin) {
        var userLoginResponse = authService.setConfig(headers).validateUser(userLogin);
        return ResponseEntity.status(HttpStatus.OK).body(userLoginResponse);
    }

    @Override
    @PostMapping("/auth/loginapp")
    public ResponseEntity<Object> validateByApp(@RequestHeader Map<String, String> headers, @RequestBody LoginAppDTO appLogin) {
        var userLoginResponse = authService.setConfig(headers).validateByApp(appLogin);
        return ResponseEntity.status(HttpStatus.OK).body(userLoginResponse);
    }    

}
