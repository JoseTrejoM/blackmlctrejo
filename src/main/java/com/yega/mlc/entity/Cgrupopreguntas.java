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
@Table(name = "cgrupopreguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cgrupopreguntas.findAll", query = "SELECT c FROM Cgrupopreguntas c"),
    @NamedQuery(name = "Cgrupopreguntas.findByGrupopreguntasid", query = "SELECT c FROM Cgrupopreguntas c WHERE c.grupopreguntasid = :grupopreguntasid"),
    @NamedQuery(name = "Cgrupopreguntas.findByClavegrupopreguntas", query = "SELECT c FROM Cgrupopreguntas c WHERE c.clavegrupopreguntas = :clavegrupopreguntas"),
    @NamedQuery(name = "Cgrupopreguntas.findByDescripciongrupopreguntas", query = "SELECT c FROM Cgrupopreguntas c WHERE c.descripciongrupopreguntas = :descripciongrupopreguntas"),
    @NamedQuery(name = "Cgrupopreguntas.findByFechaalta", query = "SELECT c FROM Cgrupopreguntas c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cgrupopreguntas.findByUsuarioalta", query = "SELECT c FROM Cgrupopreguntas c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cgrupopreguntas.findByFechamodificacion", query = "SELECT c FROM Cgrupopreguntas c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cgrupopreguntas.findByUsuariomodificacion", query = "SELECT c FROM Cgrupopreguntas c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cgrupopreguntas.findByActivo", query = "SELECT c FROM Cgrupopreguntas c WHERE c.activo = :activo")})
public class Cgrupopreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRUPOPREGUNTASID")
    private Integer grupopreguntasid;
    @Basic(optional = false)
    @Column(name = "CLAVEGRUPOPREGUNTAS")
    private String clavegrupopreguntas;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONGRUPOPREGUNTAS")
    private String descripciongrupopreguntas;
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
    @OneToMany(mappedBy = "grupopreguntasid")
    private Collection<Cpreguntas> cpreguntasCollection;

    public Cgrupopreguntas() {
    }

    public Cgrupopreguntas(Integer grupopreguntasid) {
        this.grupopreguntasid = grupopreguntasid;
    }

    public Cgrupopreguntas(Integer grupopreguntasid, String clavegrupopreguntas, String descripciongrupopreguntas, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.grupopreguntasid = grupopreguntasid;
        this.clavegrupopreguntas = clavegrupopreguntas;
        this.descripciongrupopreguntas = descripciongrupopreguntas;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getGrupopreguntasid() {
        return grupopreguntasid;
    }

    public void setGrupopreguntasid(Integer grupopreguntasid) {
        this.grupopreguntasid = grupopreguntasid;
    }

    public String getClavegrupopreguntas() {
        return clavegrupopreguntas;
    }

    public void setClavegrupopreguntas(String clavegrupopreguntas) {
        this.clavegrupopreguntas = clavegrupopreguntas;
    }

    public String getDescripciongrupopreguntas() {
        return descripciongrupopreguntas;
    }

    public void setDescripciongrupopreguntas(String descripciongrupopreguntas) {
        this.descripciongrupopreguntas = descripciongrupopreguntas;
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
    public Collection<Cpreguntas> getCpreguntasCollection() {
        return cpreguntasCollection;
    }

    public void setCpreguntasCollection(Collection<Cpreguntas> cpreguntasCollection) {
        this.cpreguntasCollection = cpreguntasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupopreguntasid != null ? grupopreguntasid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cgrupopreguntas)) {
            return false;
        }
        Cgrupopreguntas other = (Cgrupopreguntas) object;
        if ((this.grupopreguntasid == null && other.grupopreguntasid != null) || (this.grupopreguntasid != null && !this.grupopreguntasid.equals(other.grupopreguntasid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cgrupopreguntas[ grupopreguntasid=" + grupopreguntasid + " ]";
    }
    
}
