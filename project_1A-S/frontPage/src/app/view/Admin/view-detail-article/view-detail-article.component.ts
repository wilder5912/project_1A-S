import { Component, OnInit, ViewChild } from '@angular/core';
import { TabsetComponent } from 'ngx-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { Article } from '../../../model/product/Article';
import { ArticleService } from '../../../service/product/ArticleService';

@Component({
  selector: 'app-view-detail-article',
  templateUrl: './view-detail-article.component.html',
  styleUrls: ['./view-detail-article.component.css'],
  providers: [ArticleService]
})
export class ViewDetailArticleComponent implements OnInit {
  @ViewChild('staticTabs') staticTabs: TabsetComponent;
  public idArticule;
  public articleDetailId;
  public article: Article;
  public articleInfo;
  constructor(private route: ActivatedRoute, public articleService: ArticleService) { }

  ngOnInit() {
    this.getIdArticleDetail();
  }
  public getIdArticleDetail() {
    this.route.params.subscribe(params => {
      this.idArticule = +params['idArticle'];
      this.articleDetailId = +params['articleDetailId'];
      this.getArticleDetail(this.idArticule);
    });
  }
  public getArticleDetail(idArticle: number) {
    this.article = new Article();
    this.article.articleId = idArticle;
    this.articleService.getArticleDetailData(this.article)
      .subscribe( result => {
        this.articleInfo = result;
      });
  }
}
