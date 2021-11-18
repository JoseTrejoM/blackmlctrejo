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
@Table(name = "tcuentabancaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcuentabancaria.findAll", query = "SELECT t FROM Tcuentabancaria t"),
    @NamedQuery(name = "Tcuentabancaria.findByCuentabancariaid", query = "SELECT t FROM Tcuentabancaria t WHERE t.cuentabancariaid = :cuentabancariaid"),
    @NamedQuery(name = "Tcuentabancaria.findByNumerocuenta", query = "SELECT t FROM Tcuentabancaria t WHERE t.numerocuenta = :numerocuenta"),
    @NamedQuery(name = "Tcuentabancaria.findByCuentaclabe", query = "SELECT t FROM Tcuentabancaria t WHERE t.cuentaclabe = :cuentaclabe"),
    @NamedQuery(name = "Tcuentabancaria.findBySucursal", query = "SELECT t FROM Tcuentabancaria t WHERE t.sucursal = :sucursal")})
public class Tcuentabancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUENTABANCARIAID")
    private Integer cuentabancariaid;
    @Basic(optional = false)
    @Column(name = "NUMEROCUENTA")
    private String numerocuenta;
    @Column(name = "CUENTACLABE")
    private String cuentaclabe;
    @Column(name = "SUCURSAL")
    private String sucursal;
    @JoinColumn(name = "BANCOID", referencedColumnName = "BANCOID")
    @ManyToOne(optional = false)
    private Cbanco bancoid;
    @JoinColumn(name = "CLMONEDAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clmonedaid;
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne(optional = false)
    private Tpersona personaid;

    public Tcuentabancaria() {
    }

    public Tcuentabancaria(Integer cuentabancariaid) {
        this.cuentabancariaid = cuentabancariaid;
    }

    public Tcuentabancaria(Integer cuentabancariaid, String numerocuenta) {
        this.cuentabancariaid = cuentabancariaid;
        this.numerocuenta = numerocuenta;
    }

    public Integer getCuentabancariaid() {
        return cuentabancariaid;
    }

    public void setCuentabancariaid(Integer cuentabancariaid) {
        this.cuentabancariaid = cuentabancariaid;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getCuentaclabe() {
        return cuentaclabe;
    }

    public void setCuentaclabe(String cuentaclabe) {
        this.cuentaclabe = cuentaclabe;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Cbanco getBancoid() {
        return bancoid;
    }

    public void setBancoid(Cbanco bancoid) {
        this.bancoid = bancoid;
    }

    public Cmaestrodetalle getClmonedaid() {
        return clmonedaid;
    }

    public void setClmonedaid(Cmaestrodetalle clmonedaid) {
        this.clmonedaid = clmonedaid;
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
        hash += (cuentabancariaid != null ? cuentabancariaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcuentabancaria)) {
            return false;
        }
        Tcuentabancaria other = (Tcuentabancaria) object;
        if ((this.cuentabancariaid == null && other.cuentabancariaid != null) || (this.cuentabancariaid != null && !this.cuentabancariaid.equals(other.cuentabancariaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tcuentabancaria[ cuentabancariaid=" + cuentabancariaid + " ]";
    }
    
}
