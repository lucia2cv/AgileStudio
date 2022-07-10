import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Equipo, EquipoService} from "../../servicios/equipo.service";
import {Taller} from "../../servicios/taller.service";

@Component({
  selector: 'app-un-equipo',
  templateUrl: './unEquipo.component.html',
  styleUrls: ['./unEquipo.component.css']
})
export class UnEquipoComponent implements OnInit {

  equipo: Equipo;
  id: number;
  constructor(activatedRoute: ActivatedRoute, public equipoService: EquipoService,private router:Router) {
    this.id = activatedRoute.snapshot.params['id'];
    this.equipoService.getTeamById(this.id).subscribe(
      (eq) => {
        this.equipo = eq;
        console.log(this.equipo);
      },  error => console.error(error));
  }

  ngOnInit(): void {

  }

}
