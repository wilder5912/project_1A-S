import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders , HttpHandler, HttpRequest ,HttpEvent,HttpInterceptor ,  HTTP_INTERCEPTORS } from "@angular/common/http";
 import { ArticleDetail} from '../../model/product/ArticleDetail';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';

@Injectable()
export class ArticleDetailService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getArticleDetailList(): Observable<ArticleDetail>  {
    return this.http.get<ArticleDetail>(this.dataService.getUrl("/articleDetail/getArticleDetail"));
  }
 /* public addSubSection(section: SubSection): Observable<SubSection>  {
    return this.http.post<SubSection>(this.dataService.getUrl("/subSection/addSubSection"), JSON.stringify(section));
  }
  public deleteSubSectionId(subSectionId:number): Observable<boolean>  {
    return this.http.get<boolean>(this.dataService.getUrl("/subSection/deleteSubSectionId/"+subSectionId));
  }
  public updateSubSection(subSection: SubSection): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl("/subSection/updateSubSection"), JSON.stringify(subSection));
  }*/
}
