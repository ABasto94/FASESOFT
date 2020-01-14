	package com.fasesoft.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Size;

import com.fasesoft.modelo.dtos.FasAhorrosDTO;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

import uk.co.jemos.podam.annotations.PodamExclude;

/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name="FAS_AHORROS")
@SqlResultSetMappings({
    @SqlResultSetMapping(name = ConstantesConsultas.RESULT_MAPPING_APORTE_PERMANENTE,
    		classes= {@ConstructorResult(targetClass = FasAhorrosDTO.class,
    		columns= {
    				
    				@ColumnResult(name="id_ahorro"),
    				@ColumnResult(name="monto"),
    				@ColumnResult(name="fecha_inicio"),
    				@ColumnResult(name="estado"),
    				@ColumnResult(name="aporte"),
    				@ColumnResult(name="fas_afiliados_correo"),
    				@ColumnResult(name="fas_tipos_aho_id_tipo_aho"),
    				@ColumnResult(name="fecha_solicitud"),
    				@ColumnResult(name="fecha_inicio_aporte")
    		})}
    ),
        @SqlResultSetMapping(name = ConstantesConsultas.RESULT_MAPPING_CONSULTAR_AHORROS_POR_CORREO,
        		classes= {@ConstructorResult(targetClass = FasAhorrosDTO.class,
        		columns= {
        				
        				@ColumnResult(name="monto"),
        				@ColumnResult(name="fechaInicio",type=Date.class),
        				@ColumnResult(name="estado"),
        				@ColumnResult(name="aporte"),
        				@ColumnResult(name="fasAfiliadosCorreo"),
        				@ColumnResult(name="fecha_inicio_aporte",type=Date.class)
        		})})
      
    })
 


@NamedQueries({ @NamedQuery(name = "FasAhorros.findAll", query = "SELECT p FROM FasAhorros p"),
    			@NamedQuery (name = "Ahorro.NuevoAporte", query = "UPDATE FasAhorros f SET f.estado = 'INACTIVO' WHERE f.idAhorro = ?1"),
    			@NamedQuery(name = "FasAhorros.findSavingsByEmail", query = "SELECT p FROM FasAhorros p WHERE p.fasAfiliadosCorreo = :paramCorreo"),
    			@NamedQuery(name = "FasAhorros.voluntarioPendiente", query = "SELECT a FROM FasAhorros a LEFT JOIN a.fasTiposDeAhorrofasAhorFasTiposAhoFk ah WHERE ah.tipo='AHORRO VOLUNTARIO' AND a.estado='PENDIENTE'")
			 })
public class FasAhorros implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_AHORROS_PK = "idAhorro";
	public static final String ENTIDAD_FAS_AHORROS_MONTO = "monto";
	public static final String ENTIDAD_FAS_AHORROS_FECHA_INICIO = "fechaInicio";
	public static final String ENTIDAD_FAS_AHORROS_ESTADO = "estado";
	public static final String ENTIDAD_FAS_AHORROS_APORTE = "aporte";
	public static final String ENTIDAD_FAS_AHORROS_FAS_AFILIADOS_CORREO = "fasAfiliadosCorreo";
	public static final String ENTIDAD_FAS_AHORROS_FAS_TIPOS_AHO_ID_TIPO_AHO = "fasTiposAhoIdTipoAho";
	public static final String ENTIDAD_FAS_AHORROS_FECHA_SOLICITUD = "fechaSolicitud";
	public static final String ENTIDAD_FAS_AHORROS_FECHA_INICIO_APORTE = "fechaInicioAporte";
	public static final String ENTIDAD_FAS_AHORROS_CODAHORRO= "codAhorro";
    private static final String[] ATRIBUTOS_ENTIDAD_FAS_AHORROS
            = {ENTIDAD_FAS_AHORROS_FECHA_SOLICITUD, ENTIDAD_FAS_AHORROS_FECHA_INICIO, ENTIDAD_FAS_AHORROS_MONTO, ENTIDAD_FAS_AHORROS_FAS_TIPOS_AHO_ID_TIPO_AHO, ENTIDAD_FAS_AHORROS_FECHA_INICIO_APORTE, ENTIDAD_FAS_AHORROS_PK, ENTIDAD_FAS_AHORROS_ESTADO, ENTIDAD_FAS_AHORROS_FAS_AFILIADOS_CORREO, ENTIDAD_FAS_AHORROS_APORTE, ENTIDAD_FAS_AHORROS_CODAHORRO};

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AHORROS_SEQ")
	@SequenceGenerator(name = "AHORROS_SEQ", sequenceName = "SEQ_AHORRO", allocationSize = 1)
    @Column(name="ID_AHORRO")
	private Number idAhorro;

@Column(name="MONTO")
private BigDecimal monto;

@Column(name="FECHA_INICIO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
private Date fechaInicio;

@Column(name="ESTADO")
@Size(min=0, max= 20)
private String estado;

@Column(name="APORTE")
private BigDecimal aporte;

    @PodamExclude
@Column(name="FAS_AFILIADOS_CORREO")
@Size(min=0, max= 40)
private String fasAfiliadosCorreo;

    @PodamExclude
@Column(name="FAS_TIPOS_AHO_ID_TIPO_AHO")
private BigDecimal fasTiposAhoIdTipoAho;

@Column(name="FECHA_SOLICITUD")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
private Date fechaSolicitud;

@Column(name="FECHA_INICIO_APORTE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
private Date fechaInicioAporte;

@Column(name="CODAHORRO")
private BigDecimal codAhorro;


@ManyToOne
@JoinColumn(name="FAS_AFILIADOS_CORREO", referencedColumnName="CORREO", insertable = false, updatable = false)
@PodamExclude
    private FasAfiliados fasAfiliadosfasAhorrosFasAfiliadosFk;
   
 
@ManyToOne
@JoinColumn(name="FAS_TIPOS_AHO_ID_TIPO_AHO", referencedColumnName="ID_TIPO_DE_AHORRO", insertable = false, updatable = false)
@PodamExclude
    private FasTiposDeAhorro fasTiposDeAhorrofasAhorFasTiposAhoFk;
   
 
@OneToMany(mappedBy="fasAhorrosfasAportesFasAhorrosFk")
@PodamExclude
    private List<FasAportes> fasAportesFasAhorrosFkes;

// protected region atributos adicionales on begin
// Escriba en esta sección sus modificaciones

// protected region atributos adicionales end

    public FasAhorros(){
 // protected region procedimientos adicionales de inicialización on begin
 // Escriba en esta sección sus modificaciones

 // protected region procedimientos adicionales de inicialización end
    }


	public Number getIdAhorro(){
		return this.idAhorro;
	}
	
	public void setIdAhorro(Number idAhorro){
	
		this.idAhorro = idAhorro;
	}
	
	public BigDecimal getMonto(){
		return this.monto;
	}
	
	public void setMonto(BigDecimal monto){
	
		this.monto = monto;
	}
		
	public Date getFechaInicio(){
		return this.fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio){
	
		this.fechaInicio = fechaInicio;
	}
		
	public String getEstado(){
		return this.estado;
	}
	
	public void setEstado(String estado){
	
		this.estado = estado;
	}
		
	public BigDecimal getAporte(){
		return this.aporte;
	}
	
	public void setAporte(BigDecimal aporte){
	
		this.aporte = aporte;
	}
		
	public String getFasAfiliadosCorreo(){
		return this.fasAfiliadosCorreo;
	}
	
	public void setFasAfiliadosCorreo(String fasAfiliadosCorreo){
	
		this.fasAfiliadosCorreo = fasAfiliadosCorreo;
	}
		
	public BigDecimal getFasTiposAhoIdTipoAho(){
		return this.fasTiposAhoIdTipoAho;
	}
	
	public void setFasTiposAhoIdTipoAho(BigDecimal fasTiposAhoIdTipoAho){
	
		this.fasTiposAhoIdTipoAho = fasTiposAhoIdTipoAho;
	}
		
	public Date getFechaSolicitud(){
		return this.fechaSolicitud;
	}
	
	public void setFechaSolicitud(Date fechaSolicitud){
	
		this.fechaSolicitud = fechaSolicitud;
	}
		
	public Date getFechaInicioAporte(){
		return this.fechaInicioAporte;
	}
	
	public void setFechaInicioAporte(Date fechaInicioAporte){
	
		this.fechaInicioAporte = fechaInicioAporte;
	}
	
	
    public BigDecimal getCodAhorro() {
		return codAhorro;
	}


	public void setCodAhorro(BigDecimal codAhorro) {
		this.codAhorro = codAhorro;
	}


	public List<FasAportes> getFasAportesFasAhorrosFkesList(){
 return this.fasAportesFasAhorrosFkes;
}

public void setFasAportesFasAhorrosFkesList(List<FasAportes> fasAportesFasAhorrosFkes){
 this.fasAportesFasAhorrosFkes = fasAportesFasAhorrosFkes;
}
 
    public FasAfiliados getFasAfiliadosfasAhorrosFasAfiliadosFk(){
 return this.fasAfiliadosfasAhorrosFasAfiliadosFk;
}

public void setFasAfiliadosfasAhorrosFasAfiliadosFk(FasAfiliados fasAfiliadosfasAhorrosFasAfiliadosFk){
 this.fasAfiliadosfasAhorrosFasAfiliadosFk = fasAfiliadosfasAhorrosFasAfiliadosFk;
}
    public FasTiposDeAhorro getFasTiposDeAhorrofasAhorFasTiposAhoFk(){
 return this.fasTiposDeAhorrofasAhorFasTiposAhoFk;
}

public void setFasTiposDeAhorrofasAhorFasTiposAhoFk(FasTiposDeAhorro fasTiposDeAhorrofasAhorFasTiposAhoFk){
 this.fasTiposDeAhorrofasAhorFasTiposAhoFk = fasTiposDeAhorrofasAhorFasTiposAhoFk;
}

/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
 
 boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_AHORROS) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
   
    public static String[] getAtributosEntidadFasAhorros() {
 return ATRIBUTOS_ENTIDAD_FAS_AHORROS;
}

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
       
        hash = 37 * hash + Objects.hashCode(this.idAhorro);        
        hash = 37 * hash + Objects.hashCode(this.monto);
        hash = 37 * hash + Objects.hashCode(this.fechaInicio);
        hash = 37 * hash + Objects.hashCode(this.estado);
        hash = 37 * hash + Objects.hashCode(this.aporte);
        hash = 37 * hash + Objects.hashCode(this.fasAfiliadosCorreo);
        hash = 37 * hash + Objects.hashCode(this.fasTiposAhoIdTipoAho);
        hash = 37 * hash + Objects.hashCode(this.fechaSolicitud);
        hash = 37 * hash + Objects.hashCode(this.fechaInicioAporte);
       
        return hash;
    }

/**
     * Valida la igualdad de la instancia de la entidad FasAhorros que se pasa
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
        final FasAhorros other = (FasAhorros) obj;
       
        if (!Objects.equals(this.idAhorro, other.idAhorro)) {
            return false;
        }
       
        if (!Objects.equals(this.monto, other.monto)) {
            return false;
        }
       
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
       
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
       
        if (!Objects.equals(this.aporte, other.aporte)) {
            return false;
        }
       
        if (!Objects.equals(this.fasAfiliadosCorreo, other.fasAfiliadosCorreo)) {
            return false;
        }
       
        if (!Objects.equals(this.fasTiposAhoIdTipoAho, other.fasTiposAhoIdTipoAho)) {
            return false;
        }
       
        if (!Objects.equals(this.fechaSolicitud, other.fechaSolicitud)) {
            return false;
        }
       
        return Objects.equals(this.fechaInicioAporte, other.fechaInicioAporte);
               
    }

// protected region metodos adicionales on begin
// Escriba en esta sección sus modificaciones

// protected region metodos adicionales end

}
