/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "trespuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trespuesta.findAll", query = "SELECT t FROM Trespuesta t"),
    @NamedQuery(name = "Trespuesta.findByRespuestaid", query = "SELECT t FROM Trespuesta t WHERE t.respuestaid = :respuestaid"),
    @NamedQuery(name = "Trespuesta.findByRespuesta", query = "SELECT t FROM Trespuesta t WHERE t.respuesta = :respuesta"),
    @NamedQuery(name = "Trespuesta.findByFechaalta", query = "SELECT t FROM Trespuesta t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Trespuesta.findByUsuarioalta", query = "SELECT t FROM Trespuesta t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Trespuesta.findByFechamodificacion", query = "SELECT t FROM Trespuesta t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Trespuesta.findByUsuariomodificacion", query = "SELECT t FROM Trespuesta t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Trespuesta.findByActivo", query = "SELECT t FROM Trespuesta t WHERE t.activo = :activo")})
public class Trespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RESPUESTAID")
    private Integer respuestaid;
    @Basic(optional = false)
    @Column(name = "RESPUESTA")
    private String respuesta;
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
    @JoinColumn(name = "PREGUNTAID", referencedColumnName = "PREGUNTAID")
    @ManyToOne(optional = false)
    private Cpreguntas preguntaid;
    @JoinColumn(name = "SERVICIOBENEFICIARIOID", referencedColumnName = "SERVICIOBENEFICIARIOID")
    @ManyToOne(optional = false)
    private Rserviciobeneficiario serviciobeneficiarioid;

    public Trespuesta() {
    }

    public Trespuesta(Integer respuestaid) {
        this.respuestaid = respuestaid;
    }

    public Trespuesta(Integer respuestaid, String respuesta, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.respuestaid = respuestaid;
        this.respuesta = respuesta;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getRespuestaid() {
        return respuestaid;
    }

    public void setRespuestaid(Integer respuestaid) {
        this.respuestaid = respuestaid;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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

    public Cpreguntas getPreguntaid() {
        return preguntaid;
    }

    public void setPreguntaid(Cpreguntas preguntaid) {
        this.preguntaid = preguntaid;
    }

    public Rserviciobeneficiario getServiciobeneficiarioid() {
        return serviciobeneficiarioid;
    }

    public void setServiciobeneficiarioid(Rserviciobeneficiario serviciobeneficiarioid) {
        this.serviciobeneficiarioid = serviciobeneficiarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestaid != null ? respuestaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trespuesta)) {
            return false;
        }
        Trespuesta other = (Trespuesta) object;
        if ((this.respuestaid == null && other.respuestaid != null) || (this.respuestaid != null && !this.respuestaid.equals(other.respuestaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Trespuesta[ respuestaid=" + respuestaid + " ]";
    }
    
}
