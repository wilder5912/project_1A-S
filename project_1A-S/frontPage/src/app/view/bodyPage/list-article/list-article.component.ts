import { Component, OnInit ,ChangeDetectionStrategy, Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router, CanActivate } from '@angular/router';
import { ArticleService } from "../../../service/product/ArticleService";
import { SubSection } from "../../../model/product/SubSection";
import { DataService } from '../../../service/dataService/data.service';
import { ReviewArticle } from "../../../model/product/ReviewArticle";
import { Article } from "../../../model/product/Article";
import { Bussine } from "../../../model/bussine/Bussine";
import { PaginationInstance } from '../../../../../node_modules/ngx-pagination/dist/ngx-pagination.module';
@Component({
  selector: 'app-list-article',
  templateUrl: './list-article.component.html',
  styleUrls: ['./list-article.component.css'],
  providers: [ArticleService],
  changeDetection: ChangeDetectionStrategy.Default
})
export class ListArticleComponent implements OnInit {
  public id;
  public subSection:SubSection = new SubSection();
  public listArticleSubSection;

  @Input('data') meals: string[] = [];
  public reviewArticle :ReviewArticle = new ReviewArticle();
  public article :Article = new Article();
  public bussine :Bussine = new Bussine();

  public filter: string = '';
  public maxSize: number = 7;
  public directionLinks: boolean = true;
  public autoHide: boolean = false;
  public config: PaginationInstance = {
    id: 'advanced',
    itemsPerPage: 12,
    currentPage: 1
  };
  max = 10;
  rate = 0;
  isReadonly = true;
  overStar: number;
  percent: number;

  constructor(private route: ActivatedRoute,public articleService: ArticleService, public dataService:DataService, public router: Router ) { }

  ngOnInit() {
   this.dataService.imageLoadPage = true;
   this.getIdSubSection();

  }


  public getIdSubSection(){
    this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.getAticleAllSeubSection(this.id);

    });
  }

public getAticleAllSeubSection(idSubsection:number){
  this.subSection = new SubSection();
   this.subSection.subSectionId=idSubsection;
  this.articleService.getArticleListAll(this.subSection)
    .subscribe(result=>{
      this.listArticleSubSection=result;
      this.dataService.imageLoadPage = false;
    });
}

public redirectArticle(){

}

  private ngOnDestroy() {
  }
  public labels: any = {
    previousLabel: 'Previous',
    nextLabel: 'Next',
    screenReaderPaginationLabel: 'Pagination',
    screenReaderPageLabel: 'page',
    screenReaderCurrentLabel: 'tu pagina'
  };
  private popped = [];
  onPageChange(number: number) {
    this.config.currentPage = number;
  }
  pushItem() {
    let item = this.popped.pop() || 'A newly-created meal!';
    this.meals.push(item);
  }
  popItem() {
    this.popped.push(this.meals.pop());
  }

  public addReview(articleId: number){
    this.reviewArticle = new ReviewArticle();
    this.bussine.bussineId = this.dataService.bussineId;
    this.article.articleId = articleId;
    this.reviewArticle.articleId=this.article;
    this.reviewArticle.bussineId=this.bussine;

    this.articleService.addReviewArticle(this.reviewArticle)
      .subscribe(result=>{
        let redirectPage=  '/articleDetail/'+articleId;
        this.router.navigate([redirectPage]);
      });


  }

}
