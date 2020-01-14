package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * DAO que contiene la información de la entidad FasTiposDeCreditoDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasTiposDeCreditoDTO implements Serializable{	

	private BigDecimal idTipo;

	private String tipo;
	
	private BigDecimal tasa;
	
	private String descripcion;
	
	private BigDecimal cuotasMaximas;
	
	private String estado;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasTiposDeCreditoDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	
	@XmlElement(name="idTipo")
	public BigDecimal getIdTipo(){
		return this.idTipo;
	}
	
	@XmlElement(name="idTipo")
	public void setIdTipo(BigDecimal idTipo){
		this.idTipo = idTipo;
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
		
	@XmlElement(name="descripcion")
	public String getDescripcion(){
		return this.descripcion;
	}
	
	@XmlElement(name="descripcion")
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
		
	@XmlElement(name="cuotasMaximas")
	public BigDecimal getCuotasMaximas(){
		return this.cuotasMaximas;
	}
	
	@XmlElement(name="cuotasMaximas")
	public void setCuotasMaximas(BigDecimal cuotasMaximas){
		this.cuotasMaximas = cuotasMaximas;
	}
		
	@XmlElement(name="estado")
	public String getEstado(){
		return this.estado;
	}
	
	@XmlElement(name="estado")
	public void setEstado(String estado){
		this.estado = estado;
	}
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idTipo);        
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.tasa);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.cuotasMaximas);
        hash = 37 * hash + Objects.hashCode(this.estado);
  
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasTiposDeCreditoDTO que se pasa
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
        final FasTiposDeCreditoDTO other = (FasTiposDeCreditoDTO) obj;
                
        if (!Objects.equals(this.idTipo, other.idTipo)) {
            return false;
        }
        
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        
        if (!Objects.equals(this.tasa, other.tasa)) {
            return false;
        }
        
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotasMaximas, other.cuotasMaximas)) {
            return false;
        }
        
        return Objects.equals(this.estado, other.estado);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

