/*
 *  2018 Daryl Ospina
 */
package com.api.services.conf;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Daryl Ospina
 */
@javax.ws.rs.ApplicationPath("services")
public class ServicesConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.api.services.ServicioCaucion.class);
        resources.add(com.api.services.ServicioCondenado.class);
        resources.add(com.api.services.ServicioCondicion.class);
        resources.add(com.api.services.ServicioDelito.class);
        resources.add(com.api.services.ServicioFallador.class);
        resources.add(com.api.services.ServicioOfendido.class);
        resources.add(com.api.services.ServicioPena.class);
        resources.add(com.api.services.ServicioPenaDelito.class);
        resources.add(com.api.services.ServicioProceso.class);
        resources.add(com.api.services.ServicioRedencionPena.class);
        resources.add(com.api.services.ServicioSituacionJuridica.class);
    }
    
}
