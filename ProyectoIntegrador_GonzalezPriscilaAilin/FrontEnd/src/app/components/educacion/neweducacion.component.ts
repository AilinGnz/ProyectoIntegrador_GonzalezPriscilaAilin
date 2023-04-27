import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-neweducacion',
  templateUrl: './neweducacion.component.html',
  styleUrls: ['./neweducacion.component.css']
})
export class NeweducacionComponent implements OnInit{

  nombreEdu: string;
  descripcionEdu: string;

  constructor( private educacionServ: EducacionService, private router: Router){}

  ngOnInit(): void {
      
  }
  onCreate(): void{
    const educacion = new Educacion(this.nombreEdu, this.descripcionEdu);
    this.educacionServ.save (educacion).subscribe(
    data =>{
      alert ("Educacion agredada de forma correcta");
      this.router.navigate(['']);
    }, err =>{
      alert ("fallo");
      this.router.navigate(['']);
    }
    )
  }

}
