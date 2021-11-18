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
@Table(name = "TSERVICIOSCONTRATADOS")
public class ServicioContratadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SERVICIOCONTRATADOID")
    private Integer servicioContratadoId;

    @Column(name="CLFRECUENCIAPAGOID")
    private Integer frecuenciaPagoId;

    @Column(name="PROPUESTAID")
    private Integer propuestaId;

    @Column(name="TIPOPLANID")
    private Integer tipoPlanId;

    @Column(name="CLFORMAPAGOID")
    private Integer formaPagoId;

    @Column(name="FECHAALTA")
    private Date fechaAlta;

    @Column(name="USUARIOALTA")
    private int usuarioAlta;

    @Column(name="FECHAMODIFICACION")
    private Date fechaModificacion;

    @Column(name="USUARIOMODIFICACION")
    private Integer usuarioModificacion;

    @Column(name="ACTIVO")
    private Boolean activo;
}
