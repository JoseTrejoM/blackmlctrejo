package com.yega.mlc.dto;

import java.util.Date;
import java.util.List;
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
public class PropuestaBeneficiariosDTO {
    private PropuestaV propuesta;
    private List<BeneficiarioV> beneficiario;

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class PropuestaV {
        private Integer propuestaId;
        private Integer estatusPropuestaId;
        private String estatusPropuesta;
        private String curp;
        private Boolean esMenor56;
        private Boolean acuerdoCurp;
        private Date fechaAlta;
        private Date fechaModificacion;
    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class BeneficiarioV {
        private Integer beneficiarioId;
        private Integer tipoBeneficiarioId;
        private String tipoBeneficiario;
        private Integer paisOrigenId;
        private String paisOrigen;
        private Integer estadoOrigenId;
        private String estadoOrigen;
        private Integer paisTrabajoId;
        private String paisTrabajo;
        private Integer estadoTrabajoId;
        private String estadoTrabajo;

        private Integer personaId;
        private String tipoPersonaId;
        private String clave;
        private String tipoPersona;
        private String rfc;
        private String curpPersona;
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;

        private Integer sexoId;
        private String sexo;
        private Date fechaNacimiento;
        private String nss;

        private Integer tipoContactoCorreoId;
        private Integer tipoPersonaCorreoId;
        private String correo;

        private Integer tipoContactoTelefonoId;
        private Integer tipoPersonaTelefonoId;
        private String telefono;
        private Integer flag;
    }

}
