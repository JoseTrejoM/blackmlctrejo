package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreguntaDTO {
    private Integer preguntaId;
    private Integer grupoPreguntasId;
    private String clavePregunta;
    private String descripcionPregunta;
    private Integer orden;
}
