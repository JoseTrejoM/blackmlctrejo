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
@Table(name = "tsistemamodulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsistemamodulo.findAll", query = "SELECT t FROM Tsistemamodulo t"),
    @NamedQuery(name = "Tsistemamodulo.findBySismodid", query = "SELECT t FROM Tsistemamodulo t WHERE t.sismodid = :sismodid"),
    @NamedQuery(name = "Tsistemamodulo.findByNombre", query = "SELECT t FROM Tsistemamodulo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tsistemamodulo.findByDescripcion", query = "SELECT t FROM Tsistemamodulo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tsistemamodulo.findByUrl", query = "SELECT t FROM Tsistemamodulo t WHERE t.url = :url"),
    @NamedQuery(name = "Tsistemamodulo.findByUpdateto", query = "SELECT t FROM Tsistemamodulo t WHERE t.updateto = :updateto"),
    @NamedQuery(name = "Tsistemamodulo.findByBuscar", query = "SELECT t FROM Tsistemamodulo t WHERE t.buscar = :buscar"),
    @NamedQuery(name = "Tsistemamodulo.findByOrden", query = "SELECT t FROM Tsistemamodulo t WHERE t.orden = :orden"),
    @NamedQuery(name = "Tsistemamodulo.findByImagen", query = "SELECT t FROM Tsistemamodulo t WHERE t.imagen = :imagen"),
    @NamedQuery(name = "Tsistemamodulo.findByFechaalta", query = "SELECT t FROM Tsistemamodulo t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tsistemamodulo.findByActivo", query = "SELECT t FROM Tsistemamodulo t WHERE t.activo = :activo")})
public class Tsistemamodulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SISMODID")
    private Integer sismodid;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Column(name = "UPDATETO")
    private String updateto;
    @Column(name = "BUSCAR")
    private String buscar;
    @Basic(optional = false)
    @Column(name = "ORDEN")
    private short orden;
    @Column(name = "IMAGEN")
    private String imagen;
    @Basic(optional = false)
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private boolean activo;
    @OneToMany(mappedBy = "sismodpadreid")
    private Collection<Tsistemamodulo> tsistemamoduloCollection;
    @JoinColumn(name = "SISMODPADREID", referencedColumnName = "SISMODID")
    @ManyToOne
    private Tsistemamodulo sismodpadreid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tsistemamodulo")
    private Collection<Rmodulodocumento> rmodulodocumentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tsistemamodulo")
    private Collection<Tpermisos> tpermisosCollection;

    public Tsistemamodulo() {
    }

    public Tsistemamodulo(Integer sismodid) {
        this.sismodid = sismodid;
    }

    public Tsistemamodulo(Integer sismodid, String nombre, String descripcion, String url, short orden, Date fechaalta, boolean activo) {
        this.sismodid = sismodid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.orden = orden;
        this.fechaalta = fechaalta;
        this.activo = activo;
    }

    public Integer getSismodid() {
        return sismodid;
    }

    public void setSismodid(Integer sismodid) {
        this.sismodid = sismodid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpdateto() {
        return updateto;
    }

    public void setUpdateto(String updateto) {
        this.updateto = updateto;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Tsistemamodulo> getTsistemamoduloCollection() {
        return tsistemamoduloCollection;
    }

    public void setTsistemamoduloCollection(Collection<Tsistemamodulo> tsistemamoduloCollection) {
        this.tsistemamoduloCollection = tsistemamoduloCollection;
    }

    public Tsistemamodulo getSismodpadreid() {
        return sismodpadreid;
    }

    public void setSismodpadreid(Tsistemamodulo sismodpadreid) {
        this.sismodpadreid = sismodpadreid;
    }

    @XmlTransient
    public Collection<Rmodulodocumento> getRmodulodocumentoCollection() {
        return rmodulodocumentoCollection;
    }

    public void setRmodulodocumentoCollection(Collection<Rmodulodocumento> rmodulodocumentoCollection) {
        this.rmodulodocumentoCollection = rmodulodocumentoCollection;
    }

    @XmlTransient
    public Collection<Tpermisos> getTpermisosCollection() {
        return tpermisosCollection;
    }

    public void setTpermisosCollection(Collection<Tpermisos> tpermisosCollection) {
        this.tpermisosCollection = tpermisosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sismodid != null ? sismodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsistemamodulo)) {
            return false;
        }
        Tsistemamodulo other = (Tsistemamodulo) object;
        if ((this.sismodid == null && other.sismodid != null) || (this.sismodid != null && !this.sismodid.equals(other.sismodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tsistemamodulo[ sismodid=" + sismodid + " ]";
    }
    
}
