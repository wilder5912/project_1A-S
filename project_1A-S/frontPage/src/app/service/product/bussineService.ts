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
      return this.http.get<Business>(this.dataService.getUrl('/bussine/getBussineDTO'));
     }
     public getBussineAll(bussine: Business): Observable<Object>  {
      return this.http.post<Object>(this.dataService.getUrl('/bussine/getBussineListAllDTO'), JSON.stringify(bussine));
     }

}


