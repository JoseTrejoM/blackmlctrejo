/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tpagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpagos.findAll", query = "SELECT t FROM Tpagos t"),
    @NamedQuery(name = "Tpagos.findByPagoid", query = "SELECT t FROM Tpagos t WHERE t.pagoid = :pagoid"),
    @NamedQuery(name = "Tpagos.findByMontopago", query = "SELECT t FROM Tpagos t WHERE t.montopago = :montopago"),
    @NamedQuery(name = "Tpagos.findByFechapago", query = "SELECT t FROM Tpagos t WHERE t.fechapago = :fechapago"),
    @NamedQuery(name = "Tpagos.findByReferencia", query = "SELECT t FROM Tpagos t WHERE t.referencia = :referencia"),
    @NamedQuery(name = "Tpagos.findByTransaccion", query = "SELECT t FROM Tpagos t WHERE t.transaccion = :transaccion"),
    @NamedQuery(name = "Tpagos.findByFechaalta", query = "SELECT t FROM Tpagos t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tpagos.findByUsuarioalta", query = "SELECT t FROM Tpagos t WHERE t.usuarioalta = :usuarioalta"),
    @NamedQuery(name = "Tpagos.findByFechamodificacion", query = "SELECT t FROM Tpagos t WHERE t.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Tpagos.findByUsuariomodificacion", query = "SELECT t FROM Tpagos t WHERE t.usuariomodificacion = :usuariomodificacion"),
    @NamedQuery(name = "Tpagos.findByActivo", query = "SELECT t FROM Tpagos t WHERE t.activo = :activo")})
public class Tpagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PAGOID")
    private Integer pagoid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "MONTOPAGO")
    private BigDecimal montopago;
    @Basic(optional = false)
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @Basic(optional = false)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "TRANSACCION")
    private String transaccion;
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
    @JoinColumn(name = "CLFORMAPAGOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clformapagoid;
    @JoinColumn(name = "CLMONEDAPAGOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clmonedapagoid;
    @JoinColumn(name = "MEMBRESIAID", referencedColumnName = "MEMBRESIAID")
    @ManyToOne(optional = false)
    private Tmembresia membresiaid;
    @JoinColumn(name = "VIGENCIAID", referencedColumnName = "PERIODOVIGENCIAID")
    @ManyToOne(optional = false)
    private Tperiodovigencia vigenciaid;
 
    

    public Tpagos() {
    }

    public Tpagos(Integer pagoid) {
        this.pagoid = pagoid;
    }

    public Tpagos(Integer pagoid, BigDecimal montopago, Date fechapago, String referencia, Date fechaalta, int usuarioalta, Date fechamodificacion, boolean activo) {
        this.pagoid = pagoid;
        this.montopago = montopago;
        this.fechapago = fechapago;
        this.referencia = referencia;
        this.fechaalta = fechaalta;
        this.usuarioalta = usuarioalta;
        this.fechamodificacion = fechamodificacion;
        this.activo = activo;
    }

    public Integer getPagoid() {
        return pagoid;
    }

    public void setPagoid(Integer pagoid) {
        this.pagoid = pagoid;
    }

    public BigDecimal getMontopago() {
        return montopago;
    }

    public void setMontopago(BigDecimal montopago) {
        this.montopago = montopago;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
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

    public Cmaestrodetalle getClformapagoid() {
        return clformapagoid;
    }

    public void setClformapagoid(Cmaestrodetalle clformapagoid) {
        this.clformapagoid = clformapagoid;
    }

    public Cmaestrodetalle getClmonedapagoid() {
        return clmonedapagoid;
    }

    public void setClmonedapagoid(Cmaestrodetalle clmonedapagoid) {
        this.clmonedapagoid = clmonedapagoid;
    }

    public Tmembresia getMembresiaid() {
        return membresiaid;
    }

    public void setMembresiaid(Tmembresia membresiaid) {
        this.membresiaid = membresiaid;
    }

    public Tperiodovigencia getVigenciaid() {
        return vigenciaid;
    }

    public void setVigenciaid(Tperiodovigencia vigenciaid) {
        this.vigenciaid = vigenciaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagoid != null ? pagoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpagos)) {
            return false;
        }
        Tpagos other = (Tpagos) object;
        if ((this.pagoid == null && other.pagoid != null) || (this.pagoid != null && !this.pagoid.equals(other.pagoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tpagos[ pagoid=" + pagoid + " ]";
    }
    
}
