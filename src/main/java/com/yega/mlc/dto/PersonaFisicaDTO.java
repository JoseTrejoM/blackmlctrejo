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
public class PersonaFisicaDTO {
    private Integer personaFisicaId;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer sexoId;
    private Date fechaNacimiento;
    private Date fechaAlta;
    private String curp;
    private String nss;
}
