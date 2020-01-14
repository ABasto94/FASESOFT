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
public class FasExtAhorrosVoluntariosDTO implements Serializable{	

	
	
	private BigDecimal beneficio;
	
	private Date fechaAporte;
	
	private BigDecimal monto;
	
	private BigDecimal aporte;
	
	private String fasAfiliadosCorreo;
	
	private String tipo;
	
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasExtAhorrosVoluntariosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }
    
    
    
   



	public FasExtAhorrosVoluntariosDTO(BigDecimal beneficio, Date fechaAporte, BigDecimal monto, BigDecimal aporte,
			String fasAfiliadosCorreo, String tipo) {
		super();
		this.beneficio = beneficio;
		this.fechaAporte = fechaAporte;
		this.monto = monto;
		this.aporte = aporte;
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
		this.tipo = tipo;
	}







	@XmlElement(name="tipo")
	public String getTipo() {
		return tipo;
	}

    @XmlElement(name="tipo")
	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	@XmlElement(name="monto")
	public BigDecimal getMonto(){
		return this.monto;
	}
	
	@XmlElement(name="monto")
	public void setMonto(BigDecimal monto){
		this.monto = monto;
	}
	
	@XmlElement(name="aporte")
	public BigDecimal getAporte(){
		return this.aporte;
	}
	
	@XmlElement(name="aporte")
	public void setAporte(BigDecimal aporte){
		this.aporte = aporte;
	}
		
	@XmlElement(name="fasAfiliadosCorreo")
	public String getFasAfiliadosCorreo(){
		return this.fasAfiliadosCorreo;
	}
	
	@XmlElement(name="fasAfiliadosCorreo")
	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo){
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aporte == null) ? 0 : aporte.hashCode());
		result = prime * result + ((beneficio == null) ? 0 : beneficio.hashCode());
		result = prime * result + ((fasAfiliadosCorreo == null) ? 0 : fasAfiliadosCorreo.hashCode());
		result = prime * result + ((fechaAporte == null) ? 0 : fechaAporte.hashCode());
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
		FasExtAhorrosVoluntariosDTO other = (FasExtAhorrosVoluntariosDTO) obj;
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
		if (fasAfiliadosCorreo == null) {
			if (other.fasAfiliadosCorreo != null)
				return false;
		} else if (!fasAfiliadosCorreo.equals(other.fasAfiliadosCorreo))
			return false;
		if (fechaAporte == null) {
			if (other.fechaAporte != null)
				return false;
		} else if (!fechaAporte.equals(other.fechaAporte))
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
		
	
	
	
	
		
	
    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

