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
@Table(name = "vsistemamodulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vsistemamodulo.findAll", query = "SELECT v FROM Vsistemamodulo v"),
    @NamedQuery(name = "Vsistemamodulo.findBySismodpadreid", query = "SELECT v FROM Vsistemamodulo v WHERE v.sismodpadreid = :sismodpadreid"),
    @NamedQuery(name = "Vsistemamodulo.findBySismodid", query = "SELECT v FROM Vsistemamodulo v WHERE v.sismodid = :sismodid"),
    @NamedQuery(name = "Vsistemamodulo.findByPermiso", query = "SELECT v FROM Vsistemamodulo v WHERE v.permiso = :permiso"),
    @NamedQuery(name = "Vsistemamodulo.findByOrden", query = "SELECT v FROM Vsistemamodulo v WHERE v.orden = :orden"),
    @NamedQuery(name = "Vsistemamodulo.findByUsuarioid", query = "SELECT v FROM Vsistemamodulo v WHERE v.usuarioid = :usuarioid"),
    @NamedQuery(name = "Vsistemamodulo.findByNombre", query = "SELECT v FROM Vsistemamodulo v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vsistemamodulo.findByUrl", query = "SELECT v FROM Vsistemamodulo v WHERE v.url = :url"),
    @NamedQuery(name = "Vsistemamodulo.findByImagen", query = "SELECT v FROM Vsistemamodulo v WHERE v.imagen = :imagen")})
public class Vsistemamodulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "SISMODPADREID")
    private Integer sismodpadreid;
    @Basic(optional = false)
    @Column(name = "SISMODID")
    private int sismodid;
    @Basic(optional = false)
    @Column(name = "permiso")
    private int permiso;
    @Basic(optional = false)
    @Column(name = "ORDEN")
    private short orden;
    @Basic(optional = false)
    @Column(name = "USUARIOID")
    private int usuarioid;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Column(name = "IMAGEN")
    private String imagen;

    public Vsistemamodulo() {
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

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
