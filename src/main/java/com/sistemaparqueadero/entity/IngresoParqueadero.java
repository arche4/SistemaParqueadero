/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaparqueadero.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manue
 */
@Entity
@Table(name = "ingreso_parqueadero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoParqueadero.findAll", query = "SELECT i FROM IngresoParqueadero i")
    , @NamedQuery(name = "IngresoParqueadero.findByIdingresoParqueadero", query = "SELECT i FROM IngresoParqueadero i WHERE i.idingresoParqueadero = :idingresoParqueadero")
    , @NamedQuery(name = "IngresoParqueadero.findByCedulaEmpleado", query = "SELECT i FROM IngresoParqueadero i WHERE i.cedulaEmpleado = :cedulaEmpleado")
    , @NamedQuery(name = "IngresoParqueadero.findByPlacaVehiculo", query = "SELECT i FROM IngresoParqueadero i WHERE i.placaVehiculo = :placaVehiculo")
    , @NamedQuery(name = "IngresoParqueadero.findByFechaHoraEntrada", query = "SELECT i FROM IngresoParqueadero i WHERE i.fechaHoraEntrada = :fechaHoraEntrada")
    , @NamedQuery(name = "IngresoParqueadero.findByNumeroCelda", query = "SELECT i FROM IngresoParqueadero i WHERE i.numeroCelda = :numeroCelda")
    , @NamedQuery(name = "IngresoParqueadero.findByFechaHoraSalida", query = "SELECT i FROM IngresoParqueadero i WHERE i.fechaHoraSalida = :fechaHoraSalida")})
public class IngresoParqueadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idingreso_parqueadero")
    private Integer idingresoParqueadero;
    @Size(max = 45)
    @Column(name = "cedula_empleado")
    private String cedulaEmpleado;
    @Size(max = 45)
    @Column(name = "placa_vehiculo")
    private String placaVehiculo;
    @Column(name = "fecha_hora_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEntrada;
    @Size(max = 45)
    @Column(name = "numero_celda")
    private String numeroCelda;
    @Column(name = "fecha_hora_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraSalida;

    public IngresoParqueadero() {
    }

    public IngresoParqueadero(Integer idingresoParqueadero) {
        this.idingresoParqueadero = idingresoParqueadero;
    }

    public Integer getIdingresoParqueadero() {
        return idingresoParqueadero;
    }

    public void setIdingresoParqueadero(Integer idingresoParqueadero) {
        this.idingresoParqueadero = idingresoParqueadero;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public Date getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(Date fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public String getNumeroCelda() {
        return numeroCelda;
    }

    public void setNumeroCelda(String numeroCelda) {
        this.numeroCelda = numeroCelda;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idingresoParqueadero != null ? idingresoParqueadero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoParqueadero)) {
            return false;
        }
        IngresoParqueadero other = (IngresoParqueadero) object;
        if ((this.idingresoParqueadero == null && other.idingresoParqueadero != null) || (this.idingresoParqueadero != null && !this.idingresoParqueadero.equals(other.idingresoParqueadero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaparqueadero.entity.IngresoParqueadero[ idingresoParqueadero=" + idingresoParqueadero + " ]";
    }
    
}
