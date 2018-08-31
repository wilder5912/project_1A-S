import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest , HttpEvent } from '@angular/common/http';
import { RoleUser } from '../../model/usuario/RoleUser';
import { DataService } from '../../service/dataService/data.service';

@Injectable()
export class RoleUserService {
  public formdata: FormData = new FormData();
  constructor(private http: HttpClient, public dataService: DataService) { }

  public addRoleUser(roleUser: RoleUser): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/roleUser/addRoleUser'), JSON.stringify(roleUser),
      { headers: this.dataService.headerSend
      }
    );
  }
  public listRoleUser(): Observable<Object[]> {
    return this.http.get<Object[]>(this.dataService.getUrl('/roleUser/listRoleUser'),
      {
        headers: this.dataService.headerSend
      }
    );
  }

  public editRoleUser(roleUser: RoleUser): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl('/roleUser/editRoleUser'), JSON.stringify(roleUser),
      { headers: this.dataService.headerSend
      }
    );
  }
  public deleteRoleUser(roleUser: RoleUser): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl('/roleUser/deleteRoleUser'), JSON.stringify(roleUser),
      { headers: this.dataService.headerSend
      }
    );
  }
}
