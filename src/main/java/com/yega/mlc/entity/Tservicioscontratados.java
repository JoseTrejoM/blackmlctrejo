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
@Table(name = "tservicioscontratados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tservicioscontratados.findAll", query = "SELECT t FROM Tservicioscontratados t"),
    @NamedQuery(name = "Tservicioscontratados.findByServiciocontratadoid", query = "SELECT t FROM Tservicioscontratados t WHERE t.serviciocontratadoid = :serviciocontratadoid"),
    @NamedQuery(name = "Tservicioscontratados.findByClformapagoid", query = "SELECT t FROM Tservicioscontratados t WHERE t.clformapagoid = :clformapagoid"),
    @NamedQuery(name = "Tservicioscontratados.findByFechaalta", query = "SELECT t FROM Tservicioscontratados t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tservicioscontratados.findByUsuarioalta", query = "SELECT t FROM Tservicioscontratados t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tservicioscontratados.findByFechamodificacion", query = "SELECT t FROM Tservicioscontratados t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tservicioscontratados.findByUsuariomodificacion", query = "SELECT t FROM Tservicioscontratados t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tservicioscontratados.findByActivo", query = "SELECT t FROM Tservicioscontratados t WHERE t.activo = :activo")})
public class Tservicioscontratados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICIOCONTRATADOID")
    private Integer serviciocontratadoid;
    @Column(name = "CLFORMAPAGOID")
    private Integer clformapagoid;
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
    @OneToMany(mappedBy = "serviciocontratadoid")
    private Collection<Rserviciobeneficiario> rserviciobeneficiarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviciocontratadoid")
    private Collection<Tperiodovigencia> tperiodovigenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tservicioscontratados")
    private Collection<Rmodulodocumento> rmodulodocumentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviciocontratadoid")
    private Collection<Tmovimientobeneficiario> tmovimientobeneficiarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviciocontratadoid")
    private Collection<Rserviciocontratadoestatusservicio> rserviciocontratadoestatusservicioCollection;
    @JoinColumn(name = "CLFRECUENCIAPAGOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clfrecuenciapagoid;
    @JoinColumn(name = "PROPUESTAID", referencedColumnName = "PROPUESTAID")
    @ManyToOne
    private Tpropuesta propuestaid;
    @JoinColumn(name = "TIPOPLANID", referencedColumnName = "TIPOPLANID")
    @ManyToOne
    private Ttipoplan tipoplanid;

    public Tservicioscontratados() {
    }

    public Tservicioscontratados(Integer serviciocontratadoid) {
        this.serviciocontratadoid = serviciocontratadoid;
    }

    public Tservicioscontratados(Integer serviciocontratadoid, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.serviciocontratadoid = serviciocontratadoid;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getServiciocontratadoid() {
        return serviciocontratadoid;
    }

    public void setServiciocontratadoid(Integer serviciocontratadoid) {
        this.serviciocontratadoid = serviciocontratadoid;
    }

    public Integer getClformapagoid() {
        return clformapagoid;
    }

    public void setClformapagoid(Integer clformapagoid) {
        this.clformapagoid = clformapagoid;
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
    public Collection<Rserviciobeneficiario> getRserviciobeneficiarioCollection() {
        return rserviciobeneficiarioCollection;
    }

    public void setRserviciobeneficiarioCollection(Collection<Rserviciobeneficiario> rserviciobeneficiarioCollection) {
        this.rserviciobeneficiarioCollection = rserviciobeneficiarioCollection;
    }

    @XmlTransient
    public Collection<Tperiodovigencia> getTperiodovigenciaCollection() {
        return tperiodovigenciaCollection;
    }

    public void setTperiodovigenciaCollection(Collection<Tperiodovigencia> tperiodovigenciaCollection) {
        this.tperiodovigenciaCollection = tperiodovigenciaCollection;
    }

    @XmlTransient
    public Collection<Rmodulodocumento> getRmodulodocumentoCollection() {
        return rmodulodocumentoCollection;
    }

    public void setRmodulodocumentoCollection(Collection<Rmodulodocumento> rmodulodocumentoCollection) {
        this.rmodulodocumentoCollection = rmodulodocumentoCollection;
    }

    @XmlTransient
    public Collection<Tmovimientobeneficiario> getTmovimientobeneficiarioCollection() {
        return tmovimientobeneficiarioCollection;
    }

    public void setTmovimientobeneficiarioCollection(Collection<Tmovimientobeneficiario> tmovimientobeneficiarioCollection) {
        this.tmovimientobeneficiarioCollection = tmovimientobeneficiarioCollection;
    }

    @XmlTransient
    public Collection<Rserviciocontratadoestatusservicio> getRserviciocontratadoestatusservicioCollection() {
        return rserviciocontratadoestatusservicioCollection;
    }

    public void setRserviciocontratadoestatusservicioCollection(Collection<Rserviciocontratadoestatusservicio> rserviciocontratadoestatusservicioCollection) {
        this.rserviciocontratadoestatusservicioCollection = rserviciocontratadoestatusservicioCollection;
    }

    public Cmaestrodetalle getClfrecuenciapagoid() {
        return clfrecuenciapagoid;
    }

    public void setClfrecuenciapagoid(Cmaestrodetalle clfrecuenciapagoid) {
        this.clfrecuenciapagoid = clfrecuenciapagoid;
    }

    public Tpropuesta getPropuestaid() {
        return propuestaid;
    }

    public void setPropuestaid(Tpropuesta propuestaid) {
        this.propuestaid = propuestaid;
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
        hash += (serviciocontratadoid != null ? serviciocontratadoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tservicioscontratados)) {
            return false;
        }
        Tservicioscontratados other = (Tservicioscontratados) object;
        if ((this.serviciocontratadoid == null && other.serviciocontratadoid != null) || (this.serviciocontratadoid != null && !this.serviciocontratadoid.equals(other.serviciocontratadoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tservicioscontratados[ serviciocontratadoid=" + serviciocontratadoid + " ]";
    }
    
}
