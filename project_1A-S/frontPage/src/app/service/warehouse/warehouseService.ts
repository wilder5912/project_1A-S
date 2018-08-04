import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Warehouse } from '../../model/warehouse/Warehouse';

import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
@Injectable()
export class WarehouseService {

  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

/*  public addProvider(provider: Provider): Observable<Provider>  {
    return this.http.post<Provider>(this.dataService.getUrl('/provider/addProvider'), JSON.stringify(provider),
      {
        headers: this.dataService.headerSend
      }
    );
  }*/


  public addWarehouse(warehouse: Warehouse): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/warehouse/addWarehouse'), JSON.stringify(warehouse),
      { headers: this.dataService.headerSend
      }
    );
  }

  public listWarehouseCode(): Observable<Object[]> {
    return this.http.get<Object[]>(this.dataService.getUrl('/warehouse/listWarehouseCode'),
      {
        headers: this.dataService.headerSend
      }
    );
  }
  public listWarehouse(): Observable<Object[]> {
    return this.http.get<Object[]>(this.dataService.getUrl('/warehouse/listWarehouse'),
      {
        headers: this.dataService.headerSend
      }
    );
  }

}
