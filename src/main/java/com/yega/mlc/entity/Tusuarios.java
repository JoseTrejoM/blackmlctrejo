/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guillermo
 */
@Entity
@Table(name = "tusuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tusuarios.findAll", query = "SELECT t FROM Tusuarios t"),
    @NamedQuery(name = "Tusuarios.findByUsuarioid", query = "SELECT t FROM Tusuarios t WHERE t.usuarioid = :usuarioid"),
    @NamedQuery(name = "Tusuarios.findByUsuario", query = "SELECT t FROM Tusuarios t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "Tusuarios.findByIniciales", query = "SELECT t FROM Tusuarios t WHERE t.iniciales = :iniciales"),
    @NamedQuery(name = "Tusuarios.findByContrasena", query = "SELECT t FROM Tusuarios t WHERE t.contrasena = :contrasena"),
    @NamedQuery(name = "Tusuarios.findByPuesto", query = "SELECT t FROM Tusuarios t WHERE t.puesto = :puesto"),
    @NamedQuery(name = "Tusuarios.findByArea", query = "SELECT t FROM Tusuarios t WHERE t.area = :area"),
    @NamedQuery(name = "Tusuarios.findByIntentos", query = "SELECT t FROM Tusuarios t WHERE t.intentos = :intentos"),
    @NamedQuery(name = "Tusuarios.findByFechaalta", query = "SELECT t FROM Tusuarios t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tusuarios.findByFechaultimoacceso", query = "SELECT t FROM Tusuarios t WHERE t.fechaultimoacceso = :fechaultimoacceso"),
    @NamedQuery(name = "Tusuarios.findByFoto", query = "SELECT t FROM Tusuarios t WHERE t.foto = :foto")})
public class Tusuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USUARIOID")
    private Integer usuarioid;
    @Basic(optional = false)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "INICIALES")
    private String iniciales;
    @Basic(optional = false)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name = "PUESTO")
    private String puesto;
    @Basic(optional = false)
    @Column(name = "AREA")
    private String area;
    @Column(name = "INTENTOS")
    private Integer intentos;
    @Basic(optional = false)
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Basic(optional = false)
    @Column(name = "FECHAULTIMOACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaultimoacceso;
    @Column(name = "FOTO")
    private String foto;
    @ManyToMany(mappedBy = "tusuariosCollection")
    private Collection<Cgrupo> cgrupoCollection;
    @OneToMany(mappedBy = "usuarioid")
    private Collection<Tauditoriausuarios> tauditoriausuariosCollection;
    @OneToMany(mappedBy = "usuarioid")
    private Collection<Tsesiones> tsesionesCollection;
    @JoinColumn(name = "ESTATUSUSUARIOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle estatususuarioid;
    @JoinColumn(name = "ROLID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle rolid;
    @JoinColumn(name = "TIPOUSUARIOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle tipousuarioid;
    @JoinColumn(name = "PERSONAFISICAID", referencedColumnName = "PERSONAFISICAID")
    @ManyToOne
    private Tpersonafisica personafisicaid;

    public Tusuarios() {
    }

    public Tusuarios(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Tusuarios(Integer usuarioid, String usuario, String contrasena, String area, Date fechaalta, Date fechaultimoacceso) {
        this.usuarioid = usuarioid;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.area = area;
        this.fechaalta = fechaalta;
        this.fechaultimoacceso = fechaultimoacceso;
    }

    public Integer getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechaultimoacceso() {
        return fechaultimoacceso;
    }

    public void setFechaultimoacceso(Date fechaultimoacceso) {
        this.fechaultimoacceso = fechaultimoacceso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Cgrupo> getCgrupoCollection() {
        return cgrupoCollection;
    }

    public void setCgrupoCollection(Collection<Cgrupo> cgrupoCollection) {
        this.cgrupoCollection = cgrupoCollection;
    }

    @XmlTransient
    public Collection<Tauditoriausuarios> getTauditoriausuariosCollection() {
        return tauditoriausuariosCollection;
    }

    public void setTauditoriausuariosCollection(Collection<Tauditoriausuarios> tauditoriausuariosCollection) {
        this.tauditoriausuariosCollection = tauditoriausuariosCollection;
    }

    @XmlTransient
    public Collection<Tsesiones> getTsesionesCollection() {
        return tsesionesCollection;
    }

    public void setTsesionesCollection(Collection<Tsesiones> tsesionesCollection) {
        this.tsesionesCollection = tsesionesCollection;
    }

    public Cmaestrodetalle getEstatususuarioid() {
        return estatususuarioid;
    }

    public void setEstatususuarioid(Cmaestrodetalle estatususuarioid) {
        this.estatususuarioid = estatususuarioid;
    }

    public Cmaestrodetalle getRolid() {
        return rolid;
    }

    public void setRolid(Cmaestrodetalle rolid) {
        this.rolid = rolid;
    }

    public Cmaestrodetalle getTipousuarioid() {
        return tipousuarioid;
    }

    public void setTipousuarioid(Cmaestrodetalle tipousuarioid) {
        this.tipousuarioid = tipousuarioid;
    }

    public Tpersonafisica getPersonafisicaid() {
        return personafisicaid;
    }

    public void setPersonafisicaid(Tpersonafisica personafisicaid) {
        this.personafisicaid = personafisicaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioid != null ? usuarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tusuarios)) {
            return false;
        }
        Tusuarios other = (Tusuarios) object;
        if ((this.usuarioid == null && other.usuarioid != null) || (this.usuarioid != null && !this.usuarioid.equals(other.usuarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tusuarios[ usuarioid=" + usuarioid + " ]";
    }
    
}
