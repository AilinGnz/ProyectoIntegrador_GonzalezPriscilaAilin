
package com.porfoliognz.ailin.gnz.Service;

import com.porfoliognz.ailin.gnz.Entity.hYs;
import com.porfoliognz.ailin.gnz.Repository.RepohYs;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service

public class ServhYs {
    @Autowired
    RepohYs rhys;
    
    public List<hYs> list(){
        return rhys.findAll();
    }
    
    public Optional<hYs> getOne (int id){
        return rhys.findById(id);
    }
    public Optional<hYs> getByNombre (String nombre){
        return rhys.findByNombre(nombre);
    }
    public void save(hYs skill){
        rhys.save(skill);
    }
    
    public void delete (int id){
        rhys.deleteById(id);
    }
    
    public boolean existsById (int id){
        return rhys.existsById(id);
    }
    
    public boolean existsByNombre (String nombre){
        return rhys.existsByNombre(nombre);
    }
}
