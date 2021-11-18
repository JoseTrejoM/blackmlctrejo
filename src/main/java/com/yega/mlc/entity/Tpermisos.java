/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "tpermisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpermisos.findAll", query = "SELECT t FROM Tpermisos t"),
    @NamedQuery(name = "Tpermisos.findBySismodid", query = "SELECT t FROM Tpermisos t WHERE t.tpermisosPK.sismodid = :sismodid"),
    @NamedQuery(name = "Tpermisos.findByPermisoid", query = "SELECT t FROM Tpermisos t WHERE t.tpermisosPK.permisoid = :permisoid"),
    @NamedQuery(name = "Tpermisos.findByDescripcionpermiso", query = "SELECT t FROM Tpermisos t WHERE t.descripcionpermiso = :descripcionpermiso")})
public class Tpermisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TpermisosPK tpermisosPK;
    @Column(name = "DESCRIPCIONPERMISO")
    private String descripcionpermiso;
    @ManyToMany(mappedBy = "tpermisosCollection")
    private Collection<Cgrupo> cgrupoCollection;
    @JoinColumn(name = "SISMODID", referencedColumnName = "SISMODID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tsistemamodulo tsistemamodulo;

    public Tpermisos() {
    }

    public Tpermisos(TpermisosPK tpermisosPK) {
        this.tpermisosPK = tpermisosPK;
    }

    public Tpermisos(int sismodid, int permisoid) {
        this.tpermisosPK = new TpermisosPK(sismodid, permisoid);
    }

    public TpermisosPK getTpermisosPK() {
        return tpermisosPK;
    }

    public void setTpermisosPK(TpermisosPK tpermisosPK) {
        this.tpermisosPK = tpermisosPK;
    }

    public String getDescripcionpermiso() {
        return descripcionpermiso;
    }

    public void setDescripcionpermiso(String descripcionpermiso) {
        this.descripcionpermiso = descripcionpermiso;
    }

    @XmlTransient
    public Collection<Cgrupo> getCgrupoCollection() {
        return cgrupoCollection;
    }

    public void setCgrupoCollection(Collection<Cgrupo> cgrupoCollection) {
        this.cgrupoCollection = cgrupoCollection;
    }

    public Tsistemamodulo getTsistemamodulo() {
        return tsistemamodulo;
    }

    public void setTsistemamodulo(Tsistemamodulo tsistemamodulo) {
        this.tsistemamodulo = tsistemamodulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpermisosPK != null ? tpermisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpermisos)) {
            return false;
        }
        Tpermisos other = (Tpermisos) object;
        if ((this.tpermisosPK == null && other.tpermisosPK != null) || (this.tpermisosPK != null && !this.tpermisosPK.equals(other.tpermisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tpermisos[ tpermisosPK=" + tpermisosPK + " ]";
    }
    
}
