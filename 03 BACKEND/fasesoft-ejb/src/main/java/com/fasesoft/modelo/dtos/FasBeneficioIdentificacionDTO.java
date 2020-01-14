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
public class FasBeneficioIdentificacionDTO implements Serializable{	


	private BigDecimal identificacion;
	
	private BigDecimal calculoBeneficio;
	
	private Date fechaAporte;
	

	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasBeneficioIdentificacionDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }
    
    

		
	



	public FasBeneficioIdentificacionDTO(BigDecimal identificacion, BigDecimal calculoBeneficio, Date fechaAporte) {
		super();
		this.identificacion = identificacion;
		this.calculoBeneficio = calculoBeneficio;
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
	
	


	@XmlElement(name="calculoBeneficio")
	public BigDecimal getCalculoBeneficio() {
		return calculoBeneficio;
	}


	@XmlElement(name="calculoBeneficio")
	public void setCalculoBeneficio(BigDecimal calculoBeneficio) {
		this.calculoBeneficio = calculoBeneficio;
	}


	@XmlElement(name="fechaAporte")
	public Date getFechaAporte() {
		return fechaAporte;
	}


	@XmlElement(name="fechaAporte")
	public void setFechaAporte(Date fechaAporte) {
		this.fechaAporte = fechaAporte;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calculoBeneficio == null) ? 0 : calculoBeneficio.hashCode());
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
		FasBeneficioIdentificacionDTO other = (FasBeneficioIdentificacionDTO) obj;
		if (calculoBeneficio == null) {
			if (other.calculoBeneficio != null)
				return false;
		} else if (!calculoBeneficio.equals(other.calculoBeneficio))
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



	/**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
   

	
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

