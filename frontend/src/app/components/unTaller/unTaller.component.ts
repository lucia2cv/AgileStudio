import { Component, OnInit } from '@angular/core';
import {Taller, TallerService} from "../../servicios/taller.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-un-taller',
  templateUrl: './unTaller.component.html',
  styleUrls: ['./unTaller.component.css']
})
export class UnTallerComponent implements OnInit {

  taller: Taller
  id: number;

  constructor(activatedRoute: ActivatedRoute, public tallerService: TallerService) {
    this.id = activatedRoute.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.tallerService.getWorkshopsById(this.id).subscribe(
      (wk) => {
        this.taller = wk;
        console.log(this.taller.nombreTaller);

      },
      (error) =>alert('Invalid data taller component ' + error)
    );
  }

}
