import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Users, UserService} from "../../user.service";
import {LoginService} from "../../log-in/login.service";
import {Equipo, EquipoService} from "../../servicios/equipo.service";
import {User} from "../../user";
import {Observable} from "rxjs";
import {parse} from "jasmine-spec-reporter/built/configuration-parser";
import {element} from "protractor";

@Component({
  selector: 'app-equipos',
  templateUrl: './equipos.component.html',
  styleUrls: ['./equipos.component.css']
})
export class EquiposComponent implements OnInit {

  equipos: Equipo[];
  equiposUltimate: Equipo[];
  miembros: Users[] ;
  constructor(private router:Router, activatedRoute:ActivatedRoute, public userService: UserService, public loginService: LoginService, public equipoService: EquipoService) {

    console.log(this.equipos)

  }

  ngOnInit(): void {
      this.equipoService.getAllEquipos(this.loginService.user).subscribe(
        (eq) => {
          console.log(eq);
          this.equipos=eq;
          this.equiposUltimate=eq;
          this.equiposUltimate.forEach(element => {
            console.log(element);
            element.miembros.forEach(miembro => {
              if (miembro.id == undefined) {
                element.miembros = element.miembros.filter(obj => {return obj !== miembro})
                this.equipos.forEach(el => {
                  el.miembros.forEach(m => {
                    // @ts-ignore
                    if (m.id == miembro) {
                      if(!element.miembros.includes(m)) {
                        element.miembros.push(m)
                      }
                    }
                  })
                })
              }
            })
          })
        },
      error=>console.log(error)
    );

  }

}
