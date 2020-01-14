package com.fasesoft.modelo.dtos;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class FasSolicitudesAfiliacionDTO {
	
	private String correo;
	
	private String nombres;
	
	private BigDecimal aporte;
		
	private BigDecimal telefono;
	
	private String estado;

	private BigDecimal idUsuario;
	
	private String contraseña;
	
	private String fechaCreacion;
	
	

	public FasSolicitudesAfiliacionDTO(
			String correo, 
			String nombres, 
			BigDecimal aporte, 
			BigDecimal telefono,
			String estado, 
			BigDecimal idUsuario, 
			String contraseña, 
			String fechaCreacion
		) {
		super();
		this.correo = correo;
		this.nombres = nombres;
		this.aporte = aporte;
		this.telefono = telefono;
		this.estado = estado;
		this.idUsuario = idUsuario;
		this.contraseña = contraseña;
		this.fechaCreacion = fechaCreacion;
	}


	public FasSolicitudesAfiliacionDTO() {
		super();
	}


	@XmlElement(name = "correo")
	public String getCorreo() {
		return correo;
	}


	@XmlElement(name = "correo")
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@XmlElement(name = "nombres")
	public String getNombres() {
		return nombres;
	}


	@XmlElement(name = "nombres")
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	@XmlElement(name = "aporte")
	public BigDecimal getAporte() {
		return aporte;
	}


	@XmlElement(name = "aporte")
	public void setAporte(BigDecimal aporte) {
		this.aporte = aporte;
	}


	@XmlElement(name = "telefono")
	public BigDecimal getTelefono() {
		return telefono;
	}


	@XmlElement(name = "telefono")
	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}


	@XmlElement(name = "estado")
	public String getEstado() {
		return estado;
	}


	@XmlElement(name = "estado")
	public void setEstado(String estado) {
		this.estado = estado;
	}


	@XmlElement(name = "idUsuario")
	public BigDecimal getIdUsuario() {
		return idUsuario;
	}


	@XmlElement(name = "idUsuario")
	public void setIdUsuario(BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}


	@XmlElement(name = "contraseña")
	public String getContraseña() {
		return contraseña;
	}


	@XmlElement(name = "contraseña")
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	@XmlElement(name = "fechaCreacion")
	public String getFechaCreacion() {
		return fechaCreacion;
	}


	@XmlElement(name = "fechaCreacion")
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aporte == null) ? 0 : aporte.hashCode());
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		FasSolicitudesAfiliacionDTO other = (FasSolicitudesAfiliacionDTO) obj;
		if (aporte == null) {
			if (other.aporte != null)
				return false;
		} else if (!aporte.equals(other.aporte))
			return false;
		if (contraseña == null) {
			if (other.contraseña != null)
				return false;
		} else if (!contraseña.equals(other.contraseña))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	
}
