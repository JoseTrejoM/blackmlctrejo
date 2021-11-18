package com.yega.mlc.dto;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VPlanbbDTO {
    private Integer servicioContratadoId;
    private Integer tipoPlanId;
    private String descripcionPlan;

    private String clavePlan;
    private Integer clMonedaId;
    private String moneda;
    private Double costo;
    private Double gastoAdmon;
    private Double total;
    private Integer clFrecuenciaPagoId;
    private String frecuenciaPago;
    private Integer clFormaPagoId;
    private String formaPago;
}
