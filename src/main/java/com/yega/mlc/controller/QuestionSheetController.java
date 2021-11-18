package com.yega.mlc.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface QuestionSheetController {
    ResponseEntity<Object> getQuestionSheetById (Map<String, String> headers, Integer cuestionarioId);
}
