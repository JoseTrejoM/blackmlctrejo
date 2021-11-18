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
@Table(name = "tperiodovigencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tperiodovigencia.findAll", query = "SELECT t FROM Tperiodovigencia t"),
    @NamedQuery(name = "Tperiodovigencia.findByPeriodovigenciaid", query = "SELECT t FROM Tperiodovigencia t WHERE t.periodovigenciaid = :periodovigenciaid"),
    @NamedQuery(name = "Tperiodovigencia.findByFechainicio", query = "SELECT t FROM Tperiodovigencia t WHERE t.fechainicio = :fechainicio"),
    @NamedQuery(name = "Tperiodovigencia.findByFechafin", query = "SELECT t FROM Tperiodovigencia t WHERE t.fechafin = :fechafin"),
    @NamedQuery(name = "Tperiodovigencia.findByFechaalta", query = "SELECT t FROM Tperiodovigencia t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tperiodovigencia.findByUsuarioalta", query = "SELECT t FROM Tperiodovigencia t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tperiodovigencia.findByFechamodificacion", query = "SELECT t FROM Tperiodovigencia t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tperiodovigencia.findByUsuariomodificacion", query = "SELECT t FROM Tperiodovigencia t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tperiodovigencia.findByActivo", query = "SELECT t FROM Tperiodovigencia t WHERE t.activo = :activo")})
public class Tperiodovigencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERIODOVIGENCIAID")
    private Integer periodovigenciaid;
    @Basic(optional = false)
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
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
    @JoinColumn(name = "SERVICIOCONTRATADOID", referencedColumnName = "SERVICIOCONTRATADOID")
    @ManyToOne(optional = false)
    private Tservicioscontratados serviciocontratadoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vigenciaid")
    private Collection<Tpagos> tpagosCollection;

    public Tperiodovigencia() {
    }

    public Tperiodovigencia(Integer periodovigenciaid) {
        this.periodovigenciaid = periodovigenciaid;
    }

    public Tperiodovigencia(Integer periodovigenciaid, Date fechainicio, Date fechafin, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.periodovigenciaid = periodovigenciaid;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getPeriodovigenciaid() {
        return periodovigenciaid;
    }

    public void setPeriodovigenciaid(Integer periodovigenciaid) {
        this.periodovigenciaid = periodovigenciaid;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
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

    public Tservicioscontratados getServiciocontratadoid() {
        return serviciocontratadoid;
    }

    public void setServiciocontratadoid(Tservicioscontratados serviciocontratadoid) {
        this.serviciocontratadoid = serviciocontratadoid;
    }

    @XmlTransient
    public Collection<Tpagos> getTpagosCollection() {
        return tpagosCollection;
    }

    public void setTpagosCollection(Collection<Tpagos> tpagosCollection) {
        this.tpagosCollection = tpagosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodovigenciaid != null ? periodovigenciaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tperiodovigencia)) {
            return false;
        }
        Tperiodovigencia other = (Tperiodovigencia) object;
        if ((this.periodovigenciaid == null && other.periodovigenciaid != null) || (this.periodovigenciaid != null && !this.periodovigenciaid.equals(other.periodovigenciaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tperiodovigencia[ periodovigenciaid=" + periodovigenciaid + " ]";
    }
    
}
