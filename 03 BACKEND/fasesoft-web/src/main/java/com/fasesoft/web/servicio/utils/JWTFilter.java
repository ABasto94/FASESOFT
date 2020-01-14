package com.fasesoft.web.servicio.utils;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class JWTFilter implements ContainerResponseFilter {

	private static final String MENSAJE = "{\"errorCode\": 4	00,\"errorMessage\": \"El usuario no tiene autorizacion o el tiempo de la sesion ha finalizado\"}";

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		String path = requestContext.getUriInfo().getPath();
		validarJWT jwt = new validarJWT();
		boolean urlValida = false;
		String token = null;

		if (requestContext.getHeaderString("Authorization") != null) {
			token = requestContext.getHeaderString("Authorization");
			if (!urlValida) {
				if (token == null) {
					responseContext.setStatus(210);
					responseContext.setEntity(MENSAJE);
					return;
				} else {
					boolean tokenValido = false;
					try {
						tokenValido = jwt.validarToken(token, path);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (!tokenValido) {
						System.out.println("token invalido");
						responseContext.setStatus(210);
						responseContext.setEntity(MENSAJE);
						return;
					}
				}
			}
		}
	}
}
