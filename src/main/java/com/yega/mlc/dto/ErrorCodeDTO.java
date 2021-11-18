/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.http.HttpStatus;

/**
 *
 * @author greser69
 */
@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

@AllArgsConstructor
@NoArgsConstructor
public class ErrorCodeDTO implements Serializable {

    @JsonIgnore
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private String code;
    private String error;
    private String message;

    public ErrorCodeDTO(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.code = httpStatus.value() + "";
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
    }
}
