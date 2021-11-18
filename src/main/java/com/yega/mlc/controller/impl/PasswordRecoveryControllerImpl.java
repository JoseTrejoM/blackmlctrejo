package com.yega.mlc.controller.impl;

import com.yega.mlc.controller.PasswordRecoveryController;
import com.yega.mlc.service.PasswordRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class PasswordRecoveryControllerImpl implements PasswordRecoveryController {


    @Autowired
    PasswordRecoveryService passwordRecoveryService;



    @Override
    @GetMapping("/sendEmail/{token}")
    public ResponseEntity<Object> sendEmail(Map<String, String> headers, @PathVariable("token")  String token) {

        String responseBody = passwordRecoveryService.sendEmail(token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseBody);
    }
}
