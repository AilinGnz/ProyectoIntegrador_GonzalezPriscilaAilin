package com.porfoliognz.ailin.gnz.Interface;

import com.porfoliognz.ailin.gnz.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletepersona(Long id);
    
    public Persona findPersona(Long id);
}
