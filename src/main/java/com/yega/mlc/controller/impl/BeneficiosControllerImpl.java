package com.yega.mlc.controller.impl;

import com.yega.mlc.controller.BeneficiosController;
import com.yega.mlc.service.BeneficiosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class BeneficiosControllerImpl implements BeneficiosController {

    @Autowired
    private BeneficiosServices beneficiosServices;

    @Override
    @GetMapping("/getBeneficiosBeneficiarios")
    public ResponseEntity<Object> getBeneficiosBeneficiarios(Map<String, String> headers) {
        var beneficiosBeneficiariosList = beneficiosServices.getBeneficios();
        return new ResponseEntity<>(beneficiosBeneficiariosList, HttpStatus.ACCEPTED);
    }
}
