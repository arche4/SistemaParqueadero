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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manue
 */
@Entity
@Table(name = "moto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moto.findAll", query = "SELECT m FROM Moto m")
    , @NamedQuery(name = "Moto.findByIdmoto", query = "SELECT m FROM Moto m WHERE m.idmoto = :idmoto")
    , @NamedQuery(name = "Moto.findByCilindraje", query = "SELECT m FROM Moto m WHERE m.cilindraje = :cilindraje")
    , @NamedQuery(name = "Moto.findByTiempos", query = "SELECT m FROM Moto m WHERE m.tiempos = :tiempos")
    , @NamedQuery(name = "Moto.findByPlaca", query = "SELECT m FROM Moto m WHERE m.placa = :placa")
    , @NamedQuery(name = "Moto.findByFotografia", query = "SELECT m FROM Moto m WHERE m.fotografia = :fotografia")})
public class Moto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmoto")
    private Integer idmoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cilindraje")
    private String cilindraje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tiempos")
    private String tiempos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "placa")
    private String placa;
    @Size(max = 500)
    @Column(name = "fotografia")
    private String fotografia;

    public Moto() {
    }

    public Moto(Integer idmoto) {
        this.idmoto = idmoto;
    }

    public Moto(Integer idmoto, String cilindraje, String tiempos, String placa) {
        this.idmoto = idmoto;
        this.cilindraje = cilindraje;
        this.tiempos = tiempos;
        this.placa = placa;
    }
    public Moto(String cilindraje, String tiempos, String placa, String fotografia) {
        this.cilindraje = cilindraje;
        this.tiempos = tiempos;
        this.placa = placa;
        this.fotografia = fotografia;
    }

    public Integer getIdmoto() {
        return idmoto;
    }

    public void setIdmoto(Integer idmoto) {
        this.idmoto = idmoto;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTiempos() {
        return tiempos;
    }

    public void setTiempos(String tiempos) {
        this.tiempos = tiempos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmoto != null ? idmoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moto)) {
            return false;
        }
        Moto other = (Moto) object;
        if ((this.idmoto == null && other.idmoto != null) || (this.idmoto != null && !this.idmoto.equals(other.idmoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaparqueadero.entity.Moto[ idmoto=" + idmoto + " ]";
    }
    
}
