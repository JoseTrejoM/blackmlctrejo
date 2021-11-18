/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.exception;

import com.yega.mlc.dto.ErrorCodeDTO;

/**
 *
 * @author greser69
 */
public class ServiceException extends RuntimeException {

    private final ErrorCodeDTO errorCode;

    public ServiceException(ErrorCodeDTO errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ServiceException(ErrorCodeDTO errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(ErrorCodeDTO errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }
    
    public ServiceException(ErrorCodeDTO errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCodeDTO getErrorCode() {
        return this.errorCode;
    }
}
