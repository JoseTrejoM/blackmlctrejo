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
@Table(name = "vplanbeneficios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vplanbeneficios.findAll", query = "SELECT v FROM Vplanbeneficios v"),
    @NamedQuery(name = "Vplanbeneficios.findByTipoplanid", query = "SELECT v FROM Vplanbeneficios v WHERE v.tipoplanid = :tipoplanid"),
    @NamedQuery(name = "Vplanbeneficios.findByDescripcionplan", query = "SELECT v FROM Vplanbeneficios v WHERE v.descripcionplan = :descripcionplan"),
    @NamedQuery(name = "Vplanbeneficios.findByPrecio", query = "SELECT v FROM Vplanbeneficios v WHERE v.precio = :precio"),
    @NamedQuery(name = "Vplanbeneficios.findByDescripcion", query = "SELECT v FROM Vplanbeneficios v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vplanbeneficios.findByEdadminima", query = "SELECT v FROM Vplanbeneficios v WHERE v.edadminima = :edadminima"),
    @NamedQuery(name = "Vplanbeneficios.findByEdadmaxima", query = "SELECT v FROM Vplanbeneficios v WHERE v.edadmaxima = :edadmaxima"),
    @NamedQuery(name = "Vplanbeneficios.findByResideextranjero", query = "SELECT v FROM Vplanbeneficios v WHERE v.resideextranjero = :resideextranjero"),
    @NamedQuery(name = "Vplanbeneficios.findByRepatriacionaMexico", query = "SELECT v FROM Vplanbeneficios v WHERE v.repatriacionaMexico = :repatriacionaMexico"),
    @NamedQuery(name = "Vplanbeneficios.findByServicioFunerario", query = "SELECT v FROM Vplanbeneficios v WHERE v.servicioFunerario = :servicioFunerario"),
    @NamedQuery(name = "Vplanbeneficios.findBySegurodevida", query = "SELECT v FROM Vplanbeneficios v WHERE v.segurodevida = :segurodevida"),
    @NamedQuery(name = "Vplanbeneficios.findByEducacionfinanciera", query = "SELECT v FROM Vplanbeneficios v WHERE v.educacionfinanciera = :educacionfinanciera"),
    @NamedQuery(name = "Vplanbeneficios.findByEnviodedinero", query = "SELECT v FROM Vplanbeneficios v WHERE v.enviodedinero = :enviodedinero")})
public class Vplanbeneficios implements Serializable {

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

    public Vplanbeneficios() {
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
    
}
