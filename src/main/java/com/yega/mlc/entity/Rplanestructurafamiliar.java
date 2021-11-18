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
@Table(name = "rplanestructurafamiliar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rplanestructurafamiliar.findAll", query = "SELECT r FROM Rplanestructurafamiliar r"),
    @NamedQuery(name = "Rplanestructurafamiliar.findByPlanestructurafamiliarid", query = "SELECT r FROM Rplanestructurafamiliar r WHERE r.planestructurafamiliarid = :planestructurafamiliarid")})
public class Rplanestructurafamiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLANESTRUCTURAFAMILIARID")
    private Integer planestructurafamiliarid;
    @JoinColumn(name = "CLTIPOBENEFICIARIOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle cltipobeneficiarioid;
    @JoinColumn(name = "TIPOPLANID", referencedColumnName = "TIPOPLANID")
    @ManyToOne(optional = false)
    private Ttipoplan tipoplanid;

    public Rplanestructurafamiliar() {
    }

    public Rplanestructurafamiliar(Integer planestructurafamiliarid) {
        this.planestructurafamiliarid = planestructurafamiliarid;
    }

    public Integer getPlanestructurafamiliarid() {
        return planestructurafamiliarid;
    }

    public void setPlanestructurafamiliarid(Integer planestructurafamiliarid) {
        this.planestructurafamiliarid = planestructurafamiliarid;
    }

    public Cmaestrodetalle getCltipobeneficiarioid() {
        return cltipobeneficiarioid;
    }

    public void setCltipobeneficiarioid(Cmaestrodetalle cltipobeneficiarioid) {
        this.cltipobeneficiarioid = cltipobeneficiarioid;
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
        hash += (planestructurafamiliarid != null ? planestructurafamiliarid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rplanestructurafamiliar)) {
            return false;
        }
        Rplanestructurafamiliar other = (Rplanestructurafamiliar) object;
        if ((this.planestructurafamiliarid == null && other.planestructurafamiliarid != null) || (this.planestructurafamiliarid != null && !this.planestructurafamiliarid.equals(other.planestructurafamiliarid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Rplanestructurafamiliar[ planestructurafamiliarid=" + planestructurafamiliarid + " ]";
    }
    
}
