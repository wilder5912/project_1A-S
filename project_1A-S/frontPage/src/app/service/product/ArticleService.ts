import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest , HttpEvent  } from '@angular/common/http';
import { Article} from '../../model/product/Article';
import { ReviewArticle} from '../../model/product/ReviewArticle';
import { SubSection} from '../../model/product/SubSection';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
import { ArticleRelational } from '../../model/product/ArticleRelational';
@Injectable()
export class ArticleService {

  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public updateImageAndArticle(fileArticle: File, article: Article, subSection: SubSection): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('fileArticle', fileArticle);
    formdata.append('articleData', JSON.stringify(article));
    formdata.append('subSectionData', JSON.stringify(subSection));
    const req = new HttpRequest('POST', this.dataService.getUrl('/articleDetail/updateArticleDetailOne'), formdata, {
      reportProgress: true,
      responseType: 'text'
    });
    return this.http.request(req);
  }
  public editImageAndArticle(fileArticle: File, article: Article): Observable<HttpEvent<{}>> {

    const formdata: FormData = new FormData();
    formdata.append('articleData', JSON.stringify(article));
    if (fileArticle) {
      formdata.append('fileArticle', fileArticle);
      const req = new HttpRequest('POST', this.dataService.getUrl('/articleDetail/editArticleDetailOne'), formdata, {
        reportProgress: true,
        responseType: 'text'
      });
      return this.http.request(req);
    }else {
      formdata.append('fileArticle', fileArticle);
      const req = new HttpRequest('POST', this.dataService.getUrl('/articleDetail/editArticleData'), formdata, {
        reportProgress: true,
        responseType: 'text'
      });
      return this.http.request(req);
    }
  }


  public getArticleListAll(subSection: SubSection): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/article/getSubSectionArticleListAll'), JSON.stringify(subSection));
  }
  public getArticleDetailData(article: Article): Observable<Object>  {
    return this.http.post<Object>(this.dataService.getUrl('/article/getArticleDataDetail'), JSON.stringify(article));
  }

  public getBestRevieArticle(businessId: number): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/article/getBestArticleReview/' + businessId));
  }

  public getArticleRelationalArticleIdBussineId(businessId: number , articleId): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/articleRelational/getArticleRelational/' + businessId + '/' + articleId));
  }
  public getArticleIdRelational(businessId: number, articleId): Observable<Object[]> {
    return this.http.get<Object[]>(this.dataService.getUrl('/articleRelational/getArticleIdRelational/' + businessId + '/' + articleId));
  }

  public addArticleRelationalList( articleRelational): Observable<boolean> {
    return this.http.post<boolean>(this.dataService.getUrl('/articleRelational/addArticleRelation'), JSON.stringify(articleRelational),
      {
              headers: this.dataService.headerSend
      }
      );
  }
  public addReviewArticle(reviewArticle: ReviewArticle): Observable<Object> {

    return this.http.post<Object>(this.dataService.getUrl('/article/addReviewArticle'), JSON.stringify(reviewArticle));

  }
  public getArticleId( idArticle: number): Observable<Object> {

    return this.http.get<Object>(this.dataService.getUrl('/article/getArticleId/' + idArticle));

  }
  public getArticleList(): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/article/getArticleList'));

  }
  public eveentoPru(): Observable<Object> {
    return this.http.get<Object>(this.dataService.getUrl('/pru/notify'));

  }
}
