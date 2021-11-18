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
public class TpermisosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SISMODID")
    private int sismodid;
    @Basic(optional = false)
    @Column(name = "PERMISOID")
    private int permisoid;

    public TpermisosPK() {
    }

    public TpermisosPK(int sismodid, int permisoid) {
        this.sismodid = sismodid;
        this.permisoid = permisoid;
    }

    public int getSismodid() {
        return sismodid;
    }

    public void setSismodid(int sismodid) {
        this.sismodid = sismodid;
    }

    public int getPermisoid() {
        return permisoid;
    }

    public void setPermisoid(int permisoid) {
        this.permisoid = permisoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sismodid;
        hash += (int) permisoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TpermisosPK)) {
            return false;
        }
        TpermisosPK other = (TpermisosPK) object;
        if (this.sismodid != other.sismodid) {
            return false;
        }
        if (this.permisoid != other.permisoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.TpermisosPK[ sismodid=" + sismodid + ", permisoid=" + permisoid + " ]";
    }
    
}
