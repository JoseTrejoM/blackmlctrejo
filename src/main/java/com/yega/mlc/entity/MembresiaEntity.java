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
@Table(name = "TMEMBRESIA")
public class MembresiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEMBRESIAID")
    private Integer membresiaId;

    @Column(name="PROPUESTAID")
    private Integer propuestaId;
    
    @Column(name="CLESTATUSMEMBRESIAID")
    private Integer estatusMembresiaId;

    @Column(name="NUMMEMBRESIA")
    private String numMembresia;

    @Column(name="CONSECUTIVO")
    private Integer consecutivo;

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
