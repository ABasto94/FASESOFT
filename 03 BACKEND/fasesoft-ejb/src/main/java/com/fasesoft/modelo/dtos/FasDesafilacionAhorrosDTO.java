package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DAO que contiene la información de la entidad FasAhorrosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasDesafilacionAhorrosDTO implements Serializable{	

	private BigDecimal monto;
	
	private String fasAfiliadosCorreo;
	
	private String tipo;
	
	
	
	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasDesafilacionAhorrosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }
    
	
	

	
	





	public FasDesafilacionAhorrosDTO(BigDecimal monto, String fasAfiliadosCorreo, String tipo) {
		super();
		this.monto = monto;
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
		this.tipo = tipo;
	}











	@XmlElement(name="monto")
	public BigDecimal getMonto(){
		return this.monto;
	}
	
	@XmlElement(name="monto")
	public void setMonto(BigDecimal monto){
		this.monto = monto;
	}

		
	@XmlElement(name="tipo")
	public String getTipo() {
		return tipo;
	}

	@XmlElement(name="tipo")
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
		
	@XmlElement(name="fasAfiliadosCorreo")
    public String getFasAfiliadosCorreo() {
		return fasAfiliadosCorreo;
	}




	@XmlElement(name="fasAfiliadosCorreo")
	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo) {
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fasAfiliadosCorreo == null) ? 0 : fasAfiliadosCorreo.hashCode());
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FasDesafilacionAhorrosDTO other = (FasDesafilacionAhorrosDTO) obj;
		if (fasAfiliadosCorreo == null) {
			if (other.fasAfiliadosCorreo != null)
				return false;
		} else if (!fasAfiliadosCorreo.equals(other.fasAfiliadosCorreo))
			return false;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

