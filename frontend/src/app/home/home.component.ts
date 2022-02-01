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


  constructor(private router:Router, activatedRoute:ActivatedRoute, public userService: UserService, public loginService: LoginService) {}
  navigateEdit(): void {
    let user = this.loginService.user;
    this.router.navigate(['home/editarPerfil',user.id]);

  }
  ngOnInit(): void {
  }

}
