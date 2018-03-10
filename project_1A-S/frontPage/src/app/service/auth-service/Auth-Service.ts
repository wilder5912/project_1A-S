import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../model/usuario/User';


@Injectable()
export class AuthService {

     constructor(private http: HttpClient) { }

public login(user: User): Observable<boolean>  {
  return this.http.post<boolean>('http://localhost:8080/user/getUser', JSON.stringify(user));
}
}


