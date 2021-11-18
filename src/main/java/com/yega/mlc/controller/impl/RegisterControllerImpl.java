package com.yega.mlc.controller.impl;

import java.util.Map;

import com.yega.mlc.business.RegisterDelegate;
import com.yega.mlc.controller.RegisterController;
import com.yega.mlc.dto.RegistroDTO;

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
public class RegisterControllerImpl implements RegisterController {

    @Autowired
    @Qualifier("registerDelegateByAppKey")
    private RegisterDelegate registerDelegate;

    @Override
    @PostMapping("/register/create")
    public ResponseEntity<Object> createRegister(@RequestHeader Map<String, String> headers, @RequestBody RegistroDTO registro) {
        var registerNew = registerDelegate.setConfig(headers).createRegister(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerNew);
    }
    
}
