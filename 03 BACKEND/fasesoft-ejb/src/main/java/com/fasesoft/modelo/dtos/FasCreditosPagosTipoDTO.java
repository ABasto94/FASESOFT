package com.fasesoft.modelo.dtos;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

 

/**
 * DAO que contiene la información de la entidad FasAccesosDTO que se transmite
 * por los servicios REST. Solo se transmiten los atributos simples, es decir,
 * se omiten aquellos atributos que definen relaciones con otras entidades.
 * 
 * @author GeneradorCRUD
 */
@XmlRootElement
public class FasCreditosPagosTipoDTO implements Serializable{    

 

    private String tipo;
    private BigDecimal monto;
    private BigDecimal cuota_total;
    private Date fechaDePago;
    private BigDecimal tasa_real;
    private BigDecimal mora;
    private BigDecimal saldo;
    private String fas_afiliados_correo; 
    private Date fecha_desembolso;
    
    
    

 

    // protected region atributos adicionales on begin
    // Escriba en esta sección sus modificaciones

 

    // protected region atributos adicionales end
    
    
    
    public FasCreditosPagosTipoDTO(){
        // protected region procedimientos adicionales de inicialización on begin
        // Escriba en esta sección sus modificaciones

 

        // protected region procedimientos adicionales de inicialización end
    }
    
    
    
    
 


    public FasCreditosPagosTipoDTO(String tipo, BigDecimal monto, BigDecimal cuota_total, Date fechaDePago, BigDecimal tasa_real,
			BigDecimal mora, BigDecimal saldo, String fas_afiliados_correo, Date fecha_desembolso) {
		super();
		this.tipo = tipo;
		this.monto = monto;
		this.cuota_total = cuota_total;
		this.fechaDePago= fechaDePago;
		this.tasa_real = tasa_real;
		this.mora = mora;
		this.saldo = saldo;
		this.fas_afiliados_correo = fas_afiliados_correo;
		this.fecha_desembolso = fecha_desembolso;
	}







	@XmlElement(name="tipo")
    public String getTipo() {
        return tipo;
    }

 


    @XmlElement(name="tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

 


    @XmlElement(name="monto")
    public BigDecimal getMonto() {
        return monto;
    }

 


    @XmlElement(name="monto")
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

 


    @XmlElement(name="cuota_total")
    public BigDecimal getCuota_total() {
        return cuota_total;
    }

 


    @XmlElement(name="cuota_total")
    public void setCuota_total(BigDecimal cuota_total) {
        this.cuota_total = cuota_total;
    }

 


    @XmlElement(name="tasa_real")
    public BigDecimal getTasa_real() {
        return tasa_real;
    }

 


    @XmlElement(name="tasa_real")
    public void setTasa_real(BigDecimal tasa_real) {
        this.tasa_real = tasa_real;
    }

 


    @XmlElement(name="mora")
    public BigDecimal getMora() {
        return mora;
    }

 


    @XmlElement(name="mora")
    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

 


    @XmlElement(name="saldo")
    public BigDecimal getSaldo() {
        return saldo;
    }

 


    @XmlElement(name="saldo")
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

 

 

    @XmlElement(name="fas_afiliados_correo")
    public String getFas_afiliados_correo() {
        return fas_afiliados_correo;
    }

 

    @XmlElement(name="fas_afiliados_correo")
    public void setFas_afiliados_correo(String fas_afiliados_correo) {
        this.fas_afiliados_correo = fas_afiliados_correo;
    }

 

    
    @XmlElement(name="fecha_desembolso")
    public Date getFecha_desembolso() {
        return fecha_desembolso;
    }

 

    @XmlElement(name="fecha_desembolso")
    public void setFecha_desembolso(Date fecha_desembolso) {
        this.fecha_desembolso = fecha_desembolso;
    }
    
    
    @XmlElement(name="fechaDePago")
	public Date getFechaDePago() {
		return fechaDePago;
	}

    @XmlElement(name="fechaDePago")
	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuota_total == null) ? 0 : cuota_total.hashCode());
		result = prime * result + ((fas_afiliados_correo == null) ? 0 : fas_afiliados_correo.hashCode());
		result = prime * result + ((fechaDePago == null) ? 0 : fechaDePago.hashCode());
		result = prime * result + ((fecha_desembolso == null) ? 0 : fecha_desembolso.hashCode());
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
		result = prime * result + ((mora == null) ? 0 : mora.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime * result + ((tasa_real == null) ? 0 : tasa_real.hashCode());
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
		FasCreditosPagosTipoDTO other = (FasCreditosPagosTipoDTO) obj;
		if (cuota_total == null) {
			if (other.cuota_total != null)
				return false;
		} else if (!cuota_total.equals(other.cuota_total))
			return false;
		if (fas_afiliados_correo == null) {
			if (other.fas_afiliados_correo != null)
				return false;
		} else if (!fas_afiliados_correo.equals(other.fas_afiliados_correo))
			return false;
		if (fechaDePago == null) {
			if (other.fechaDePago != null)
				return false;
		} else if (!fechaDePago.equals(other.fechaDePago))
			return false;
		if (fecha_desembolso == null) {
			if (other.fecha_desembolso != null)
				return false;
		} else if (!fecha_desembolso.equals(other.fecha_desembolso))
			return false;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
			return false;
		if (mora == null) {
			if (other.mora != null)
				return false;
		} else if (!mora.equals(other.mora))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (tasa_real == null) {
			if (other.tasa_real != null)
				return false;
		} else if (!tasa_real.equals(other.tasa_real))
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
