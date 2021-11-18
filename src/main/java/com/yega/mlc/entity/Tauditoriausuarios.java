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
@Table(name = "tauditoriausuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tauditoriausuarios.findAll", query = "SELECT t FROM Tauditoriausuarios t"),
    @NamedQuery(name = "Tauditoriausuarios.findByAuditaid", query = "SELECT t FROM Tauditoriausuarios t WHERE t.auditaid = :auditaid"),
    @NamedQuery(name = "Tauditoriausuarios.findByDetalleauditoria", query = "SELECT t FROM Tauditoriausuarios t WHERE t.detalleauditoria = :detalleauditoria"),
    @NamedQuery(name = "Tauditoriausuarios.findByFechaaudita", query = "SELECT t FROM Tauditoriausuarios t WHERE t.fechaaudita = :fechaaudita")})
public class Tauditoriausuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AUDITAID")
    private Integer auditaid;
    @Basic(optional = false)
    @Column(name = "DETALLEAUDITORIA")
    private String detalleauditoria;
    @Basic(optional = false)
    @Column(name = "FECHAAUDITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaaudita;
    @JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")
    @ManyToOne
    private Tusuarios usuarioid;

    public Tauditoriausuarios() {
    }

    public Tauditoriausuarios(Integer auditaid) {
        this.auditaid = auditaid;
    }

    public Tauditoriausuarios(Integer auditaid, String detalleauditoria, Date fechaaudita) {
        this.auditaid = auditaid;
        this.detalleauditoria = detalleauditoria;
        this.fechaaudita = fechaaudita;
    }

    public Integer getAuditaid() {
        return auditaid;
    }

    public void setAuditaid(Integer auditaid) {
        this.auditaid = auditaid;
    }

    public String getDetalleauditoria() {
        return detalleauditoria;
    }

    public void setDetalleauditoria(String detalleauditoria) {
        this.detalleauditoria = detalleauditoria;
    }

    public Date getFechaaudita() {
        return fechaaudita;
    }

    public void setFechaaudita(Date fechaaudita) {
        this.fechaaudita = fechaaudita;
    }

    public Tusuarios getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Tusuarios usuarioid) {
        this.usuarioid = usuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditaid != null ? auditaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tauditoriausuarios)) {
            return false;
        }
        Tauditoriausuarios other = (Tauditoriausuarios) object;
        if ((this.auditaid == null && other.auditaid != null) || (this.auditaid != null && !this.auditaid.equals(other.auditaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tauditoriausuarios[ auditaid=" + auditaid + " ]";
    }
    
}
