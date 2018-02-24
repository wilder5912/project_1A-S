import { Component, OnInit } from '@angular/core';
import { DataService } from '../../../service/dataService/data.service';

@Component({
  selector: 'app-load-page',
  templateUrl: './load-page.component.html',
  styleUrls: ['./load-page.component.css']
})
export class LoadPageComponent implements OnInit {
  public imageload = '';
  constructor(public dataService:DataService) { }

  ngOnInit() {
    this.imageload= this.dataService.getApiUrl()+"/user/files/loadpage.gif";
  }

}
