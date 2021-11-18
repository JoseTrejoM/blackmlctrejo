/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.controller.impl;

import java.util.Map;

import com.yega.mlc.business.UsuarioDelegate;
import com.yega.mlc.controller.UserController;
import com.yega.mlc.dto.PersonaReqDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author greser69
 */
@RestController
@RequestMapping("/api/v1") // esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
@CrossOrigin
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserControllerImpl implements UserController {

    @Autowired
    @Qualifier("usuarioDelegateByAppKey")
    private UsuarioDelegate usuarioDelegate;

    @Override
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestHeader Map<String, String> headers, @RequestBody PersonaReqDTO persona) {
        var userNew = usuarioDelegate.setConfig(headers).crear(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
    }

    @Override
    @GetMapping("/user/byid/{personaId}")
    public ResponseEntity<Object> getUserById(@RequestHeader Map<String, String> headers, @PathVariable Integer personaId) {
        var userGet = usuarioDelegate.setConfig(headers).getById(personaId);
        return ResponseEntity.status(HttpStatus.OK).body(userGet);
    }

    @Override
    @GetMapping("/user/all")
    public ResponseEntity<Object> getUserAll(@RequestHeader Map<String, String> headers) {
        var listClient = usuarioDelegate.setConfig(headers).getAll();
        return ResponseEntity.status(HttpStatus.OK).body(listClient);
    }

    @Override
    @PutMapping("/user/update")
    public ResponseEntity<Object> updateUser(@RequestHeader Map<String, String> headers, @RequestBody PersonaReqDTO persona) {
        var userUpdate = usuarioDelegate.setConfig(headers).actualizar(persona);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userUpdate);
    }

    @Override
    @DeleteMapping("/user/delete/{personaId}")
    public ResponseEntity<Object> deleteUser(@RequestHeader Map<String, String> headers, @PathVariable Integer personaId) {
        var userDelete = usuarioDelegate.setConfig(headers).eliminar(personaId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDelete);
    }
}
