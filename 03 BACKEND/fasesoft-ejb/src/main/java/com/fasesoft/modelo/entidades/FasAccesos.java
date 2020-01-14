package com.fasesoft.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import uk.co.jemos.podam.annotations.PodamExclude;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name = "FAS_ACCESOS")
@NamedQueries({ @NamedQuery(name = "FasAccesos.findAll", query = "SELECT p FROM FasAccesos p"),
		@NamedQuery(name = "FasAccesos.findAccesosByUser", query = "SELECT a FROM FasAccesos a LEFT JOIN a.fasPermisosFasAccesosFkes p LEFT JOIN p.fasPerfilesfasPermisosFasPerfilesFk pe LEFT JOIN pe.fasRolesFasPerfilesFkes r LEFT JOIN r.fasUsuariosfasRolesFasUsuariosFk us WHERE us.fasAfiliadosCorreo= :correo"),
		@NamedQuery(name = "FasAccesos.findAccesosByProfile", query = "SELECT a FROM FasAccesos a LEFT JOIN a.fasPermisosFasAccesosFkes p LEFT JOIN p.fasPerfilesfasPermisosFasPerfilesFk pe WHERE pe.tipo = :tipo") })
public class FasAccesos implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_ACCESOS_PK = "idAcceso";
	public static final String ENTIDAD_FAS_ACCESOS_NOMBRE = "nombre";
	public static final String ENTIDAD_FAS_ACCESOS_COMPONENTE = "componente";
	public static final String ENTIDAD_FAS_ACCESOS_DESCRIPCION = "descripcion";
	private static final String[] ATRIBUTOS_ENTIDAD_FAS_ACCESOS = { ENTIDAD_FAS_ACCESOS_NOMBRE, ENTIDAD_FAS_ACCESOS_PK,
			ENTIDAD_FAS_ACCESOS_COMPONENTE, ENTIDAD_FAS_ACCESOS_DESCRIPCION };

	@Id
	@Column(name = "ID_ACCESO")
	private BigDecimal idAcceso;

	@Column(name = "NOMBRE")
	@Size(min = 0, max = 20)
	private String nombre;

	@Column(name = "COMPONENTE")
	@Size(min = 0, max = 250)
	private String componente;

	@Column(name = "DESCRIPCION")
	@Size(min = 0, max = 250)
	private String descripcion;

	@OneToMany(mappedBy = "fasAccesosfasPermisosFasAccesosFk")
	@PodamExclude
	private List<FasPermisos> fasPermisosFasAccesosFkes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasAccesos() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	public BigDecimal getIdAcceso() {
		return idAcceso;
	}

	public void setIdAcceso(BigDecimal idAcceso) {

		this.idAcceso = idAcceso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {

		this.componente = componente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
	}

	public List<FasPermisos> getFasPermisosFasAccesosFkesList() {
		return fasPermisosFasAccesosFkes;
	}

	public void setFasPermisosFasAccesosFkesList(List<FasPermisos> fasPermisosFasAccesosFkes) {
		this.fasPermisosFasAccesosFkes = fasPermisosFasAccesosFkes;
	}

	/**
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_FAS_ACCESOS) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
	}

	public static String[] getAtributosEntidadFasAccesos() {
		return ATRIBUTOS_ENTIDAD_FAS_ACCESOS;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(idAcceso);
		hash = 37 * hash + Objects.hashCode(nombre);
		hash = 37 * hash + Objects.hashCode(componente);
		hash = 37 * hash + Objects.hashCode(descripcion);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasAccesos que se pasa como
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
		final FasAccesos other = (FasAccesos) obj;

		if (!Objects.equals(idAcceso, other.idAcceso))
			return false;

		if (!Objects.equals(nombre, other.nombre))
			return false;

		if (!Objects.equals(componente, other.componente))
			return false;

		return Objects.equals(descripcion, other.descripcion);

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
