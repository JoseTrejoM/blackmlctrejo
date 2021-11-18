package com.yega.mlc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TPROPUESTA")
public class PropuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PROPUESTAID")
    private Integer propuestaId;

    @Column(name="ENLACEID")
    private Integer enlaceId;

    @Column(name="FECHAAUTORIZACION")
    private Date fechaAutorizacion;

    @Column(name="CLESTATUSPROPUESTAID")
    private Integer estatusPropuestaId;

    @Column(name="CURP")
    private String curp;

    @Column(name="ESMENOR56")
    private Boolean esMenor56;

    @Column(name="ACUERDOCURP")
    private Boolean acuerdoCurp;

    @Column(name="FECHAFINPROPUESTA")
    private Date fechaFinPropuesta;

    @Column(name="FECHAALTA")
    private Date fechaAlta;

    @Column(name="USUARIOALTA")
    private Integer usuarioAlta;

    @Column(name="FECHAMODIFICACION")
    private Date fechaModificacion;

    @Column(name="USUARIOMODIFICACION")
    private Integer usuarioModificacion;

    @Column(name="ACTIVO")
    private Boolean activo;
}
