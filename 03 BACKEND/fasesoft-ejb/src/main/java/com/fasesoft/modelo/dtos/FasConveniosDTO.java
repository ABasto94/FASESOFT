package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DAO que contiene la información de la entidad FasConveniosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasConveniosDTO implements Serializable{	

	private Integer idConvenio;

	private BigDecimal monto;
	
	private BigDecimal saldo;
	
	private Date fechaInicioConvenio;
	
	private String estado;
	
	private BigDecimal numeroCuotas;
	
	private BigDecimal mora;
	
	private BigDecimal fasTipoConvIdTipoConv;
	
	private Date fechaSolicitud;
	
	private Date fechaInicioPago;
	
	private BigDecimal cuotasPendientes;
	
	private BigDecimal coutaIntereses;
	
	private BigDecimal coutaSeguro;
	
	private BigDecimal cuotaAporte;
	
	private String urlImagen;
	
	private String principal;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasConveniosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	
	@XmlElement(name="idConvenio")
	public Integer getIdConvenio(){
		return this.idConvenio;
	}
	
	@XmlElement(name="idConvenio")
	public void setIdConvenio(Integer idConvenio){
		this.idConvenio = idConvenio;
	}
	
	@XmlElement(name="monto")
	public BigDecimal getMonto(){
		return this.monto;
	}
	
	@XmlElement(name="monto")
	public void setMonto(BigDecimal monto){
		this.monto = monto;
	}
		
	@XmlElement(name="saldo")
	public BigDecimal getSaldo(){
		return this.saldo;
	}
	
	@XmlElement(name="saldo")
	public void setSaldo(BigDecimal saldo){
		this.saldo = saldo;
	}
		
	@XmlElement(name="fechaInicioConvenio")
	public Date getFechaInicioConvenio(){
		return this.fechaInicioConvenio;
	}
	
	@XmlElement(name="fechaInicioConvenio")
	public void setFechaInicioConvenio(Date fechaInicioConvenio){
		this.fechaInicioConvenio = fechaInicioConvenio;
	}
		
	@XmlElement(name="estado")
	public String getEstado(){
		return this.estado;
	}
	
	@XmlElement(name="estado")
	public void setEstado(String estado){
		this.estado = estado;
	}
		
	@XmlElement(name="numeroCuotas")
	public BigDecimal getNumeroCuotas(){
		return this.numeroCuotas;
	}
	
	@XmlElement(name="numeroCuotas")
	public void setNumeroCuotas(BigDecimal numeroCuotas){
		this.numeroCuotas = numeroCuotas;
	}
		
	@XmlElement(name="mora")
	public BigDecimal getMora(){
		return this.mora;
	}
	
	@XmlElement(name="mora")
	public void setMora(BigDecimal mora){
		this.mora = mora;
	}
		
	@XmlElement(name="fasTipoConvIdTipoConv")
	public BigDecimal getFasTipoConvIdTipoConv(){
		return this.fasTipoConvIdTipoConv;
	}
	
	@XmlElement(name="fasTipoConvIdTipoConv")
	public void setFasTipoConvIdTipoConv(BigDecimal fasTipoConvIdTipoConv){
		this.fasTipoConvIdTipoConv = fasTipoConvIdTipoConv;
	}
		
	@XmlElement(name="fechaSolicitud")
	public Date getFechaSolicitud(){
		return this.fechaSolicitud;
	}
	
	@XmlElement(name="fechaSolicitud")
	public void setFechaSolicitud(Date fechaSolicitud){
		this.fechaSolicitud = fechaSolicitud;
	}
		
	@XmlElement(name="fechaInicioPago")
	public Date getFechaInicioPago(){
		return this.fechaInicioPago;
	}
	
	@XmlElement(name="fechaInicioPago")
	public void setFechaInicioPago(Date fechaInicioPago){
		this.fechaInicioPago = fechaInicioPago;
	}
		
	@XmlElement(name="cuotasPendientes")
	public BigDecimal getCuotasPendientes(){
		return this.cuotasPendientes;
	}
	
	@XmlElement(name="cuotasPendientes")
	public void setCuotasPendientes(BigDecimal cuotasPendientes){
		this.cuotasPendientes = cuotasPendientes;
	}
		
	@XmlElement(name="coutaIntereses")
	public BigDecimal getCoutaIntereses(){
		return this.coutaIntereses;
	}
	
	@XmlElement(name="coutaIntereses")
	public void setCoutaIntereses(BigDecimal coutaIntereses){
		this.coutaIntereses = coutaIntereses;
	}
		
	@XmlElement(name="coutaSeguro")
	public BigDecimal getCoutaSeguro(){
		return this.coutaSeguro;
	}
	
	@XmlElement(name="coutaSeguro")
	public void setCoutaSeguro(BigDecimal coutaSeguro){
		this.coutaSeguro = coutaSeguro;
	}
		
	@XmlElement(name="cuotaAporte")
	public BigDecimal getCuotaAporte(){
		return this.cuotaAporte;
	}
	
	@XmlElement(name="cuotaAporte")
	public void setCuotaAporte(BigDecimal cuotaAporte){
		this.cuotaAporte = cuotaAporte;
	}
		
	@XmlElement(name="urlImagen")
	public String getUrlImagen(){
		return this.urlImagen;
	}
	
	@XmlElement(name="urlImagen")
	public void setUrlImagen(String urlImagen){
		this.urlImagen = urlImagen;
	}
		
	@XmlElement(name="principal")
	public String getPrincipal(){
		return this.principal;
	}
	
	@XmlElement(name="principal")
	public void setPrincipal(String principal){
		this.principal = principal;
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
     * Valida la igualdad de la instancia de la entidad FasConveniosDTO que se pasa
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
        final FasConveniosDTO other = (FasConveniosDTO) obj;
                
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

