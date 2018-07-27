import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
import { ListProduct } from '../../model/boxArticle/ListProduct';
import { Box } from '../../model/boxArticle/Box';
@Injectable()
export class BoxService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getBoxListArticle(boxData: Box): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/box/getBox'), JSON.stringify(boxData),
      { headers: this.dataService.headerSend
            }
      );
  }

  public addBoxArticle(listProduct: ListProduct): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/box/addBoxArticle'), JSON.stringify(listProduct),
      { headers: this.dataService.headerSend
    }
      );
  }


}
