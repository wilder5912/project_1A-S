import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Provider } from '../../model/provider/Provider';

import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
@Injectable()
export class ProviderService {

  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public addProvider(provider: Provider): Observable<Provider>  {
    return this.http.post<Provider>(this.dataService.getUrl('/provider/addProvider'), JSON.stringify(provider),
      {
        headers: this.dataService.headerSend
      }
      );
  }
  public getProvidesList(): Observable<Provider> {
    return this.http.get<Provider>(this.dataService.getUrl('/provider/listProvider'),
      {
        headers: this.dataService.headerSend
      }
      );
  }
  public listProviderDTO(): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/provider/listProviderDTO'),
      {
        headers: this.dataService.headerSend
      }
    );
  }


}
