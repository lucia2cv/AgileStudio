import {Equipo} from "./equipo.service";
import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {Users} from "../user.service";

export interface Taller {
  img: string;
  id?:number;
  nombreTaller: string;
  categoria: string ;
  equipos: Equipo [];
}

const URL='http://localhost:8080/talleres/'
@Injectable()
export class TallerService{
  /*Constructor con lo que vamos a necesitar*/
  constructor(private http:HttpClient){}

  getAllWorkshops(user: Users ):Observable<Taller[]>{
    console.log("pidiendo todos los datos");
    let params = new HttpParams();
    params = params.set('id', String(user.id));
    return this.http.get<Taller[]>(URL, {params} )
      .pipe(catchError((error)=>this.handleError(error)));
  }

  private handleError(error:any){
    console.error(error);
    return Observable.throw('Server error ('+error.status+' ): '+error);
  }
}
