import {Component, OnInit} from '@angular/core';
import {Taller, TallerService} from "../../servicios/taller.service";
import {LoginService} from "../../log-in/login.service";

@Component({
  selector: 'app-talleres',
  templateUrl: './talleres.component.html',
  styleUrls: ['./talleres.component.css']
})
export class TalleresComponent implements OnInit {

  talleres: Taller[];
  categorias: String[];

  constructor( public loginService: LoginService,public tallerService: TallerService) {}

  ngOnInit(): void {
    this.tallerService.getAllWorkshops(this.loginService.user).subscribe(
      (t) => {
        this.talleres = t;
        if (this.talleres.length > 0) {
          this.categorias = [];
          let cat;
          this.talleres.forEach(tall => {
            cat = tall.categoria;
            if(!this.categorias.includes(cat)){
              this.categorias.push(cat);
            }
          })
        } else {
          this.categorias = [];
        }
        if (this.talleres.length > 3) {
          this.talleres = this.talleres.slice(0,3);
        }
      },
      (error) =>alert('Invalid data login component ' + error),

    );
  }
}
