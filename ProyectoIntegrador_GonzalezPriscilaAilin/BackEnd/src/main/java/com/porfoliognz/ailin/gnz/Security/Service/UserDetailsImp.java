package com.porfoliognz.ailin.gnz.Security.Service;

import com.porfoliognz.ailin.gnz.Security.Entity.Usuario;
import com.porfoliognz.ailin.gnz.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDatailsService{
   @Autowired
   UsuarioService usuarioService;
   
   public UserDetails loadUserByUsername (String nombreUsuario) throws  UsernameNotFoundException{
       Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
       return UsuarioPrincipal.buil (usuario);
   }
   
}
