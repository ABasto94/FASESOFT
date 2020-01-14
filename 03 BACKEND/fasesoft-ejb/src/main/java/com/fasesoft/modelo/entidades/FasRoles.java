package com.fasesoft.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import uk.co.jemos.podam.annotations.PodamExclude;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name = "FAS_ROLES")
@NamedQuery(name = "FasRoles.findAll", query = "SELECT p FROM FasRoles p")
public class FasRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_ROLES_PK = "idRol";
	public static final String ENTIDAD_FAS_ROLES_FAS_PERFILES_ID_PERFIL = "fasPerfilesIdPerfil";
	public static final String ENTIDAD_FAS_ROLES_FAS_USUARIOS_ID_USUARIO = "fasUsuariosIdUsuario";
	private static final String[] ATRIBUTOS_ENTIDAD_FAS_ROLES = { ENTIDAD_FAS_ROLES_PK,
			ENTIDAD_FAS_ROLES_FAS_PERFILES_ID_PERFIL, ENTIDAD_FAS_ROLES_FAS_USUARIOS_ID_USUARIO };

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ")
	@SequenceGenerator(name = "ROLES_SEQ", sequenceName = "SQ_FAS_ROLES", allocationSize = 1)
	@Column(name = "ID_ROL")
	private Integer idRol;

	@PodamExclude
	@Column(name = "FAS_PERFILES_ID_PERFIL")
	private BigDecimal fasPerfilesIdPerfil;

	@PodamExclude
	@Column(name = "FAS_USUARIOS_ID_USUARIO")
	private BigDecimal fasUsuariosIdUsuario;

	@ManyToOne
	@JoinColumn(name = "FAS_PERFILES_ID_PERFIL", referencedColumnName = "ID_PERFIL", insertable = false, updatable = false)
	@PodamExclude
	private FasPerfiles fasPerfilesfasRolesFasPerfilesFk;

	@ManyToOne
	@JoinColumn(name = "FAS_USUARIOS_ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
	@PodamExclude
	private FasUsuarios fasUsuariosfasRolesFasUsuariosFk;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasRoles() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {

		this.idRol = idRol;
	}

	public BigDecimal getFasPerfilesIdPerfil() {
		return fasPerfilesIdPerfil;
	}

	public void setFasPerfilesIdPerfil(BigDecimal fasPerfilesIdPerfil) {

		this.fasPerfilesIdPerfil = fasPerfilesIdPerfil;
	}

	public BigDecimal getFasUsuariosIdUsuario() {
		return fasUsuariosIdUsuario;
	}

	public void setFasUsuariosIdUsuario(BigDecimal fasUsuariosIdUsuario) {

		this.fasUsuariosIdUsuario = fasUsuariosIdUsuario;
	}

	public FasPerfiles getFasPerfilesfasRolesFasPerfilesFk() {
		return fasPerfilesfasRolesFasPerfilesFk;
	}

	public void setFasPerfilesfasRolesFasPerfilesFk(FasPerfiles fasPerfilesfasRolesFasPerfilesFk) {
		this.fasPerfilesfasRolesFasPerfilesFk = fasPerfilesfasRolesFasPerfilesFk;
	}

	public FasUsuarios getFasUsuariosfasRolesFasUsuariosFk() {
		return fasUsuariosfasRolesFasUsuariosFk;
	}

	public void setFasUsuariosfasRolesFasUsuariosFk(FasUsuarios fasUsuariosfasRolesFasUsuariosFk) {
		this.fasUsuariosfasRolesFasUsuariosFk = fasUsuariosfasRolesFasUsuariosFk;
	}

	/**
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_FAS_ROLES) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
	}

	public static String[] getAtributosEntidadFasRoles() {
		return ATRIBUTOS_ENTIDAD_FAS_ROLES;
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
	 * Valida la igualdad de la instancia de la entidad FasRoles que se pasa como
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
		final FasRoles other = (FasRoles) obj;

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
