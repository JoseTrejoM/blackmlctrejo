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
public class BeneficioSimpleDTO {

    private Integer beneficioId;
    private String titulobeneficio;
    private boolean activo;

}