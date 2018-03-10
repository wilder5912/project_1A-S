import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SubSection} from '../../model/product/SubSection';
import { DataService } from '../dataService/data.service';
import { Router } from '@angular/router';

@Injectable()
export class SubSectionService {
  constructor(private http: HttpClient, public dataService: DataService , public router: Router) { }

  public getSubSectionList(): Observable<SubSection>  {
    return this.http.get<SubSection>(this.dataService.getUrl('/subSection/getSubSection'));
  }
  public addSubSection(section: SubSection): Observable<SubSection>  {
    return this.http.post<SubSection>(this.dataService.getUrl('/subSection/addSubSection'), JSON.stringify(section));
  }
  public deleteSubSectionId(subSectionId: number): Observable<boolean>  {
    return this.http.get<boolean>(this.dataService.getUrl('/subSection/deleteSubSectionId/' + subSectionId));
  }
  public updateSubSection(subSection: SubSection): Observable<boolean>  {
    return this.http.post<boolean>(this.dataService.getUrl('/subSection/updateSubSection'), JSON.stringify(subSection));
  }
  public getSectionSubSectionIdList(idSection: number): Observable<SubSection>  {
    return this.http.get<SubSection>(this.dataService.getUrl('/subSection/getSectionSubSectionIdList/' + idSection));
   }
}
