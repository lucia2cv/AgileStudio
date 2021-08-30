import { Component, OnInit } from '@angular/core';
import {LoginService} from "../log-in/login.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  form: FormGroup = new FormGroup({
    nombre: new FormControl(''),
    email: new FormControl('')
  });

  constructor( public loginService: LoginService) { }

  ngOnInit(): void {
  }

}
