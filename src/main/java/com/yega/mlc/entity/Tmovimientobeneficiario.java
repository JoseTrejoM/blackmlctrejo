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
@Table(name = "tmovimientobeneficiario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmovimientobeneficiario.findAll", query = "SELECT t FROM Tmovimientobeneficiario t"),
    @NamedQuery(name = "Tmovimientobeneficiario.findByMovimientobeneficiariosid", query = "SELECT t FROM Tmovimientobeneficiario t WHERE t.movimientobeneficiariosid = :movimientobeneficiariosid"),
    @NamedQuery(name = "Tmovimientobeneficiario.findByTipomovimientoid", query = "SELECT t FROM Tmovimientobeneficiario t WHERE t.tipomovimientoid = :tipomovimientoid"),
    @NamedQuery(name = "Tmovimientobeneficiario.findByFechaalta", query = "SELECT t FROM Tmovimientobeneficiario t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tmovimientobeneficiario.findByUsuarioalta", query = "SELECT t FROM Tmovimientobeneficiario t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tmovimientobeneficiario.findByFechamodificacion", query = "SELECT t FROM Tmovimientobeneficiario t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tmovimientobeneficiario.findByUsuariomodificacion", query = "SELECT t FROM Tmovimientobeneficiario t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tmovimientobeneficiario.findByActivo", query = "SELECT t FROM Tmovimientobeneficiario t WHERE t.activo = :activo")})
public class Tmovimientobeneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MOVIMIENTOBENEFICIARIOSID")
    private Integer movimientobeneficiariosid;
    @Basic(optional = false)
    @Column(name = "TIPOMOVIMIENTOID")
    private int tipomovimientoid;
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
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne(optional = false)
    private Tpersona personaid;
    @JoinColumn(name = "SERVICIOCONTRATADOID", referencedColumnName = "SERVICIOCONTRATADOID")
    @ManyToOne(optional = false)
    private Tservicioscontratados serviciocontratadoid;

    public Tmovimientobeneficiario() {
    }

    public Tmovimientobeneficiario(Integer movimientobeneficiariosid) {
        this.movimientobeneficiariosid = movimientobeneficiariosid;
    }

    public Tmovimientobeneficiario(Integer movimientobeneficiariosid, int tipomovimientoid, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.movimientobeneficiariosid = movimientobeneficiariosid;
        this.tipomovimientoid = tipomovimientoid;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getMovimientobeneficiariosid() {
        return movimientobeneficiariosid;
    }

    public void setMovimientobeneficiariosid(Integer movimientobeneficiariosid) {
        this.movimientobeneficiariosid = movimientobeneficiariosid;
    }

    public int getTipomovimientoid() {
        return tipomovimientoid;
    }

    public void setTipomovimientoid(int tipomovimientoid) {
        this.tipomovimientoid = tipomovimientoid;
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

    public Tpersona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Tpersona personaid) {
        this.personaid = personaid;
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
        hash += (movimientobeneficiariosid != null ? movimientobeneficiariosid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmovimientobeneficiario)) {
            return false;
        }
        Tmovimientobeneficiario other = (Tmovimientobeneficiario) object;
        if ((this.movimientobeneficiariosid == null && other.movimientobeneficiariosid != null) || (this.movimientobeneficiariosid != null && !this.movimientobeneficiariosid.equals(other.movimientobeneficiariosid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tmovimientobeneficiario[ movimientobeneficiariosid=" + movimientobeneficiariosid + " ]";
    }
    
}
