package com.fasesoft.modelo.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

public class FasParametrosDTO {

	private BigDecimal codigo;
	
	private String descripcion;

	private String valor;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasParametrosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }
    
    

	public FasParametrosDTO(BigDecimal codigo, String descripcion, String valor) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.valor = valor;
	}



	@XmlElement(name="codigo")
	public BigDecimal getCodigo(){
		return this.codigo;
	}
	
	@XmlElement(name="codigo")
	public void setCodigo(BigDecimal cuotaTotal){
		this.codigo = cuotaTotal;
	}
		
		
	@XmlElement(name="valor")
	public String getValor(){
		return this.valor;
	}
	
	@XmlElement(name="valor")
	public void setValor(String valor){
		this.valor = valor;
	}
		
	@XmlElement(name="descripcion")
	public String getDescripcion(){
		return this.descripcion;
	}
	
	@XmlElement(name="descripcion")
	public void setDescripcion(String valor){
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		FasParametrosDTO other = (FasParametrosDTO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	

	
}
