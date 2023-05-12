
package com.porfoliognz.ailin.gnz.Repository;

import com.porfoliognz.ailin.gnz.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ailin
 */
@Repository
public interface RepoEducacion extends JpaRepository<Educacion, Integer>{
    public Optional <Educacion> findByNombreEdu (String nombreEdu);
    public boolean existsByNombreEdu (String nombreEdu);

    public void delete(int id);
}
