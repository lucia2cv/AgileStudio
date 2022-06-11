import { Component, OnInit } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {Equipo, EquipoService} from "../servicios/equipo.service";
import {Users, UserService} from "../user.service";
import {Taller, TallerService} from "../servicios/taller.service";
import {LoginService} from "../log-in/login.service";
import {Router} from "@angular/router";

export interface TeamForm{
  id?: number;
  nombre: string;
  logo: string;
  miembros: number[];
  talleres: number[];
}
@Component({
  selector: 'app-crear-equipo',
  templateUrl: './crear-equipo.component.html',
  styleUrls: ['./crear-equipo.component.css']
})
export class CrearEquipoComponent implements OnInit {
  users: Users[];
  talleres: Taller[];
  teamForm: TeamForm;
  constructor(public teamsServicee: EquipoService, private snackBar: MatSnackBar, public userService: UserService, public tallerService: TallerService, public loginService: LoginService, private router:Router) {
    this.teamForm = {
      nombre: '',
      logo: '',
      miembros: [],
      talleres: []
    };
  }

  ngOnInit(): void {
    if (this.loginService.user.rol !== 'scrum master') {
      this.router.navigate(['equipos']);
    } else {
      this.userService.getAllUsers().subscribe(
        (u) => {
          this.users=u;
        },
        error=>console.log(error)
      );
      this.tallerService.getAllWorkshopsList().subscribe(
        (talleres) => {
          this.talleres=talleres;
        },
        error=>console.log(error)
      );
    }

  }

  saveTeam(){
    this.teamsServicee.saveTeam(this.teamForm).subscribe(() => {
      this.snackBar.open('Equipo guardado correctamente', 'OK', {duration: 4000});
    }, error => {
      console.log(error);
      this.snackBar.open('Algo ha fallado', 'OK', {duration: 4000});
    });
  }
}
