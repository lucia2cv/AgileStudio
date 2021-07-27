import { Component, OnInit } from '@angular/core';
import {Users, UserService} from "../user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../log-in/login.service";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit {

  users: Users;


  constructor(private routes:Router, activatedRoute:ActivatedRoute, public userService: UserService, public loginService: LoginService) {
    /*const id = activatedRoute.
    console.log("este es el id en homecompo " +id);*/
    //console.log("Ver " + JSON.stringify(this.userService));
    //userService.getUserById(this.loginService.user.id).subscribe((users) =>(this.users = users),(error) => console.error(error));

  }
  navigateEdit(): void {
    this.routes.navigateByUrl('/editarPerfil');
  }
  ngOnInit(): void {
  }

}
