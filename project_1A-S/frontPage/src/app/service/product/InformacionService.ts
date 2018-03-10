import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Information } from '../../model/product/Information';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';

@Injectable()
export class InformationService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public addInformationArticle(infomation: Information): Observable<boolean> {
    return this.http.post<boolean>(this.dataService.getUrl('/information/addInformationArticle'), JSON.stringify(infomation));
  }
}
