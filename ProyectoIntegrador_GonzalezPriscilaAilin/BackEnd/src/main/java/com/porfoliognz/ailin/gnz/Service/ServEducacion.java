
package com.porfoliognz.ailin.gnz.Service;

import com.porfoliognz.ailin.gnz.Entity.Educacion;
import com.porfoliognz.ailin.gnz.Repository.RepoEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServEducacion {

    @Autowired
    RepoEducacion repoEducacion;

    public List<Educacion> list() {
        return repoEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return repoEducacion.findById(id);
        
    }
    
    public Optional<Educacion> getByNombreEdu (String nombreEdu){
       return repoEducacion.findByNombreEdu(nombreEdu);
    }
    
    public void save (Educacion educacion){
        repoEducacion.save(educacion);
    }
    
    public void delete (int id){
        repoEducacion.delete(id);
    }
    
    public boolean existsById (int id){
        return repoEducacion.existsById(id);
    }
    
    public boolean existsByNombreEdu (String nombreEdu){
        return repoEducacion.existsByNombreEdu(nombreEdu);
    }

}
