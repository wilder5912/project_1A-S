import { Component, OnInit , ChangeDetectionStrategy, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router} from '@angular/router';
import { ArticleService } from '../../../service/product/ArticleService';
import { SubSection } from '../../../model/product/SubSection';
import { DataService } from '../../../service/dataService/data.service';
import { ReviewArticle } from '../../../model/product/ReviewArticle';
import { Article } from '../../../model/product/Article';
import { Business } from '../../../model/business/Business';
import { PaginationInstance } from '../../../../../node_modules/ngx-pagination/dist/ngx-pagination.module';
import { BoxService } from '../../../service/boxArticle/BoxService';
import { Box } from '../../../model/boxArticle/Box';
import { ListProduct } from '../../../model/boxArticle/ListProduct';
import { User } from '../../../model/usuario/User';
 @Component({
  selector: 'app-list-page-article',
  templateUrl: './list-page-article.component.html',
  styleUrls: ['./list-page-article.component.css'],
  providers: [ArticleService, BoxService],
  changeDetection: ChangeDetectionStrategy.Default
})

export class ListPageArticleComponent implements OnInit {
  @Input() listArticle: string;
  @Input('data')meals: string[] = [];

  public id;
  public subSection: SubSection = new SubSection();
  public reviewArticle: ReviewArticle = new ReviewArticle();
  public article: Article = new Article();
  public business: Business = new Business();
  public box: Box = new Box();
  public listProduct: ListProduct = new ListProduct();
  public user: User = new User();
  public filter: string;
  public maxSize: number;
  public directionLinks: boolean;
  public autoHide: boolean;
  public config: PaginationInstance = {
    id: 'advanced',
    itemsPerPage: 12,
    currentPage: 1
  };
  public max;
  public rate = 0;
  public isReadonly = true;
  public overStar: number;
  public percent: number;
  public labels: any = {
     previousLabel: 'Previous',
     nextLabel: 'Next',
     screenReaderPaginationLabel: 'Pagination',
     screenReaderPageLabel: 'page',
     screenReaderCurrentLabel: 'tu pagina'
   };
   private popped = [];
   constructor(private route: ActivatedRoute, public boxService: BoxService,
            public articleService: ArticleService, public dataService: DataService,
            public router: Router ) { }

  ngOnInit() {
  this.filter = '';
  this.maxSize = 7;
  this.directionLinks = true;
  this.autoHide = false;
  this.max = 5;
  this.rate = 0;
  this.isReadonly = true;
  }
  public onPageChange(number: number) {
    this.config.currentPage = number;
  }
  pushItem() {
    const item = this.popped.pop() || 'A newly-created meal!';
    this.meals.push(item);
  }
  popItem() {
    this.popped.push(this.meals.pop());
  }

  public addReview(articleId: number) {
    this.reviewArticle = new ReviewArticle();
    this.business.businessId = this.dataService.bussineId;
    this.article.articleId = articleId;
    this.reviewArticle.articleId = this.article;
    this.reviewArticle.businessId = this.business;
    this.articleService.addReviewArticle(this.reviewArticle)
      .subscribe(result => {
        const redirectPage =  '/articleDetail/' + articleId;
        this.router.navigate([redirectPage]);
      });
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
    this.listProduct = new ListProduct();
    this.business = new Business();
    this.business.businessId = this.dataService.bussineId;
    this.user.userID = this.dataService.AUTH_CONFIG.userID;
    this.box.boxId = this.dataService.boxIdUser;
    this.box.userID = this.user;
    this.listProduct.boxId = this.box;
    this.article.articleId = articleData.articleId;
    this.listProduct.articleId = this.article;
    this.box.businessId = this.business;
    this.boxService.addBoxArticle(this.listProduct)
      .subscribe(result => {
        this.getBoxArticle(this.box);
      });
  }

}
