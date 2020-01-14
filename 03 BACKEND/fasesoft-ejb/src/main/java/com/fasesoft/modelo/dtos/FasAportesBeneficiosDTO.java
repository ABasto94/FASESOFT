package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DAO que contiene la información de la entidad FasAfiliadosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasAportesBeneficiosDTO implements Serializable{	


	private BigDecimal identificacion;
	
	private BigDecimal aporte;
	
	private BigDecimal beneficio;
	
	private Date fechaAporte;
	

	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasAportesBeneficiosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }
    
    

		
	public FasAportesBeneficiosDTO(BigDecimal identificacion, BigDecimal aporte, BigDecimal beneficio,
			Date fechaAporte) {
		super();
		this.identificacion = identificacion;
		this.aporte = aporte;
		this.beneficio = beneficio;
		this.fechaAporte = fechaAporte;
	}




	@XmlElement(name="identificacion")
	public BigDecimal getIdentificacion(){
		return this.identificacion;
	}
	
	@XmlElement(name="identificacion")
	public void setIdentificacion(BigDecimal identificacion){
		this.identificacion = identificacion;
	}
	
	@XmlElement(name="aporte")
    public BigDecimal getAporte() {
		return aporte;
	}


	@XmlElement(name="aporte")
	public void setAporte(BigDecimal aporte) {
		this.aporte = aporte;
	}


	@XmlElement(name="beneficio")
	public BigDecimal getBeneficio() {
		return beneficio;
	}


	@XmlElement(name="beneficio")
	public void setBeneficio(BigDecimal beneficio) {
		this.beneficio = beneficio;
	}


	@XmlElement(name="fechaAporte")
	public Date getFechaAporte() {
		return fechaAporte;
	}


	@XmlElement(name="fechaAporte")
	public void setFechaAporte(Date fechaAporte) {
		this.fechaAporte = fechaAporte;
	}



	/**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
   

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aporte == null) ? 0 : aporte.hashCode());
		result = prime * result + ((beneficio == null) ? 0 : beneficio.hashCode());
		result = prime * result + ((fechaAporte == null) ? 0 : fechaAporte.hashCode());
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
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
		FasAportesBeneficiosDTO other = (FasAportesBeneficiosDTO) obj;
		if (aporte == null) {
			if (other.aporte != null)
				return false;
		} else if (!aporte.equals(other.aporte))
			return false;
		if (beneficio == null) {
			if (other.beneficio != null)
				return false;
		} else if (!beneficio.equals(other.beneficio))
			return false;
		if (fechaAporte == null) {
			if (other.fechaAporte != null)
				return false;
		} else if (!fechaAporte.equals(other.fechaAporte))
			return false;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

