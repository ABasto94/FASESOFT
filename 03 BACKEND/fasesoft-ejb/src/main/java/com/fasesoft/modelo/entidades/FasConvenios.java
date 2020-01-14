package com.fasesoft.modelo.entidades;


import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery; 
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import java.util.Date;
import uk.co.jemos.podam.annotations.PodamExclude;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name="FAS_CONVENIOS")
@NamedQueries({
	@NamedQuery(name = "FasConvenios.findAll", query = "SELECT p FROM FasConvenios p"),
	@NamedQuery(name = "FasConvenios.findSolConveniosByUser", query = "SELECT c FROM FasConvenios c LEFT JOIN"
			+ " c.fasSolConvFasConvFkes sc WHERE sc.fasAfiliadosCorreo = :correo")
})
public class FasConvenios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_CONVENIOS_PK = "idConvenio";
	public static final String ENTIDAD_FAS_CONVENIOS_MONTO = "monto";
	public static final String ENTIDAD_FAS_CONVENIOS_SALDO = "saldo";
	public static final String ENTIDAD_FAS_CONVENIOS_FECHA_INICIO_CONVENIO = "fechaInicioConvenio";
	public static final String ENTIDAD_FAS_CONVENIOS_ESTADO = "estado";
	public static final String ENTIDAD_FAS_CONVENIOS_NUMERO_CUOTAS = "numeroCuotas";
	public static final String ENTIDAD_FAS_CONVENIOS_MORA = "mora";
	public static final String ENTIDAD_FAS_CONVENIOS_FAS_TIPO_CONV_ID_TIPO_CONV = "fasTipoConvIdTipoConv";
	public static final String ENTIDAD_FAS_CONVENIOS_FECHA_SOLICITUD = "fechaSolicitud";
	public static final String ENTIDAD_FAS_CONVENIOS_FECHA_INICIO_PAGO = "fechaInicioPago";
	public static final String ENTIDAD_FAS_CONVENIOS_CUOTAS_PENDIENTES = "cuotasPendientes";
	public static final String ENTIDAD_FAS_CONVENIOS_COUTA_INTERESES = "coutaIntereses";
	public static final String ENTIDAD_FAS_CONVENIOS_COUTA_SEGURO = "coutaSeguro";
	public static final String ENTIDAD_FAS_CONVENIOS_CUOTA_APORTE = "cuotaAporte";
	public static final String ENTIDAD_FAS_CONVENIOS_URL_IMAGEN = "urlImagen";
	public static final String ENTIDAD_FAS_CONVENIOS_PRINCIPAL = "principal";
    private static final String[] ATRIBUTOS_ENTIDAD_FAS_CONVENIOS
            = {ENTIDAD_FAS_CONVENIOS_CUOTA_APORTE, ENTIDAD_FAS_CONVENIOS_MORA, ENTIDAD_FAS_CONVENIOS_COUTA_INTERESES, ENTIDAD_FAS_CONVENIOS_URL_IMAGEN, ENTIDAD_FAS_CONVENIOS_FAS_TIPO_CONV_ID_TIPO_CONV, ENTIDAD_FAS_CONVENIOS_COUTA_SEGURO, ENTIDAD_FAS_CONVENIOS_NUMERO_CUOTAS, ENTIDAD_FAS_CONVENIOS_SALDO, ENTIDAD_FAS_CONVENIOS_PK, ENTIDAD_FAS_CONVENIOS_FECHA_INICIO_PAGO, ENTIDAD_FAS_CONVENIOS_FECHA_INICIO_CONVENIO, ENTIDAD_FAS_CONVENIOS_FECHA_SOLICITUD, ENTIDAD_FAS_CONVENIOS_CUOTAS_PENDIENTES, ENTIDAD_FAS_CONVENIOS_PRINCIPAL, ENTIDAD_FAS_CONVENIOS_ESTADO, ENTIDAD_FAS_CONVENIOS_MONTO};

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONVENIOS_SEQ")
    @SequenceGenerator(name = "CONVENIOS_SEQ", sequenceName = "SQ_FAS_CONVENIOS", allocationSize = 1)
    @Column(name="ID_CONVENIO")
	private Integer idConvenio;

	@Column(name="MONTO")
	private BigDecimal monto;
	
	@Column(name="SALDO")
	private BigDecimal saldo;
	
	@Column(name="FECHA_INICIO_CONVENIO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaInicioConvenio;
	
	@Column(name="ESTADO")
	@Size(min=0, max= 30)
	private String estado;
	
	@Column(name="NUMERO_CUOTAS")
	private BigDecimal numeroCuotas;
	
	@Column(name="MORA")
	private BigDecimal mora;
	
    @PodamExclude
	@Column(name="FAS_TIPO_CONV_ID_TIPO_CONV")
	private BigDecimal fasTipoConvIdTipoConv;
	
	@Column(name="FECHA_SOLICITUD")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaSolicitud;
	
	@Column(name="FECHA_INICIO_PAGO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaInicioPago;
	
	@Column(name="CUOTAS_PENDIENTES")
	private BigDecimal cuotasPendientes;
	
	@Column(name="COUTA_INTERESES")
	private BigDecimal coutaIntereses;
	
	@Column(name="COUTA_SEGURO")
	private BigDecimal coutaSeguro;
	
	@Column(name="CUOTA_APORTE")
	private BigDecimal cuotaAporte;
	
	@Column(name="URL_IMAGEN")
	@Size(min=0, max= 250)
	private String urlImagen;
	
	@Column(name="PRINCIPAL")
	@Size(min=0, max= 10)
	private String principal;
	

	@ManyToOne
	@JoinColumn(name="FAS_TIPO_CONV_ID_TIPO_CONV", referencedColumnName="ID_TIPO_CONVENIO", insertable = false, updatable = false)
	@PodamExclude
    private FasTiposConvenio fasTiposConveniofasConvFasTipoConvFk;
    
		
	@OneToMany(mappedBy="fasConveniosfasSolConvFasConvFk")
	@PodamExclude
    private List<FasSolConvenios> fasSolConvFasConvFkes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasConvenios(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	public Integer getIdConvenio(){
		return this.idConvenio;
	}
	
	public void setIdConvenio(Integer idConvenio){
	
		this.idConvenio = idConvenio;
	}
	
	public BigDecimal getMonto(){
		return this.monto;
	}
	
	public void setMonto(BigDecimal monto){
	
		this.monto = monto;
	}
		
	public BigDecimal getSaldo(){
		return this.saldo;
	}
	
	public void setSaldo(BigDecimal saldo){
	
		this.saldo = saldo;
	}
		
	public Date getFechaInicioConvenio(){
		return this.fechaInicioConvenio;
	}
	
	public void setFechaInicioConvenio(Date fechaInicioConvenio){
	
		this.fechaInicioConvenio = fechaInicioConvenio;
	}
		
	public String getEstado(){
		return this.estado;
	}
	
	public void setEstado(String estado){
	
		this.estado = estado;
	}
		
	public BigDecimal getNumeroCuotas(){
		return this.numeroCuotas;
	}
	
	public void setNumeroCuotas(BigDecimal numeroCuotas){
	
		this.numeroCuotas = numeroCuotas;
	}
		
	public BigDecimal getMora(){
		return this.mora;
	}
	
	public void setMora(BigDecimal mora){
	
		this.mora = mora;
	}
		
	public BigDecimal getFasTipoConvIdTipoConv(){
		return this.fasTipoConvIdTipoConv;
	}
	
	public void setFasTipoConvIdTipoConv(BigDecimal fasTipoConvIdTipoConv){
	
		this.fasTipoConvIdTipoConv = fasTipoConvIdTipoConv;
	}
		
	public Date getFechaSolicitud(){
		return this.fechaSolicitud;
	}
	
	public void setFechaSolicitud(Date fechaSolicitud){
	
		this.fechaSolicitud = fechaSolicitud;
	}
		
	public Date getFechaInicioPago(){
		return this.fechaInicioPago;
	}
	
	public void setFechaInicioPago(Date fechaInicioPago){
	
		this.fechaInicioPago = fechaInicioPago;
	}
		
	public BigDecimal getCuotasPendientes(){
		return this.cuotasPendientes;
	}
	
	public void setCuotasPendientes(BigDecimal cuotasPendientes){
	
		this.cuotasPendientes = cuotasPendientes;
	}
		
	public BigDecimal getCoutaIntereses(){
		return this.coutaIntereses;
	}
	
	public void setCoutaIntereses(BigDecimal coutaIntereses){
	
		this.coutaIntereses = coutaIntereses;
	}
		
	public BigDecimal getCoutaSeguro(){
		return this.coutaSeguro;
	}
	
	public void setCoutaSeguro(BigDecimal coutaSeguro){
	
		this.coutaSeguro = coutaSeguro;
	}
		
	public BigDecimal getCuotaAporte(){
		return this.cuotaAporte;
	}
	
	public void setCuotaAporte(BigDecimal cuotaAporte){
	
		this.cuotaAporte = cuotaAporte;
	}
		
	public String getUrlImagen(){
		return this.urlImagen;
	}
	
	public void setUrlImagen(String urlImagen){
	
		this.urlImagen = urlImagen;
	}
		
	public String getPrincipal(){
		return this.principal;
	}
	
	public void setPrincipal(String principal){
	
		this.principal = principal;
	}
		

    public List<FasSolConvenios> getFasSolConvFasConvFkesList(){
		return this.fasSolConvFasConvFkes;
	}
	
	public void setFasSolConvFasConvFkesList(List<FasSolConvenios> fasSolConvFasConvFkes){
		this.fasSolConvFasConvFkes = fasSolConvFasConvFkes;
	}
			
    public FasTiposConvenio getFasTiposConveniofasConvFasTipoConvFk(){
		return this.fasTiposConveniofasConvFasTipoConvFk; 
	}
	
	public void setFasTiposConveniofasConvFasTipoConvFk(FasTiposConvenio fasTiposConveniofasConvFasTipoConvFk){
		this.fasTiposConveniofasConvFasTipoConvFk = fasTiposConveniofasConvFasTipoConvFk;
	}

	/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
		
		boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_CONVENIOS) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
    
    public static String[] getAtributosEntidadFasConvenios() {
		return ATRIBUTOS_ENTIDAD_FAS_CONVENIOS;
	}

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idConvenio);        
        hash = 37 * hash + Objects.hashCode(this.monto);
        hash = 37 * hash + Objects.hashCode(this.saldo);
        hash = 37 * hash + Objects.hashCode(this.fechaInicioConvenio);
        hash = 37 * hash + Objects.hashCode(this.estado);
        hash = 37 * hash + Objects.hashCode(this.numeroCuotas);
        hash = 37 * hash + Objects.hashCode(this.mora);
        hash = 37 * hash + Objects.hashCode(this.fasTipoConvIdTipoConv);
        hash = 37 * hash + Objects.hashCode(this.fechaSolicitud);
        hash = 37 * hash + Objects.hashCode(this.fechaInicioPago);
        hash = 37 * hash + Objects.hashCode(this.cuotasPendientes);
        hash = 37 * hash + Objects.hashCode(this.coutaIntereses);
        hash = 37 * hash + Objects.hashCode(this.coutaSeguro);
        hash = 37 * hash + Objects.hashCode(this.cuotaAporte);
        hash = 37 * hash + Objects.hashCode(this.urlImagen);
        hash = 37 * hash + Objects.hashCode(this.principal);
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasConvenios que se pasa
     * como parámetro comprobando que comparten los mismos valores en cada uno
     * de sus atributos. Solo se tienen en cuenta los atributos simples, es
     * decir, se omiten aquellos que definen una relación con otra tabla.
     *
     * @param obj Instancia de la categoría a comprobar
     * iguales.
     * @return Verdadero si esta instancia y la que se pasan como parámetros son
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FasConvenios other = (FasConvenios) obj;
        
        if (!Objects.equals(this.idConvenio, other.idConvenio)) {
            return false;
        }
        
        if (!Objects.equals(this.monto, other.monto)) {
            return false;
        }
        
        if (!Objects.equals(this.saldo, other.saldo)) {
            return false;
        }
        
        if (!Objects.equals(this.fechaInicioConvenio, other.fechaInicioConvenio)) {
            return false;
        }
        
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        
        if (!Objects.equals(this.numeroCuotas, other.numeroCuotas)) {
            return false;
        }
        
        if (!Objects.equals(this.mora, other.mora)) {
            return false;
        }
        
        if (!Objects.equals(this.fasTipoConvIdTipoConv, other.fasTipoConvIdTipoConv)) {
            return false;
        }
        
        if (!Objects.equals(this.fechaSolicitud, other.fechaSolicitud)) {
            return false;
        }
        
        if (!Objects.equals(this.fechaInicioPago, other.fechaInicioPago)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotasPendientes, other.cuotasPendientes)) {
            return false;
        }
        
        if (!Objects.equals(this.coutaIntereses, other.coutaIntereses)) {
            return false;
        }
        
        if (!Objects.equals(this.coutaSeguro, other.coutaSeguro)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotaAporte, other.cuotaAporte)) {
            return false;
        }
        
        if (!Objects.equals(this.urlImagen, other.urlImagen)) {
            return false;
        }
        
        return Objects.equals(this.principal, other.principal);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

