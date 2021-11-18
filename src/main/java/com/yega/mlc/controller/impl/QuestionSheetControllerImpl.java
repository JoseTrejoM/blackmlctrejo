package com.yega.mlc.controller.impl;

import java.util.Map;

import com.yega.mlc.controller.QuestionSheetController;
import com.yega.mlc.service.QuestionSheetService;

import org.springframework.beans.factory.annotation.Autowired;
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
public class QuestionSheetControllerImpl implements QuestionSheetController{

    @Autowired
    private QuestionSheetService questionSheetService;

    @Override
    @GetMapping("/questionsheet/byid/{cuestionarioId}")
    public ResponseEntity<Object> getQuestionSheetById(@RequestHeader Map<String, String> headers, @PathVariable Integer cuestionarioId) {
        var questionSheetGet = questionSheetService.getQuestionSheetById(cuestionarioId);
        return ResponseEntity.status(HttpStatus.OK).body(questionSheetGet);
    }
    
}
