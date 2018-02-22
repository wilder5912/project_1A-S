import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders , HttpHandler, HttpRequest ,HttpEvent,HttpInterceptor ,  HTTP_INTERCEPTORS } from "@angular/common/http";
 import { ImageArticle} from '../../model/product/ImageArticle';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';

@Injectable()
export class ImageArticleSevice {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

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
