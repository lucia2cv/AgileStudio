import { Component, OnInit } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {UserService} from "../../user.service";
import {Equipo} from "../../servicios/equipo.service";
export interface RegisterForm{
  id?: number;
  nombre: string;
  email: string;
  password: string;
  rol: string;
  img: string;
  teams: number[];
}
@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styleUrls: ['./crear-usuario.component.css']
})

export class CrearUsuarioComponent implements OnInit {

  roles: string[] = ['desarrollador', 'scrum master', 'product owner'];
  registerForm: RegisterForm;
  equipos: Equipo[];
  hide: any;
  constructor(public userService: UserService,private snackBar: MatSnackBar) {
    this.registerForm = {
      nombre: '',
      email: '',
      password: '',
      rol: '',
      img: '',
      teams: []
    };
  }

  ngOnInit(): void {
    this.hide = true;
    this.userService.getAllTeams().subscribe(
      (eq) => {
        this.equipos=eq;
      },
      error=>console.log(error)
    );
  }
  saveUser(){
    this.userService.saveUser(this.registerForm).subscribe(() => {
      console.log("rol.: " + this.registerForm.rol);
      this.snackBar.open('Usuario creado correctamente', 'OK', {duration: 4000});
    }, error => {
      console.log(error);
      this.snackBar.open('Algo ha fallado', 'OK', {duration: 4000});
    });
  }
}
