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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cbanco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cbanco.findAll", query = "SELECT c FROM Cbanco c"),
    @NamedQuery(name = "Cbanco.findByBancoid", query = "SELECT c FROM Cbanco c WHERE c.bancoid = :bancoid"),
    @NamedQuery(name = "Cbanco.findByClavebanco", query = "SELECT c FROM Cbanco c WHERE c.clavebanco = :clavebanco"),
    @NamedQuery(name = "Cbanco.findByDescripcionbanco", query = "SELECT c FROM Cbanco c WHERE c.descripcionbanco = :descripcionbanco"),
    @NamedQuery(name = "Cbanco.findByFechaalta", query = "SELECT c FROM Cbanco c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cbanco.findByUsuarioalta", query = "SELECT c FROM Cbanco c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cbanco.findByFechamodificacion", query = "SELECT c FROM Cbanco c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cbanco.findByUsuariomodificacion", query = "SELECT c FROM Cbanco c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cbanco.findByActivo", query = "SELECT c FROM Cbanco c WHERE c.activo = :activo")})
public class Cbanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BANCOID")
    private Integer bancoid;
    @Basic(optional = false)
    @Column(name = "CLAVEBANCO")
    private String clavebanco;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONBANCO")
    private String descripcionbanco;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bancoid")
    private Collection<Tcuentabancaria> tcuentabancariaCollection;
    @JoinColumn(name = "PAISID", referencedColumnName = "PAISID")
    @ManyToOne(optional = false)
    private Cpais paisid;

    public Cbanco() {
    }

    public Cbanco(Integer bancoid) {
        this.bancoid = bancoid;
    }

    public Cbanco(Integer bancoid, String clavebanco, String descripcionbanco, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.bancoid = bancoid;
        this.clavebanco = clavebanco;
        this.descripcionbanco = descripcionbanco;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getBancoid() {
        return bancoid;
    }

    public void setBancoid(Integer bancoid) {
        this.bancoid = bancoid;
    }

    public String getClavebanco() {
        return clavebanco;
    }

    public void setClavebanco(String clavebanco) {
        this.clavebanco = clavebanco;
    }

    public String getDescripcionbanco() {
        return descripcionbanco;
    }

    public void setDescripcionbanco(String descripcionbanco) {
        this.descripcionbanco = descripcionbanco;
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
    public Collection<Tcuentabancaria> getTcuentabancariaCollection() {
        return tcuentabancariaCollection;
    }

    public void setTcuentabancariaCollection(Collection<Tcuentabancaria> tcuentabancariaCollection) {
        this.tcuentabancariaCollection = tcuentabancariaCollection;
    }

    public Cpais getPaisid() {
        return paisid;
    }

    public void setPaisid(Cpais paisid) {
        this.paisid = paisid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bancoid != null ? bancoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbanco)) {
            return false;
        }
        Cbanco other = (Cbanco) object;
        if ((this.bancoid == null && other.bancoid != null) || (this.bancoid != null && !this.bancoid.equals(other.bancoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cbanco[ bancoid=" + bancoid + " ]";
    }
    
}
