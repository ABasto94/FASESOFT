package com.fasesoft.modelo.manejadores;

import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;
import com.fasesoft.modelo.dtos.FasDetallePagoDTO;
import com.fasesoft.modelo.entidades.FasPagos;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre
 * la tabla correspondiente a la entidad FasPagos.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasPagos extends ManejadorCrud<FasPagos,BigDecimal>{
	
    public ManejadorFasPagos() {
        super(FasPagos.class);
    }   
    
    public List<FasDetallePagoDTO> consultarPagosAfiliados(){
    	
		return this.mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVA_CONSULTAR_PAGOS_AFILIADO,null,ConstantesConsultas.RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_PAGOS_AFILIADO);
    	
    }
    // protected region Use esta region para su implementacion del manejador on begin 
    
    // protected region Use esta region para su implementacion del manejador end        
}

