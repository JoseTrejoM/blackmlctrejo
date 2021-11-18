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
@Table(name = "cestados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cestados.findAll", query = "SELECT c FROM Cestados c"),
    @NamedQuery(name = "Cestados.findByEstadoid", query = "SELECT c FROM Cestados c WHERE c.estadoid = :estadoid"),
    @NamedQuery(name = "Cestados.findByClaveestado", query = "SELECT c FROM Cestados c WHERE c.claveestado = :claveestado"),
    @NamedQuery(name = "Cestados.findByNombreestado", query = "SELECT c FROM Cestados c WHERE c.nombreestado = :nombreestado"),
    @NamedQuery(name = "Cestados.findByFechaalta", query = "SELECT c FROM Cestados c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cestados.findByUsuarioalta", query = "SELECT c FROM Cestados c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cestados.findByFechamodificacion", query = "SELECT c FROM Cestados c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cestados.findByUsuariomodificacion", query = "SELECT c FROM Cestados c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cestados.findByActivo", query = "SELECT c FROM Cestados c WHERE c.activo = :activo")})
public class Cestados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ESTADOID")
    private Short estadoid;
    @Basic(optional = false)
    @Column(name = "CLAVEESTADO")
    private String claveestado;
    @Basic(optional = false)
    @Column(name = "NOMBREESTADO")
    private String nombreestado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoid")
    private Collection<Tdomicilio> tdomicilioCollection;
    @JoinColumn(name = "PAISID", referencedColumnName = "PAISID")
    @ManyToOne(optional = false)
    private Cpais paisid;
    @OneToMany(mappedBy = "estadoid")
    private Collection<Restadoresidencia> restadoresidenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoid")
    private Collection<Cmunicipios> cmunicipiosCollection;

    public Cestados() {
    }

    public Cestados(Short estadoid) {
        this.estadoid = estadoid;
    }

    public Cestados(Short estadoid, String claveestado, String nombreestado, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.estadoid = estadoid;
        this.claveestado = claveestado;
        this.nombreestado = nombreestado;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Short getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(Short estadoid) {
        this.estadoid = estadoid;
    }

    public String getClaveestado() {
        return claveestado;
    }

    public void setClaveestado(String claveestado) {
        this.claveestado = claveestado;
    }

    public String getNombreestado() {
        return nombreestado;
    }

    public void setNombreestado(String nombreestado) {
        this.nombreestado = nombreestado;
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

    public Cpais getPaisid() {
        return paisid;
    }

    public void setPaisid(Cpais paisid) {
        this.paisid = paisid;
    }

    @XmlTransient
    public Collection<Restadoresidencia> getRestadoresidenciaCollection() {
        return restadoresidenciaCollection;
    }

    public void setRestadoresidenciaCollection(Collection<Restadoresidencia> restadoresidenciaCollection) {
        this.restadoresidenciaCollection = restadoresidenciaCollection;
    }

    @XmlTransient
    public Collection<Cmunicipios> getCmunicipiosCollection() {
        return cmunicipiosCollection;
    }

    public void setCmunicipiosCollection(Collection<Cmunicipios> cmunicipiosCollection) {
        this.cmunicipiosCollection = cmunicipiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoid != null ? estadoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cestados)) {
            return false;
        }
        Cestados other = (Cestados) object;
        if ((this.estadoid == null && other.estadoid != null) || (this.estadoid != null && !this.estadoid.equals(other.estadoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cestados[ estadoid=" + estadoid + " ]";
    }
    
}
