import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {TalleresComponent} from "./components/talleres/talleres.component";
import {EquiposComponent} from "./components/equipos/equipos.component";
import {LogInComponent} from "./log-in/log-in.component";
import {EditUserComponent} from "./edit-user/edit-user.component";
import {CategoryComponent} from "./components/category/category.component";
import { UnTallerComponent } from './components/unTaller/unTaller.component';
import { UnEquipoComponent } from './components/unEquipo/unEquipo.component';
import {CrearTallerComponent} from "./crear-taller/crear-taller.component";
import {CrearEquipoComponent} from "./crear-equipo/crear-equipo.component";
import {CrearUsuarioComponent} from "./components/crear-usuario/crear-usuario.component";

export const ROUTES: Routes = [
  {path: '', component: LogInComponent},
  {path: 'home', component:HomeComponent},
  {path: 'talleres', component:TalleresComponent},
  {path: 'talleres/:categoria', component:CategoryComponent},
  {path: 'equipos', component:EquiposComponent},
  {path: 'home/editarPerfil/:id', component: EditUserComponent},
  {path: 'talleres/un-taller/:id', component: UnTallerComponent},
  {path: 'equipos/un-equipo/:id', component: UnEquipoComponent},
  {path: 'talleres/crear/taller', component: CrearTallerComponent},
  {path: 'equipos/crear/equipo', component: CrearEquipoComponent},
  {path: 'registro', component: CrearUsuarioComponent},
  {path: '**', component:HomeComponent}
];
