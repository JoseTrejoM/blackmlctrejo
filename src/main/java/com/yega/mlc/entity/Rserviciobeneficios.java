/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "rserviciobeneficios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rserviciobeneficios.findAll", query = "SELECT r FROM Rserviciobeneficios r"),
    @NamedQuery(name = "Rserviciobeneficios.findByServiciobeneficiosid", query = "SELECT r FROM Rserviciobeneficios r WHERE r.serviciobeneficiosid = :serviciobeneficiosid"),
    @NamedQuery(name = "Rserviciobeneficios.findByBeneficioid", query = "SELECT r FROM Rserviciobeneficios r WHERE r.beneficioid = :beneficioid")})
public class Rserviciobeneficios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICIOBENEFICIOSID")
    private Integer serviciobeneficiosid;
    @Basic(optional = false)
    @Column(name = "BENEFICIOID")
    private int beneficioid;
    @JoinColumn(name = "TIPOPLANID", referencedColumnName = "TIPOPLANID")
    @ManyToOne(optional = false)
    private Ttipoplan tipoplanid;

    public Rserviciobeneficios() {
    }

    public Rserviciobeneficios(Integer serviciobeneficiosid) {
        this.serviciobeneficiosid = serviciobeneficiosid;
    }

    public Rserviciobeneficios(Integer serviciobeneficiosid, int beneficioid) {
        this.serviciobeneficiosid = serviciobeneficiosid;
        this.beneficioid = beneficioid;
    }

    public Integer getServiciobeneficiosid() {
        return serviciobeneficiosid;
    }

    public void setServiciobeneficiosid(Integer serviciobeneficiosid) {
        this.serviciobeneficiosid = serviciobeneficiosid;
    }

    public int getBeneficioid() {
        return beneficioid;
    }

    public void setBeneficioid(int beneficioid) {
        this.beneficioid = beneficioid;
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
        hash += (serviciobeneficiosid != null ? serviciobeneficiosid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rserviciobeneficios)) {
            return false;
        }
        Rserviciobeneficios other = (Rserviciobeneficios) object;
        if ((this.serviciobeneficiosid == null && other.serviciobeneficiosid != null) || (this.serviciobeneficiosid != null && !this.serviciobeneficiosid.equals(other.serviciobeneficiosid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Rserviciobeneficios[ serviciobeneficiosid=" + serviciobeneficiosid + " ]";
    }
    
}
