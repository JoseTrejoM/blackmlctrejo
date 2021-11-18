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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cpais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cpais.findAll", query = "SELECT c FROM Cpais c"),
    @NamedQuery(name = "Cpais.findByPaisid", query = "SELECT c FROM Cpais c WHERE c.paisid = :paisid"),
    @NamedQuery(name = "Cpais.findByClavepais", query = "SELECT c FROM Cpais c WHERE c.clavepais = :clavepais"),
    @NamedQuery(name = "Cpais.findByDescripcionpais", query = "SELECT c FROM Cpais c WHERE c.descripcionpais = :descripcionpais"),
    @NamedQuery(name = "Cpais.findByFechaalta", query = "SELECT c FROM Cpais c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cpais.findByUsuarioalta", query = "SELECT c FROM Cpais c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cpais.findByFechamodificacion", query = "SELECT c FROM Cpais c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cpais.findByUsuariomodificacion", query = "SELECT c FROM Cpais c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cpais.findByActivo", query = "SELECT c FROM Cpais c WHERE c.activo = :activo")})
public class Cpais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAISID")
    private Short paisid;
    @Basic(optional = false)
    @Column(name = "CLAVEPAIS")
    private String clavepais;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONPAIS")
    private String descripcionpais;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisid")
    private Collection<Tdomicilio> tdomicilioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisid")
    private Collection<Cbanco> cbancoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisid")
    private Collection<Cestados> cestadosCollection;

    public Cpais() {
    }

    public Cpais(Short paisid) {
        this.paisid = paisid;
    }

    public Cpais(Short paisid, String clavepais, String descripcionpais, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.paisid = paisid;
        this.clavepais = clavepais;
        this.descripcionpais = descripcionpais;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Short getPaisid() {
        return paisid;
    }

    public void setPaisid(Short paisid) {
        this.paisid = paisid;
    }

    public String getClavepais() {
        return clavepais;
    }

    public void setClavepais(String clavepais) {
        this.clavepais = clavepais;
    }

    public String getDescripcionpais() {
        return descripcionpais;
    }

    public void setDescripcionpais(String descripcionpais) {
        this.descripcionpais = descripcionpais;
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

    @XmlTransient
    public Collection<Cbanco> getCbancoCollection() {
        return cbancoCollection;
    }

    public void setCbancoCollection(Collection<Cbanco> cbancoCollection) {
        this.cbancoCollection = cbancoCollection;
    }

    @XmlTransient
    public Collection<Cestados> getCestadosCollection() {
        return cestadosCollection;
    }

    public void setCestadosCollection(Collection<Cestados> cestadosCollection) {
        this.cestadosCollection = cestadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisid != null ? paisid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpais)) {
            return false;
        }
        Cpais other = (Cpais) object;
        if ((this.paisid == null && other.paisid != null) || (this.paisid != null && !this.paisid.equals(other.paisid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cpais[ paisid=" + paisid + " ]";
    }
    
}
