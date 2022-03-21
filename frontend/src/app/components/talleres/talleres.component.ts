import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Taller, TallerService} from "../../servicios/taller.service";
import {LoginService} from "../../log-in/login.service";

@Component({
  selector: 'app-talleres',
  templateUrl: './talleres.component.html',
  styleUrls: ['./talleres.component.css']
})
export class TalleresComponent implements OnInit {

  talleres: Taller[];

  constructor( public loginService: LoginService,public tallerService: TallerService) {}

  ngOnInit(): void {
    this.tallerService.getAllWorkshops(this.loginService.user).subscribe(
      (t) => {
        this.talleres = t;
      },
      (error) =>alert('Invalid data login component ' + error),
    );
  }
}
