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
@Table(name = "tcontactopersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcontactopersona.findAll", query = "SELECT t FROM Tcontactopersona t"),
    @NamedQuery(name = "Tcontactopersona.findByContactopersonaid", query = "SELECT t FROM Tcontactopersona t WHERE t.contactopersonaid = :contactopersonaid"),
    @NamedQuery(name = "Tcontactopersona.findByContacto", query = "SELECT t FROM Tcontactopersona t WHERE t.contacto = :contacto"),
    @NamedQuery(name = "Tcontactopersona.findByPrincipal", query = "SELECT t FROM Tcontactopersona t WHERE t.principal = :principal"),
    @NamedQuery(name = "Tcontactopersona.findByFechaalta", query = "SELECT t FROM Tcontactopersona t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tcontactopersona.findByUsuarioalta", query = "SELECT t FROM Tcontactopersona t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tcontactopersona.findByFechamodificacion", query = "SELECT t FROM Tcontactopersona t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tcontactopersona.findByUsuariomodificacion", query = "SELECT t FROM Tcontactopersona t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tcontactopersona.findByActivo", query = "SELECT t FROM Tcontactopersona t WHERE t.activo = :activo")})
public class Tcontactopersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTACTOPERSONAID")
    private Integer contactopersonaid;
    @Basic(optional = false)
    @Column(name = "CONTACTO")
    private String contacto;
    @Basic(optional = false)
    @Column(name = "PRINCIPAL")
    private boolean principal;
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
    @JoinColumn(name = "CLTIPOCONTACTOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle cltipocontactoid;
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne(optional = false)
    private Tpersona personaid;

    public Tcontactopersona() {
    }

    public Tcontactopersona(Integer contactopersonaid) {
        this.contactopersonaid = contactopersonaid;
    }

    public Tcontactopersona(Integer contactopersonaid, String contacto, boolean principal, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.contactopersonaid = contactopersonaid;
        this.contacto = contacto;
        this.principal = principal;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getContactopersonaid() {
        return contactopersonaid;
    }

    public void setContactopersonaid(Integer contactopersonaid) {
        this.contactopersonaid = contactopersonaid;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
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

    public Cmaestrodetalle getCltipocontactoid() {
        return cltipocontactoid;
    }

    public void setCltipocontactoid(Cmaestrodetalle cltipocontactoid) {
        this.cltipocontactoid = cltipocontactoid;
    }

    public Tpersona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Tpersona personaid) {
        this.personaid = personaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactopersonaid != null ? contactopersonaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcontactopersona)) {
            return false;
        }
        Tcontactopersona other = (Tcontactopersona) object;
        if ((this.contactopersonaid == null && other.contactopersonaid != null) || (this.contactopersonaid != null && !this.contactopersonaid.equals(other.contactopersonaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tcontactopersona[ contactopersonaid=" + contactopersonaid + " ]";
    }
    
}
