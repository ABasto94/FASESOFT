package com.fasesoft.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

import uk.co.jemos.podam.annotations.PodamExclude;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name = "FAS_USUARIOS")
@NamedQueries({ 
	@NamedQuery(name = "FasUsuarios.findAll", query = "SELECT p FROM FasUsuarios p"),
	@NamedQuery(name = "FasUsuarios.findUsuarioAfiliado", query = "SELECT p FROM FasUsuarios p WHERE p.fasAfiliadosCorreo = :paramCorreo") })
public class FasUsuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_USUARIOS_PK = "idUsuario";
	public static final String ENTIDAD_FAS_USUARIOS_CONTRASENA = "contraseña";
	public static final String ENTIDAD_FAS_USUARIOS_ESTADO = "estado";
	public static final String ENTIDAD_FAS_USUARIOS_FECHA_CRACION = "fechaCracion";
	public static final String ENTIDAD_FAS_USUARIOS_FAS_AFILIADOS_CORREO = "fasAfiliadosCorreo";
	public static final String ENTIDAD_FAS_USUARIOS_MOT_RECHAZO ="motRechazo";
	private static final String[] ATRIBUTOS_ENTIDAD_FAS_USUARIOS = { ENTIDAD_FAS_USUARIOS_PK,
			ENTIDAD_FAS_USUARIOS_FAS_AFILIADOS_CORREO, ENTIDAD_FAS_USUARIOS_CONTRASENA, ENTIDAD_FAS_USUARIOS_ESTADO,
			ENTIDAD_FAS_USUARIOS_FECHA_CRACION, ENTIDAD_FAS_USUARIOS_MOT_RECHAZO };

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "SEQ_AFI_USU", allocationSize = 1)
	@Column(name = "ID_USUARIO")
	private Integer idUsuario;

	@Column(name = "CONTRASEÑA")
	@Size(min = 0, max = 30)
	private String contrasena;

	@Column(name = "ESTADO")
	@Size(min = 0, max = 10)
	private String estado;

	@Column(name = "FECHA_CRACION")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaCracion;

	@PodamExclude
	@Column(name = "FAS_AFILIADOS_CORREO")
	@Size(min = 0, max = 40)
	private String fasAfiliadosCorreo;
	
	@Column(name = "MOT_RECHAZO")
	@Size(min=0, max =4000)
	private String motRechazo;

	@ManyToOne
	@JoinColumn(name = "FAS_AFILIADOS_CORREO", referencedColumnName = "CORREO", insertable = false, updatable = false)
	@PodamExclude
	private FasAfiliados fasAfiliadosfasUsuariosFasAfiliadosFk;

	@OneToMany(mappedBy = "fasUsuariosfasRolesFasUsuariosFk")
	@PodamExclude
	private List<FasRoles> fasRolesFasUsuariosFkes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasUsuarios() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {

		this.idUsuario = idUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {

		this.contrasena = contrasena;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {

		this.estado = estado;
	}

	public Date getFechaCracion() {
		return fechaCracion;
	}

	public void setFechaCracion(Date fechaCracion) {

		this.fechaCracion = fechaCracion;
	}

	public String getFasAfiliadosCorreo() {
		return fasAfiliadosCorreo;
	}

	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo) {

		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}
	
	public void setMotRechazo(String motRechazo ) {
		this.motRechazo = motRechazo;
	}
	
	public String getMotRechazo() {
		return motRechazo;
	}

	public List<FasRoles> getFasRolesFasUsuariosFkesList() {
		return fasRolesFasUsuariosFkes;
	}

	public void setFasRolesFasUsuariosFkesList(List<FasRoles> fasRolesFasUsuariosFkes) {
		this.fasRolesFasUsuariosFkes = fasRolesFasUsuariosFkes;
	}

	public FasAfiliados getFasAfiliadosfasUsuariosFasAfiliadosFk() {
		return fasAfiliadosfasUsuariosFasAfiliadosFk;
	}

	public void setFasAfiliadosfasUsuariosFasAfiliadosFk(FasAfiliados fasAfiliadosfasUsuariosFasAfiliadosFk) {
		this.fasAfiliadosfasUsuariosFasAfiliadosFk = fasAfiliadosfasUsuariosFasAfiliadosFk;
	}
	

	/**
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_FAS_USUARIOS) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
	}

	public static String[] getAtributosEntidadFasUsuarios() {
		return ATRIBUTOS_ENTIDAD_FAS_USUARIOS;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(idUsuario);
		hash = 37 * hash + Objects.hashCode(contrasena);
		hash = 37 * hash + Objects.hashCode(estado);
		hash = 37 * hash + Objects.hashCode(fechaCracion);
		hash = 37 * hash + Objects.hashCode(fasAfiliadosCorreo);
		hash = 37 * hash + Objects.hashCode(motRechazo);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasUsuarios que se pasa como
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
		final FasUsuarios other = (FasUsuarios) obj;

		if (!Objects.equals(idUsuario, other.idUsuario))
			return false;

		if (!Objects.equals(contrasena, other.contrasena))
			return false;

		if (!Objects.equals(estado, other.estado))
			return false;

		if (!Objects.equals(fechaCracion, other.fechaCracion))
			return false;
		
		if (!Objects.equals(motRechazo, other.motRechazo))
			return false;

		return Objects.equals(fasAfiliadosCorreo, other.fasAfiliadosCorreo);
		
	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
