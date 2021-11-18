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
public class TdocumentosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "DOCUMENTOSID")
    private int documentosid;
    @Basic(optional = false)
    @Column(name = "CONTROLDOCUMENTOID")
    private int controldocumentoid;

    public TdocumentosPK() {
    }

    public TdocumentosPK(int documentosid, int controldocumentoid) {
        this.documentosid = documentosid;
        this.controldocumentoid = controldocumentoid;
    }

    public int getDocumentosid() {
        return documentosid;
    }

    public void setDocumentosid(int documentosid) {
        this.documentosid = documentosid;
    }

    public int getControldocumentoid() {
        return controldocumentoid;
    }

    public void setControldocumentoid(int controldocumentoid) {
        this.controldocumentoid = controldocumentoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentosid;
        hash += (int) controldocumentoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TdocumentosPK)) {
            return false;
        }
        TdocumentosPK other = (TdocumentosPK) object;
        if (this.documentosid != other.documentosid) {
            return false;
        }
        if (this.controldocumentoid != other.controldocumentoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.entidades.mlc_v2.TdocumentosPK[ documentosid=" + documentosid + ", controldocumentoid=" + controldocumentoid + " ]";
    }
    
}
