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
@Table(name = "cpreguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cpreguntas.findAll", query = "SELECT c FROM Cpreguntas c"),
    @NamedQuery(name = "Cpreguntas.findByPreguntaid", query = "SELECT c FROM Cpreguntas c WHERE c.preguntaid = :preguntaid"),
    @NamedQuery(name = "Cpreguntas.findByClavepregunta", query = "SELECT c FROM Cpreguntas c WHERE c.clavepregunta = :clavepregunta"),
    @NamedQuery(name = "Cpreguntas.findByDescripcionpregunta", query = "SELECT c FROM Cpreguntas c WHERE c.descripcionpregunta = :descripcionpregunta"),
    @NamedQuery(name = "Cpreguntas.findByOrden", query = "SELECT c FROM Cpreguntas c WHERE c.orden = :orden"),
    @NamedQuery(name = "Cpreguntas.findByFechaalta", query = "SELECT c FROM Cpreguntas c WHERE c.fechaalta = :fechaalta"),
    @NamedQuery(name = "Cpreguntas.findByUsuarioalta", query = "SELECT c FROM Cpreguntas c WHERE c.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Cpreguntas.findByFechamodificacion", query = "SELECT c FROM Cpreguntas c WHERE c.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Cpreguntas.findByUsuariomodificacion", query = "SELECT c FROM Cpreguntas c WHERE c.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Cpreguntas.findByActivo", query = "SELECT c FROM Cpreguntas c WHERE c.activo = :activo")})
public class Cpreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PREGUNTAID")
    private Integer preguntaid;
    @Basic(optional = false)
    @Column(name = "CLAVEPREGUNTA")
    private String clavepregunta;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONPREGUNTA")
    private String descripcionpregunta;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preguntaid")
    private Collection<Trespuesta> trespuestaCollection;
    @JoinColumn(name = "CUESTIONARIOID", referencedColumnName = "CUESTIONARIOID")
    @ManyToOne(optional = false)
    private Ccuestionario cuestionarioid;
    @JoinColumn(name = "GRUPOPREGUNTASID", referencedColumnName = "GRUPOPREGUNTASID")
    @ManyToOne
    private Cgrupopreguntas grupopreguntasid;

    public Cpreguntas() {
    }

    public Cpreguntas(Integer preguntaid) {
        this.preguntaid = preguntaid;
    }

    public Cpreguntas(Integer preguntaid, String clavepregunta, String descripcionpregunta, int orden, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.preguntaid = preguntaid;
        this.clavepregunta = clavepregunta;
        this.descripcionpregunta = descripcionpregunta;
        this.orden = orden;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getPreguntaid() {
        return preguntaid;
    }

    public void setPreguntaid(Integer preguntaid) {
        this.preguntaid = preguntaid;
    }

    public String getClavepregunta() {
        return clavepregunta;
    }

    public void setClavepregunta(String clavepregunta) {
        this.clavepregunta = clavepregunta;
    }

    public String getDescripcionpregunta() {
        return descripcionpregunta;
    }

    public void setDescripcionpregunta(String descripcionpregunta) {
        this.descripcionpregunta = descripcionpregunta;
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
    public Collection<Trespuesta> getTrespuestaCollection() {
        return trespuestaCollection;
    }

    public void setTrespuestaCollection(Collection<Trespuesta> trespuestaCollection) {
        this.trespuestaCollection = trespuestaCollection;
    }

    public Ccuestionario getCuestionarioid() {
        return cuestionarioid;
    }

    public void setCuestionarioid(Ccuestionario cuestionarioid) {
        this.cuestionarioid = cuestionarioid;
    }

    public Cgrupopreguntas getGrupopreguntasid() {
        return grupopreguntasid;
    }

    public void setGrupopreguntasid(Cgrupopreguntas grupopreguntasid) {
        this.grupopreguntasid = grupopreguntasid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaid != null ? preguntaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpreguntas)) {
            return false;
        }
        Cpreguntas other = (Cpreguntas) object;
        if ((this.preguntaid == null && other.preguntaid != null) || (this.preguntaid != null && !this.preguntaid.equals(other.preguntaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Cpreguntas[ preguntaid=" + preguntaid + " ]";
    }
    
}
