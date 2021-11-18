package com.yega.mlc.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class PropuestaDTO {

    private Integer propuestaId;
    private Date fechaautorizacion;
    private String curp;
    private Boolean activo;

    private CatalogoDetalleDTO catalogoDetalleDTO;

}
