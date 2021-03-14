import {Injectable} from "@angular/core";
import {LoginService} from "./log-in/login.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";

export interface Users {
  id?: number;
  nombre:string;
  password:string;
  email:string;
  rol: string;
  equipo_id: number;
}

const URL='/home/';

@Injectable()
export class UserService {

  constructor(private loginService: LoginService, private http:HttpClient) {}

  getUserById(id:number|string):Observable<Users>{
    console.log("entra en user unica");
    console.log(id);

    return this.http.get<any>(URL,{withCredentials:true})
      .pipe(catchError((error)=>this.handleError(error)));
  }

  private handleError(error:any){
    console.error(error);
    return Observable.throw('Server error ('+error.status+ '): '+error);
  }
}
