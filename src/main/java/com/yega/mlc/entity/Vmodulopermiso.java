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
@Table(name = "vmodulopermiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vmodulopermiso.findAll", query = "SELECT v FROM Vmodulopermiso v"),
    @NamedQuery(name = "Vmodulopermiso.findByPermisoid", query = "SELECT v FROM Vmodulopermiso v WHERE v.permisoid = :permisoid"),
    @NamedQuery(name = "Vmodulopermiso.findByDescripcionpermiso", query = "SELECT v FROM Vmodulopermiso v WHERE v.descripcionpermiso = :descripcionpermiso"),
    @NamedQuery(name = "Vmodulopermiso.findByUsuarioid", query = "SELECT v FROM Vmodulopermiso v WHERE v.usuarioid = :usuarioid"),
    @NamedQuery(name = "Vmodulopermiso.findBySismodpadreid", query = "SELECT v FROM Vmodulopermiso v WHERE v.sismodpadreid = :sismodpadreid"),
    @NamedQuery(name = "Vmodulopermiso.findBySismodid", query = "SELECT v FROM Vmodulopermiso v WHERE v.sismodid = :sismodid")})
public class Vmodulopermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PERMISOID")
    private int permisoid;
    @Column(name = "DESCRIPCIONPERMISO")
    private String descripcionpermiso;
    @Basic(optional = false)
    @Column(name = "USUARIOID")
    private int usuarioid;
    @Column(name = "SISMODPADREID")
    private Integer sismodpadreid;
    @Basic(optional = false)
    @Column(name = "SISMODID")
    private int sismodid;

    public Vmodulopermiso() {
    }

    public int getPermisoid() {
        return permisoid;
    }

    public void setPermisoid(int permisoid) {
        this.permisoid = permisoid;
    }

    public String getDescripcionpermiso() {
        return descripcionpermiso;
    }

    public void setDescripcionpermiso(String descripcionpermiso) {
        this.descripcionpermiso = descripcionpermiso;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Integer getSismodpadreid() {
        return sismodpadreid;
    }

    public void setSismodpadreid(Integer sismodpadreid) {
        this.sismodpadreid = sismodpadreid;
    }

    public int getSismodid() {
        return sismodid;
    }

    public void setSismodid(int sismodid) {
        this.sismodid = sismodid;
    }
    
}
