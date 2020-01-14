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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import java.util.List;
import uk.co.jemos.podam.annotations.PodamExclude;
import java.math.BigDecimal;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name="FAS_TIPOS_DE_CREDITO")
@NamedQuery(name = "FasTiposDeCredito.findAll", query = "SELECT p FROM FasTiposDeCredito p")
public class FasTiposDeCredito implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_TIPOS_DE_CREDITO_PK = "idTipo";
	public static final String ENTIDAD_FAS_TIPOS_DE_CREDITO_TIPO = "tipo";
	public static final String ENTIDAD_FAS_TIPOS_DE_CREDITO_TASA = "tasa";
	public static final String ENTIDAD_FAS_TIPOS_DE_CREDITO_DESCRIPCION = "descripcion";
	public static final String ENTIDAD_FAS_TIPOS_DE_CREDITO_CUOTAS_MAXIMAS = "cuotasMaximas";
	public static final String ENTIDAD_FAS_TIPOS_DE_CREDITO_ESTADO = "estado";
    private static final String[] ATRIBUTOS_ENTIDAD_FAS_TIPOS_DE_CREDITO
            = {ENTIDAD_FAS_TIPOS_DE_CREDITO_CUOTAS_MAXIMAS, ENTIDAD_FAS_TIPOS_DE_CREDITO_ESTADO, ENTIDAD_FAS_TIPOS_DE_CREDITO_TIPO, ENTIDAD_FAS_TIPOS_DE_CREDITO_PK, ENTIDAD_FAS_TIPOS_DE_CREDITO_DESCRIPCION, ENTIDAD_FAS_TIPOS_DE_CREDITO_TASA};

	@Id
    @Column(name="ID_TIPO")
	private BigDecimal idTipo;

	@Column(name="TIPO")
	@Size(min=0, max= 20)
	private String tipo;
	
	@Column(name="TASA")
	private BigDecimal tasa;
	
	@Column(name="DESCRIPCION")
	@Size(min=0, max= 250)
	private String descripcion;
	
	@Column(name="CUOTAS_MAXIMAS")
	private BigDecimal cuotasMaximas;
	
	@Column(name="ESTADO")
	@Size(min=0, max= 10)
	private String estado;
	

	@OneToMany(mappedBy="fasTiposDeCreditofasCredFasTipoCredFk")
	@PodamExclude
    private List<FasCreditos> fasCredFasTipoCredFkes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasTiposDeCredito(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	public BigDecimal getIdTipo(){
		return this.idTipo;
	}
	
	public void setIdTipo(BigDecimal idTipo){
	
		this.idTipo = idTipo;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public void setTipo(String tipo){
	
		this.tipo = tipo;
	}
		
	public BigDecimal getTasa(){
		return this.tasa;
	}
	
	public void setTasa(BigDecimal tasa){
	
		this.tasa = tasa;
	}
		
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion){
	
		this.descripcion = descripcion;
	}
		
	public BigDecimal getCuotasMaximas(){
		return this.cuotasMaximas;
	}
	
	public void setCuotasMaximas(BigDecimal cuotasMaximas){
	
		this.cuotasMaximas = cuotasMaximas;
	}
		
	public String getEstado(){
		return this.estado;
	}
	
	public void setEstado(String estado){
	
		this.estado = estado;
	}
		

    public List<FasCreditos> getFasCredFasTipoCredFkesList(){
		return this.fasCredFasTipoCredFkes;
	}
	
	public void setFasCredFasTipoCredFkesList(List<FasCreditos> fasCredFasTipoCredFkes){
		this.fasCredFasTipoCredFkes = fasCredFasTipoCredFkes;
	}
			

	/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
		
		boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_TIPOS_DE_CREDITO) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
    
    public static String[] getAtributosEntidadFasTiposDeCredito() {
		return ATRIBUTOS_ENTIDAD_FAS_TIPOS_DE_CREDITO;
	}

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idTipo);        
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.tasa);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.cuotasMaximas);
        hash = 37 * hash + Objects.hashCode(this.estado);
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasTiposDeCredito que se pasa
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
        final FasTiposDeCredito other = (FasTiposDeCredito) obj;
        
        if (!Objects.equals(this.idTipo, other.idTipo)) {
            return false;
        }
        
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        
        if (!Objects.equals(this.tasa, other.tasa)) {
            return false;
        }
        
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotasMaximas, other.cuotasMaximas)) {
            return false;
        }
        
        return Objects.equals(this.estado, other.estado);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

