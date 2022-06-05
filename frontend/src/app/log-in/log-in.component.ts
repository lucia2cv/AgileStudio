import {Component, Input, OnInit, Output} from '@angular/core';
import {FormControl, Validators, FormGroup} from "@angular/forms";
import {EventEmitter} from "events";
import {MatDialog} from "@angular/material/dialog";
import {DialogoRegistroComponent} from "../dialogoRegistro/dialogoRegistro.component";
import {Router} from "@angular/router";
import {LoginService} from "./login.service";
import {UserService} from "../user.service";
import {User} from "../user";


export interface DialogData {
  nombre:string
  contraseña: string;
}
@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  hide = true;
  dialogoAbierto = false;
  nombre:string;

  form: FormGroup = new FormGroup({
    nombre: new FormControl(''),
    password: new FormControl(''),
  });
  submit() {
    if (this.form.valid) {
      this.submitEM.emit(this.form.value);
    }
  }
  @Input() error: string | null;

  @Output() submitEM = new EventEmitter();


  constructor( public dialog: MatDialog, public router: Router, public loginService: LoginService, public userService: UserService) { }

  login(event:any, nombre:string, password:string){
    event.preventDefault();
    this.loginService.login(nombre, password).subscribe((us) => {
      this.router.navigate(['/home']);
      return us;
    },
      (error) =>alert('Invalid data login component ' + error),
      );
  }

  logout(){
    this.loginService.logout().subscribe( (response) =>{
      this.router.navigate(['/']);
    },
      (error) => console.log('Error when trying to logout' + error),
      );
  }

  ngOnInit(): void {
  }
  goToRegistro(): void {
    this.router.navigate(['registro']);
  }
}
