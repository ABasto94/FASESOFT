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
public class FasConveniosTiposPagosDTO implements Serializable{    
    
    private String fas_afiliados_correo;
    private BigDecimal id_convenio;
    private BigDecimal monto_convenio;
    private BigDecimal saldo_convenio;
    private Date fecha_desembolso_conv;
    private Date fecha_de_pago;
    private BigDecimal tasa_convenio;
    private BigDecimal mora_convenio;
    private String tipo_convenio;
    private BigDecimal cuota_total;
    
    

 

    // protected region atributos adicionales on begin
    // Escriba en esta sección sus modificaciones

 

    // protected region atributos adicionales end
    
    
    
    public FasConveniosTiposPagosDTO(){
        // protected region procedimientos adicionales de inicialización on begin
        // Escriba en esta sección sus modificaciones

 

        // protected region procedimientos adicionales de inicialización end
    }
    

 

    public FasConveniosTiposPagosDTO(String fas_afiliados_correo, BigDecimal id_convenio, BigDecimal monto_convenio,
            BigDecimal saldo_convenio, Date fecha_desembolso_conv, Date fecha_de_pago, BigDecimal tasa_convenio, BigDecimal mora_convenio,
            String tipo_convenio, BigDecimal cuota_total) {
        super();
        this.fas_afiliados_correo = fas_afiliados_correo;
        this.id_convenio = id_convenio;
        this.monto_convenio = monto_convenio;
        this.saldo_convenio = saldo_convenio;
        this.fecha_desembolso_conv = fecha_desembolso_conv;
        this.fecha_de_pago= fecha_de_pago;
        this.tasa_convenio = tasa_convenio;
        this.mora_convenio = mora_convenio;
        this.tipo_convenio = tipo_convenio;
        this.cuota_total = cuota_total;
    }

 


    @XmlElement(name="fas_afiliados_correo")
    public String getFas_afiliados_correo() {
        return fas_afiliados_correo;
    }

 

    @XmlElement(name="fas_afiliados_correo")
    public void setFas_afiliados_correo(String fas_afiliados_correo) {
        this.fas_afiliados_correo = fas_afiliados_correo;
    }

 

   

 

    @XmlElement(name="id_convenio")
    public BigDecimal getId_convenio() {
        return id_convenio;
    }

 

    @XmlElement(name="id_convenio")
    public void setId_convenio(BigDecimal id_convenio) {
        this.id_convenio = id_convenio;
    }

 


    @XmlElement(name="monto_convenio")
    public BigDecimal getMonto_convenio() {
        return monto_convenio;
    }

 

    @XmlElement(name="monto_convenio")
    public void setMonto_convenio(BigDecimal monto_convenio) {
        this.monto_convenio = monto_convenio;
    }

 


    @XmlElement(name="mora_convenio")
    public BigDecimal getMora_convenio() {
        return mora_convenio;
    }

 

    @XmlElement(name="mora_convenio")
    public void setMora_convenio(BigDecimal mora_convenio) {
        this.mora_convenio = mora_convenio;
    }

 

    @XmlElement(name="saldo_convenio")
    public BigDecimal getSaldo_convenio() {
        return saldo_convenio;
    }

 


    @XmlElement(name="saldo_convenio")
    public void setSaldo_convenio(BigDecimal saldo_convenio) {
        this.saldo_convenio = saldo_convenio;
    }

 

    @XmlElement(name="fecha_desembolso_conv")
    public Date getFecha_desembolso_conv() {
        return fecha_desembolso_conv;
    }

 


    @XmlElement(name="fecha_desembolso_conv")
    public void setFecha_desembolso_conv(Date fecha_desembolso_conv) {
        this.fecha_desembolso_conv = fecha_desembolso_conv;
    }

 


    @XmlElement(name="tasa_convenio")
    public BigDecimal getTasa_convenio() {
        return tasa_convenio;
    }

 

    @XmlElement(name="tasa_convenio")
    public void setTasa_convenio(BigDecimal tasa_convenio) {
        this.tasa_convenio = tasa_convenio;
    }

 

    @XmlElement(name="tipo_convenio")
    public String getTipo_convenio() {
        return tipo_convenio;
    }

 

    @XmlElement(name="tipo_convenio")
    public void setTipo_convenio(String tipo_convenio) {
        this.tipo_convenio = tipo_convenio;
    }

 

    @XmlElement(name="cuota_total")
    public BigDecimal getCuota_total() {
        return cuota_total;
    }

 

    @XmlElement(name="cuota_total")
    public void setCuota_total(BigDecimal cuota_total) {
        this.cuota_total = cuota_total;
    }
    
    

    @XmlElement(name="fecha_de_pago")
    public Date getFecha_de_pago() {
		return fecha_de_pago;
	}



    @XmlElement(name="fecha_de_pago")
	public void setFecha_de_pago(Date fecha_de_pago) {
		this.fecha_de_pago = fecha_de_pago;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuota_total == null) ? 0 : cuota_total.hashCode());
		result = prime * result + ((fas_afiliados_correo == null) ? 0 : fas_afiliados_correo.hashCode());
		result = prime * result + ((fecha_de_pago == null) ? 0 : fecha_de_pago.hashCode());
		result = prime * result + ((fecha_desembolso_conv == null) ? 0 : fecha_desembolso_conv.hashCode());
		result = prime * result + ((id_convenio == null) ? 0 : id_convenio.hashCode());
		result = prime * result + ((monto_convenio == null) ? 0 : monto_convenio.hashCode());
		result = prime * result + ((mora_convenio == null) ? 0 : mora_convenio.hashCode());
		result = prime * result + ((saldo_convenio == null) ? 0 : saldo_convenio.hashCode());
		result = prime * result + ((tasa_convenio == null) ? 0 : tasa_convenio.hashCode());
		result = prime * result + ((tipo_convenio == null) ? 0 : tipo_convenio.hashCode());
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
		FasConveniosTiposPagosDTO other = (FasConveniosTiposPagosDTO) obj;
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
		if (fecha_de_pago == null) {
			if (other.fecha_de_pago != null)
				return false;
		} else if (!fecha_de_pago.equals(other.fecha_de_pago))
			return false;
		if (fecha_desembolso_conv == null) {
			if (other.fecha_desembolso_conv != null)
				return false;
		} else if (!fecha_desembolso_conv.equals(other.fecha_desembolso_conv))
			return false;
		if (id_convenio == null) {
			if (other.id_convenio != null)
				return false;
		} else if (!id_convenio.equals(other.id_convenio))
			return false;
		if (monto_convenio == null) {
			if (other.monto_convenio != null)
				return false;
		} else if (!monto_convenio.equals(other.monto_convenio))
			return false;
		if (mora_convenio == null) {
			if (other.mora_convenio != null)
				return false;
		} else if (!mora_convenio.equals(other.mora_convenio))
			return false;
		if (saldo_convenio == null) {
			if (other.saldo_convenio != null)
				return false;
		} else if (!saldo_convenio.equals(other.saldo_convenio))
			return false;
		if (tasa_convenio == null) {
			if (other.tasa_convenio != null)
				return false;
		} else if (!tasa_convenio.equals(other.tasa_convenio))
			return false;
		if (tipo_convenio == null) {
			if (other.tipo_convenio != null)
				return false;
		} else if (!tipo_convenio.equals(other.tipo_convenio))
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