import { Component, OnInit } from '@angular/core';
import { DataService } from "../../../service/dataService/data.service";

@Component({
  selector: 'app-footer-user',
  templateUrl: './footer-user.component.html',
  styleUrls: ['./footer-user.component.css']
})
export class FooterUserComponent implements OnInit {
  public imageload;
  constructor(private dataService:DataService) { }

  ngOnInit() {
    this.imageload= this.dataService.getApiUrl()+"/user/files/logo.png";
  }

}
