/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaparqueadero.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manue
 */
@Entity
@Table(name = "bicicleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bicicleta.findAll", query = "SELECT b FROM Bicicleta b")
    , @NamedQuery(name = "Bicicleta.findByIdbicicleta", query = "SELECT b FROM Bicicleta b WHERE b.idbicicleta = :idbicicleta")
    , @NamedQuery(name = "Bicicleta.findByFoto", query = "SELECT b FROM Bicicleta b WHERE b.foto = :foto")})
public class Bicicleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbicicleta")
    private Integer idbicicleta;
    @Size(max = 500)
    @Column(name = "foto")
    private String foto;

    public Bicicleta() {
    }

    
     public Bicicleta(String foto) {
         this.foto = foto;
    }
    public Bicicleta(Integer idbicicleta) {
        this.idbicicleta = idbicicleta;
    }

    public Integer getIdbicicleta() {
        return idbicicleta;
    }

    public void setIdbicicleta(Integer idbicicleta) {
        this.idbicicleta = idbicicleta;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbicicleta != null ? idbicicleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bicicleta)) {
            return false;
        }
        Bicicleta other = (Bicicleta) object;
        if ((this.idbicicleta == null && other.idbicicleta != null) || (this.idbicicleta != null && !this.idbicicleta.equals(other.idbicicleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaparqueadero.entity.Bicicleta[ idbicicleta=" + idbicicleta + " ]";
    }
    
}
