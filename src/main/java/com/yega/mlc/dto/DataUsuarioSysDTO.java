package com.yega.mlc.dto;

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
public class DataUsuarioSysDTO {
    private Integer rolId;
    private Integer tipoUsuarioId;
    private Integer estatusUsuarioId;
    private String puesto;
    private String area;
    private String contrasena;
    private String rfc;
    private String curp;
    private String nss;
    private String foto;
    private String iniciales;
    private Integer tipoPersonaId;
}
