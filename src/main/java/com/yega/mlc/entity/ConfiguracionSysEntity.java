package com.yega.mlc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TCONFIGURACION")
public class ConfiguracionSysEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CONFIGURACIONID")
    private Integer configuracionId;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="VALOR")
    private String valor;
}
