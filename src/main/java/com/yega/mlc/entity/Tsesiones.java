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
@Table(name = "tsesiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsesiones.findAll", query = "SELECT t FROM Tsesiones t"),
    @NamedQuery(name = "Tsesiones.findBySesionid", query = "SELECT t FROM Tsesiones t WHERE t.sesionid = :sesionid"),
    @NamedQuery(name = "Tsesiones.findByFechaacceso", query = "SELECT t FROM Tsesiones t WHERE t.fechaacceso = :fechaacceso"),
    @NamedQuery(name = "Tsesiones.findByToken", query = "SELECT t FROM Tsesiones t WHERE t.token = :token")})
public class Tsesiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SESIONID")
    private Integer sesionid;
    @Basic(optional = false)
    @Column(name = "FECHAACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaacceso;
    @Basic(optional = false)
    @Column(name = "TOKEN")
    private String token;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tsesiones")
    private Collection<Tsesionparametros> tsesionparametrosCollection;
    @JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")
    @ManyToOne
    private Tusuarios usuarioid;

    public Tsesiones() {
    }

    public Tsesiones(Integer sesionid) {
        this.sesionid = sesionid;
    }

    public Tsesiones(Integer sesionid, Date fechaacceso, String token) {
        this.sesionid = sesionid;
        this.fechaacceso = fechaacceso;
        this.token = token;
    }

    public Integer getSesionid() {
        return sesionid;
    }

    public void setSesionid(Integer sesionid) {
        this.sesionid = sesionid;
    }

    public Date getFechaacceso() {
        return fechaacceso;
    }

    public void setFechaacceso(Date fechaacceso) {
        this.fechaacceso = fechaacceso;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @XmlTransient
    public Collection<Tsesionparametros> getTsesionparametrosCollection() {
        return tsesionparametrosCollection;
    }

    public void setTsesionparametrosCollection(Collection<Tsesionparametros> tsesionparametrosCollection) {
        this.tsesionparametrosCollection = tsesionparametrosCollection;
    }

    public Tusuarios getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Tusuarios usuarioid) {
        this.usuarioid = usuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sesionid != null ? sesionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsesiones)) {
            return false;
        }
        Tsesiones other = (Tsesiones) object;
        if ((this.sesionid == null && other.sesionid != null) || (this.sesionid != null && !this.sesionid.equals(other.sesionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tsesiones[ sesionid=" + sesionid + " ]";
    }
    
}
