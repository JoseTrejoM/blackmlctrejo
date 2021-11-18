/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "cbeneficios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cbeneficios.findAll", query = "SELECT c FROM Cbeneficios c"),
    @NamedQuery(name = "Cbeneficios.findByBeneficioid", query = "SELECT c FROM Cbeneficios c WHERE c.beneficioid = :beneficioid"),
    @NamedQuery(name = "Cbeneficios.findByClavebeneficio", query = "SELECT c FROM Cbeneficios c WHERE c.clavebeneficio = :clavebeneficio"),
    @NamedQuery(name = "Cbeneficios.findByTitulobeneficio", query = "SELECT c FROM Cbeneficios c WHERE c.titulobeneficio = :titulobeneficio"),
    @NamedQuery(name = "Cbeneficios.findBySubtitulobeneficio", query = "SELECT c FROM Cbeneficios c WHERE c.subtitulobeneficio = :subtitulobeneficio"),
    @NamedQuery(name = "Cbeneficios.findByDescripcionbeneficio", query = "SELECT c FROM Cbeneficios c WHERE c.descripcionbeneficio = :descripcionbeneficio"),
    @NamedQuery(name = "Cbeneficios.findByOrden", query = "SELECT c FROM Cbeneficios c WHERE c.orden = :orden"),
    @NamedQuery(name = "Cbeneficios.findByFechaalta", query = "SELECT c FROM Cbeneficios c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cbeneficios.findByUsuarioalta", query = "SELECT c FROM Cbeneficios c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cbeneficios.findByFechamodificacion", query = "SELECT c FROM Cbeneficios c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cbeneficios.findByUsuariomodificacion", query = "SELECT c FROM Cbeneficios c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cbeneficios.findByActivo", query = "SELECT c FROM Cbeneficios c WHERE c.activo = :activo")})
public class Cbeneficios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BENEFICIOID")
    private Integer beneficioid;
    @Basic(optional = false)
    @Column(name = "CLAVEBENEFICIO")
    private String clavebeneficio;
    @Basic(optional = false)
    @Column(name = "TITULOBENEFICIO")
    private String titulobeneficio;
    @Column(name = "SUBTITULOBENEFICIO")
    private String subtitulobeneficio;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONBENEFICIO")
    private String descripcionbeneficio;
    @Basic(optional = false)
    @Column(name = "ORDEN")
    private int orden;
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

    @JsonIgnore
    @OneToMany(mappedBy = "beneficioid")
    private Collection<Rbeneficiosbeneficiario> rbeneficiosbeneficiarioCollection;

    @JsonIgnore
    @OneToMany(mappedBy = "beneficioid")
    private Collection<Rserviciobeneficiario> rserviciobeneficiarioCollection;

    @JsonManagedReference
    @JoinColumn(name = "CLRECEPTORPAGO", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clreceptorpago;

    @JsonManagedReference
    @JoinColumn(name = "CLTIPOBENEFICIO", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle cltipobeneficio;

    public Cbeneficios() {
    }

    public Cbeneficios(Integer beneficioid) {
        this.beneficioid = beneficioid;
    }

    public Cbeneficios(Integer beneficioid, String clavebeneficio, String titulobeneficio, String descripcionbeneficio, int orden, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.beneficioid = beneficioid;
        this.clavebeneficio = clavebeneficio;
        this.titulobeneficio = titulobeneficio;
        this.descripcionbeneficio = descripcionbeneficio;
        this.orden = orden;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getBeneficioid() {
        return beneficioid;
    }

    public void setBeneficioid(Integer beneficioid) {
        this.beneficioid = beneficioid;
    }

    public String getClavebeneficio() {
        return clavebeneficio;
    }

    public void setClavebeneficio(String clavebeneficio) {
        this.clavebeneficio = clavebeneficio;
    }

    public String getTitulobeneficio() {
        return titulobeneficio;
    }

    public void setTitulobeneficio(String titulobeneficio) {
        this.titulobeneficio = titulobeneficio;
    }

    public String getSubtitulobeneficio() {
        return subtitulobeneficio;
    }

    public void setSubtitulobeneficio(String subtitulobeneficio) {
        this.subtitulobeneficio = subtitulobeneficio;
    }

    public String getDescripcionbeneficio() {
        return descripcionbeneficio;
    }

    public void setDescripcionbeneficio(String descripcionbeneficio) {
        this.descripcionbeneficio = descripcionbeneficio;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
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
    public Collection<Rbeneficiosbeneficiario> getRbeneficiosbeneficiarioCollection() {
        return rbeneficiosbeneficiarioCollection;
    }

    public void setRbeneficiosbeneficiarioCollection(Collection<Rbeneficiosbeneficiario> rbeneficiosbeneficiarioCollection) {
        this.rbeneficiosbeneficiarioCollection = rbeneficiosbeneficiarioCollection;
    }

    @XmlTransient
    public Collection<Rserviciobeneficiario> getRserviciobeneficiarioCollection() {
        return rserviciobeneficiarioCollection;
    }

    public void setRserviciobeneficiarioCollection(Collection<Rserviciobeneficiario> rserviciobeneficiarioCollection) {
        this.rserviciobeneficiarioCollection = rserviciobeneficiarioCollection;
    }

    public Cmaestrodetalle getClreceptorpago() {
        return clreceptorpago;
    }

    public void setClreceptorpago(Cmaestrodetalle clreceptorpago) {
        this.clreceptorpago = clreceptorpago;
    }

    public Cmaestrodetalle getCltipobeneficio() {
        return cltipobeneficio;
    }

    public void setCltipobeneficio(Cmaestrodetalle cltipobeneficio) {
        this.cltipobeneficio = cltipobeneficio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beneficioid != null ? beneficioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cbeneficios)) {
            return false;
        }
        Cbeneficios other = (Cbeneficios) object;
        if ((this.beneficioid == null && other.beneficioid != null) || (this.beneficioid != null && !this.beneficioid.equals(other.beneficioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cbeneficios[ beneficioid=" + beneficioid + " ]";
    }
    
}
