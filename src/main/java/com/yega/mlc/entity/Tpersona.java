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
@Table(name = "tpersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpersona.findAll", query = "SELECT t FROM Tpersona t"),
    @NamedQuery(name = "Tpersona.findByPersonaid", query = "SELECT t FROM Tpersona t WHERE t.personaid = :personaid"),
    @NamedQuery(name = "Tpersona.findByFechaalta", query = "SELECT t FROM Tpersona t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tpersona.findByFechabaja", query = "SELECT t FROM Tpersona t WHERE t.fechabaja = :fechabaja"),
    @NamedQuery(name = "Tpersona.findByRfc", query = "SELECT t FROM Tpersona t WHERE t.rfc = :rfc"),
    @NamedQuery(name = "Tpersona.findByActivo", query = "SELECT t FROM Tpersona t WHERE t.activo = :activo")})
public class Tpersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERSONAID")
    private Integer personaid;
    @Basic(optional = false)
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Column(name = "FECHABAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechabaja;
    @Column(name = "RFC")
    private String rfc;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private Collection<Tdomicilio> tdomicilioCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tpersona")
    private Tpersonamoral tpersonamoral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private Collection<Tcuentabancaria> tcuentabancariaCollection;
    @OneToMany(mappedBy = "personaid")
    private Collection<Tbeneficiario> tbeneficiarioCollection;
    @JoinColumn(name = "CLTIPOPERSONAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle cltipopersonaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private Collection<Tcontactopersona> tcontactopersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpersona")
    private Collection<Rmodulodocumento> rmodulodocumentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private Collection<Tmovimientobeneficiario> tmovimientobeneficiarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private Collection<Tpuntoventa> tpuntoventaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tpersona")
    private Tpersonafisica tpersonafisica;

    public Tpersona() {
    }

    public Tpersona(Integer personaid) {
        this.personaid = personaid;
    }

    public Tpersona(Integer personaid, Date fechaalta, boolean activo) {
        this.personaid = personaid;
        this.fechaalta = fechaalta;
        this.activo = activo;
    }

    public Integer getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Integer personaid) {
        this.personaid = personaid;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Tdomicilio> getTdomicilioCollection() {
        return tdomicilioCollection;
    }

    public void setTdomicilioCollection(Collection<Tdomicilio> tdomicilioCollection) {
        this.tdomicilioCollection = tdomicilioCollection;
    }

    public Tpersonamoral getTpersonamoral() {
        return tpersonamoral;
    }

    public void setTpersonamoral(Tpersonamoral tpersonamoral) {
        this.tpersonamoral = tpersonamoral;
    }

    @XmlTransient
    public Collection<Tcuentabancaria> getTcuentabancariaCollection() {
        return tcuentabancariaCollection;
    }

    public void setTcuentabancariaCollection(Collection<Tcuentabancaria> tcuentabancariaCollection) {
        this.tcuentabancariaCollection = tcuentabancariaCollection;
    }

    @XmlTransient
    public Collection<Tbeneficiario> getTbeneficiarioCollection() {
        return tbeneficiarioCollection;
    }

    public void setTbeneficiarioCollection(Collection<Tbeneficiario> tbeneficiarioCollection) {
        this.tbeneficiarioCollection = tbeneficiarioCollection;
    }

    public Cmaestrodetalle getCltipopersonaid() {
        return cltipopersonaid;
    }

    public void setCltipopersonaid(Cmaestrodetalle cltipopersonaid) {
        this.cltipopersonaid = cltipopersonaid;
    }

    @XmlTransient
    public Collection<Tcontactopersona> getTcontactopersonaCollection() {
        return tcontactopersonaCollection;
    }

    public void setTcontactopersonaCollection(Collection<Tcontactopersona> tcontactopersonaCollection) {
        this.tcontactopersonaCollection = tcontactopersonaCollection;
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
    public Collection<Tpuntoventa> getTpuntoventaCollection() {
        return tpuntoventaCollection;
    }

    public void setTpuntoventaCollection(Collection<Tpuntoventa> tpuntoventaCollection) {
        this.tpuntoventaCollection = tpuntoventaCollection;
    }

    public Tpersonafisica getTpersonafisica() {
        return tpersonafisica;
    }

    public void setTpersonafisica(Tpersonafisica tpersonafisica) {
        this.tpersonafisica = tpersonafisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaid != null ? personaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpersona)) {
            return false;
        }
        Tpersona other = (Tpersona) object;
        if ((this.personaid == null && other.personaid != null) || (this.personaid != null && !this.personaid.equals(other.personaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tpersona[ personaid=" + personaid + " ]";
    }
    
}
