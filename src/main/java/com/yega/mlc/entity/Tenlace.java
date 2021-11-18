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
@Table(name = "tenlace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tenlace.findAll", query = "SELECT t FROM Tenlace t"),
    @NamedQuery(name = "Tenlace.findByEnlaceid", query = "SELECT t FROM Tenlace t WHERE t.enlaceid = :enlaceid"),
    @NamedQuery(name = "Tenlace.findByFechaalta", query = "SELECT t FROM Tenlace t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tenlace.findByUsuarioalta", query = "SELECT t FROM Tenlace t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tenlace.findByFechamodificacion", query = "SELECT t FROM Tenlace t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tenlace.findByUsuariomodificacion", query = "SELECT t FROM Tenlace t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tenlace.findByActivo", query = "SELECT t FROM Tenlace t WHERE t.activo = :activo")})
public class Tenlace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ENLACEID")
    private Integer enlaceid;
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
    @OneToMany(mappedBy = "enlaceid")
    private Collection<Tpropuesta> tpropuestaCollection;
    @JoinColumn(name = "CLTIPOCOMISIONISTAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle cltipocomisionistaid;
    @OneToMany(mappedBy = "enlacepadreid")
    private Collection<Tenlace> tenlaceCollection;
    @JoinColumn(name = "ENLACEPADREID", referencedColumnName = "ENLACEID")
    @ManyToOne
    private Tenlace enlacepadreid;
    @JoinColumn(name = "PERSONAFISICAID", referencedColumnName = "PERSONAFISICAID")
    @ManyToOne(optional = false)
    private Tpersonafisica personafisicaid;
    @JoinColumn(name = "PUNTOVENTAID", referencedColumnName = "PUNTOVENTAID")
    @ManyToOne(optional = false)
    private Tpuntoventa puntoventaid;

    public Tenlace() {
    }

    public Tenlace(Integer enlaceid) {
        this.enlaceid = enlaceid;
    }

    public Tenlace(Integer enlaceid, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.enlaceid = enlaceid;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getEnlaceid() {
        return enlaceid;
    }

    public void setEnlaceid(Integer enlaceid) {
        this.enlaceid = enlaceid;
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
    public Collection<Tpropuesta> getTpropuestaCollection() {
        return tpropuestaCollection;
    }

    public void setTpropuestaCollection(Collection<Tpropuesta> tpropuestaCollection) {
        this.tpropuestaCollection = tpropuestaCollection;
    }

    public Cmaestrodetalle getCltipocomisionistaid() {
        return cltipocomisionistaid;
    }

    public void setCltipocomisionistaid(Cmaestrodetalle cltipocomisionistaid) {
        this.cltipocomisionistaid = cltipocomisionistaid;
    }

    @XmlTransient
    public Collection<Tenlace> getTenlaceCollection() {
        return tenlaceCollection;
    }

    public void setTenlaceCollection(Collection<Tenlace> tenlaceCollection) {
        this.tenlaceCollection = tenlaceCollection;
    }

    public Tenlace getEnlacepadreid() {
        return enlacepadreid;
    }

    public void setEnlacepadreid(Tenlace enlacepadreid) {
        this.enlacepadreid = enlacepadreid;
    }

    public Tpersonafisica getPersonafisicaid() {
        return personafisicaid;
    }

    public void setPersonafisicaid(Tpersonafisica personafisicaid) {
        this.personafisicaid = personafisicaid;
    }

    public Tpuntoventa getPuntoventaid() {
        return puntoventaid;
    }

    public void setPuntoventaid(Tpuntoventa puntoventaid) {
        this.puntoventaid = puntoventaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enlaceid != null ? enlaceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tenlace)) {
            return false;
        }
        Tenlace other = (Tenlace) object;
        if ((this.enlaceid == null && other.enlaceid != null) || (this.enlaceid != null && !this.enlaceid.equals(other.enlaceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tenlace[ enlaceid=" + enlaceid + " ]";
    }
    
}
