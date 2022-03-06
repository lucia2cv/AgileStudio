import {Users, UserService} from "../user.service";
import {Injectable} from "@angular/core";
import {LoginService} from "../log-in/login.service";
import {HttpClient} from "@angular/common/http";
import {DomSanitizer} from "@angular/platform-browser";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";

export interface Equipo {
  id?:number;
  nombreEquipo:string;
  miembros: Users[] | number[];
}

const URL='/home';
@Injectable()
export class EquipoService{
  /*Constructor con lo que vamos a necesitar*/
  constructor(private loginService:LoginService,private userService:UserService,private http:HttpClient, private _sanitizer:DomSanitizer){}



  /*getEvents():Observable<Equipo[]>{
    console.log("Entrando en getEvents");
    return this.http.get<any>(URL,{withCredentials:true})
      .pipe(
        map(result=>result.content),
        catchError((error)=>this.handleError(error)));
  }*/

 /* getEvent(id:number|string):Observable<Event>{
    return this.http.get<Event>(URL+id,{withCredentials:true})
      .pipe(catchError((error)=>this.handleError(error)));
  }*/

  getAllEquipos():Observable<Equipo[]>{
    console.log("pidiendo todos los datos");
    return this.http.get<Equipo[]>(URL,{withCredentials:true})
      .pipe(catchError((error)=>this.handleError(error)));
  }

  private handleError(error:any){
    console.error(error);
    return Observable.throw('Server error ('+error.status+' ): '+error);
  }
}
