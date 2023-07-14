
package com.example.jpaDemo.service;

import com.example.jpaDemo.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    //traer 
    public List <Persona> getPersonas();
    
    //dar de alta
    public void savePersona(Persona perso);
    
    //borrar
    public void deletePersona(Long id);
    
    //encontrar
    public Persona findPersona(Long id);
}
