package com.fasesoft.modelo.manejadores;

import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;
import com.fasesoft.modelo.entidades.FasTiposDeAhorro;
import java.math.BigDecimal;
import javax.ejb.Stateless;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre
 * la tabla correspondiente a la entidad FasTiposDeAhorro.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasTiposDeAhorro extends ManejadorCrud<FasTiposDeAhorro,Integer>{
	

    public ManejadorFasTiposDeAhorro() {
        super(FasTiposDeAhorro.class);
    }   
    
    // protected region Use esta region para su implementacion del manejador on begin 
    
    // protected region Use esta region para su implementacion del manejador end        
}

