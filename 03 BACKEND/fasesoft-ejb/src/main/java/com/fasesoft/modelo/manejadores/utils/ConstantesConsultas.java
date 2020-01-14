package com.fasesoft.modelo.manejadores.utils;

public class ConstantesConsultas {
	
	public static final String QUERY_NATIVA_CONSULTAR_PAGOS_AFILIADO = "SELECT " +
			"CTC.TIPO, CTC.MONTO, pc.cuota_total, CTC.TASA_REAL, CTC.MORA, CTC.SALDO " + 
			"FROM fas_pagos PC " + 
			"        JOIN (SELECT * " + 
			"        FROM FAS_CREDITOS C " + 
			"        JOIN FAS_TIPOS_DE_CREDITO TC " + 
			"        ON (c.fas_tipos_de_credito_id_tipo = tc.id_tipo)) CTC " + 
			"ON (pc.fas_creditos_id_credito = CTC.ID_CREDITO) ";
	
	public static final String QUERY_NATIVA_CONSULTAR_AHORROS_PERMANENTES_AFILIADO = "SELECT " + 
			"        correo," + 
			"        nombre," + 
			"        apellido," + 
			"        telefono," + 
			"        direccion," + 
			"        identificacion," + 
			"        cuenta_bancaria," + 
			"        fecha_ingreso," + 
			"        beneficio," + 
			"        fecha_aporte," + 
			"        monto," + 
			"        aporte," + 
			"        ahorro_permanente," + 
			"        aportes_ordinarios," +
			"        ahorro_permanente_aporte," +
			"        aportes_ordinarios_aporte," +
			"        tipo " + 
			"    FROM ahorro_aportes_permanentes where ahorro_aportes_permanentes.fecha_aporte BETWEEN ?1 AND ?2";
	
	public static final String QUERY_NATIVA_CONSULTAR_AHORROS_VOLUNTARIOS_AFILIADO = " SELECT" + 
			"                beneficio," + 
			"                fecha_aporte," + 
			"                monto," + 
			"                aporte," + 
			"                fas_afiliados_correo," + 
			"                tipo" + 
			"            FROM ahorro_aportes_voluntarios where ahorro_aportes_voluntarios.fecha_aporte BETWEEN ?1 AND ?2";
	
	public static final String RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_PAGOS_AFILIADO = "detallePagosAfiliados";
	
	
	public static final String RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_APORTE_PERMANENTE_AFILIADO = "aportePermanenteAfiliado";
	
	public static final String RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_APORTE_VOLUNTARIO_AFILIADO = "aporteVoluntarioAfiliado";
	
	public static final String QUERY_NATIVA_GENERECION_EXTRACTOS ="SELECT"+
			"*"+ 
			"FROM EXTRACTO_FINAL ";
	
	public static final String  RESULSETMAPPING_QUERY_NATIVA_CONSULTAR_EXTRACTOS ="extractosAfiliados";
	
	public static final String QUERY_NATIVE_TIPO_PAGO_CONVENIO = "SELECT " + 
			"    cp.fas_afiliados_correo, " + 
			"    cp.id_convenio, " + 
			"    cp.monto_convenio, " + 
			"    cp.saldo_convenio, " + 
			"    cp.fecha_desembolso_conv, " + 
			"	 cp.fecha_de_pago, " +	
			"    cp.tasa_convenio, " + 
			"    cp.mora_convenio, " + 
			"    cp.tipo_convenio, " + 
			"    cp.cuota_total " + 
			"FROM convenios_tipos_pagos cp WHERE cp.fecha_de_pago BETWEEN ?1 AND ?2";
	
	public static final String RESULTMAPPING_QUERY_CONSULTAR_PAGOS_CONVENIOS = "pagosConvenios";
	
	public static final String QUERY_NATIVE_TIPO_PAGO_CREDITO ="SELECT " + 
			"    pcg.tipo," + 
			"    pcg.monto," + 
			"    pcg.cuota_total," +
			"	 pcg.fecha_de_pago," +	
			"    pcg.tasa_real," + 
			"    pcg.mora," + 
			"    pcg.saldo," + 
			"    pcg.fas_afiliados_correo," +
			"    pcg.fecha_desembolso " +
			"FROM creditos_tipos_creditos_pagos pcg WHERE pcg.fecha_de_pago BETWEEN ?1 AND ?2";
	
	public static final String  RESULT_MAPPING_CONSULTAR_PAGO_CREDITOS="pagosCreditos";	
	
	
    public static final String QUERY_NATIVE_USUARIOS_ARES = " select  " + 
            "            p.CORREO correo, " + 
            "            p.NOMBRE nombre, " + 
            "            p.APELLIDO apellido,  " + 
            "            p.TELEFONO telefono,  " + 
            "            p.DIRECCION direccion,  " + 
            "            p.IDENTIFICACION identificacion, " + 
            "            p.TIPO_ID tipoId,  " + 
            "            p.FECHA_RETIRO fechaRetiro, " + 
            "            p.FECHA_INGRESO fechaIngreso, " + 
            "            p.Cuenta_Bancaria cuentaBancaria, " + 
            "            p.total_otros_ahorros totalOtrosAhorros, " + 
            "            p.banco banco, " + 
            "            p.expedicion expedicion, " + 
            "            p.ciudad ciudad, " + 
            "            p.dependencia dependencia, " + 
            "            p.estado_civil estadoCivil " +
            " from fas_afiliados p where p.correo = ?";          
    public static final String  RESULT_MAPPING_USUARIOS_ARES="usuariosAres";
	
	
	public static final String QUERY_NATIVE_PARAMETROS = "SELECT  " + 
			"P.CODIGO codigo, " + 
			"P.DESCRIPCION descripcion, " + 
			"P.VALOR valor " + 
			"FROM FAS_PARAMETROS P";			
	public static final String  RESULT_MAPPING_PARAMETROS="parametros";	

	public static final String QUERY_NATIVE_CONSULTAR_BENEFICIO_APORTE_PERMANENTE = "SELECT " + 
			"    af.identificacion," + 
			"    dap.aporte," + 
			"    dap.beneficio," + 
			"    dap.fecha_aporte " + 
			"FROM " + 
			"    fas_afiliados af " + 
			"    JOIN (" + 
			"        SELECT " + 
			"            ap.beneficio, " + 
			"            ap.fecha_aporte, " + 
			"            apah.* " + 
			"        FROM " + 
			"            fas_aportes ap " + 
			"            JOIN ( " + 
			"                SELECT " + 
			"                    gh.aporte, " + 
			"                    gh.fas_afiliados_correo, " + 
			"                    gh.monto, " + 
			"                    gh.id_ahorro " + 
			"                FROM " + 
			"                    fas_tipos_de_ahorro   ta " + 
			"                    JOIN fas_ahorros           gh ON ( ta.id_tipo_de_ahorro = gh.fas_tipos_aho_id_tipo_aho ) " + 
			"                WHERE " + 
			"                    ta.tipo = 'PERMANENTE' " + 
			"            ) apah ON ( ap.fas_ahorros_id_ahorro = apah.id_ahorro ) " + 
			"    ) dap ON( af.correo = dap.fas_afiliados_correo ) where dap.fecha_aporte BETWEEN ?1 AND ?2 ";
	
	public static final String RESULT_MAPPING_CONSULTAR_APORTE_BENEFICIO_PERMANENTE ="beneficiosAportesAfiliados"; 
	public static final String QUERY_NATIVE_CONSULTAR_FECHA_RETIRO= "SELECT " + 
			"    af.nombre " + 
			"    || ' ' " + 
			" || af.apellido AS nombre, " + 
			"    af.correo," + 
			"    af.fecha_retiro " + 
			" FROM " + 
			"    fas_afiliados af " + 
			"WHERE af.fecha_retiro BETWEEN ?1 AND ?2";
	public static final String RESULT_MAPPING_CONSULTA_RETIROS_FECHAS="fechaRetiros";
	
	public static final String QUERY_NATIVE_CONSULTAR_AHORROS_DEUDA_AFILIADO="SELECT " + 
			"    ah.monto, " + 
			"    ah.fas_afiliados_correo, "+
			"    ta.tipo " + 
			"	 FROM " + 
			"    fas_ahorros ah " + 
			"    JOIN fas_tipos_de_ahorro   ta ON ( ah.fas_tipos_aho_id_tipo_aho = ta.id_tipo_de_ahorro ) " + 
			"WHERE " + 
			"    ah.fas_afiliados_correo = ? and ah.estado='ACTIVO'";
	public static final String RESULT_MAPPING_CONSULTA_DEUDA_AHORROS="deudaAhorrosAfiliados";
	
	public static final String QUERY_NATIVE_CONSULTAR_CREDITOS_DEUDA_AFILIADO="SELECT " + 
			"    cr.saldo, " + 
			"    tc.tipo, " + 
			"    cr.estado, " + 
			"    cr.fas_afiliados_correo "+
			"    FROM " + 
			"    fas_creditos cr " + 
			"    JOIN fas_tipos_de_credito   tc ON ( cr.fas_tipos_de_credito_id_tipo = tc.id_tipo ) " + 
			"    WHERE " + 
			"    cr.fas_afiliados_correo = ? and cr.estado<>'FINALIZADO'";
	public static final String RESULT_MAPPING_CONSULTA_DEUDA_CREDITOS="deudaCreditosAfiliados";
	
	public static final String QUERY_NATIVE_ACTUALIZAR_AFILIADO= "UPDATE "
			+ "fas_afiliados f "
			+ "SET "
			+ "f.fecha_retiro = ?1 "
			+ "WHERE "
			+ "f.correo= ?2";
	public static final String RESULT_MAPPING_ACTUALIZAR="actualizarAfiliado";
	
	public static final String QUERY_NATIVE_ACTUALIZAR_USUARIO= "UPDATE "
			+ "fas_usuarios f "
			+ "SET "
			+ "f.estado = 'RETIRADO' "
			+ "WHERE "
			+ "f.fas_afiliados_correo= ?";
	public static final String RESULT_MAPPING_ACTUALIZAR_USUARIO="actualizarUsuario";
	
	public static final String QUERY_NATIVE_ACTUALIZAR_ROLES= "UPDATE "
			+ "fas_roles f "
			+ "SET "
			+ "f.fas_perfiles_id_perfil= (SELECT"
			+ " p.id_perfil "
			+ "FROM fas_perfiles p "
			+ "WHERE p.tipo='NO AFILIADO') "
			+ "WHERE f.fas_perfiles_id_perfil="
			+ "(SELECT "
			+ "u.id_usuario FROM fas_usuarios u "
			+ "WHERE "
			+ "u.fas_afiliados_correo= ?)";
	public static final String RESULT_MAPPING_ACTUALIZAR_ROLES="actualizarRoles";
	
	
	
	
	/*public static final String QUERY_NATIVE_APORTE_PERMANENTE = "SELECT " + 
			
			"    monto, " + 
			"    fecha_inicio, " + 
			"    estado, " + 
			"    aporte, " + 
			"    fas_afiliados_correo, " + 
			"    fas_tipos_aho_id_tipo_aho, " + 
			"    fecha_solicitud, " + 
			"    fecha_inicio_aporte " + 
			"FROM " + 
			"    fas_ahorros " + 
			"WHERE fas_afiliados_correo = ? AND estado = 'ACTIVO'"; */
	
public static final String QUERY_NATIVE_APORTE_PERMANENTE = "SELECT ah.id_ahorro,"+
		"               ah.monto," + 
		"               ah.fecha_inicio, " + 
		"			    ah.estado, " + 
		"			    ah.aporte, " + 
		"			    ah.fas_afiliados_correo," + 
		"			    ah.fas_tipos_aho_id_tipo_aho," + 
		"			    ah.fecha_solicitud, " + 
		"			    ah.fecha_inicio_aporte " + 
		"			FROM " + 
		"			    fas_ahorros ah join fas_tipos_de_ahorro ap on (ap.id_tipo_de_ahorro = ah.fas_tipos_aho_id_tipo_aho)" + 
		"			WHERE ah.fas_afiliados_correo = ? AND ah.estado = 'ACTIVO' AND ap.tipo='PERMANENTE'"; 
	public static final String  RESULT_MAPPING_APORTE_PERMANENTE="consultaAportePermanente";	
	public static final String QUERY_NATIVE_CONSULTAR_SOLICITUES_AFILIACION= "select " + 
			"u.FAS_AFILIADOS_CORREO as correo, " + 
			"(a.nombre ||' '|| a.apellido) as nombres, " + 
			"ah.aporte as aporte, " + 
			"a.telefono as telefono, " + 
			"u.estado as estado, " + 
			"u.id_usuario as idUsuario, " + 
			"u.contraseña as contraseña, " + 
			"u.fecha_cracion as fechaCreacion " + 
			" " + 
			"from fas_afiliados a, fas_usuarios u, fas_ahorros ah " + 
			"where " + 
			" a.correo  = u.FAS_AFILIADOS_CORREO and " + 
			" ah.FAS_AFILIADOS_CORREO = a.correo and u.estado='REGISTRADO' and ah.estado='PENDIENTE'";
	public static final String RESULT_MAPPING_CONSULTA_SOLICITUDES_AFILIACION="solicitudesAfiliacion";
	
	public static final String QUERY_NATIVE_CONSULTAR_AHORROS_POR_CORREO= "select " + 
			"a.monto as monto, " + 
			"a.fecha_inicio as fechaInicio, " + 
			"a.estado as estado, " + 
			"a.aporte as aporte, " + 
			"a.fas_afiliados_correo as fasAfiliadosCorreo, " + 
			"a.fecha_inicio_aporte   " +  
			"from fas_afiliados af,  fas_ahorros a " + 
			"where " + 
			" af.correo  = a.fas_afiliados_correo and a.fas_tipos_aho_id_tipo_aho =1 AND a.fas_afiliados_correo = ? ";
	public static final String RESULT_MAPPING_CONSULTAR_AHORROS_POR_CORREO="solicitudesAhorros";
	
	public static final String CREATE_TIPO_CONVENIO = "INSERT INTO Fas_Tipos_Convenio "
			+ "( ID_TIPO_CONVENIO,tipo, tasa, estado, descripcion, url_convenio, cuotas_maximas) "
			+ "VALUES (SQ_FAS_TIPOS_CONVENIOS.nextval,?1,?2,?3,?4,?5,?6) ";
	public static final String RESULT_MAPPING_CREAR_TIPO_CONVENIO="creatTipoConvenio";
}
