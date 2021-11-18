package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeneficiosBeneficiariosDTO
{
    private Integer beneficiobeneficiarioid;
    private String imagenactivo;
    private String imageninactivo;
    private String imagendefault;
    private boolean esseleccionado;
    private Integer personaid;

    private Integer beneficiarioid;
    private String tipobeneficiario;
    private String tipobeneficiarioid;
    private Integer serviciobeneficiarioid;
    private Integer serviciocontratadoid;
}