package com.fasesoft.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.fasesoft.modelo.dtos.FasPerfilesDTO;
import com.fasesoft.modelo.entidades.FasPerfiles;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.modelo.manejadores.ManejadorFasPerfiles;
import com.fasesoft.modelo.manejadores.utils.InformacionAgrupamiento;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.InformacionOrdenamiento;
import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.utils.UtilOperaciones;

// protected region Incluya importaciones adicionales en esta seccion on begin

// protected region Incluya importaciones adicionales en esta seccion end

/**
 * Servicios para operaciones CRUD y de negocio sobre la entidad FasPerfiles
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class NegocioFasPerfiles extends NegocioAbstracto<FasPerfiles, FasPerfilesDTO> {

	@EJB
	private ManejadorFasPerfiles manejadorFasPerfiles;

	/**
	 * Variable estatica para imprimir logs...
	 */
	private static final Logger logger = Logger.getLogger(NegocioFasPerfiles.class.getName());

	// protected region Declare atributos adicionales en esta seccion on begin

	// protected region Declare atributos adicionales en esta seccion end

	/**
	 * Realiza un consulta en la entidad FasPerfiles aplicando los filtros, el
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
	 *                 {@literal fasPerfilesId>1&fasPerfilesName:LIKE:juan}
	 * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere ordenar, seguido por el símbolo '$' y
	 *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
	 *                 ultimos valores son opcionales ya que si no se especifica por
	 *                 defecto se asume que el ordenamiento es de forma Ascendente.
	 *                 Si se coloca más de un parámetro debe ir separado por coma :
	 *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
	 *                 ser: fasPerfilesId$ASC, fasPerfilesName$DESC
	 * @param from     Número de registro inicial que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual a 0
	 * @param to       Número de registro final que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual al parámetro from
	 * @return Una lista de DAOs de los FasPerfiles que se consultaron con los
	 *         parámetros enviados por el cliente
	 * @throws InvalidParameterException Excepción lanzada cuando algunos de los
	 *                                   parámetros de la url tenía un error de
	 *                                   sintáxis por lo que no pudo ser procesado
	 *                                   correctamente
	 */
	public List<FasPerfilesDTO> consultar(String filterBy, String orderBy, Integer from, Integer to)
			throws InvalidParameterException {
		// protected region Modifique el metodo consultar on begin
		logService(this.getClass().getName(), "consultar", filterBy, orderBy, from, to);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);
		RangoConsulta rango = validarParametrosBloque(from, to);

		return convertirListaEntidadesADao(manejadorFasPerfiles.consultar(filtros, ordenamiento, rango));
		// protected region Modifique el metodo consultar end
	}

	public List<FasPerfilesDTO> consultarPerfilesUsuario(String correo) {
		return convertirListaEntidadesADao(manejadorFasPerfiles.consultarPerfilesUsuario(correo));
	}

	/**
	 * Crea el fasPerfiles que se pasa como parámetro en la base de datos.
	 * 
	 * @param fasPerfilesDTO El DAO de la entidad FasPerfiles a crear. Este se envía
	 *                       en el cuerpo de la solicitud POST como un objeto JSON.
	 * @return La insntancia de FasPerfiles recién creado
	 */
	public FasPerfilesDTO crear(FasPerfilesDTO fasPerfilesDTO) {
		// protected region Modifique el metodo crear on begin

		logService(this.getClass().getName(), "crear", fasPerfilesDTO);

		FasPerfiles fasPerfiles = new FasPerfiles();
		copiarPropiedades(fasPerfiles, fasPerfilesDTO);

		manejadorFasPerfiles.crear(fasPerfiles);

		return convertirEntidadADao(fasPerfiles);
		// protected region Modifique el metodo crear end
	}

	/**
	 * Actualiza en la base de datos el fasPerfiles que se pasa como parámetro.
	 * 
	 * @param fasPerfilesDTO El DAO de la entidad FasPerfiles a actualizar. Este se
	 *                       envía en el cuerpo de la solicitud PUT como un objeto
	 *                       JSON.
	 * @return La instancia de la entidad FasPerfiles que ha sido actualizado
	 */
	public FasPerfilesDTO actualizar(FasPerfilesDTO fasPerfilesDTO) {
		// protected region Modifique el metodo actualizar on begin

		logService(this.getClass().getName(), "actualizar", fasPerfilesDTO);

		FasPerfiles fasPerfiles = manejadorFasPerfiles.buscar(fasPerfilesDTO.getIdPerfil());
		copiarPropiedades(fasPerfiles, fasPerfilesDTO);

		manejadorFasPerfiles.actualizar(fasPerfiles);

		return fasPerfilesDTO;
		// protected region Modifique el metodo actualizar end
	}

	/**
	 * Elimina el fasPerfiles con el identificador que se pasa como parámetro.
	 * 
	 * @param idPerfil Valor del atributo del identificador de la instancia de la
	 *                 entidad fasPerfiles a eliminar
	 * @return El identificador del fasPerfiles que ha sido eliminado
	 */
	public String eliminar(Integer idPerfil) {
		// protected region Modifique el metodo eliminar on begin

		logService(this.getClass().getName(), "eliminar", idPerfil);
		manejadorFasPerfiles.eliminarPorId(idPerfil);

		StringBuilder valores = new StringBuilder();
		valores.append(String.valueOf(idPerfil));
		return valores.toString();
		// protected region Modifique el metodo eliminar end
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
	 *                 {@literal fasPerfilesId>1&fasPerfilesName:LIKE:juan}
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
	public String contar(String filterBy, Integer from, Integer to) throws InvalidParameterException {
		// protected region Modifique el metodo contar on begin

		logService(this.getClass().getName(), "contar", filterBy);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		RangoConsulta rango = validarParametrosBloque(from, to);

		return String.valueOf(manejadorFasPerfiles.consultarTotalRegistros(filtros, rango));
		// protected region Modifique el metodo contar end
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
	 *                 {@literal fasPerfilesId>1&fasPerfilesName:LIKE:juan}
	 * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere ordenar, seguido por el símbolo '$' y
	 *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
	 *                 ultimos valores son opcionales ya que si no se especifica por
	 *                 defecto se asume que el ordenamiento es de forma Ascendente.
	 *                 Si se coloca más de un parámetro debe ir separado por coma :
	 *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
	 *                 ser: fasPerfilesId$ASC, fasPerfilesName$DESC
	 * @param atributo Nombre del atributo de la entidad FasPerfiles del cual se
	 *                 quieren obtener los diferentes valores.
	 * @return Una lista con los diferentes valores que se encuentran en la columna
	 *         de la tabla asociada al atributo.
	 * @throws InvalidParameterException Si el atributo no existe en la entidad o si
	 *                                   los filtros y el ordenamiento contienen
	 *                                   atributos de la entidad que no existen.
	 */
	public List<String> consultarLista(String filterBy, String orderBy, String atributo)
			throws InvalidParameterException {
		// protected region Modifique el metodo consultarLista on begin

		logService(this.getClass().getName(), "contar", filterBy, orderBy, atributo);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);
		InformacionAgrupamiento infoAgrupamiento = decodificarInformacionAgrupamiento(atributo);

		return UtilOperaciones.convertirListaObjetosAString(
				manejadorFasPerfiles.consultarLista(filtros, ordenamiento, infoAgrupamiento));
		// protected region Modifique el metodo consultarLista end
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param nombreAtributo {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	protected boolean entidadContieneAtributo(String nombreAtributo) {
		return FasPerfiles.contieneAtributo(nombreAtributo);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return {@inheritDoc}
	 */
	@Override
	protected Logger getLogger() {
		return logger;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return {@inheritDoc}
	 */
	@Override
	protected FasPerfilesDTO instanciarDAO() {
		return new FasPerfilesDTO();
	}

	// protected region Use esta region para su implementacion de otros metodos on
	// begin

	// protected region Use esta region para su implementacion de otros metodos end

}
