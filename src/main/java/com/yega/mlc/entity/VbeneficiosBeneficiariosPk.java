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

@Data
public class VbeneficiosBeneficiariosPk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BENEFICIOID")
    private int beneficioid;
    @Id
    @Column(name = "CLTIPOBENEFICIARIOID")
    private int tipobeneficiarioid;
}
