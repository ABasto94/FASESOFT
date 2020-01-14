package com.fasesoft.modelo.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DAO que contiene la información de la entidad FasAfiliadosDTO que se
 * transmite por los servicios REST. Solo se transmiten los atributos simples,
 * es decir, se omiten aquellos atributos que definen relaciones con otras
 * entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasAfiliadosDTO implements Serializable {

	private String correo;

	private String nombre;

	private String apellido;

	private BigDecimal telefono;

	private String direccion;

	private BigDecimal identificacion;

	private String tipoId;

	private Date fechaRetiro;

	private Date fechaIngreso;

	private String cuentaBancaria;

	private BigDecimal totalOtrosAhorros;

	private String banco;

	private String expedicion;

	private String ciudad;

	private String dependencia;

	private String estadoCivil;
	

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	public FasAfiliadosDTO() {
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
	}
	
	public FasAfiliadosDTO(
			String correo, 
			String nombre, 
			String apellido, 
			BigDecimal telefono,
			String direccion,
			BigDecimal identificacion,
			String tipoId,
			Date fechaRetiro,
			Date fechaIngreso,
			String cuentaBancaria,
			BigDecimal totalOtrosAhorros,
			String banco,
			String expedicion,
			String ciudad,
			String dependencia,
			String estadoCivil
			) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.identificacion = identificacion;
		this.tipoId = tipoId;
		this.fechaRetiro = fechaRetiro;
		this.fechaIngreso = fechaIngreso;
		this.cuentaBancaria = cuentaBancaria;
		this.totalOtrosAhorros = totalOtrosAhorros;
		this.banco = banco;
		this.expedicion = expedicion;
		this.ciudad = ciudad;
		this.dependencia = dependencia;
		this.estadoCivil = estadoCivil;
	}

	
	public FasAfiliadosDTO(String nombre, String correo,  Date fechaRetiro) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.fechaRetiro = fechaRetiro;
	}




	@XmlElement(name="correo")
	public String getCorreo(){
		return this.correo;
	}

	@XmlElement(name = "correo")
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@XmlElement(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	@XmlElement(name = "nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name = "apellido")
	public String getApellido() {
		return apellido;
	}

	@XmlElement(name = "apellido")
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@XmlElement(name = "telefono")
	public BigDecimal getTelefono() {
		return telefono;
	}

	@XmlElement(name = "telefono")
	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

	@XmlElement(name = "direccion")
	public String getDireccion() {
		return direccion;
	}

	@XmlElement(name = "direccion")
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@XmlElement(name = "identificacion")
	public BigDecimal getIdentificacion() {
		return identificacion;
	}

	@XmlElement(name = "identificacion")
	public void setIdentificacion(BigDecimal identificacion) {
		this.identificacion = identificacion;
	}

	@XmlElement(name = "tipoId")
	public String getTipoId() {
		return tipoId;
	}

	@XmlElement(name = "tipoId")
	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	@XmlElement(name = "fechaRetiro")
	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	@XmlElement(name = "fechaRetiro")
	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	@XmlElement(name = "fechaIngreso")
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	@XmlElement(name = "fechaIngreso")
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@XmlElement(name = "cuentaBancaria")
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	@XmlElement(name = "cuentaBancaria")
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	@XmlElement(name = "totalOtrosAhorros")
	public BigDecimal getTotalOtrosAhorros() {
		return totalOtrosAhorros;
	}

	@XmlElement(name = "totalOtrosAhorros")
	public void setTotalOtrosAhorros(BigDecimal totalOtrosAhorros) {
		this.totalOtrosAhorros = totalOtrosAhorros;
	}

	@XmlElement(name = "banco")
	public String getBanco() {
		return banco;
	}

	@XmlElement(name = "banco")
	public void setBanco(String banco) {
		this.banco = banco;
	}

	@XmlElement(name = "expedicion")
	public String getExpedicion() {
		return expedicion;
	}

	@XmlElement(name = "expedicion")
	public void setExpedicion(String expedicion) {
		this.expedicion = expedicion;
	}

	@XmlElement(name = "ciudad")
	public String getCiudad() {
		return ciudad;
	}

	@XmlElement(name = "ciudad")
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@XmlElement(name = "dependencia")
	public String getDependencia() {
		return dependencia;
	}

	@XmlElement(name = "dependencia")
	public void setDependencia(String dependencia) {
		banco = dependencia;
	}

	@XmlElement(name = "estadoCivil")
	public String getEstadoCivil() {
		return estadoCivil;
	}

	@XmlElement(name = "estadoCivil")
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + ((banco == null) ? 0 : banco.hashCode());
        result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((cuentaBancaria == null) ? 0 : cuentaBancaria.hashCode());
        result = prime * result + ((dependencia == null) ? 0 : dependencia.hashCode());
        result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
        result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
        result = prime * result + ((expedicion == null) ? 0 : expedicion.hashCode());
        result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
        result = prime * result + ((fechaRetiro == null) ? 0 : fechaRetiro.hashCode());
        result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        result = prime * result + ((tipoId == null) ? 0 : tipoId.hashCode());
        result = prime * result + ((totalOtrosAhorros == null) ? 0 : totalOtrosAhorros.hashCode());
        
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
        FasAfiliadosDTO other = (FasAfiliadosDTO) obj;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (banco == null) {
            if (other.banco != null)
                return false;
        } else if (!banco.equals(other.banco))
            return false;
        if (ciudad == null) {
            if (other.ciudad != null)
                return false;
        } else if (!ciudad.equals(other.ciudad))
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
        if (dependencia == null) {
            if (other.dependencia != null)
                return false;
        } else if (!dependencia.equals(other.dependencia))
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
        if (estadoCivil == null) {
            if (other.estadoCivil != null)
                return false;
        } else if (!estadoCivil.equals(other.estadoCivil))
            return false;
        if (expedicion == null) {
            if (other.expedicion != null)
                return false;
        } else if (!expedicion.equals(other.expedicion))
            return false;
        if (fechaIngreso == null) {
            if (other.fechaIngreso != null)
                return false;
        } else if (!fechaIngreso.equals(other.fechaIngreso))
            return false;
        if (fechaRetiro == null) {
            if (other.fechaRetiro != null)
                return false;
        } else if (!fechaRetiro.equals(other.fechaRetiro))
            return false;
        if (identificacion == null) {
            if (other.identificacion != null)
                return false;
        } else if (!identificacion.equals(other.identificacion))
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
        if (tipoId == null) {
            if (other.tipoId != null)
                return false;
        } else if (!tipoId.equals(other.tipoId))
            return false;
        if (totalOtrosAhorros == null) {
            if (other.totalOtrosAhorros != null)
                return false;
        } else if (!totalOtrosAhorros.equals(other.totalOtrosAhorros))
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

