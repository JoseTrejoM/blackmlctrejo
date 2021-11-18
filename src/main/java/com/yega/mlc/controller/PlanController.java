package com.yega.mlc.controller;

import java.util.Map;

import com.yega.mlc.exception.ServiceException;

import org.springframework.http.ResponseEntity;

public interface PlanController {
    ResponseEntity<Object> getAllPlans(Map<String, String> headers) throws ServiceException;
}
