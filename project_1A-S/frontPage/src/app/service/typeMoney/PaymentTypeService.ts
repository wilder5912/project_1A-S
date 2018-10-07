import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
import { PaymentType } from '../../model/typeMoney/PaymentType';
@Injectable()
export class PaymentTypeService {

  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public listPaymentType(): Observable<Object[]> {
    return this.http.get<Object[]>(this.dataService.getUrl('/paymentType/listPaimentType/'),
      {
        headers: this.dataService.headerSend
      }
    );
  }

/*
  public addTypeMoney(typeMoney: TypeMoney): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/typeMoney/addTypeMoney'), JSON.stringify(typeMoney),
      { headers: this.dataService.headerSend
      }
    );
  }
  public listMoneyBusinessId(idBusiness: number): Observable<Object[]> {
    return this.http.get<Object[]>(this.dataService.getUrl('/typeMoney/listTypeMoneyBusiness/' + idBusiness),
      {
        headers: this.dataService.headerSend
      }
    );
  }
  public editTypeMoney(typeMoney: TypeMoney): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl('/typeMoney/editTypeMoney'), JSON.stringify(typeMoney),
      { headers: this.dataService.headerSend
      }
    );
  }

  public deleteTypeMoney(warehouse: TypeMoney): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl('/typeMoney/deleteTypeMoney'), JSON.stringify(warehouse),
      { headers: this.dataService.headerSend
      }
    );
  }
*/


}
