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
public class AceptarPropuestaDTO {
    private Integer propuestaId;
    private Integer frecuenciaPagoId;
    private Integer tipoPlanId;
    private Integer formaPagoId;
}
