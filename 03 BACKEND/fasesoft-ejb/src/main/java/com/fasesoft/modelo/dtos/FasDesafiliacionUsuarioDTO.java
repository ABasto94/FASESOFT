package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class FasDesafiliacionUsuarioDTO implements Serializable{
private BigDecimal saldo;
	
	private String tipoAhorro;
	
	private String estado;
	
	private BigDecimal monto;
	
	private String tipoCredito;

	
	public FasDesafiliacionUsuarioDTO() {
		super();
	}


	public FasDesafiliacionUsuarioDTO(BigDecimal saldo, String tipoAhorro, String estado, BigDecimal monto,
			String tipoCredito) {
		super();
		this.saldo = saldo;
		this.tipoAhorro = tipoAhorro;
		this.estado = estado;
		this.monto = monto;
		this.tipoCredito = tipoCredito;
	}


	@XmlElement(name="saldo")
	public BigDecimal getSaldo() {
		return saldo;
	}


	@XmlElement(name="saldo")
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}


	@XmlElement(name="tipoAhorro")
	public String getTipoAhorro() {
		return tipoAhorro;
	}


	@XmlElement(name="tipoAhorro")
	public void setTipoAhorro(String tipoAhorro) {
		this.tipoAhorro = tipoAhorro;
	}


	@XmlElement(name="estado")
	public String getEstado() {
		return estado;
	}

	@XmlElement(name="estado")
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@XmlElement(name="monto")
	public BigDecimal getMonto() {
		return monto;
	}


	@XmlElement(name="monto")
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	@XmlElement(name="tipoCredito")
	public String getTipoCredito() {
		return tipoCredito;
	}



	@XmlElement(name="tipoCredito")
	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime * result + ((tipoAhorro == null) ? 0 : tipoAhorro.hashCode());
		result = prime * result + ((tipoCredito == null) ? 0 : tipoCredito.hashCode());
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
		FasDesafiliacionUsuarioDTO other = (FasDesafiliacionUsuarioDTO) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (tipoAhorro == null) {
			if (other.tipoAhorro != null)
				return false;
		} else if (!tipoAhorro.equals(other.tipoAhorro))
			return false;
		if (tipoCredito == null) {
			if (other.tipoCredito != null)
				return false;
		} else if (!tipoCredito.equals(other.tipoCredito))
			return false;
		return true;
	}
	
	
	
	
	

}
