/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tpreciosumaasegurada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpreciosumaasegurada.findAll", query = "SELECT t FROM Tpreciosumaasegurada t"),
    @NamedQuery(name = "Tpreciosumaasegurada.findByPreciosumaaseguradaid", query = "SELECT t FROM Tpreciosumaasegurada t WHERE t.preciosumaaseguradaid = :preciosumaaseguradaid"),
    @NamedQuery(name = "Tpreciosumaasegurada.findByPrecio", query = "SELECT t FROM Tpreciosumaasegurada t WHERE t.precio = :precio"),
    @NamedQuery(name = "Tpreciosumaasegurada.findByFechaalta", query = "SELECT t FROM Tpreciosumaasegurada t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tpreciosumaasegurada.findByUsuarioalta", query = "SELECT t FROM Tpreciosumaasegurada t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tpreciosumaasegurada.findByFechamodificacion", query = "SELECT t FROM Tpreciosumaasegurada t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tpreciosumaasegurada.findByUsuariomodificacion", query = "SELECT t FROM Tpreciosumaasegurada t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tpreciosumaasegurada.findByActivo", query = "SELECT t FROM Tpreciosumaasegurada t WHERE t.activo = :activo")})
public class Tpreciosumaasegurada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRECIOSUMAASEGURADAID")
    private Integer preciosumaaseguradaid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private BigDecimal precio;
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
    @JoinColumn(name = "CLRANGOEDADID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clrangoedadid;
    @JoinColumn(name = "CLSUMAASEGURADAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clsumaaseguradaid;
    @JoinColumn(name = "TIPOPLANID", referencedColumnName = "TIPOPLANID")
    @ManyToOne(optional = false)
    private Ttipoplan tipoplanid;

    public Tpreciosumaasegurada() {
    }

    public Tpreciosumaasegurada(Integer preciosumaaseguradaid) {
        this.preciosumaaseguradaid = preciosumaaseguradaid;
    }

    public Tpreciosumaasegurada(Integer preciosumaaseguradaid, BigDecimal precio, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.preciosumaaseguradaid = preciosumaaseguradaid;
        this.precio = precio;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getPreciosumaaseguradaid() {
        return preciosumaaseguradaid;
    }

    public void setPreciosumaaseguradaid(Integer preciosumaaseguradaid) {
        this.preciosumaaseguradaid = preciosumaaseguradaid;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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

    public Cmaestrodetalle getClrangoedadid() {
        return clrangoedadid;
    }

    public void setClrangoedadid(Cmaestrodetalle clrangoedadid) {
        this.clrangoedadid = clrangoedadid;
    }

    public Cmaestrodetalle getClsumaaseguradaid() {
        return clsumaaseguradaid;
    }

    public void setClsumaaseguradaid(Cmaestrodetalle clsumaaseguradaid) {
        this.clsumaaseguradaid = clsumaaseguradaid;
    }

    public Ttipoplan getTipoplanid() {
        return tipoplanid;
    }

    public void setTipoplanid(Ttipoplan tipoplanid) {
        this.tipoplanid = tipoplanid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preciosumaaseguradaid != null ? preciosumaaseguradaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpreciosumaasegurada)) {
            return false;
        }
        Tpreciosumaasegurada other = (Tpreciosumaasegurada) object;
        if ((this.preciosumaaseguradaid == null && other.preciosumaaseguradaid != null) || (this.preciosumaaseguradaid != null && !this.preciosumaaseguradaid.equals(other.preciosumaaseguradaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tpreciosumaasegurada[ preciosumaaseguradaid=" + preciosumaaseguradaid + " ]";
    }
    
}
