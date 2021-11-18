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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "rserviciocontratadoestatusservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rserviciocontratadoestatusservicio.findAll", query = "SELECT r FROM Rserviciocontratadoestatusservicio r"),
    @NamedQuery(name = "Rserviciocontratadoestatusservicio.findByServiciocontratadoestatusid", query = "SELECT r FROM Rserviciocontratadoestatusservicio r WHERE r.serviciocontratadoestatusid = :serviciocontratadoestatusid"),
    @NamedQuery(name = "Rserviciocontratadoestatusservicio.findByFechaalta", query = "SELECT r FROM Rserviciocontratadoestatusservicio r WHERE r.fechaalta = :fechaalta"),
    @NamedQuery(name = "Rserviciocontratadoestatusservicio.findByUsuarioalta", query = "SELECT r FROM Rserviciocontratadoestatusservicio r WHERE r.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Rserviciocontratadoestatusservicio.findByFechamodificacion", query = "SELECT r FROM Rserviciocontratadoestatusservicio r WHERE r.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Rserviciocontratadoestatusservicio.findByUsuariomodificacion", query = "SELECT r FROM Rserviciocontratadoestatusservicio r WHERE r.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Rserviciocontratadoestatusservicio.findByActivo", query = "SELECT r FROM Rserviciocontratadoestatusservicio r WHERE r.activo = :activo")})
public class Rserviciocontratadoestatusservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICIOCONTRATADOESTATUSID")
    private Integer serviciocontratadoestatusid;
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
    @JoinColumn(name = "CLESTATUSSERVICIOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clestatusservicioid;
    @JoinColumn(name = "SERVICIOCONTRATADOID", referencedColumnName = "SERVICIOCONTRATADOID")
    @ManyToOne(optional = false)
    private Tservicioscontratados serviciocontratadoid;

    public Rserviciocontratadoestatusservicio() {
    }

    public Rserviciocontratadoestatusservicio(Integer serviciocontratadoestatusid) {
        this.serviciocontratadoestatusid = serviciocontratadoestatusid;
    }

    public Rserviciocontratadoestatusservicio(Integer serviciocontratadoestatusid, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.serviciocontratadoestatusid = serviciocontratadoestatusid;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getServiciocontratadoestatusid() {
        return serviciocontratadoestatusid;
    }

    public void setServiciocontratadoestatusid(Integer serviciocontratadoestatusid) {
        this.serviciocontratadoestatusid = serviciocontratadoestatusid;
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

    public Cmaestrodetalle getClestatusservicioid() {
        return clestatusservicioid;
    }

    public void setClestatusservicioid(Cmaestrodetalle clestatusservicioid) {
        this.clestatusservicioid = clestatusservicioid;
    }

    public Tservicioscontratados getServiciocontratadoid() {
        return serviciocontratadoid;
    }

    public void setServiciocontratadoid(Tservicioscontratados serviciocontratadoid) {
        this.serviciocontratadoid = serviciocontratadoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviciocontratadoestatusid != null ? serviciocontratadoestatusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rserviciocontratadoestatusservicio)) {
            return false;
        }
        Rserviciocontratadoestatusservicio other = (Rserviciocontratadoestatusservicio) object;
        if ((this.serviciocontratadoestatusid == null && other.serviciocontratadoestatusid != null) || (this.serviciocontratadoestatusid != null && !this.serviciocontratadoestatusid.equals(other.serviciocontratadoestatusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Rserviciocontratadoestatusservicio[ serviciocontratadoestatusid=" + serviciocontratadoestatusid + " ]";
    }
    
}
