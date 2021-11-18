/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Guillermo
 */
@Embeddable
public class RmodulodocumentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "FOLIOID")
    private int folioid;
    @Basic(optional = false)
    @Column(name = "SISMODID")
    private int sismodid;
    @Basic(optional = false)
    @Column(name = "USUARIOID")
    private int usuarioid;

    public RmodulodocumentoPK() {
    }

    public RmodulodocumentoPK(int folioid, int sismodid, int usuarioid) {
        this.folioid = folioid;
        this.sismodid = sismodid;
        this.usuarioid = usuarioid;
    }

    public int getFolioid() {
        return folioid;
    }

    public void setFolioid(int folioid) {
        this.folioid = folioid;
    }

    public int getSismodid() {
        return sismodid;
    }

    public void setSismodid(int sismodid) {
        this.sismodid = sismodid;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) folioid;
        hash += (int) sismodid;
        hash += (int) usuarioid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmodulodocumentoPK)) {
            return false;
        }
        RmodulodocumentoPK other = (RmodulodocumentoPK) object;
        if (this.folioid != other.folioid) {
            return false;
        }
        if (this.sismodid != other.sismodid) {
            return false;
        }
        if (this.usuarioid != other.usuarioid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.RmodulodocumentoPK[ folioid=" + folioid + ", sismodid=" + sismodid + ", usuarioid=" + usuarioid + " ]";
    }
    
}
