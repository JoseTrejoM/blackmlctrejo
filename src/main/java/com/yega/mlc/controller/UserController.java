/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.controller;

import java.util.Map;

import com.yega.mlc.dto.PersonaReqDTO;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author greser69
 */
public interface UserController {

	ResponseEntity<Object> createUser(Map<String, String> headers, PersonaReqDTO persona);
	
	ResponseEntity<Object> getUserById (Map<String, String> headers, Integer personaId);

	ResponseEntity<Object> getUserAll(Map<String, String> headers);

	ResponseEntity<Object> updateUser(Map<String, String> headers, PersonaReqDTO persona);

	ResponseEntity<Object> deleteUser(Map<String, String> headers, Integer personaId);
}
