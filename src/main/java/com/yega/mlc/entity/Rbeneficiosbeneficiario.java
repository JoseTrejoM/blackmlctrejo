/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "rbeneficiosbeneficiario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rbeneficiosbeneficiario.findAll", query = "SELECT r FROM Rbeneficiosbeneficiario r"),
    @NamedQuery(name = "Rbeneficiosbeneficiario.findByBeneficiobeneficiarioid", query = "SELECT r FROM Rbeneficiosbeneficiario r WHERE r.beneficiobeneficiarioid = :beneficiobeneficiarioid"),
    @NamedQuery(name = "Rbeneficiosbeneficiario.findByImagenactivo", query = "SELECT r FROM Rbeneficiosbeneficiario r WHERE r.imagenactivo = :imagenactivo"),
    @NamedQuery(name = "Rbeneficiosbeneficiario.findByImageninactivo", query = "SELECT r FROM Rbeneficiosbeneficiario r WHERE r.imageninactivo = :imageninactivo"),
    @NamedQuery(name = "Rbeneficiosbeneficiario.findByImagendefault", query = "SELECT r FROM Rbeneficiosbeneficiario r WHERE r.imagendefault = :imagendefault"),
    @NamedQuery(name = "Rbeneficiosbeneficiario.findByEsseleccionado", query = "SELECT r FROM Rbeneficiosbeneficiario r WHERE r.esseleccionado = :esseleccionado")})
public class Rbeneficiosbeneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BENEFICIOBENEFICIARIOID")
    private Integer beneficiobeneficiarioid;
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

    @JsonManagedReference
    @JoinColumn(name = "BENEFICIOID", referencedColumnName = "BENEFICIOID")
    @ManyToOne
    private Cbeneficios beneficioid;


    @JsonManagedReference
    @JoinColumn(name = "CLTIPOBENEFICIARIOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle cltipobeneficiarioid;

    public Rbeneficiosbeneficiario() {
    }

    public Rbeneficiosbeneficiario(Integer beneficiobeneficiarioid) {
        this.beneficiobeneficiarioid = beneficiobeneficiarioid;
    }

    public Rbeneficiosbeneficiario(Integer beneficiobeneficiarioid, String imagenactivo, String imageninactivo, String imagendefault, boolean esseleccionado) {
        this.beneficiobeneficiarioid = beneficiobeneficiarioid;
        this.imagenactivo = imagenactivo;
        this.imageninactivo = imageninactivo;
        this.imagendefault = imagendefault;
        this.esseleccionado = esseleccionado;
    }

    public Integer getBeneficiobeneficiarioid() {
        return beneficiobeneficiarioid;
    }

    public void setBeneficiobeneficiarioid(Integer beneficiobeneficiarioid) {
        this.beneficiobeneficiarioid = beneficiobeneficiarioid;
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

    public Cbeneficios getBeneficioid() {
        return beneficioid;
    }

    public void setBeneficioid(Cbeneficios beneficioid) {
        this.beneficioid = beneficioid;
    }

    public Cmaestrodetalle getCltipobeneficiarioid() {
        return cltipobeneficiarioid;
    }

    public void setCltipobeneficiarioid(Cmaestrodetalle cltipobeneficiarioid) {
        this.cltipobeneficiarioid = cltipobeneficiarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beneficiobeneficiarioid != null ? beneficiobeneficiarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rbeneficiosbeneficiario)) {
            return false;
        }
        Rbeneficiosbeneficiario other = (Rbeneficiosbeneficiario) object;
        if ((this.beneficiobeneficiarioid == null && other.beneficiobeneficiarioid != null) || (this.beneficiobeneficiarioid != null && !this.beneficiobeneficiarioid.equals(other.beneficiobeneficiarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Rbeneficiosbeneficiario[ beneficiobeneficiarioid=" + beneficiobeneficiarioid + " ]";
    }
    
}
