package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DAO que contiene la información de la entidad FasPermisosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasPermisosDTO implements Serializable {

	private Integer idPermiso;

	private BigDecimal fasPerfilesIdPerfil;

	private BigDecimal fasAccesosIdAcceso;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasPermisosDTO() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	@XmlElement(name = "idPermiso")
	public Integer getIdPermiso() {
		return idPermiso;
	}

	@XmlElement(name = "idPermiso")
	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	@XmlElement(name = "fasPerfilesIdPerfil")
	public BigDecimal getFasPerfilesIdPerfil() {
		return fasPerfilesIdPerfil;
	}

	@XmlElement(name = "fasPerfilesIdPerfil")
	public void setFasPerfilesIdPerfil(BigDecimal fasPerfilesIdPerfil) {
		this.fasPerfilesIdPerfil = fasPerfilesIdPerfil;
	}

	@XmlElement(name = "fasAccesosIdAcceso")
	public BigDecimal getFasAccesosIdAcceso() {
		return fasAccesosIdAcceso;
	}

	@XmlElement(name = "fasAccesosIdAcceso")
	public void setFasAccesosIdAcceso(BigDecimal fasAccesosIdAcceso) {
		this.fasAccesosIdAcceso = fasAccesosIdAcceso;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(idPermiso);
		hash = 37 * hash + Objects.hashCode(fasPerfilesIdPerfil);
		hash = 37 * hash + Objects.hashCode(fasAccesosIdAcceso);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasPermisosDTO que se pasa
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
		final FasPermisosDTO other = (FasPermisosDTO) obj;

		if (!Objects.equals(idPermiso, other.idPermiso))
			return false;

		if (!Objects.equals(fasPerfilesIdPerfil, other.fasPerfilesIdPerfil))
			return false;

		return Objects.equals(fasAccesosIdAcceso, other.fasAccesosIdAcceso);

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
