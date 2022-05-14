import {Equipo} from "./equipo.service";
import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Users} from "../user.service";
import {Observable} from "rxjs";

export interface Taller {
  img: string;
  id?:number;
  nombreTaller: string;
  categoria: string ;
  equipos: Equipo [];
  descripcion: string;
  //documentos: String [4];
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
  getAllWorkshopsByCategory(id: number, categoria: string ):Observable<Taller[]>{
    let params = new HttpParams();
    params = params.set('id', String(id));
    return this.http.get<Taller[]>(URL+categoria, {params})
      .pipe(catchError((error)=>this.handleError(error)));
  }
  getWorkshopsById(id: number):Observable<Taller>{
    return this.http.get<Taller>(URL+'un-taller/' + id )
  }
  private handleError(error:any){
    console.error(error);
    return Observable.throw('Server error ('+error.status+' ): '+error);
  }
}
