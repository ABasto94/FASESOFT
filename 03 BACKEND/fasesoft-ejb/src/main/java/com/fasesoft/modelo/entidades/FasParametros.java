package com.fasesoft.modelo.entidades;

import java.math.BigDecimal;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasesoft.modelo.dtos.FasDetallePagoDTO;
import com.fasesoft.modelo.dtos.FasParametrosDTO;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;
/**
 * The persistent class for the CATEGORIES database table.
 *
 */
@Entity
@Table(name="FAS_PARAMETROS")
@SqlResultSetMapping( 	name= ConstantesConsultas.RESULT_MAPPING_PARAMETROS,
	classes = {
	 @ConstructorResult(targetClass = FasParametrosDTO.class,
	 columns = { 
			 @ColumnResult(name="codigo"),    
			 @ColumnResult(name="descripcion"),
			 @ColumnResult(name="valor"),
})})
public class FasParametros {
	
	private static final long serialVersionUID = 1L;
	
	//Definicion de atributos de la entidad (Exceptuando relaciones)
	public static final String ENTIDAD_FAS_PARAMETROS_CODIGO_PK = "codigo";
	public static final String ENTIDAD_FAS_PARAMETROS_VALOR = "valor";
	public static final String ENTIDAD_FAS_PARAMETROS_DESCRIPCION= "descripcion";

    private static final String[] ATRIBUTOS_ENTIDAD_FAS_PARAMETROS
            = {ENTIDAD_FAS_PARAMETROS_CODIGO_PK, ENTIDAD_FAS_PARAMETROS_VALOR, ENTIDAD_FAS_PARAMETROS_DESCRIPCION};

	@Id
    @Column(name="CODIGO")
	private BigDecimal codigo;

	@Column(name="VALOR")
	@Size(min=0, max= 1000)
	private String valor;

	
	@Column(name="DESCRIPCION")
	@Size(min=0, max= 250)
	private String descripcion;
	

	public BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
    public FasParametros(){
		// protected region procedimientos adicionales de inicialización on begin
		// Escriba en esta sección sus modificaciones

		// protected region procedimientos adicionales de inicialización end
    }
	/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
		
		boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_PARAMETROS) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
    
    public static String[] getAtributosEntidadFasTiposConvenio() {
		return ATRIBUTOS_ENTIDAD_FAS_PARAMETROS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		FasParametros other = (FasParametros) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

    
	// protected region metodos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region metodos adicionales end
}
