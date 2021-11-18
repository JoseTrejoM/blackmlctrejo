/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "cmunicipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cmunicipios.findAll", query = "SELECT c FROM Cmunicipios c"),
    @NamedQuery(name = "Cmunicipios.findByMunicipioid", query = "SELECT c FROM Cmunicipios c WHERE c.municipioid = :municipioid"),
    @NamedQuery(name = "Cmunicipios.findByClavemunicipio", query = "SELECT c FROM Cmunicipios c WHERE c.clavemunicipio = :clavemunicipio"),
    @NamedQuery(name = "Cmunicipios.findByDescripcionmunicipio", query = "SELECT c FROM Cmunicipios c WHERE c.descripcionmunicipio = :descripcionmunicipio"),
    @NamedQuery(name = "Cmunicipios.findByFechaalta", query = "SELECT c FROM Cmunicipios c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cmunicipios.findByUsuarioalta", query = "SELECT c FROM Cmunicipios c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cmunicipios.findByFechamodificacion", query = "SELECT c FROM Cmunicipios c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cmunicipios.findByUsuariomodificacion", query = "SELECT c FROM Cmunicipios c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cmunicipios.findByActivo", query = "SELECT c FROM Cmunicipios c WHERE c.activo = :activo")})
public class Cmunicipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MUNICIPIOID")
    private Short municipioid;
    @Basic(optional = false)
    @Column(name = "CLAVEMUNICIPIO")
    private String clavemunicipio;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONMUNICIPIO")
    private String descripcionmunicipio;
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
    @OneToMany(mappedBy = "municipioid")
    private Collection<Tdomicilio> tdomicilioCollection;
    @JoinColumn(name = "ESTADOID", referencedColumnName = "ESTADOID")
    @ManyToOne(optional = false)
    private Cestados estadoid;

    public Cmunicipios() {
    }

    public Cmunicipios(Short municipioid) {
        this.municipioid = municipioid;
    }

    public Cmunicipios(Short municipioid, String clavemunicipio, String descripcionmunicipio, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.municipioid = municipioid;
        this.clavemunicipio = clavemunicipio;
        this.descripcionmunicipio = descripcionmunicipio;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Short getMunicipioid() {
        return municipioid;
    }

    public void setMunicipioid(Short municipioid) {
        this.municipioid = municipioid;
    }

    public String getClavemunicipio() {
        return clavemunicipio;
    }

    public void setClavemunicipio(String clavemunicipio) {
        this.clavemunicipio = clavemunicipio;
    }

    public String getDescripcionmunicipio() {
        return descripcionmunicipio;
    }

    public void setDescripcionmunicipio(String descripcionmunicipio) {
        this.descripcionmunicipio = descripcionmunicipio;
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

    @XmlTransient
    public Collection<Tdomicilio> getTdomicilioCollection() {
        return tdomicilioCollection;
    }

    public void setTdomicilioCollection(Collection<Tdomicilio> tdomicilioCollection) {
        this.tdomicilioCollection = tdomicilioCollection;
    }

    public Cestados getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(Cestados estadoid) {
        this.estadoid = estadoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioid != null ? municipioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cmunicipios)) {
            return false;
        }
        Cmunicipios other = (Cmunicipios) object;
        if ((this.municipioid == null && other.municipioid != null) || (this.municipioid != null && !this.municipioid.equals(other.municipioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cmunicipios[ municipioid=" + municipioid + " ]";
    }
    
}
