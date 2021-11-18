package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CCUESTIONARIO")
public class CuestionarioEntity implements Serializable {

    @Id
    @Column(name="CUESTIONARIOID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuestionarioId;

    @Column(name="CLAVECUESTIONARIO")
    private String claveCuestionario;

    @Column(name="DESCRIPCIONCUESTIONARIO")
    private String descripcionCuestionario;

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

    @OneToMany
    @JoinColumn(name = "CUESTIONARIOID", referencedColumnName = "CUESTIONARIOID")
    private List<PreguntaEntity> preguntas;

    public List<PreguntaEntity> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaEntity> preguntas) {
        this.preguntas = preguntas;
    }


}
