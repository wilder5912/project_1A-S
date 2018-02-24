import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders , HttpHandler, HttpRequest ,HttpEvent,HttpInterceptor ,  HTTP_INTERCEPTORS } from "@angular/common/http";
import { User } from "../../model/usuario/User";
import { GroupProduct } from "../../model/product/GroupProduct";
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
@Injectable()
export class GroupProductService {

  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getGroupProduct(): Observable<GroupProduct>  {
    return this.http.get<GroupProduct>(this.dataService.getUrl("/groupProduct/getGroupProduct"));
   }

  public addProductGroup(GroupProduct: GroupProduct): Observable<GroupProduct>  {
    return this.http.post<GroupProduct>(this.dataService.getUrl("/groupProduct/addGroupProduct"), JSON.stringify(GroupProduct));
  }

  public editProductGroup(GroupProduct: GroupProduct): Observable<GroupProduct>  {
    return this.http.post<GroupProduct>(this.dataService.getUrl("/groupProduct/editGroupProduct"), JSON.stringify(GroupProduct));
  }
  public deleteProductGroup(GroupProduct: GroupProduct): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl("/groupProduct/deleteGroupProduct"), JSON.stringify(GroupProduct));
  }
  public getProductGroupBussineId(bussineId:number): Observable<object>  {
    return this.http.get<object>(this.dataService.getUrl("/groupProduct/getBussineGroupList/"+bussineId));
  }


}


