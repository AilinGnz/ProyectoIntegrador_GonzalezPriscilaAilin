package com.porfoliognz.ailin.gnz.Security.Service;

import com.porfoliognz.ailin.gnz.Security.Entity.Usuario;
import com.porfoliognz.ailin.gnz.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;
    
    @Override
public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException{
    Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con nombre: " + nombreUsuario));
    return UsuarioPrincipal.build(usuario);
}

}
