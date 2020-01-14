package com.fasesoft.web.servicio;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.dtos.FasCreditosDTO;
import com.fasesoft.modelo.dtos.FasExtractosDTO;
import com.fasesoft.modelo.dtos.FasGeneracionExtractoDTO;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;

import com.fasesoft.modelo.dtos.FasExtractosDTO;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.negocio.NegocioFasExtractos;

/**
 * Servicios REST para operaciones CRUD y de negocio sobre la entidad
 * FasExtractos
 * 
 * @author GeneradorCRUD
 */
@Stateless
@Path("servicios/fasextractos")
public class ServicioFasExtractos{

    @EJB
    private NegocioFasExtractos negocioFasExtractos;

    /**
     * Variable estatica para imprimir logs...
     */
    private static final Logger logger = Logger.getLogger(ServicioFasExtractos.class.getName());

    @GET
    @Produces({APPLICATION_JSON})
    public List<FasExtractosDTO> consultar(@QueryParam("filterBy") String filterBy, 
                @QueryParam("orderBy") String orderBy, @QueryParam("from") Integer from,
                @QueryParam("to") Integer to) 
            throws InvalidParameterException {
        // protected region Use esta region para su implementacion on begin
        
        return negocioFasExtractos.consultar(filterBy, orderBy, from, to);
        // protected region Use esta region para su implementacion end 
    }

    
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public FasExtractosDTO crear(FasExtractosDTO fasExtractosDTO) {
        // protected region Use esta region para su implementacion on begin

        return negocioFasExtractos.crear(fasExtractosDTO);
        // protected region Use esta region para su implementacion end 
        
    }

    
    @PUT
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public FasExtractosDTO actualizar(FasExtractosDTO fasExtractosDTO){
        // protected region Use esta region para su implementacion on begin

        return negocioFasExtractos.actualizar(fasExtractosDTO);
        // protected region Use esta region para su implementacion end
    }

    
    @DELETE
    public String eliminar(@QueryParam("idExtracto") BigDecimal idExtracto) {
        // protected region Use esta region para su implementacion on begin

        return negocioFasExtractos.eliminar(idExtracto);
        // protected region Use esta region para su implementacion end
    }

  
    @GET
    @Path("contar")
    @Produces(TEXT_PLAIN)
    public String contar(@QueryParam("filterBy") String filterBy,
             @QueryParam("from") Integer from,
                @QueryParam("to") Integer to) throws InvalidParameterException {        
        // protected region Use esta region para su implementacion on begin

        return negocioFasExtractos.contar(filterBy, from, to);
        // protected region Use esta region para su implementacion end
    }    
    
   
    @GET
    @Path("lista")
    @Produces({APPLICATION_JSON})
    public List<String> consultarLista(@QueryParam("filterBy") String filterBy,
             @QueryParam("orderBy") String orderBy, @QueryParam("atributo") String atributo) throws InvalidParameterException{
        // protected region Use esta region para su implementacion on begin
        return negocioFasExtractos.consultarLista(filterBy, orderBy, atributo);
        // protected region Use esta region para su implementacion end
    }     
    
    @GET
    @Path("generacionExtracto/{year}/{month}/{mes}")
    @Produces({APPLICATION_JSON})
    public List<FasGeneracionExtractoDTO> generarExtracto(@PathParam("year") int year,
            @PathParam("month") int month, @PathParam("mes") String mes
) {
        // protected region Use esta region para su implementacion on begin
        return negocioFasExtractos.consultarDatosExtracto(year, month, mes);        
        // protected region Use esta region para su implementacion end 
    }
    
    @GET
	@Path("extracto/{correo}")
	@Produces({ APPLICATION_JSON })
	public List<FasExtractosDTO> consultarExtractoPorAfiliado(@PathParam("correo") String correo)
			throws InvalidParameterException {
		return negocioFasExtractos.consultarExtractoPorAfiliado(correo);
	}
    
    /*@GET
    @Path("extracto")
    @Produces({APPLICATION_JSON})
    public List<FasGeneracionExtractoDTO> consultarExtractos() throws InvalidParameterException{
        // protected region Use esta region para su implementacion on begin
        return negocioFasExtractos.generarExtractos();
        // protected region Use esta region para su implementacion end
    }*/ 
    
    // protected region Use esta region para su implementacion de otros servicios on begin
    
    // protected region Use esta region para su implementacion de otros servicios end

}
