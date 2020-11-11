import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DialogData} from "../log-in/log-in.component";
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-doalogo-registro',
  templateUrl: './dialogoRegistro.component.html',
  styleUrls: ['./dialogoRegistro.component.css']
})
export class DialogoRegistroComponent implements OnInit {
  email = new FormControl('', [ Validators.required, Validators.email]);
  hide = true;
  dialogoAbierto =true;
  constructor( public dialogoRef: MatDialogRef<DialogoRegistroComponent>,
               @Inject(MAT_DIALOG_DATA) public data:DialogData) {

  }

  getErrorMessage() {
    if(this.email.hasError('required')){
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  onNoClick():void{
    this.dialogoAbierto = false;
    this.dialogoRef.close();
  }


  ngOnInit(): void {
  }

}
