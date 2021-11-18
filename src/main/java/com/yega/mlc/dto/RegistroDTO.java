package com.yega.mlc.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistroDTO {
    private Integer propuestaId;
    private Integer servicioBeneficiarioId;
    private String curp;
    private List<Integer> beneficiarios;
    private List<BeneficioDTO> beneficios;
    private List<RegistroRespuestaDTO> respuestas;
}
