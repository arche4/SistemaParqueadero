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
@Table(name = "empleado_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoVehiculo.findAll", query = "SELECT e FROM EmpleadoVehiculo e")
    , @NamedQuery(name = "EmpleadoVehiculo.findByIdempleadoVehiculo", query = "SELECT e FROM EmpleadoVehiculo e WHERE e.idempleadoVehiculo = :idempleadoVehiculo")
    , @NamedQuery(name = "EmpleadoVehiculo.findByCedulaEmpleado", query = "SELECT e FROM EmpleadoVehiculo e WHERE e.cedulaEmpleado = :cedulaEmpleado")
    , @NamedQuery(name = "EmpleadoVehiculo.findByPlacaCodigoVehiculo", query = "SELECT e FROM EmpleadoVehiculo e WHERE e.placaCodigoVehiculo = :placaCodigoVehiculo")
    , @NamedQuery(name = "EmpleadoVehiculo.findByTipoVehiculo", query = "SELECT e FROM EmpleadoVehiculo e WHERE e.tipoVehiculo = :tipoVehiculo")})
public class EmpleadoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado_vehiculo")
    private Integer idempleadoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cedula_empleado")
    private String cedulaEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "placa_codigo_vehiculo")
    private String placaCodigoVehiculo;
    @Size(max = 45)
    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    public EmpleadoVehiculo() {
    }

    public EmpleadoVehiculo(Integer idempleadoVehiculo) {
        this.idempleadoVehiculo = idempleadoVehiculo;
    }

    public EmpleadoVehiculo(Integer idempleadoVehiculo, String cedulaEmpleado, String placaCodigoVehiculo) {
        this.idempleadoVehiculo = idempleadoVehiculo;
        this.cedulaEmpleado = cedulaEmpleado;
        this.placaCodigoVehiculo = placaCodigoVehiculo;
    }

    public Integer getIdempleadoVehiculo() {
        return idempleadoVehiculo;
    }

    public void setIdempleadoVehiculo(Integer idempleadoVehiculo) {
        this.idempleadoVehiculo = idempleadoVehiculo;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getPlacaCodigoVehiculo() {
        return placaCodigoVehiculo;
    }

    public void setPlacaCodigoVehiculo(String placaCodigoVehiculo) {
        this.placaCodigoVehiculo = placaCodigoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleadoVehiculo != null ? idempleadoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoVehiculo)) {
            return false;
        }
        EmpleadoVehiculo other = (EmpleadoVehiculo) object;
        if ((this.idempleadoVehiculo == null && other.idempleadoVehiculo != null) || (this.idempleadoVehiculo != null && !this.idempleadoVehiculo.equals(other.idempleadoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaparqueadero.entity.EmpleadoVehiculo[ idempleadoVehiculo=" + idempleadoVehiculo + " ]";
    }
    
}
