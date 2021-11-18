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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "tconfiguracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tconfiguracion.findAll", query = "SELECT t FROM Tconfiguracion t"),
    @NamedQuery(name = "Tconfiguracion.findByConfiguracionid", query = "SELECT t FROM Tconfiguracion t WHERE t.configuracionid = :configuracionid"),
    @NamedQuery(name = "Tconfiguracion.findByNombre", query = "SELECT t FROM Tconfiguracion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tconfiguracion.findByValor", query = "SELECT t FROM Tconfiguracion t WHERE t.valor = :valor")})
public class Tconfiguracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONFIGURACIONID")
    private Short configuracionid;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private String valor;

    public Tconfiguracion() {
    }

    public Tconfiguracion(Short configuracionid) {
        this.configuracionid = configuracionid;
    }

    public Tconfiguracion(Short configuracionid, String nombre, String valor) {
        this.configuracionid = configuracionid;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Short getConfiguracionid() {
        return configuracionid;
    }

    public void setConfiguracionid(Short configuracionid) {
        this.configuracionid = configuracionid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configuracionid != null ? configuracionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tconfiguracion)) {
            return false;
        }
        Tconfiguracion other = (Tconfiguracion) object;
        if ((this.configuracionid == null && other.configuracionid != null) || (this.configuracionid != null && !this.configuracionid.equals(other.configuracionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tconfiguracion[ configuracionid=" + configuracionid + " ]";
    }
    
}
