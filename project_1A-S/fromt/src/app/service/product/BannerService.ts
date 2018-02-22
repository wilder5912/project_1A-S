import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders , HttpHandler, HttpRequest ,HttpEvent,HttpInterceptor ,  HTTP_INTERCEPTORS } from "@angular/common/http";
 import { Banner} from '../../model/product/Banner';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';

@Injectable()
export class BannerService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public updateImageArticle(fileArticle: File, banner:Banner ): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();
    formdata.append('fileBanner', fileArticle);
    formdata.append('banner', JSON.stringify(banner));
    const req = new HttpRequest('POST', this.dataService.getUrl("/banner/updateImageArticle"), formdata, {
      reportProgress: true,
      responseType: 'text'
    });
    return this.http.request(req);
  }

  public getBannerList(): Observable<Banner>  {
    return this.http.get<Banner>(this.dataService.getUrl("/banner/getListBanner"));
  }

/*
  public getImageSectionList(): Observable<ImageArticle>  {
    return this.http.get<ImageArticle>(this.dataService.getUrl("/imageArticle/getImageArticle"));
  }

  public updateImageArticleId(fileArticle: File, idArticle:string ): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();
    formdata.append('fileArticle', fileArticle);
    formdata.append('idArticle', idArticle);

    const req = new HttpRequest('POST', this.dataService.getUrl("/imageArticle/updateArticleImageDetailOne"), formdata, {
      reportProgress: true,
      responseType: 'text'
    });
    return this.http.request(req);
  }

  public getImageArticleIdList(articleId:number): Observable<ImageArticle>  {
    return this.http.get<ImageArticle>(this.dataService.getUrl("/imageArticle/getImageArticleIdList/"+articleId));
  }
*/



}
