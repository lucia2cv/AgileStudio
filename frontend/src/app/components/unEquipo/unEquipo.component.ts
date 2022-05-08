import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Equipo, EquipoService} from "../../servicios/equipo.service";

@Component({
  selector: 'app-un-equipo',
  templateUrl: './unEquipo.component.html',
  styleUrls: ['./unEquipo.component.css']
})
export class UnEquipoComponent implements OnInit {

  equipo: Equipo
  id: number;
  constructor(activatedRoute: ActivatedRoute, public equipoService: EquipoService) {
    this.id = activatedRoute.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.equipoService.getTeamById(this.id).subscribe(
      (eq) => {
        this.equipo = eq;
        console.log(this.equipo);

      },
      (error) =>alert('Invalid data equipo component ' + error)
    );
  }

}
