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
@Table(name = "cmaestro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cmaestro.findAll", query = "SELECT c FROM Cmaestro c"),
    @NamedQuery(name = "Cmaestro.findByCatalogomaestroid", query = "SELECT c FROM Cmaestro c WHERE c.catalogomaestroid = :catalogomaestroid"),
    @NamedQuery(name = "Cmaestro.findByNombre", query = "SELECT c FROM Cmaestro c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cmaestro.findByDescripcion", query = "SELECT c FROM Cmaestro c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cmaestro.findByFechaalta", query = "SELECT c FROM Cmaestro c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cmaestro.findByUsuarioalta", query = "SELECT c FROM Cmaestro c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cmaestro.findByFechamodificacion", query = "SELECT c FROM Cmaestro c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cmaestro.findByUsuariomodificacion", query = "SELECT c FROM Cmaestro c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cmaestro.findByActivo", query = "SELECT c FROM Cmaestro c WHERE c.activo = :activo")})
public class Cmaestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATALOGOMAESTROID")
    private Integer catalogomaestroid;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogomaestroid")
    private Collection<Cmaestrodetalle> cmaestrodetalleCollection;

    public Cmaestro() {
    }

    public Cmaestro(Integer catalogomaestroid) {
        this.catalogomaestroid = catalogomaestroid;
    }

    public Cmaestro(Integer catalogomaestroid, String nombre, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.catalogomaestroid = catalogomaestroid;
        this.nombre = nombre;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getCatalogomaestroid() {
        return catalogomaestroid;
    }

    public void setCatalogomaestroid(Integer catalogomaestroid) {
        this.catalogomaestroid = catalogomaestroid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public Collection<Cmaestrodetalle> getCmaestrodetalleCollection() {
        return cmaestrodetalleCollection;
    }

    public void setCmaestrodetalleCollection(Collection<Cmaestrodetalle> cmaestrodetalleCollection) {
        this.cmaestrodetalleCollection = cmaestrodetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogomaestroid != null ? catalogomaestroid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cmaestro)) {
            return false;
        }
        Cmaestro other = (Cmaestro) object;
        if ((this.catalogomaestroid == null && other.catalogomaestroid != null) || (this.catalogomaestroid != null && !this.catalogomaestroid.equals(other.catalogomaestroid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cmaestro[ catalogomaestroid=" + catalogomaestroid + " ]";
    }
    
}
