package com.fasesoft.negocio;

import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.dtos.FasAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasParametrosDTO;
import com.fasesoft.modelo.dtos.FasTiposConvenioDTO;
import java.util.List;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasTiposConvenio;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.InformacionOrdenamiento;
import com.fasesoft.modelo.manejadores.ManejadorFasExtractos;
import com.fasesoft.modelo.manejadores.ManejadorFasParametros;
import com.fasesoft.modelo.manejadores.ManejadorFasTiposConvenio;
import com.fasesoft.modelo.manejadores.utils.InformacionAgrupamiento;
import com.fasesoft.modelo.utils.UtilOperaciones;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import java.util.Date;

import java.math.BigDecimal;
import com.fasesoft.modelo.manejadores.ManejadorFasParametros;

// protected region Incluya importaciones adicionales en esta seccion on begin


// protected region Incluya importaciones adicionales en esta seccion end


/**
 * Servicios para operaciones CRUD y de negocio sobre la entidad FasTiposConvenio
 * @author GeneradorCRUD
 */
@Stateless
public class NegocioFasParametros {
	@EJB
	private ManejadorFasParametros manejadorFasParametros;
	
	
	public List<FasParametrosDTO> consultarParametros() {
		return this.manejadorFasParametros.consultarParametros();
	}
}
