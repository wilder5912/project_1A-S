import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest , HttpEvent } from '@angular/common/http';
import { User } from '../../model/usuario/User';
import { DataService } from '../../service/dataService/data.service';

@Injectable()
export class UserService {
    public formdata: FormData = new FormData();
    constructor(private http: HttpClient, public dataService: DataService) { }
    public register( user: User): Observable<User> {
      return this.http.post<User>(this.dataService.getUrl('/user/addUser'), JSON.stringify(user),
  { headers: this.dataService.headerSend
      }
      );
    }

    public editImage(file: File): Observable<HttpEvent<{}>> {
      this.formdata = new FormData();
      this.formdata.append('file', file);
      this.formdata.append('userData', JSON.stringify(this.dataService.AUTH_CONFIG));
      const req = new HttpRequest('POST', this.dataService.getUrl('/user/editImageUserOne'), this.formdata, {
        reportProgress: true,
        responseType: 'text'
      });
      return this.http.request(req);
    }
  public getUserId(userId: number): Observable<User>  {
    return this.http.post<User>(this.dataService.getUrl('/user/getUserId'), userId,
      { headers: this.dataService.headerSend
      }
    );
  }
  public editUserRol(user: User): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl('/user/editUserRol'), JSON.stringify(user),
      { headers: this.dataService.headerSend
      }
    );
  }
}


