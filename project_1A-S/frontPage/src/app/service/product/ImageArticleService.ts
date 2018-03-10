import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { ImageArticle} from '../../model/product/ImageArticle';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';

@Injectable()
export class ImageArticleSevice {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getImageSectionList(): Observable<ImageArticle>  {
    return this.http.get<ImageArticle>(this.dataService.getUrl('/imageArticle/getImageArticle'));
  }

  public updateImageArticleId(fileArticle: File, idArticle: string ): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('fileArticle', fileArticle);
    formdata.append('idArticle', idArticle);

    const req = new HttpRequest('POST', this.dataService.getUrl('/imageArticle/updateArticleImageDetailOne'), formdata, {
      reportProgress: true,
      responseType: 'text'
    });
    return this.http.request(req);
  }

  public getImageArticleIdList(articleId: number): Observable<ImageArticle>  {
    return this.http.get<ImageArticle>(this.dataService.getUrl('/imageArticle/getImageArticleIdList/' + articleId));
  }
}
