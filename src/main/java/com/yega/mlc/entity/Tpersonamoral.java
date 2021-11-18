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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "tpersonamoral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpersonamoral.findAll", query = "SELECT t FROM Tpersonamoral t"),
    @NamedQuery(name = "Tpersonamoral.findByPersonamoralid", query = "SELECT t FROM Tpersonamoral t WHERE t.personamoralid = :personamoralid"),
    @NamedQuery(name = "Tpersonamoral.findByRazonsocial", query = "SELECT t FROM Tpersonamoral t WHERE t.razonsocial = :razonsocial"),
    @NamedQuery(name = "Tpersonamoral.findByNombrecomercial", query = "SELECT t FROM Tpersonamoral t WHERE t.nombrecomercial = :nombrecomercial"),
    @NamedQuery(name = "Tpersonamoral.findByTin", query = "SELECT t FROM Tpersonamoral t WHERE t.tin = :tin")})
public class Tpersonamoral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PERSONAMORALID")
    private Integer personamoralid;
    @Basic(optional = false)
    @Column(name = "RAZONSOCIAL")
    private String razonsocial;
    @Basic(optional = false)
    @Column(name = "NOMBRECOMERCIAL")
    private String nombrecomercial;
    @Column(name = "TIN")
    private String tin;
    @JoinColumn(name = "CLPERSONALIDADJURIDICAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clpersonalidadjuridicaid;
    @JoinColumn(name = "CLTIPOEMPRESAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle cltipoempresaid;
    @JoinColumn(name = "PERSONAMORALID", referencedColumnName = "PERSONAID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tpersona tpersona;

    public Tpersonamoral() {
    }

    public Tpersonamoral(Integer personamoralid) {
        this.personamoralid = personamoralid;
    }

    public Tpersonamoral(Integer personamoralid, String razonsocial, String nombrecomercial) {
        this.personamoralid = personamoralid;
        this.razonsocial = razonsocial;
        this.nombrecomercial = nombrecomercial;
    }

    public Integer getPersonamoralid() {
        return personamoralid;
    }

    public void setPersonamoralid(Integer personamoralid) {
        this.personamoralid = personamoralid;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getNombrecomercial() {
        return nombrecomercial;
    }

    public void setNombrecomercial(String nombrecomercial) {
        this.nombrecomercial = nombrecomercial;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public Cmaestrodetalle getClpersonalidadjuridicaid() {
        return clpersonalidadjuridicaid;
    }

    public void setClpersonalidadjuridicaid(Cmaestrodetalle clpersonalidadjuridicaid) {
        this.clpersonalidadjuridicaid = clpersonalidadjuridicaid;
    }

    public Cmaestrodetalle getCltipoempresaid() {
        return cltipoempresaid;
    }

    public void setCltipoempresaid(Cmaestrodetalle cltipoempresaid) {
        this.cltipoempresaid = cltipoempresaid;
    }

    public Tpersona getTpersona() {
        return tpersona;
    }

    public void setTpersona(Tpersona tpersona) {
        this.tpersona = tpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personamoralid != null ? personamoralid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpersonamoral)) {
            return false;
        }
        Tpersonamoral other = (Tpersonamoral) object;
        if ((this.personamoralid == null && other.personamoralid != null) || (this.personamoralid != null && !this.personamoralid.equals(other.personamoralid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tpersonamoral[ personamoralid=" + personamoralid + " ]";
    }
    
}
