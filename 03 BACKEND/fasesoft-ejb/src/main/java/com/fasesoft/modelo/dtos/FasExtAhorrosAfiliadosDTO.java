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
public class FasExtAhorrosAfiliadosDTO implements Serializable{	
	
	private String correo;
	
	private String nombre; 
	
	private String apellido;
	
	private BigDecimal telefono;
	
	private String direccion; 
	
	private BigDecimal identificacion; 
	
	private String cuentaBancaria; 
	
	private Date fechaIngreso; 
	
	private BigDecimal beneficio;
	
	private Date fechaAporte;
	
	private BigDecimal monto;
	
	private BigDecimal aporte;
	
	private BigDecimal ahorroPermanente;
	
	private BigDecimal aporteOrdinario; 
	
	private BigDecimal ahorroPermanenteAporte;
	
	private BigDecimal aporteOrdinarioAporte; 
	
	private String tipo;
	
	
	
	
	
	
	
	
	
	
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasExtAhorrosAfiliadosDTO(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }
    
   

	public FasExtAhorrosAfiliadosDTO(String correo, String nombre, String apellido, BigDecimal telefono,
			String direccion, BigDecimal identificacion, String cuentaBancaria, Date fechaIngreso, BigDecimal beneficio,
			Date fechaAporte, BigDecimal monto, BigDecimal aporte, BigDecimal ahorroPermanente,
			BigDecimal aporteOrdinario, BigDecimal ahorroPermanenteAporte, BigDecimal aporteOrdinarioAporte,
			String tipo) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.identificacion = identificacion;
		this.cuentaBancaria = cuentaBancaria;
		this.fechaIngreso = fechaIngreso;
		this.beneficio = beneficio;
		this.fechaAporte = fechaAporte;
		this.monto = monto;
		this.aporte = aporte;
		this.ahorroPermanente = ahorroPermanente;
		this.aporteOrdinario = aporteOrdinario;
		this.ahorroPermanenteAporte = ahorroPermanenteAporte;
		this.aporteOrdinarioAporte = aporteOrdinarioAporte;
		this.tipo = tipo;
	}



	@XmlElement(name="correo")
    public String getCorreo() {
		return correo;
	}

    @XmlElement(name="correo")
	public void setCorreo(String correo) {
		this.correo = correo;
	}

    @XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}

    @XmlElement(name="nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    @XmlElement(name="apellido")
	public String getApellido() {
		return apellido;
	}

    @XmlElement(name="apellido")
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

    @XmlElement(name="telefono")
	public BigDecimal getTelefono() {
		return telefono;
	}

    @XmlElement(name="telefono")
	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

    @XmlElement(name="direccion")
	public String getDireccion() {
		return direccion;
	}

    @XmlElement(name="direccion")
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

    @XmlElement(name="identificacion")
	public BigDecimal getIdentificacion() {
		return identificacion;
	}

    @XmlElement(name="identificacion")
	public void setIdentificacion(BigDecimal identificacion) {
		this.identificacion = identificacion;
	}

    @XmlElement(name="cuentaBancaria")
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

    @XmlElement(name="cuentaBancaria")
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

    @XmlElement(name="fechaIngreso")
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

    @XmlElement(name="fechaIngreso")
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
	
	@XmlElement(name="ahorroPermanente")
    public BigDecimal getAhorroPermanente() {
		return ahorroPermanente;
	}

    @XmlElement(name="ahorroPermanente")
	public void setAhorroPermanente(BigDecimal ahorroPermanente) {
		this.ahorroPermanente = ahorroPermanente;
	}

    @XmlElement(name="aporteOrdinario")
	public BigDecimal getAporteOrdinario() {
		return aporteOrdinario;
	}

    @XmlElement(name="aporteOrdinario")
	public void setAporteOrdinario(BigDecimal aporteOrdinario) {
		this.aporteOrdinario = aporteOrdinario;
	}


	@XmlElement(name="fechaAporte")
	public Date getFechaAporte() {
		return fechaAporte;
	}

    @XmlElement(name="fechaAporte")
	public void setFechaAporte(Date fechaAporte) {
		this.fechaAporte = fechaAporte;
	}
    
    @XmlElement(name="ahorroPermanenteAporte")
	public BigDecimal getAhorroPermanenteAporte() {
		return ahorroPermanenteAporte;
	}
    
    @XmlElement(name="ahorroPermanenteAporte")
	public void setAhorroPermanenteAporte(BigDecimal ahorroPermanenteAporte) {
		this.ahorroPermanenteAporte = ahorroPermanenteAporte;
	}
    @XmlElement(name="aporteOrdinarioAporte")
	public BigDecimal getAporteOrdinarioAporte() {
		return aporteOrdinarioAporte;
	}
    
    @XmlElement(name="aporteOrdinarioAporte")
	public void setAporteOrdinarioAporte(BigDecimal aporteOrdinarioAporte) {
		this.aporteOrdinarioAporte = aporteOrdinarioAporte;
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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((aporte == null) ? 0 : aporte.hashCode());
		result = prime * result + ((beneficio == null) ? 0 : beneficio.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((cuentaBancaria == null) ? 0 : cuentaBancaria.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((fechaAporte == null) ? 0 : fechaAporte.hashCode());
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		FasExtAhorrosAfiliadosDTO other = (FasExtAhorrosAfiliadosDTO) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
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
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (cuentaBancaria == null) {
			if (other.cuentaBancaria != null)
				return false;
		} else if (!cuentaBancaria.equals(other.cuentaBancaria))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (fechaAporte == null) {
			if (other.fechaAporte != null)
				return false;
		} else if (!fechaAporte.equals(other.fechaAporte))
			return false;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
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

