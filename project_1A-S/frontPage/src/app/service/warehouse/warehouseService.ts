import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Warehouse } from '../../model/warehouse/Warehouse';

import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
@Injectable()
export class WarehouseService {

  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }
  public addWarehouse(warehouse: Warehouse): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/warehouse/addWarehouse'), JSON.stringify(warehouse),
      { headers: this.dataService.headerSend
      }
    );
  }
  public editWarehouse(warehouse: Warehouse): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/warehouse/editWarehouser'), JSON.stringify(warehouse),
      { headers: this.dataService.headerSend
      }
    );
  }
  public deleteWarehouse(warehouse: Warehouse): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/warehouse/deleteWarehouse'), JSON.stringify(warehouse),
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
  public getNumerOfArticle(codeArticle: string, businessId: number ): Observable<number> {
    return this.http.get<number>(this.dataService.getUrl('/warehouse/getWarehouserNumArticle/' + codeArticle + '/' + businessId),
      {
        headers: this.dataService.headerSend
      }
    );
  }

}
