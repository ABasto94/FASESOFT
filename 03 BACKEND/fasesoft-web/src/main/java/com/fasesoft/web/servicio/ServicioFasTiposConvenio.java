package com.fasesoft.web.servicio;

import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.dtos.FasTiposConvenioDTO;
import java.util.List;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;

import com.fasesoft.modelo.entidades.FasTiposConvenio;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.InformacionOrdenamiento;
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
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Servicios REST para operaciones CRUD y de negocio sobre la entidad FasTiposConvenio
 * @author GeneradorCRUD
 */
@Stateless
@Path("servicios/fastiposconvenio")
public class ServicioFasTiposConvenio {

    @EJB
    private NegocioFasTiposConvenio negocioFasTiposConvenio;

    /**
     * Variable estatica para imprimir logs...
     */
    private static final Logger logger = Logger.getLogger(ServicioFasTiposConvenio.class.getName());

    /**
     * Realiza un consulta en la entidad FasTiposConvenio aplicando los filtros, el ordenamiento,
     * y el rango (from y to) que se pasan como parámetro. Los parámetros filterBy y orderBy
     * pueden ser nulos. El parámetro from y to están relacionados. Si from es diferente de nulo
     * to puedo ser nulo, pero no al revés. Ambos pueden ser nulos, en cuyo caso no se aplica una
     * restricción de rango a la consulta.
     * 
     * @param filterBy Cadena de caracteres con los parámetros de filtrado. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere filtrar, seguido por un operador
     * de comparación que puede tomar los valores {@literal '=', '<', '<=', '>', '>=', ':NOTLIKE:', ':LIKE:'}, y por último el valor
     * por el que se quiere filtrar. Los filtros se concatenan por el símbolo {@literal '&' (AND) o '|' (OR)}.
     * Ej. Una secuencia de parámetros de filtrado puede ser {@literal fasTiposConvenioId>1&fasTiposConvenioName:LIKE:juan}
     * @param orderBy Cadena de caracteres con los parámetros de ordenamiento. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere ordenar, seguido por el símbolo '$' y 
     * posteriormente por los valores 'ASC' o 'DESC'. Estos dos ultimos valores son opcionales ya que si
     * no se especifica por defecto se asume que el ordenamiento es de forma Ascendente. Si se coloca más de un
     * parámetro debe ir separado por coma : ','.
     * Ej. Una secuencia de parámetros de ordenamiento puede ser: fasTiposConvenioId$ASC, fasTiposConvenioName$DESC
     * @param from Número de registro inicial que se quiere retornar de la consulta realizada. Entero mayor o igual a 0
     * @param to Número de registro final que se quiere retornar de la consulta realizada. Entero mayor o igual al parámetro from
     * @return Una lista de DAOs de los FasTiposConvenio que se consultaron con los parámetros enviados por el cliente
     * @throws InvalidParameterException Excepción lanzada cuando algunos de los parámetros de la url tenía un error de sintáxis por lo que no pudo ser procesado correctamente
     */
    @GET
    @Produces({APPLICATION_JSON})
    public List<FasTiposConvenioDTO> consultar(@QueryParam("filterBy") String filterBy, 
                @QueryParam("orderBy") String orderBy, @QueryParam("from") Integer from,
                @QueryParam("to") Integer to) 
            throws InvalidParameterException {
        // protected region Use esta region para su implementacion on begin
        
        return negocioFasTiposConvenio.consultar(filterBy, orderBy, from, to);
        // protected region Use esta region para su implementacion end 
    }

    /**
     * Crea el fasTiposConvenio que se pasa como parámetro en la base de datos.
     * 
     * @param fasTiposConvenioDTO El DAO de la entidad FasTiposConvenio a crear. Este se envía en el cuerpo de la
     * solicitud POST como un objeto JSON.
     * @return El identificador de la insntancia de FasTiposConvenio recién creado
     */
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public FasTiposConvenioDTO crear(FasTiposConvenioDTO fasTiposConvenioDTO) {
        // protected region Use esta region para su implementacion on begin
    	System.out.println();
        return negocioFasTiposConvenio.crear(fasTiposConvenioDTO);
        // protected region Use esta region para su implementacion end 
        
    }

    /**
     * Actualiza en la base de datos el fasTiposConvenio que se pasa como parámetro.
     * 
     * @param fasTiposConvenioDTO El DAO de la entidad FasTiposConvenio a actualizar. Este se envía en el cuerpo de la
     * solicitud PUT como un objeto JSON.
     * @return El identificador de la instancia de la entidad FasTiposConvenio que ha sido actualizado
     */
    @PUT
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public FasTiposConvenioDTO actualizar(FasTiposConvenioDTO fasTiposConvenioDTO){
        // protected region Use esta region para su implementacion on begin

        return negocioFasTiposConvenio.actualizar(fasTiposConvenioDTO);
        // protected region Use esta region para su implementacion end
    }

    /**
     * Elimina el fasTiposConvenio con el identificador que se pasa como parámetro.
     * 
     * @param idTipoConvenio Valor del atributo del identificador de la instancia de la entidad  fasTiposConvenio a eliminar
     * @return El identificador del fasTiposConvenio que ha sido eliminado
     */
    @DELETE
    public String eliminar(@QueryParam("idTipoConvenio") Integer idTipoConvenio) {
        // protected region Use esta region para su implementacion on begin

        return negocioFasTiposConvenio.eliminar(idTipoConvenio);
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
     * Ej. Una secuencia de parámetros de filtrado puede ser {@literal fasTiposConvenioId>1&fasTiposConvenioName:LIKE:juan}
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

        return negocioFasTiposConvenio.contar(filterBy, from, to);
        // protected region Use esta region para su implementacion end
    }    
    
    /**
     * 
     * @param filterBy Cadena de caracteres con los parámetros de filtrado. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere filtrar, seguido por un operador
     * de comparación que puede tomar los valores {@literal '=', '<', '<=', '>', '>=', ':NOTLIKE:', ':LIKE:'}, y por último el valor
     * por el que se quiere filtrar. Los filtros se concatenan por el símbolo {@literal '&' (AND) o '|' (OR)}.
     * Ej. Una secuencia de parámetros de filtrado puede ser {@literal fasTiposConvenioId>1&fasTiposConvenioName:LIKE:juan}
     * @param orderBy Cadena de caracteres con los parámetros de ordenamiento. Cada parámetro
     * está compuesto por el nombre del campo por el que se quiere ordenar, seguido por el símbolo '$' y 
     * posteriormente por los valores 'ASC' o 'DESC'. Estos dos ultimos valores son opcionales ya que si
     * no se especifica por defecto se asume que el ordenamiento es de forma Ascendente. Si se coloca más de un
     * parámetro debe ir separado por coma : ','.
     * Ej. Una secuencia de parámetros de ordenamiento puede ser: fasTiposConvenioId$ASC, fasTiposConvenioName$DESC
     * @param atributo Nombre del atributo de la entidad FasTiposConvenio del cual se quieren obtener los diferentes valores.
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
        return negocioFasTiposConvenio.consultarLista(filterBy, orderBy, atributo);
        // protected region Use esta region para su implementacion end
    }     
    
    // protected region Use esta region para su implementacion de otros servicios on begin
    
    // protected region Use esta region para su implementacion de otros servicios end
    
}
