package com.fasesoft.modelo.entidades;


import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;

import com.fasesoft.modelo.dtos.FasCreditosAfiliadoDTO;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultaCreditos;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery; 
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;

import java.util.List;
import uk.co.jemos.podam.annotations.PodamExclude;
import java.math.BigDecimal;
import javax.persistence.Access;
import static javax.persistence.AccessType.FIELD;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name="FAS_TIPOS_CONVENIO")
@NamedQueries({
	@NamedQuery(name = "FasTiposConvenio.findAll", query = "SELECT p FROM FasTiposConvenio p")
	})

@SqlResultSetMapping(  name= ConstantesConsultas.CREATE_TIPO_CONVENIO,
classes = {
 @ConstructorResult(targetClass = FasTiposConvenio.class,
 columns = {
         @ColumnResult(name="tipo"),   
         @ColumnResult(name="tasa"),
         @ColumnResult(name="estado"),
         @ColumnResult(name="descripcion"),
         @ColumnResult(name="url_convenio"),
         @ColumnResult(name="cuotas_maximas")
         })})

@Access(FIELD)
public class FasTiposConvenio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_TIPOS_CONVENIO_PK = "idTipoConvenio";
	public static final String ENTIDAD_FAS_TIPOS_CONVENIO_TIPO = "tipo";
	public static final String ENTIDAD_FAS_TIPOS_CONVENIO_TASA = "tasa";
	public static final String ENTIDAD_FAS_TIPOS_CONVENIO_ESTADO = "estado";
	public static final String ENTIDAD_FAS_TIPOS_CONVENIO_DESCRIPCION = "descripcion";
	public static final String ENTIDAD_FAS_TIPOS_CONVENIO_URL_CONVENIO = "urlConvenio";
	public static final String ENTIDAD_FAS_TIPOS_CONVENIO_CODLINE = "codLine";
	public static final String ENTIDAD_FAS_TIPOS_CONVENIO_CUOTAS_MAXIMAS = "cuotasMaximas";
    private static final String[] ATRIBUTOS_ENTIDAD_FAS_TIPOS_CONVENIO
            = {ENTIDAD_FAS_TIPOS_CONVENIO_ESTADO, ENTIDAD_FAS_TIPOS_CONVENIO_TASA,
            		ENTIDAD_FAS_TIPOS_CONVENIO_PK, ENTIDAD_FAS_TIPOS_CONVENIO_TIPO,
            		ENTIDAD_FAS_TIPOS_CONVENIO_DESCRIPCION, ENTIDAD_FAS_TIPOS_CONVENIO_URL_CONVENIO,
            		ENTIDAD_FAS_TIPOS_CONVENIO_CODLINE,ENTIDAD_FAS_TIPOS_CONVENIO_CUOTAS_MAXIMAS};

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOS_CONVENIOS_SEQ")
    @SequenceGenerator(name = "TIPOS_CONVENIOS_SEQ", sequenceName = "SQ_FAS_TIPOS_CONVENIOS", allocationSize = 1)
    @Column(name="ID_TIPO_CONVENIO")
	private Number idTipoConvenio;

	@Column(name="TIPO")
	@Size(min=0, max= 50)
	private String tipo;
	
	@Column(name="TASA")
	private BigDecimal tasa;
	
	@Column(name="ESTADO")
	@Size(min=0, max= 10)
	private String estado;
	
	@Column(name="DESCRIPCION")
	@Size(min=0, max= 250)
	private String descripcion;
	
	@Column(name="URL_CONVENIO")
	@Size(min=0, max= 250)
	private String urlConvenio;
		
	@Column(name="CUOTAS_MAXIMAS")
	private BigDecimal cuotasMaximas;

	@OneToMany(mappedBy="fasTiposConveniofasConvFasTipoConvFk")
	@PodamExclude
    private List<FasConvenios> fasConvFasTipoConvFkes;

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasTiposConvenio(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	public Number getIdTipoConvenio(){
		return this.idTipoConvenio;
	}
	
	public void setIdTipoConvenio(Number idTipoConvenio){
	
		this.idTipoConvenio = idTipoConvenio;
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
		
	public String getEstado(){
		return this.estado;
	}
	
	public void setEstado(String estado){
	
		this.estado = estado;
	}
		
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion){
	
		this.descripcion = descripcion;
	}
	
	public String getUrlConvenio(){
		return this.urlConvenio;
	}
	
	public void setUrlConvenio(String urlConvenio){
	
		this.urlConvenio = urlConvenio;
	}
	
	public BigDecimal getCuotasMaximas(){
		return this.cuotasMaximas;
	}
	
	public void setCoutasMaximas(BigDecimal cuotasMaximas){
	
		this.cuotasMaximas = cuotasMaximas;
	}

    public List<FasConvenios> getFasConvFasTipoConvFkesList(){
		return this.fasConvFasTipoConvFkes;
	}
	
	public void setFasConvFasTipoConvFkesList(List<FasConvenios> fasConvFasTipoConvFkes){
		this.fasConvFasTipoConvFkes = fasConvFasTipoConvFkes;
	}
			

	/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
		
		boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_TIPOS_CONVENIO) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
    
    public static String[] getAtributosEntidadFasTiposConvenio() {
		return ATRIBUTOS_ENTIDAD_FAS_TIPOS_CONVENIO;
	}

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idTipoConvenio);        
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.tasa);
        hash = 37 * hash + Objects.hashCode(this.estado);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.urlConvenio);
        hash = 37 * hash + Objects.hashCode(this.cuotasMaximas);
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasTiposConvenio que se pasa
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
        final FasTiposConvenio other = (FasTiposConvenio) obj;
        
        if (!Objects.equals(this.idTipoConvenio, other.idTipoConvenio)) {
            return false;
        }
        
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        
        if (!Objects.equals(this.tasa, other.tasa)) {
            return false;
        }
        
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        
        if (!Objects.equals(this.urlConvenio, other.urlConvenio)) {
            return false;
        }
        
        if (!Objects.equals(this.cuotasMaximas, other.cuotasMaximas)) {
            return false;
        }
        
        return Objects.equals(this.descripcion, other.descripcion);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

