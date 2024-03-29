
package com.porfoliognz.ailin.gnz.Security.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author ailin
 */
public class JwtDto {

    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    
    
    public JwtDto(String Token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = Token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }

    
    
    public String getToken() {
        return token;
    }

    public void setToken(String Token) {
        this.token = Token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
