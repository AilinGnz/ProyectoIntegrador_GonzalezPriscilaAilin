
package com.porfoliognz.ailin.gnz.Security.Repository;

import com.porfoliognz.ailin.gnz.Security.Entity.Rol;
import com.porfoliognz.ailin.gnz.Repository.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolOptional (RolNombre rolnombre);

    public Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
