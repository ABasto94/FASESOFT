package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DAO que contiene la informaciÃ³n de la entidad FasCreditosDTO que se
 * transmite por los servicios REST. Solo se transmiten los atributos simples,
 * es decir, se omiten aquellos atributos que definen relaciones con otras
 * entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasHistorialCreditosDTO implements Serializable {

	// Data FAS_TIPOS_DE_CREDITOS
	private String descripcion;

	private String tipo;

	// Data FAS_CREDITOS

	private Integer idCredito;

	private Float tasaReal;

	private Integer monto;

	private Integer saldo;

	private Integer cuotas;

	private Integer mora;

	private String estadoCredito;

	private Date fechaSolicitud;

	// Data FAS_AFILIADOS

	private String correo;

	private String nombre;

	private String apellido;

	private Integer telefono;

	private String direccion;

	private String tipoId;

	private Integer identificacion;

	private String estadoAfiliado;

	@Override
	public int hashCode() {
		return Objects.hash(apellido, correo, cuotas, descripcion, direccion, estadoAfiliado, estadoCredito,
				fechaSolicitud, idCredito, identificacion, monto, mora, nombre, saldo, tasaReal, telefono, tipo,
				tipoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof FasHistorialCreditosDTO))
			return false;
		FasHistorialCreditosDTO other = (FasHistorialCreditosDTO) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(correo, other.correo)
				&& Objects.equals(cuotas, other.cuotas) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(estadoAfiliado, other.estadoAfiliado)
				&& Objects.equals(estadoCredito, other.estadoCredito)
				&& Objects.equals(fechaSolicitud, other.fechaSolicitud) && Objects.equals(idCredito, other.idCredito)
				&& Objects.equals(identificacion, other.identificacion) && Objects.equals(monto, other.monto)
				&& Objects.equals(mora, other.mora) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(saldo, other.saldo) && Objects.equals(tasaReal, other.tasaReal)
				&& Objects.equals(telefono, other.telefono) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(tipoId, other.tipoId);
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the idCredito
	 */
	public Integer getIdCredito() {
		return idCredito;
	}

	/**
	 * @param idCredito the idCredito to set
	 */
	public void setIdCredito(Integer idCredito) {
		this.idCredito = idCredito;
	}

	/**
	 * @return the tasaReal
	 */
	public Float getTasaReal() {
		return tasaReal;
	}

	/**
	 * @param tasaReal the tasaReal to set
	 */
	public void setTasaReal(Float tasaReal) {
		this.tasaReal = tasaReal;
	}

	/**
	 * @return the monto
	 */
	public Integer getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	/**
	 * @return the saldo
	 */
	public Integer getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the cuotas
	 */
	public Integer getCuotas() {
		return cuotas;
	}

	/**
	 * @param cuotas the cuotas to set
	 */
	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}

	/**
	 * @return the mora
	 */
	public Integer getMora() {
		return mora;
	}

	/**
	 * @param mora the mora to set
	 */
	public void setMora(Integer mora) {
		this.mora = mora;
	}

	/**
	 * @return the estadoCredito
	 */
	public String getEstadoCredito() {
		return estadoCredito;
	}

	/**
	 * @param estadoCredito the estadoCredito to set
	 */
	public void setEstadoCredito(String estadoCredito) {
		this.estadoCredito = estadoCredito;
	}

	/**
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

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
	public Integer getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(Integer telefono) {
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
	 * @return the identificacion
	 */
	public Integer getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the estadoAfiliado
	 */
	public String getEstadoAfiliado() {
		return estadoAfiliado;
	}

	/**
	 * @param estadoAfiliado the estadoAfiliado to set
	 */
	public void setEstadoAfiliado(String estadoAfiliado) {
		this.estadoAfiliado = estadoAfiliado;
	}

	public FasHistorialCreditosDTO() {
		// protected region procedimientos adicionales de inicializaciÃ³n on begin
		// Escriba en esta secciÃ³n sus modificaciones

		// protected region procedimientos adicionales de inicializaciÃ³n end
	}

	// protected region metodos adicionales on begin
	// Escriba en esta secciÃ³n sus modificaciones

	// protected region metodos adicionales end

}
