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

  roles: string[] = ['desarrollador', 'scrum master', 'product owner'];

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
    this.service.editUser(this.loginService.user).subscribe(
      _ => {
        window.history.back();
      },
      (error:Error)=> console.error('error edit user info: '+this.loginService.user + ' ' +error));

  }
}
