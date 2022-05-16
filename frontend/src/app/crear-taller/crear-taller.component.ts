import { Component, OnInit } from '@angular/core';
import {Equipo} from "../servicios/equipo.service";
import {Taller, TallerService} from "../servicios/taller.service";
import {LoginService} from "../log-in/login.service";
import {MatSnackBar, MatSnackBarModule} from "@angular/material/snack-bar";

export interface WorkshopForm{
  id?: number;
  nombre: string;
  categoria: string;
  img: string;
  teams: number[];
  descripcion: string;
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
  constructor( public tallerService: TallerService, public loginService: LoginService, private snackBar: MatSnackBar) {

    this.showSpinner = false;
    this.workshopForm = {
      nombre: '',
      img: '',
      categoria: '',
      descripcion: '',
      teams: []
    };
  }


  ngOnInit(): void {
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

  saveWorkshop(){
    this.showSpinner = true;
    setTimeout(() => {
      this.showSpinner = false;
    }, 3000);
    this.tallerService.saveWorkshop(this.workshopForm).subscribe(id => {
      this.snackBar.open('Taller guardado correctamente', 'OK', {duration: 3000});
    }, error => {
      console.log(error);
      this.snackBar.open('Algo ha fallado', 'OK', {duration: 3000});
    });
  }
}
