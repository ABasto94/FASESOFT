package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * DAO que contiene la información de la entidad FasAccesosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasAccesosDTO implements Serializable{	

	private BigDecimal idAcceso;

	private String nombre;
	
	private String componente;
	
	private String descripcion;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasAccesosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	
	@XmlElement(name="idAcceso")
	public BigDecimal getIdAcceso(){
		return this.idAcceso;
	}
	
	@XmlElement(name="idAcceso")
	public void setIdAcceso(BigDecimal idAcceso){
		this.idAcceso = idAcceso;
	}
	
	@XmlElement(name="nombre")
	public String getNombre(){
		return this.nombre;
	}
	
	@XmlElement(name="nombre")
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
		
	@XmlElement(name="componente")
	public String getComponente(){
		return this.componente;
	}
	
	@XmlElement(name="componente")
	public void setComponente(String componente){
		this.componente = componente;
	}
		
	@XmlElement(name="descripcion")
	public String getDescripcion(){
		return this.descripcion;
	}
	
	@XmlElement(name="descripcion")
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idAcceso);        
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.componente);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
  
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasAccesosDTO que se pasa
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
        final FasAccesosDTO other = (FasAccesosDTO) obj;
                
        if (!Objects.equals(this.idAcceso, other.idAcceso)) {
            return false;
        }
        
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        
        if (!Objects.equals(this.componente, other.componente)) {
            return false;
        }
        
        return Objects.equals(this.descripcion, other.descripcion);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

