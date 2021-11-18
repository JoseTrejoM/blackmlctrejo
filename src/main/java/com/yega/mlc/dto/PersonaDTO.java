package com.yega.mlc.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaDTO {
    private Integer personaId;
    private Integer tipoPersonaId;
    private Date fechaAlta;
    private Date fechaBaja;
    private String rfc;
    private Boolean activo;
}
