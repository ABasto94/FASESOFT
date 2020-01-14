/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fasesoft.web.servicio;

import com.fasesoft.web.servicio.utils.ListaStringMessageBodyWriter;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author milan
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();

        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
    	resources.add(com.fasesoft.web.servicio.ServicioFasAccesos.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasAfiliados.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasAhorros.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasAportes.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasConvenios.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasCreditos.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasExtractos.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasPagos.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasPerfiles.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasPermisos.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasRoles.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasSolConvenios.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasTiposConvenio.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasTiposDeAhorro.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasTiposDeCredito.class);
    	resources.add(com.fasesoft.web.servicio.ServicioFasUsuarios.class);
        
    }
    
}
