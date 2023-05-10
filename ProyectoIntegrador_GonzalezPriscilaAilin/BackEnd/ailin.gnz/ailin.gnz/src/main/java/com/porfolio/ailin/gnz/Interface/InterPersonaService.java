package com.porfolio.ailin.gnz.Interface;

import com.porfolio.ailin.gnz.Entity.Persona;
import java.util.List;

public interface InterPersonaService {
    
    public List <Persona> getPersona();
    
    public void savePersona (Persona persona);
    
    public  void deletePersona (Long id);
    
    public Persona findPersona(Long id);
    
    
}
