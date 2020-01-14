package com.fasesoft.modelo.manejadores;

import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;
import com.fasesoft.modelo.entidades.FasAportes;
import java.math.BigDecimal;
import javax.ejb.Stateless;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre
 * la tabla correspondiente a la entidad FasAportes.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasAportes extends ManejadorCrud<FasAportes,BigDecimal>{
	

    public ManejadorFasAportes() {
        super(FasAportes.class);
    }   
    
    // protected region Use esta region para su implementacion del manejador on begin 
    
    // protected region Use esta region para su implementacion del manejador end        
}

