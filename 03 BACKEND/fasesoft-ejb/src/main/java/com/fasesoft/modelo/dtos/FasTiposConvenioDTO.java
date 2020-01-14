package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * DAO que contiene la información de la entidad FasTiposConvenioDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasTiposConvenioDTO implements Serializable{	

	private Number idTipoConvenio;

	private String tipo;
	
	private BigDecimal tasa;
	
	private String estado;
	
	private String descripcion;
	
	private String urlConvenio;
	
	private BigDecimal cuotasMaximas;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasTiposConvenioDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	
	@XmlElement(name="idTipoConvenio")
	public Number getIdTipoConvenio(){
		return this.idTipoConvenio;
	}
	
	@XmlElement(name="idTipoConvenio")
	public void setIdTipoConvenio(Number idTipoConvenio){
		this.idTipoConvenio = idTipoConvenio;
	}
	
	@XmlElement(name="tipo")
	public String getTipo(){
		return this.tipo;
	}
	
	@XmlElement(name="tipo")
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
		
	@XmlElement(name="tasa")
	public BigDecimal getTasa(){
		return this.tasa;
	}
	
	@XmlElement(name="tasa")
	public void setTasa(BigDecimal tasa){
		this.tasa = tasa;
	}
		
	@XmlElement(name="estado")
	public String getEstado(){
		return this.estado;
	}
	
	@XmlElement(name="estado")
	public void setEstado(String estado){
		this.estado = estado;
	}
		
	@XmlElement(name="descripcion")
	public String getDescripcion(){
		return this.descripcion;
	}
	
	@XmlElement(name="descripcion")
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	@XmlElement(name="urlConvenio")
	public String getUrlConvenio(){
		return this.urlConvenio;
	}
	
	@XmlElement(name="urlConvenio")
	public void setUrlConvenio(String urlConvenio){
		this.urlConvenio = urlConvenio;
	}
	
	@XmlElement(name="cuotasMaximas")
	public BigDecimal getCuotasMaximas(){
		return this.cuotasMaximas;
	}
	
	@XmlElement(name="cuotasMaximas")
	public void setCuotasMaximas(BigDecimal cuotasMaximas){
		this.cuotasMaximas = cuotasMaximas;
	}
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idTipoConvenio);        
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.tasa);
        hash = 37 * hash + Objects.hashCode(this.estado);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.urlConvenio);
        hash = 37 * hash + Objects.hashCode(this.cuotasMaximas);
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasTiposConvenioDTO que se pasa
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
        final FasTiposConvenioDTO other = (FasTiposConvenioDTO) obj;
                
        if (!Objects.equals(this.idTipoConvenio, other.idTipoConvenio)) {
            return false;
        }
        
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        
        if (!Objects.equals(this.tasa, other.tasa)) {
            return false;
        }
        
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        
        if (!Objects.equals(this.urlConvenio, other.urlConvenio)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotasMaximas, other.cuotasMaximas)) {
            return false;
        }
        
        return Objects.equals(this.descripcion, other.descripcion);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

