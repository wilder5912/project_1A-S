import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest , HttpEvent } from '@angular/common/http';
import { DetailRole } from '../../model/usuario/DetailRole';
import { RoleUser } from '../../model/usuario/RoleUser';
import { User } from '../../model/usuario/User';
import { DataService } from '../../service/dataService/data.service';

@Injectable()
export class DetailRoleService {
  public formdata: FormData = new FormData();
  constructor(private http: HttpClient, public dataService: DataService) { }

  public lookForDetailRole(infoUser: string): Observable<User>  {
    return this.http.post<User>(this.dataService.getUrl('/detailRole/lookForDetailRole'), infoUser ,
      { headers: this.dataService.headerSend
      }
    );
  }
  public listRoleUser( userId: number): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/detailRole/listRoleUser'), userId,
      { headers: this.dataService.headerSend
      }
    );
  }
  public listAllRoleUser( userId: number): Observable<Object[]>  {
    return this.http.post<Object[]>(this.dataService.getUrl('/detailRole/listAllRoleUserId'), userId,
      { headers: this.dataService.headerSend
      }
    );
  }
  public addlistRoleUser( listRoleUserAdd): Observable<boolean> {
    return this.http.post<boolean>(this.dataService.getUrl('/detailRole/addRoleUser'), JSON.stringify(listRoleUserAdd),
      {
        headers: this.dataService.headerSend
      }
    );
  }
  public getLisRoleUserSelect( idRole: number): Observable<Object[]> {
    return this.http.post<Object[]>(this.dataService.getUrl('/detailRole/getLisRoleUser'), idRole,
      {
        headers: this.dataService.headerSend
      }
    );
  }
  public getLisRoleUserIdRoleId( detailRole: DetailRole): Observable<number> {
    return this.http.post<number>(this.dataService.getUrl('/detailRole/getUserIdRoleDetail'),  JSON.stringify(detailRole),
      {
        headers: this.dataService.headerSend
      }
    );
  }

 }


