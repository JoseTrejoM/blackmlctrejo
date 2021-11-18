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
@Table(name = "TCONTACTOPERSONA")
public class ContactoPersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CONTACTOPERSONAID")
    private Integer contactoPersonaId;

    @Column(name="PERSONAID")
    private Integer personaId;

    @Column(name="CLTIPOCONTACTOID")
    private Integer tipoContactoId;

    @Column(name="CONTACTO")
    private String contacto;

    @Column(name="PRINCIPAL")
    private Boolean principal;

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
