/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author Guillermo
 */
@Data
public class VpropuestaBeneficiariosBeneficiosPk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PROPUESTAID")
    private int propuestaid;
    @Id
    @Column(name = "TIPOBENEFICIARIOID")
    private int tipobeneficiarioid;
    @Id
    @Column(name = "BENEFICIOID")
    private Integer beneficioid;
}
