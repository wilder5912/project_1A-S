import { Component, OnInit } from '@angular/core';
import { CarouselConfig } from 'ngx-bootstrap/carousel';
import { DataService } from "../../../service/dataService/data.service";
import { ArticleService } from "../../../service/product/ArticleService";

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

  public max = 10;
  public  rate = 0;
   public isReadonly = true;

  constructor(public dataService:DataService, public articleService:ArticleService) { }

  ngOnInit() {

    this.getBetsArticle();

  }
  public getBetsArticle(){
    this.articleService.getBestRevieArticle(this.dataService.bussineId)
      .subscribe(result=>{
        this.articleRelational = result;

      });


  }

}
