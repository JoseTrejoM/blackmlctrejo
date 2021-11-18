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
public class MaestroDetalleDTO {

    private Integer catalogoMaestroId;
    private String nombre;
    private String descripcion;
    private boolean activo;

}
