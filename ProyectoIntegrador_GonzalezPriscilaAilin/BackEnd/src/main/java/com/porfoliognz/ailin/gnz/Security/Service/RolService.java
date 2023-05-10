
package com.porfoliognz.ailin.gnz.Security.Service;

import com.porfoliognz.ailin.gnz.Security.Entity.Rol;
import com.porfoliognz.ailin.gnz.Repository.Enums.RolNombre;
import com.porfoliognz.ailin.gnz.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class RolService {

    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);

    }

    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
