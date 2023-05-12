
package com.porfoliognz.ailin.gnz.Security.Controller;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ailin
 */

@RestController
public class Mensaje {
    private String mensaje;
    
    
    
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
