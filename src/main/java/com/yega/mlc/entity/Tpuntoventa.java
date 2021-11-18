/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "tpuntoventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpuntoventa.findAll", query = "SELECT t FROM Tpuntoventa t"),
    @NamedQuery(name = "Tpuntoventa.findByPuntoventaid", query = "SELECT t FROM Tpuntoventa t WHERE t.puntoventaid = :puntoventaid"),
    @NamedQuery(name = "Tpuntoventa.findByClavepuntoventa", query = "SELECT t FROM Tpuntoventa t WHERE t.clavepuntoventa = :clavepuntoventa"),
    @NamedQuery(name = "Tpuntoventa.findByDescripcionpuntoventa", query = "SELECT t FROM Tpuntoventa t WHERE t.descripcionpuntoventa = :descripcionpuntoventa")})
public class Tpuntoventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PUNTOVENTAID")
    private Integer puntoventaid;
    @Basic(optional = false)
    @Column(name = "CLAVEPUNTOVENTA")
    private String clavepuntoventa;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONPUNTOVENTA")
    private String descripcionpuntoventa;
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne(optional = false)
    private Tpersona personaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puntoventaid")
    private Collection<Tenlace> tenlaceCollection;

    public Tpuntoventa() {
    }

    public Tpuntoventa(Integer puntoventaid) {
        this.puntoventaid = puntoventaid;
    }

    public Tpuntoventa(Integer puntoventaid, String clavepuntoventa, String descripcionpuntoventa) {
        this.puntoventaid = puntoventaid;
        this.clavepuntoventa = clavepuntoventa;
        this.descripcionpuntoventa = descripcionpuntoventa;
    }

    public Integer getPuntoventaid() {
        return puntoventaid;
    }

    public void setPuntoventaid(Integer puntoventaid) {
        this.puntoventaid = puntoventaid;
    }

    public String getClavepuntoventa() {
        return clavepuntoventa;
    }

    public void setClavepuntoventa(String clavepuntoventa) {
        this.clavepuntoventa = clavepuntoventa;
    }

    public String getDescripcionpuntoventa() {
        return descripcionpuntoventa;
    }

    public void setDescripcionpuntoventa(String descripcionpuntoventa) {
        this.descripcionpuntoventa = descripcionpuntoventa;
    }

    public Tpersona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Tpersona personaid) {
        this.personaid = personaid;
    }

    @XmlTransient
    public Collection<Tenlace> getTenlaceCollection() {
        return tenlaceCollection;
    }

    public void setTenlaceCollection(Collection<Tenlace> tenlaceCollection) {
        this.tenlaceCollection = tenlaceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puntoventaid != null ? puntoventaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpuntoventa)) {
            return false;
        }
        Tpuntoventa other = (Tpuntoventa) object;
        if ((this.puntoventaid == null && other.puntoventaid != null) || (this.puntoventaid != null && !this.puntoventaid.equals(other.puntoventaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tpuntoventa[ puntoventaid=" + puntoventaid + " ]";
    }
    
}
