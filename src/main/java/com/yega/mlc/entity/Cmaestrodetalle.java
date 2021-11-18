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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "cmaestrodetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cmaestrodetalle.findAll", query = "SELECT c FROM Cmaestrodetalle c"),
    @NamedQuery(name = "Cmaestrodetalle.findByCatalogodetalleid", query = "SELECT c FROM Cmaestrodetalle c WHERE c.catalogodetalleid = :catalogodetalleid"),
    @NamedQuery(name = "Cmaestrodetalle.findByClave", query = "SELECT c FROM Cmaestrodetalle c WHERE c.clave = :clave"),
    @NamedQuery(name = "Cmaestrodetalle.findByDescripcion", query = "SELECT c FROM Cmaestrodetalle c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cmaestrodetalle.findByOrden", query = "SELECT c FROM Cmaestrodetalle c WHERE c.orden = :orden"),
    @NamedQuery(name = "Cmaestrodetalle.findByFechaalta", query = "SELECT c FROM Cmaestrodetalle c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cmaestrodetalle.findByUsuarioalta", query = "SELECT c FROM Cmaestrodetalle c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cmaestrodetalle.findByFechamodificacion", query = "SELECT c FROM Cmaestrodetalle c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cmaestrodetalle.findByUsuariomodificacion", query = "SELECT c FROM Cmaestrodetalle c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cmaestrodetalle.findByActivo", query = "SELECT c FROM Cmaestrodetalle c WHERE c.activo = :activo")})
public class Cmaestrodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATALOGODETALLEID")
    private Integer catalogodetalleid;
    @Basic(optional = false)
    @Column(name = "CLAVE")
    private String clave;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ORDEN")
    private short orden;
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
    @ManyToMany(mappedBy = "cmaestrodetalleCollection")
    private Collection<Cgrupo> cgrupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cltipobeneficiarioid")
    private Collection<Rbeneficiosbeneficiario> rbeneficiosbeneficiarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clestatuspropuestaid")
    private Collection<Tpropuesta> tpropuestaCollection;
    @OneToMany(mappedBy = "cltipodomicilioid")
    private Collection<Tdomicilio> tdomicilioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clpersonalidadjuridicaid")
    private Collection<Tpersonamoral> tpersonamoralCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cltipoempresaid")
    private Collection<Tpersonamoral> tpersonamoralCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clmonedaid")
    private Collection<Tcuentabancaria> tcuentabancariaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipobeneficiarioid")
    private Collection<Tbeneficiario> tbeneficiarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cltipopersonaid")
    private Collection<Tpersona> tpersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cltipocontactoid")
    private Collection<Tcontactopersona> tcontactopersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clmonedaid")
    private Collection<Ttipoplan> ttipoplanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clprogramaid")
    private Collection<Ttipoplan> ttipoplanCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clreceptorpago")
    private Collection<Cbeneficios> cbeneficiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cltipobeneficio")
    private Collection<Cbeneficios> cbeneficiosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clformapagoid")
    private Collection<Tpagos> tpagosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clmonedapagoid")
    private Collection<Tpagos> tpagosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clestatusservicioid")
    private Collection<Rserviciocontratadoestatusservicio> rserviciocontratadoestatusservicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cltipocomisionistaid")
    private Collection<Tenlace> tenlaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clsexoid")
    private Collection<Tpersonafisica> tpersonafisicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clrangoedadid")
    private Collection<Tpreciosumaasegurada> tpreciosumaaseguradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clsumaaseguradaid")
    private Collection<Tpreciosumaasegurada> tpreciosumaaseguradaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clfrecuenciapagoid")
    private Collection<Tservicioscontratados> tservicioscontratadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatususuarioid")
    private Collection<Tusuarios> tusuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolid")
    private Collection<Tusuarios> tusuariosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipousuarioid")
    private Collection<Tusuarios> tusuariosCollection2;
    @JoinColumn(name = "CATALOGOMAESTROID", referencedColumnName = "CATALOGOMAESTROID")
    @ManyToOne(optional = false)
    private Cmaestro catalogomaestroid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cltipobeneficiarioid")
    private Collection<Rplanestructurafamiliar> rplanestructurafamiliarCollection;

    public Cmaestrodetalle() {
    }

    public Cmaestrodetalle(Integer catalogodetalleid) {
        this.catalogodetalleid = catalogodetalleid;
    }

    public Cmaestrodetalle(Integer catalogodetalleid, String clave, String descripcion, short orden, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.catalogodetalleid = catalogodetalleid;
        this.clave = clave;
        this.descripcion = descripcion;
        this.orden = orden;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getCatalogodetalleid() {
        return catalogodetalleid;
    }

    public void setCatalogodetalleid(Integer catalogodetalleid) {
        this.catalogodetalleid = catalogodetalleid;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
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
    public Collection<Cgrupo> getCgrupoCollection() {
        return cgrupoCollection;
    }

    public void setCgrupoCollection(Collection<Cgrupo> cgrupoCollection) {
        this.cgrupoCollection = cgrupoCollection;
    }

    @XmlTransient
    public Collection<Rbeneficiosbeneficiario> getRbeneficiosbeneficiarioCollection() {
        return rbeneficiosbeneficiarioCollection;
    }

    public void setRbeneficiosbeneficiarioCollection(Collection<Rbeneficiosbeneficiario> rbeneficiosbeneficiarioCollection) {
        this.rbeneficiosbeneficiarioCollection = rbeneficiosbeneficiarioCollection;
    }

    @XmlTransient
    public Collection<Tpropuesta> getTpropuestaCollection() {
        return tpropuestaCollection;
    }

    public void setTpropuestaCollection(Collection<Tpropuesta> tpropuestaCollection) {
        this.tpropuestaCollection = tpropuestaCollection;
    }

    @XmlTransient
    public Collection<Tdomicilio> getTdomicilioCollection() {
        return tdomicilioCollection;
    }

    public void setTdomicilioCollection(Collection<Tdomicilio> tdomicilioCollection) {
        this.tdomicilioCollection = tdomicilioCollection;
    }

    @XmlTransient
    public Collection<Tpersonamoral> getTpersonamoralCollection() {
        return tpersonamoralCollection;
    }

    public void setTpersonamoralCollection(Collection<Tpersonamoral> tpersonamoralCollection) {
        this.tpersonamoralCollection = tpersonamoralCollection;
    }

    @XmlTransient
    public Collection<Tpersonamoral> getTpersonamoralCollection1() {
        return tpersonamoralCollection1;
    }

    public void setTpersonamoralCollection1(Collection<Tpersonamoral> tpersonamoralCollection1) {
        this.tpersonamoralCollection1 = tpersonamoralCollection1;
    }

    @XmlTransient
    public Collection<Tcuentabancaria> getTcuentabancariaCollection() {
        return tcuentabancariaCollection;
    }

    public void setTcuentabancariaCollection(Collection<Tcuentabancaria> tcuentabancariaCollection) {
        this.tcuentabancariaCollection = tcuentabancariaCollection;
    }

    @XmlTransient
    public Collection<Tbeneficiario> getTbeneficiarioCollection() {
        return tbeneficiarioCollection;
    }

    public void setTbeneficiarioCollection(Collection<Tbeneficiario> tbeneficiarioCollection) {
        this.tbeneficiarioCollection = tbeneficiarioCollection;
    }

    @XmlTransient
    public Collection<Tpersona> getTpersonaCollection() {
        return tpersonaCollection;
    }

    public void setTpersonaCollection(Collection<Tpersona> tpersonaCollection) {
        this.tpersonaCollection = tpersonaCollection;
    }

    @XmlTransient
    public Collection<Tcontactopersona> getTcontactopersonaCollection() {
        return tcontactopersonaCollection;
    }

    public void setTcontactopersonaCollection(Collection<Tcontactopersona> tcontactopersonaCollection) {
        this.tcontactopersonaCollection = tcontactopersonaCollection;
    }

    @XmlTransient
    public Collection<Ttipoplan> getTtipoplanCollection() {
        return ttipoplanCollection;
    }

    public void setTtipoplanCollection(Collection<Ttipoplan> ttipoplanCollection) {
        this.ttipoplanCollection = ttipoplanCollection;
    }

    @XmlTransient
    public Collection<Ttipoplan> getTtipoplanCollection1() {
        return ttipoplanCollection1;
    }

    public void setTtipoplanCollection1(Collection<Ttipoplan> ttipoplanCollection1) {
        this.ttipoplanCollection1 = ttipoplanCollection1;
    }

    @XmlTransient
    public Collection<Cbeneficios> getCbeneficiosCollection() {
        return cbeneficiosCollection;
    }

    public void setCbeneficiosCollection(Collection<Cbeneficios> cbeneficiosCollection) {
        this.cbeneficiosCollection = cbeneficiosCollection;
    }

    @XmlTransient
    public Collection<Cbeneficios> getCbeneficiosCollection1() {
        return cbeneficiosCollection1;
    }

    public void setCbeneficiosCollection1(Collection<Cbeneficios> cbeneficiosCollection1) {
        this.cbeneficiosCollection1 = cbeneficiosCollection1;
    }

    @XmlTransient
    public Collection<Tpagos> getTpagosCollection() {
        return tpagosCollection;
    }

    public void setTpagosCollection(Collection<Tpagos> tpagosCollection) {
        this.tpagosCollection = tpagosCollection;
    }

    @XmlTransient
    public Collection<Tpagos> getTpagosCollection1() {
        return tpagosCollection1;
    }

    public void setTpagosCollection1(Collection<Tpagos> tpagosCollection1) {
        this.tpagosCollection1 = tpagosCollection1;
    }

    @XmlTransient
    public Collection<Rserviciocontratadoestatusservicio> getRserviciocontratadoestatusservicioCollection() {
        return rserviciocontratadoestatusservicioCollection;
    }

    public void setRserviciocontratadoestatusservicioCollection(Collection<Rserviciocontratadoestatusservicio> rserviciocontratadoestatusservicioCollection) {
        this.rserviciocontratadoestatusservicioCollection = rserviciocontratadoestatusservicioCollection;
    }

    @XmlTransient
    public Collection<Tenlace> getTenlaceCollection() {
        return tenlaceCollection;
    }

    public void setTenlaceCollection(Collection<Tenlace> tenlaceCollection) {
        this.tenlaceCollection = tenlaceCollection;
    }

    @XmlTransient
    public Collection<Tpersonafisica> getTpersonafisicaCollection() {
        return tpersonafisicaCollection;
    }

    public void setTpersonafisicaCollection(Collection<Tpersonafisica> tpersonafisicaCollection) {
        this.tpersonafisicaCollection = tpersonafisicaCollection;
    }

    @XmlTransient
    public Collection<Tpreciosumaasegurada> getTpreciosumaaseguradaCollection() {
        return tpreciosumaaseguradaCollection;
    }

    public void setTpreciosumaaseguradaCollection(Collection<Tpreciosumaasegurada> tpreciosumaaseguradaCollection) {
        this.tpreciosumaaseguradaCollection = tpreciosumaaseguradaCollection;
    }

    @XmlTransient
    public Collection<Tpreciosumaasegurada> getTpreciosumaaseguradaCollection1() {
        return tpreciosumaaseguradaCollection1;
    }

    public void setTpreciosumaaseguradaCollection1(Collection<Tpreciosumaasegurada> tpreciosumaaseguradaCollection1) {
        this.tpreciosumaaseguradaCollection1 = tpreciosumaaseguradaCollection1;
    }

    @XmlTransient
    public Collection<Tservicioscontratados> getTservicioscontratadosCollection() {
        return tservicioscontratadosCollection;
    }

    public void setTservicioscontratadosCollection(Collection<Tservicioscontratados> tservicioscontratadosCollection) {
        this.tservicioscontratadosCollection = tservicioscontratadosCollection;
    }

    @XmlTransient
    public Collection<Tusuarios> getTusuariosCollection() {
        return tusuariosCollection;
    }

    public void setTusuariosCollection(Collection<Tusuarios> tusuariosCollection) {
        this.tusuariosCollection = tusuariosCollection;
    }

    @XmlTransient
    public Collection<Tusuarios> getTusuariosCollection1() {
        return tusuariosCollection1;
    }

    public void setTusuariosCollection1(Collection<Tusuarios> tusuariosCollection1) {
        this.tusuariosCollection1 = tusuariosCollection1;
    }

    @XmlTransient
    public Collection<Tusuarios> getTusuariosCollection2() {
        return tusuariosCollection2;
    }

    public void setTusuariosCollection2(Collection<Tusuarios> tusuariosCollection2) {
        this.tusuariosCollection2 = tusuariosCollection2;
    }

    public Cmaestro getCatalogomaestroid() {
        return catalogomaestroid;
    }

    public void setCatalogomaestroid(Cmaestro catalogomaestroid) {
        this.catalogomaestroid = catalogomaestroid;
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
        hash += (catalogodetalleid != null ? catalogodetalleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cmaestrodetalle)) {
            return false;
        }
        Cmaestrodetalle other = (Cmaestrodetalle) object;
        if ((this.catalogodetalleid == null && other.catalogodetalleid != null) || (this.catalogodetalleid != null && !this.catalogodetalleid.equals(other.catalogodetalleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cmaestrodetalle[ catalogodetalleid=" + catalogodetalleid + " ]";
    }
    
}
