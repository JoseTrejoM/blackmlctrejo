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
public class TsesionparametrosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PARAMETROID")
    private int parametroid;
    @Basic(optional = false)
    @Column(name = "SESIONID")
    private int sesionid;

    public TsesionparametrosPK() {
    }

    public TsesionparametrosPK(int parametroid, int sesionid) {
        this.parametroid = parametroid;
        this.sesionid = sesionid;
    }

    public int getParametroid() {
        return parametroid;
    }

    public void setParametroid(int parametroid) {
        this.parametroid = parametroid;
    }

    public int getSesionid() {
        return sesionid;
    }

    public void setSesionid(int sesionid) {
        this.sesionid = sesionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) parametroid;
        hash += (int) sesionid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TsesionparametrosPK)) {
            return false;
        }
        TsesionparametrosPK other = (TsesionparametrosPK) object;
        if (this.parametroid != other.parametroid) {
            return false;
        }
        if (this.sesionid != other.sesionid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.TsesionparametrosPK[ parametroid=" + parametroid + ", sesionid=" + sesionid + " ]";
    }
    
}
