import {Component, Input, OnInit, Output} from '@angular/core';
import {FormControl, Validators, FormGroup} from "@angular/forms";
import {EventEmitter} from "events";

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  email = new FormControl('', [ Validators.required, Validators.email]);
  hide = true;
/*
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

  @Output() submitEM = new EventEmitter();*/
  getErrorMessage() {
    if(this.email.hasError('required')){
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }


  constructor() { }

  ngOnInit(): void {
  }

}
