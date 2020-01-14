package com.fasesoft.negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.fasesoft.modelo.dtos.FasAhorrosDTO;
import com.fasesoft.modelo.entidades.FasAhorros;
import com.fasesoft.modelo.excepciones.InvalidParameterException;
import com.fasesoft.modelo.manejadores.ManejadorFasAhorros;
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
import java.util.Date;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

// protected region Incluya importaciones adicionales en esta seccion on begin

// protected region Incluya importaciones adicionales en esta seccion end

/**
 * Servicios para operaciones CRUD y de negocio sobre la entidad FasAhorros
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class NegocioFasAhorros extends NegocioAbstracto<FasAhorros, FasAhorrosDTO> {

    private Number id;
    private BigDecimal monto;
    private String correoAf;
    private BigDecimal tipo;
    private Date fechaInicio;
    private Date fechaSol;

    @EJB
    private ManejadorFasAhorros manejadorFasAhorros;

    /**
     * Variable estatica para imprimir logs...
     */
    private static final Logger logger = Logger.getLogger(NegocioFasAhorros.class.getName());

    // protected region Declare atributos adicionales en esta seccion on begin

    // protected region Declare atributos adicionales en esta seccion end

    /**
     * Realiza un consulta en la entidad FasAhorros aplicando los filtros, el
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
     *                 {@literal fasAhorrosId>1&fasAhorrosName:LIKE:juan}
     * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
     *                 parámetro está compuesto por el nombre del campo por el que
     *                 se quiere ordenar, seguido por el símbolo '$' y
     *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
     *                 ultimos valores son opcionales ya que si no se especifica por
     *                 defecto se asume que el ordenamiento es de forma Ascendente.
     *                 Si se coloca más de un parámetro debe ir separado por coma :
     *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
     *                 ser: fasAhorrosId$ASC, fasAhorrosName$DESC
     * @param from     Número de registro inicial que se quiere retornar de la
     *                 consulta realizada. Entero mayor o igual a 0
     * @param to       Número de registro final que se quiere retornar de la
     *                 consulta realizada. Entero mayor o igual al parámetro from
     * @return Una lista de DAOs de los FasAhorros que se consultaron con los
     *         parámetros enviados por el cliente
     * @throws InvalidParameterException Excepción lanzada cuando algunos de los
     *                                   parámetros de la url tenía un error de
     *                                   sintáxis por lo que no pudo ser procesado
     *                                   correctamente
     */
    public List<FasAhorrosDTO> consultar(String filterBy, String orderBy, Integer from, Integer to)
            throws InvalidParameterException {
        // protected region Modifique el metodo consultar on begin
        logService(this.getClass().getName(), "consultar", filterBy, orderBy, from, to);

        List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
        List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);
        RangoConsulta rango = validarParametrosBloque(from, to);

        return convertirListaEntidadesADao(manejadorFasAhorros.consultar(filtros, ordenamiento, rango));
        // protected region Modifique el metodo consultar end
    }

    
    public List<FasAhorrosDTO> consultarAhorroVoluntario(String correo){
    	List<Object> mail = new ArrayList<Object>();
    	mail.add(correo);
    	return manejadorFasAhorros.consultarAhorroVoluntario(mail);
    }
    /**
     * Crea el fasAhorros que se pasa como parámetro en la base de datos.
     *
     * @param fasAhorrosDTO El DAO de la entidad FasAhorros a crear. Este se envía
     *                      en el cuerpo de la solicitud POST como un objeto JSON.
     * @return La insntancia de FasAhorros recién creado
     */

    /*
     * public FasAhorrosDTO crear(FasAhorrosDTO fasAhorrosDTO) { // protected region
     * Modifique el metodo crear on begin
     * 
     * logService(this.getClass().getName(), "crear", fasAhorrosDTO);
     * 
     * 
     * 
     * FasAhorros fasAhorros = new FasAhorros(); copiarPropiedades(fasAhorros,
     * fasAhorrosDTO);
     * 
     * manejadorFasAhorros.crear(fasAhorros);
     * 
     * 
     * 
     * return fasAhorrosDTO; // protected region Modifique el metodo crear end }
     */
    public FasAhorrosDTO crear(FasAhorrosDTO fasAhorrosDTO) {
        // protected region Modifique el metodo crear on begin

        logService(this.getClass().getName(), "crear", fasAhorrosDTO);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        fasAhorrosDTO.setFechaInicio(timestamp);
        fasAhorrosDTO.setFechaSolicitud(timestamp);
        fasAhorrosDTO.setMonto(BigDecimal.valueOf(12345));
        BigDecimal j = new BigDecimal(1);
        fasAhorrosDTO.setFasTiposAhoIdTipoAho(j);
        // System.out.println("fecha" + fasAhorrosDTO.getFechaInicioAporte());
        // String fecha = fasAhorrosDTO.getFechaInicioAporte().toString();
        // fasAhorrosDTO.setFechaInicioAporte(timestamp.valueOf(fecha));


        FasAhorros fasAhorros = new FasAhorros();
        copiarPropiedades(fasAhorros, fasAhorrosDTO);

        manejadorFasAhorros.crear(fasAhorros);

        return fasAhorrosDTO;
        // protected region Modifique el metodo crear end
    }

    public FasAhorrosDTO crearNuevoAporte(FasAhorrosDTO fasAhorrosDTO) {
        // protected region Modifique el metodo crear on begin
        
        logService(this.getClass().getName(), "crear", fasAhorrosDTO);
         
          List<FasAhorrosDTO> listaAhorros = new ArrayList<>();
        FasAhorrosDTO ahorros = new FasAhorrosDTO();
        
        String correo = fasAhorrosDTO.getFasAfiliadosCorreo();
        Object obj=correo;
       
        List<Object> listaCorreos = new ArrayList<>();
          listaCorreos.add(correo);
        
        
          listaAhorros= manejadorFasAhorros.consultarAporte(listaCorreos); 
          Timestamp fecha = new Timestamp(System.currentTimeMillis());
        fasAhorrosDTO.setFechaSolicitud(fecha);
        //fasAhorrosDTO.setFechaInicio(fecha);
        fasAhorrosDTO.setEstado("ACTIVO");
          fasAhorrosDTO.setFechaInicioAporte(fecha); 

        FasAhorros fasAhorros = new FasAhorros();
        copiarPropiedades(fasAhorros, fasAhorrosDTO);
        
        manejadorFasAhorros.crear(fasAhorros);
        
        return fasAhorrosDTO;
    }

    /**
     * Actualiza en la base de datos el fasAhorros que se pasa como parámetro.
     *
     * @param fasAhorrosDTO El DAO de la entidad FasAhorros a actualizar. Este se
     *                      envía en el cuerpo de la solicitud PUT como un objeto
     *                      JSON.
     * @return La instancia de la entidad FasAhorros que ha sido actualizado
     */
    public FasAhorrosDTO actualizar(FasAhorrosDTO fasAhorrosDTO) {
        // protected region Modifique el metodo actualizar on begin

        logService(this.getClass().getName(), "actualizar", fasAhorrosDTO);

        FasAhorros fasAhorros = manejadorFasAhorros.buscar(fasAhorrosDTO.getIdAhorro());
        copiarPropiedades(fasAhorros, fasAhorrosDTO);

        manejadorFasAhorros.actualizar(fasAhorros);

        return fasAhorrosDTO; // protected region Modifique el metodo actualizar end
    }

    public int actualizarAportePermanente(FasAhorrosDTO fasAhorrosDTO) {
        // protected region Modifique el metodo actualizar on begin
        // int var =
        // consultarAportePermanente(fasAhorrosDTO.getFasAfiliadosCorreo()).get(0).getIdAhorro();
        logService(this.getClass().getName(), "actualizar aporte", fasAhorrosDTO);
        FasAhorros fasAhorros = new FasAhorros();

        copiarPropiedades(fasAhorros, fasAhorrosDTO);

        return manejadorFasAhorros.actualizarAporte(id);

    }

    /**
     * Elimina el fasAhorros con el identificador que se pasa como parámetro.
     *
     * @param idAhorro Valor del atributo del identificador de la instancia de la
     *                 entidad fasAhorros a eliminar
     * @return El identificador del fasAhorros que ha sido eliminado
     */
    public String eliminar(Integer idAhorro) {
        // protected region Modifique el metodo eliminar on begin

        logService(this.getClass().getName(), "eliminar", idAhorro);
        manejadorFasAhorros.eliminarPorId(idAhorro);

        StringBuilder valores = new StringBuilder();
        valores.append(String.valueOf(idAhorro));
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
     *                 {@literal fasAhorrosId>1&fasAhorrosName:LIKE:juan}
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

        return String.valueOf(manejadorFasAhorros.consultarTotalRegistros(filtros, rango));
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
     *                 {@literal fasAhorrosId>1&fasAhorrosName:LIKE:juan}
     * @param orderBy  Cadena de caracteres con los parámetros de ordenamiento. Cada
     *                 parámetro está compuesto por el nombre del campo por el que
     *                 se quiere ordenar, seguido por el símbolo '$' y
     *                 posteriormente por los valores 'ASC' o 'DESC'. Estos dos
     *                 ultimos valores son opcionales ya que si no se especifica por
     *                 defecto se asume que el ordenamiento es de forma Ascendente.
     *                 Si se coloca más de un parámetro debe ir separado por coma :
     *                 ','. Ej. Una secuencia de parámetros de ordenamiento puede
     *                 ser: fasAhorrosId$ASC, fasAhorrosName$DESC
     * @param atributo Nombre del atributo de la entidad FasAhorros del cual se
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
                manejadorFasAhorros.consultarLista(filtros, ordenamiento, infoAgrupamiento));
        // protected region Modifique el metodo consultarLista end
    }

    public List<FasAhorrosDTO> consultarAportePermanente(String correo) {

        Object obj = correo;
        List<Object> listaCorreos = new ArrayList<>();
        listaCorreos.add(correo);
        List<FasAhorrosDTO> var = manejadorFasAhorros.consultarAporte(listaCorreos);
        System.out.println(var.get(0).getIdAhorro());
        id = var.get(0).getIdAhorro();
        monto = var.get(0).getMonto();
        correoAf = var.get(0).getFasAfiliadosCorreo();
        tipo = var.get(0).getFasTiposAhoIdTipoAho();
        fechaInicio = var.get(0).getFechaInicio();
        fechaSol = var.get(0).getFechaSolicitud();

        return manejadorFasAhorros.consultarAporte(listaCorreos);

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
    protected FasAhorrosDTO instanciarDAO() {
        return new FasAhorrosDTO();
    }

    @Override
    protected boolean entidadContieneAtributo(String nombreAtributo) {
        // TODO Auto-generated method stub
        return false;
    }

    // protected region Use esta region para su implementacion de otros metodos on
    // begin
    
	public List<FasAhorrosDTO> consultarSolicitudesVoluntarias() {
		List<FasAhorros> ahorros = manejadorFasAhorros.consultarSolicitudesVoluntariasPendientes();

		return convertirListaEntidadesADao(ahorros);
	}

    // protected region Use esta region para su implementacion de otros metodos end

}
