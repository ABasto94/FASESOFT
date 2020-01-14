package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DAO que contiene la información de la entidad FasPagosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasPagosDTO implements Serializable{	

	private BigDecimal idPago;

	private BigDecimal cuotaTotal;
	
	private Date fechaDePago;
	
	private BigDecimal saldo;
	
	private BigDecimal fasCreditosIdCredito;
	
	private BigDecimal cuotaIntereses;
	
	private BigDecimal cuotaSeguro;
	
	private BigDecimal cuotaDeuda;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasPagosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	
	@XmlElement(name="idPago")
	public BigDecimal getIdPago(){
		return this.idPago;
	}
	
	@XmlElement(name="idPago")
	public void setIdPago(BigDecimal idPago){
		this.idPago = idPago;
	}
	
	@XmlElement(name="cuotaTotal")
	public BigDecimal getCuotaTotal(){
		return this.cuotaTotal;
	}
	
	@XmlElement(name="cuotaTotal")
	public void setCuotaTotal(BigDecimal cuotaTotal){
		this.cuotaTotal = cuotaTotal;
	}
		
	@XmlElement(name="fechaDePago")
	public Date getFechaDePago(){
		return this.fechaDePago;
	}
	
	@XmlElement(name="fechaDePago")
	public void setFechaDePago(Date fechaDePago){
		this.fechaDePago = fechaDePago;
	}
		
	@XmlElement(name="saldo")
	public BigDecimal getSaldo(){
		return this.saldo;
	}
	
	@XmlElement(name="saldo")
	public void setSaldo(BigDecimal saldo){
		this.saldo = saldo;
	}
		
	@XmlElement(name="fasCreditosIdCredito")
	public BigDecimal getFasCreditosIdCredito(){
		return this.fasCreditosIdCredito;
	}
	
	@XmlElement(name="fasCreditosIdCredito")
	public void setFasCreditosIdCredito(BigDecimal fasCreditosIdCredito){
		this.fasCreditosIdCredito = fasCreditosIdCredito;
	}
		
	@XmlElement(name="cuotaIntereses")
	public BigDecimal getCuotaIntereses(){
		return this.cuotaIntereses;
	}
	
	@XmlElement(name="cuotaIntereses")
	public void setCuotaIntereses(BigDecimal cuotaIntereses){
		this.cuotaIntereses = cuotaIntereses;
	}
		
	@XmlElement(name="cuotaSeguro")
	public BigDecimal getCuotaSeguro(){
		return this.cuotaSeguro;
	}
	
	@XmlElement(name="cuotaSeguro")
	public void setCuotaSeguro(BigDecimal cuotaSeguro){
		this.cuotaSeguro = cuotaSeguro;
	}
		
	@XmlElement(name="cuotaDeuda")
	public BigDecimal getCuotaDeuda(){
		return this.cuotaDeuda;
	}
	
	@XmlElement(name="cuotaDeuda")
	public void setCuotaDeuda(BigDecimal cuotaDeuda){
		this.cuotaDeuda = cuotaDeuda;
	}
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idPago);        
        hash = 37 * hash + Objects.hashCode(this.cuotaTotal);
        hash = 37 * hash + Objects.hashCode(this.fechaDePago);
        hash = 37 * hash + Objects.hashCode(this.saldo);
        hash = 37 * hash + Objects.hashCode(this.fasCreditosIdCredito);
        hash = 37 * hash + Objects.hashCode(this.cuotaIntereses);
        hash = 37 * hash + Objects.hashCode(this.cuotaSeguro);
        hash = 37 * hash + Objects.hashCode(this.cuotaDeuda);
  
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasPagosDTO que se pasa
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
        final FasPagosDTO other = (FasPagosDTO) obj;
                
        if (!Objects.equals(this.idPago, other.idPago)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotaTotal, other.cuotaTotal)) {
            return false;
        }
        
        if (!Objects.equals(this.fechaDePago, other.fechaDePago)) {
            return false;
        }
        
        if (!Objects.equals(this.saldo, other.saldo)) {
            return false;
        }
        
        if (!Objects.equals(this.fasCreditosIdCredito, other.fasCreditosIdCredito)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotaIntereses, other.cuotaIntereses)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotaSeguro, other.cuotaSeguro)) {
            return false;
        }
        
        return Objects.equals(this.cuotaDeuda, other.cuotaDeuda);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

