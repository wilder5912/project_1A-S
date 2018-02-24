import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders , HttpHandler, HttpRequest ,HttpEvent,HttpInterceptor ,  HTTP_INTERCEPTORS } from "@angular/common/http";
 import { ArticleDetail} from '../../model/product/ArticleDetail';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
import { Comment } from "../../model/product/Comment";

@Injectable()
export class CommentService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public addCommentAndGetCommentList(comment:Comment): Observable<Object>  {
    return this.http.post<boolean>(this.dataService.getUrl("/comment/addComment"), JSON.stringify(comment));  }


  public getCommentArticleId(comment:Comment): Observable<Object>  {
    return this.http.post<boolean>(this.dataService.getUrl("/comment/getCommentArticleId"), JSON.stringify(comment));  }



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
