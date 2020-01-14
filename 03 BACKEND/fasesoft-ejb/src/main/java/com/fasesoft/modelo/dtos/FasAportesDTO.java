package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DAO que contiene la información de la entidad FasAportesDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasAportesDTO implements Serializable{	

	private BigDecimal idAporte;

	private BigDecimal beneficio;
	
	private BigDecimal aporte;
	
	private Date fechaAporte;
	
	private BigDecimal fasAhorrosIdAhorro;
	
	private BigDecimal aportesOrdinarios;
	
	private BigDecimal ahorroPermanente;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasAportesDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	
	@XmlElement(name="idAporte")
	public BigDecimal getIdAporte(){
		return this.idAporte;
	}
	
	@XmlElement(name="idAporte")
	public void setIdAporte(BigDecimal idAporte){
		this.idAporte = idAporte;
	}
	
	@XmlElement(name="beneficio")
	public BigDecimal getBeneficio(){
		return this.beneficio;
	}
	
	@XmlElement(name="beneficio")
	public void setBeneficio(BigDecimal beneficio){
		this.beneficio = beneficio;
	}
		
	@XmlElement(name="aporte")
	public BigDecimal getAporte(){
		return this.aporte;
	}
	
	@XmlElement(name="aporte")
	public void setAporte(BigDecimal aporte){
		this.aporte = aporte;
	}
		
	@XmlElement(name="fechaAporte")
	public Date getFechaAporte(){
		return this.fechaAporte;
	}
	
	@XmlElement(name="fechaAporte")
	public void setFechaAporte(Date fechaAporte){
		this.fechaAporte = fechaAporte;
	}
		
	@XmlElement(name="fasAhorrosIdAhorro")
	public BigDecimal getFasAhorrosIdAhorro(){
		return this.fasAhorrosIdAhorro;
	}
	
	@XmlElement(name="fasAhorrosIdAhorro")
	public void setFasAhorrosIdAhorro(BigDecimal fasAhorrosIdAhorro){
		this.fasAhorrosIdAhorro = fasAhorrosIdAhorro;
	}
		
	@XmlElement(name="aportesOrdinarios")
	public BigDecimal getAportesOrdinarios(){
		return this.aportesOrdinarios;
	}
	
	@XmlElement(name="aportesOrdinarios")
	public void setAportesOrdinarios(BigDecimal aportesOrdinarios){
		this.aportesOrdinarios = aportesOrdinarios;
	}
		
	@XmlElement(name="ahorroPermanente")
	public BigDecimal getAhorroPermanente(){
		return this.ahorroPermanente;
	}
	
	@XmlElement(name="ahorroPermanente")
	public void setAhorroPermanente(BigDecimal ahorroPermanente){
		this.ahorroPermanente = ahorroPermanente;
	}
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idAporte);        
        hash = 37 * hash + Objects.hashCode(this.beneficio);
        hash = 37 * hash + Objects.hashCode(this.aporte);
        hash = 37 * hash + Objects.hashCode(this.fechaAporte);
        hash = 37 * hash + Objects.hashCode(this.fasAhorrosIdAhorro);
        hash = 37 * hash + Objects.hashCode(this.aportesOrdinarios);
        hash = 37 * hash + Objects.hashCode(this.ahorroPermanente);
  
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasAportesDTO que se pasa
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
        final FasAportesDTO other = (FasAportesDTO) obj;
                
        if (!Objects.equals(this.idAporte, other.idAporte)) {
            return false;
        }
        
        if (!Objects.equals(this.beneficio, other.beneficio)) {
            return false;
        }
        
        if (!Objects.equals(this.aporte, other.aporte)) {
            return false;
        }
        
        if (!Objects.equals(this.fechaAporte, other.fechaAporte)) {
            return false;
        }
        
        if (!Objects.equals(this.fasAhorrosIdAhorro, other.fasAhorrosIdAhorro)) {
            return false;
        }
        
        if (!Objects.equals(this.aportesOrdinarios, other.aportesOrdinarios)) {
            return false;
        }
        
        return Objects.equals(this.ahorroPermanente, other.ahorroPermanente);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

