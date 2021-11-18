package com.yega.mlc.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "VPROPUESTA_BENEFICIARIOS")
public class BeneficiariosDePropuestaEntity {
    /** Datos de la propuesta */    
    @Column(name="PROPUESTAID")
    private Integer propuestaId;

    @Column(name="CLESTATUSPROPUESTAID")
    private Integer estatusPropuestaId;

    @Column(name="ESTATUSPROPUESTA")
    private String estatusPropuesta;

    @Column(name="CURP")
    private String curp;

    @Column(name="ESMENOR56")
    private Boolean esMenor56;

    @Column(name="ACUERDOCURP")
    private Boolean acuerdoCurp;

    @Column(name="FECHAALTA")
    private Date fechaAlta;

    @Column(name="FECHAMODIFICACION")
    private Date fechaModificacion;

    /**Datos de los beneficiarios */
    @Id
    @Column(name="BENEFICIARIOID")
    private Integer beneficiarioId;

    @Column(name="TIPOBENEFICIARIOID")
    private Integer tipoBeneficiarioId;

    @Column(name="TIPOBENEFICIARIO")
    private String tipoBeneficiario;

    @Column(name="PAISID_ORIGEN")
    private Integer paisOrigenId;

    @Column(name="DESCRIPCIONPAIS_ORIGEN")
    private String paisOrigen;

    @Column(name="ESTADOID_ORIGEN")
    private Integer estadoOrigenId;

    @Column(name="NOMBREESTADO_ORIGEN")
    private String estadoOrigen;

    @Column(name="PAISID_TRABAJO")
    private Integer paisTrabajoId;

    @Column(name="DESCRIPCIONPAIS_TRABAJO")
    private String paisTrabajo;

    @Column(name="ESTADOID_TRABAJO")
    private Integer estadoTrabajoId;

    @Column(name="NOMBREESTADO_TRABAJO")
    private String estadoTrabajo;
    
    @Column(name="PERSONAID")
    private Integer personaId;

    @Column(name="CLTIPOPERSONAID")
    private String tipoPersonaId;

    @Column(name="CLAVE")
    private String clave;

    @Column(name="TIPOPERSONA")
    private String tipoPersona;

    @Column(name="RFC")
    private String rfc;

    @Column(name="CURP_PERSONA")
    private String curpPersona;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="PRIMERAPELLIDO")
    private String apellidoPaterno;

    @Column(name="SEGUNDOAPELLIDO")
    private String apellidoMaterno;

    @Column(name="CLSEXOID")
    private Integer sexoId;

    @Column(name="CLAVE_SEXO")
    private String sexoClave;

    @Column(name="SEXO")
    private String sexo;

    @Column(name="FECHANACIMIENTO")
    private Date fechaNacimiento;

    @Column(name="NSS")
    private String nss;

    @Column(name="CLTIPOCONTACTOID_CORREO")
    private Integer tipoContactoCorreoId;

    @Column(name="CONTACTOPERSONAID_CORREO")
    private Integer tipoPersonaCorreoId;

    @Column(name="CORREO")
    private String correo;

    @Column(name="CLTIPOCONTACTOID_TELEFONO")
    private Integer tipoContactoTelefonoId;

    @Column(name="CONTACTOPERSONAID_TELEFONO")
    private Integer tipoPersonaTelefonoId;

    @Column(name="TELEFONO")
    private String telefono;

    @Column(name="FLAG")
    private Integer flag;
}
