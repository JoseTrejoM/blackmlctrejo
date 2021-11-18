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
@Table(name = "tbeneficiario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbeneficiario.findAll", query = "SELECT t FROM Tbeneficiario t"),
    @NamedQuery(name = "Tbeneficiario.findByBeneficiarioid", query = "SELECT t FROM Tbeneficiario t WHERE t.beneficiarioid = :beneficiarioid"),
    @NamedQuery(name = "Tbeneficiario.findByFechaalta", query = "SELECT t FROM Tbeneficiario t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tbeneficiario.findByUsuarioalta", query = "SELECT t FROM Tbeneficiario t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tbeneficiario.findByFechamodificacion", query = "SELECT t FROM Tbeneficiario t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tbeneficiario.findByUsuariomodificacion", query = "SELECT t FROM Tbeneficiario t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tbeneficiario.findByActivo", query = "SELECT t FROM Tbeneficiario t WHERE t.activo = :activo")})
public class Tbeneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BENEFICIARIOID")
    private Integer beneficiarioid;
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
    @OneToMany(mappedBy = "beneficiarioid")
    private Collection<Rserviciobeneficiario> rserviciobeneficiarioCollection;
    @JoinColumn(name = "TIPOBENEFICIARIOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle tipobeneficiarioid;
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne
    private Tpersona personaid;
    @JoinColumn(name = "PROPUESTAID", referencedColumnName = "PROPUESTAID")
    @ManyToOne(optional = false)
    private Tpropuesta propuestaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiarioid")
    private Collection<Restadoresidencia> restadoresidenciaCollection;

    public Tbeneficiario() {
    }

    public Tbeneficiario(Integer beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
    }

    public Tbeneficiario(Integer beneficiarioid, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.beneficiarioid = beneficiarioid;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(Integer beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
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

    public Cmaestrodetalle getTipobeneficiarioid() {
        return tipobeneficiarioid;
    }

    public void setTipobeneficiarioid(Cmaestrodetalle tipobeneficiarioid) {
        this.tipobeneficiarioid = tipobeneficiarioid;
    }

    public Tpersona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Tpersona personaid) {
        this.personaid = personaid;
    }

    public Tpropuesta getPropuestaid() {
        return propuestaid;
    }

    public void setPropuestaid(Tpropuesta propuestaid) {
        this.propuestaid = propuestaid;
    }

    @XmlTransient
    public Collection<Restadoresidencia> getRestadoresidenciaCollection() {
        return restadoresidenciaCollection;
    }

    public void setRestadoresidenciaCollection(Collection<Restadoresidencia> restadoresidenciaCollection) {
        this.restadoresidenciaCollection = restadoresidenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beneficiarioid != null ? beneficiarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbeneficiario)) {
            return false;
        }
        Tbeneficiario other = (Tbeneficiario) object;
        if ((this.beneficiarioid == null && other.beneficiarioid != null) || (this.beneficiarioid != null && !this.beneficiarioid.equals(other.beneficiarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tbeneficiario[ beneficiarioid=" + beneficiarioid + " ]";
    }
    
}
