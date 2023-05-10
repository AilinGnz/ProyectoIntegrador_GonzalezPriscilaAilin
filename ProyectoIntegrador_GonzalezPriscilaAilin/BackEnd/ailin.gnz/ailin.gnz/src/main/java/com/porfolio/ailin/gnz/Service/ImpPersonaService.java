package com.porfolio.ailin.gnz.Service;

import com.porfolio.ailin.gnz.Entity.Persona;
import com.porfolio.ailin.gnz.Interface.InterPersonaService;
import com.porfolio.ailin.gnz.Repository.InterPersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements InterPersonaService {

    @Autowired
    InterPersonaRepo interPersonaRepo;

    @Override
    public List<Persona> getPersona() {
       List<Persona> persona = interPersonaRepo.findAll();
       return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        interPersonaRepo.save(persona);
       }

    @Override
    public void deletePersona(Long id) {
        interPersonaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
    Persona persona = interPersonaRepo.findById(id).orElse(null);
    return persona;
    }

}
