import { Component, OnInit, Input } from '@angular/core';
import { NgxCarousel } from 'ngx-carousel';
import { DataService } from '../../../service/dataService/data.service';
import { BoxService } from '../../../service/boxArticle/BoxService';
import { Box } from '../../../model/boxArticle/Box';
import { ListProduct } from '../../../model/boxArticle/ListProduct';
import { User } from '../../../model/usuario/User';
import { Article } from '../../../model/product/Article';
import { Bussine } from '../../../model/bussine/Bussine';

@Component({
  selector: 'app-carousel-article-page',
  templateUrl: './carousel-article-page.component.html',
  styleUrls: ['./carousel-article-page.component.css'],
  providers: [BoxService]
})
export class CarouselArticlePageComponent implements OnInit {

  @Input() articleList: string;
  @Input() titleCarousel: string;
  public carouselOne: NgxCarousel;
  public articleRelational;
  public max: number;
  public isReadonly: boolean;
  public box: Box = new Box();
  public listProduct: ListProduct = new ListProduct();
  public user: User = new User();
  public article: Article = new Article();
  public bussine: Bussine = new Bussine();
  constructor(public dataService: DataService , public boxService: BoxService ) { }

  ngOnInit() {
    this.max = 10;
    this.isReadonly = true;
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
    this.articleRelational = this.articleList;
  }
  public carouselTileLoad(evt: any) {

  }

  public getBoxArticle(box: Box) {

    this.boxService.getBoxListArticle(box)
      .subscribe( result => {
        this.dataService.getListArticle = result;
        this.dataService.articleValue = 0;
        let coste = 0;
        this.dataService.getListArticle.listProductVEO.articleVEO.forEach(function(keyForm: any, i){
          coste = coste + (keyForm.numProduct * keyForm.precyAr);
        });

        this.dataService.articleValue = coste;
      });
  }
  public addArticle(articleData) {
    this.box = new Box();
    this.user = new User();
    this.article = new Article();
    this.bussine = new Bussine();
    this.listProduct = new ListProduct();
    this.bussine.bussineId = this.dataService.bussineId;
    this.user.userID = this.dataService.AUTH_CONFIG.userID;
    this.box.boxId = this.dataService.boxIdUser;
    this.box.userID = this.user;
    this.box.bussineId = this.bussine;
    this.listProduct.boxId = this.box;
    this.article.articleId = articleData.articleId;
    this.listProduct.articleId = this.article;
    this.listProduct.numProduct = 1;
    this.boxService.addBoxArticle(this.listProduct)
      .subscribe(result => {
        console.log(result);
        this.getBoxArticle(this.box);
      });
  }
}
