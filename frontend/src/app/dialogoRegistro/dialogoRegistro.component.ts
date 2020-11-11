import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DialogData} from "../log-in/log-in.component";

@Component({
  selector: 'app-doalogo-registro',
  templateUrl: './dialogoRegistro.component.html',
  styleUrls: ['./dialogoRegistro.component.css']
})
export class DialogoRegistroComponent implements OnInit {

  dialogoAbierto =true;
  constructor( public dialogoRef: MatDialogRef<DialogoRegistroComponent>,
               @Inject(MAT_DIALOG_DATA) public data:DialogData) { }

  onNoClick():void{
    this.dialogoAbierto = false;
    this.dialogoRef.close();
  }


  ngOnInit(): void {
  }

}
