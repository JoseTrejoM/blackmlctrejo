package com.yega.mlc.dto;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanBeneficiosBeneficiariosDTO {
    private Integer tipoplanId;
    private String descripcionPlan;
    private double precioMensual;
    private double precioAnual;

    private Integer edadminima;
    private Integer edadmaxima;
    private Integer programa;
    private Double repatriacion_a_mexico;
    private Double servicio_funerario;
    private Double seguro_de_vida;
    private Double educacion_financiera;
    private Double envio_de_dinero;
    private Double titular;
    private Double pareja;
    private Double padre;
    private Double madre;
    private Double hijo;
}
