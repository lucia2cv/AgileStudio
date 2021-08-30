import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "../../log-in/login.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {



  constructor(public router: Router, public loginService: LoginService ) { }

  logout(){
    console.log("logout navbar");
    this.loginService.logout().subscribe( (response) =>{
        this.router.navigate(['/']);
      },
      (error) => console.log('Error when trying to logout' + error),
    );
  }
  ngOnInit(): void {
  }

}
