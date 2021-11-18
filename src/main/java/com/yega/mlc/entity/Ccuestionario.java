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
@Table(name = "ccuestionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ccuestionario.findAll", query = "SELECT c FROM Ccuestionario c"),
    @NamedQuery(name = "Ccuestionario.findByCuestionarioid", query = "SELECT c FROM Ccuestionario c WHERE c.cuestionarioid = :cuestionarioid"),
    @NamedQuery(name = "Ccuestionario.findByClavecuestionario", query = "SELECT c FROM Ccuestionario c WHERE c.clavecuestionario = :clavecuestionario"),
    @NamedQuery(name = "Ccuestionario.findByDescripcioncuestionario", query = "SELECT c FROM Ccuestionario c WHERE c.descripcioncuestionario = :descripcioncuestionario"),
    @NamedQuery(name = "Ccuestionario.findByFechaalta", query = "SELECT c FROM Ccuestionario c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Ccuestionario.findByUsuarioalta", query = "SELECT c FROM Ccuestionario c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Ccuestionario.findByFechamodificacion", query = "SELECT c FROM Ccuestionario c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Ccuestionario.findByUsuariomodificacion", query = "SELECT c FROM Ccuestionario c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Ccuestionario.findByActivo", query = "SELECT c FROM Ccuestionario c WHERE c.activo = :activo")})
public class Ccuestionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUESTIONARIOID")
    private Integer cuestionarioid;
    @Basic(optional = false)
    @Column(name = "CLAVECUESTIONARIO")
    private String clavecuestionario;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONCUESTIONARIO")
    private String descripcioncuestionario;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuestionarioid")
    private Collection<Cpreguntas> cpreguntasCollection;

    public Ccuestionario() {
    }

    public Ccuestionario(Integer cuestionarioid) {
        this.cuestionarioid = cuestionarioid;
    }

    public Ccuestionario(Integer cuestionarioid, String clavecuestionario, String descripcioncuestionario, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.cuestionarioid = cuestionarioid;
        this.clavecuestionario = clavecuestionario;
        this.descripcioncuestionario = descripcioncuestionario;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getCuestionarioid() {
        return cuestionarioid;
    }

    public void setCuestionarioid(Integer cuestionarioid) {
        this.cuestionarioid = cuestionarioid;
    }

    public String getClavecuestionario() {
        return clavecuestionario;
    }

    public void setClavecuestionario(String clavecuestionario) {
        this.clavecuestionario = clavecuestionario;
    }

    public String getDescripcioncuestionario() {
        return descripcioncuestionario;
    }

    public void setDescripcioncuestionario(String descripcioncuestionario) {
        this.descripcioncuestionario = descripcioncuestionario;
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
        hash += (cuestionarioid != null ? cuestionarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ccuestionario)) {
            return false;
        }
        Ccuestionario other = (Ccuestionario) object;
        if ((this.cuestionarioid == null && other.cuestionarioid != null) || (this.cuestionarioid != null && !this.cuestionarioid.equals(other.cuestionarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Ccuestionario[ cuestionarioid=" + cuestionarioid + " ]";
    }
    
}
