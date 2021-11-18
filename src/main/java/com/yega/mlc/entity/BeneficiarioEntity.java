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
@Table(name = "TBENEFICIARIO")
public class BeneficiarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BENEFICIARIOID")
    private Integer beneficiarioId;

    @Column(name="PERSONAID")
    private Integer personaId;

    @Column(name="PROPUESTAID")
    private Integer propuestaId;

    @Column(name="TIPOBENEFICIARIOID")
    private Integer tipoBeneficiarioId;

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
