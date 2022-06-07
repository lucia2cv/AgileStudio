import { Component, OnInit } from '@angular/core';
import {Users, UserService} from "../user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../log-in/login.service";
import {Equipo, EquipoService} from "../servicios/equipo.service";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit {

  users: Users;
  equipos: Equipo [];

  constructor(private router:Router, activatedRoute:ActivatedRoute, public userService: UserService, public loginService: LoginService, public equipoService: EquipoService) {

    let equipos = this.loginService.user.equipos;
    this.equipos = equipos;
  }
  navigateEdit(): void {
    let user = this.loginService.user;
    this.router.navigate(['home/editarPerfil',user.id]);

  }
  ngOnInit(): void {
    this.equipoService.getAllEquipos(this.loginService.user).subscribe(
      (eq) => {
        this.equipos=eq;
        if (this.equipos.length > 3) {
          this.equipos = this.equipos.slice(0,3);
        }
        console.log(this.equipos);
      },
      error=>console.log(error)
    );
  }
  goToEquipos(): void {
    this.router.navigate(['equipos']);
  }
}
