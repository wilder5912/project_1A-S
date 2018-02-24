import { Component, OnInit } from '@angular/core';
import { CarouselConfig } from 'ngx-bootstrap/carousel';
import { Banner } from '../../../model/product/Banner';
import { BannerService } from '../../../service/product/BannerService';
import { DataService } from '../../../service/dataService/data.service';
import { NgxCarousel } from 'ngx-carousel';
@Component({
  selector: 'app-header-carousel',
  templateUrl: './header-carousel.component.html',
  styleUrls: ['./header-carousel.component.css'],
  providers: [ BannerService ]
})
export class HeaderCarouselComponent implements OnInit {

  public listBanner;

  public config: SwiperOptions;

  constructor(public bannerService:BannerService,public dataService: DataService) { }

  ngOnInit() {
    this.dataService.imageLoadPage=true;
    this.getListBanner();
    this.configCarousel();
  }

  public configCarousel() {
    this.config = {
      pagination: '.swiper-pagination',
      paginationClickable: true,
      nextButton: '.swiper-button-next',
      prevButton: '.swiper-button-prev',
      spaceBetween: 30,
      loop: true
    };
  }
  public getListBanner(){

    this.bannerService.getBannerList()
      .subscribe(result=>{
        this.listBanner=result;
        this.dataService.imageLoadPage=false;
      });

  }


}
