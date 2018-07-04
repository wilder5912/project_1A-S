import { Component, OnInit , ChangeDetectionStrategy} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { ArticleService } from '../../../service/product/ArticleService';
import { SubSection } from '../../../model/product/SubSection';
import { DataService } from '../../../service/dataService/data.service';
import { ReviewArticle } from '../../../model/product/ReviewArticle';
import { Article } from '../../../model/product/Article';
import { Business } from '../../../model/business/Business';

@Component({
  selector: 'app-list-article',
  templateUrl: './list-article.component.html',
  styleUrls: ['./list-article.component.css'],
  providers: [ArticleService],
  changeDetection: ChangeDetectionStrategy.Default
})
export class ListArticleComponent implements OnInit {
  public id;
  public subSection: SubSection = new SubSection();
  public listArticleSubSection;
  public reviewArticle: ReviewArticle = new ReviewArticle();
  public article: Article = new Article();
  public business: Business = new Business();


constructor(private route: ActivatedRoute, public articleService: ArticleService,
            public dataService: DataService, public router: Router ) { }

  ngOnInit() {
   this.dataService.imageLoadPage = true;
   this.getIdSubSection();
  }
  public getIdSubSection() {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.getAticleAllSeubSection(this.id);
    });
  }

public getAticleAllSeubSection(idSubsection: number) {
  this.subSection = new SubSection();
   this.subSection.subSectionId = idSubsection;
  this.articleService.getArticleListAll(this.subSection)
    .subscribe(result => {
      this.listArticleSubSection = result;
      this.dataService.imageLoadPage = false;
    });
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

}
