import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';


import { HttpClient,HttpHeaders , HttpHandler, HttpRequest ,HttpEvent,HttpInterceptor ,  HTTP_INTERCEPTORS } from "@angular/common/http";
import { Headers, RequestOptions } from '@angular/http';
import {Http} from '@angular/http';

import { User } from "../../model/usuario/User";
import { DataService } from '../../service/dataService/data.service';
import { Router } from '@angular/router';
@Injectable()
export class LoginService{

     constructor( private http: HttpClient, public dataService: DataService , public router: Router  ) { }

    public login(user: User): Observable<User> {
      return this.http.post<User>(this.dataService.getUrl("/user/loginUser"), JSON.stringify(user));
    }
  public isLogin(user: User): Observable<User>  {
    return this.http.post<User>(this.dataService.getUrl("/user/isLoginUser"), JSON.stringify(user) );

  }
  public logout(): Observable<boolean>  {
    localStorage.removeItem('currentUser');
    sessionStorage.removeItem('token');
    return this.http.get<boolean>(this.dataService.getUrl("/user/logoutUser") );
  }

  redirectUser(userA: User, urlPageN: string ) {
    this.router.navigate([urlPageN]);
  }



  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }
  private handleErrorObservable (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

  public intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const authorizationReq = this.setAuthHeader(req);
    const handledRequest = next.handle(authorizationReq);
    return handledRequest;
  }
  private setAuthHeader(req: HttpRequest<any>): HttpRequest<any> {
    const authorization = 'Basic ' + btoa("ajay:test");
    const headers = req.headers.set("Authorization", authorization);
    const authorizationReq = req.clone({ headers });
    return authorizationReq;
  }
}


