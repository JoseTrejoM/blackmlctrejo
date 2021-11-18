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
public class ServicioContratadoDTO {
    private Integer servicioContratadoId;
    private Integer frecuenciaPagoId;
    private Integer propuestaId;
    private Integer tipoPlanId;
    private Integer formaPagoId;
    private Date fechaAlta;
    private int usuarioAlta;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    private Boolean activo;    
    
}
