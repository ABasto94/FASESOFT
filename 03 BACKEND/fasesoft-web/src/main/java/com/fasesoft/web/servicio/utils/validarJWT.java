package com.fasesoft.web.servicio.utils;

import org.apache.commons.codec.binary.Base64;

public class validarJWT {

	/**
	 * Método encargado de validar si la URL requiere una validación de token
	 */
	public boolean validarURL(String url, String correo) {
		boolean urlValida = false;
		if (url.equals("servicios/fasaccesos/correo?correo=" + correo)) {
			urlValida = true;
		} else {
			urlValida = true;
		}
		return urlValida;
	}

	public boolean validarToken(String token, String path) throws Exception {
		boolean tokenValido = false;
		if (token.length()  > 20) {
			String jwtToken = token.substring(7);
			// System.out.println("------------ Decode JWT ------------");
			String[] split_string = jwtToken.split("\\.");
			String base64EncodedHeader = split_string[0];
			String base64EncodedBody = split_string[1];
			String base64EncodedSignature = split_string[2];

			// System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
			Base64 base64Url = new Base64(true);
			String header = new String(base64Url.decode(base64EncodedHeader));

			// System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
			String body = new String(base64Url.decode(base64EncodedBody));
			String[] uniqueName = body.split(",");

			String correo = uniqueName[16].replaceAll("\"", "").replaceAll("unique_name:", "");

			if (validarURL(path + "/correo?correo=" + correo, correo)) {
				tokenValido = true;
			}
		} else {
			tokenValido = true;
		}

		return tokenValido;

	}
}