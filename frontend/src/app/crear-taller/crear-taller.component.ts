import { Component, OnInit } from '@angular/core';
import {Equipo} from "../servicios/equipo.service";
import {Taller, TallerService} from "../servicios/taller.service";
import {LoginService} from "../log-in/login.service";
import {MatSnackBar, MatSnackBarModule} from "@angular/material/snack-bar";
import {Router} from "@angular/router";

export interface WorkshopForm{
  id?: number;
  nombre: string;
  categoria: string;
  img: string;
  teams: number[];
  descripcion: string;
  videconferencia: string;
}
@Component({
  selector: 'app-crear-taller',
  templateUrl: './crear-taller.component.html',
  styleUrls: ['./crear-taller.component.css']
})
export class CrearTallerComponent implements OnInit {
  equipos: Equipo[];
  equiposUltimate: Equipo[];
  workshopForm: WorkshopForm;
  showSpinner: Boolean;
  constructor( public tallerService: TallerService, public loginService: LoginService, private snackBar: MatSnackBar,private router:Router) {

    this.workshopForm = {
      nombre: '',
      img: '',
      categoria: '',
      descripcion: '',
      videconferencia: '',
      teams: []
    };
  }


  ngOnInit(): void {
    if (this.loginService.user.rol !== 'scrum master') {
      this.router.navigate(['talleres']);
    } else {
      this.tallerService.getAllEquipos(this.loginService.user).subscribe(
        (eq) => {
          this.equipos=eq;
          this.equiposUltimate=eq;
          this.equiposUltimate.forEach(element => {
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

  saveWorkshop(){
    this.tallerService.saveWorkshop(this.workshopForm).subscribe(() => {
      this.snackBar.open('Taller guardado correctamente', 'OK', {duration: 4000});
    }, error => {
      console.log(error);
      this.snackBar.open('Algo ha fallado', 'OK', {duration: 4000});
    });
  }
}
