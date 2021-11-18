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
@Table(name = "vplan_beneficios_beneficiarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findAll", query = "SELECT v FROM VplanBeneficiosBeneficiarios v"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByTipoplanid", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.tipoplanid = :tipoplanid"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByDescripcionplan", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.descripcionplan = :descripcionplan"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByPrecioMensual", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.precioMensual = :precioMensual"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByPrecioAnual", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.precioAnual = :precioAnual"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByEdadminima", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.edadminima = :edadminima"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByEdadmaxima", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.edadmaxima = :edadmaxima"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByResideextranjero", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.resideextranjero = :resideextranjero"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByRepatriacionaMexico", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.repatriacionaMexico = :repatriacionaMexico"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByServicioFunerario", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.servicioFunerario = :servicioFunerario"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findBySegurodevida", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.segurodevida = :segurodevida"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByEducacionfinanciera", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.educacionfinanciera = :educacionfinanciera"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByEnviodedinero", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.enviodedinero = :enviodedinero"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByTitular", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.titular = :titular"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByPareja", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.pareja = :pareja"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByPadre", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.padre = :padre"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByMadre", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.madre = :madre"),
    @NamedQuery(name = "VplanBeneficiosBeneficiarios.findByHijo", query = "SELECT v FROM VplanBeneficiosBeneficiarios v WHERE v.hijo = :hijo")})
public class VplanBeneficiosBeneficiarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "tipoplanid")
    private int tipoplanid;
    @Basic(optional = false)
    @Column(name = "descripcionplan")
    private String descripcionplan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_Mensual")
    private BigDecimal precioMensual;
    @Column(name = "precio_Anual")
    private BigDecimal precioAnual;
    @Column(name = "EDADMINIMA")
    private Short edadminima;
    @Column(name = "EDADMAXIMA")
    private Short edadmaxima;
    @Column(name = "RESIDEEXTRANJERO")
    private Short resideextranjero;
    @Column(name = "Repatriacion_a_Mexico")
    private BigInteger repatriacionaMexico;
    @Column(name = "Servicio_Funerario")
    private BigInteger servicioFunerario;
    @Column(name = "Seguro_de_vida")
    private BigInteger segurodevida;
    @Column(name = "Educacion_financiera")
    private BigInteger educacionfinanciera;
    @Column(name = "Envio_de_dinero")
    private BigInteger enviodedinero;
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

    public VplanBeneficiosBeneficiarios() {
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

    public BigDecimal getPrecioMensual() {
        return precioMensual;
    }

    public void setPrecioMensual(BigDecimal precioMensual) {
        this.precioMensual = precioMensual;
    }

    public BigDecimal getPrecioAnual() {
        return precioAnual;
    }

    public void setPrecioAnual(BigDecimal precioAnual) {
        this.precioAnual = precioAnual;
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

    public BigInteger getRepatriacionaMexico() {
        return repatriacionaMexico;
    }

    public void setRepatriacionaMexico(BigInteger repatriacionaMexico) {
        this.repatriacionaMexico = repatriacionaMexico;
    }

    public BigInteger getServicioFunerario() {
        return servicioFunerario;
    }

    public void setServicioFunerario(BigInteger servicioFunerario) {
        this.servicioFunerario = servicioFunerario;
    }

    public BigInteger getSegurodevida() {
        return segurodevida;
    }

    public void setSegurodevida(BigInteger segurodevida) {
        this.segurodevida = segurodevida;
    }

    public BigInteger getEducacionfinanciera() {
        return educacionfinanciera;
    }

    public void setEducacionfinanciera(BigInteger educacionfinanciera) {
        this.educacionfinanciera = educacionfinanciera;
    }

    public BigInteger getEnviodedinero() {
        return enviodedinero;
    }

    public void setEnviodedinero(BigInteger enviodedinero) {
        this.enviodedinero = enviodedinero;
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
