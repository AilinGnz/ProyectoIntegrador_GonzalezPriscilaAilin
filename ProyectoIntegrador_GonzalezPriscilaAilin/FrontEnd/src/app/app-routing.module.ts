import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NewExpienciaComponent } from './components/experiencia/new-expiencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'nuevaExp', component: NewExpienciaComponent},
  { path: 'editExp/:id', component: EditExperienciaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
