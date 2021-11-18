package com.yega.mlc.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class PropuestaPersistDTO {
    private Integer propuestaId;
    private Integer enlaceId;
    private Date fechaAutorizacion;
    private Integer estatusPropuestaId;
    private String curp;
    private Boolean esMenor56;
    private Boolean acuerdoCurp;
    private Date fechaFinPropuesta;
    private Date fechaAlta;
    private Integer usuarioAlta;
    private Date fechaModificacion;
    private Integer usuarioModificacion;
    private Boolean activo;
}
