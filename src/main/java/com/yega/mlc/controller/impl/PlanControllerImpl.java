package com.yega.mlc.controller.impl;

import java.util.Map;

import com.yega.mlc.controller.PlanController;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.service.PlanBeneficiosBeneficiariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class PlanControllerImpl implements PlanController{

    @Autowired
    private PlanBeneficiosBeneficiariosService planService;

    @Override
    @GetMapping("/plan/all")
    public ResponseEntity<Object> getAllPlans(@RequestHeader Map<String, String> headers) throws ServiceException {
        var plans = planService.getAllPlans();
        return ResponseEntity.status(HttpStatus.OK).body(plans);
    }
    
}
