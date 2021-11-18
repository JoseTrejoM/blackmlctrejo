/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tsesionparametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsesionparametros.findAll", query = "SELECT t FROM Tsesionparametros t"),
    @NamedQuery(name = "Tsesionparametros.findByParametroid", query = "SELECT t FROM Tsesionparametros t WHERE t.tsesionparametrosPK.parametroid = :parametroid"),
    @NamedQuery(name = "Tsesionparametros.findBySesionid", query = "SELECT t FROM Tsesionparametros t WHERE t.tsesionparametrosPK.sesionid = :sesionid"),
    @NamedQuery(name = "Tsesionparametros.findByNombreparametro", query = "SELECT t FROM Tsesionparametros t WHERE t.nombreparametro = :nombreparametro"),
    @NamedQuery(name = "Tsesionparametros.findByValorparametro", query = "SELECT t FROM Tsesionparametros t WHERE t.valorparametro = :valorparametro")})
public class Tsesionparametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TsesionparametrosPK tsesionparametrosPK;
    @Basic(optional = false)
    @Column(name = "NOMBREPARAMETRO")
    private String nombreparametro;
    @Basic(optional = false)
    @Column(name = "VALORPARAMETRO")
    private String valorparametro;
    @JoinColumn(name = "SESIONID", referencedColumnName = "SESIONID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tsesiones tsesiones;

    public Tsesionparametros() {
    }

    public Tsesionparametros(TsesionparametrosPK tsesionparametrosPK) {
        this.tsesionparametrosPK = tsesionparametrosPK;
    }

    public Tsesionparametros(TsesionparametrosPK tsesionparametrosPK, String nombreparametro, String valorparametro) {
        this.tsesionparametrosPK = tsesionparametrosPK;
        this.nombreparametro = nombreparametro;
        this.valorparametro = valorparametro;
    }

    public Tsesionparametros(int parametroid, int sesionid) {
        this.tsesionparametrosPK = new TsesionparametrosPK(parametroid, sesionid);
    }

    public TsesionparametrosPK getTsesionparametrosPK() {
        return tsesionparametrosPK;
    }

    public void setTsesionparametrosPK(TsesionparametrosPK tsesionparametrosPK) {
        this.tsesionparametrosPK = tsesionparametrosPK;
    }

    public String getNombreparametro() {
        return nombreparametro;
    }

    public void setNombreparametro(String nombreparametro) {
        this.nombreparametro = nombreparametro;
    }

    public String getValorparametro() {
        return valorparametro;
    }

    public void setValorparametro(String valorparametro) {
        this.valorparametro = valorparametro;
    }

    public Tsesiones getTsesiones() {
        return tsesiones;
    }

    public void setTsesiones(Tsesiones tsesiones) {
        this.tsesiones = tsesiones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tsesionparametrosPK != null ? tsesionparametrosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsesionparametros)) {
            return false;
        }
        Tsesionparametros other = (Tsesionparametros) object;
        if ((this.tsesionparametrosPK == null && other.tsesionparametrosPK != null) || (this.tsesionparametrosPK != null && !this.tsesionparametrosPK.equals(other.tsesionparametrosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tsesionparametros[ tsesionparametrosPK=" + tsesionparametrosPK + " ]";
    }
    
}
