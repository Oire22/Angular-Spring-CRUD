import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { PersonaServiceService } from './servicios/persona-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'angularDemo';

  personas: any = [] //array de personas
  persona: any = {} //objeto persona
  nombre!: string;
  apellido!:string;
  edad!:number;
  id!: number
  

  accion = "crear";

  constructor(private personaService: PersonaServiceService){
  }
    ngOnInit(){
     
      //consola 
      this.personaService.getPersonas().subscribe(personas => console.log(personas));
      //pantalla
      this.personaService.getPersonas().subscribe(personas => {
        this.personas = personas;
      });
    }
    onSubmit() {
      

        const persona = {nombre: this.nombre, apellido: this.apellido, edad: this.edad };
        this.personaService.create(persona).subscribe(
          response => console.log(response),
          error => console.error(error)
          );
         
        }
    submit()  {

      this.personaService.editPersona(this.persona.id, this.persona)
      .subscribe(
        data => console.log(data),
        error => console.log(error)
      );
    }    

    
    eliminar(id: number) {
      this.personaService.eliminarPersona(id)
      .subscribe(() => console.log('Persona eliminada'));
    }
    
  }
