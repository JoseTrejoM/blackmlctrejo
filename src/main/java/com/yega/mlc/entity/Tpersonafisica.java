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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "tpersonafisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpersonafisica.findAll", query = "SELECT t FROM Tpersonafisica t"),
    @NamedQuery(name = "Tpersonafisica.findByPersonafisicaid", query = "SELECT t FROM Tpersonafisica t WHERE t.personafisicaid = :personafisicaid"),
    @NamedQuery(name = "Tpersonafisica.findByNombre", query = "SELECT t FROM Tpersonafisica t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tpersonafisica.findByPrimerapellido", query = "SELECT t FROM Tpersonafisica t WHERE t.primerapellido = :primerapellido"),
    @NamedQuery(name = "Tpersonafisica.findBySegundoapellido", query = "SELECT t FROM Tpersonafisica t WHERE t.segundoapellido = :segundoapellido"),
    @NamedQuery(name = "Tpersonafisica.findByFechanacimiento", query = "SELECT t FROM Tpersonafisica t WHERE t.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Tpersonafisica.findByFechaalta", query = "SELECT t FROM Tpersonafisica t WHERE t.fechaalta = :fechaalta"),
    @NamedQuery(name = "Tpersonafisica.findByCurp", query = "SELECT t FROM Tpersonafisica t WHERE t.curp = :curp"),
    @NamedQuery(name = "Tpersonafisica.findByNss", query = "SELECT t FROM Tpersonafisica t WHERE t.nss = :nss")})
public class Tpersonafisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PERSONAFISICAID")
    private Integer personafisicaid;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "PRIMERAPELLIDO")
    private String primerapellido;
    @Column(name = "SEGUNDOAPELLIDO")
    private String segundoapellido;
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Basic(optional = false)
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Column(name = "CURP")
    private String curp;
    @Column(name = "NSS")
    private String nss;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personafisicaid")
    private Collection<Tenlace> tenlaceCollection;
    @JoinColumn(name = "CLSEXOID", referencedColumnName = "CATALOGODETALLEID")
    @ManyToOne(optional = false)
    private Cmaestrodetalle clsexoid;
    @JoinColumn(name = "PERSONAFISICAID", referencedColumnName = "PERSONAID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tpersona tpersona;
    @OneToMany(mappedBy = "personafisicaid")
    private Collection<Tusuarios> tusuariosCollection;

    public Tpersonafisica() {
    }

    public Tpersonafisica(Integer personafisicaid) {
        this.personafisicaid = personafisicaid;
    }

    public Tpersonafisica(Integer personafisicaid, String nombre, String primerapellido, Date fechaalta) {
        this.personafisicaid = personafisicaid;
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.fechaalta = fechaalta;
    }

    public Integer getPersonafisicaid() {
        return personafisicaid;
    }

    public void setPersonafisicaid(Integer personafisicaid) {
        this.personafisicaid = personafisicaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
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

    @XmlTransient
    public Collection<Tenlace> getTenlaceCollection() {
        return tenlaceCollection;
    }

    public void setTenlaceCollection(Collection<Tenlace> tenlaceCollection) {
        this.tenlaceCollection = tenlaceCollection;
    }

    public Cmaestrodetalle getClsexoid() {
        return clsexoid;
    }

    public void setClsexoid(Cmaestrodetalle clsexoid) {
        this.clsexoid = clsexoid;
    }

    public Tpersona getTpersona() {
        return tpersona;
    }

    public void setTpersona(Tpersona tpersona) {
        this.tpersona = tpersona;
    }

    @XmlTransient
    public Collection<Tusuarios> getTusuariosCollection() {
        return tusuariosCollection;
    }

    public void setTusuariosCollection(Collection<Tusuarios> tusuariosCollection) {
        this.tusuariosCollection = tusuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personafisicaid != null ? personafisicaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpersonafisica)) {
            return false;
        }
        Tpersonafisica other = (Tpersonafisica) object;
        if ((this.personafisicaid == null && other.personafisicaid != null) || (this.personafisicaid != null && !this.personafisicaid.equals(other.personafisicaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.Tpersonafisica[ personafisicaid=" + personafisicaid + " ]";
    }
    
}
