import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../user";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor( private http: HttpClient) { }

  saveUser(user: User):Observable<User>{
    const body=JSON.stringify(user);
    const headers=new HttpHeaders({
      'Content-Type': 'application/json',
    });
    console.log('usuario registrarion service: '+ user);

      return this.http
        .post<User>('http://localhost:8080/',body,{headers})
        .pipe(catchError((error)=>this.handleError(error)));
  }



  private handleError(error:any){
    console.error(error);
    return throwError('Server error ('+error.status+ '): '+error);
  }
}
