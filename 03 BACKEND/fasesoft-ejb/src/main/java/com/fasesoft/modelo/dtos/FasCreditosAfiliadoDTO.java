package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FasCreditosAfiliadoDTO implements Serializable {
	
	private BigDecimal identificacion;
	private String nombre;
	
	private Date fechaSolicitud; // no existe
	private String tipoCredito;
	private BigDecimal cuota; //no existe
	private BigDecimal tasaReal;
	private BigDecimal idCredito;
	private BigDecimal montoFijo;
	private BigDecimal deuda; //Donde esta?
	private String estado;
	private BigDecimal monto;
	
	
	

	public FasCreditosAfiliadoDTO() {
		super();
	}
	public FasCreditosAfiliadoDTO(BigDecimal identificacion, String nombre, String tipoCredito, 
			BigDecimal cuota, String estado, Date fechaSolicitud, BigDecimal idCredito,  
			BigDecimal monto, BigDecimal tasaReal, 
			BigDecimal montoFijo, BigDecimal deuda) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.fechaSolicitud = fechaSolicitud;
		this.tipoCredito = tipoCredito;
		this.cuota = cuota;
		this.tasaReal = tasaReal;
		this.idCredito = idCredito;
		this.montoFijo = montoFijo;
		this.estado = estado;
		this.monto = monto;
		this.deuda = deuda;
	}
	@XmlElement(name="identificacion")
	public BigDecimal getIdentificacion() {
		return identificacion;
	}
	@XmlElement(name="identificacion")
	public void setIdentificacion(BigDecimal identificacion) {
		this.identificacion = identificacion;
	}
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	@XmlElement(name="nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name="fechaSolicitud")
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	@XmlElement(name="fechaSolicitud")
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	@XmlElement(name="tipoCredito")
	public String getTipoCredito() {
		return tipoCredito;
	}
	@XmlElement(name="tipoCredito")
	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
	@XmlElement(name="cuota")
	public BigDecimal getCuota() {
		return cuota;
	}
	@XmlElement(name="cuota")
	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}
	@XmlElement(name="tasaReal")
	public BigDecimal getTasaReal() {
		return tasaReal;
	}
	@XmlElement(name="tasaReal")
	public void setTasaReal(BigDecimal tasaReal) {
		this.tasaReal = tasaReal;
	}
	@XmlElement(name="idCredito")
	public BigDecimal getIdCredito() {
		return idCredito;
	}
	@XmlElement(name="idCredito")
	public void setIdCredito(BigDecimal idCredito) {
		this.idCredito = idCredito;
	}
	@XmlElement(name="montoFijo")
	public BigDecimal getMontoFijo() {
		return montoFijo;
	}
	@XmlElement(name="montoFijo")
	public void setMontoFijo(BigDecimal montoFijo) {
		this.montoFijo = montoFijo;
	}
	@XmlElement(name="deuda")
	public BigDecimal getDeuda() {
		return deuda;
	}
	@XmlElement(name="deuda")
	public void setDeuda(BigDecimal deuda) {
		this.deuda = deuda;
	}
	@XmlElement(name="estado")
	public String getEstado() {
		return estado;
	}
	@XmlElement(name="estado")
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@XmlElement(name="monto")
	public BigDecimal getMonto() {
		return monto;
	}
	@XmlElement(name="monto")
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(identificacion, cuota, deuda, estado, fechaSolicitud, idCredito, monto, montoFijo, nombre, tasaReal,
				tipoCredito);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FasCreditosAfiliadoDTO)) {
			return false;
		}
		FasCreditosAfiliadoDTO other = (FasCreditosAfiliadoDTO) obj;
		return Objects.equals(identificacion, other.identificacion) && Objects.equals(cuota, other.cuota)
				&& Objects.equals(deuda, other.deuda) && Objects.equals(estado, other.estado)
				&& Objects.equals(fechaSolicitud, other.fechaSolicitud) && Objects.equals(idCredito, other.idCredito)
				&& Objects.equals(monto, other.monto) && Objects.equals(montoFijo, other.montoFijo)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(tasaReal, other.tasaReal)
				&& Objects.equals(tipoCredito, other.tipoCredito);
	}
	
	
}
