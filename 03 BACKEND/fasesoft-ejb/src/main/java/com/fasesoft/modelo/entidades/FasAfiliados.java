package com.fasesoft.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

import com.fasesoft.modelo.dtos.FasAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasAportesBeneficiosDTO;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;

import com.fasesoft.modelo.dtos.FasAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasCreditosAfiliadoDTO;
import com.fasesoft.modelo.dtos.FasSolicitudesAfiliacionDTO;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultaCreditos;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;

import com.fasesoft.modelo.dtos.FasAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasDesafilacionAhorrosDTO;
import com.fasesoft.modelo.dtos.FasDesafilacionCreditosDTO;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;

import uk.co.jemos.podam.annotations.PodamExclude;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name = "FAS_AFILIADOS")
@NamedQueries({ @NamedQuery(name = "FasAfiliados.findAll", query = "SELECT p FROM FasAfiliados p"),
		@NamedQuery(name = "FasAfiliados.findByCorreo", query = "SELECT p FROM FasAfiliados p WHERE p.correo = :paramCorreo"),
		@NamedQuery(name = "FasAfiliados.findUserInfoByCorreo", query = "SELECT p FROM FasAfiliados p WHERE p.correo = :paramCorreo"),
		@NamedQuery(name = "FasAfiliados.afiliadosUsuarios", query = "SELECT a FROM FasAfiliados a INNER JOIN a.fasUsuariosFasAfiliadosFkes b") })

@SqlResultSetMappings({
	
	@SqlResultSetMapping( 	name= ConstantesConsultas.RESULT_MAPPING_CONSULTAR_APORTE_BENEFICIO_PERMANENTE,
	classes = {
	 @ConstructorResult(targetClass = FasAportesBeneficiosDTO.class,
	 columns = { 
			 @ColumnResult(name="identificacion"),
			 @ColumnResult(name="aporte"),
			 @ColumnResult(name="beneficio"),
			 @ColumnResult(name="fecha_aporte")
			 })}),
	
	@SqlResultSetMapping(     name= ConstantesConsultas.RESULT_MAPPING_CONSULTA_RETIROS_FECHAS,
		classes = {
	 	@ConstructorResult(targetClass = FasAfiliadosDTO.class,
	 	columns = { 
	         @ColumnResult(name="nombre"),
	         @ColumnResult(name="correo"),
	         @ColumnResult(name="fecha_retiro")
	         })}),
		
	@SqlResultSetMapping(name= ConstantesConsultas.RESULT_MAPPING_USUARIOS_ARES,
		classes = {
		 @ConstructorResult(targetClass = FasAfiliadosDTO.class,
		 columns = {
		         @ColumnResult(name="correo"),   
		         @ColumnResult(name="nombre"),
		         @ColumnResult(name="apellido"),
		         @ColumnResult(name="telefono", type = BigDecimal.class), 
		         @ColumnResult(name="direccion", type = String.class),  
		         @ColumnResult(name="identificacion"),
		         @ColumnResult(name="tipoId"),
		         @ColumnResult(name="fechaRetiro", type=Date.class),   
		         @ColumnResult(name="fechaIngreso", type=Date.class),
		         @ColumnResult(name="cuentaBancaria"),
		         @ColumnResult(name="totalOtrosAhorros",type=BigDecimal.class),
		         @ColumnResult(name="banco",type=String.class),
		         @ColumnResult(name="expedicion",type=String.class),
		         @ColumnResult(name="ciudad",type=String.class),
		         @ColumnResult(name="dependencia",type=String.class),
		         @ColumnResult(name="estadoCivil",type=String.class)
		         })}),
	@SqlResultSetMapping(name= ConstantesConsultas.RESULT_MAPPING_CONSULTA_DEUDA_AHORROS,
		classes = {
	 	@ConstructorResult(targetClass = FasDesafilacionAhorrosDTO.class,
	 	columns = { 
	         @ColumnResult(name="monto"),
	         @ColumnResult(name="fas_afiliados_correo"),
	         @ColumnResult(name="tipo")
	         })}),
	@SqlResultSetMapping(name= ConstantesConsultas.RESULT_MAPPING_CONSULTA_DEUDA_CREDITOS,
		classes = {
	 	@ConstructorResult(targetClass = FasDesafilacionCreditosDTO.class,
	 	columns = { 
	         @ColumnResult(name="saldo"),
	         @ColumnResult(name="tipo"),
	         @ColumnResult(name="estado"),
	         @ColumnResult(name= "fas_afiliados_correo")
			 })}),
			 
	@SqlResultSetMapping(name= ConstantesConsultas.RESULT_MAPPING_CONSULTA_SOLICITUDES_AFILIACION,
	 	classes = {
	 	@ConstructorResult(targetClass = FasSolicitudesAfiliacionDTO.class,
	 	columns = { 
	         @ColumnResult(name="correo",type=String.class),
	         @ColumnResult(name="nombres",type=String.class),
	         @ColumnResult(name="aporte",type=BigDecimal.class),
	         @ColumnResult(name="telefono",type=BigDecimal.class),
	         @ColumnResult(name="estado",type=String.class),
	         @ColumnResult(name="idUsuario",type=BigDecimal.class),
	         @ColumnResult(name="contraseña",type=String.class),
	         @ColumnResult(name="fechaCreacion",type=String.class),
	         })})
})
public class FasAfiliados implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_AFILIADOS_PK = "correo";
	public static final String ENTIDAD_FAS_AFILIADOS_NOMBRE = "nombre";
	public static final String ENTIDAD_FAS_AFILIADOS_APELLIDO = "apellido";
	public static final String ENTIDAD_FAS_AFILIADOS_TELEFONO = "telefono";
	public static final String ENTIDAD_FAS_AFILIADOS_DIRECCION = "direccion";
	public static final String ENTIDAD_FAS_AFILIADOS_IDENTIFICACION = "identificacion";
	public static final String ENTIDAD_FAS_AFILIADOS_TIPO_ID = "tipoId";
	public static final String ENTIDAD_FAS_AFILIADOS_FECHA_RETIRO = "fechaRetiro";
	public static final String ENTIDAD_FAS_AFILIADOS_FECHA_INGRESO = "fechaIngreso";
	public static final String ENTIDAD_FAS_AFILIADOS_CUENTA_BANCARIA = "cuentaBancaria";
	public static final String ENTIDAD_FAS_AFILIADOS_TOTAL_OTROS_AHORROS = "totalOtrosAhorros";
	public static final String ENTIDAD_FAS_AFILIADOS_BANCO = "banco";

	public static final String ENTIDAD_FAS_AFILIADOS_EXPEDICION = "expedicion";
	public static final String ENTIDAD_FAS_AFILIADOS_CUIDAD = "cuidad";
	public static final String ENTIDAD_FAS_AFILIADOS_DEPENDENCIA = "dependencia";
	public static final String ENTIDAD_FAS_AFILIADOS_ESTADO_CIVIL = "estadoCivil";

	private static final String[] ATRIBUTOS_ENTIDAD_FAS_AFILIADOS = { ENTIDAD_FAS_AFILIADOS_APELLIDO,
			ENTIDAD_FAS_AFILIADOS_PK, ENTIDAD_FAS_AFILIADOS_TIPO_ID, ENTIDAD_FAS_AFILIADOS_IDENTIFICACION,
			ENTIDAD_FAS_AFILIADOS_FECHA_RETIRO, ENTIDAD_FAS_AFILIADOS_CUENTA_BANCARIA, ENTIDAD_FAS_AFILIADOS_TELEFONO,
			ENTIDAD_FAS_AFILIADOS_FECHA_INGRESO, ENTIDAD_FAS_AFILIADOS_TOTAL_OTROS_AHORROS,
			ENTIDAD_FAS_AFILIADOS_NOMBRE, ENTIDAD_FAS_AFILIADOS_DIRECCION, ENTIDAD_FAS_AFILIADOS_BANCO,
			ENTIDAD_FAS_AFILIADOS_EXPEDICION, ENTIDAD_FAS_AFILIADOS_CUIDAD, ENTIDAD_FAS_AFILIADOS_DEPENDENCIA,
			ENTIDAD_FAS_AFILIADOS_ESTADO_CIVIL };

	@Id
	@Column(name = "CORREO")
	@Size(min = 0, max = 40)
	private String correo;

	@Column(name = "NOMBRE")
	@Size(min = 0, max = 20)
	private String nombre;

	@Column(name = "APELLIDO")
	@Size(min = 0, max = 20)
	private String apellido;

	@Column(name = "TELEFONO")
	private BigDecimal telefono;

	@Column(name = "DIRECCION")
	@Size(min = 0, max = 30)
	private String direccion;

	@Column(name = "IDENTIFICACION")
	private BigDecimal identificacion;

	@Column(name = "TIPO_ID")
	@Size(min = 0, max = 4)
	private String tipoId;

	@Column(name = "FECHA_RETIRO")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaRetiro;

	@Column(name = "FECHA_INGRESO")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaIngreso;

	@Column(name = "CUENTA_BANCARIA")
	@Size(min = 0, max = 15)
	private String cuentaBancaria;

	@Column(name = "TOTAL_OTROS_AHORROS")
	private BigDecimal totalOtrosAhorros;

	@Column(name = "BANCO")
	@Size(min = 0, max = 15)
	private String banco;

	@Column(name = "EXPEDICION")
	@Size(min = 0, max = 15)
	private String expedicion;

	@Column(name = "CIUDAD")
	@Size(min = 0, max = 15)
	private String ciudad;

	@Column(name = "DEPENDENCIA")
	@Size(min = 0, max = 15)
	private String dependencia;

	@Column(name = "ESTADO_CIVIL")
	@Size(min = 0, max = 15)
	private String estadoCivil;

	@OneToMany(mappedBy = "fasAfiliadosfasAhorrosFasAfiliadosFk")
	@PodamExclude
	private List<FasAhorros> fasAhorrosFasAfiliadosFkes;
	@OneToMany(mappedBy = "fasAfiliadosfasCreditosFasAfiliadosFk")
	@PodamExclude
	private List<FasCreditos> fasCreditosFasAfiliadosFkes;
	@OneToMany(mappedBy = "fasAfiliadosfasExtractosFasAfiliadosFk")
	@PodamExclude
	private List<FasExtractos> fasExtractosFasAfiliadosFkes;
	@OneToMany(mappedBy = "fasAfiliadosfasSolConvFasAfiliFk")
	@PodamExclude
	private List<FasSolConvenios> fasSolConvFasAfiliFkes;
	@OneToMany(mappedBy = "fasAfiliadosfasUsuariosFasAfiliadosFk")
	@PodamExclude
	private List<FasUsuarios> fasUsuariosFasAfiliadosFkes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasAfiliados() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {

		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {

		this.apellido = apellido;
	}

	public BigDecimal getTelefono() {
		return telefono;
	}

	public void setTelefono(BigDecimal telefono) {

		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {

		this.direccion = direccion;
	}

	public BigDecimal getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(BigDecimal identificacion) {

		this.identificacion = identificacion;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {

		this.tipoId = tipoId;
	}

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {

		this.fechaRetiro = fechaRetiro;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {

		this.fechaIngreso = fechaIngreso;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {

		this.cuentaBancaria = cuentaBancaria;
	}

	public BigDecimal getTotalOtrosAhorros() {
		return totalOtrosAhorros;
	}

	public void setTotalOtrosAhorros(BigDecimal totalOtrosAhorros) {

		this.totalOtrosAhorros = totalOtrosAhorros;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {

		this.banco = banco;
	}

	public String getExpedicion() {
		return expedicion;
	}

	public void setExpedicion(String expedicion) {

		this.expedicion = expedicion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {

		this.ciudad = ciudad;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {

		this.dependencia = dependencia;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setExtadoCivil(String estadoCivil) {

		this.estadoCivil = estadoCivil;
	}

	public List<FasAhorros> getFasAhorrosFasAfiliadosFkesList() {
		return fasAhorrosFasAfiliadosFkes;
	}

	public void setFasAhorrosFasAfiliadosFkesList(List<FasAhorros> fasAhorrosFasAfiliadosFkes) {
		this.fasAhorrosFasAfiliadosFkes = fasAhorrosFasAfiliadosFkes;
	}

	public List<FasCreditos> getFasCreditosFasAfiliadosFkesList() {
		return fasCreditosFasAfiliadosFkes;
	}

	public void setFasCreditosFasAfiliadosFkesList(List<FasCreditos> fasCreditosFasAfiliadosFkes) {
		this.fasCreditosFasAfiliadosFkes = fasCreditosFasAfiliadosFkes;
	}

	public List<FasExtractos> getFasExtractosFasAfiliadosFkesList() {
		return fasExtractosFasAfiliadosFkes;
	}

	public void setFasExtractosFasAfiliadosFkesList(List<FasExtractos> fasExtractosFasAfiliadosFkes) {
		this.fasExtractosFasAfiliadosFkes = fasExtractosFasAfiliadosFkes;
	}

	public List<FasSolConvenios> getFasSolConvFasAfiliFkesList() {
		return fasSolConvFasAfiliFkes;
	}

	public void setFasSolConvFasAfiliFkesList(List<FasSolConvenios> fasSolConvFasAfiliFkes) {
		this.fasSolConvFasAfiliFkes = fasSolConvFasAfiliFkes;
	}

	public List<FasUsuarios> getFasUsuariosFasAfiliadosFkesList() {
		return fasUsuariosFasAfiliadosFkes;
	}

	public void setFasUsuariosFasAfiliadosFkesList(List<FasUsuarios> fasUsuariosFasAfiliadosFkes) {
		this.fasUsuariosFasAfiliadosFkes = fasUsuariosFasAfiliadosFkes;
	}

	/**
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_FAS_AFILIADOS) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
	}

	public static String[] getAtributosEntidadFasAfiliados() {
		return ATRIBUTOS_ENTIDAD_FAS_AFILIADOS;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(correo);
		hash = 37 * hash + Objects.hashCode(nombre);
		hash = 37 * hash + Objects.hashCode(apellido);
		hash = 37 * hash + Objects.hashCode(telefono);
		hash = 37 * hash + Objects.hashCode(direccion);
		hash = 37 * hash + Objects.hashCode(identificacion);
		hash = 37 * hash + Objects.hashCode(tipoId);
		hash = 37 * hash + Objects.hashCode(fechaRetiro);
		hash = 37 * hash + Objects.hashCode(fechaIngreso);
		hash = 37 * hash + Objects.hashCode(cuentaBancaria);
		hash = 37 * hash + Objects.hashCode(totalOtrosAhorros);
		hash = 37 * hash + Objects.hashCode(banco);
		hash = 37 * hash + Objects.hashCode(expedicion);
		hash = 37 * hash + Objects.hashCode(ciudad);
		hash = 37 * hash + Objects.hashCode(dependencia);
		hash = 37 * hash + Objects.hashCode(estadoCivil);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasAfiliados que se pasa
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
		final FasAfiliados other = (FasAfiliados) obj;

		if (!Objects.equals(correo, other.correo))
			return false;

		if (!Objects.equals(nombre, other.nombre))
			return false;

		if (!Objects.equals(apellido, other.apellido))
			return false;

		if (!Objects.equals(telefono, other.telefono))
			return false;

		if (!Objects.equals(direccion, other.direccion))
			return false;

		if (!Objects.equals(identificacion, other.identificacion))
			return false;

		if (!Objects.equals(tipoId, other.tipoId))
			return false;

		if (!Objects.equals(fechaRetiro, other.fechaRetiro))
			return false;

		if (!Objects.equals(fechaIngreso, other.fechaIngreso))
			return false;

		if (!Objects.equals(cuentaBancaria, other.cuentaBancaria))
			return false;

		if (!Objects.equals(banco, other.banco))
			return false;

		if (!Objects.equals(expedicion, other.expedicion))
			return false;

		if (!Objects.equals(ciudad, other.ciudad))
			return false;

		if (!Objects.equals(dependencia, other.dependencia))
			return false;

		if (!Objects.equals(estadoCivil, other.estadoCivil))
			return false;

		return Objects.equals(totalOtrosAhorros, other.totalOtrosAhorros);

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
