
package com.porfoliognz.ailin.gnz.Security.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author ailin
 */
public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    
   

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getnuevoUsuario() {
        throw new UnsupportedOperationException("Not supported yet.");  }
    
    
}
