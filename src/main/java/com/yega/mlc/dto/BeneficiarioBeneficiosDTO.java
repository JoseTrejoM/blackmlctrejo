package com.yega.mlc.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeneficiarioBeneficiosDTO {
    private Integer beneficiarioid;
    private String imagenactivo;
    private String imageninactivo;
    private String imagendefault;
    private boolean esseleccionado;
    private String tipobeneficiario;
    private Integer tipobeneficiarioid;
    private List<BeneficioSimpleDTO> beneficioSimpleDTO;
}
