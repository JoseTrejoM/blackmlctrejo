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
import javax.persistence.OneToOne;
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
@Table(name = "tmembresia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmembresia.findAll", query = "SELECT t FROM Tmembresia t"),
    @NamedQuery(name = "Tmembresia.findByMembresiaid", query = "SELECT t FROM Tmembresia t WHERE t.membresiaid = :membresiaid"),
    @NamedQuery(name = "Tmembresia.findByNummembresia", query = "SELECT t FROM Tmembresia t WHERE t.nummembresia = :nummembresia"),
    @NamedQuery(name = "Tmembresia.findByFechaalta", query = "SELECT t FROM Tmembresia t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tmembresia.findByUsuarioalta", query = "SELECT t FROM Tmembresia t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tmembresia.findByFechamodificacion", query = "SELECT t FROM Tmembresia t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tmembresia.findByUsuariomodificacion", query = "SELECT t FROM Tmembresia t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tmembresia.findByActivo", query = "SELECT t FROM Tmembresia t WHERE t.activo = :activo")})
public class Tmembresia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MEMBRESIAID")
    private Integer membresiaid;
    @Basic(optional = false)
    @Column(name = "NUMMEMBRESIA")
    private String nummembresia;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membresiaid")
    private Collection<Tpagos> tpagosCollection;
    @JoinColumn(name = "MEMBRESIAID", referencedColumnName = "MEMBRESIAID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tpropuesta tpropuesta;
    @JoinColumn(name = "CLESTATUSMEMBRESIAID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clestatusmembresiaid;            
            
    

    public Tmembresia() {
    }

    public Tmembresia(Integer membresiaid) {
        this.membresiaid = membresiaid;
    }

    public Tmembresia(Integer membresiaid, String nummembresia, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.membresiaid = membresiaid;
        this.nummembresia = nummembresia;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getMembresiaid() {
        return membresiaid;
    }

    public void setMembresiaid(Integer membresiaid) {
        this.membresiaid = membresiaid;
    }

    public String getNummembresia() {
        return nummembresia;
    }

    public void setNummembresia(String nummembresia) {
        this.nummembresia = nummembresia;
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
    public Collection<Tpagos> getTpagosCollection() {
        return tpagosCollection;
    }

    public void setTpagosCollection(Collection<Tpagos> tpagosCollection) {
        this.tpagosCollection = tpagosCollection;
    }

    public Tpropuesta getTpropuesta() {
        return tpropuesta;
    }

    public void setTpropuesta(Tpropuesta tpropuesta) {
        this.tpropuesta = tpropuesta;
    }

    /**
     * @return the clestatusmembresiaid
     */
    public Cmaestrodetalle getClestatusmembresiaid() {
        return clestatusmembresiaid;
    }

    /**
     * @param clestatusmembresiaid the clestatusmembresiaid to set
     */
    public void setClestatusmembresiaid(Cmaestrodetalle clestatusmembresiaid) {
        this.clestatusmembresiaid = clestatusmembresiaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membresiaid != null ? membresiaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmembresia)) {
            return false;
        }
        Tmembresia other = (Tmembresia) object;
        if ((this.membresiaid == null && other.membresiaid != null) || (this.membresiaid != null && !this.membresiaid.equals(other.membresiaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tmembresia[ membresiaid=" + membresiaid + " ]";
    }
    
}
