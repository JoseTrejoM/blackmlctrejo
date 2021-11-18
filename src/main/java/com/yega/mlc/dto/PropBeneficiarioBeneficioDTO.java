package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.List;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropBeneficiarioBeneficioDTO {

    private Integer propuestaid;
    private Integer tipoPlanId;
    private String clavePlan;
    private String descripcionPlan;
    private Integer clMonedaId;
    private String moneda;
    private Integer clFrecuenciaPagoId;
    private String frecuenciaPago;
    private Integer clFormaPagoId;
    private String formaPago;
    private Double costo;
    private Double gastoAdmon;
    private Double total;
    private Double mensual;
    private Double anual;
    
   
    private List<BeneficiarioBeneficiosDTO> beneficiarios;
}
