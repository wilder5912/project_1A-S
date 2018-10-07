import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import { ArticleDetail} from '../../model/product/ArticleDetail';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
@Injectable()
export class ArticleDetailService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getArticleDetailList(): Observable<ArticleDetail>  {
    return this.http.get<ArticleDetail>(this.dataService.getUrl('/articleDetail/getArticleDetail'));
  }
  public getArticleFiend(nameArticle: string, idBusiness: number): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/articleDetail/getFindArticleBussineId/' + nameArticle + '/' + idBusiness));
  }

  public getArticleDetailBussine( idBusiness: number): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/articleDetail/getArticleBussine/' + idBusiness));
  }
  public getArticleDetailIdBussine( idBusiness: number): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/articleDetail/getArticleDetailIdBussine/' + idBusiness));
  }
  public getArticleBussine(): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/articleDetail/getArticleBussineId'));
  }

  public getSubSectionListArticle(subSectionId: number): Observable<Object[]> {
    return this.http.get<Object[]>(this.dataService.getUrl('/articleDetail/getSubSectionListArticle/' + subSectionId ));
  }

  public addArticleDetail( articleDetail ): Observable<boolean> {
    return this.http.post<boolean>(this.dataService.getUrl('/articleDetail/addArticleDetail'), JSON.stringify(articleDetail),
      {
        headers: this.dataService.headerSend
      }
    );
  }
  public getArticleDetailCodBusi( codeAr: string , businessId: number ): Observable<ArticleDetail> {
    return this.http.get<ArticleDetail>(this.dataService.getUrl('/articleDetail/getArticleDetailCodBusi/' + codeAr + '/' + businessId),
      {
        headers: this.dataService.headerSend
      }
    )
     .catch(this.errorHandler);
  }
  private handleError (error: any) {
    const errMsg = error.message || 'Server error';
    /*//console.error(errMsg); // log to console instead*/
    return Observable.throw(errMsg);
  }
  errorHandler(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'error');
  }
}
