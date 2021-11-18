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
public class MembresiaDTO {
    private Integer membresiaId;
    private Integer estatusMembresiaId;
    private String numMembresia;
    private Integer consecutivo;
    private Date fechaAlta;
    private Integer usuarioAlta;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    private Boolean activo;
}
