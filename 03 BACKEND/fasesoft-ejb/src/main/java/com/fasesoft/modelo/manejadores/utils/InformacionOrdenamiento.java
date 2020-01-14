package com.fasesoft.modelo.manejadores.utils;

import com.fasesoft.modelo.enums.TipoOrdenamiento;

public class InformacionOrdenamiento {	
	
	public final TipoOrdenamiento tipo;
	public final String campo;
	
	public InformacionOrdenamiento(TipoOrdenamiento tipo, String campo) {
		this.tipo = tipo;
		this.campo = campo;
	}        

}
