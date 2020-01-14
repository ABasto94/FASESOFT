package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DAO que contiene la información de la entidad FasExtractosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasExtractosDTO implements Serializable{	

	private BigDecimal idExtracto;

	private String urlExtracto;
	
	private String nombreExtracto;
	
	private Date fechaExtracto;
	
	private String fasAfiliadosCorreo;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasExtractosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	
	@XmlElement(name="idExtracto")
	public BigDecimal getIdExtracto(){
		return this.idExtracto;
	}
	
	@XmlElement(name="idExtracto")
	public void setIdExtracto(BigDecimal idExtracto){
		this.idExtracto = idExtracto;
	}
	
	@XmlElement(name="urlExtracto")
	public String getUrlExtracto(){
		return this.urlExtracto;
	}
	
	@XmlElement(name="urlExtracto")
	public void setUrlExtracto(String urlExtracto){
		this.urlExtracto = urlExtracto;
	}
		
	@XmlElement(name="nombreExtracto")
	public String getNombreExtracto(){
		return this.nombreExtracto;
	}
	
	@XmlElement(name="nombreExtracto")
	public void setNombreExtracto(String nombreExtracto){
		this.nombreExtracto = nombreExtracto;
	}
		
	@XmlElement(name="fechaExtracto")
	public Date getFechaExtracto(){
		return this.fechaExtracto;
	}
	
	@XmlElement(name="fechaExtracto")
	public void setFechaExtracto(Date fechaExtracto){
		this.fechaExtracto = fechaExtracto;
	}
		
	@XmlElement(name="fasAfiliadosCorreo")
	public String getFasAfiliadosCorreo(){
		return this.fasAfiliadosCorreo;
	}
	
	@XmlElement(name="fasAfiliadosCorreo")
	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo){
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idExtracto);        
        hash = 37 * hash + Objects.hashCode(this.urlExtracto);
        hash = 37 * hash + Objects.hashCode(this.nombreExtracto);
        hash = 37 * hash + Objects.hashCode(this.fechaExtracto);
        hash = 37 * hash + Objects.hashCode(this.fasAfiliadosCorreo);
  
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasExtractosDTO que se pasa
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
        final FasExtractosDTO other = (FasExtractosDTO) obj;
                
        if (!Objects.equals(this.idExtracto, other.idExtracto)) {
            return false;
        }
        
        if (!Objects.equals(this.urlExtracto, other.urlExtracto)) {
            return false;
        }
        
        if (!Objects.equals(this.nombreExtracto, other.nombreExtracto)) {
            return false;
        }
        
        if (!Objects.equals(this.fechaExtracto, other.fechaExtracto)) {
            return false;
        }
        
        return Objects.equals(this.fasAfiliadosCorreo, other.fasAfiliadosCorreo);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

