/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "tdomicilio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tdomicilio.findAll", query = "SELECT t FROM Tdomicilio t"),
    @NamedQuery(name = "Tdomicilio.findByDomicilioid", query = "SELECT t FROM Tdomicilio t WHERE t.domicilioid = :domicilioid"),
    @NamedQuery(name = "Tdomicilio.findByCalle", query = "SELECT t FROM Tdomicilio t WHERE t.calle = :calle"),
    @NamedQuery(name = "Tdomicilio.findByNumeroexterior", query = "SELECT t FROM Tdomicilio t WHERE t.numeroexterior = :numeroexterior"),
    @NamedQuery(name = "Tdomicilio.findByNumerointerior", query = "SELECT t FROM Tdomicilio t WHERE t.numerointerior = :numerointerior"),
    @NamedQuery(name = "Tdomicilio.findByColonia", query = "SELECT t FROM Tdomicilio t WHERE t.colonia = :colonia"),
    @NamedQuery(name = "Tdomicilio.findByCiudad", query = "SELECT t FROM Tdomicilio t WHERE t.ciudad = :ciudad"),
    @NamedQuery(name = "Tdomicilio.findByCodigopostal", query = "SELECT t FROM Tdomicilio t WHERE t.codigopostal = :codigopostal"),
    @NamedQuery(name = "Tdomicilio.findByFechaalta", query = "SELECT t FROM Tdomicilio t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tdomicilio.findByUsuarioalta", query = "SELECT t FROM Tdomicilio t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tdomicilio.findByFechamodificacion", query = "SELECT t FROM Tdomicilio t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tdomicilio.findByUsuariomodificacion", query = "SELECT t FROM Tdomicilio t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tdomicilio.findByActivo", query = "SELECT t FROM Tdomicilio t WHERE t.activo = :activo")})
public class Tdomicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DOMICILIOID")
    private Integer domicilioid;
    @Basic(optional = false)
    @Column(name = "CALLE")
    private String calle;
    @Basic(optional = false)
    @Column(name = "NUMEROEXTERIOR")
    private String numeroexterior;
    @Column(name = "NUMEROINTERIOR")
    private String numerointerior;
    @Basic(optional = false)
    @Column(name = "COLONIA")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;
    @Basic(optional = false)
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Basic(optional = false)
    @Column(name = "USUARIOALTA")
    private int usuarioalta;
    @Basic(optional = false)
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "USUARIOMODIFICACION")
    private Integer usuariomodificacion;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private boolean activo;
    @JoinColumn(name = "ESTADOID", referencedColumnName = "ESTADOID")
    @ManyToOne(optional = false)
    private Cestados estadoid;
    @JoinColumn(name = "CLTIPODOMICILIOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne
    private Cmaestrodetalle cltipodomicilioid;
    @JoinColumn(name = "MUNICIPIOID", referencedColumnName = "MUNICIPIOID")
    @ManyToOne
    private Cmunicipios municipioid;
    @JoinColumn(name = "PAISID", referencedColumnName = "PAISID")
    @ManyToOne(optional = false)
    private Cpais paisid;
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne(optional = false)
    private Tpersona personaid;

    public Tdomicilio() {
    }

    public Tdomicilio(Integer domicilioid) {
        this.domicilioid = domicilioid;
    }

    public Tdomicilio(Integer domicilioid, String calle, String numeroexterior, String colonia, String ciudad, String codigopostal, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.domicilioid = domicilioid;
        this.calle = calle;
        this.numeroexterior = numeroexterior;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.codigopostal = codigopostal;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getDomicilioid() {
        return domicilioid;
    }

    public void setDomicilioid(Integer domicilioid) {
        this.domicilioid = domicilioid;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroexterior() {
        return numeroexterior;
    }

    public void setNumeroexterior(String numeroexterior) {
        this.numeroexterior = numeroexterior;
    }

    public String getNumerointerior() {
        return numerointerior;
    }

    public void setNumerointerior(String numerointerior) {
        this.numerointerior = numerointerior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public int getUsuarioalta() {
        return usuarioalta;
    }

    public void setUsuarioalta(int usuarioalta) {
        this.usuarioalta = usuarioalta;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Integer getUsuariomodificacion() {
        return usuariomodificacion;
    }

    public void setUsuariomodificacion(Integer usuariomodificacion) {
        this.usuariomodificacion = usuariomodificacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Cestados getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(Cestados estadoid) {
        this.estadoid = estadoid;
    }

    public Cmaestrodetalle getCltipodomicilioid() {
        return cltipodomicilioid;
    }

    public void setCltipodomicilioid(Cmaestrodetalle cltipodomicilioid) {
        this.cltipodomicilioid = cltipodomicilioid;
    }

    public Cmunicipios getMunicipioid() {
        return municipioid;
    }

    public void setMunicipioid(Cmunicipios municipioid) {
        this.municipioid = municipioid;
    }

    public Cpais getPaisid() {
        return paisid;
    }

    public void setPaisid(Cpais paisid) {
        this.paisid = paisid;
    }

    public Tpersona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Tpersona personaid) {
        this.personaid = personaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domicilioid != null ? domicilioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tdomicilio)) {
            return false;
        }
        Tdomicilio other = (Tdomicilio) object;
        if ((this.domicilioid == null && other.domicilioid != null) || (this.domicilioid != null && !this.domicilioid.equals(other.domicilioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tdomicilio[ domicilioid=" + domicilioid + " ]";
    }
    
}
