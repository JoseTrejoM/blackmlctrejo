/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Guillermo
 */
@Entity
//@Embeddable
@Immutable
@IdClass(VpropuestaBeneficiariosBeneficiosPk.class)
@Table(name = "vpropuesta_beneficiarios_beneficios")
public class VpropuestaBeneficiariosBeneficios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROPUESTAID")
    private int propuestaid;
    @Basic(optional = false)
    @Column(name = "CLESTATUSPROPUESTAID")
    private int clestatuspropuestaid;
    @Basic(optional = false)
    @Column(name = "ESTATUSPROPUESTA")
    private String estatuspropuesta;
    @Basic(optional = false)
    @Column(name = "CURP")
    private String curp;
    @Column(name = "ESMENOR56")
    private Boolean esmenor56;
    @Column(name = "ACUERDOCURP")
    private Boolean acuerdocurp;
    @Basic(optional = false)
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Basic(optional = false)
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Basic(optional = false)
    @Column(name = "BENEFICIOBENEFICIARIOID")
    private int beneficiobeneficiarioid;
    @Basic(optional = false)
    @Column(name = "BENEFICIARIOID")
    private int beneficiarioid;
    @Id
    @Basic(optional = false)
    @Column(name = "TIPOBENEFICIARIOID")
    private int tipobeneficiarioid;
    @Basic(optional = false)
    @Column(name = "TIPOBENEFICIARIO")
    private String tipobeneficiario;
    @Basic(optional = false)
    @Column(name = "IMAGENACTIVO")
    private String imagenactivo;
    @Basic(optional = false)
    @Column(name = "IMAGENINACTIVO")
    private String imageninactivo;
    @Basic(optional = false)
    @Column(name = "IMAGENDEFAULT")
    private String imagendefault;
    @Basic(optional = false)
    @Column(name = "ESSELECCIONADO")
    private boolean esseleccionado;
    @Basic(optional = false)
    @Column(name = "SERVICIOBENEFICIARIOID")
    private int serviciobeneficiarioid;
    @Column(name = "SERVICIOCONTRATADOID")
    private Integer serviciocontratadoid;
    @Id
    @Column(name = "BENEFICIOID")
    private Integer beneficioid;
    @Basic(optional = false)
    @Column(name = "TITULOBENEFICIO")
    private String titulobeneficio;
    @Column(name = "SUBTITULOBENEFICIO")
    private String subtitulobeneficio;
    @Basic(optional = false)
    @Column(name = "DESCRIPCIONBENEFICIO")
    private String descripcionbeneficio;
    @Column(name = "PAISID_RES")
    private Short paisid_res;
    @Column(name = "DESCRIPCIONPAIS_RES")
    private String descripcionpais_res;
    @Column(name = "ESTADOID_RES")
    private Short estadoid_res;
    @Column(name = "NOMBREESTADO_RES")
    private String nombreestado_res;
    @Column(name = "PAISID_ORIGEN")
    private Short paisid_origen;
    @Column(name = "DESCRIPCIONPAIS_ORIGEN")
    private String descripcionpais_origen;
    @Column(name = "ESTADOID_ORIGEN")
    private Short estadoid_origen;
    @Column(name = "NOMBREESTADO_origen")
    private String nombreestado_origen;
    @Column(name = "PERSONAID")
    private Integer personaid;
    @Column(name = "CLTIPOPERSONAID")
    private Integer cltipopersonaid;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "TIPOPERSONA")
    private String tipopersona;
    @Column(name = "RFC")
    private String rfc;
    @Column(name = "CURP_PERSONA")
    private String curpPersona;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PRIMERAPELLIDO")
    private String primerapellido;
    @Column(name = "SEGUNDOAPELLIDO")
    private String segundoapellido;
    @Column(name = "CLSEXOID")
    private Integer clsexoid;
    @Column(name = "CLAVE_SEXO")
    private String claveSexo;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "NSS")
    private String nss;
    @Column(name = "CLTIPOCONTACTOID_CORREO")
    private Integer cltipocontactoidCorreo;
    @Column(name = "CONTACTOPERSONAID_CORREO")
    private Integer contactopersonaidCorreo;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "CLTIPOCONTACTOID_TELEFONO")
    private Integer cltipocontactoidTelefono;
    @Column(name = "CONTACTOPERSONAID_TELEFONO")
    private Integer contactopersonaidTelefono;
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "FLAG")
    private int flag;

    @Column(name = "TIPOPLANID")
    private Integer tipoPlanId;
    @Column(name = "CLAVEPLAN")
    private String clavePlan;
    @Column(name = "DESCRIPCIONPLAN")
    private String descripcionPlan;
    @Column(name = "CLMONEDAID")
    private Integer clMonedaId;
    @Column(name = "MONEDA")
    private String moneda;
    @Column(name = "COSTO")
    private Double costo;
    @Column(name = "GASTOADMON")
    private Double gastoAdmon;
    @Column(name = "TOTAL")
    private Double total;
    @Column(name = "CLFRECUENCIAPAGOID")
    private Integer clFrecuenciaPagoId;
    @Column(name = "FRECUENCIAPAGO")
    private String frecuenciaPago;
    @Column(name = "CLFORMAPAGOID")
    private Integer clFormaPagoId;
    @Column(name = "FORMAPAGO")
    private String formaPago;
    @Column(name = "MENSUAL")
    private Double mensual;
    @Column(name = "ANUAL")
    private Double anual;

    public VpropuestaBeneficiariosBeneficios() {
    }

    public int getPropuestaid() {
        return propuestaid;
    }

    public void setPropuestaid(int propuestaid) {
        this.propuestaid = propuestaid;
    }

    public int getClestatuspropuestaid() {
        return clestatuspropuestaid;
    }

    public void setClestatuspropuestaid(int clestatuspropuestaid) {
        this.clestatuspropuestaid = clestatuspropuestaid;
    }

    public String getEstatuspropuesta() {
        return estatuspropuesta;
    }

    public void setEstatuspropuesta(String estatuspropuesta) {
        this.estatuspropuesta = estatuspropuesta;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Boolean getEsmenor56() {
        return esmenor56;
    }

    public void setEsmenor56(Boolean esmenor56) {
        this.esmenor56 = esmenor56;
    }

    public Boolean getAcuerdocurp() {
        return acuerdocurp;
    }

    public void setAcuerdocurp(Boolean acuerdocurp) {
        this.acuerdocurp = acuerdocurp;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public int getBeneficiobeneficiarioid() {
        return beneficiobeneficiarioid;
    }

    public void setBeneficiobeneficiarioid(int beneficiobeneficiarioid) {
        this.beneficiobeneficiarioid = beneficiobeneficiarioid;
    }

    public int getBeneficiarioid() {
        return beneficiarioid;
    }

    public void setBeneficiarioid(int beneficiarioid) {
        this.beneficiarioid = beneficiarioid;
    }

    public int getTipobeneficiarioid() {
        return tipobeneficiarioid;
    }

    public void setTipobeneficiarioid(int tipobeneficiarioid) {
        this.tipobeneficiarioid = tipobeneficiarioid;
    }

    public String getTipobeneficiario() {
        return tipobeneficiario;
    }

    public void setTipobeneficiario(String tipobeneficiario) {
        this.tipobeneficiario = tipobeneficiario;
    }

    public String getImagenactivo() {
        return imagenactivo;
    }

    public void setImagenactivo(String imagenactivo) {
        this.imagenactivo = imagenactivo;
    }

    public String getImageninactivo() {
        return imageninactivo;
    }

    public void setImageninactivo(String imageninactivo) {
        this.imageninactivo = imageninactivo;
    }

    public String getImagendefault() {
        return imagendefault;
    }

    public void setImagendefault(String imagendefault) {
        this.imagendefault = imagendefault;
    }

    public boolean getEsseleccionado() {
        return esseleccionado;
    }

    public void setEsseleccionado(boolean esseleccionado) {
        this.esseleccionado = esseleccionado;
    }

    public int getServiciobeneficiarioid() {
        return serviciobeneficiarioid;
    }

    public void setServiciobeneficiarioid(int serviciobeneficiarioid) {
        this.serviciobeneficiarioid = serviciobeneficiarioid;
    }

    public Integer getServiciocontratadoid() {
        return serviciocontratadoid;
    }

    public void setServiciocontratadoid(Integer serviciocontratadoid) {
        this.serviciocontratadoid = serviciocontratadoid;
    }

    public Integer getBeneficioid() {
        return beneficioid;
    }

    public void setBeneficioid(Integer beneficioid) {
        this.beneficioid = beneficioid;
    }

    public String getTitulobeneficio() {
        return titulobeneficio;
    }

    public void setTitulobeneficio(String titulobeneficio) {
        this.titulobeneficio = titulobeneficio;
    }

    public String getSubtitulobeneficio() {
        return subtitulobeneficio;
    }

    public void setSubtitulobeneficio(String subtitulobeneficio) {
        this.subtitulobeneficio = subtitulobeneficio;
    }

    public String getDescripcionbeneficio() {
        return descripcionbeneficio;
    }

    public void setDescripcionbeneficio(String descripcionbeneficio) {
        this.descripcionbeneficio = descripcionbeneficio;
    }

    /*public Short getPaisid() {
        return paisid;
    }

    public void setPaisid(Short paisid) {
        this.paisid = paisid;
    }

    public String getDescripcionpais() {
        return descripcionpais;
    }

    public void setDescripcionpais(String descripcionpais) {
        this.descripcionpais = descripcionpais;
    }

    public Short getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(Short estadoid) {
        this.estadoid = estadoid;
    }

    public String getNombreestado() {
        return nombreestado;
    }

    public void setNombreestado(String nombreestado) {
        this.nombreestado = nombreestado;
    }
*/


public Short getPaisid_res() {
    return paisid_res;
}

public void setPaisid_res(Short paisid_res) {
    this.paisid_res = paisid_res;
}

public String getDescripcionpais_res() {
    return descripcionpais_res;
}

public void setDescripcionpais_res(String descripcionpais_res) {
    this.descripcionpais_res = descripcionpais_res;
}

public Short getEstadoid_res() {
    return estadoid_res;
}

public void setEstadoid_res(Short estadoid_res) {
    this.estadoid_res = estadoid_res;
}

public String getNombreestado_res() {
    return nombreestado_res;
}

public void setNombreestado_res(String nombreestado_res) {
    this.nombreestado_res = nombreestado_res;
}

public Short getPaisid_origen() {
    return paisid_origen;
}

public void setPaisid_origen(Short paisid_origen) {
    this.paisid_origen = paisid_origen;
}

public String getDescripcionpais_origen() {
    return descripcionpais_origen;
}

public void setDescripcionpais_origen(String descripcionpais_origen) {
    this.descripcionpais_origen = descripcionpais_origen;
}

public Short getEstadoid_origen() {
    return estadoid_origen;
}

public void setEstadoid_origen(Short estadoid_origen) {
    this.estadoid_origen = estadoid_origen;
}

public String getNombreestado_origen() {
    return nombreestado_origen;
}

public void setNombreestado_origen(String nombreestado_origen) {
    this.nombreestado_origen = nombreestado_origen;
}

public Integer getPersonaid() {
       return personaid;
 }

    public void setPersonaid(Integer personaid) {
        this.personaid = personaid;
    }

    public Integer getCltipopersonaid() {
        return cltipopersonaid;
    }

    public void setCltipopersonaid(Integer cltipopersonaid) {
        this.cltipopersonaid = cltipopersonaid;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(String tipopersona) {
        this.tipopersona = tipopersona;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurpPersona() {
        return curpPersona;
    }

    public void setCurpPersona(String curpPersona) {
        this.curpPersona = curpPersona;
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

    public Integer getClsexoid() {
        return clsexoid;
    }

    public void setClsexoid(Integer clsexoid) {
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

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public Integer getCltipocontactoidCorreo() {
        return cltipocontactoidCorreo;
    }

    public void setCltipocontactoidCorreo(Integer cltipocontactoidCorreo) {
        this.cltipocontactoidCorreo = cltipocontactoidCorreo;
    }

    public Integer getContactopersonaidCorreo() {
        return contactopersonaidCorreo;
    }

    public void setContactopersonaidCorreo(Integer contactopersonaidCorreo) {
        this.contactopersonaidCorreo = contactopersonaidCorreo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getCltipocontactoidTelefono() {
        return cltipocontactoidTelefono;
    }

    public void setCltipocontactoidTelefono(Integer cltipocontactoidTelefono) {
        this.cltipocontactoidTelefono = cltipocontactoidTelefono;
    }

    public Integer getContactopersonaidTelefono() {
        return contactopersonaidTelefono;
    }

    public void setContactopersonaidTelefono(Integer contactopersonaidTelefono) {
        this.contactopersonaidTelefono = contactopersonaidTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    public Integer getTipoPlanId() {
        return tipoPlanId;
    }

    /**
     * @param tipoPlanId the tipoPlanId to set
     */
    public void setTipoPlanId(Integer tipoPlanId) {
        this.tipoPlanId = tipoPlanId;
    }

    /**
     * @return String return the clavePlan
     */
    public String getClavePlan() {
        return clavePlan;
    }

    /**
     * @param clavePlan the clavePlan to set
     */
    public void setClavePlan(String clavePlan) {
        this.clavePlan = clavePlan;
    }

    /**
     * @return String return the descripcionPlan
     */
    public String getDescripcionPlan() {
        return descripcionPlan;
    }

    /**
     * @param descripcionPlan the descripcionPlan to set
     */
    public void setDescripcionPlan(String descripcionPlan) {
        this.descripcionPlan = descripcionPlan;
    }

    /**
     * @return Integer return the clMonedaId
     */
    public Integer getClMonedaId() {
        return clMonedaId;
    }

    /**
     * @param clMonedaId the clMonedaId to set
     */
    public void setClMonedaId(Integer clMonedaId) {
        this.clMonedaId = clMonedaId;
    }

    /**
     * @return String return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return Double return the costo
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * @return Double return the gastoAdmon
     */
    public Double getGastoAdmon() {
        return gastoAdmon;
    }

    /**
     * @param gastoAdmon the gastoAdmon to set
     */
    public void setGastoAdmon(Double gastoAdmon) {
        this.gastoAdmon = gastoAdmon;
    }

    /**
     * @return Double return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return Integer return the clFrecuenciaPagoId
     */
    public Integer getClFrecuenciaPagoId() {
        return clFrecuenciaPagoId;
    }

    /**
     * @param clFrecuenciaPagoId the clFrecuenciaPagoId to set
     */
    public void setClFrecuenciaPagoId(Integer clFrecuenciaPagoId) {
        this.clFrecuenciaPagoId = clFrecuenciaPagoId;
    }

    /**
     * @return String return the frecuenciaPago
     */
    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    /**
     * @param frecuenciaPago the frecuenciaPago to set
     */
    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    /**
     * @return Integer return the clFormaPagoId
     */
    public Integer getClFormaPagoId() {
        return clFormaPagoId;
    }

    /**
     * @param clFormaPagoId the clFormaPagoId to set
     */
    public void setClFormaPagoId(Integer clFormaPagoId) {
        this.clFormaPagoId = clFormaPagoId;
    }

    /**
     * @return String return the formaPago
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * @param formaPago the formaPago to set
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @return the mensual
     */
    public Double getMensual() {
        return mensual;
    }

    /**
     * @param mensual the mensual to set
     */
    public void setMensual(Double mensual) {
        this.mensual = mensual;
    }

    /**
     * @return the anual
     */
    public Double getAnual() {
        return anual;
    }

    /**
     * @param anual the anual to set
     */
    public void setAnual(Double anual) {
        this.anual = anual;
    }

}
