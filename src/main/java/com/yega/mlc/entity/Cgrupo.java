/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "cgrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cgrupo.findAll", query = "SELECT c FROM Cgrupo c"),
    @NamedQuery(name = "Cgrupo.findByGrupoid", query = "SELECT c FROM Cgrupo c WHERE c.grupoid = :grupoid"),
    @NamedQuery(name = "Cgrupo.findByClavegrupo", query = "SELECT c FROM Cgrupo c WHERE c.clavegrupo = :clavegrupo"),
    @NamedQuery(name = "Cgrupo.findByDescripciongrupo", query = "SELECT c FROM Cgrupo c WHERE c.descripciongrupo = :descripciongrupo"),
    @NamedQuery(name = "Cgrupo.findByFechaalta", query = "SELECT c FROM Cgrupo c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cgrupo.findByUsuarioalta", query = "SELECT c FROM Cgrupo c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cgrupo.findByFechamodificacion", query = "SELECT c FROM Cgrupo c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cgrupo.findByUsuariomodificacion", query = "SELECT c FROM Cgrupo c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cgrupo.findByActivo", query = "SELECT c FROM Cgrupo c WHERE c.activo = :activo")})
public class Cgrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRUPOID")
    private Integer grupoid;
    @Basic(optional = false)
    @Column(name = "CLAVEGRUPO")
    private String clavegrupo;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONGRUPO")
    private String descripciongrupo;
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
    @JoinTable(name = "rusuariogrupo", joinColumns = {
        @JoinColumn(name = "GRUPOID", referencedColumnName = "GRUPOID")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")})
    @ManyToMany
    private Collection<Tusuarios> tusuariosCollection;
    @JoinTable(name = "rgrupopermisos", joinColumns = {
        @JoinColumn(name = "GRUPOID", referencedColumnName = "GRUPOID")}, inverseJoinColumns = {
        @JoinColumn(name = "SISMODID", referencedColumnName = "SISMODID"),
        @JoinColumn(name = "PERMISOID", referencedColumnName = "PERMISOID")})
    @ManyToMany
    private Collection<Tpermisos> tpermisosCollection;
    @JoinTable(name = "rrolgrupo", joinColumns = {
        @JoinColumn(name = "GRUPOID", referencedColumnName = "GRUPOID")}, inverseJoinColumns = {
        @JoinColumn(name = "ROLID", referencedColumnName = "CATALOGODETALLEID")})
    @ManyToMany
    private Collection<Cmaestrodetalle> cmaestrodetalleCollection;

    public Cgrupo() {
    }

    public Cgrupo(Integer grupoid) {
        this.grupoid = grupoid;
    }

    public Cgrupo(Integer grupoid, String clavegrupo, String descripciongrupo, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.grupoid = grupoid;
        this.clavegrupo = clavegrupo;
        this.descripciongrupo = descripciongrupo;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(Integer grupoid) {
        this.grupoid = grupoid;
    }

    public String getClavegrupo() {
        return clavegrupo;
    }

    public void setClavegrupo(String clavegrupo) {
        this.clavegrupo = clavegrupo;
    }

    public String getDescripciongrupo() {
        return descripciongrupo;
    }

    public void setDescripciongrupo(String descripciongrupo) {
        this.descripciongrupo = descripciongrupo;
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

    @XmlTransient
    public Collection<Tusuarios> getTusuariosCollection() {
        return tusuariosCollection;
    }

    public void setTusuariosCollection(Collection<Tusuarios> tusuariosCollection) {
        this.tusuariosCollection = tusuariosCollection;
    }

    @XmlTransient
    public Collection<Tpermisos> getTpermisosCollection() {
        return tpermisosCollection;
    }

    public void setTpermisosCollection(Collection<Tpermisos> tpermisosCollection) {
        this.tpermisosCollection = tpermisosCollection;
    }

    @XmlTransient
    public Collection<Cmaestrodetalle> getCmaestrodetalleCollection() {
        return cmaestrodetalleCollection;
    }

    public void setCmaestrodetalleCollection(Collection<Cmaestrodetalle> cmaestrodetalleCollection) {
        this.cmaestrodetalleCollection = cmaestrodetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoid != null ? grupoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cgrupo)) {
            return false;
        }
        Cgrupo other = (Cgrupo) object;
        if ((this.grupoid == null && other.grupoid != null) || (this.grupoid != null && !this.grupoid.equals(other.grupoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cgrupo[ grupoid=" + grupoid + " ]";
    }
    
}
