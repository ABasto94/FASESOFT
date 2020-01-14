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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.JoinColumn;
import uk.co.jemos.podam.annotations.PodamExclude;
import java.math.BigDecimal;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name="FAS_SOL_CONVENIOS")
@NamedQuery(name = "FasSolConvenios.findAll", query = "SELECT p FROM FasSolConvenios p")
public class FasSolConvenios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_SOL_CONVENIOS_PK = "idSolicitud";
	public static final String ENTIDAD_FAS_SOL_CONVENIOS_FAS_AFILIADOS_CORREO = "fasAfiliadosCorreo";
	public static final String ENTIDAD_FAS_SOL_CONVENIOS_FAS_CONVENIOS_ID_CONVENIO = "fasConveniosIdConvenio";
    private static final String[] ATRIBUTOS_ENTIDAD_FAS_SOL_CONVENIOS
            = {ENTIDAD_FAS_SOL_CONVENIOS_FAS_CONVENIOS_ID_CONVENIO, ENTIDAD_FAS_SOL_CONVENIOS_PK, ENTIDAD_FAS_SOL_CONVENIOS_FAS_AFILIADOS_CORREO};

	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOL_CONVENIOS_SEQ")
    @SequenceGenerator(name = "SOL_CONVENIOS_SEQ", sequenceName = "SQ_FAS_SOL_CONVENIOS", allocationSize = 1)
    @Column(name="ID_SOLICITUD")
	private Integer idSolicitud;

    @PodamExclude
	@Column(name="FAS_AFILIADOS_CORREO")
	@Size(min=0, max= 40)
	private String fasAfiliadosCorreo;
	
    @PodamExclude
	@Column(name="FAS_CONVENIOS_ID_CONVENIO")
	private BigDecimal fasConveniosIdConvenio;
	

	@ManyToOne
	@JoinColumn(name="FAS_AFILIADOS_CORREO", referencedColumnName="CORREO", insertable = false, updatable = false)
	@PodamExclude
    private FasAfiliados fasAfiliadosfasSolConvFasAfiliFk;
    
		
	@ManyToOne
	@JoinColumn(name="FAS_CONVENIOS_ID_CONVENIO", referencedColumnName="ID_CONVENIO", insertable = false, updatable = false)
	@PodamExclude
    private FasConvenios fasConveniosfasSolConvFasConvFk;
    
		

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
	
    public FasSolConvenios(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }


	public Integer getIdSolicitud(){
		return this.idSolicitud;
	}
	
	public void setIdSolicitud(Integer idSolicitud){
	
		this.idSolicitud = idSolicitud;
	}
	
	public String getFasAfiliadosCorreo(){
		return this.fasAfiliadosCorreo;
	}
	
	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo){
	
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}
		
	public BigDecimal getFasConveniosIdConvenio(){
		return this.fasConveniosIdConvenio;
	}
	
	public void setFasConveniosIdConvenio(BigDecimal fasConveniosIdConvenio){
	
		this.fasConveniosIdConvenio = fasConveniosIdConvenio;
	}
		

    public FasAfiliados getFasAfiliadosfasSolConvFasAfiliFk(){
		return this.fasAfiliadosfasSolConvFasAfiliFk; 
	}
	
	public void setFasAfiliadosfasSolConvFasAfiliFk(FasAfiliados fasAfiliadosfasSolConvFasAfiliFk){
		this.fasAfiliadosfasSolConvFasAfiliFk = fasAfiliadosfasSolConvFasAfiliFk;
	}
    public FasConvenios getFasConveniosfasSolConvFasConvFk(){
		return this.fasConveniosfasSolConvFasConvFk; 
	}
	
	public void setFasConveniosfasSolConvFasConvFk(FasConvenios fasConveniosfasSolConvFasConvFk){
		this.fasConveniosfasSolConvFasConvFk = fasConveniosfasSolConvFasConvFk;
	}

	/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
		
		boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_SOL_CONVENIOS) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
    
    public static String[] getAtributosEntidadFasSolConvenios() {
		return ATRIBUTOS_ENTIDAD_FAS_SOL_CONVENIOS;
	}

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 37 * hash + Objects.hashCode(this.idSolicitud);        
        hash = 37 * hash + Objects.hashCode(this.fasAfiliadosCorreo);
        hash = 37 * hash + Objects.hashCode(this.fasConveniosIdConvenio);
        
        return hash;
    }

	/**
     * Valida la igualdad de la instancia de la entidad FasSolConvenios que se pasa
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
        final FasSolConvenios other = (FasSolConvenios) obj;
        
        if (!Objects.equals(this.idSolicitud, other.idSolicitud)) {
            return false;
        }
        
        if (!Objects.equals(this.fasAfiliadosCorreo, other.fasAfiliadosCorreo)) {
            return false;
        }
        
        return Objects.equals(this.fasConveniosIdConvenio, other.fasConveniosIdConvenio);
                
    }
	
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end

} 

