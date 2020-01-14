package com.fasesoft.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.fasesoft.modelo.dtos.FasCreditosAfiliadoDTO;
import com.fasesoft.modelo.dtos.FasCreditosDTO;
import com.fasesoft.modelo.dtos.FasHistorialCreditosDTO;
import com.fasesoft.modelo.entidades.FasAfiliados;
import com.fasesoft.modelo.entidades.FasCreditos;
import com.fasesoft.modelo.entidades.FasTiposDeCredito;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.modelo.manejadores.ManejadorFasAfiliados;
import com.fasesoft.modelo.manejadores.ManejadorFasCreditos;
import com.fasesoft.modelo.manejadores.ManejadorFasTiposDeCredito;
import com.fasesoft.modelo.manejadores.utils.InformacionAgrupamiento;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.InformacionOrdenamiento;
import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.utils.UtilOperaciones;

// protected region Incluya importaciones adicionales en esta seccion on begin

// protected region Incluya importaciones adicionales en esta seccion end

/**
 * Servicios para operaciones CRUD y de negocio sobre la entidad FasCreditos
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class NegocioFasCreditos extends NegocioAbstracto<FasCreditos, FasCreditosDTO> {

	@EJB
	private ManejadorFasAfiliados manejadorFasAfiliados;
	@EJB
	private ManejadorFasCreditos manejadorFasCreditos;
	@EJB
	private ManejadorFasTiposDeCredito manejadorFasTiposDeCreditos;

	/**
	 * Variable estatica para imprimir logs...
	 */
	private static final Logger logger = Logger.getLogger(NegocioFasCreditos.class.getName());

	// protected region Declare atributos adicionales en esta seccion on begin

	// protected region Declare atributos adicionales en esta seccion end

	/**
	 * Realiza un consulta en la entidad FasCreditos aplicando los filtros, el
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
	 *                 {@literal fasCreditosId>1&fasCreditosName:LIKE:juan}
	 * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere ordenar, seguido por el símbolo '$' y
	 *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
	 *                 ultimos valores son opcionales ya que si no se especifica por
	 *                 defecto se asume que el ordenamiento es de forma Ascendente.
	 *                 Si se coloca más de un parámetro debe ir separado por coma :
	 *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
	 *                 ser: fasCreditosId$ASC, fasCreditosName$DESC
	 * @param from     Número de registro inicial que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual a 0
	 * @param to       Número de registro final que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual al parámetro from
	 * @return Una lista de DAOs de los FasCreditos que se consultaron con los
	 *         parámetros enviados por el cliente
	 * @throws InvalidParameterException Excepción lanzada cuando algunos de los
	 *                                   parámetros de la url tenía un error de
	 *                                   sintáxis por lo que no pudo ser procesado
	 *                                   correctamente
	 */
	public List<FasCreditosDTO> consultar(String filterBy, String orderBy, Integer from, Integer to)
			throws InvalidParameterException {
		// protected region Modifique el metodo consultar on begin
		logService(this.getClass().getName(), "consultar", filterBy, orderBy, from, to);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);
		RangoConsulta rango = validarParametrosBloque(from, to);

		return convertirListaEntidadesADao(manejadorFasCreditos.consultar(filtros, ordenamiento, rango));
		// protected region Modifique el metodo consultar end
	}

	/**
	 * Crea el fasCreditos que se pasa como parámetro en la base de datos.
	 * 
	 * @param fasCreditosDTO El DAO de la entidad FasCreditos a crear. Este se envía
	 *                       en el cuerpo de la solicitud POST como un objeto JSON.
	 * @return La insntancia de FasCreditos recién creado
	 */
	public FasCreditosDTO crear(FasCreditosDTO fasCreditosDTO) {
		// protected region Modifique el metodo crear on begin

		// protected region Modifique el metodo crear on begin
		logService(this.getClass().getName(), "crear", fasCreditosDTO);
		fasCreditosDTO.setEstado("REGISTRADO");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		fasCreditosDTO.setFechaSolicitud(timestamp);
		double monto = fasCreditosDTO.getMonto().doubleValue();
		double tasa = fasCreditosDTO.getTasaReal().doubleValue();
		double montoTasa = monto * tasa;
		double saldoTotaldoble = montoTasa + monto;
		System.out.println("ESTE ES MONTO TASA:::::" + montoTasa);
		BigDecimal saldoTotal = new BigDecimal(saldoTotaldoble);
		fasCreditosDTO.setSaldo(saldoTotal);
		fasCreditosDTO.setCuotasPendientes(fasCreditosDTO.getNumeroCuotas());
		BigDecimal mora = new BigDecimal(0);
		fasCreditosDTO.setMora(mora);

		FasCreditos fasCreditos = new FasCreditos();
		copiarPropiedades(fasCreditos, fasCreditosDTO);

		manejadorFasCreditos.crear(fasCreditos);

		return fasCreditosDTO;

		// protected region Modifique el metodo crear end
	}

	public List<FasHistorialCreditosDTO> consultarHistorial(String atributo) {

		List<FasCreditos> creditos = manejadorFasCreditos.consultarHistorialSolicitudes(atributo);
		List<FasAfiliados> afiliados = manejadorFasAfiliados.consultarDatosAfiliadoPorCorreo(atributo);

		List<FasTiposDeCredito> tiposDeCreditos = manejadorFasTiposDeCreditos.consultar(null, null, null);

		List<FasHistorialCreditosDTO> historial = new ArrayList<>();

		for (FasAfiliados afiliado : afiliados) {
			for (FasCreditos credito : creditos) {
				if (afiliado.getCorreo().equals(credito.getFasAfiliadosCorreo())) {
					for (FasTiposDeCredito tipoCredito : tiposDeCreditos) {
						if (credito.getFasTiposDeCreditoIdTipo().equals(tipoCredito.getIdTipo())) {
							FasHistorialCreditosDTO historialCreditos = new FasHistorialCreditosDTO();
							historialCreditos.setDescripcion(tipoCredito.getDescripcion());
							historialCreditos.setTipo(tipoCredito.getTipo());
							historialCreditos.setIdCredito(credito.getIdCredito());
							historialCreditos.setTasaReal(credito.getTasaReal().floatValue());
							historialCreditos.setMonto(credito.getMonto().intValue());
							historialCreditos.setSaldo(credito.getSaldo().intValue());
							historialCreditos.setCuotas(credito.getCuotasPendientes().intValue());
							historialCreditos.setMora(credito.getMora().intValue());
							historialCreditos.setEstadoCredito(credito.getEstado());
							historialCreditos.setFechaSolicitud(credito.getFechaSolicitud());
							historialCreditos.setCorreo(afiliado.getCorreo());
							historialCreditos.setNombre(afiliado.getNombre());
							historialCreditos.setApellido(afiliado.getApellido());
							historialCreditos.setTelefono(afiliado.getTelefono().intValue());
							historialCreditos.setDireccion(afiliado.getDireccion());
							historialCreditos.setTipoId(afiliado.getTipoId());
							historialCreditos.setIdentificacion(afiliado.getIdentificacion().intValue());
							historial.add(historialCreditos);
						}
					}
				}
			}
		}

		return historial;

		// protected region Use esta region para su implementacion de otros metodos on
		// begin

		// protected region Use esta region para su implementacion de otros metodos end

	}

	/**
	 * Actualiza en la base de datos el fasCreditos que se pasa como parámetro.
	 * 
	 * @param fasCreditosDTO El DAO de la entidad FasCreditos a actualizar. Este se
	 *                       envía en el cuerpo de la solicitud PUT como un objeto
	 *                       JSON.
	 * @return La instancia de la entidad FasCreditos que ha sido actualizado
	 */
	public FasCreditosDTO actualizar(FasCreditosDTO fasCreditosDTO) {
		// protected region Modifique el metodo actualizar on begin

		logService(this.getClass().getName(), "actualizar", fasCreditosDTO);

		FasCreditos fasCreditos = manejadorFasCreditos.buscar(fasCreditosDTO.getIdCredito());
		
		fasCreditosDTO.setFasAfiliadosCorreo(fasCreditos.getFasAfiliadosCorreo());
		fasCreditosDTO.setFasTiposDeCreditoIdTipo(fasCreditos.getFasTiposDeCreditoIdTipo());
		fasCreditosDTO.setMora(fasCreditos.getMora());
		fasCreditosDTO.setSaldo(fasCreditos.getSaldo());
		fasCreditosDTO.setCuotasPendientes(fasCreditos.getCuotasPendientes());
		copiarPropiedades(fasCreditos, fasCreditosDTO);
		
		manejadorFasCreditos.actualizar(fasCreditos);

		return fasCreditosDTO;
		// protected region Modifique el metodo actualizar end
	}

	/**
	 * Elimina el fasCreditos con el identificador que se pasa como parámetro.
	 * 
	 * @param idCredito Valor del atributo del identificador de la instancia de la
	 *                  entidad fasCreditos a eliminar
	 * @return El identificador del fasCreditos que ha sido eliminado
	 */
	public String eliminar(Integer idCredito) {
		// protected region Modifique el metodo eliminar on begin

		logService(this.getClass().getName(), "eliminar", idCredito);
		manejadorFasCreditos.eliminarPorId(idCredito);

		StringBuilder valores = new StringBuilder();
		valores.append(String.valueOf(idCredito));
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
	 *                 {@literal fasCreditosId>1&fasCreditosName:LIKE:juan}
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

		return String.valueOf(manejadorFasCreditos.consultarTotalRegistros(filtros, rango));
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
	 *                 {@literal fasCreditosId>1&fasCreditosName:LIKE:juan}
	 * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere ordenar, seguido por el símbolo '$' y
	 *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
	 *                 ultimos valores son opcionales ya que si no se especifica por
	 *                 defecto se asume que el ordenamiento es de forma Ascendente.
	 *                 Si se coloca más de un parámetro debe ir separado por coma :
	 *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
	 *                 ser: fasCreditosId$ASC, fasCreditosName$DESC
	 * @param atributo Nombre del atributo de la entidad FasCreditos del cual se
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
				manejadorFasCreditos.consultarLista(filtros, ordenamiento, infoAgrupamiento));
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
		return FasCreditos.contieneAtributo(nombreAtributo);
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
	protected FasCreditosDTO instanciarDAO() {
		return new FasCreditosDTO();
	}

	// protected region Use esta region para su implementacion de otros metodos on
	// begin
	

	public List<FasCreditosAfiliadoDTO> consultarCreditosPorAprobar() throws InvalidParameterException {
		// TODO Auto-generated method stub
				
		List<FasCreditosAfiliadoDTO> afiliados = manejadorFasCreditos.consultarCreditosPorAprobar();
        for (FasCreditosAfiliadoDTO fasCreditosAfiliadoDTO : afiliados) {
            if (fasCreditosAfiliadoDTO.getDeuda() == null) {
                fasCreditosAfiliadoDTO.setDeuda(new BigDecimal(0));
            }
        }
        return afiliados;
	}  


	// protected region Use esta region para su implementacion de otros metodos end

}
