package com.yega.mlc.exception;

import com.yega.mlc.dto.ErrorCodeDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlerAllExceptions(Exception ex, WebRequest request) {
        var errorCode = new ErrorCodeDTO(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errorCode, errorCode.getHttpStatus());
    }

    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<Object> handlerServiceExceptions(ServiceException ex, WebRequest request) {        
        return new ResponseEntity<>(ex.getErrorCode(), ex.getErrorCode().getHttpStatus());
    }

}
