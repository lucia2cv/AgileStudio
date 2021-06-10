import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import {LoginService} from "../log-in/login.service";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  user:User
  constructor(public loginService:LoginService) { }


  ngOnInit(): void {
  }

  save() {

  }
}
