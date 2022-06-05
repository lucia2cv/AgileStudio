import {Injectable} from "@angular/core";
import {LoginService} from "./log-in/login.service";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";
import {User} from "./user";
import {Equipo} from "./servicios/equipo.service";
import {WorkshopForm} from "./crear-taller/crear-taller.component";
import {RegisterForm} from "./components/crear-usuario/crear-usuario.component";

export interface Users {
  id?: number;
  nombre:string;
  password:string;
  email:string;
  rol: string;
  equipo_id: number;
  img: string;
}

const URL='http://localhost:8080/home/editarPerfil/';
const URLCrear='http://localhost:8080/equipos/crear/equipo';
const urlRegistro='http://localhost:8080/home/registro';
@Injectable()
export class UserService {

  constructor(private loginService: LoginService, private http:HttpClient) {}

  getUser(id:number|string):Observable<Users>{
    console.log('getUSer');
    return this.http.get<any>(URL+id,{withCredentials:true})
      .pipe(catchError((error)=>this.handleError(error)));
  }
  oldSaveUser(user:Users):Observable<Users>{
    const body=JSON.stringify(user);
    const headers=new HttpHeaders({
      'Content-Type': 'application/json',
    });
    console.log(user);

    if(!user.id){
      return this.http
        .post<Users>(URL,body,{headers})
        .pipe(catchError((error)=>this.handleError(error)));
    }else{
      console.log(user.nombre);
      return this.http
        .put<Users>(URL+user.id,body,{headers})
        .pipe(catchError((error)=>this.handleError(error)));
    }
  }
  private handleError(error:any){

    return throwError('Server error ('+error.status+ '): '+error);
  }
  getAllUsers():Observable<Users[]>{
    console.log('getAllUSers');
    return this.http.get<any>(URLCrear)
      .pipe(catchError((error)=>this.handleError(error)));
  }
  getAllTeams():Observable<Equipo[]>{
    console.log("pidiendo todos los datos");
    return this.http.get<any>(urlRegistro)
      .pipe(catchError((error)=>this.handleError(error)));
  }

  saveUser(registerForm: RegisterForm) {
    const body = JSON.stringify(registerForm);
    console.log('body: ', body)
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    return this.http.post(urlRegistro ,body, {headers})
  }
}
