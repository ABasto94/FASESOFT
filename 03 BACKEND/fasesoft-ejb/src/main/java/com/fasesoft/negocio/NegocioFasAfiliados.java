package com.fasesoft.negocio;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.fasesoft.modelo.dtos.FasAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasAportesBeneficiosDTO;
import com.fasesoft.modelo.dtos.FasBeneficioIdentificacionDTO;
import com.fasesoft.modelo.dtos.FasDesafilacionAhorrosDTO;
import com.fasesoft.modelo.dtos.FasDesafilacionCreditosDTO;
import com.fasesoft.modelo.dtos.FasDetalleUsuarioDTO;
import com.fasesoft.modelo.dtos.FasSolicitudesAfiliacionDTO;
import com.fasesoft.modelo.entidades.FasAfiliados;
import com.fasesoft.modelo.entidades.FasAhorros;
import com.fasesoft.modelo.entidades.FasUsuarios;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.modelo.manejadores.ManejadorFasAfiliados;
import com.fasesoft.modelo.manejadores.ManejadorFasAhorros;
import com.fasesoft.modelo.manejadores.ManejadorFasUsuarios;
import com.fasesoft.modelo.manejadores.utils.InformacionAgrupamiento;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.InformacionOrdenamiento;
import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.utils.UtilOperaciones;

// protected region Incluya importaciones adicionales en esta seccion on begin

// protected region Incluya importaciones adicionales en esta seccion end

/**
 * Servicios para operaciones CRUD y de negocio sobre la entidad FasAfiliados
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class NegocioFasAfiliados extends NegocioAbstracto<FasAfiliados, FasAfiliadosDTO> {

	@EJB
	private ManejadorFasUsuarios manejadorFasUsuarios;
	@EJB
	private ManejadorFasAfiliados manejadorFasAfiliados;
	@EJB
	private ManejadorFasAhorros manejadorFasAhorros;

	/**
	 * Variable estatica para imprimir logs...
	 */
	private static final Logger logger = Logger.getLogger(NegocioFasAfiliados.class.getName());

	// protected region Declare atributos adicionales en esta seccion on begin

	// protected region Declare atributos adicionales en esta seccion end

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
	public List<FasDetalleUsuarioDTO> consultarDetalleUsuario(String atributo) {

		List<FasUsuarios> usuarios = manejadorFasUsuarios.consultar(null, null, null);
		List<FasAfiliados> afiliados = manejadorFasAfiliados.consultarDatosAfiliadoPorCorreo(atributo);
		List<FasAhorros> ahorros = manejadorFasAhorros.consultarAhorrosPorCorreoAfiliado(atributo);

		List<FasDetalleUsuarioDTO> detalleUsuario = new ArrayList<>();

		for (FasUsuarios usuario : usuarios) {
			for (FasAfiliados afiliado : afiliados) {
				if (afiliado.getCorreo().equals(usuario.getFasAfiliadosCorreo())) {
					for (FasAhorros ahorro : ahorros) {
						if (ahorro.getFasAfiliadosCorreo().equals(afiliado.getCorreo())
								&& usuario.getEstado().contentEquals("REGISTRADO")) {
							FasDetalleUsuarioDTO detalleUsuarios = new FasDetalleUsuarioDTO();
							detalleUsuarios.setApellido(afiliado.getApellido());
							detalleUsuarios.setBanco(afiliado.getBanco());
							detalleUsuarios.setCiudad(afiliado.getCiudad());
							detalleUsuarios.setCorreo(afiliado.getCorreo());
							detalleUsuarios.setCuentaBancaria(afiliado.getCuentaBancaria());
							detalleUsuarios.setDependencia(afiliado.getDependencia());
							detalleUsuarios.setDireccion(afiliado.getDireccion());
							detalleUsuarios.setEstadoCivil(afiliado.getEstadoCivil());
							detalleUsuarios.setExpedicion(afiliado.getExpedicion());
							detalleUsuarios.setIdentificacion(afiliado.getIdentificacion());
							detalleUsuarios.setNombre(afiliado.getNombre());
							detalleUsuarios.setTelefono(afiliado.getTelefono());
							detalleUsuarios.setTipoId(afiliado.getTipoId());
							detalleUsuarios.setFechaCracion(usuario.getFechaCracion());
							detalleUsuarios.setEstado(usuario.getEstado());
							detalleUsuarios.setAporte(ahorro.getAporte());
							detalleUsuario.add(detalleUsuarios);
						}
					}
				}
			}
		}

		return detalleUsuario;

		// protected region Use esta region para su implementacion de otros metodos on
		// begin

		// protected region Use esta region para su implementacion de otros metodos end

	}

	public List<FasAfiliadosDTO> consultarDetalleUsuarioAres(String correo) {
		return manejadorFasAfiliados.consultarDatosAfiliadoPorCorreoAres(correo);
	}

	public List<FasAfiliadosDTO> consultarAfiliadosUsuarios() {
		return convertirListaEntidadesADao(manejadorFasAfiliados.consultarAfiliadosUsuarios());
	}

	
	
	public List<FasSolicitudesAfiliacionDTO> consultarSolicitudesAfiliacion() {
		return manejadorFasAfiliados.consultarSolicitudesAfiliacion();
	}
	
	public List<FasAfiliadosDTO> consultar(String filterBy, String orderBy, Integer from, Integer to)
			throws InvalidParameterException {
		// protected region Modifique el metodo consultar on begin
		logService(this.getClass().getName(), "consultar", filterBy, orderBy, from, to);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);
		RangoConsulta rango = validarParametrosBloque(from, to);

		return convertirListaEntidadesADao(manejadorFasAfiliados.consultar(filtros, ordenamiento, rango));
		// protected region Modifique el metodo consultar end
	}

	/**
	 * Crea el fasAfiliados que se pasa como parámetro en la base de datos.
	 * 
	 * @param fasAfiliadosDTO El DAO de la entidad FasAfiliados a crear. Este se
	 *                        envía en el cuerpo de la solicitud POST como un objeto
	 *                        JSON.
	 * @return La insntancia de FasAfiliados recién creado
	 */
	public FasAfiliadosDTO crear(FasAfiliadosDTO fasAfiliadosDTO) {
		// protected region Modifique el metodo crear on begin

		logService(this.getClass().getName(), "crear", fasAfiliadosDTO);

		FasAfiliados fasAfiliados = new FasAfiliados();
		copiarPropiedades(fasAfiliados, fasAfiliadosDTO);

		manejadorFasAfiliados.crear(fasAfiliados);

		return fasAfiliadosDTO;
		// protected region Modifique el metodo crear end
	}

	/**
	 * Actualiza en la base de datos el fasAfiliados que se pasa como parámetro.
	 * 
	 * @param fasAfiliadosDTO El DAO de la entidad FasAfiliados a actualizar. Este
	 *                        se envía en el cuerpo de la solicitud PUT como un
	 *                        objeto JSON.
	 * @return La instancia de la entidad FasAfiliados que ha sido actualizado
	 */
	public FasAfiliadosDTO actualizar(FasAfiliadosDTO fasAfiliadosDTO) {
		// protected region Modifique el metodo actualizar on begin

		logService(this.getClass().getName(), "actualizar", fasAfiliadosDTO);

		FasAfiliados fasAfiliados = manejadorFasAfiliados.buscar(fasAfiliadosDTO.getCorreo());
		copiarPropiedades(fasAfiliados, fasAfiliadosDTO);

		manejadorFasAfiliados.actualizar(fasAfiliados);

		return fasAfiliadosDTO;
		// protected region Modifique el metodo actualizar end
	}

	/**
	 * Elimina el fasAfiliados con el identificador que se pasa como parámetro.
	 * 
	 * @param correo Valor del atributo del identificador de la instancia de la
	 *               entidad fasAfiliados a eliminar
	 * @return El identificador del fasAfiliados que ha sido eliminado
	 */
	public String eliminar(String correo) {
		// protected region Modifique el metodo eliminar on begin

		logService(this.getClass().getName(), "eliminar", correo);
		manejadorFasAfiliados.eliminarPorId(correo);

		StringBuilder valores = new StringBuilder();
		valores.append(String.valueOf(correo));
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
	public String contar(String filterBy, Integer from, Integer to) throws InvalidParameterException {
		// protected region Modifique el metodo contar on begin

		logService(this.getClass().getName(), "contar", filterBy);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		RangoConsulta rango = validarParametrosBloque(from, to);

		return String.valueOf(manejadorFasAfiliados.consultarTotalRegistros(filtros, rango));
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
	public List<String> consultarLista(String filterBy, String orderBy, String atributo)
			throws InvalidParameterException {
		// protected region Modifique el metodo consultarLista on begin

		logService(this.getClass().getName(), "contar", filterBy, orderBy, atributo);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);
		InformacionAgrupamiento infoAgrupamiento = decodificarInformacionAgrupamiento(atributo);

		return UtilOperaciones.convertirListaObjetosAString(
				manejadorFasAfiliados.consultarLista(filtros, ordenamiento, infoAgrupamiento));
		// protected region Modifique el metodo consultarLista end
	}

	public List<FasAfiliadosDTO> consultarFechaRetiroFondo(Object fechaIni, Object fechaFin) {
		List<Object> fechas = new ArrayList<>();
		// Object fechaInicio= fechaIni;
		// Object fechaFinal= fechaFin;
		fechas.add(fechaIni);
		fechas.add(fechaFin);
		return manejadorFasAfiliados.consultarFechaRetiroFondo(fechas);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param nombreAtributo {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	protected boolean entidadContieneAtributo(String nombreAtributo) {
		return FasAfiliados.contieneAtributo(nombreAtributo);
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
	protected FasAfiliadosDTO instanciarDAO() {
		return new FasAfiliadosDTO();
	}

	public List<FasAfiliadosDTO> consultarPorCorreo(String correo) {

		return convertirListaEntidadesADao(manejadorFasAfiliados.consultarDatosAfiliadoPorCorreo(correo));
	}

	public List<FasBeneficioIdentificacionDTO> calcularBeneficioyAportes(int year, int month) {

		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		System.out.println(daysInMonth + " dias del mes: " + month + " del año " + year);

		Calendar calIni = Calendar.getInstance();
		calIni.set(Calendar.YEAR, year);
		calIni.set(Calendar.MONTH, month - 1);
		calIni.set(Calendar.DAY_OF_MONTH, 1);
		calIni.set(Calendar.HOUR_OF_DAY, 0);
		calIni.set(Calendar.MINUTE, 0);
		calIni.set(Calendar.SECOND, 0);
		calIni.set(Calendar.MILLISECOND, 0);

		System.out.println(calIni.getTime());
		Object fechaIni = calIni.getTime();

		System.out.println("OBJETO FECHA FINAL " + fechaIni);

		Calendar calFin = Calendar.getInstance();
		calFin.set(Calendar.YEAR, year);
		calFin.set(Calendar.MONTH, month - 1);
		calFin.set(Calendar.DAY_OF_MONTH, daysInMonth);
		calFin.set(Calendar.HOUR_OF_DAY, 23);
		calFin.set(Calendar.MINUTE, 58);
		calFin.set(Calendar.SECOND, 58);
		calFin.set(Calendar.MILLISECOND, 0);

		System.out.println(calFin.getTime());
		Object fechaFin = calFin.getTime();

		System.out.println("OBJETO FECHA FINAL " + fechaFin);

		List<Object> params = new ArrayList<>();
		params.add(fechaIni);
		params.add(fechaFin);

		List<FasAportesBeneficiosDTO> aportesBeneficios = manejadorFasAfiliados
				.consultarAporteBeneficioAfiliado(params);

		List<FasBeneficioIdentificacionDTO> listabeneficioIdentificacion = new ArrayList<FasBeneficioIdentificacionDTO>();
		for (FasAportesBeneficiosDTO aporteBeneficio : aportesBeneficios) {
			FasBeneficioIdentificacionDTO beneficioIdentificacion = new FasBeneficioIdentificacionDTO();
			beneficioIdentificacion.setIdentificacion(aporteBeneficio.getIdentificacion());
			// beneficioIdentificacion.setFechaAporte(aporteBeneficio.getFechaAporte());
			BigDecimal aporte = aporteBeneficio.getAporte();
			BigDecimal beneficioPorcentaje = aporteBeneficio.getBeneficio();
			BigDecimal beneficio = new BigDecimal(beneficioPorcentaje.doubleValue() / 100);
			System.out.println("beneficio" + beneficio);
			BigDecimal aportePorBeneficio = new BigDecimal(aporte.doubleValue() * beneficio.doubleValue());
			System.out.println("aporte X beneficio" + aportePorBeneficio);
			beneficioIdentificacion.setCalculoBeneficio(aportePorBeneficio);
			listabeneficioIdentificacion.add(beneficioIdentificacion);
		}
		return listabeneficioIdentificacion;
	}

	public List<FasDesafilacionCreditosDTO> consultarDeudasAfiliado(String correo) {
		List<Object> objetosParam = new ArrayList<Object>();
		objetosParam.add(correo);
		List<FasDesafilacionCreditosDTO> deudas = manejadorFasAfiliados.consultarDeudaCreditosAfiliados(objetosParam);
		return deudas;
	}

	public List<FasDesafilacionAhorrosDTO> consultarAhorroAfiliado(String correo) {
		List<Object> objetosParam = new ArrayList<Object>();
		objetosParam.add(correo);
		List<FasDesafilacionAhorrosDTO> ahorros = manejadorFasAfiliados.consultarDeudaAhorrosAfiliado(objetosParam);
		return ahorros;
	}

	public int actualizarAfiliados(String fechaRetiro, String correo) throws ParseException {
		System.out.println("negocio actualizar ");
		List<Object> objetosParam = new ArrayList<Object>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(df.parse(fechaRetiro));
		System.out.println("Fecha" + cal.getTime());
		objetosParam.add(cal.getTime());
		objetosParam.add(correo);
		return manejadorFasAfiliados.actualizarAfiliado(objetosParam);

	}

	public int actualizarDesafiliacion(String correo) {
		List<Object> objetosParam = new ArrayList<Object>();
		objetosParam.add(correo);
		int actualizarUsuario = manejadorFasAfiliados.actualizarUsuario(objetosParam);
		int variableVerificacion = actualizarUsuario;
		return variableVerificacion;
	}

	// protected region Use esta region para su implementacion de otros metodos on
	// begin

	// protected region Use esta region para su implementacion de otros metodos end

}
