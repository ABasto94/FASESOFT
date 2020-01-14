package com.fasesoft.web.servicio;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.dtos.FasAhorrosDTO;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.websocket.server.PathParam;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;

import com.fasesoft.modelo.dtos.FasAhorrosDTO;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.negocio.NegocioFasAhorros;

/**
 * Servicios REST para operaciones CRUD y de negocio sobre la entidad FasAhorros
 * 
 * @author GeneradorCRUD
 */
@Stateless
@Path("servicios/fasahorros")
public class ServicioFasAhorros {

    @EJB
    private NegocioFasAhorros negocioFasAhorros;

    /**
     * Variable estatica para imprimir logs...
     */
    private static final Logger logger = Logger.getLogger(ServicioFasAhorros.class.getName());

    /**
     * Realiza un consulta en la entidad FasAhorros aplicando los filtros, el ordenamiento,
     * y el rango (from y to) que se pasan como parámetro. Los parámetros filterBy y orderBy
     * pueden ser nulos. El parámetro from y to están relacionados. Si from es diferente de nulo
     * to puedo ser nulo, pero no al revés. Ambos pueden ser nulos, en cuyo caso no se aplica una
     * restricción de rango a la consulta.
     * 
     * @param filterBy Cadena de caracteres con los parámetros de filtrado. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere filtrar, seguido por un operador
     * de comparación que puede tomar los valores {@literal '=', '<', '<=', '>', '>=', ':NOTLIKE:', ':LIKE:'}, y por último el valor
     * por el que se quiere filtrar. Los filtros se concatenan por el símbolo {@literal '&' (AND) o '|' (OR)}.
     * Ej. Una secuencia de parámetros de filtrado puede ser {@literal fasAhorrosId>1&fasAhorrosName:LIKE:juan}
     * @param orderBy Cadena de caracteres con los parámetros de ordenamiento. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere ordenar, seguido por el símbolo '$' y 
     * posteriormente por los valores 'ASC' o 'DESC'. Estos dos ultimos valores son opcionales ya que si
     * no se especifica por defecto se asume que el ordenamiento es de forma Ascendente. Si se coloca más de un
     * parámetro debe ir separado por coma : ','.
     * Ej. Una secuencia de parámetros de ordenamiento puede ser: fasAhorrosId$ASC, fasAhorrosName$DESC
     * @param from Número de registro inicial que se quiere retornar de la consulta realizada. Entero mayor o igual a 0
     * @param to Número de registro final que se quiere retornar de la consulta realizada. Entero mayor o igual al parámetro from
     * @return Una lista de DAOs de los FasAhorros que se consultaron con los parámetros enviados por el cliente
     * @throws InvalidParameterException Excepción lanzada cuando algunos de los parámetros de la url tenía un error de sintáxis por lo que no pudo ser procesado correctamente
     */
    @GET
    @Produces({APPLICATION_JSON})
    public List<FasAhorrosDTO> consultar(@QueryParam("filterBy") String filterBy, 
                @QueryParam("orderBy") String orderBy, @QueryParam("from") Integer from,
                @QueryParam("to") Integer to) 
            throws InvalidParameterException {
        // protected region Use esta region para su implementacion on begin
        
        return negocioFasAhorros.consultar(filterBy, orderBy, from, to);
        // protected region Use esta region para su implementacion end 
    }
    
    @GET
    @Path("correo")
    @Produces({APPLICATION_JSON})
    public List<FasAhorrosDTO> consultarAhorroVoluntario(@QueryParam("correo") String correo)
    	throws InvalidParameterException {
    	return negocioFasAhorros.consultarAhorroVoluntario(correo);
    	
    }

    /**
     * Crea el fasAhorros que se pasa como parámetro en la base de datos.
     * 
     * @param fasAhorrosDTO El DAO de la entidad FasAhorros a crear. Este se envía en el cuerpo de la
     * solicitud POST como un objeto JSON.
     * @return El identificador de la insntancia de FasAhorros recién creado
     */
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public FasAhorrosDTO crear(FasAhorrosDTO fasAhorrosDTO) {
        // protected region Use esta region para su implementacion on begin
;
        return negocioFasAhorros.crear(fasAhorrosDTO);
        // protected region Use esta region para su implementacion end 
        
    }

    /**
     * Actualiza en la base de datos el fasAhorros que se pasa como parámetro.
     * 
     * @param fasAhorrosDTO El DAO de la entidad FasAhorros a actualizar. Este se envía en el cuerpo de la
     * solicitud PUT como un objeto JSON.
     * @return El identificador de la instancia de la entidad FasAhorros que ha sido actualizado
     */
    @PUT
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public FasAhorrosDTO actualizar(FasAhorrosDTO fasAhorrosDTO){
        // protected region Use esta region para su implementacion on begin

        return negocioFasAhorros.actualizar(fasAhorrosDTO);
        // protected region Use esta region para su implementacion end
    }
    
    @PUT
    @Path("actualizaraportespermanentes")
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public int actualizarAportePermanente(FasAhorrosDTO fasAhorrosDTO){
       
    	return negocioFasAhorros.actualizarAportePermanente(fasAhorrosDTO);
        
    }


   // String correo = "jfgarcia@asesoftware.com";
    
    @GET
    @Path("aportespermanentes")
    @Produces({APPLICATION_JSON})
    public List<FasAhorrosDTO> consultarAportePermanente(@QueryParam("correo") String correo)
            throws InvalidParameterException{
        // protected region Use esta region para su implementacion on begin
    
        return negocioFasAhorros.consultarAportePermanente(correo);
        // protected region Use esta region para su implementacion end
    }

    /**
     * Elimina el fasAhorros con el identificador que se pasa como parámetro.
     * 
     * @param idAhorro Valor del atributo del identificador de la instancia de la entidad  fasAhorros a eliminar
     * @return El identificador del fasAhorros que ha sido eliminado
     */
    @DELETE
    public String eliminar(@QueryParam("idAhorro") Integer idAhorro) {
        // protected region Use esta region para su implementacion on begin

        return negocioFasAhorros.eliminar(idAhorro);
        // protected region Use esta region para su implementacion end
    }

    /**
     * Cuenta la cantidad de registros que devuelve la consulta a la tabla de 
     * aplicando los filtros o rangos que se pasen como parámetro. Estos 
     * pueden ser nulos, en cuyo caso a la consulta no se le realiza ningún tipo de
     * filtrado.
     * 
     * @param filterBy Cadena de caracteres con los parámetros de filtrado. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere filtrar, seguido por un operador
     * de comparación que puede tomar los valores {@literal '=', '<', '<=', '>', '>=', ':NOTLIKE:', ':LIKE:'}, y por último el valor
     * por el que se quiere filtrar. Los filtros se concatenan por el símbolo {@literal '&' (AND) o '|' (OR)}.
     * Ej. Una secuencia de parámetros de filtrado puede ser {@literal fasAhorrosId>1&fasAhorrosName:LIKE:juan}
     * @param from Número de registro inicial que se quiere retornar de la consulta realizada. Entero mayor o igual a 0
     * @param to Número de registro final que se quiere retornar de la consulta realizada. Entero mayor o igual al parámetro from
     * @return El número de registros contados a partir de los parámetros enviados por el cliente
     * @throws InvalidParameterException Excepción lanzada cuando algunos de los parámetros de la url tenía un error de sintáxis por lo que no pudo ser procesado correctamente
     */
    @GET
    @Path("contar")
    @Produces(TEXT_PLAIN)
    public String contar(@QueryParam("filterBy") String filterBy,
             @QueryParam("from") Integer from,
                @QueryParam("to") Integer to) throws InvalidParameterException {        
        // protected region Use esta region para su implementacion on begin

        return negocioFasAhorros.contar(filterBy, from, to);
        // protected region Use esta region para su implementacion end
    }    
    
    /**
     * 
     * @param filterBy Cadena de caracteres con los parámetros de filtrado. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere filtrar, seguido por un operador
     * de comparación que puede tomar los valores {@literal '=', '<', '<=', '>', '>=', ':NOTLIKE:', ':LIKE:'}, y por último el valor
     * por el que se quiere filtrar. Los filtros se concatenan por el símbolo {@literal '&' (AND) o '|' (OR)}.
     * Ej. Una secuencia de parámetros de filtrado puede ser {@literal fasAhorrosId>1&fasAhorrosName:LIKE:juan}
     * @param orderBy Cadena de caracteres con los parámetros de ordenamiento. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere ordenar, seguido por el símbolo '$' y 
     * posteriormente por los valores 'ASC' o 'DESC'. Estos dos ultimos valores son opcionales ya que si
     * no se especifica por defecto se asume que el ordenamiento es de forma Ascendente. Si se coloca más de un
     * parámetro debe ir separado por coma : ','.
     * Ej. Una secuencia de parámetros de ordenamiento puede ser: fasAhorrosId$ASC, fasAhorrosName$DESC
     * @param atributo Nombre del atributo de la entidad FasAhorros del cual se quieren obtener los diferentes valores.
     * @return Una lista con los diferentes valores que se encuentran en la columna de la tabla asociada al atributo.
     * @throws InvalidParameterException Si el atributo no existe en la entidad o si los filtros y el ordenamiento 
     * contienen atributos de la entidad que no existen.
     */
    @GET
    @Path("lista")
    @Produces({APPLICATION_JSON})
    public List<String> consultarLista(@QueryParam("filterBy") String filterBy,
             @QueryParam("orderBy") String orderBy, @QueryParam("atributo") String atributo) throws InvalidParameterException{
        // protected region Use esta region para su implementacion on begin
        return negocioFasAhorros.consultarLista(filterBy, orderBy, atributo);
        // protected region Use esta region para su implementacion end
    }     
    
    // protected region Use esta region para su implementacion de otros servicios on begin
    
    @POST
    @Path("crearnuevoaporte")
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public FasAhorrosDTO crearNuevoAporte(FasAhorrosDTO fasAhorrosDTO) {
        return negocioFasAhorros.crearNuevoAporte(fasAhorrosDTO);
        
    }
    
	@GET
	@Path("solicitudesVoluntarioPendientes")
	@Produces({ APPLICATION_JSON })
	public List<FasAhorrosDTO> consultarSolicitudesVoluntariasPendientes() throws InvalidParameterException {
		// protected region Use esta region para su implementacion on begin
		return negocioFasAhorros.consultarSolicitudesVoluntarias();
		// protected region Use esta region para su implementacion end
	}
    
    // protected region Use esta region para su implementacion de otros servicios end

}
