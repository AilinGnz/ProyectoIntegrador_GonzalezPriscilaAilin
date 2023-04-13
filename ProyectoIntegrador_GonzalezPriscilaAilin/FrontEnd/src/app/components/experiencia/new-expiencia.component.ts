import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ServExperienciaService } from 'src/app/service/serv-experiencia.service';

@Component({
  selector: 'app-new-expiencia',
  templateUrl: './new-expiencia.component.html',
  styleUrls: ['./new-expiencia.component.css']
})
export class NewExpienciaComponent implements OnInit {
  nombreExp: string = '';
  descripcionExp: string = '';

  constructor(private servExperiencia: ServExperienciaService, private router: Router ){}


  ngOnInit(): void {
      
  }

  onCreate(): void{
    const exp = new Experiencia(this.nombreExp, this.descripcionExp);
    this.servExperiencia.save(exp).subscribe(
      data=>{
        alert("Experiencia agregada");
        this.router.navigate(['']);
    }, err =>{
      alert("Fallo");
      this.router.navigate([''])
    }
    )
  }
}
