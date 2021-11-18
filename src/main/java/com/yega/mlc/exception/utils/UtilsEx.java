/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.exception.utils;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.exception.ServiceException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author greser69
 */
@Slf4j
public class UtilsEx {

    private UtilsEx() {
    }

    public static ServiceException createServiceException(Exception e) {
        if (e instanceof ServiceException) {
            return (ServiceException) e;
        }

        var errorCode = new ErrorCodeDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        if ((e instanceof JWTVerificationException || e instanceof AuthenticationException) && !(e instanceof InternalAuthenticationServiceException)) {
            errorCode = new ErrorCodeDTO(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
        
        return new ServiceException(errorCode, errorCode.getMessage());

    }

    public static void showStackTraceError(Exception e) {
        if ((e instanceof ServiceException || e instanceof JWTVerificationException || e instanceof AuthenticationException) && !(e instanceof InternalAuthenticationServiceException)) {
            var classAndMethodName = "";
            if (e.getStackTrace() != null && e.getStackTrace().length > 0) {
                classAndMethodName = e.getStackTrace()[0].getClassName() + "." + e.getStackTrace()[0].getMethodName()
                        + " :: ";
            }
            log.error(classAndMethodName + e.getMessage());
        } else {
            log.error(e.getMessage(), e);
        }
    }
}
