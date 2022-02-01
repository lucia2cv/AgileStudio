import {Injectable} from "@angular/core";
import {LoginService} from "./log-in/login.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";
import {User} from "./user";

export interface Users {
  id?: number;
  nombre:string;
  password:string;
  email:string;
  rol: string;
  equipo_id: number;
}

const URL='http://localhost:8080/home/editarPerfil/';

@Injectable()
export class UserService {

  constructor(private loginService: LoginService, private http:HttpClient) {}
  /*
  getUserById(id:number|string):Observable<Users>{
    console.log("entrando en get user By Id " + id);
    console.log("entra en user unica");
    console.log(id);

    return this.http.get<any>(URL,{withCredentials:true})
      .pipe(map(result => result.content),catchError((error)=>this.handleError(error)));
  }*/
  getUser(id:number|string):Observable<Users>{
    console.log('getUSer');
    return this.http.get<any>(URL+id,{withCredentials:true})
      .pipe(catchError((error)=>this.handleError(error)));
  }
  saveUser(user:Users):Observable<Users>{
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
}
