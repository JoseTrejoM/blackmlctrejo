package com.yega.mlc.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDetalleDTO {

    private Integer catalogoDetalleId;
    private String clave;
    private String descripcion;
    private short orden;
    private boolean activo;

    MaestroDetalleDTO maestroDetalle;

}
