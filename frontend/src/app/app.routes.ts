import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {TalleresComponent} from "./components/talleres/talleres.component";
import {EquiposComponent} from "./components/equipos/equipos.component";
import {LogInComponent} from "./log-in/log-in.component";
import {EditUserComponent} from "./edit-user/edit-user.component";

export const ROUTES: Routes = [
  {path: '', component: LogInComponent},
  {path: 'home', component:HomeComponent},
  {path: 'talleres', component:TalleresComponent},
  {path: 'talleres/:categoria', component:TalleresComponent},
  {path: 'equipos', component:EquiposComponent},
  {path: 'home/editarPerfil/:id', component: EditUserComponent},
  {path: '**', component:HomeComponent}
];
