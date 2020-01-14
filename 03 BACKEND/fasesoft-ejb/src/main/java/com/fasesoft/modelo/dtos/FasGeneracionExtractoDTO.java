package com.fasesoft.modelo.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;
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
public class FasGeneracionExtractoDTO implements Serializable{	

	private FasExtAhorrosAfiliadosDTO ahorroAfiliado;
	
	private List<FasExtAhorrosVoluntariosDTO> ahorroVoluntario;
	
	private List<FasCreditosPagosTipoDTO> creditos; 
	
	private List<FasConveniosTiposPagosDTO> convenios; 
	
	private double saldoOtroAhorros;
	
	private double saldoCreditos;
	
	private double saldoConvenios; 
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasGeneracionExtractoDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }

    
	
    @XmlElement(name="ahorroAfiliado")
    public FasExtAhorrosAfiliadosDTO getAhorroAfiliado() {
		return ahorroAfiliado;
	}

    @XmlElement(name="ahorroAfiliado")
	public void setAhorroAfiliado(FasExtAhorrosAfiliadosDTO ahorroAfiliado) {
		this.ahorroAfiliado = ahorroAfiliado;
	}

	@XmlElement(name="ahorroVoluntario")
	public List<FasExtAhorrosVoluntariosDTO> getAhorroVoluntario() {
		return ahorroVoluntario;
	}

    @XmlElement(name="ahorroVoluntario")
	public void setAhorroVoluntario(List<FasExtAhorrosVoluntariosDTO> ahorroVoluntario) {
		this.ahorroVoluntario = ahorroVoluntario;
	}

    @XmlElement(name="creditos")
	public List<FasCreditosPagosTipoDTO> getCreditos() {
		return creditos;
	}

    @XmlElement(name="creditos")
	public void setCreditos(List<FasCreditosPagosTipoDTO> creditos) {
		this.creditos = creditos;
	}

    @XmlElement(name="convenios")
	public List<FasConveniosTiposPagosDTO> getConvenios() {
		return convenios;
	}

    @XmlElement(name="convenios")
	public void setConvenios(List<FasConveniosTiposPagosDTO> convenios) {
		this.convenios = convenios;
	}


    @XmlElement(name="saldoOtroAhorros")
	public double getSaldoOtroAhorros() {
		return saldoOtroAhorros;
	}


    @XmlElement(name="saldoOtroAhorros")
	public void setSaldoOtroAhorros(double saldoOtroAhorros) {
		this.saldoOtroAhorros = saldoOtroAhorros;
	}


    @XmlElement(name="saldoCreditos")
	public double getSaldoCreditos() {
		return saldoCreditos;
	}


    @XmlElement(name="saldoCreditos")
	public void setSaldoCreditos(double saldoCreditos) {
		this.saldoCreditos = saldoCreditos;
	}


    @XmlElement(name="saldoConvenios")
	public double getSaldoConvenios() {
		return saldoConvenios;
	}


    @XmlElement(name="saldoConvenios")
	public void setSaldoConvenios(double saldoConvenios) {
		this.saldoConvenios = saldoConvenios;
	}
    
    
    


	
	
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

