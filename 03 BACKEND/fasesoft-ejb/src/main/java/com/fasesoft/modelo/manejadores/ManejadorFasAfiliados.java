package com.fasesoft.modelo.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.fasesoft.modelo.dtos.FasAfiliadosDTO;
import com.fasesoft.modelo.dtos.FasAportesBeneficiosDTO;
import com.fasesoft.modelo.dtos.FasDesafilacionAhorrosDTO;
import com.fasesoft.modelo.dtos.FasDesafilacionCreditosDTO;
import com.fasesoft.modelo.dtos.FasSolicitudesAfiliacionDTO;
import com.fasesoft.modelo.entidades.FasAfiliados;
import com.fasesoft.modelo.manejadores.utils.ConstantesConsultas;
import com.fasesoft.modelo.manejadores.utils.ManejadorCrud;

/**
 * Manejador que define las operaciones CRUD y de negocio a realizar sobre la
 * tabla correspondiente a la entidad FasAfiliados.
 * 
 * @author GeneradorCRUD
 */
@Stateless
public class ManejadorFasAfiliados extends ManejadorCrud<FasAfiliados, String> {

	public ManejadorFasAfiliados() {
		super(FasAfiliados.class);
	}

	public List<FasAfiliados> consultarDatosAfiliadoPorCorreo(String correoAfiliado) {
		return mp.createNamedQuery("FasAfiliados.findUserInfoByCorreo").setParameter("paramCorreo", correoAfiliado)
				.getResultList();
	}

	public List<FasAfiliados> consultarAfiliadosUsuarios() {
		return mp.createNamedQuery("FasAfiliados.afiliadosUsuarios").getResultList();
	}

	public List<FasAfiliadosDTO> consultarDatosAfiliadoPorCorreoAres(String correo) {
		List<Object> listaCorreo = new ArrayList<Object>();
		Object obj = correo;
		listaCorreo.add(obj);
		return mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_USUARIOS_ARES, listaCorreo,
				ConstantesConsultas.RESULT_MAPPING_USUARIOS_ARES);
	}

	public List<FasDesafilacionAhorrosDTO> consultarDeudaAhorrosAfiliado(List<Object> objetosParam) {
		return mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_CONSULTAR_AHORROS_DEUDA_AFILIADO, objetosParam,
				ConstantesConsultas.RESULT_MAPPING_CONSULTA_DEUDA_AHORROS);
	}

	public List<FasDesafilacionCreditosDTO> consultarDeudaCreditosAfiliados(List<Object> objetosParam) {
		return mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_CONSULTAR_CREDITOS_DEUDA_AFILIADO, objetosParam,
				ConstantesConsultas.RESULT_MAPPING_CONSULTA_DEUDA_CREDITOS);
	}

	public int actualizarAfiliado(List<Object> objetosParam) {
		System.out.println("manejador");
		return mp.doNativeQueryUpdate(ConstantesConsultas.QUERY_NATIVE_ACTUALIZAR_AFILIADO, objetosParam);
	}

	public int actualizarUsuario(List<Object> objetosParam) {
		return mp.doNativeQueryUpdate(ConstantesConsultas.QUERY_NATIVE_ACTUALIZAR_USUARIO, objetosParam);
	}

	public int actualizarRoles(List<Object> objetosParam) {
		return mp.doNativeQueryUpdate(ConstantesConsultas.QUERY_NATIVE_ACTUALIZAR_ROLES, objetosParam);
	}

	public List<FasAportesBeneficiosDTO> consultarAporteBeneficioAfiliado(List<Object> params) {
		return mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_CONSULTAR_BENEFICIO_APORTE_PERMANENTE, params,
				ConstantesConsultas.RESULT_MAPPING_CONSULTAR_APORTE_BENEFICIO_PERMANENTE);

	}

	public List<FasAfiliadosDTO> consultarFechaRetiroFondo(List<Object> param) {
		return mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_CONSULTAR_FECHA_RETIRO, param,
				ConstantesConsultas.RESULT_MAPPING_CONSULTA_RETIROS_FECHAS);
	}
	

	public List<FasSolicitudesAfiliacionDTO> consultarSolicitudesAfiliacion(){
		return mp.doNativeQuery(ConstantesConsultas.QUERY_NATIVE_CONSULTAR_SOLICITUES_AFILIACION, null, ConstantesConsultas.RESULT_MAPPING_CONSULTA_SOLICITUDES_AFILIACION);
	}
	// protected region Use esta region para su implementacion del manejador on
	// begin

	// protected region Use esta region para su implementacion del manejador end
}
