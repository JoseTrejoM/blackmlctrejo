package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistroRespuestaDTO {
    private Integer preguntaId;
    private String respuesta;
    private Integer respuestaId;    
}
