/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Embeddable
@Table(name = "vplanbeneficiarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vplanbeneficiarios.findAll", query = "SELECT v FROM Vplanbeneficiarios v"),
    @NamedQuery(name = "Vplanbeneficiarios.findByTipoplanid", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.tipoplanid = :tipoplanid"),
    @NamedQuery(name = "Vplanbeneficiarios.findByDescripcionplan", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.descripcionplan = :descripcionplan"),
    @NamedQuery(name = "Vplanbeneficiarios.findByPrecio", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.precio = :precio"),
    @NamedQuery(name = "Vplanbeneficiarios.findByDescripcion", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vplanbeneficiarios.findByEdadminima", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.edadminima = :edadminima"),
    @NamedQuery(name = "Vplanbeneficiarios.findByEdadmaxima", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.edadmaxima = :edadmaxima"),
    @NamedQuery(name = "Vplanbeneficiarios.findByResideextranjero", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.resideextranjero = :resideextranjero"),
    @NamedQuery(name = "Vplanbeneficiarios.findByTitular", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.titular = :titular"),
    @NamedQuery(name = "Vplanbeneficiarios.findByPareja", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.pareja = :pareja"),
    @NamedQuery(name = "Vplanbeneficiarios.findByPadre", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.padre = :padre"),
    @NamedQuery(name = "Vplanbeneficiarios.findByMadre", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.madre = :madre"),
    @NamedQuery(name = "Vplanbeneficiarios.findByHijo", query = "SELECT v FROM Vplanbeneficiarios v WHERE v.hijo = :hijo")})
public class Vplanbeneficiarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "TIPOPLANID")
    private int tipoplanid;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONPLAN")
    private String descripcionplan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "EDADMINIMA")
    private Short edadminima;
    @Column(name = "EDADMAXIMA")
    private Short edadmaxima;
    @Column(name = "RESIDEEXTRANJERO")
    private Short resideextranjero;
    @Column(name = "Titular")
    private BigInteger titular;
    @Column(name = "Pareja")
    private BigInteger pareja;
    @Column(name = "Padre")
    private BigInteger padre;
    @Column(name = "Madre")
    private BigInteger madre;
    @Column(name = "Hijo")
    private BigInteger hijo;

    public Vplanbeneficiarios() {
    }

    public int getTipoplanid() {
        return tipoplanid;
    }

    public void setTipoplanid(int tipoplanid) {
        this.tipoplanid = tipoplanid;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Short getResideextranjero() {
        return resideextranjero;
    }

    public void setResideextranjero(Short resideextranjero) {
        this.resideextranjero = resideextranjero;
    }

    public BigInteger getTitular() {
        return titular;
    }

    public void setTitular(BigInteger titular) {
        this.titular = titular;
    }

    public BigInteger getPareja() {
        return pareja;
    }

    public void setPareja(BigInteger pareja) {
        this.pareja = pareja;
    }

    public BigInteger getPadre() {
        return padre;
    }

    public void setPadre(BigInteger padre) {
        this.padre = padre;
    }

    public BigInteger getMadre() {
        return madre;
    }

    public void setMadre(BigInteger madre) {
        this.madre = madre;
    }

    public BigInteger getHijo() {
        return hijo;
    }

    public void setHijo(BigInteger hijo) {
        this.hijo = hijo;
    }
    
}
