import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Business } from '../../model/business/Business';

import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
@Injectable()
export class BussineService {

    constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

    public getBussine(): Observable<Business>  {
      return this.http.get<Business>(this.dataService.getUrl('/business/getBusinessDTO'));
     }
    public getBussineList(): Observable<Business> {
      return this.http.get<Business>(this.dataService.getUrl('/business/getBusinessList'));
    }
     public getBussineAll(business: Business): Observable<Object>  {
      return this.http.post<Object>(this.dataService.getUrl('/business/getBusinessListAllDTO'), JSON.stringify(business));
     }
    public addBusiness(business: Business): Observable<Business>  {
       return this.http.post<Business>(this.dataService.getUrl('/business/addBusiness'), JSON.stringify(business));
    }

    public editBusiness(business: Business): Observable<Business>  {
      return this.http.post<Business>(this.dataService.getUrl('/business/editBusiness'), JSON.stringify(business));
    }
    public deleteBusiness(business: Business): Observable<Business>  {
      return this.http.post<Business>(this.dataService.getUrl('/business/deleteBusiness'), JSON.stringify(business));
    }
}

