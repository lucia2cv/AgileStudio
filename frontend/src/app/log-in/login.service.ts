import { Injectable } from '@angular/core';
import {HttpHeaders, HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";


export interface Users {
  id?:number;
  nombre:string;
  rol:string;
  authdata: string;
  email:string;
  //equipo_id: number[];

}
@Injectable()
export class LoginService {

  isLogged = false;
  user: Users;
  auth: string;

  constructor(private http: HttpClient) {
    let user = JSON.parse(localStorage.getItem('currentUser'));
    if (user) {
      console.log('Logged user');
      this.setCurrentUser(user);
    }
  }



  login(user: string, password:string){

    let auth = window.btoa(user + ':' + password); //encripta
    console.log( "nombre: "+ user +" " + "password: " + password + " servicio login");

    const headers = new HttpHeaders({
      Authorization: 'Basic ' + auth, 'X-Requested-With': 'XMLHttpRequest',
    });


    console.log("buscando ruta");

    return this.http.get<Users>('http://localhost:8080/', { headers })
      .pipe(map(user => {

        if (user) {
          this.setCurrentUser(user);
          user.authdata = auth;
          localStorage.setItem('currentUser', JSON.stringify(user));

        }
        return user;
      }));
    console.log("hola estoy aqui")
  }

  logout(){
    return this.http.get(URL + '/').pipe(
      map(response => {
        this.removeCurrentUser();
        return response;
      }),
    );
  }
  private setCurrentUser(user: Users) {
    this.isLogged = true;
    this.user = user;
  }

  removeCurrentUser(){
    localStorage.removeItem('currentUser');
    this.isLogged = false;
  }
}
