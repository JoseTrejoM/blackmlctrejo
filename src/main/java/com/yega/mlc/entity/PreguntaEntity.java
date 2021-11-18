package com.yega.mlc.entity;

import java.io.Serializable;
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
@Table(name = "CPREGUNTAS")
public class PreguntaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PREGUNTAID")    
    private Integer preguntaId;

    @Column(name="CUESTIONARIOID")
    private Integer cuestionarioId;

    @Column(name="GRUPOPREGUNTASID")
    private Integer grupoPreguntasId;

    @Column(name="CLAVEPREGUNTA")
    private String clavePregunta;

    @Column(name="DESCRIPCIONPREGUNTA")
    private String descripcionPregunta;

    @Column(name="ORDEN")
    private Integer orden;

    @Column(name="FECHAALTA")
    private Date fechaAlta;

    @Column(name="USUARIOALTA")
    private Integer usuarioAlta;

    @Column(name="FECHAMODIFICACION")
    private Date fechaModificacion;

    @Column(name="USUARIOMODIFICACION")
    private Integer usuarioModificacion;
    
    @Column(name="ACTIVO")
    private Integer activo;

    public Integer getPreguntaId() {
        return preguntaId;
    }

    public String getDescripcionPregunta() {
        return descripcionPregunta;
    }

}
