package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FasDetalleUsuarioDTO implements Serializable {

	// Data FAS_Afiliados
	private String correo;

	private String nombre;

	private String apellido;

	private BigDecimal telefono;

	private String direccion;

	private BigDecimal identificacion;

	private String tipoId;

	private String cuentaBancaria;

	private String banco;

	private String expedicion;

	private String ciudad;

	private String dependencia;

	private String estadoCivil;

	private Date fechaIngreso;

	// Data FAS_Usuarios

	private Date fechaCracion;

	private String estado;

	// Data FAS_Ahorros

	private BigDecimal aporte;

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the telefono
	 */
	public BigDecimal getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the identificacion
	 */
	public BigDecimal getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(BigDecimal identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the tipoId
	 */
	public String getTipoId() {
		return tipoId;
	}

	/**
	 * @param tipoId the tipoId to set
	 */
	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	/**
	 * @return the cuentaBancaria
	 */
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	/**
	 * @param cuentaBancaria the cuentaBancaria to set
	 */
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	/**
	 * @return the banco
	 */
	public String getBanco() {
		return banco;
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

	/**
	 * @return the expedicion
	 */
	public String getExpedicion() {
		return expedicion;
	}

	/**
	 * @param expedicion the expedicion to set
	 */
	public void setExpedicion(String expedicion) {
		this.expedicion = expedicion;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the dependencia
	 */
	public String getDependencia() {
		return dependencia;
	}

	/**
	 * @param dependencia the dependencia to set
	 */
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	/**
	 * @return the estadoCivil
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * @return the fechaIngreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the fechaCracion
	 */
	public Date getFechaCracion() {
		return fechaCracion;
	}

	/**
	 * @param fechaCracion the fechaCracion to set
	 */
	public void setFechaCracion(Date fechaCracion) {
		this.fechaCracion = fechaCracion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the aporte
	 */
	public BigDecimal getAporte() {
		return aporte;
	}

	/**
	 * @param aporte the aporte to set
	 */
	public void setAporte(BigDecimal aporte) {
		this.aporte = aporte;
	}

}
