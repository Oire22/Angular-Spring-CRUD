
package com.example.jpaDemo.controller;

import com.example.jpaDemo.model.Persona;
import com.example.jpaDemo.service.IPersonaService;
import jakarta.ws.rs.Produces;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    
    @CrossOrigin
    @GetMapping("/personas/traer")
    public List <Persona> getPersonas(){
        return interPersona.getPersonas();
    }
    
    @CrossOrigin
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        interPersona.deletePersona(id);
        return "La persona fue eliminida correctamente";
    }
    /*
    //data como query parameters
    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("edad") int nuevaEdad){
        Persona perso = interPersona.findPersona(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        
        interPersona.savePersona(perso);
        
        return perso;
   
    }*/
    
    //Data en el request body
   
    
  @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestBody Persona nuevaPersona){
    Persona perso = interPersona.findPersona(id);

    perso.setNombre(nuevaPersona.getNombre());
    perso.setApellido(nuevaPersona.getApellido());
    perso.setEdad(nuevaPersona.getEdad());

    interPersona.savePersona(perso);

    return perso;
    }   
}
