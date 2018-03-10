import { Component, OnInit } from '@angular/core';
import { CarouselConfig } from 'ngx-bootstrap/carousel';
import { DataService } from '../../../service/dataService/data.service';
import { ArticleService } from '../../../service/product/ArticleService';
import { NgxCarousel } from 'ngx-carousel';

@Component({
  selector: 'app-best-review-product-carousel',
  templateUrl: './best-review-product-carousel.component.html',
  styleUrls: ['./best-review-product-carousel.component.css'],
  providers: [ArticleService,
    { provide: CarouselConfig, useValue: { interval: 5000, noPause: true } }
  ]
})
export class BestReviewProductCarouselComponent implements OnInit {
  public articleRelational;
  public carouselOne: NgxCarousel;
  public max: number;
  public  rate: number;
  public isReadonly: boolean;
  public articleTitle: string;
  constructor(public dataService: DataService, public articleService: ArticleService) { }

  ngOnInit() {
    this.max = 10;
    this.rate = 0;
    this.isReadonly = true;
    this.articleTitle = 'Articulos Mas Revisados';
    this.getBetsArticle();
    this.carouselOne  = {
      grid: {xs: 1, sm: 3, md: 3, lg: 4, all: 0},
      slide: 2,
      speed: 400,
      animation: 'lazy',
      loop: true,
      point: {
        visible: true,
        pointStyles: `
          .ngxcarouselPoint {
            list-style-type: none;
            text-align: center;
            padding: 12px;
            margin: 0;
            white-space: nowrap;
            overflow: auto;
            box-sizing: border-box;
          }
          .ngxcarouselPoint li {
            display: inline-block;
            border-radius: 50%;
            border: 2px solid rgba(0, 0, 0, 0.55);
            padding: 4px;
            margin: 0 3px;
            transition-timing-function: cubic-bezier(.17, .67, .83, .67);
            transition: .4s;
          }
          .ngxcarouselPoint li.active {
              background: #6b6b6b;
              transform: scale(1.2);
          }
        `
      },
      load: 2,
      touch: true,
      easing: 'ease'
    };

  }
  public getBetsArticle() {
    this.articleService.getBestRevieArticle(this.dataService.bussineId)
      .subscribe(result => {
        this.articleRelational = result;
      });
  }
  public carouselTileLoad(evt: any) {

  }
}
