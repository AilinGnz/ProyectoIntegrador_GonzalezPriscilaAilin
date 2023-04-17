
package com.porfoliognz.ailin.gnz.Security.Repository;

import com.porfoliognz.ailin.gnz.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario (String nombreUsuario);
    
    boolean existByNombreUsuario (String nombreUsuario);
    boolean existByEmail (String email);

    public Optional<Usuario> finByNombreUsuario(String nombreUsuario);

    public boolean existsByNombreUsuario(String nombreUsuario);

    public boolean existsByEmail(String email);
    
}
