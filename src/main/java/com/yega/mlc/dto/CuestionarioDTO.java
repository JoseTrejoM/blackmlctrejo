package com.yega.mlc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CuestionarioDTO {
    private Integer cuestionarioId;
    private String descripcionCuestionario;
    private List<PreguntaDTO> preguntas;
}
