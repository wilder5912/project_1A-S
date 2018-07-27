import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Provider } from '../../model/provider/Provider';

import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
@Injectable()
export class WareHouseMainService {

  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

/*  public addProvider(provider: Provider): Observable<Provider>  {
    return this.http.post<Provider>(this.dataService.getUrl('/provider/addProvider'), JSON.stringify(provider),
      {
        headers: this.dataService.headerSend
      }
    );
  }*/

  public listWarehouseCodeMain(): Observable<Object[]> {
    return this.http.get<Object[]>(this.dataService.getUrl('/wareHouseMain/getWareHouseMainDTO'),
      {
        headers: this.dataService.headerSend
      }
    );
  }

}
