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
@Table(name = "restadoresidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restadoresidencia.findAll", query = "SELECT r FROM Restadoresidencia r"),
    @NamedQuery(name = "Restadoresidencia.findByEstadoresidenciaid", query = "SELECT r FROM Restadoresidencia r WHERE r.estadoresidenciaid = :estadoresidenciaid"),
    @NamedQuery(name = "Restadoresidencia.findByFechaalta", query = "SELECT r FROM Restadoresidencia r WHERE r.fechaalta = :fechaalta"),
    @NamedQuery(name = "Restadoresidencia.findByUsuarioalta", query = "SELECT r FROM Restadoresidencia r WHERE r.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Restadoresidencia.findByFechamodificacion", query = "SELECT r FROM Restadoresidencia r WHERE r.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Restadoresidencia.findByUsuariomodificacion", query = "SELECT r FROM Restadoresidencia r WHERE r.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Restadoresidencia.findByActivo", query = "SELECT r FROM Restadoresidencia r WHERE r.activo = :activo")})
public class Restadoresidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTADORESIDENCIAID")
    private Integer estadoresidenciaid;
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
    @JoinColumn(name = "ESTADOID", referencedColumnName = "ESTADOID")
    @ManyToOne
    private Cestados estadoid;
    @JoinColumn(name = "BENEFICIARIOID", referencedColumnName = "BENEFICIARIOID")
    @ManyToOne(optional = false)
    private Tbeneficiario beneficiarioid;

    public Restadoresidencia() {
    }

    public Restadoresidencia(Integer estadoresidenciaid) {
        this.estadoresidenciaid = estadoresidenciaid;
    }

    public Restadoresidencia(Integer estadoresidenciaid, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.estadoresidenciaid = estadoresidenciaid;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getEstadoresidenciaid() {
        return estadoresidenciaid;
    }

    public void setEstadoresidenciaid(Integer estadoresidenciaid) {
        this.estadoresidenciaid = estadoresidenciaid;
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

    public Cestados getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(Cestados estadoid) {
        this.estadoid = estadoid;
    }

    public Tbeneficiario getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(Tbeneficiario beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoresidenciaid != null ? estadoresidenciaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restadoresidencia)) {
            return false;
        }
        Restadoresidencia other = (Restadoresidencia) object;
        if ((this.estadoresidenciaid == null && other.estadoresidenciaid != null) || (this.estadoresidenciaid != null && !this.estadoresidenciaid.equals(other.estadoresidenciaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Restadoresidencia[ estadoresidenciaid=" + estadoresidenciaid + " ]";
    }
    
}
