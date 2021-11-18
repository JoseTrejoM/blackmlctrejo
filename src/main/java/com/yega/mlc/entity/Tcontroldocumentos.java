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
import javax.persistence.JoinColumns;
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
@Table(name = "tcontroldocumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcontroldocumentos.findAll", query = "SELECT t FROM Tcontroldocumentos t"),
    @NamedQuery(name = "Tcontroldocumentos.findByControldocumentoid", query = "SELECT t FROM Tcontroldocumentos t WHERE t.controldocumentoid = :controldocumentoid"),
    @NamedQuery(name = "Tcontroldocumentos.findByNombre", query = "SELECT t FROM Tcontroldocumentos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tcontroldocumentos.findByUltimaversion", query = "SELECT t FROM Tcontroldocumentos t WHERE t.ultimaversion = :ultimaversion"),
    @NamedQuery(name = "Tcontroldocumentos.findByDescripciondocumento", query = "SELECT t FROM Tcontroldocumentos t WHERE t.descripciondocumento = :descripciondocumento"),
    @NamedQuery(name = "Tcontroldocumentos.findByRutadocumentos", query = "SELECT t FROM Tcontroldocumentos t WHERE t.rutadocumentos = :rutadocumentos"),
    @NamedQuery(name = "Tcontroldocumentos.findByFechaalta", query = "SELECT t FROM Tcontroldocumentos t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tcontroldocumentos.findByUsuarioalta", query = "SELECT t FROM Tcontroldocumentos t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tcontroldocumentos.findByFechamodificacion", query = "SELECT t FROM Tcontroldocumentos t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tcontroldocumentos.findByUsuariomodificacion", query = "SELECT t FROM Tcontroldocumentos t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tcontroldocumentos.findByActivo", query = "SELECT t FROM Tcontroldocumentos t WHERE t.activo = :activo")})
public class Tcontroldocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTROLDOCUMENTOID")
    private Integer controldocumentoid;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ULTIMAVERSION")
    private short ultimaversion;
    @Column(name = "DESCRIPCIONDOCUMENTO")
    private String descripciondocumento;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcontroldocumentos")
    private Collection<Tdocumentos> tdocumentosCollection;
    @JoinColumn(name = "TIPODOCUMENTOSID", referencedColumnName = "TIPODOCUMENTOSID")
    @ManyToOne(optional = false)
    private Ctipodocumentos tipodocumentosid;
    @JoinColumns({
        @JoinColumn(name = "FOLIOID", referencedColumnName = "FOLIOID"),
        @JoinColumn(name = "SISMODID", referencedColumnName = "SISMODID"),
        @JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")})
    @ManyToOne(optional = false)
    private Rmodulodocumento rmodulodocumento;

    public Tcontroldocumentos() {
    }

    public Tcontroldocumentos(Integer controldocumentoid) {
        this.controldocumentoid = controldocumentoid;
    }

    public Tcontroldocumentos(Integer controldocumentoid, String nombre, short ultimaversion, String rutadocumentos, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.controldocumentoid = controldocumentoid;
        this.nombre = nombre;
        this.ultimaversion = ultimaversion;
        this.rutadocumentos = rutadocumentos;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getControldocumentoid() {
        return controldocumentoid;
    }

    public void setControldocumentoid(Integer controldocumentoid) {
        this.controldocumentoid = controldocumentoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getUltimaversion() {
        return ultimaversion;
    }

    public void setUltimaversion(short ultimaversion) {
        this.ultimaversion = ultimaversion;
    }

    public String getDescripciondocumento() {
        return descripciondocumento;
    }

    public void setDescripciondocumento(String descripciondocumento) {
        this.descripciondocumento = descripciondocumento;
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
    public Collection<Tdocumentos> getTdocumentosCollection() {
        return tdocumentosCollection;
    }

    public void setTdocumentosCollection(Collection<Tdocumentos> tdocumentosCollection) {
        this.tdocumentosCollection = tdocumentosCollection;
    }

    public Ctipodocumentos getTipodocumentosid() {
        return tipodocumentosid;
    }

    public void setTipodocumentosid(Ctipodocumentos tipodocumentosid) {
        this.tipodocumentosid = tipodocumentosid;
    }

    public Rmodulodocumento getRmodulodocumento() {
        return rmodulodocumento;
    }

    public void setRmodulodocumento(Rmodulodocumento rmodulodocumento) {
        this.rmodulodocumento = rmodulodocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (controldocumentoid != null ? controldocumentoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcontroldocumentos)) {
            return false;
        }
        Tcontroldocumentos other = (Tcontroldocumentos) object;
        if ((this.controldocumentoid == null && other.controldocumentoid != null) || (this.controldocumentoid != null && !this.controldocumentoid.equals(other.controldocumentoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tcontroldocumentos[ controldocumentoid=" + controldocumentoid + " ]";
    }
    
}
