
package com.porfoliognz.ailin.gnz.Repository;

import com.porfoliognz.ailin.gnz.Entity.hYs;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepohYs extends JpaRepository<hYs, Integer>{
    Optional<hYs> findByNombre (String nombre);
    public boolean existsByNombre (String nombre);
    
}
