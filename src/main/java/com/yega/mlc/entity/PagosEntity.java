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
@Table(name = "TPAGOS")
public class PagosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PAGOID")
    private Integer pagoId;

    @Column(name="MEMBRESIAID")
    private Integer membresiaId;

    @Column(name="VIGENCIAID")
    private Integer vigenciaId;

    @Column(name="CLMONEDAPAGOID")
    private Integer monedaPagoId;

    @Column(name="CLFORMAPAGOID")
    private Integer formaPagoId;

    @Column(name="MONTOPAGO")
    private Double montoPago;

    @Column(name="FECHAPAGO")
    private Date fechaPago;

    @Column(name="REFERENCIA")
    private String referencia;

    @Column(name="TRANSACCION")
    private String transaccion;

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
