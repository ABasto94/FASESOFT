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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import uk.co.jemos.podam.annotations.PodamExclude;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name = "FAS_PERMISOS")
@NamedQueries({ @NamedQuery(name = "FasPermisos.findAll", query = "SELECT p FROM FasPermisos p") })

public class FasPermisos implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_PERMISOS_PK = "idPermiso";
	public static final String ENTIDAD_FAS_PERMISOS_FAS_PERFILES_ID_PERFIL = "fasPerfilesIdPerfil";
	public static final String ENTIDAD_FAS_PERMISOS_FAS_ACCESOS_ID_ACCESO = "fasAccesosIdAcceso";
	private static final String[] ATRIBUTOS_ENTIDAD_FAS_PERMISOS = { ENTIDAD_FAS_PERMISOS_PK,
			ENTIDAD_FAS_PERMISOS_FAS_PERFILES_ID_PERFIL, ENTIDAD_FAS_PERMISOS_FAS_ACCESOS_ID_ACCESO };

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISOS_SEQ")
	@SequenceGenerator(name = "PERMISOS_SEQ", sequenceName = "SQ_FAS_PERMISOS", allocationSize = 1)
	@Column(name = "ID_PERMISO")
	private Integer idPermiso;

	@PodamExclude
	@Column(name = "FAS_PERFILES_ID_PERFIL")
	private BigDecimal fasPerfilesIdPerfil;

	@PodamExclude
	@Column(name = "FAS_ACCESOS_ID_ACCESO")
	private BigDecimal fasAccesosIdAcceso;

	@ManyToOne
	@JoinColumn(name = "FAS_ACCESOS_ID_ACCESO", referencedColumnName = "ID_ACCESO", insertable = false, updatable = false)
	@PodamExclude
	private FasAccesos fasAccesosfasPermisosFasAccesosFk;

	@ManyToOne
	@JoinColumn(name = "FAS_PERFILES_ID_PERFIL", referencedColumnName = "ID_PERFIL", insertable = false, updatable = false)
	@PodamExclude
	private FasPerfiles fasPerfilesfasPermisosFasPerfilesFk;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasPermisos() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {

		this.idPermiso = idPermiso;
	}

	public BigDecimal getFasPerfilesIdPerfil() {
		return fasPerfilesIdPerfil;
	}

	public void setFasPerfilesIdPerfil(BigDecimal fasPerfilesIdPerfil) {

		this.fasPerfilesIdPerfil = fasPerfilesIdPerfil;
	}

	public BigDecimal getFasAccesosIdAcceso() {
		return fasAccesosIdAcceso;
	}

	public void setFasAccesosIdAcceso(BigDecimal fasAccesosIdAcceso) {

		this.fasAccesosIdAcceso = fasAccesosIdAcceso;
	}

	public FasAccesos getFasAccesosfasPermisosFasAccesosFk() {
		return fasAccesosfasPermisosFasAccesosFk;
	}

	public void setFasAccesosfasPermisosFasAccesosFk(FasAccesos fasAccesosfasPermisosFasAccesosFk) {
		this.fasAccesosfasPermisosFasAccesosFk = fasAccesosfasPermisosFasAccesosFk;
	}

	public FasPerfiles getFasPerfilesfasPermisosFasPerfilesFk() {
		return fasPerfilesfasPermisosFasPerfilesFk;
	}

	public void setFasPerfilesfasPermisosFasPerfilesFk(FasPerfiles fasPerfilesfasPermisosFasPerfilesFk) {
		this.fasPerfilesfasPermisosFasPerfilesFk = fasPerfilesfasPermisosFasPerfilesFk;
	}

	/**
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_FAS_PERMISOS) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
	}

	public static String[] getAtributosEntidadFasPermisos() {
		return ATRIBUTOS_ENTIDAD_FAS_PERMISOS;
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
	 * Valida la igualdad de la instancia de la entidad FasPermisos que se pasa como
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
		final FasPermisos other = (FasPermisos) obj;

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
