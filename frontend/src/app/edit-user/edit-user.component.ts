import { Component, OnInit } from '@angular/core';
import {LoginService} from "../log-in/login.service";
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Users, UserService} from "../user.service";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent{

  form: FormGroup = new FormGroup({
    nombre: new FormControl('')/*,
    email: new FormControl('')*/
  });
  user: Users;
  modUser: boolean;
  constructor(public loginService: LoginService, activatedRoute: ActivatedRoute, public service: UserService, private router: Router) {
    const id = activatedRoute.snapshot.params['id'];
    if(id) {
      let prueba = service.getUser(id);
      console.log(prueba)
      this.modUser=false;
    }else {
      this.user = {email: "", equipo_id: 0, password: "", rol: "", nombre: '', img: ''}
      this.modUser = true;
    }
  }

  save(){
    console.log(this.loginService.user)
    this.service.saveUser(this.loginService.user).subscribe(
      _ =>{},(error:Error)=>console.error('error creating new categories: '+this.loginService.user + ' ' +error));
    window.history.back();
  }
}
