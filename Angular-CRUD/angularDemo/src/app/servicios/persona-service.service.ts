import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';


@Injectable({
  providedIn: 'root'
})

export class PersonaServiceService {

  constructor(private http: HttpClient) { }



 getPersonas(){ //ver usuarios en pantalla y en consola
   return this.http.get<any[]>('http://localhost:8080/personas/traer');
  }


  create(persona: any) {
    return this.http.post('http://localhost:8080/personas/crear', persona, {responseType: "text"});
  }



  eliminarPersona(id:number){
    return this.http.delete("http://localhost:8080/personas/borrar/" + id)
  }
  
  editPersona(id: number, persona: any){
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put("http://localhost:8080/personas/editar/" + id, persona,{headers})
  }
}
