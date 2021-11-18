/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guillermo
 */
@Embeddable
@Table(name = "vpersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vpersona.findAll", query = "SELECT v FROM Vpersona v"),
    @NamedQuery(name = "Vpersona.findByPersonaid", query = "SELECT v FROM Vpersona v WHERE v.personaid = :personaid"),
    @NamedQuery(name = "Vpersona.findByCltipopersonaid", query = "SELECT v FROM Vpersona v WHERE v.cltipopersonaid = :cltipopersonaid"),
    @NamedQuery(name = "Vpersona.findByClave", query = "SELECT v FROM Vpersona v WHERE v.clave = :clave"),
    @NamedQuery(name = "Vpersona.findByDescripcion", query = "SELECT v FROM Vpersona v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vpersona.findByRfc", query = "SELECT v FROM Vpersona v WHERE v.rfc = :rfc"),
    @NamedQuery(name = "Vpersona.findByNombreRazonSocial", query = "SELECT v FROM Vpersona v WHERE v.nombreRazonSocial = :nombreRazonSocial"),
    @NamedQuery(name = "Vpersona.findByClsexoid", query = "SELECT v FROM Vpersona v WHERE v.clsexoid = :clsexoid"),
    @NamedQuery(name = "Vpersona.findByClaveSexo", query = "SELECT v FROM Vpersona v WHERE v.claveSexo = :claveSexo"),
    @NamedQuery(name = "Vpersona.findBySexo", query = "SELECT v FROM Vpersona v WHERE v.sexo = :sexo"),
    @NamedQuery(name = "Vpersona.findByFechanacimiento", query = "SELECT v FROM Vpersona v WHERE v.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Vpersona.findByCurp", query = "SELECT v FROM Vpersona v WHERE v.curp = :curp"),
    @NamedQuery(name = "Vpersona.findByNss", query = "SELECT v FROM Vpersona v WHERE v.nss = :nss"),
    @NamedQuery(name = "Vpersona.findByTin", query = "SELECT v FROM Vpersona v WHERE v.tin = :tin")})
public class Vpersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PERSONAID")
    private int personaid;
    @Basic(optional = false)
    @Column(name = "CLTIPOPERSONAID")
    private int cltipopersonaid;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RFC")
    private String rfc;
    @Column(name = "NOMBRE_RAZON_SOCIAL")
    private String nombreRazonSocial;
    @Basic(optional = false)
    @Column(name = "CLSEXOID")
    private int clsexoid;
    @Column(name = "CLAVE_SEXO")
    private String claveSexo;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "CURP")
    private String curp;
    @Column(name = "NSS")
    private String nss;
    @Column(name = "TIN")
    private String tin;

    public Vpersona() {
    }

    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }

    public int getCltipopersonaid() {
        return cltipopersonaid;
    }

    public void setCltipopersonaid(int cltipopersonaid) {
        this.cltipopersonaid = cltipopersonaid;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public int getClsexoid() {
        return clsexoid;
    }

    public void setClsexoid(int clsexoid) {
        this.clsexoid = clsexoid;
    }

    public String getClaveSexo() {
        return claveSexo;
    }

    public void setClaveSexo(String claveSexo) {
        this.claveSexo = claveSexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
    
}
