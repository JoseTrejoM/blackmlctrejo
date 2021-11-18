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
@Table(name = "TPERSONA")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSONAID")
    private Integer personaId;

    @Column(name = "CLTIPOPERSONAID")
    private Integer tipoPersonaId;

    @Column(name = "FECHAALTA")
    private Date fechaAlta;

    @Column(name = "FECHABAJA")
    private Date fechaBaja;

    @Column(name = "RFC")
    private String rfc;

    @Column(name = "ACTIVO")
    private Boolean activo;
}
