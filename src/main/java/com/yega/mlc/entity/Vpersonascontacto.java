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
@Table(name = "vpersonascontacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vpersonascontacto.findAll", query = "SELECT v FROM Vpersonascontacto v"),
    @NamedQuery(name = "Vpersonascontacto.findByPersonaid", query = "SELECT v FROM Vpersonascontacto v WHERE v.personaid = :personaid"),
    @NamedQuery(name = "Vpersonascontacto.findByContactopersonaid", query = "SELECT v FROM Vpersonascontacto v WHERE v.contactopersonaid = :contactopersonaid"),
    @NamedQuery(name = "Vpersonascontacto.findByCltipocontactoid", query = "SELECT v FROM Vpersonascontacto v WHERE v.cltipocontactoid = :cltipocontactoid"),
    @NamedQuery(name = "Vpersonascontacto.findByClaveTipoContacto", query = "SELECT v FROM Vpersonascontacto v WHERE v.claveTipoContacto = :claveTipoContacto"),
    @NamedQuery(name = "Vpersonascontacto.findByDescripcionTipoContacto", query = "SELECT v FROM Vpersonascontacto v WHERE v.descripcionTipoContacto = :descripcionTipoContacto"),
    @NamedQuery(name = "Vpersonascontacto.findByContacto", query = "SELECT v FROM Vpersonascontacto v WHERE v.contacto = :contacto"),
    @NamedQuery(name = "Vpersonascontacto.findByPrincipal", query = "SELECT v FROM Vpersonascontacto v WHERE v.principal = :principal")})
public class Vpersonascontacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PERSONAID")
    private int personaid;
    @Basic(optional = false)
    @Column(name = "CONTACTOPERSONAID")
    private int contactopersonaid;
    @Basic(optional = false)
    @Column(name = "CLTIPOCONTACTOID")
    private int cltipocontactoid;
    @Basic(optional = false)
    @Column(name = "CLAVE_TIPO_CONTACTO")
    private String claveTipoContacto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_TIPO_CONTACTO")
    private String descripcionTipoContacto;
    @Basic(optional = false)
    @Column(name = "CONTACTO")
    private String contacto;
    @Basic(optional = false)
    @Column(name = "PRINCIPAL")
    private boolean principal;

    public Vpersonascontacto() {
    }

    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }

    public int getContactopersonaid() {
        return contactopersonaid;
    }

    public void setContactopersonaid(int contactopersonaid) {
        this.contactopersonaid = contactopersonaid;
    }

    public int getCltipocontactoid() {
        return cltipocontactoid;
    }

    public void setCltipocontactoid(int cltipocontactoid) {
        this.cltipocontactoid = cltipocontactoid;
    }

    public String getClaveTipoContacto() {
        return claveTipoContacto;
    }

    public void setClaveTipoContacto(String claveTipoContacto) {
        this.claveTipoContacto = claveTipoContacto;
    }

    public String getDescripcionTipoContacto() {
        return descripcionTipoContacto;
    }

    public void setDescripcionTipoContacto(String descripcionTipoContacto) {
        this.descripcionTipoContacto = descripcionTipoContacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    
}
