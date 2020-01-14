package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DAO que contiene la información de la entidad FasCreditosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasCreditosDTO implements Serializable {

	private Integer idCredito;

	private BigDecimal tasaReal;

	private BigDecimal monto;

	private BigDecimal saldo;

	private Date fechaInicio;

	private String estado;

	private String fasAfiliadosCorreo;

	private BigDecimal fasTiposDeCreditoIdTipo;

	private BigDecimal numeroCuotas;

	private Date fechaSolicitud;

	private BigDecimal mora;

	private Date fechaDesembolso;

	private Date fechaInicioPago;

	private BigDecimal cuotasPendientes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasCreditosDTO() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	@XmlElement(name = "idCredito")
	public Integer getIdCredito() {
		return idCredito;
	}

	@XmlElement(name = "idCredito")
	public void setIdCredito(Integer idCredito) {
		this.idCredito = idCredito;
	}

	@XmlElement(name = "tasaReal")
	public BigDecimal getTasaReal() {
		return tasaReal;
	}

	@XmlElement(name = "tasaReal")
	public void setTasaReal(BigDecimal tasaReal) {
		this.tasaReal = tasaReal;
	}

	@XmlElement(name = "monto")
	public BigDecimal getMonto() {
		return monto;
	}

	@XmlElement(name = "monto")
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	@XmlElement(name = "saldo")
	public BigDecimal getSaldo() {
		return saldo;
	}

	@XmlElement(name = "saldo")
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@XmlElement(name = "fechaInicio")
	public Date getFechaInicio() {
		return fechaInicio;
	}

	@XmlElement(name = "fechaInicio")
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@XmlElement(name = "estado")
	public String getEstado() {
		return estado;
	}

	@XmlElement(name = "estado")
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@XmlElement(name = "fasAfiliadosCorreo")
	public String getFasAfiliadosCorreo() {
		return fasAfiliadosCorreo;
	}

	@XmlElement(name = "fasAfiliadosCorreo")
	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo) {
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}

	@XmlElement(name = "fasTiposDeCreditoIdTipo")
	public BigDecimal getFasTiposDeCreditoIdTipo() {
		return fasTiposDeCreditoIdTipo;
	}

	@XmlElement(name = "fasTiposDeCreditoIdTipo")
	public void setFasTiposDeCreditoIdTipo(BigDecimal fasTiposDeCreditoIdTipo) {
		this.fasTiposDeCreditoIdTipo = fasTiposDeCreditoIdTipo;
	}

	@XmlElement(name = "numeroCuotas")
	public BigDecimal getNumeroCuotas() {
		return numeroCuotas;
	}

	@XmlElement(name = "numeroCuotas")
	public void setNumeroCuotas(BigDecimal numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	@XmlElement(name = "fechaSolicitud")
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	@XmlElement(name = "fechaSolicitud")
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@XmlElement(name = "mora")
	public BigDecimal getMora() {
		return mora;
	}

	@XmlElement(name = "mora")
	public void setMora(BigDecimal mora) {
		this.mora = mora;
	}

	@XmlElement(name = "fechaDesembolso")
	public Date getFechaDesembolso() {
		return fechaDesembolso;
	}

	@XmlElement(name = "fechaDesembolso")
	public void setFechaDesembolso(Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	@XmlElement(name = "fechaInicioPago")
	public Date getFechaInicioPago() {
		return fechaInicioPago;
	}

	@XmlElement(name = "fechaInicioPago")
	public void setFechaInicioPago(Date fechaInicioPago) {
		this.fechaInicioPago = fechaInicioPago;
	}

	@XmlElement(name = "cuotasPendientes")
	public BigDecimal getCuotasPendientes() {
		return cuotasPendientes;
	}

	@XmlElement(name = "cuotasPendientes")
	public void setCuotasPendientes(BigDecimal cuotasPendientes) {
		this.cuotasPendientes = cuotasPendientes;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(idCredito);
		hash = 37 * hash + Objects.hashCode(tasaReal);
		hash = 37 * hash + Objects.hashCode(monto);
		hash = 37 * hash + Objects.hashCode(saldo);
		hash = 37 * hash + Objects.hashCode(fechaInicio);
		hash = 37 * hash + Objects.hashCode(estado);
		hash = 37 * hash + Objects.hashCode(fasAfiliadosCorreo);
		hash = 37 * hash + Objects.hashCode(fasTiposDeCreditoIdTipo);
		hash = 37 * hash + Objects.hashCode(numeroCuotas);
		hash = 37 * hash + Objects.hashCode(fechaSolicitud);
		hash = 37 * hash + Objects.hashCode(mora);
		hash = 37 * hash + Objects.hashCode(fechaDesembolso);
		hash = 37 * hash + Objects.hashCode(fechaInicioPago);
		hash = 37 * hash + Objects.hashCode(cuotasPendientes);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasCreditosDTO que se pasa
	 * como parámetro comprobando que comparten los mismos valores en cada uno de
	 * sus atributos. Solo se tienen en cuenta los atributos simples, es decir, se
	 * omiten aquellos que definen una relación con otra tabla.
	 *
	 * @param obj Instancia de la categoría a comprobar iguales.
	 * @return Verdadero si esta instancia y la que se pasan como parámetros son
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final FasCreditosDTO other = (FasCreditosDTO) obj;

		if (!Objects.equals(idCredito, other.idCredito))
			return false;

		if (!Objects.equals(tasaReal, other.tasaReal))
			return false;

		if (!Objects.equals(monto, other.monto))
			return false;

		if (!Objects.equals(saldo, other.saldo))
			return false;

		if (!Objects.equals(fechaInicio, other.fechaInicio))
			return false;

		if (!Objects.equals(estado, other.estado))
			return false;

		if (!Objects.equals(fasAfiliadosCorreo, other.fasAfiliadosCorreo))
			return false;

		if (!Objects.equals(fasTiposDeCreditoIdTipo, other.fasTiposDeCreditoIdTipo))
			return false;

		if (!Objects.equals(numeroCuotas, other.numeroCuotas))
			return false;

		if (!Objects.equals(fechaSolicitud, other.fechaSolicitud))
			return false;

		if (!Objects.equals(mora, other.mora))
			return false;

		if (!Objects.equals(fechaDesembolso, other.fechaDesembolso))
			return false;

		if (!Objects.equals(fechaInicioPago, other.fechaInicioPago))
			return false;

		return Objects.equals(cuotasPendientes, other.cuotasPendientes);

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
