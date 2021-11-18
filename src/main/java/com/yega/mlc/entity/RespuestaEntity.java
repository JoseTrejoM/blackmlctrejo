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
@Table(name = "TRESPUESTA")
public class RespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RESPUESTAID")    
    private Integer respuestaId;

    @Column(name="PREGUNTAID")
    private Integer preguntaId;

    @Column(name="SERVICIOBENEFICIARIOID")
    private Integer servicioBeneficiarioId;

    @Column(name="RESPUESTA")
    private String respuesta;

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
