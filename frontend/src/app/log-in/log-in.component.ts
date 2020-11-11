import {Component, Input, OnInit, Output} from '@angular/core';
import {FormControl, Validators, FormGroup} from "@angular/forms";
import {EventEmitter} from "events";
import {MatDialog} from "@angular/material/dialog";
import {DialogoRegistroComponent} from "../dialogoRegistro/dialogoRegistro.component";


export interface DialogData {
  email:string
  contraseña: string;
}
@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  email = new FormControl('', [ Validators.required, Validators.email]);
  hide = true;
  dialogoAbierto = false;
/*
  form: FormGroup = new FormGroup({
    correo: new FormControl(''),
    contraseña: new FormControl(''),
  });
  submit() {
    if (this.form.valid) {
      this.submitEM.emit(this.form.value);
    }
  }
  @Input() error: string | null;

  @Output() submitEM = new EventEmitter();*/
  getErrorMessage() {
    if(this.email.hasError('required')){
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }


  constructor( public dialog: MatDialog) { }


  openDialog(): void{
    this.dialogoAbierto = true;
    console.log('Dialogo abierto');
    const dialogRef = this.dialog.open(DialogoRegistroComponent,{
      width: '50%', height:'50%', data: {email: this.email}
    });
    dialogRef.afterClosed().subscribe( result =>{
      console.log('Dialogo cerrado');
      this.dialogoAbierto=false;
      this.email = result;
    });
  }

  ngOnInit(): void {
  }

}
