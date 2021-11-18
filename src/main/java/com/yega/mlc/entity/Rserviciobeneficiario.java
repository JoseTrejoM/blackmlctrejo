/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "rserviciobeneficiario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rserviciobeneficiario.findAll", query = "SELECT r FROM Rserviciobeneficiario r"),
    @NamedQuery(name = "Rserviciobeneficiario.findByServiciobeneficiarioid", query = "SELECT r FROM Rserviciobeneficiario r WHERE r.serviciobeneficiarioid = :serviciobeneficiarioid"),
    @NamedQuery(name = "Rserviciobeneficiario.findByPorcentaje", query = "SELECT r FROM Rserviciobeneficiario r WHERE r.porcentaje = :porcentaje"),
    @NamedQuery(name = "Rserviciobeneficiario.findByFechaalta", query = "SELECT r FROM Rserviciobeneficiario r WHERE r.fechaalta = :fechaalta"),
    @NamedQuery(name = "Rserviciobeneficiario.findByUsuarioalta", query = "SELECT r FROM Rserviciobeneficiario r WHERE r.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Rserviciobeneficiario.findByFechamodificacion", query = "SELECT r FROM Rserviciobeneficiario r WHERE r.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Rserviciobeneficiario.findByUsuariomodificacion", query = "SELECT r FROM Rserviciobeneficiario r WHERE r.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Rserviciobeneficiario.findByActivo", query = "SELECT r FROM Rserviciobeneficiario r WHERE r.activo = :activo")})
public class Rserviciobeneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICIOBENEFICIARIOID")
    private Integer serviciobeneficiarioid;
    @Column(name = "PORCENTAJE")
    private Integer porcentaje;
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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviciobeneficiarioid")
    private Collection<Trespuesta> trespuestaCollection;

    @JsonManagedReference
    @JoinColumn(name = "BENEFICIOID", referencedColumnName = "BENEFICIOID")
    @ManyToOne
    private Cbeneficios beneficioid;

    @JsonManagedReference
    @JoinColumn(name = "BENEFICIARIOID", referencedColumnName = "BENEFICIARIOID")
    @ManyToOne
    private Tbeneficiario beneficiarioid;

    @JsonManagedReference
    @JoinColumn(name = "SERVICIOCONTRATADOID", referencedColumnName = "SERVICIOCONTRATADOID")
    @ManyToOne
    private Tservicioscontratados serviciocontratadoid;

    public Rserviciobeneficiario() {
    }

    public Rserviciobeneficiario(Integer serviciobeneficiarioid) {
        this.serviciobeneficiarioid = serviciobeneficiarioid;
    }

    public Rserviciobeneficiario(Integer serviciobeneficiarioid, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.serviciobeneficiarioid = serviciobeneficiarioid;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getServiciobeneficiarioid() {
        return serviciobeneficiarioid;
    }

    public void setServiciobeneficiarioid(Integer serviciobeneficiarioid) {
        this.serviciobeneficiarioid = serviciobeneficiarioid;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
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
    public Collection<Trespuesta> getTrespuestaCollection() {
        return trespuestaCollection;
    }

    public void setTrespuestaCollection(Collection<Trespuesta> trespuestaCollection) {
        this.trespuestaCollection = trespuestaCollection;
    }

    public Cbeneficios getBeneficioid() {
        return beneficioid;
    }

    public void setBeneficioid(Cbeneficios beneficioid) {
        this.beneficioid = beneficioid;
    }

    public Tbeneficiario getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(Tbeneficiario beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
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
        hash += (serviciobeneficiarioid != null ? serviciobeneficiarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rserviciobeneficiario)) {
            return false;
        }
        Rserviciobeneficiario other = (Rserviciobeneficiario) object;
        if ((this.serviciobeneficiarioid == null && other.serviciobeneficiarioid != null) || (this.serviciobeneficiarioid != null && !this.serviciobeneficiarioid.equals(other.serviciobeneficiarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Rserviciobeneficiario[ serviciobeneficiarioid=" + serviciobeneficiarioid + " ]";
    }
    
}
