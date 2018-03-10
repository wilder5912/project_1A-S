import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GroupProduct } from '../../model/product/GroupProduct';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';
@Injectable()
export class GroupProductService {

  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getGroupProduct(): Observable<GroupProduct>  {
    return this.http.get<GroupProduct>(this.dataService.getUrl('/groupProduct/getGroupProduct'));
   }

  public addProductGroup(groupProduct: GroupProduct): Observable<GroupProduct>  {
    return this.http.post<GroupProduct>(this.dataService.getUrl('/groupProduct/addGroupProduct'), JSON.stringify(groupProduct));
  }

  public editProductGroup(groupProduct: GroupProduct): Observable<GroupProduct>  {
    return this.http.post<GroupProduct>(this.dataService.getUrl('/groupProduct/editGroupProduct'), JSON.stringify(groupProduct));
  }
  public deleteProductGroup(groupProduct: GroupProduct): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl('/groupProduct/deleteGroupProduct'), JSON.stringify(groupProduct));
  }
  public getProductGroupBussineId(bussineId: number): Observable<object>  {
    return this.http.get<object>(this.dataService.getUrl('/groupProduct/getBussineGroupList/' + bussineId));
  }


}


