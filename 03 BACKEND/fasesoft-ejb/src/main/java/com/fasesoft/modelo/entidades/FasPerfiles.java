package com.fasesoft.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import uk.co.jemos.podam.annotations.PodamExclude;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name = "FAS_PERFILES")
@NamedQueries({ @NamedQuery(name = "FasPerfiles.findAll", query = "SELECT p FROM FasPerfiles p"),
		@NamedQuery(name = "FasPerfiles.perfilesPorUsuario", query = "SELECT p FROM FasPerfiles p LEFT JOIN p.fasRolesFasPerfilesFkes r LEFT JOIN r.fasUsuariosfasRolesFasUsuariosFk u WHERE u.fasAfiliadosCorreo = :correo") })

public class FasPerfiles implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_PERFILES_PK = "idPerfil";
	public static final String ENTIDAD_FAS_PERFILES_TIPO = "tipo";
	private static final String[] ATRIBUTOS_ENTIDAD_FAS_PERFILES = { ENTIDAD_FAS_PERFILES_PK,
			ENTIDAD_FAS_PERFILES_TIPO };

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERFILES_SEQ")
	@SequenceGenerator(name = "PERFILES_SEQ", sequenceName = "SQ_FAS_PERFILES", allocationSize = 1)
	@Column(name = "ID_PERFIL")
	private Integer idPerfil;

	@Column(name = "TIPO")
	@Size(min = 0, max = 20)
	private String tipo;

	@OneToMany(mappedBy = "fasPerfilesfasPermisosFasPerfilesFk")
	@PodamExclude
	private List<FasPermisos> fasPermisosFasPerfilesFkes;
	@OneToMany(mappedBy = "fasPerfilesfasRolesFasPerfilesFk")
	@PodamExclude
	private List<FasRoles> fasRolesFasPerfilesFkes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasPerfiles() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {

		this.idPerfil = idPerfil;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {

		this.tipo = tipo;
	}

	public List<FasPermisos> getFasPermisosFasPerfilesFkesList() {
		return fasPermisosFasPerfilesFkes;
	}

	public void setFasPermisosFasPerfilesFkesList(List<FasPermisos> fasPermisosFasPerfilesFkes) {
		this.fasPermisosFasPerfilesFkes = fasPermisosFasPerfilesFkes;
	}

	public List<FasRoles> getFasRolesFasPerfilesFkesList() {
		return fasRolesFasPerfilesFkes;
	}

	public void setFasRolesFasPerfilesFkesList(List<FasRoles> fasRolesFasPerfilesFkes) {
		this.fasRolesFasPerfilesFkes = fasRolesFasPerfilesFkes;
	}

	/**
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_FAS_PERFILES) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
	}

	public static String[] getAtributosEntidadFasPerfiles() {
		return ATRIBUTOS_ENTIDAD_FAS_PERFILES;
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
	 * Valida la igualdad de la instancia de la entidad FasPerfiles que se pasa como
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
		final FasPerfiles other = (FasPerfiles) obj;

		if (!Objects.equals(idPerfil, other.idPerfil))
			return false;

		return true;

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
