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
@Table(name = "RSERVICIOBENEFICIARIO")
public class ServicioBeneficiarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SERVICIOBENEFICIARIOID")
    private Integer servicioBeneficiarioId;

    @Column(name="BENEFICIARIOID")
    private Integer beneficiarioId;

    @Column(name="SERVICIOCONTRATADOID")
    private Integer servicioContratadoId;

    @Column(name="BENEFICIOID")
    private Integer beneficioId;

    @Column(name="PORCENTAJE")
    private Integer porcentaje;

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
}
