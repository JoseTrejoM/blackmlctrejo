/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Guillermo
 */
@Entity
@Embeddable
@Immutable
@Data
@ToString
@Table(name = "vpropuesta_cuestionario")
public class VpropuestaCuestionario implements Serializable
{
    private static final long serialVersionUID = -1810670811972499621L;

    @Column(name = "PROPUESTAID")
    private Integer propuestaid;

    @Column(name = "BENEFICIARIOID")
    private Integer beneficiarioid;

    @Column(name = "SERVICIOBENEFICIARIOID")
    private Integer serviciobeneficiarioid;

    @Id
    @Column(name = "PREGUNTAID")
    private Integer preguntaid;

    @Column(name = "DESCRIPCIONPREGUNTA")
    private String descripcionpregunta;

    @Column(name = "RESPUESTAID")
    private Integer respuestaid;

    @Column(name = "RESPUESTA")
    private String respuesta;
}
