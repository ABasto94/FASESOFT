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
public class FasAhorrosDTO implements Serializable{	

	private Number idAhorro;

	private BigDecimal monto;
	
	private Date fechaInicio;
	
	private String estado;
	
	private BigDecimal aporte;
	
	private String fasAfiliadosCorreo;
	
	private BigDecimal fasTiposAhoIdTipoAho;
	
	private Date fechaSolicitud;
	
	private Date fechaInicioAporte;
	
	private BigDecimal codAhorro;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasAhorrosDTO(){
 // protected region procedimientos adicionales de inicialización on begin
 // Escriba en esta sección sus modificaciones

 // protected region procedimientos adicionales de inicialización end
    }
    
    
    
	public FasAhorrosDTO(BigDecimal aporte) {
		
		
		this.aporte = aporte;
	}




	/**
	 * @param idAhorro
	 * @param monto
	 * @param fechaInicio
	 * @param estado
	 * @param aporte
	 * @param fasAfiliadosCorreo
	 * @param fasTiposAhoIdTipoAho
	 * @param fechaSolicitud
	 * @param fechaInicioAporte
	 */
	



	@XmlElement(name="idAhorro")
	public Number getIdAhorro(){
		return this.idAhorro;
	}
	
	/**
	 * @param idAhorro
	 * @param monto
	 * @param fechaInicio
	 * @param estado
	 * @param aporte
	 * @param fasAfiliadosCorreo
	 * @param fasTiposAhoIdTipoAho
	 * @param fechaSolicitud
	 * @param fechaInicioAporte
	 */
	public FasAhorrosDTO(Number idAhorro, BigDecimal monto, Date fechaInicio, String estado, BigDecimal aporte,
			String fasAfiliadosCorreo, BigDecimal fasTiposAhoIdTipoAho, Date fechaSolicitud, Date fechaInicioAporte) {
		this.idAhorro = idAhorro;
		this.monto = monto;
		this.fechaInicio = fechaInicio;
		this.estado = estado;
		this.aporte = aporte;
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
		this.fasTiposAhoIdTipoAho = fasTiposAhoIdTipoAho;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicioAporte = fechaInicioAporte;
	}
	
	public FasAhorrosDTO(BigDecimal monto, Date fechaInicio, String estado, BigDecimal aporte,
			String fasAfiliadosCorreo, BigDecimal fasTiposAhoIdTipoAho, Date fechaSolicitud, Date fechaInicioAporte) {

		this.monto = monto;
		this.fechaInicio = fechaInicio;
		this.estado = estado;
		this.aporte = aporte;
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
		this.fasTiposAhoIdTipoAho = fasTiposAhoIdTipoAho;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicioAporte = fechaInicioAporte;
	}
	



	public FasAhorrosDTO(BigDecimal monto, Date fechaInicio, String estado, BigDecimal aporte,
			String fasAfiliadosCorreo, Date fechaInicioAporte) {
		
		this.monto = monto;
		this.fechaInicio = fechaInicio;
		this.estado = estado;
		this.aporte = aporte;
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
		this.fechaInicioAporte = fechaInicioAporte;
	}



	/**
	 * @param idAhorro
	 * @param monto
	 * @param fechaInicio
	 * @param estado
	 * @param aporte
	 * @param fasAfiliadosCorreo
	 * @param fasTiposAhoIdTipoAho
	 * @param fechaSolicitud
	 * @param fechaInicioAporte
	 */




	@XmlElement(name="idAhorro")
	public void setIdAhorro(Number idAhorro){
		this.idAhorro = idAhorro;
	}
	
	@XmlElement(name="monto")
	public BigDecimal getMonto(){
		return this.monto;
	}
	
	@XmlElement(name="monto")
	public void setMonto(BigDecimal monto){
		this.monto = monto;
	}
		
	@XmlElement(name="fechaInicio")
	public Date getFechaInicio(){
		return this.fechaInicio;
	}
	
	@XmlElement(name="fechaInicio")
	public void setFechaInicio(Date fechaInicio){
		this.fechaInicio = fechaInicio;
	}
		
	@XmlElement(name="estado")
	public String getEstado(){
		return this.estado;
	}
	
	@XmlElement(name="estado")
	public void setEstado(String estado){
		this.estado = estado;
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
		
	@XmlElement(name="fasTiposAhoIdTipoAho")
	public BigDecimal getFasTiposAhoIdTipoAho(){
		return this.fasTiposAhoIdTipoAho;
	}
	
	@XmlElement(name="fasTiposAhoIdTipoAho")
	public void setFasTiposAhoIdTipoAho(BigDecimal fasTiposAhoIdTipoAho){
		this.fasTiposAhoIdTipoAho = fasTiposAhoIdTipoAho;
	}
		
	@XmlElement(name="fechaSolicitud")
	public Date getFechaSolicitud(){
		return this.fechaSolicitud;
	}
	
	@XmlElement(name="fechaSolicitud")
	public void setFechaSolicitud(Date fechaSolicitud){
		this.fechaSolicitud = fechaSolicitud;
	}
		
	@XmlElement(name="fechaInicioAporte")
	public Date getFechaInicioAporte(){
		return this.fechaInicioAporte;
	}
	
	@XmlElement(name="fechaInicioAporte")
	public void setFechaInicioAporte(Date fechaInicioAporte){
		this.fechaInicioAporte = fechaInicioAporte;
	}
	
		
	@XmlElement(name="codAhorro")
    public BigDecimal getCodAhorro() {
		return codAhorro;
	}


	@XmlElement(name="codAhorro")
	public void setCodAhorro(BigDecimal codAhorro) {
		this.codAhorro = codAhorro;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aporte == null) ? 0 : aporte.hashCode());
		result = prime * result + ((codAhorro == null) ? 0 : codAhorro.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fasAfiliadosCorreo == null) ? 0 : fasAfiliadosCorreo.hashCode());
		result = prime * result + ((fasTiposAhoIdTipoAho == null) ? 0 : fasTiposAhoIdTipoAho.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((fechaInicioAporte == null) ? 0 : fechaInicioAporte.hashCode());
		result = prime * result + ((fechaSolicitud == null) ? 0 : fechaSolicitud.hashCode());
		result = prime * result + ((idAhorro == null) ? 0 : idAhorro.hashCode());
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
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
		FasAhorrosDTO other = (FasAhorrosDTO) obj;
		if (aporte == null) {
			if (other.aporte != null)
				return false;
		} else if (!aporte.equals(other.aporte))
			return false;
		if (codAhorro == null) {
			if (other.codAhorro != null)
				return false;
		} else if (!codAhorro.equals(other.codAhorro))
			return false;
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
		if (fasTiposAhoIdTipoAho == null) {
			if (other.fasTiposAhoIdTipoAho != null)
				return false;
		} else if (!fasTiposAhoIdTipoAho.equals(other.fasTiposAhoIdTipoAho))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (fechaInicioAporte == null) {
			if (other.fechaInicioAporte != null)
				return false;
		} else if (!fechaInicioAporte.equals(other.fechaInicioAporte))
			return false;
		if (fechaSolicitud == null) {
			if (other.fechaSolicitud != null)
				return false;
		} else if (!fechaSolicitud.equals(other.fechaSolicitud))
			return false;
		if (idAhorro == null) {
			if (other.idAhorro != null)
				return false;
		} else if (!idAhorro.equals(other.idAhorro))
			return false;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
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

