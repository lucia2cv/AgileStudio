import {Users, UserService} from "../user.service";
import {Injectable} from "@angular/core";
import {LoginService} from "../log-in/login.service";
import {HttpClient, HttpParams} from "@angular/common/http";
import {DomSanitizer} from "@angular/platform-browser";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {User} from "../user";

export interface Equipo {
  id?:number;
  nombreEquipo:string;
  miembros: Users[] ;
}

const URL='http://localhost:8080/equipos/'
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

  getAllEquipos(user: Users):Observable<Equipo[]>{
    console.log("pidiendo todos los datos");
    let params = new HttpParams();
    params = params.set('id', String(user.id));
    return this.http.get<Equipo[]>(URL, {params})
      .pipe(catchError((error)=>this.handleError(error)));
  }
  private handleError(error:any){
    console.error(error);
    return Observable.throw('Server error ('+error.status+' ): '+error);
  }
}
