package com.fasesoft.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.Size;

import com.fasesoft.modelo.dtos.FasConveniosTiposPagosDTO;
import com.fasesoft.modelo.dtos.FasCreditosPagosTipoDTO;
import com.fasesoft.modelo.dtos.FasDetallePagoDTO;
import com.fasesoft.modelo.dtos.FasExtAhorrosAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasExtAhorrosVoluntariosDTO;
import com.fasesoft.modelo.dtos.FasGeneracionExtractoDTO;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery; 
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

import uk.co.jemos.podam.annotations.PodamExclude;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name="FAS_EXTRACTOS")
@NamedQueries({
@NamedQuery(name = "FasExtractos.findAll", query = "SELECT p FROM FasExtractos p"),
@NamedQuery(name = "FasExtractos.porFecha", query = "SELECT p FROM FasExtractos p WHERE p.nombreExtracto=:paramNombre"),
@NamedQuery(name = "FasExtractos.findPorAfiliado", query = "SELECT p FROM FasExtractos p WHERE p.fasAfiliadosCorreo= :paramCorreo")
})


@SqlResultSetMappings({

	
	@SqlResultSetMapping( 	name= ConstantesConsultas.RESULTMAPPING_QUERY_CONSULTAR_PAGOS_CONVENIOS,
	classes = {
	 @ConstructorResult(targetClass = FasConveniosTiposPagosDTO.class,
	 columns = { 
			 @ColumnResult(name="fas_afiliados_correo"),    
			 @ColumnResult(name="id_convenio"),
			 @ColumnResult(name="monto_convenio"),
			 @ColumnResult(name="saldo_convenio"),    
			 @ColumnResult(name="fecha_desembolso_conv" ,type=Date.class),
			 @ColumnResult(name="fecha_de_pago", type=Date.class),
			 @ColumnResult(name="tasa_convenio"),
			 @ColumnResult(name="mora_convenio"),    
			 @ColumnResult(name="tipo_convenio"),
			 @ColumnResult(name="cuota_total")
			 })}),
	
	@SqlResultSetMapping( 	name= ConstantesConsultas.RESULT_MAPPING_CONSULTAR_PAGO_CREDITOS,
	classes = {
	 @ConstructorResult(targetClass = FasCreditosPagosTipoDTO.class,
	 columns = { 
			 @ColumnResult(name="tipo"),    
			 @ColumnResult(name="monto"),
			 @ColumnResult(name="cuota_total"),
			 @ColumnResult(name="fecha_de_pago"),
			 @ColumnResult(name="tasa_real"),  
			 @ColumnResult(name="mora"),
			 @ColumnResult(name="saldo"),
			 @ColumnResult(name="fas_afiliados_correo"),
			 @ColumnResult(name="fecha_desembolso")
	 		})}),

	@SqlResultSetMapping( 	name= ConstantesConsultas.RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_APORTE_PERMANENTE_AFILIADO,
	classes = {
	 @ConstructorResult(targetClass = FasExtAhorrosAfiliadosDTO.class,
	 columns = { 
			 @ColumnResult(name="correo"),
			 @ColumnResult(name="nombre"),
			 @ColumnResult(name="apellido"),
			 @ColumnResult(name="telefono"),
			 @ColumnResult(name="direccion"),
			 @ColumnResult(name="identificacion"),
			 @ColumnResult(name="cuenta_bancaria"),
			 @ColumnResult(name="fecha_ingreso"),
			 @ColumnResult(name="beneficio"),
			 @ColumnResult(name="fecha_aporte"),
			 @ColumnResult(name="monto"),
			 @ColumnResult(name="aporte"),
			 @ColumnResult(name="ahorro_permanente"),
			 @ColumnResult(name="aportes_ordinarios"),
			 @ColumnResult(name="ahorro_permanente_aporte"),
			 @ColumnResult(name="aportes_ordinarios_aporte"),
			 @ColumnResult(name="tipo")
			 
			 })}),
	
	@SqlResultSetMapping( 	name= ConstantesConsultas.RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_APORTE_VOLUNTARIO_AFILIADO,
	classes = {
	 @ConstructorResult(targetClass = FasExtAhorrosVoluntariosDTO.class,
	 columns = { 
			 
			 @ColumnResult(name="beneficio"),
			 @ColumnResult(name="fecha_aporte"),
			 @ColumnResult(name="monto"),
			 @ColumnResult(name="aporte"),
			 @ColumnResult(name="fas_afiliados_correo"),
			 @ColumnResult(name="tipo")
			 
			 })})
	

})
public class FasExtractos implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_EXTRACTOS_PK = "idExtracto";
	public static final String ENTIDAD_FAS_EXTRACTOS_URL_EXTRACTO = "urlExtracto";
	public static final String ENTIDAD_FAS_EXTRACTOS_NOMBRE_EXTRACTO = "nombreExtracto";
	public static final String ENTIDAD_FAS_EXTRACTOS_FECHA_EXTRACTO = "fechaExtracto";
	public static final String ENTIDAD_FAS_EXTRACTOS_FAS_AFILIADOS_CORREO = "fasAfiliadosCorreo";
	private static final String[] ATRIBUTOS_ENTIDAD_FAS_EXTRACTOS = { ENTIDAD_FAS_EXTRACTOS_FAS_AFILIADOS_CORREO,
			ENTIDAD_FAS_EXTRACTOS_NOMBRE_EXTRACTO, ENTIDAD_FAS_EXTRACTOS_URL_EXTRACTO, ENTIDAD_FAS_EXTRACTOS_PK,
			ENTIDAD_FAS_EXTRACTOS_FECHA_EXTRACTO };

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXTRACTOS_SEQ")
	@SequenceGenerator(name = "EXTRACTOS_SEQ", sequenceName = "SQ_FAS_EXTRACTOS", allocationSize = 1)
	@Column(name = "ID_EXTRACTO")
	private Number idExtracto;

	@Column(name = "URL_EXTRACTO")
	@Size(min = 0, max = 1000)
	private String urlExtracto;

	@Column(name = "NOMBRE_EXTRACTO")
	@Size(min = 0, max = 50)
	private String nombreExtracto;

	@Column(name = "FECHA_EXTRACTO")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaExtracto;

	@PodamExclude
	@Column(name = "FAS_AFILIADOS_CORREO")
	@Size(min = 0, max = 40)
	private String fasAfiliadosCorreo;

	@ManyToOne
	@JoinColumn(name = "FAS_AFILIADOS_CORREO", referencedColumnName = "CORREO", insertable = false, updatable = false)
	@PodamExclude
	private FasAfiliados fasAfiliadosfasExtractosFasAfiliadosFk;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasExtractos() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	public Number getIdExtracto() {
		return idExtracto;
	}

	public void setIdExtracto(Number idExtracto) {

		this.idExtracto = idExtracto;
	}

	public String getUrlExtracto() {
		return urlExtracto;
	}

	public void setUrlExtracto(String urlExtracto) {

		this.urlExtracto = urlExtracto;
	}

	public String getNombreExtracto() {
		return nombreExtracto;
	}

	public void setNombreExtracto(String nombreExtracto) {

		this.nombreExtracto = nombreExtracto;
	}

	public Date getFechaExtracto() {
		return fechaExtracto;
	}

	public void setFechaExtracto(Date fechaExtracto) {

		this.fechaExtracto = fechaExtracto;
	}

	public String getFasAfiliadosCorreo() {
		return fasAfiliadosCorreo;
	}

	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo) {

		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}

	public FasAfiliados getFasAfiliadosfasExtractosFasAfiliadosFk() {
		return fasAfiliadosfasExtractosFasAfiliadosFk;
	}

	public void setFasAfiliadosfasExtractosFasAfiliadosFk(FasAfiliados fasAfiliadosfasExtractosFasAfiliadosFk) {
		this.fasAfiliadosfasExtractosFasAfiliadosFk = fasAfiliadosfasExtractosFasAfiliadosFk;
	}

	/**
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_FAS_EXTRACTOS) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
	}

	public static String[] getAtributosEntidadFasExtractos() {
		return ATRIBUTOS_ENTIDAD_FAS_EXTRACTOS;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(idExtracto);
		hash = 37 * hash + Objects.hashCode(urlExtracto);
		hash = 37 * hash + Objects.hashCode(nombreExtracto);
		hash = 37 * hash + Objects.hashCode(fechaExtracto);
		hash = 37 * hash + Objects.hashCode(fasAfiliadosCorreo);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasExtractos que se pasa
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
		final FasExtractos other = (FasExtractos) obj;

		if (!Objects.equals(idExtracto, other.idExtracto))
			return false;

		if (!Objects.equals(urlExtracto, other.urlExtracto))
			return false;

		if (!Objects.equals(nombreExtracto, other.nombreExtracto))
			return false;

		if (!Objects.equals(fechaExtracto, other.fechaExtracto))
			return false;

		return Objects.equals(fasAfiliadosCorreo, other.fasAfiliadosCorreo);

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
