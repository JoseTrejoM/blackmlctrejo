/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "rmodulodocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rmodulodocumento.findAll", query = "SELECT r FROM Rmodulodocumento r"),
    @NamedQuery(name = "Rmodulodocumento.findByFolioid", query = "SELECT r FROM Rmodulodocumento r WHERE r.rmodulodocumentoPK.folioid = :folioid"),
    @NamedQuery(name = "Rmodulodocumento.findBySismodid", query = "SELECT r FROM Rmodulodocumento r WHERE r.rmodulodocumentoPK.sismodid = :sismodid"),
    @NamedQuery(name = "Rmodulodocumento.findByUsuarioid", query = "SELECT r FROM Rmodulodocumento r WHERE r.rmodulodocumentoPK.usuarioid = :usuarioid")})
public class Rmodulodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RmodulodocumentoPK rmodulodocumentoPK;
    @JoinColumn(name = "FOLIOID", referencedColumnName = "PERSONAID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tpersona tpersona;
    @JoinColumn(name = "FOLIOID", referencedColumnName = "SERVICIOCONTRATADOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tservicioscontratados tservicioscontratados;
    @JoinColumn(name = "SISMODID", referencedColumnName = "SISMODID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tsistemamodulo tsistemamodulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rmodulodocumento")
    private Collection<Tcontroldocumentos> tcontroldocumentosCollection;

    public Rmodulodocumento() {
    }

    public Rmodulodocumento(RmodulodocumentoPK rmodulodocumentoPK) {
        this.rmodulodocumentoPK = rmodulodocumentoPK;
    }

    public Rmodulodocumento(int folioid, int sismodid, int usuarioid) {
        this.rmodulodocumentoPK = new RmodulodocumentoPK(folioid, sismodid, usuarioid);
    }

    public RmodulodocumentoPK getRmodulodocumentoPK() {
        return rmodulodocumentoPK;
    }

    public void setRmodulodocumentoPK(RmodulodocumentoPK rmodulodocumentoPK) {
        this.rmodulodocumentoPK = rmodulodocumentoPK;
    }

    public Tpersona getTpersona() {
        return tpersona;
    }

    public void setTpersona(Tpersona tpersona) {
        this.tpersona = tpersona;
    }

    public Tservicioscontratados getTservicioscontratados() {
        return tservicioscontratados;
    }

    public void setTservicioscontratados(Tservicioscontratados tservicioscontratados) {
        this.tservicioscontratados = tservicioscontratados;
    }

    public Tsistemamodulo getTsistemamodulo() {
        return tsistemamodulo;
    }

    public void setTsistemamodulo(Tsistemamodulo tsistemamodulo) {
        this.tsistemamodulo = tsistemamodulo;
    }

    @XmlTransient
    public Collection<Tcontroldocumentos> getTcontroldocumentosCollection() {
        return tcontroldocumentosCollection;
    }

    public void setTcontroldocumentosCollection(Collection<Tcontroldocumentos> tcontroldocumentosCollection) {
        this.tcontroldocumentosCollection = tcontroldocumentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmodulodocumentoPK != null ? rmodulodocumentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rmodulodocumento)) {
            return false;
        }
        Rmodulodocumento other = (Rmodulodocumento) object;
        if ((this.rmodulodocumentoPK == null && other.rmodulodocumentoPK != null) || (this.rmodulodocumentoPK != null && !this.rmodulodocumentoPK.equals(other.rmodulodocumentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Rmodulodocumento[ rmodulodocumentoPK=" + rmodulodocumentoPK + " ]";
    }
    
}
