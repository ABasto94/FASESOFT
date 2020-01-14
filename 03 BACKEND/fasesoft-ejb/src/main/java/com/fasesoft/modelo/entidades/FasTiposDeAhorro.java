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
@Table(name="FAS_TIPOS_DE_AHORRO")
@NamedQuery(name = "FasTiposDeAhorro.findAll", query = "SELECT p FROM FasTiposDeAhorro p")
public class FasTiposDeAhorro implements Serializable{

private static final long serialVersionUID = 1L;

//Definicion de atributos de la entidad (Exceptuando relaciones)
public static final String ENTIDAD_FAS_TIPOS_DE_AHORRO_PK = "idTipoDeAhorro";
public static final String ENTIDAD_FAS_TIPOS_DE_AHORRO_TIPO = "tipo";
public static final String ENTIDAD_FAS_TIPOS_DE_AHORRO_TASA = "tasa";
public static final String ENTIDAD_FAS_TIPOS_DE_AHORRO_DESCRIPCION = "descripcion";
    private static final String[] ATRIBUTOS_ENTIDAD_FAS_TIPOS_DE_AHORRO
            = {ENTIDAD_FAS_TIPOS_DE_AHORRO_TIPO, ENTIDAD_FAS_TIPOS_DE_AHORRO_DESCRIPCION, ENTIDAD_FAS_TIPOS_DE_AHORRO_TASA, ENTIDAD_FAS_TIPOS_DE_AHORRO_PK};

@Id
    @Column(name="ID_TIPO_DE_AHORRO")
private Integer idTipoDeAhorro;

@Column(name="TIPO")
@Size(min=0, max= 50)
private String tipo;

@Column(name="TASA")
private BigDecimal tasa;

@Column(name="DESCRIPCION")
@Size(min=0, max= 250)
private String descripcion;


@OneToMany(mappedBy="fasTiposDeAhorrofasAhorFasTiposAhoFk")
@PodamExclude
    private List<FasAhorros> fasAhorFasTiposAhoFkes;

// protected region atributos adicionales on begin
// Escriba en esta sección sus modificaciones

// protected region atributos adicionales end

    public FasTiposDeAhorro(){
 // protected region procedimientos adicionales de inicialización on begin
 // Escriba en esta sección sus modificaciones

 // protected region procedimientos adicionales de inicialización end
    }


public Integer getIdTipoDeAhorro(){
 return this.idTipoDeAhorro;
}

public void setIdTipoDeAhorro(Integer idTipoDeAhorro){

 this.idTipoDeAhorro = idTipoDeAhorro;
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
 

    public List<FasAhorros> getFasAhorFasTiposAhoFkesList(){
 return this.fasAhorFasTiposAhoFkes;
}

public void setFasAhorFasTiposAhoFkesList(List<FasAhorros> fasAhorFasTiposAhoFkes){
 this.fasAhorFasTiposAhoFkes = fasAhorFasTiposAhoFkes;
}
 

/**
     * Verifica si la entidad contiene el atributo que se pasa como parámetro
     *
     * @param atributo Nombre del atributo a validar
     * @return Verdadero si la entidad contiene al atributo.
     */
    public static boolean contieneAtributo(String atributo) {
 
 boolean contiene = false;
        for (final String atr : ATRIBUTOS_ENTIDAD_FAS_TIPOS_DE_AHORRO) {
            if (atr.equals(atributo)) {
                contiene = true;
            }
        }

        return contiene;
    }
   
    public static String[] getAtributosEntidadFasTiposDeAhorro() {
 return ATRIBUTOS_ENTIDAD_FAS_TIPOS_DE_AHORRO;
}

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 3;
       
        hash = 37 * hash + Objects.hashCode(this.idTipoDeAhorro);        
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.tasa);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
       
        return hash;
    }

/**
     * Valida la igualdad de la instancia de la entidad FasTiposDeAhorro que se pasa
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
        final FasTiposDeAhorro other = (FasTiposDeAhorro) obj;
       
        if (!Objects.equals(this.idTipoDeAhorro, other.idTipoDeAhorro)) {
            return false;
        }
       
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
       
        if (!Objects.equals(this.tasa, other.tasa)) {
            return false;
        }
       
        return Objects.equals(this.descripcion, other.descripcion);
               
    }

// protected region metodos adicionales on begin
// Escriba en esta sección sus modificaciones

// protected region metodos adicionales end

}

