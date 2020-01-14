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
public class FasDesafilacionCreditosDTO implements Serializable{	

	private BigDecimal saldo;
	
	private String tipo;
	
	private String estado;
	
	private String fasAfiliadosCorreo;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasDesafilacionCreditosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }

    
  

	public FasDesafilacionCreditosDTO(BigDecimal saldo, String tipo, String estado, String fasAfiliadosCorreo) {
		super();
		this.saldo = saldo;
		this.tipo = tipo;
		this.estado = estado;
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}









	@XmlElement(name="saldo")
	public BigDecimal getSaldo() {
		return saldo;
	}

    @XmlElement(name="saldo")
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	
	@XmlElement(name="tipo")
	public String getTipo() {
		return tipo;
	}

	@XmlElement(name="tipo")
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@XmlElement(name="estado")
	public String getEstado(){
		return this.estado;
	}
	
	@XmlElement(name="estado")
	public void setEstado(String estado){
		this.estado = estado;
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
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fasAfiliadosCorreo == null) ? 0 : fasAfiliadosCorreo.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
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
		FasDesafilacionCreditosDTO other = (FasDesafilacionCreditosDTO) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fasAfiliadosCorreo == null) {
			if (other.fasAfiliadosCorreo != null)
				return false;
		} else if (!fasAfiliadosCorreo.equals(other.fasAfiliadosCorreo))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
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

