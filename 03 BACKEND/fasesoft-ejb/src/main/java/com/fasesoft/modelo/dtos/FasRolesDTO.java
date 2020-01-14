package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DAO que contiene la información de la entidad FasRolesDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasRolesDTO implements Serializable {

	private Integer idRol;

	private BigDecimal fasPerfilesIdPerfil;

	private BigDecimal fasUsuariosIdUsuario;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasRolesDTO() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	@XmlElement(name = "idRol")
	public Integer getIdRol() {
		return idRol;
	}

	@XmlElement(name = "idRol")
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	@XmlElement(name = "fasPerfilesIdPerfil")
	public BigDecimal getFasPerfilesIdPerfil() {
		return fasPerfilesIdPerfil;
	}

	@XmlElement(name = "fasPerfilesIdPerfil")
	public void setFasPerfilesIdPerfil(BigDecimal fasPerfilesIdPerfil) {
		this.fasPerfilesIdPerfil = fasPerfilesIdPerfil;
	}

	@XmlElement(name = "fasUsuariosIdUsuario")
	public BigDecimal getFasUsuariosIdUsuario() {
		return fasUsuariosIdUsuario;
	}

	@XmlElement(name = "fasUsuariosIdUsuario")
	public void setFasUsuariosIdUsuario(BigDecimal fasUsuariosIdUsuario) {
		this.fasUsuariosIdUsuario = fasUsuariosIdUsuario;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(idRol);
		hash = 37 * hash + Objects.hashCode(fasPerfilesIdPerfil);
		hash = 37 * hash + Objects.hashCode(fasUsuariosIdUsuario);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasRolesDTO que se pasa como
	 * parámetro comprobando que comparten los mismos valores en cada uno de sus
	 * atributos. Solo se tienen en cuenta los atributos simples, es decir, se
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
		final FasRolesDTO other = (FasRolesDTO) obj;

		if (!Objects.equals(idRol, other.idRol))
			return false;

		if (!Objects.equals(fasPerfilesIdPerfil, other.fasPerfilesIdPerfil))
			return false;

		return Objects.equals(fasUsuariosIdUsuario, other.fasUsuariosIdUsuario);

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
