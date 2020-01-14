package com.fasesoft.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasesoft.modelo.manejadores.utils.ConstantesConsultaCreditos;

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
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

import com.fasesoft.modelo.dtos.FasCreditosAfiliadoDTO;

import uk.co.jemos.podam.annotations.PodamExclude;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;


/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name = "FAS_CREDITOS")
@NamedQueries({ @NamedQuery(name = "FasCreditos.findAll", query = "SELECT  p FROM FasCreditos p"),
		@NamedQuery(name = "FasCreditos.findDetalleCredito", query = "SELECT  c from FasCreditos c WHERE c.fasAfiliadosCorreo = :paramCorreo"),
		@NamedQuery(name = "FasCreditos.findbyid", query = "SELECT p.estado FROM FasCreditos p") })

@SqlResultSetMapping(     name= ConstantesConsultaCreditos.RESULTMAPPING_QUERY_NATIVA_SOLICITUDES_CREDITOS,
classes = {
 @ConstructorResult(targetClass = FasCreditosAfiliadoDTO.class,
 columns = {
         @ColumnResult(name="identificacion"),   
         @ColumnResult(name="nombre"),
         @ColumnResult(name="tipoCredito"),
         @ColumnResult(name="cuotas"),
         @ColumnResult(name="estado"),
         @ColumnResult(name="fechaSolicitud"),
         @ColumnResult(name="idCredito"),
         @ColumnResult(name="monto"),
         @ColumnResult(name="tasaReal"),
         @ColumnResult(name="montoFijo"),
         @ColumnResult(name="deuda", type=BigDecimal.class)
         })})


public class FasCreditos implements Serializable {

	private static final long serialVersionUID = 1L;

	// Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_CREDITOS_PK = "idCredito";
	public static final String ENTIDAD_FAS_CREDITOS_TASA_REAL = "tasaReal";
	public static final String ENTIDAD_FAS_CREDITOS_MONTO = "monto";
	public static final String ENTIDAD_FAS_CREDITOS_SALDO = "saldo";
	public static final String ENTIDAD_FAS_CREDITOS_FECHA_INICIO = "fechaInicio";
	public static final String ENTIDAD_FAS_CREDITOS_ESTADO = "estado";
	public static final String ENTIDAD_FAS_CREDITOS_FAS_AFILIADOS_CORREO = "fasAfiliadosCorreo";
	public static final String ENTIDAD_FAS_CREDITOS_FAS_TIPOS_DE_CREDITO_ID_TIPO = "fasTiposDeCreditoIdTipo";
	public static final String ENTIDAD_FAS_CREDITOS_NUMERO_CUOTAS = "numeroCuotas";
	public static final String ENTIDAD_FAS_CREDITOS_FECHA_SOLICITUD = "fechaSolicitud";
	public static final String ENTIDAD_FAS_CREDITOS_MORA = "mora";
	public static final String ENTIDAD_FAS_CREDITOS_FECHA_DESEMBOLSO = "fechaDesembolso";
	public static final String ENTIDAD_FAS_CREDITOS_FECHA_INICIO_PAGO = "fechaInicioPago";
	public static final String ENTIDAD_FAS_CREDITOS_CUOTAS_PENDIENTES = "cuotasPendientes";
	private static final String[] ATRIBUTOS_ENTIDAD_FAS_CREDITOS = { ENTIDAD_FAS_CREDITOS_NUMERO_CUOTAS,
			ENTIDAD_FAS_CREDITOS_FECHA_SOLICITUD, ENTIDAD_FAS_CREDITOS_FAS_AFILIADOS_CORREO,
			ENTIDAD_FAS_CREDITOS_TASA_REAL, ENTIDAD_FAS_CREDITOS_MORA, ENTIDAD_FAS_CREDITOS_FECHA_INICIO,
			ENTIDAD_FAS_CREDITOS_MONTO, ENTIDAD_FAS_CREDITOS_FAS_TIPOS_DE_CREDITO_ID_TIPO,
			ENTIDAD_FAS_CREDITOS_FECHA_DESEMBOLSO, ENTIDAD_FAS_CREDITOS_PK, ENTIDAD_FAS_CREDITOS_CUOTAS_PENDIENTES,
			ENTIDAD_FAS_CREDITOS_ESTADO, ENTIDAD_FAS_CREDITOS_FECHA_INICIO_PAGO, ENTIDAD_FAS_CREDITOS_SALDO };

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CREDITOS_SEQ")
	@SequenceGenerator(name = "CREDITOS_SEQ", sequenceName = "SQ_FAS_CREDITOS", allocationSize = 1)
	@Column(name = "ID_CREDITO")
	private Integer idCredito;

	@Column(name = "TASA_REAL")
	private BigDecimal tasaReal;

	@Column(name = "MONTO")
	private BigDecimal monto;

	@Column(name = "SALDO")
	private BigDecimal saldo;

	@Column(name = "FECHA_INICIO")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaInicio;

	@Column(name = "ESTADO")
	@Size(min = 0, max = 20)
	private String estado;

	@PodamExclude
	@Column(name = "FAS_AFILIADOS_CORREO")
	@Size(min = 0, max = 40)
	private String fasAfiliadosCorreo;

	@PodamExclude
	@Column(name = "FAS_TIPOS_DE_CREDITO_ID_TIPO")
	private BigDecimal fasTiposDeCreditoIdTipo;

	@Column(name = "NUMERO_CUOTAS")
	private BigDecimal numeroCuotas;

	@Column(name = "FECHA_SOLICITUD")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaSolicitud;

	@Column(name = "MORA")
	private BigDecimal mora;

	@Column(name = "FECHA_DESEMBOLSO")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaDesembolso;

	@Column(name = "FECHA_INICIO_PAGO")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaInicioPago;

	@Column(name = "CUOTAS_PENDIENTES")
	private BigDecimal cuotasPendientes;

	@ManyToOne
	@JoinColumn(name = "FAS_AFILIADOS_CORREO", referencedColumnName = "CORREO", insertable = false, updatable = false)
	@PodamExclude
	private FasAfiliados fasAfiliadosfasCreditosFasAfiliadosFk;

	@ManyToOne
	@JoinColumn(name = "FAS_TIPOS_DE_CREDITO_ID_TIPO", referencedColumnName = "ID_TIPO", insertable = false, updatable = false)
	@PodamExclude
	private FasTiposDeCredito fasTiposDeCreditofasCredFasTipoCredFk;

	@OneToMany(mappedBy = "fasCreditosfasPagosFasCreditosFk")
	@PodamExclude
	private List<FasPagos> fasPagosFasCreditosFkes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasCreditos() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}

	public Integer getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(Integer idCredito) {

		this.idCredito = idCredito;
	}

	public BigDecimal getTasaReal() {
		return tasaReal;
	}

	public void setTasaReal(BigDecimal tasaReal) {

		this.tasaReal = tasaReal;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {

		this.monto = monto;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {

		this.saldo = saldo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {

		this.fechaInicio = fechaInicio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {

		this.estado = estado;
	}

	public String getFasAfiliadosCorreo() {
		return fasAfiliadosCorreo;
	}

	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo) {

		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}

	public BigDecimal getFasTiposDeCreditoIdTipo() {
		return fasTiposDeCreditoIdTipo;
	}

	public void setFasTiposDeCreditoIdTipo(BigDecimal fasTiposDeCreditoIdTipo) {

		this.fasTiposDeCreditoIdTipo = fasTiposDeCreditoIdTipo;
	}

	public BigDecimal getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(BigDecimal numeroCuotas) {

		this.numeroCuotas = numeroCuotas;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {

		this.fechaSolicitud = fechaSolicitud;
	}

	public BigDecimal getMora() {
		return mora;
	}

	public void setMora(BigDecimal mora) {

		this.mora = mora;
	}

	public Date getFechaDesembolso() {
		return fechaDesembolso;
	}

	public void setFechaDesembolso(Date fechaDesembolso) {

		this.fechaDesembolso = fechaDesembolso;
	}

	public Date getFechaInicioPago() {
		return fechaInicioPago;
	}

	public void setFechaInicioPago(Date fechaInicioPago) {

		this.fechaInicioPago = fechaInicioPago;
	}

	public BigDecimal getCuotasPendientes() {
		return cuotasPendientes;
	}

	public void setCuotasPendientes(BigDecimal cuotasPendientes) {

		this.cuotasPendientes = cuotasPendientes;
	}

	public List<FasPagos> getFasPagosFasCreditosFkesList() {
		return fasPagosFasCreditosFkes;
	}

	public void setFasPagosFasCreditosFkesList(List<FasPagos> fasPagosFasCreditosFkes) {
		this.fasPagosFasCreditosFkes = fasPagosFasCreditosFkes;
	}

	public FasAfiliados getFasAfiliadosfasCreditosFasAfiliadosFk() {
		return fasAfiliadosfasCreditosFasAfiliadosFk;
	}

	public void setFasAfiliadosfasCreditosFasAfiliadosFk(FasAfiliados fasAfiliadosfasCreditosFasAfiliadosFk) {
		this.fasAfiliadosfasCreditosFasAfiliadosFk = fasAfiliadosfasCreditosFasAfiliadosFk;
	}

	public FasTiposDeCredito getFasTiposDeCreditofasCredFasTipoCredFk() {
		return fasTiposDeCreditofasCredFasTipoCredFk;
	}

	public void setFasTiposDeCreditofasCredFasTipoCredFk(FasTiposDeCredito fasTiposDeCreditofasCredFasTipoCredFk) {
		this.fasTiposDeCreditofasCredFasTipoCredFk = fasTiposDeCreditofasCredFasTipoCredFk;
	}

	/**
	 * Verifica si la entidad contiene el atributo que se pasa como parámetro
	 *
	 * @param atributo Nombre del atributo a validar
	 * @return Verdadero si la entidad contiene al atributo.
	 */
	public static boolean contieneAtributo(String atributo) {

		boolean contiene = false;
		for (final String atr : ATRIBUTOS_ENTIDAD_FAS_CREDITOS) {
			if (atr.equals(atributo)) {
				contiene = true;
			}
		}

		return contiene;
	}

	public static String[] getAtributosEntidadFasCreditos() {
		return ATRIBUTOS_ENTIDAD_FAS_CREDITOS;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 3;

		hash = 37 * hash + Objects.hashCode(idCredito);
		hash = 37 * hash + Objects.hashCode(tasaReal);
		hash = 37 * hash + Objects.hashCode(monto);
		hash = 37 * hash + Objects.hashCode(saldo);
		hash = 37 * hash + Objects.hashCode(fechaInicio);
		hash = 37 * hash + Objects.hashCode(estado);
		hash = 37 * hash + Objects.hashCode(fasAfiliadosCorreo);
		hash = 37 * hash + Objects.hashCode(fasTiposDeCreditoIdTipo);
		hash = 37 * hash + Objects.hashCode(numeroCuotas);
		hash = 37 * hash + Objects.hashCode(fechaSolicitud);
		hash = 37 * hash + Objects.hashCode(mora);
		hash = 37 * hash + Objects.hashCode(fechaDesembolso);
		hash = 37 * hash + Objects.hashCode(fechaInicioPago);
		hash = 37 * hash + Objects.hashCode(cuotasPendientes);

		return hash;
	}

	/**
	 * Valida la igualdad de la instancia de la entidad FasCreditos que se pasa como
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
		final FasCreditos other = (FasCreditos) obj;

		if (!Objects.equals(idCredito, other.idCredito))
			return false;

		if (!Objects.equals(tasaReal, other.tasaReal))
			return false;

		if (!Objects.equals(monto, other.monto))
			return false;

		if (!Objects.equals(saldo, other.saldo))
			return false;

		if (!Objects.equals(fechaInicio, other.fechaInicio))
			return false;

		if (!Objects.equals(estado, other.estado))
			return false;

		if (!Objects.equals(fasAfiliadosCorreo, other.fasAfiliadosCorreo))
			return false;

		if (!Objects.equals(fasTiposDeCreditoIdTipo, other.fasTiposDeCreditoIdTipo))
			return false;

		if (!Objects.equals(numeroCuotas, other.numeroCuotas))
			return false;

		if (!Objects.equals(fechaSolicitud, other.fechaSolicitud))
			return false;

		if (!Objects.equals(mora, other.mora))
			return false;

		if (!Objects.equals(fechaDesembolso, other.fechaDesembolso))
			return false;

		if (!Objects.equals(fechaInicioPago, other.fechaInicioPago))
			return false;

		return Objects.equals(cuotasPendientes, other.cuotasPendientes);

	}

	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

}
