/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import org.hibernate.annotations.Immutable;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Entity
@Immutable
@IdClass(VbeneficiosBeneficiarios.class)
@Table(name = "vbeneficios_beneficiarios")
public class VbeneficiosBeneficiarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BENEFICIOID")
    private int beneficioid;
    @Basic(optional = false)
    @Column(name = "TITULOBENEFICIO")
    private String titulobeneficio;
    @Column(name = "SUBTITULOBENEFICIO")
    private String subtitulobeneficio;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONBENEFICIO")
    private String descripcionbeneficio;
    @Id
    @Basic(optional = false)
    @Column(name = "CLTIPOBENEFICIARIOID")
    private int tipobeneficiarioid;
    @Basic(optional = false)
    @Column(name = "TIPOBENEFICIARIO")
    private String tipobeneficiario;
    @Basic(optional = false)
    @Column(name = "IMAGENACTIVO")
    private String imagenactivo;
    @Basic(optional = false)
    @Column(name = "IMAGENINACTIVO")
    private String imageninactivo;
    @Basic(optional = false)
    @Column(name = "IMAGENDEFAULT")
    private String imagendefault;
    @Basic(optional = false)
    @Column(name = "ESSELECCIONADO")
    private boolean esseleccionado;

    public VbeneficiosBeneficiarios() {
    }

    public int getBeneficioid() {
        return beneficioid;
    }

    public void setBeneficioid(int beneficioid) {
        this.beneficioid = beneficioid;
    }

    public String getTitulobeneficio() {
        return titulobeneficio;
    }

    public void setTitulobeneficio(String titulobeneficio) {
        this.titulobeneficio = titulobeneficio;
    }

    public String getSubtitulobeneficio() {
        return subtitulobeneficio;
    }

    public void setSubtitulobeneficio(String subtitulobeneficio) {
        this.subtitulobeneficio = subtitulobeneficio;
    }

    public String getDescripcionbeneficio() {
        return descripcionbeneficio;
    }

    public void setDescripcionbeneficio(String descripcionbeneficio) {
        this.descripcionbeneficio = descripcionbeneficio;
    }

    public int getTipobeneficiarioid() {
        return tipobeneficiarioid;
    }

    public void setTipobeneficiarioid(int tipobeneficiarioid) {
        this.tipobeneficiarioid = tipobeneficiarioid;
    }

    public String getTipobeneficiario() {
        return tipobeneficiario;
    }

    public void setTipobeneficiario(String tipobeneficiario) {
        this.tipobeneficiario = tipobeneficiario;
    }

    public String getImagenactivo() {
        return imagenactivo;
    }

    public void setImagenactivo(String imagenactivo) {
        this.imagenactivo = imagenactivo;
    }

    public String getImageninactivo() {
        return imageninactivo;
    }

    public void setImageninactivo(String imageninactivo) {
        this.imageninactivo = imageninactivo;
    }

    public String getImagendefault() {
        return imagendefault;
    }

    public void setImagendefault(String imagendefault) {
        this.imagendefault = imagendefault;
    }

    public boolean getEsseleccionado() {
        return esseleccionado;
    }

    public void setEsseleccionado(boolean esseleccionado) {
        this.esseleccionado = esseleccionado;
    }
    
}
