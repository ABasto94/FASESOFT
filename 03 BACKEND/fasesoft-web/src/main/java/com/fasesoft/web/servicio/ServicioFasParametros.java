package com.fasesoft.web.servicio;

import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.dtos.FasParametrosDTO;
import com.fasesoft.modelo.dtos.FasTiposConvenioDTO;
import java.util.List;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasTiposConvenio;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.InformacionOrdenamiento;
import com.fasesoft.negocio.NegocioFasAccesos;
import com.fasesoft.negocio.NegocioFasParametros;
import com.fasesoft.negocio.NegocioFasTiposConvenio;
import com.fasesoft.modelo.manejadores.utils.InformacionAgrupamiento;
import com.fasesoft.modelo.utils.UtilOperaciones;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.math.BigDecimal;

/**
 * Servicios REST para operaciones CRUD y de negocio sobre la entidad FasTiposConvenio
 * @author GeneradorCRUD
 */
@Stateless
@Path("servicios/fasParametros")
public class ServicioFasParametros{
	
	@EJB
	private NegocioFasParametros negocioFasParametros;
	
	private static final Logger logger = Logger.getLogger(ServicioFasParametros.class.getName());

	
	
	@GET
	@Produces({ APPLICATION_JSON })
	public List<FasParametrosDTO> consultarParmetros()
			throws InvalidParameterException {
		return negocioFasParametros.consultarParametros();
	}
    
    // protected region Use esta region para su implementacion de otros servicios on begin
    
    // protected region Use esta region para su implementacion de otros servicios end

}
