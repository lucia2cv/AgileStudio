import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DialogData} from "../log-in/log-in.component";
import {FormControl, FormGroup, Validators} from "@angular/forms";

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

  user:any
  constructor( public dialogoRef: MatDialogRef<DialogoRegistroComponent>,
               @Inject(MAT_DIALOG_DATA) public data:DialogData) {

  }


  getErrorMessage() {
    if(this.email.hasError('required')){
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }

  ngOnInit(): void {
  }

  registerUser(){
    if (this.myForm.valid){
      console.log("form valido", this.myForm.value);
    }
  }
}
