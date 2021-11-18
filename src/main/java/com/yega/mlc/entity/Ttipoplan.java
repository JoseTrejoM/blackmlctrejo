/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "ttipoplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttipoplan.findAll", query = "SELECT t FROM Ttipoplan t"),
    @NamedQuery(name = "Ttipoplan.findByTipoplanid", query = "SELECT t FROM Ttipoplan t WHERE t.tipoplanid = :tipoplanid"),
    @NamedQuery(name = "Ttipoplan.findByClaveplan", query = "SELECT t FROM Ttipoplan t WHERE t.claveplan = :claveplan"),
    @NamedQuery(name = "Ttipoplan.findByDescripcionplan", query = "SELECT t FROM Ttipoplan t WHERE t.descripcionplan = :descripcionplan"),
    @NamedQuery(name = "Ttipoplan.findByPrecio", query = "SELECT t FROM Ttipoplan t WHERE t.precio = :precio"),
    @NamedQuery(name = "Ttipoplan.findByEdadminima", query = "SELECT t FROM Ttipoplan t WHERE t.edadminima = :edadminima"),
    @NamedQuery(name = "Ttipoplan.findByEdadmaxima", query = "SELECT t FROM Ttipoplan t WHERE t.edadmaxima = :edadmaxima"),
//    @NamedQuery(name = "Ttipoplan.findByResideextranjero", query = "SELECT t FROM Ttipoplan t WHERE t.resideextranjero = :resideextranjero"),
    @NamedQuery(name = "Ttipoplan.findByFechaalta", query = "SELECT t FROM Ttipoplan t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Ttipoplan.findByUsuarioalta", query = "SELECT t FROM Ttipoplan t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Ttipoplan.findByFechamodificacion", query = "SELECT t FROM Ttipoplan t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Ttipoplan.findByUsuariomodificacion", query = "SELECT t FROM Ttipoplan t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Ttipoplan.findByActivo", query = "SELECT t FROM Ttipoplan t WHERE t.activo = :activo")})
public class Ttipoplan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPOPLANID")
    private Integer tipoplanid;
    @Basic(optional = false)
    @Column(name = "CLAVEPLAN")
    private String claveplan;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONPLAN")
    private String descripcionplan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Column(name = "EDADMINIMA")
    private Short edadminima;
    @Column(name = "EDADMAXIMA")
    private Short edadmaxima;
//    @Column(name = "RESIDEEXTRANJERO")
//    private Short resideextranjero;
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
    @JoinColumn(name = "CLMONEDAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clmonedaid;
    @JoinColumn(name = "CLPROGRAMAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clprogramaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoplanid")
    private Collection<Tpreciosumaasegurada> tpreciosumaaseguradaCollection;
    @OneToMany(mappedBy = "tipoplanid")
    private Collection<Tservicioscontratados> tservicioscontratadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoplanid")
    private Collection<Rserviciobeneficios> rserviciobeneficiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoplanid")
    private Collection<Rplanestructurafamiliar> rplanestructurafamiliarCollection;

    public Ttipoplan() {
    }

    public Ttipoplan(Integer tipoplanid) {
        this.tipoplanid = tipoplanid;
    }

    public Ttipoplan(Integer tipoplanid, String claveplan, String descripcionplan, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.tipoplanid = tipoplanid;
        this.claveplan = claveplan;
        this.descripcionplan = descripcionplan;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getTipoplanid() {
        return tipoplanid;
    }

    public void setTipoplanid(Integer tipoplanid) {
        this.tipoplanid = tipoplanid;
    }

    public String getClaveplan() {
        return claveplan;
    }

    public void setClaveplan(String claveplan) {
        this.claveplan = claveplan;
    }

    public String getDescripcionplan() {
        return descripcionplan;
    }

    public void setDescripcionplan(String descripcionplan) {
        this.descripcionplan = descripcionplan;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Short getEdadminima() {
        return edadminima;
    }

    public void setEdadminima(Short edadminima) {
        this.edadminima = edadminima;
    }

    public Short getEdadmaxima() {
        return edadmaxima;
    }

    public void setEdadmaxima(Short edadmaxima) {
        this.edadmaxima = edadmaxima;
    }

//    public Short getResideextranjero() {
//        return resideextranjero;
//    }

//    public void setResideextranjero(Short resideextranjero) {
//        this.resideextranjero = resideextranjero;
//    }

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

    public Cmaestrodetalle getClmonedaid() {
        return clmonedaid;
    }

    public void setClmonedaid(Cmaestrodetalle clmonedaid) {
        this.clmonedaid = clmonedaid;
    }

    public Cmaestrodetalle getClprogramaid() {
        return clprogramaid;
    }

    public void setClprogramaid(Cmaestrodetalle clprogramaid) {
        this.clprogramaid = clprogramaid;
    }

    @XmlTransient
    public Collection<Tpreciosumaasegurada> getTpreciosumaaseguradaCollection() {
        return tpreciosumaaseguradaCollection;
    }

    public void setTpreciosumaaseguradaCollection(Collection<Tpreciosumaasegurada> tpreciosumaaseguradaCollection) {
        this.tpreciosumaaseguradaCollection = tpreciosumaaseguradaCollection;
    }

    @XmlTransient
    public Collection<Tservicioscontratados> getTservicioscontratadosCollection() {
        return tservicioscontratadosCollection;
    }

    public void setTservicioscontratadosCollection(Collection<Tservicioscontratados> tservicioscontratadosCollection) {
        this.tservicioscontratadosCollection = tservicioscontratadosCollection;
    }

    @XmlTransient
    public Collection<Rserviciobeneficios> getRserviciobeneficiosCollection() {
        return rserviciobeneficiosCollection;
    }

    public void setRserviciobeneficiosCollection(Collection<Rserviciobeneficios> rserviciobeneficiosCollection) {
        this.rserviciobeneficiosCollection = rserviciobeneficiosCollection;
    }

    @XmlTransient
    public Collection<Rplanestructurafamiliar> getRplanestructurafamiliarCollection() {
        return rplanestructurafamiliarCollection;
    }

    public void setRplanestructurafamiliarCollection(Collection<Rplanestructurafamiliar> rplanestructurafamiliarCollection) {
        this.rplanestructurafamiliarCollection = rplanestructurafamiliarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoplanid != null ? tipoplanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ttipoplan)) {
            return false;
        }
        Ttipoplan other = (Ttipoplan) object;
        if ((this.tipoplanid == null && other.tipoplanid != null) || (this.tipoplanid != null && !this.tipoplanid.equals(other.tipoplanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Ttipoplan[ tipoplanid=" + tipoplanid + " ]";
    }
    
}
