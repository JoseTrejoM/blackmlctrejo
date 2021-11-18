package com.yega.mlc.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeneficioDTO {

    private Integer beneficioId;
    private String clavebeneficio;
    private String titulobeneficio;
    private String subtitulobeneficio;
    private String descripcionbeneficio;
    private int orden;
    private boolean activo;
    private List<Integer> beneficiarios;

}
