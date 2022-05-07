import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DialogData} from "../log-in/log-in.component";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {RegistrationService} from "../registrarion/registration.service";
import {User} from "../user";
import {CrossOrigin} from "@angular-devkit/build-angular";

@Component({
  selector: 'app-doalogo-registro',
  templateUrl: './dialogoRegistro.component.html',
  styleUrls: ['./dialogoRegistro.component.css']
})

export class DialogoRegistroComponent implements OnInit {


  email = new FormControl('', [ Validators.required, Validators.email]);
  hide = true;
  password = new FormControl('',[Validators.required, Validators.minLength(8)]);
  nombre = new FormControl();
  equipo = new FormControl();
  rol = new FormControl();
  teamRole = String;
  roles: string[] = ['desarrollador', 'scrum master', 'product owner'];
  myForm: FormGroup = new FormGroup({
    nombre: this.nombre,
    email:this.email,
    password: this.password,
    equipo: this.equipo,
    rol: this.rol
  });

  user: any;

  usuario:User;
  constructor( public dialogoRef: MatDialogRef<DialogoRegistroComponent>,
               @Inject(MAT_DIALOG_DATA) public data:DialogData, private service: RegistrationService) {

  }


  getErrorMessage() {
    if(this.email.hasError('required')){
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }

  ngOnInit(): void {
  }

  saveUser(){
    if (this.myForm.valid){
      this.usuario = new User(this.myForm.value.nombre, this.myForm.value.password, this.myForm.value.email, this.myForm.value.rol, this.myForm.value.equipo, 'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/271deea8-e28c-41a3-aaf5-2913f5f48be6/de7834s-6515bd40-8b2c-4dc6-a843-5ac1a95a8b55.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzI3MWRlZWE4LWUyOGMtNDFhMy1hYWY1LTI5MTNmNWY0OGJlNlwvZGU3ODM0cy02NTE1YmQ0MC04YjJjLTRkYzYtYTg0My01YWMxYTk1YThiNTUuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.BopkDn1ptIwbmcKHdAOlYHyAOOACXW0Zfgbs0-6BY-E');
      this.usuario.imprimir();
      this.service.saveUser(this.usuario).subscribe(
        _=>{},(error: Error)=>console.error('ERROR COMPONENTE DIALOGO '));
      console.log("form valido", this.myForm.value);
    }
  }
}
