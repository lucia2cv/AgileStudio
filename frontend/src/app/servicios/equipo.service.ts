import {Users, UserService} from "../user.service";
import {Injectable} from "@angular/core";
import {LoginService} from "../log-in/login.service";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {DomSanitizer} from "@angular/platform-browser";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {User} from "../user";
import {Taller} from "./taller.service";
import {WorkshopForm} from "../crear-taller/crear-taller.component";
import {TeamForm} from "../crear-equipo/crear-equipo.component";

export interface Equipo {
  id?:number;
  nombreEquipo:string;
  miembros: Users[] ;
  logoImg: string;
  talleres: Taller[];
}

const URL='http://localhost:8080/equipos/'
@Injectable()
export class EquipoService{
  /*Constructor con lo que vamos a necesitar*/
  constructor(private loginService:LoginService,private userService:UserService,private http:HttpClient, private _sanitizer:DomSanitizer){}

  getAllEquipos(user: Users):Observable<Equipo[]>{
    let params = new HttpParams();
    params = params.set('id', String(user.id));
    return this.http.get<Equipo[]>(URL, {params})
      .pipe(catchError((error)=>this.handleError(error)));
  }
  private handleError(error:any){
    console.error(error);
    return Observable.throw('Server error ('+error.status+' ): '+error);
  }

  getTeamById(id: number):Observable<Equipo>{
    return this.http.get<Equipo>(URL+'un-equipo/' + id );
  }

  saveTeam(teamForm: TeamForm) {
    const body = JSON.stringify(teamForm);
    console.log('body: ', body)
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    return this.http.post(URL + 'crear/equipo',body, {headers})
  }
}
