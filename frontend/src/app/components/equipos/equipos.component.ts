import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Users, UserService} from "../../user.service";
import {LoginService} from "../../log-in/login.service";
import {Equipo, EquipoService} from "../../servicios/equipo.service";
import {User} from "../../user";

@Component({
  selector: 'app-equipos',
  templateUrl: './equipos.component.html',
  styleUrls: ['./equipos.component.css']
})
export class EquiposComponent implements OnInit {

  equipos: Equipo[];
  miembros: Users[] ;
  constructor(private router:Router, activatedRoute:ActivatedRoute, public userService: UserService, public loginService: LoginService, public equipoService: EquipoService) {

    console.log(this.equipos)

  }

  ngOnInit(): void {
      this.equipoService.getAllEquipos(this.loginService.user).subscribe(
        (eq) => {
          console.log(eq);
          this.equipos=eq
        },
      error=>console.log(error)
    );
  }

}
