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
import javax.persistence.OneToOne;
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
@Table(name = "tpropuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpropuesta.findAll", query = "SELECT t FROM Tpropuesta t"),
    @NamedQuery(name = "Tpropuesta.findByPropuestaid", query = "SELECT t FROM Tpropuesta t WHERE t.propuestaid = :propuestaid"),
    @NamedQuery(name = "Tpropuesta.findByFechaautorizacion", query = "SELECT t FROM Tpropuesta t WHERE t.fechaautorizacion = :fechaautorizacion"),
    @NamedQuery(name = "Tpropuesta.findByCurp", query = "SELECT t FROM Tpropuesta t WHERE t.curp = :curp"),
    @NamedQuery(name = "Tpropuesta.findByFechafinpropuesta", query = "SELECT t FROM Tpropuesta t WHERE t.fechafinpropuesta = :fechafinpropuesta"),
    @NamedQuery(name = "Tpropuesta.findByFechaalta", query = "SELECT t FROM Tpropuesta t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tpropuesta.findByUsuarioalta", query = "SELECT t FROM Tpropuesta t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tpropuesta.findByFechamodificacion", query = "SELECT t FROM Tpropuesta t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tpropuesta.findByUsuariomodificacion", query = "SELECT t FROM Tpropuesta t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tpropuesta.findByActivo", query = "SELECT t FROM Tpropuesta t WHERE t.activo = :activo")})
public class Tpropuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROPUESTAID")
    private Integer propuestaid;
    @Column(name = "FECHAAUTORIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaautorizacion;
    @Basic(optional = false)
    @Column(name = "CURP")
    private String curp;
    @Column(name = "FECHAFINPROPUESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinpropuesta;
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
    @JoinColumn(name = "CLESTATUSPROPUESTAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clestatuspropuestaid;
    @JoinColumn(name = "ENLACEID", referencedColumnName = "ENLACEID")
    @ManyToOne
    private Tenlace enlaceid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propuestaid")
    private Collection<Tbeneficiario> tbeneficiarioCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tpropuesta")
    private Tmembresia tmembresia;
    @OneToMany(mappedBy = "propuestaid")
    private Collection<Tservicioscontratados> tservicioscontratadosCollection;

    public Tpropuesta() {
    }

    public Tpropuesta(Integer propuestaid) {
        this.propuestaid = propuestaid;
    }

    public Tpropuesta(Integer propuestaid, String curp, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.propuestaid = propuestaid;
        this.curp = curp;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getPropuestaid() {
        return propuestaid;
    }

    public void setPropuestaid(Integer propuestaid) {
        this.propuestaid = propuestaid;
    }

    public Date getFechaautorizacion() {
        return fechaautorizacion;
    }

    public void setFechaautorizacion(Date fechaautorizacion) {
        this.fechaautorizacion = fechaautorizacion;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFechafinpropuesta() {
        return fechafinpropuesta;
    }

    public void setFechafinpropuesta(Date fechafinpropuesta) {
        this.fechafinpropuesta = fechafinpropuesta;
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

    public Cmaestrodetalle getClestatuspropuestaid() {
        return clestatuspropuestaid;
    }

    public void setClestatuspropuestaid(Cmaestrodetalle clestatuspropuestaid) {
        this.clestatuspropuestaid = clestatuspropuestaid;
    }

    public Tenlace getEnlaceid() {
        return enlaceid;
    }

    public void setEnlaceid(Tenlace enlaceid) {
        this.enlaceid = enlaceid;
    }

    @XmlTransient
    public Collection<Tbeneficiario> getTbeneficiarioCollection() {
        return tbeneficiarioCollection;
    }

    public void setTbeneficiarioCollection(Collection<Tbeneficiario> tbeneficiarioCollection) {
        this.tbeneficiarioCollection = tbeneficiarioCollection;
    }

    public Tmembresia getTmembresia() {
        return tmembresia;
    }

    public void setTmembresia(Tmembresia tmembresia) {
        this.tmembresia = tmembresia;
    }

    @XmlTransient
    public Collection<Tservicioscontratados> getTservicioscontratadosCollection() {
        return tservicioscontratadosCollection;
    }

    public void setTservicioscontratadosCollection(Collection<Tservicioscontratados> tservicioscontratadosCollection) {
        this.tservicioscontratadosCollection = tservicioscontratadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propuestaid != null ? propuestaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpropuesta)) {
            return false;
        }
        Tpropuesta other = (Tpropuesta) object;
        if ((this.propuestaid == null && other.propuestaid != null) || (this.propuestaid != null && !this.propuestaid.equals(other.propuestaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tpropuesta[ propuestaid=" + propuestaid + " ]";
    }
    
}
