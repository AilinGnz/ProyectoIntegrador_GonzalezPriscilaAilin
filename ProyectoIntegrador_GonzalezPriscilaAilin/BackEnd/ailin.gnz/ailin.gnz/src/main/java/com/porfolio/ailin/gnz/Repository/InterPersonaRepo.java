
package com.porfolio.ailin.gnz.Repository;

import com.porfolio.ailin.gnz.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterPersonaRepo extends JpaRepository<Persona, Long>{
    
}
