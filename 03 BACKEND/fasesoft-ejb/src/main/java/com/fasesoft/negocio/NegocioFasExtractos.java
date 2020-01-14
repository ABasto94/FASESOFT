package com.fasesoft.negocio;

import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.dtos.FasAhorrosDTO;
import com.fasesoft.modelo.dtos.FasConveniosTiposPagosDTO;
import com.fasesoft.modelo.dtos.FasCreditosPagosTipoDTO;
import com.fasesoft.modelo.dtos.FasExtAhorrosAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasExtAhorrosVoluntariosDTO;
import com.fasesoft.modelo.dtos.FasExtractosDTO;
import com.fasesoft.modelo.dtos.FasGeneracionExtractoDTO;
import com.fasesoft.modelo.entidades.FasExtractos;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.fasesoft.modelo.dtos.FasExtractosDTO;
import com.fasesoft.modelo.entidades.FasExtractos;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.modelo.manejadores.ManejadorFasExtractos;
import com.fasesoft.modelo.manejadores.utils.InformacionAgrupamiento;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.InformacionOrdenamiento;
import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.YearMonth;

// protected region Incluya importaciones adicionales en esta seccion on begin

// protected region Incluya importaciones adicionales en esta seccion end

/**
 * Servicios para operaciones CRUD y de negocio sobre la entidad FasExtractos
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class NegocioFasExtractos extends NegocioAbstracto<FasExtractos, FasExtractosDTO> {

	@EJB
	private ManejadorFasExtractos manejadorFasExtractos;

	/**
	 * Variable estatica para imprimir logs...
	 */
	private static final Logger logger = Logger.getLogger(NegocioFasExtractos.class.getName());

	// protected region Declare atributos adicionales en esta seccion on begin

	// protected region Declare atributos adicionales en esta seccion end

	/**
	 * Realiza un consulta en la entidad FasExtractos aplicando los filtros, el
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
	 *                 {@literal fasExtractosId>1&fasExtractosName:LIKE:juan}
	 * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
	 *                 parámetro está compuesto por el nombre del campo por el que
	 *                 se quiere ordenar, seguido por el símbolo '$' y
	 *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
	 *                 ultimos valores son opcionales ya que si no se especifica por
	 *                 defecto se asume que el ordenamiento es de forma Ascendente.
	 *                 Si se coloca más de un parámetro debe ir separado por coma :
	 *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
	 *                 ser: fasExtractosId$ASC, fasExtractosName$DESC
	 * @param from     Número de registro inicial que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual a 0
	 * @param to       Número de registro final que se quiere retornar de la
	 *                 consulta realizada. Entero mayor o igual al parámetro from
	 * @return Una lista de DAOs de los FasExtractos que se consultaron con los
	 *         parámetros enviados por el cliente
	 * @throws InvalidParameterException Excepción lanzada cuando algunos de los
	 *                                   parámetros de la url tenía un error de
	 *                                   sintáxis por lo que no pudo ser procesado
	 *                                   correctamente
	 */
	public List<FasExtractosDTO> consultar(String filterBy, String orderBy, Integer from, Integer to)
			throws InvalidParameterException {
		// protected region Modifique el metodo consultar on begin
		logService(this.getClass().getName(), "consultar", filterBy, orderBy, from, to);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);
		RangoConsulta rango = validarParametrosBloque(from, to);

		return convertirListaEntidadesADao(manejadorFasExtractos.consultar(filtros, ordenamiento, rango));
		// protected region Modifique el metodo consultar end
	}

	/**
	 * Crea el fasExtractos que se pasa como parámetro en la base de datos.
	 * 
	 * @param fasExtractosDTO El DAO de la entidad FasExtractos a crear. Este se
	 *                        envía en el cuerpo de la solicitud POST como un objeto
	 *                        JSON.
	 * @return La insntancia de FasExtractos recién creado
	 */
	public FasExtractosDTO crear(FasExtractosDTO fasExtractosDTO) {
		// protected region Modifique el metodo crear on begin

		logService(this.getClass().getName(), "crear", fasExtractosDTO);

		FasExtractos fasExtractos = new FasExtractos();
		copiarPropiedades(fasExtractos, fasExtractosDTO);

		manejadorFasExtractos.crear(fasExtractos);

		return fasExtractosDTO;
		// protected region Modifique el metodo crear end
	}

	/**
	 * Actualiza en la base de datos el fasExtractos que se pasa como parámetro.
	 * 
	 * @param fasExtractosDTO El DAO de la entidad FasExtractos a actualizar. Este
	 *                        se envía en el cuerpo de la solicitud PUT como un
	 *                        objeto JSON.
	 * @return La instancia de la entidad FasExtractos que ha sido actualizado
	 */
	public FasExtractosDTO actualizar(FasExtractosDTO fasExtractosDTO) {
		// protected region Modifique el metodo actualizar on begin

		logService(this.getClass().getName(), "actualizar", fasExtractosDTO);

		FasExtractos fasExtractos = manejadorFasExtractos.buscar(fasExtractosDTO.getIdExtracto());
		copiarPropiedades(fasExtractos, fasExtractosDTO);

		manejadorFasExtractos.actualizar(fasExtractos);

		return fasExtractosDTO;
		// protected region Modifique el metodo actualizar end
	}

	/**
	 * Elimina el fasExtractos con el identificador que se pasa como parámetro.
	 * 
	 * @param idExtracto Valor del atributo del identificador de la instancia de la
	 *                   entidad fasExtractos a eliminar
	 * @return El identificador del fasExtractos que ha sido eliminado
	 */
	public String eliminar(BigDecimal idExtracto) {
		// protected region Modifique el metodo eliminar on begin

		logService(this.getClass().getName(), "eliminar", idExtracto);
		manejadorFasExtractos.eliminarPorId(idExtracto);

		StringBuilder valores = new StringBuilder();
		valores.append(String.valueOf(idExtracto));
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
	 *                 {@literal fasExtractosId>1&fasExtractosName:LIKE:juan}
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

		return String.valueOf(manejadorFasExtractos.consultarTotalRegistros(filtros, rango));
		// protected region Modifique el metodo contar end
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
    public List<String> consultarLista(String filterBy,
             String orderBy, String atributo) throws InvalidParameterException{
        // protected region Modifique el metodo consultarLista on begin

        logService(this.getClass().getName(), "contar", filterBy, orderBy, atributo);  
        
        List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
        List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);    
        InformacionAgrupamiento infoAgrupamiento = decodificarInformacionAgrupamiento(atributo);
                
        return UtilOperaciones.convertirListaObjetosAString(manejadorFasExtractos.consultarLista(filtros, ordenamiento, infoAgrupamiento));
        // protected region Modifique el metodo consultarLista end
    }
    
      
    
    public List<FasGeneracionExtractoDTO> consultarDatosExtracto(int year, int month, String nombre) {
    	YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        Calendar calIni = Calendar.getInstance();
        calIni.set(Calendar.YEAR, year);
        calIni.set(Calendar.MONTH, month-1);
        calIni.set(Calendar.DAY_OF_MONTH, 1);
        calIni.set(Calendar.HOUR_OF_DAY, 0);
        calIni.set(Calendar.MINUTE, 0);
        calIni.set(Calendar.SECOND, 0);
        calIni.set(Calendar.MILLISECOND, 0);
        
        Calendar calFin = Calendar.getInstance();
        calFin.set(Calendar.YEAR, year);
        calFin.set(Calendar.MONTH, month-1);
        calFin.set(Calendar.DAY_OF_MONTH, daysInMonth);
        calFin.set(Calendar.HOUR_OF_DAY, 23);
        calFin.set(Calendar.MINUTE, 58);
        calFin.set(Calendar.SECOND, 58);
        calFin.set(Calendar.MILLISECOND, 0);
       
        System.out.println(calIni.getTime());
   
        System.out.println(calFin.getTime());

        List<Object> params = new ArrayList<>();
        params.add(calIni.getTime());
        params.add(calFin.getTime());

        
        //no se les ah generado extracto
    	List<FasExtAhorrosAfiliadosDTO> ahorroPermanente = manejadorFasExtractos.consultarAhorroPermanenteAfiliado(params);
    	List<FasExtAhorrosVoluntariosDTO> ahorroVoluntario = manejadorFasExtractos.consultarAhorroVoluntarioAfiliado(params);
    	List<FasCreditosPagosTipoDTO> creditos = manejadorFasExtractos.consultarPagoCreditos(params);
    	List<FasConveniosTiposPagosDTO> convenios = manejadorFasExtractos.consultarPagoConvenios(params);
    	List<FasExtractos> listaExtractosEntidad = manejadorFasExtractos.consultarExtractosPorFecha(nombre);
    	List<FasExtractosDTO> listaExtractosConsultada= convertirListaEntidadesADao(listaExtractosEntidad);//ya se les genero extracto
    	
    	
    	List<FasGeneracionExtractoDTO> listaExtractos = new ArrayList<FasGeneracionExtractoDTO>();
    	
    	List<FasExtAhorrosVoluntariosDTO> ahorroVoluntarioTemporal = new ArrayList<FasExtAhorrosVoluntariosDTO>() ;
    	List<FasCreditosPagosTipoDTO> creditoTemporal = new ArrayList<FasCreditosPagosTipoDTO>() ;
 		List<FasConveniosTiposPagosDTO> convenioTemporal = new ArrayList<FasConveniosTiposPagosDTO>() ;
    	List<FasExtAhorrosAfiliadosDTO> listaDeLosQueSeLePuedeGenerarExtractos= new ArrayList<FasExtAhorrosAfiliadosDTO>();
    	List<String> correos = new ArrayList<String>(); 
    	
    	for(FasExtractosDTO extractosGenerados: listaExtractosConsultada) {
    		if(!(correos.contains(extractosGenerados.getFasAfiliadosCorreo()))) {
    			correos.add(extractosGenerados.getFasAfiliadosCorreo());
    		}
    		
    	}
    	for(FasExtAhorrosAfiliadosDTO extractosQuePuedenGenerar: ahorroPermanente) {
			if(!(correos.contains(extractosQuePuedenGenerar.getCorreo()))){
				listaDeLosQueSeLePuedeGenerarExtractos.add(extractosQuePuedenGenerar);
			}
		}
    	
    		for (FasExtAhorrosAfiliadosDTO listaAhorroPermanente : listaDeLosQueSeLePuedeGenerarExtractos) {
    		
    		FasGeneracionExtractoDTO extracto = new FasGeneracionExtractoDTO();
    		
   
        	double saldoCreditos= 0; 
        	double saldoConvenios=0; 
        	double saldoOtrosAhorros=0;
        		
    		extracto.setAhorroAfiliado(listaAhorroPermanente);
 
    		
			for (FasExtAhorrosVoluntariosDTO listaAhorroVoluntario : ahorroVoluntario) {
				
				if (listaAhorroPermanente.getCorreo().equals(listaAhorroVoluntario.getFasAfiliadosCorreo())) {
					
					ahorroVoluntarioTemporal.add(listaAhorroVoluntario);
					saldoOtrosAhorros+=listaAhorroVoluntario.getMonto().doubleValue();
					
					extracto.setAhorroVoluntario(ahorroVoluntarioTemporal);
				}
			}
			//extracto.setAhorroVoluntario(ahorroVoluntarioTemporal);
			for (FasCreditosPagosTipoDTO listaCreditos : creditos) {
				if (listaAhorroPermanente.getCorreo().equals(listaCreditos.getFas_afiliados_correo())) {
					creditoTemporal.add(listaCreditos);
					saldoCreditos+=listaCreditos.getSaldo().doubleValue();
					
					extracto.setCreditos(creditoTemporal);
				}
			}
			//extracto.setCreditos(creditoTemporal);
			for (FasConveniosTiposPagosDTO listaConvenios : convenios) {
				if (listaAhorroPermanente.getCorreo().equals(listaConvenios.getFas_afiliados_correo())) {
					convenioTemporal.add(listaConvenios);
					saldoConvenios+=listaConvenios.getSaldo_convenio().doubleValue();
					
					extracto.setConvenios(convenioTemporal);
				}
				
			}
			
			extracto.setSaldoOtroAhorros(saldoOtrosAhorros);
			extracto.setSaldoCreditos(saldoCreditos);
			extracto.setSaldoConvenios(saldoConvenios);
			listaExtractos.add(extracto);
		}


    	return listaExtractos; 
    }
    
    
    /*public List<FasGeneracionExtractoDTO> generarExtractos() {
		// TODO Auto-generated method stub
		return manejadorFasExtractos.consultarExtractosAfiliados();
	}*/

    

    /**
     * {@inheritDoc}
     * @param nombreAtributo {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    protected boolean entidadContieneAtributo(String nombreAtributo) {
        return FasExtractos.contieneAtributo(nombreAtributo);
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc} 
     */
    @Override
    protected Logger getLogger() {
        return logger;
    }

    /**
     * {@inheritDoc}
     * @return  {@inheritDoc}
     */
    @Override
    protected FasExtractosDTO instanciarDAO() {
        return new FasExtractosDTO();
    }

    public List<FasExtractosDTO> consultarExtractoPorAfiliado(String correoAfiliado) {
    	return convertirListaEntidadesADao(manejadorFasExtractos.consultarExtractoPorAfiliado(correoAfiliado));
	}

	
    // protected region Use esta region para su implementacion de otros metodos on begin
    
    
    // protected region Use esta region para su implementacion de otros metodos end

}
