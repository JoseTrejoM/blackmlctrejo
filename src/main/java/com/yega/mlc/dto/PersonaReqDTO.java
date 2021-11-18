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
public class PersonaReqDTO {
    private Integer propuestaId;
    private Integer personaId;
    private Integer tipoBeneficiarioId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String email;    
    private Date fechaNacimiento;
    private Integer sexo;
    private Integer paisOrigenId;
    private Integer estadoOrigenId;
    private Integer paisResidenciaId;
    private Integer estadoResidenciaId;

    private DataUsuarioSysDTO dataUserSys;
}

