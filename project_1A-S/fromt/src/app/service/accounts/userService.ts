import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders , HttpHandler, HttpRequest ,HttpEvent,HttpInterceptor ,  HTTP_INTERCEPTORS } from "@angular/common/http";
import { User } from "../../model/usuario/User";
import { DataService } from '../../service/dataService/data.service';

@Injectable()
export class UserService {

     constructor(private http: HttpClient, public dataService:DataService) { }
    public register(User: User): Observable<User>  {
      return this.http.post<User>(this.dataService.getUrl("/user/addUser"), JSON.stringify(User));
    }

    public editImage(file: File): Observable<HttpEvent<{}>> {

      let formdata: FormData = new FormData();
      formdata.append('file', file);
      formdata.append('userData', JSON.stringify(this.dataService.AUTH_CONFIG));

      const req = new HttpRequest('POST', this.dataService.getUrl("/user/editImageUserOne"), formdata, {
        reportProgress: true,
        responseType: 'text'
      });
      return this.http.request(req);
    }





}


