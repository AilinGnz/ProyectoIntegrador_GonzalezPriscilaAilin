package com.porfoliognz.ailin.gnz.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class UsuarioPrincipal implements UserDetails {

    public static UserDetails buil(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private final String nombre;
    private final String nombreUsuario;
    private final String email;
    private final String password;
    private final Collection<? extends GrantedAuthority> authoritie;

    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authoritie) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authoritie = authoritie;
    }

    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors
                .toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities) {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

    }

    public Collection<? extends GrantedAuthority> getAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;

    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
