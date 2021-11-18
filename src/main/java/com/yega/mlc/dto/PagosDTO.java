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
public class PagosDTO {
    private Integer pagoId;
    private Integer membresiaId;
    private Integer vigenciaId;
    private Integer monedaPagoId;
    private Integer formaPagoId;
    private Double montoPago;
    private Date fechaPago;
    private String referencia;
    private String transaccion;
    private Date fechaAlta;
    private Integer usuarioAlta;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    private Boolean activo;
}
