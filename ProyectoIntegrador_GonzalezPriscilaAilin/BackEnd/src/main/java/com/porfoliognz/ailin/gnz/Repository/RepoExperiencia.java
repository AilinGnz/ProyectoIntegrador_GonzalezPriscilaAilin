
package com.porfoliognz.ailin.gnz.Repository;

import com.porfoliognz.ailin.gnz.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoExperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional <Experiencia> findByNombreExp (String nombreExp);
    public boolean existByNombreExp (String nombreExp);
    
}
