package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * DAO que contiene la información de la entidad FasSolConveniosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasSolConveniosDTO implements Serializable{	

	private Integer idSolicitud;

	private String fasAfiliadosCorreo;
	
	private BigDecimal fasConveniosIdConvenio;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasSolConveniosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	
	@XmlElement(name="idSolicitud")
	public Integer getIdSolicitud(){
		return this.idSolicitud;
	}
	
	@XmlElement(name="idSolicitud")
	public void setIdSolicitud(Integer idSolicitud){
		this.idSolicitud = idSolicitud;
	}
	
	@XmlElement(name="fasAfiliadosCorreo")
	public String getFasAfiliadosCorreo(){
		return this.fasAfiliadosCorreo;
	}
	
	@XmlElement(name="fasAfiliadosCorreo")
	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo){
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}
		
	@XmlElement(name="fasConveniosIdConvenio")
	public BigDecimal getFasConveniosIdConvenio(){
		return this.fasConveniosIdConvenio;
	}
	
	@XmlElement(name="fasConveniosIdConvenio")
	public void setFasConveniosIdConvenio(BigDecimal fasConveniosIdConvenio){
		this.fasConveniosIdConvenio = fasConveniosIdConvenio;
	}
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idSolicitud);        
        hash = 37 * hash + Objects.hashCode(this.fasAfiliadosCorreo);
        hash = 37 * hash + Objects.hashCode(this.fasConveniosIdConvenio);
  
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasSolConveniosDTO que se pasa
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
        final FasSolConveniosDTO other = (FasSolConveniosDTO) obj;
                
        if (!Objects.equals(this.idSolicitud, other.idSolicitud)) {
            return false;
        }
        
        if (!Objects.equals(this.fasAfiliadosCorreo, other.fasAfiliadosCorreo)) {
            return false;
        }
        
        return Objects.equals(this.fasConveniosIdConvenio, other.fasConveniosIdConvenio);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

