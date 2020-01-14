package com.fasesoft.modelo.manejadores.utils;

public class ConstantesConsultaCreditos {
	
	public static final String RESULTMAPPING_QUERY_NATIVA_SOLICITUDES_CREDITOS = "solicitudesCreditos";
	
	public static final String CONSULTA_SOLICITUDES_CREDUTIS = "SELECT DISTINCT t1.identificacion , t1.nombre, t1.tipoCredito, " + 
			"            t1.cuotas, t1.estado, t1.fechaSolicitud, " + 
			"            t1.idCredito, t1.monto, t1.tasa_real tasaReal, " + 
			"            t3.monto montoFijo, t2.debeCredito deuda  FROM " + 
			"            (SELECT a.identificacion, a.nombre, s.tipo  tipoCredito, " + 
			"            c.numero_cuotas cuotas, c.estado, c.fecha_solicitud fechaSolicitud, " + 
			"            c.id_credito idCredito, c.monto, c.tasa_real, a.correo " + 
			"            FROM FAS_AFILIADOS A " + 
			"            JOIN FAS_CREDITOS c ON (a.correo = c.fas_afiliados_correo) " + 
			"            JOIN FAS_TIPOS_DE_CREDITO s ON (c.fas_tipos_de_credito_id_tipo = s.id_tipo) " + 
			"            JOIN FAS_AHORROS h ON ( a.correo  = h.fas_afiliados_correo ) " + 
			"            JOIN FAS_TIPOS_DE_AHORRO th ON ( h.fas_tipos_aho_id_tipo_aho = th.id_tipo_de_ahorro AND th.tipo = 'PERMANENTE' ) " + 
			"            WHERE c.estado = 'REGISTRADO') t1 " + 
			"             LEFT JOIN (SELECT SUM(c.saldo) debeCredito , c.fas_afiliados_correo FROM FAS_CREDITOS c  WHERE c.estado = 'ENPROCESO' OR c.estado = 'DESEMBOLSADO' GROUP BY c.fas_afiliados_correo ) t2 " + 
			"            ON (t1.correo = t2.fas_afiliados_correo) " + 
			"            JOIN(SELECT " + 
			"                ah.fas_afiliados_correo, sum(ah.monto) monto " + 
			"            FROM fas_ahorros ah group by ah.fas_afiliados_correo) t3 " + 
			"            ON(t1.correo = t3.fas_afiliados_correo) ";
}
