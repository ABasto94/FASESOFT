package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DAO que contiene la información de la entidad FasPerfilesDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasPerfilesDTO implements Serializable {

	private Integer idPerfil;

	private String tipo;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasPerfilesDTO() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	@XmlElement(name = "idPerfil")
	public Integer getIdPerfil() {
		return idPerfil;
	}

	@XmlElement(name = "idPerfil")
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	@XmlElement(name = "tipo")
	public String getTipo() {
		return tipo;
	}

	@XmlElement(name = "tipo")
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(idPerfil);
		hash = 37 * hash + Objects.hashCode(tipo);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasPerfilesDTO que se pasa
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
		final FasPerfilesDTO other = (FasPerfilesDTO) obj;

		return Objects.equals(idPerfil, other.idPerfil);

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
