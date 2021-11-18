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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tdocumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tdocumentos.findAll", query = "SELECT t FROM Tdocumentos t"),
    @NamedQuery(name = "Tdocumentos.findByDocumentosid", query = "SELECT t FROM Tdocumentos t WHERE t.tdocumentosPK.documentosid = :documentosid"),
    @NamedQuery(name = "Tdocumentos.findByControldocumentoid", query = "SELECT t FROM Tdocumentos t WHERE t.tdocumentosPK.controldocumentoid = :controldocumentoid"),
    @NamedQuery(name = "Tdocumentos.findByNombrelogico", query = "SELECT t FROM Tdocumentos t WHERE t.nombrelogico = :nombrelogico"),
    @NamedQuery(name = "Tdocumentos.findByNombrereal", query = "SELECT t FROM Tdocumentos t WHERE t.nombrereal = :nombrereal"),
    @NamedQuery(name = "Tdocumentos.findByTamano", query = "SELECT t FROM Tdocumentos t WHERE t.tamano = :tamano"),
    @NamedQuery(name = "Tdocumentos.findByDescripciondocumento", query = "SELECT t FROM Tdocumentos t WHERE t.descripciondocumento = :descripciondocumento"),
    @NamedQuery(name = "Tdocumentos.findByFechaAlta", query = "SELECT t FROM Tdocumentos t WHERE t.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "Tdocumentos.findByUsuarioalta", query = "SELECT t FROM Tdocumentos t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tdocumentos.findByFechamodificacion", query = "SELECT t FROM Tdocumentos t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tdocumentos.findByUsuariomodificacion", query = "SELECT t FROM Tdocumentos t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tdocumentos.findByActivo", query = "SELECT t FROM Tdocumentos t WHERE t.activo = :activo")})
public class Tdocumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TdocumentosPK tdocumentosPK;
    @Basic(optional = false)
    @Column(name = "NOMBRELOGICO")
    private String nombrelogico;
    @Basic(optional = false)
    @Column(name = "NOMBREREAL")
    private String nombrereal;
    @Basic(optional = false)
    @Column(name = "TAMANO")
    private long tamano;
    @Column(name = "DESCRIPCIONDOCUMENTO")
    private String descripciondocumento;
    @Basic(optional = false)
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
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
    @JoinColumn(name = "CONTROLDOCUMENTOID", referencedColumnName = "CONTROLDOCUMENTOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tcontroldocumentos tcontroldocumentos;

    public Tdocumentos() {
    }

    public Tdocumentos(TdocumentosPK tdocumentosPK) {
        this.tdocumentosPK = tdocumentosPK;
    }

    public Tdocumentos(TdocumentosPK tdocumentosPK, String nombrelogico, String nombrereal, long tamano, Date fechaAlta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.tdocumentosPK = tdocumentosPK;
        this.nombrelogico = nombrelogico;
        this.nombrereal = nombrereal;
        this.tamano = tamano;
        this.fechaAlta = fechaAlta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Tdocumentos(int documentosid, int controldocumentoid) {
        this.tdocumentosPK = new TdocumentosPK(documentosid, controldocumentoid);
    }

    public TdocumentosPK getTdocumentosPK() {
        return tdocumentosPK;
    }

    public void setTdocumentosPK(TdocumentosPK tdocumentosPK) {
        this.tdocumentosPK = tdocumentosPK;
    }

    public String getNombrelogico() {
        return nombrelogico;
    }

    public void setNombrelogico(String nombrelogico) {
        this.nombrelogico = nombrelogico;
    }

    public String getNombrereal() {
        return nombrereal;
    }

    public void setNombrereal(String nombrereal) {
        this.nombrereal = nombrereal;
    }

    public long getTamano() {
        return tamano;
    }

    public void setTamano(long tamano) {
        this.tamano = tamano;
    }

    public String getDescripciondocumento() {
        return descripciondocumento;
    }

    public void setDescripciondocumento(String descripciondocumento) {
        this.descripciondocumento = descripciondocumento;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
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

    public Tcontroldocumentos getTcontroldocumentos() {
        return tcontroldocumentos;
    }

    public void setTcontroldocumentos(Tcontroldocumentos tcontroldocumentos) {
        this.tcontroldocumentos = tcontroldocumentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdocumentosPK != null ? tdocumentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tdocumentos)) {
            return false;
        }
        Tdocumentos other = (Tdocumentos) object;
        if ((this.tdocumentosPK == null && other.tdocumentosPK != null) || (this.tdocumentosPK != null && !this.tdocumentosPK.equals(other.tdocumentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tdocumentos[ tdocumentosPK=" + tdocumentosPK + " ]";
    }
    
}
