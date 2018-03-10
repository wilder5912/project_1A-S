import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient  } from '@angular/common/http';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
import { Comment } from '../../model/product/Comment';

@Injectable()
export class CommentService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public addCommentAndGetCommentList(comment: Comment): Observable<Object>  {
    return this.http.post<boolean>(this.dataService.getUrl('/comment/addComment'), JSON.stringify(comment));
  }
  public getCommentArticleId(comment: Comment): Observable<Object>  {
    return this.http.post<boolean>(this.dataService.getUrl('/comment/getCommentArticleId'), JSON.stringify(comment));
  }
}
