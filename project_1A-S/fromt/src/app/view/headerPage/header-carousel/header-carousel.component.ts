import { Component, OnInit } from '@angular/core';
import { CarouselConfig } from 'ngx-bootstrap/carousel';
import { Banner } from '../../../model/product/Banner';
import { BannerService } from '../../../service/product/BannerService';
import { DataService } from '../../../service/dataService/data.service';

@Component({
  selector: 'app-header-carousel',
  templateUrl: './header-carousel.component.html',
  styleUrls: ['./header-carousel.component.css'],
  providers: [BannerService,
    { provide: CarouselConfig, useValue: { interval: 13500, noPause: true } }
  ]
})
export class HeaderCarouselComponent implements OnInit {

  public listBanner;
  constructor(private bannerService:BannerService,private dataService: DataService) { }

  ngOnInit() {
    this.dataService.imageLoadPage=true;
    this.getListBanner();
  }

  public getListBanner(){

    this.bannerService.getBannerList()
      .subscribe(result=>{
        this.listBanner=result;
        this.dataService.imageLoadPage=false;
      });

  }


}
