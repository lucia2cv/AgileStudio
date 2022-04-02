import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {LoginService} from "../../log-in/login.service";
import {Taller, TallerService} from "../../servicios/taller.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categoria: any;
  allTalleres: Taller[];
  filterTalleres: string[];

  constructor(activatedRoute: ActivatedRoute, public loginService: LoginService,public tallerService: TallerService) {
     this.categoria = activatedRoute.snapshot.params['categoria'];
  }

  ngOnInit(): void {
    this.tallerService.getAllWorkshopsByCategory(this.loginService.user.id, this.categoria).subscribe(
      (wk) => {
          this.filterTalleres = wk;
          },
      (error) =>alert('Invalid data login component ' + error)
    );
  }

}
