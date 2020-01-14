package com.fasesoft.web.servicio;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import com.fasesoft.modelo.dtos.FasAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasBeneficioIdentificacionDTO;
import com.fasesoft.modelo.dtos.FasDesafilacionAhorrosDTO;
import com.fasesoft.modelo.dtos.FasDesafilacionCreditosDTO;
import com.fasesoft.modelo.dtos.FasDetalleUsuarioDTO;
import com.fasesoft.modelo.dtos.FasSolicitudesAfiliacionDTO;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.negocio.NegocioFasAfiliados;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Servicios REST para operaciones CRUD y de negocio sobre la entidad
 * FasAfiliados
 * 
 * @author GeneradorCRUD
 */
@Stateless
@Path("servicios/fasafiliados")
public class ServicioFasAfiliados {

	@EJB
	private NegocioFasAfiliados negocioFasAfiliados;

	/**
	 * Variable estatica para imprimir logs...
	 */
	private static final Logger logger = Logger.getLogger(ServicioFasAfiliados.class.getName());

	/**
	 * Realiza un consulta en la entidad FasAfiliados aplicando los filtros, el
	 * ordenamiento, y el rango (from y to) que se pasan como parámetro. Los
	 * parámetros filterBy y orderBy pueden ser nulos. El parámetro from y to están
	 * relacionados. Si from es diferente de nulo to puedo ser nulo, pero no al
	 * revés. Ambos pueden ser nulos, en cuyo caso no se aplica una restricción de
	 * rango a la consulta.
	 * 
	 * @param filterBy Cadena de caracteres con los parámetros de filtrado. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere filtrar, seguido por un operador de comparación que
	 *                 puede tomar los valores
	 *                 {@literal '=', '<', '<=', '>', '>=', ':NOTLIKE:', ':LIKE:'},
	 *                 y por último el valor por el que se quiere filtrar. Los
	 *                 filtros se concatenan por el símbolo
	 *                 {@literal '&' (AND) o '|' (OR)}. Ej. Una secuencia de
	 *                 parámetros de filtrado puede ser
	 *                 {@literal fasAfiliadosId>1&fasAfiliadosName:LIKE:juan}
	 * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere ordenar, seguido por el símbolo '$' y
	 *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
	 *                 ultimos valores son opcionales ya que si no se especifica por
	 *                 defecto se asume que el ordenamiento es de forma Ascendente.
	 *                 Si se coloca más de un parámetro debe ir separado por coma :
	 *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
	 *                 ser: fasAfiliadosId$ASC, fasAfiliadosName$DESC
	 * @param from     Número de registro inicial que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual a 0
	 * @param to       Número de registro final que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual al parámetro from
	 * @return Una lista de DAOs de los FasAfiliados que se consultaron con los
	 *         parámetros enviados por el cliente
	 * @throws InvalidParameterException Excepción lanzada cuando algunos de los
	 *                                   parámetros de la url tenía un error de
	 *                                   sintáxis por lo que no pudo ser procesado
	 *                                   correctamente
	 */
	@GET
	@Produces({ APPLICATION_JSON })
	public List<FasAfiliadosDTO> consultar(@QueryParam("filterBy") String filterBy,
			@QueryParam("orderBy") String orderBy, @QueryParam("from") Integer from, @QueryParam("to") Integer to)
			throws InvalidParameterException {
		// protected region Use esta region para su implementacion on begin

		return negocioFasAfiliados.consultar(filterBy, orderBy, from, to);
		// protected region Use esta region para su implementacion end
	}

	/**
	 * Crea el fasAfiliados que se pasa como parámetro en la base de datos.
	 * 
	 * @param fasAfiliadosDTO El DAO de la entidad FasAfiliados a crear. Este se
	 *                        envía en el cuerpo de la solicitud POST como un objeto
	 *                        JSON.
	 * @return El identificador de la insntancia de FasAfiliados recién creado
	 */
	@POST
	@Consumes({ APPLICATION_JSON })
	@Produces({ APPLICATION_JSON })
	public FasAfiliadosDTO crear(FasAfiliadosDTO fasAfiliadosDTO) {
		// protected region Use esta region para su implementacion on begin

		return negocioFasAfiliados.crear(fasAfiliadosDTO);
		// protected region Use esta region para su implementacion end

	}

	/**
	 * Actualiza en la base de datos el fasAfiliados que se pasa como parámetro.
	 * 
	 * @param fasAfiliadosDTO El DAO de la entidad FasAfiliados a actualizar. Este
	 *                        se envía en el cuerpo de la solicitud PUT como un
	 *                        objeto JSON.
	 * @return El identificador de la instancia de la entidad FasAfiliados que ha
	 *         sido actualizado
	 */
	@PUT
	@Consumes({ APPLICATION_JSON })
	@Produces({ APPLICATION_JSON })
	public FasAfiliadosDTO actualizar(FasAfiliadosDTO fasAfiliadosDTO) {
		// protected region Use esta region para su implementacion on begin

		return negocioFasAfiliados.actualizar(fasAfiliadosDTO);
		// protected region Use esta region para su implementacion end
	}

	/**
	 * Elimina el fasAfiliados con el identificador que se pasa como parámetro.
	 * 
	 * @param correo Valor del atributo del identificador de la instancia de la
	 *               entidad fasAfiliados a eliminar
	 * @return El identificador del fasAfiliados que ha sido eliminado
	 */
	@DELETE
	public String eliminar(@QueryParam("correo") String correo) {
		// protected region Use esta region para su implementacion on begin

		return negocioFasAfiliados.eliminar(correo);
		// protected region Use esta region para su implementacion end
	}

	/**
	 * Cuenta la cantidad de registros que devuelve la consulta a la tabla de
	 * aplicando los filtros o rangos que se pasen como parámetro. Estos pueden ser
	 * nulos, en cuyo caso a la consulta no se le realiza ningún tipo de filtrado.
	 * 
	 * @param filterBy Cadena de caracteres con los parámetros de filtrado. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere filtrar, seguido por un operador de comparación que
	 *                 puede tomar los valores
	 *                 {@literal '=', '<', '<=', '>', '>=', ':NOTLIKE:', ':LIKE:'},
	 *                 y por último el valor por el que se quiere filtrar. Los
	 *                 filtros se concatenan por el símbolo
	 *                 {@literal '&' (AND) o '|' (OR)}. Ej. Una secuencia de
	 *                 parámetros de filtrado puede ser
	 *                 {@literal fasAfiliadosId>1&fasAfiliadosName:LIKE:juan}
	 * @param from     Número de registro inicial que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual a 0
	 * @param to       Número de registro final que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual al parámetro from
	 * @return El número de registros contados a partir de los parámetros enviados
	 *         por el cliente
	 * @throws InvalidParameterException Excepción lanzada cuando algunos de los
	 *                                   parámetros de la url tenía un error de
	 *                                   sintáxis por lo que no pudo ser procesado
	 *                                   correctamente
	 */
	@GET
	@Path("contar")
	@Produces(TEXT_PLAIN)
	public String contar(@QueryParam("filterBy") String filterBy, @QueryParam("from") Integer from,
			@QueryParam("to") Integer to) throws InvalidParameterException {
		// protected region Use esta region para su implementacion on begin

		return negocioFasAfiliados.contar(filterBy, from, to);
		// protected region Use esta region para su implementacion end
	}

	@GET
	@Path("afiliadosUsuarios")
	@Produces({ APPLICATION_JSON })
	public List<FasAfiliadosDTO> consultarAfiliadosUsuarios() {
		return negocioFasAfiliados.consultarAfiliadosUsuarios();
	}

	/**
	 * 
	 * @param filterBy Cadena de caracteres con los parámetros de filtrado. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere filtrar, seguido por un operador de comparación que
	 *                 puede tomar los valores
	 *                 {@literal '=', '<', '<=', '>', '>=', ':NOTLIKE:', ':LIKE:'},
	 *                 y por último el valor por el que se quiere filtrar. Los
	 *                 filtros se concatenan por el símbolo
	 *                 {@literal '&' (AND) o '|' (OR)}. Ej. Una secuencia de
	 *                 parámetros de filtrado puede ser
	 *                 {@literal fasAfiliadosId>1&fasAfiliadosName:LIKE:juan}
	 * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere ordenar, seguido por el símbolo '$' y
	 *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
	 *                 ultimos valores son opcionales ya que si no se especifica por
	 *                 defecto se asume que el ordenamiento es de forma Ascendente.
	 *                 Si se coloca más de un parámetro debe ir separado por coma :
	 *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
	 *                 ser: fasAfiliadosId$ASC, fasAfiliadosName$DESC
	 * @param atributo Nombre del atributo de la entidad FasAfiliados del cual se
	 *                 quieren obtener los diferentes valores.
	 * @return Una lista con los diferentes valores que se encuentran en la columna
	 *         de la tabla asociada al atributo.
	 * @throws InvalidParameterException Si el atributo no existe en la entidad o si
	 *                                   los filtros y el ordenamiento contienen
	 *                                   atributos de la entidad que no existen.
	 */

	@GET
	@Path("detalleUsuarioAres/{correo}")
	@Produces({ APPLICATION_JSON })
	public List<FasAfiliadosDTO> consultarUsuarioAres(@PathParam("correo") String correo)
			throws InvalidParameterException {
		// protected region Use esta region para su implementacion on begin
		return negocioFasAfiliados.consultarDetalleUsuarioAres(correo);
		// protected region Use esta region para su implementacion end
	}

	@GET
	@Path("lista")
	@Produces({ APPLICATION_JSON })
	public List<String> consultarLista(@QueryParam("filterBy") String filterBy, @QueryParam("orderBy") String orderBy,
			@QueryParam("atributo") String atributo) throws InvalidParameterException {
		// protected region Use esta region para su implementacion on begin
		return negocioFasAfiliados.consultarLista(filterBy, orderBy, atributo);
		// protected region Use esta region para su implementacion end
	}

	@GET
	@Path("ahorroAfiliado")
	@Produces({ APPLICATION_JSON })
	public List<FasAfiliadosDTO> consultarPorCorreo(@QueryParam("correo") String correo)
			throws InvalidParameterException {
		return negocioFasAfiliados.consultarPorCorreo(correo);
	}

	// protected region Use esta region para su implementacion de otros servicios on
	// begin

	// protected region Use esta region para su implementacion de otros servicios
	// end
	@GET
	@Path("detalleUsuario/{correo}")
	@Produces({ APPLICATION_JSON })
	public List<FasDetalleUsuarioDTO> consultarHistorialSolicitudesCredito(@PathParam("correo") String correo)
			throws InvalidParameterException {
		// protected region Use esta region para su implementacion on begin
		return negocioFasAfiliados.consultarDetalleUsuario(correo);
		// protected region Use esta region para su implementacion end
	}

	@GET
	@Path("permanente/{year}/{month}")
	@Produces({ APPLICATION_JSON })
	public List<FasBeneficioIdentificacionDTO> consultarBeneficiosAportes(@PathParam("year") int year,
			@PathParam("month") int month) {
		return negocioFasAfiliados.calcularBeneficioyAportes(year, month);
	}

	// con PathParm se usa /{variable}
	// con QueryParm no se usa /{variable} en el path
	// la fecha llega con formato año-mes-dia
	@GET
	@Path("retiro/{inicial}/{final}")
	@Produces({ APPLICATION_JSON })
	public List<FasAfiliadosDTO> consultarFechasRetiroAfiliados(@PathParam("inicial") String fechaIni,
			@PathParam("final") String fechaFin) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = sdf.parse(fechaIni);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println(cal.getTime());
		System.out.println(fechaIni);

		Date datefin = sdf.parse(fechaFin);
		Calendar calFin = Calendar.getInstance();
		calFin.setTime(datefin);
		calFin.set(Calendar.HOUR_OF_DAY,23);
		
    	System.out.println(calFin.getTime());
    	
    	Object inicial = cal.getTime();
    	Object finalDate = calFin.getTime();

    	return negocioFasAfiliados.consultarFechaRetiroFondo(inicial, finalDate);
    }
    
	@GET
	@Path("solicitudAfiliacion")
	@Produces({ APPLICATION_JSON })
	public List<FasSolicitudesAfiliacionDTO> consultarUsuarioAres()
			throws InvalidParameterException {
		// protected region Use esta region para su implementacion on begin
		return negocioFasAfiliados.consultarSolicitudesAfiliacion();
		// protected region Use esta region para su implementacion end
	}
    // protected region Use esta region para su implementacion de otros servicios on begin
    
    // protected region Use esta region para su implementacion de otros servicios end
    
    @GET
    @Path("datosDeudas")
    @Produces({APPLICATION_JSON})
    public List<FasDesafilacionCreditosDTO> consultarDeudasAfiliado(@QueryParam("correo") String correo) {
    	return negocioFasAfiliados.consultarDeudasAfiliado(correo);
    }
    
    @PUT
    @Path("actualizarAfiliado")
    public int actualizarAfiliado(@QueryParam("fechaRetiro") String fechaRetiro, @QueryParam("correo") String correo) throws ParseException {
    	System.out.println("servicio actualizar");
    	return negocioFasAfiliados.actualizarAfiliados(fechaRetiro, correo);
    }
    
    @PUT
    @Path("actualizarDesfiliaciones")
    public int actualizarDesafiliaciones(@QueryParam("correo") String correo) throws ParseException {
    	return negocioFasAfiliados.actualizarDesafiliacion(correo);
    }
    
    @GET
    @Path("datosAhroros")
    @Produces({APPLICATION_JSON})
    public List<FasDesafilacionAhorrosDTO> consultarAhorrosAfiliado(@QueryParam("correo") String correo) {
    	return negocioFasAfiliados.consultarAhorroAfiliado(correo);
    }

}
