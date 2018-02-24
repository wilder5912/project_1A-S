import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor } from '@angular/common/http';

@Injectable()
export class SecurityInterceptor implements HttpInterceptor {
  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authorization =  'Basic ' + btoa("ajay:test");//sessionStorage.getItem('token');//'Basic ' + btoa("ajay:test");
    const correctReq = req.clone({ headers: req.headers.set('Authorization', authorization)});
    return next.handle(correctReq);
  }
}

