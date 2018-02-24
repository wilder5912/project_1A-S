import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders , HttpHandler, HttpRequest ,HttpEvent,HttpInterceptor ,  HTTP_INTERCEPTORS } from "@angular/common/http";
import { User } from "../../model/usuario/User";
import { Section} from '../../model/product/Section';
import { GroupProduct } from "../../model/product/GroupProduct";
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';

@Injectable()
export class SectionService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getSectionList(): Observable<Section>  {
    return this.http.get<Section>(this.dataService.getUrl("/section/getSection"));
  }

  public addSection(section: Section): Observable<Section>  {
    return this.http.post<Section>(this.dataService.getUrl("/section/addSection"), JSON.stringify(section));
  }

  public getSectionIdList(idGroup:number): Observable<Section>  {
    return this.http.get<Section>(this.dataService.getUrl("/section/getSectionIdList/"+idGroup));
  }


  public deleteSectionId(sectionId:number): Observable<boolean>  {
    return this.http.get<boolean>(this.dataService.getUrl("/section/deleteSectionId/"+sectionId));
  }


  public updateSection(section: Section): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl("/section/updateSection"), JSON.stringify(section));
  }

}
