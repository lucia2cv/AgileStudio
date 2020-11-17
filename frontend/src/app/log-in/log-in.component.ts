import {Component, Input, OnInit, Output} from '@angular/core';
import {FormControl, Validators, FormGroup} from "@angular/forms";
import {EventEmitter} from "events";
import {MatDialog} from "@angular/material/dialog";
import {DialogoRegistroComponent} from "../dialogoRegistro/dialogoRegistro.component";
import {Router} from "@angular/router";
import {LoginService} from "./login.service";


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

  @Output() submitEM = new EventEmitter();
  getErrorMessage() {
    if(this.email.hasError('required')){
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }


  constructor( public dialog: MatDialog, public router: Router, public loginService: LoginService) { }

  login(event:any, email:string, pass:string){
    event.preventDefault();
    this.loginService.login(email, pass).subscribe((us)=> {
      console.log(us);
    },
      (error) =>alert('Invalid data'),
      );
  }

  logout(){
    this.loginService.logout().subscribe( (response) =>{
      this.router.navigate(['/']);
    },
      (error) => console.log('Error whe trying to logout' + error),
      );
  }

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
