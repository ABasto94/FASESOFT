package com.fasesoft.modelo.entidades;


import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;

import com.fasesoft.modelo.dtos.FasDetallePagoDTO;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import java.util.Date;
import uk.co.jemos.podam.annotations.PodamExclude;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name="FAS_PAGOS")
@NamedQuery(name = "FasPagos.findAll", query = "SELECT p FROM FasPagos p")
@SqlResultSetMapping( 	name= ConstantesConsultas.RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_PAGOS_AFILIADO,
						classes = {
						 @ConstructorResult(targetClass = FasDetallePagoDTO.class,
						 columns = { 
								 @ColumnResult(name="tipo"),    
								 @ColumnResult(name="monto"),
								 @ColumnResult(name="cuota_total"),
								 @ColumnResult(name="tasa_real"),
								 @ColumnResult(name="mora"),
								 @ColumnResult(name="saldo")})})


public class FasPagos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_PAGOS_PK = "idPago";
	public static final String ENTIDAD_FAS_PAGOS_CUOTA_TOTAL = "cuotaTotal";
	public static final String ENTIDAD_FAS_PAGOS_FECHA_DE_PAGO = "fechaDePago";
	public static final String ENTIDAD_FAS_PAGOS_SALDO = "saldo";
	public static final String ENTIDAD_FAS_PAGOS_FAS_CREDITOS_ID_CREDITO = "fasCreditosIdCredito";
	public static final String ENTIDAD_FAS_PAGOS_CUOTA_INTERESES = "cuotaIntereses";
	public static final String ENTIDAD_FAS_PAGOS_CUOTA_SEGURO = "cuotaSeguro";
	public static final String ENTIDAD_FAS_PAGOS_CUOTA_DEUDA = "cuotaDeuda";
    private static final String[] ATRIBUTOS_ENTIDAD_FAS_PAGOS
            = {ENTIDAD_FAS_PAGOS_PK, ENTIDAD_FAS_PAGOS_CUOTA_SEGURO, ENTIDAD_FAS_PAGOS_CUOTA_DEUDA, ENTIDAD_FAS_PAGOS_SALDO, ENTIDAD_FAS_PAGOS_FAS_CREDITOS_ID_CREDITO, ENTIDAD_FAS_PAGOS_CUOTA_INTERESES, ENTIDAD_FAS_PAGOS_FECHA_DE_PAGO, ENTIDAD_FAS_PAGOS_CUOTA_TOTAL};

	@Id
    @Column(name="ID_PAGO")
	private BigDecimal idPago;

	@Column(name="CUOTA_TOTAL")
	private BigDecimal cuotaTotal;
	
	@Column(name="FECHA_DE_PAGO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaDePago;
	
	@Column(name="SALDO")
	private BigDecimal saldo;
	
    @PodamExclude
	@Column(name="FAS_CREDITOS_ID_CREDITO")
	private BigDecimal fasCreditosIdCredito;
	
	@Column(name="CUOTA_INTERESES")
	private BigDecimal cuotaIntereses;
	
	@Column(name="CUOTA_SEGURO")
	private BigDecimal cuotaSeguro;
	
	@Column(name="CUOTA_DEUDA")
	private BigDecimal cuotaDeuda;
	

	@ManyToOne
	@JoinColumn(name="FAS_CREDITOS_ID_CREDITO", referencedColumnName="ID_CREDITO", insertable = false, updatable = false)
	@PodamExclude
    private FasCreditos fasCreditosfasPagosFasCreditosFk;
    
		

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasPagos(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	public BigDecimal getIdPago(){
		return this.idPago;
	}
	
	public void setIdPago(BigDecimal idPago){
	
		this.idPago = idPago;
	}
	
	public BigDecimal getCuotaTotal(){
		return this.cuotaTotal;
	}
	
	public void setCuotaTotal(BigDecimal cuotaTotal){
	
		this.cuotaTotal = cuotaTotal;
	}
		
	public Date getFechaDePago(){
		return this.fechaDePago;
	}
	
	public void setFechaDePago(Date fechaDePago){
	
		this.fechaDePago = fechaDePago;
	}
		
	public BigDecimal getSaldo(){
		return this.saldo;
	}
	
	public void setSaldo(BigDecimal saldo){
	
		this.saldo = saldo;
	}
		
	public BigDecimal getFasCreditosIdCredito(){
		return this.fasCreditosIdCredito;
	}
	
	public void setFasCreditosIdCredito(BigDecimal fasCreditosIdCredito){
	
		this.fasCreditosIdCredito = fasCreditosIdCredito;
	}
		
	public BigDecimal getCuotaIntereses(){
		return this.cuotaIntereses;
	}
	
	public void setCuotaIntereses(BigDecimal cuotaIntereses){
	
		this.cuotaIntereses = cuotaIntereses;
	}
		
	public BigDecimal getCuotaSeguro(){
		return this.cuotaSeguro;
	}
	
	public void setCuotaSeguro(BigDecimal cuotaSeguro){
	
		this.cuotaSeguro = cuotaSeguro;
	}
		
	public BigDecimal getCuotaDeuda(){
		return this.cuotaDeuda;
	}
	
	public void setCuotaDeuda(BigDecimal cuotaDeuda){
	
		this.cuotaDeuda = cuotaDeuda;
	}
		

    public FasCreditos getFasCreditosfasPagosFasCreditosFk(){
		return this.fasCreditosfasPagosFasCreditosFk; 
	}
	
	public void setFasCreditosfasPagosFasCreditosFk(FasCreditos fasCreditosfasPagosFasCreditosFk){
		this.fasCreditosfasPagosFasCreditosFk = fasCreditosfasPagosFasCreditosFk;
	}

	/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
		
		boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_PAGOS) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
    
    public static String[] getAtributosEntidadFasPagos() {
		return ATRIBUTOS_ENTIDAD_FAS_PAGOS;
	}

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idPago);        
        hash = 37 * hash + Objects.hashCode(this.cuotaTotal);
        hash = 37 * hash + Objects.hashCode(this.fechaDePago);
        hash = 37 * hash + Objects.hashCode(this.saldo);
        hash = 37 * hash + Objects.hashCode(this.fasCreditosIdCredito);
        hash = 37 * hash + Objects.hashCode(this.cuotaIntereses);
        hash = 37 * hash + Objects.hashCode(this.cuotaSeguro);
        hash = 37 * hash + Objects.hashCode(this.cuotaDeuda);
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasPagos que se pasa
     * como parámetro comprobando que comparten los mismos valores en cada uno
     * de sus atributos. Solo se tienen en cuenta los atributos simples, es
     * decir, se omiten aquellos que definen una relación con otra tabla.
     *
     * @param obj Instancia de la categoría a comprobar
     * iguales.
     * @return Verdadero si esta instancia y la que se pasan como parámetros son
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FasPagos other = (FasPagos) obj;
        
        if (!Objects.equals(this.idPago, other.idPago)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotaTotal, other.cuotaTotal)) {
            return false;
        }
        
        if (!Objects.equals(this.fechaDePago, other.fechaDePago)) {
            return false;
        }
        
        if (!Objects.equals(this.saldo, other.saldo)) {
            return false;
        }
        
        if (!Objects.equals(this.fasCreditosIdCredito, other.fasCreditosIdCredito)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotaIntereses, other.cuotaIntereses)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotaSeguro, other.cuotaSeguro)) {
            return false;
        }
        
        return Objects.equals(this.cuotaDeuda, other.cuotaDeuda);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

