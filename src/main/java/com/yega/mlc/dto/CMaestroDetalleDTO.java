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
public class CMaestroDetalleDTO {

    private Integer catalogodetalleid;
    private String clave;
    private String descripcion;
    private Short orden;
    private Boolean activo;

}
