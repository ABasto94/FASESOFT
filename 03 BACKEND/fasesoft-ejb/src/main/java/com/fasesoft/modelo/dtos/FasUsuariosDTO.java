package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DAO que contiene la información de la entidad FasUsuariosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasUsuariosDTO implements Serializable{	

	private Integer idUsuario;

	private String contrasena;
	
	private String estado;
	
	private Date fechaCracion;
	
	private String fasAfiliadosCorreo;
	
	private String motRechazo;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasUsuariosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }

    

	
	@XmlElement(name="idUsuario")
	public Integer getIdUsuario(){
		return this.idUsuario;
	}
	
	@XmlElement(name="idUsuario")
	public void setIdUsuario(Integer idUsuario){
		this.idUsuario = idUsuario;
	}
	
	@XmlElement(name="contraseña")
	public String getContrasena(){
		return this.contrasena;
	}
	
	@XmlElement(name="contraseña")
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}
		
	@XmlElement(name="estado")
	public String getEstado(){
		return this.estado;
	}
	
	@XmlElement(name="estado")
	public void setEstado(String estado){
		this.estado = estado;
	}
		
	@XmlElement(name="fechaCracion")
	public Date getFechaCracion(){
		return this.fechaCracion;
	}
	
	@XmlElement(name="fechaCracion")
	public void setFechaCracion(Date fechaCracion){
		this.fechaCracion = fechaCracion;
	}
		
	@XmlElement(name="fasAfiliadosCorreo")
	public String getFasAfiliadosCorreo(){
		return this.fasAfiliadosCorreo;
	}
	
	@XmlElement(name="fasAfiliadosCorreo")
	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo){
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}
	
	@XmlElement(name="motRechazo")
	public String getMotRechazo(){
		return this.motRechazo;
	}
	
	@XmlElement(name="motRechazo")
	public void setMotRechazo(String motRechazo){
		this.motRechazo = motRechazo;
	}
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idUsuario);        
        hash = 37 * hash + Objects.hashCode(this.contrasena);
        hash = 37 * hash + Objects.hashCode(this.estado);
        hash = 37 * hash + Objects.hashCode(this.fechaCracion);
        hash = 37 * hash + Objects.hashCode(this.fasAfiliadosCorreo);
        hash = 37 * hash + Objects.hashCode(this.motRechazo);
  
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasUsuariosDTO que se pasa
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
        final FasUsuariosDTO other = (FasUsuariosDTO) obj;
                
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
                
        if (!Objects.equals(this.fechaCracion, other.fechaCracion)) {
            return false;
        }
        if (!Objects.equals(this.motRechazo, other.motRechazo)) {
            return false;
        }
        return Objects.equals(this.fasAfiliadosCorreo, other.fasAfiliadosCorreo);
        

                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

