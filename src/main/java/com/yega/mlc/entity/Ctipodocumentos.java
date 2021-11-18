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
@Table(name = "ctipodocumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctipodocumentos.findAll", query = "SELECT c FROM Ctipodocumentos c"),
    @NamedQuery(name = "Ctipodocumentos.findByTipodocumentosid", query = "SELECT c FROM Ctipodocumentos c WHERE c.tipodocumentosid = :tipodocumentosid"),
    @NamedQuery(name = "Ctipodocumentos.findByNombre", query = "SELECT c FROM Ctipodocumentos c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ctipodocumentos.findByExtensiones", query = "SELECT c FROM Ctipodocumentos c WHERE c.extensiones = :extensiones"),
    @NamedQuery(name = "Ctipodocumentos.findByIniciales", query = "SELECT c FROM Ctipodocumentos c WHERE c.iniciales = :iniciales"),
    @NamedQuery(name = "Ctipodocumentos.findByOrden", query = "SELECT c FROM Ctipodocumentos c WHERE c.orden = :orden"),
    @NamedQuery(name = "Ctipodocumentos.findByRutadocumentos", query = "SELECT c FROM Ctipodocumentos c WHERE c.rutadocumentos = :rutadocumentos"),
    @NamedQuery(name = "Ctipodocumentos.findByFechaalta", query = "SELECT c FROM Ctipodocumentos c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Ctipodocumentos.findByUsuarioalta", query = "SELECT c FROM Ctipodocumentos c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Ctipodocumentos.findByFechamodificacion", query = "SELECT c FROM Ctipodocumentos c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Ctipodocumentos.findByUsuariomodificacion", query = "SELECT c FROM Ctipodocumentos c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Ctipodocumentos.findByActivo", query = "SELECT c FROM Ctipodocumentos c WHERE c.activo = :activo")})
public class Ctipodocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPODOCUMENTOSID")
    private Integer tipodocumentosid;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "EXTENSIONES")
    private String extensiones;
    @Column(name = "INICIALES")
    private String iniciales;
    @Column(name = "ORDEN")
    private Integer orden;
    @Basic(optional = false)
    @Column(name = "RUTADOCUMENTOS")
    private String rutadocumentos;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodocumentosid")
    private Collection<Tcontroldocumentos> tcontroldocumentosCollection;

    public Ctipodocumentos() {
    }

    public Ctipodocumentos(Integer tipodocumentosid) {
        this.tipodocumentosid = tipodocumentosid;
    }

    public Ctipodocumentos(Integer tipodocumentosid, String nombre, String extensiones, String rutadocumentos, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.tipodocumentosid = tipodocumentosid;
        this.nombre = nombre;
        this.extensiones = extensiones;
        this.rutadocumentos = rutadocumentos;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getTipodocumentosid() {
        return tipodocumentosid;
    }

    public void setTipodocumentosid(Integer tipodocumentosid) {
        this.tipodocumentosid = tipodocumentosid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtensiones() {
        return extensiones;
    }

    public void setExtensiones(String extensiones) {
        this.extensiones = extensiones;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getRutadocumentos() {
        return rutadocumentos;
    }

    public void setRutadocumentos(String rutadocumentos) {
        this.rutadocumentos = rutadocumentos;
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
    public Collection<Tcontroldocumentos> getTcontroldocumentosCollection() {
        return tcontroldocumentosCollection;
    }

    public void setTcontroldocumentosCollection(Collection<Tcontroldocumentos> tcontroldocumentosCollection) {
        this.tcontroldocumentosCollection = tcontroldocumentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipodocumentosid != null ? tipodocumentosid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctipodocumentos)) {
            return false;
        }
        Ctipodocumentos other = (Ctipodocumentos) object;
        if ((this.tipodocumentosid == null && other.tipodocumentosid != null) || (this.tipodocumentosid != null && !this.tipodocumentosid.equals(other.tipodocumentosid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Ctipodocumentos[ tipodocumentosid=" + tipodocumentosid + " ]";
    }
    
}
