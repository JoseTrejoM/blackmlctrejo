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
@Table(name = "TPERIODOVIGENCIA")
public class PeriodoVigenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PERIODOVIGENCIAID")
    private Integer periodoVigenciaId;

    @Column(name="SERVICIOCONTRATADOID")
    private Integer servicioContratadoId;

    @Column(name="FECHAINICIO")
    private Date fechaInicio;

    @Column(name="FECHAFIN")
    private Date fechaFin;

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
