/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Embeddable
@Table(name = "vpersonadomicilio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vpersonadomicilio.findAll", query = "SELECT v FROM Vpersonadomicilio v"),
    @NamedQuery(name = "Vpersonadomicilio.findByPersonaid", query = "SELECT v FROM Vpersonadomicilio v WHERE v.personaid = :personaid"),
    @NamedQuery(name = "Vpersonadomicilio.findByDomicilioid", query = "SELECT v FROM Vpersonadomicilio v WHERE v.domicilioid = :domicilioid"),
    @NamedQuery(name = "Vpersonadomicilio.findByCltipodomicilioid", query = "SELECT v FROM Vpersonadomicilio v WHERE v.cltipodomicilioid = :cltipodomicilioid"),
    @NamedQuery(name = "Vpersonadomicilio.findByClaveTipoDomicilio", query = "SELECT v FROM Vpersonadomicilio v WHERE v.claveTipoDomicilio = :claveTipoDomicilio"),
    @NamedQuery(name = "Vpersonadomicilio.findByDescripcionTipoDomilicio", query = "SELECT v FROM Vpersonadomicilio v WHERE v.descripcionTipoDomilicio = :descripcionTipoDomilicio"),
    @NamedQuery(name = "Vpersonadomicilio.findByCalle", query = "SELECT v FROM Vpersonadomicilio v WHERE v.calle = :calle"),
    @NamedQuery(name = "Vpersonadomicilio.findByNumeroExterior", query = "SELECT v FROM Vpersonadomicilio v WHERE v.numeroExterior = :numeroExterior"),
    @NamedQuery(name = "Vpersonadomicilio.findByNumeroInterior", query = "SELECT v FROM Vpersonadomicilio v WHERE v.numeroInterior = :numeroInterior"),
    @NamedQuery(name = "Vpersonadomicilio.findByColonia", query = "SELECT v FROM Vpersonadomicilio v WHERE v.colonia = :colonia"),
    @NamedQuery(name = "Vpersonadomicilio.findByCiudad", query = "SELECT v FROM Vpersonadomicilio v WHERE v.ciudad = :ciudad"),
    @NamedQuery(name = "Vpersonadomicilio.findByMunicipioid", query = "SELECT v FROM Vpersonadomicilio v WHERE v.municipioid = :municipioid"),
    @NamedQuery(name = "Vpersonadomicilio.findByClavemunicipio", query = "SELECT v FROM Vpersonadomicilio v WHERE v.clavemunicipio = :clavemunicipio"),
    @NamedQuery(name = "Vpersonadomicilio.findByDescripcionmunicipio", query = "SELECT v FROM Vpersonadomicilio v WHERE v.descripcionmunicipio = :descripcionmunicipio"),
    @NamedQuery(name = "Vpersonadomicilio.findByEstadoid", query = "SELECT v FROM Vpersonadomicilio v WHERE v.estadoid = :estadoid"),
    @NamedQuery(name = "Vpersonadomicilio.findByClaveestado", query = "SELECT v FROM Vpersonadomicilio v WHERE v.claveestado = :claveestado"),
    @NamedQuery(name = "Vpersonadomicilio.findByNombreestado", query = "SELECT v FROM Vpersonadomicilio v WHERE v.nombreestado = :nombreestado"),
    @NamedQuery(name = "Vpersonadomicilio.findByPaisid", query = "SELECT v FROM Vpersonadomicilio v WHERE v.paisid = :paisid"),
    @NamedQuery(name = "Vpersonadomicilio.findByClavepais", query = "SELECT v FROM Vpersonadomicilio v WHERE v.clavepais = :clavepais"),
    @NamedQuery(name = "Vpersonadomicilio.findByDescripcionpais", query = "SELECT v FROM Vpersonadomicilio v WHERE v.descripcionpais = :descripcionpais"),
    @NamedQuery(name = "Vpersonadomicilio.findByCodigopostal", query = "SELECT v FROM Vpersonadomicilio v WHERE v.codigopostal = :codigopostal")})
public class Vpersonadomicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PERSONAID")
    private int personaid;
    @Basic(optional = false)
    @Column(name = "DOMICILIOID")
    private int domicilioid;
    @Column(name = "CLTIPODOMICILIOID")
    private Integer cltipodomicilioid;
    @Basic(optional = false)
    @Column(name = "CLAVE_TIPO_DOMICILIO")
    private String claveTipoDomicilio;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_TIPO_DOMILICIO")
    private String descripcionTipoDomilicio;
    @Basic(optional = false)
    @Column(name = "CALLE")
    private String calle;
    @Basic(optional = false)
    @Column(name = "NUMERO_EXTERIOR")
    private String numeroExterior;
    @Column(name = "NUMERO_INTERIOR")
    private String numeroInterior;
    @Basic(optional = false)
    @Column(name = "COLONIA")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "MUNICIPIOID")
    private Short municipioid;
    @Column(name = "CLAVEMUNICIPIO")
    private String clavemunicipio;
    @Column(name = "DESCRIPCIONMUNICIPIO")
    private String descripcionmunicipio;
    @Basic(optional = false)
    @Column(name = "ESTADOID")
    private short estadoid;
    @Basic(optional = false)
    @Column(name = "CLAVEESTADO")
    private String claveestado;
    @Basic(optional = false)
    @Column(name = "NOMBREESTADO")
    private String nombreestado;
    @Basic(optional = false)
    @Column(name = "PAISID")
    private short paisid;
    @Basic(optional = false)
    @Column(name = "CLAVEPAIS")
    private String clavepais;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONPAIS")
    private String descripcionpais;
    @Basic(optional = false)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;

    public Vpersonadomicilio() {
    }

    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }

    public int getDomicilioid() {
        return domicilioid;
    }

    public void setDomicilioid(int domicilioid) {
        this.domicilioid = domicilioid;
    }

    public Integer getCltipodomicilioid() {
        return cltipodomicilioid;
    }

    public void setCltipodomicilioid(Integer cltipodomicilioid) {
        this.cltipodomicilioid = cltipodomicilioid;
    }

    public String getClaveTipoDomicilio() {
        return claveTipoDomicilio;
    }

    public void setClaveTipoDomicilio(String claveTipoDomicilio) {
        this.claveTipoDomicilio = claveTipoDomicilio;
    }

    public String getDescripcionTipoDomilicio() {
        return descripcionTipoDomilicio;
    }

    public void setDescripcionTipoDomilicio(String descripcionTipoDomilicio) {
        this.descripcionTipoDomilicio = descripcionTipoDomilicio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Short getMunicipioid() {
        return municipioid;
    }

    public void setMunicipioid(Short municipioid) {
        this.municipioid = municipioid;
    }

    public String getClavemunicipio() {
        return clavemunicipio;
    }

    public void setClavemunicipio(String clavemunicipio) {
        this.clavemunicipio = clavemunicipio;
    }

    public String getDescripcionmunicipio() {
        return descripcionmunicipio;
    }

    public void setDescripcionmunicipio(String descripcionmunicipio) {
        this.descripcionmunicipio = descripcionmunicipio;
    }

    public short getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(short estadoid) {
        this.estadoid = estadoid;
    }

    public String getClaveestado() {
        return claveestado;
    }

    public void setClaveestado(String claveestado) {
        this.claveestado = claveestado;
    }

    public String getNombreestado() {
        return nombreestado;
    }

    public void setNombreestado(String nombreestado) {
        this.nombreestado = nombreestado;
    }

    public short getPaisid() {
        return paisid;
    }

    public void setPaisid(short paisid) {
        this.paisid = paisid;
    }

    public String getClavepais() {
        return clavepais;
    }

    public void setClavepais(String clavepais) {
        this.clavepais = clavepais;
    }

    public String getDescripcionpais() {
        return descripcionpais;
    }

    public void setDescripcionpais(String descripcionpais) {
        this.descripcionpais = descripcionpais;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }
    
}
