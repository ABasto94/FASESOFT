package com.fasesoft.modelo.entidades;


import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery; 
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
@Table(name="FAS_APORTES")
@NamedQuery(name = "FasAportes.findAll", query = "SELECT p FROM FasAportes p")
public class FasAportes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_APORTES_PK = "idAporte";
	public static final String ENTIDAD_FAS_APORTES_BENEFICIO = "beneficio";
	public static final String ENTIDAD_FAS_APORTES_APORTE = "aporte";
	public static final String ENTIDAD_FAS_APORTES_FECHA_APORTE = "fechaAporte";
	public static final String ENTIDAD_FAS_APORTES_FAS_AHORROS_ID_AHORRO = "fasAhorrosIdAhorro";
	public static final String ENTIDAD_FAS_APORTES_APORTES_ORDINARIOS = "aportesOrdinarios";
	public static final String ENTIDAD_FAS_APORTES_AHORRO_PERMANENTE = "ahorroPermanente";
    private static final String[] ATRIBUTOS_ENTIDAD_FAS_APORTES
            = {ENTIDAD_FAS_APORTES_BENEFICIO, ENTIDAD_FAS_APORTES_FECHA_APORTE, ENTIDAD_FAS_APORTES_FAS_AHORROS_ID_AHORRO, ENTIDAD_FAS_APORTES_APORTE, ENTIDAD_FAS_APORTES_PK, ENTIDAD_FAS_APORTES_APORTES_ORDINARIOS, ENTIDAD_FAS_APORTES_AHORRO_PERMANENTE};

	@Id
    @Column(name="ID_APORTE")
	private BigDecimal idAporte;

	@Column(name="BENEFICIO")
	private BigDecimal beneficio;
	
	@Column(name="APORTE")
	private BigDecimal aporte;
	
	@Column(name="FECHA_APORTE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fechaAporte;
	
    @PodamExclude
	@Column(name="FAS_AHORROS_ID_AHORRO")
	private BigDecimal fasAhorrosIdAhorro;
	
	@Column(name="APORTES_ORDINARIOS")
	private BigDecimal aportesOrdinarios;
	
	@Column(name="AHORRO_PERMANENTE")
	private BigDecimal ahorroPermanente;
	

	@ManyToOne
	@JoinColumn(name="FAS_AHORROS_ID_AHORRO", referencedColumnName="ID_AHORRO", insertable = false, updatable = false)
	@PodamExclude
    private FasAhorros fasAhorrosfasAportesFasAhorrosFk;
    
		

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasAportes(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	public BigDecimal getIdAporte(){
		return this.idAporte;
	}
	
	public void setIdAporte(BigDecimal idAporte){
	
		this.idAporte = idAporte;
	}
	
	public BigDecimal getBeneficio(){
		return this.beneficio;
	}
	
	public void setBeneficio(BigDecimal beneficio){
	
		this.beneficio = beneficio;
	}
		
	public BigDecimal getAporte(){
		return this.aporte;
	}
	
	public void setAporte(BigDecimal aporte){
	
		this.aporte = aporte;
	}
		
	public Date getFechaAporte(){
		return this.fechaAporte;
	}
	
	public void setFechaAporte(Date fechaAporte){
	
		this.fechaAporte = fechaAporte;
	}
		
	public BigDecimal getFasAhorrosIdAhorro(){
		return this.fasAhorrosIdAhorro;
	}
	
	public void setFasAhorrosIdAhorro(BigDecimal fasAhorrosIdAhorro){
	
		this.fasAhorrosIdAhorro = fasAhorrosIdAhorro;
	}
		
	public BigDecimal getAportesOrdinarios(){
		return this.aportesOrdinarios;
	}
	
	public void setAportesOrdinarios(BigDecimal aportesOrdinarios){
	
		this.aportesOrdinarios = aportesOrdinarios;
	}
		
	public BigDecimal getAhorroPermanente(){
		return this.ahorroPermanente;
	}
	
	public void setAhorroPermanente(BigDecimal ahorroPermanente){
	
		this.ahorroPermanente = ahorroPermanente;
	}
		

    public FasAhorros getFasAhorrosfasAportesFasAhorrosFk(){
		return this.fasAhorrosfasAportesFasAhorrosFk; 
	}
	
	public void setFasAhorrosfasAportesFasAhorrosFk(FasAhorros fasAhorrosfasAportesFasAhorrosFk){
		this.fasAhorrosfasAportesFasAhorrosFk = fasAhorrosfasAportesFasAhorrosFk;
	}

	/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
		
		boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_APORTES) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
    
    public static String[] getAtributosEntidadFasAportes() {
		return ATRIBUTOS_ENTIDAD_FAS_APORTES;
	}

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idAporte);        
        hash = 37 * hash + Objects.hashCode(this.beneficio);
        hash = 37 * hash + Objects.hashCode(this.aporte);
        hash = 37 * hash + Objects.hashCode(this.fechaAporte);
        hash = 37 * hash + Objects.hashCode(this.fasAhorrosIdAhorro);
        hash = 37 * hash + Objects.hashCode(this.aportesOrdinarios);
        hash = 37 * hash + Objects.hashCode(this.ahorroPermanente);
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasAportes que se pasa
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
        final FasAportes other = (FasAportes) obj;
        
        if (!Objects.equals(this.idAporte, other.idAporte)) {
            return false;
        }
        
        if (!Objects.equals(this.beneficio, other.beneficio)) {
            return false;
        }
        
        if (!Objects.equals(this.aporte, other.aporte)) {
            return false;
        }
        
        if (!Objects.equals(this.fechaAporte, other.fechaAporte)) {
            return false;
        }
        
        if (!Objects.equals(this.fasAhorrosIdAhorro, other.fasAhorrosIdAhorro)) {
            return false;
        }
        
        if (!Objects.equals(this.aportesOrdinarios, other.aportesOrdinarios)) {
            return false;
        }
        
        return Objects.equals(this.ahorroPermanente, other.ahorroPermanente);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

