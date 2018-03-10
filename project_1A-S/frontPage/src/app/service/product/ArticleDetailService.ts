import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
 import { ArticleDetail} from '../../model/product/ArticleDetail';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';

@Injectable()
export class ArticleDetailService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getArticleDetailList(): Observable<ArticleDetail>  {
    return this.http.get<ArticleDetail>(this.dataService.getUrl('/articleDetail/getArticleDetail'));
  }
  public getArticleFiend(nameArticle: string, idBussine: number): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/articleDetail/getFindArticleBussineId/' + nameArticle + '/' + idBussine));
  }

  public getArticleDetailBussine( idBussine: number): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/articleDetail/getArticleBussine/' + idBussine));
  }

}
