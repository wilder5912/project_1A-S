import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ArticleDetailService } from '../../../service/product/ArticleDetailService';
import { DataService } from '../../../service/dataService/data.service';

@Component({
  selector: 'app-list-article-fiend',
  templateUrl: './list-article-fiend.component.html',
  styleUrls: ['./list-article-fiend.component.css'],
  providers: [ArticleDetailService]
})
export class ListArticleFiendComponent implements OnInit {

  public listArticleFind;
  constructor(private route: ActivatedRoute  , public articleDetailService: ArticleDetailService, public dataService: DataService) { }

  ngOnInit() {
    this.dataService.imageLoadPage = true;
    this.getIdSubSection();
  }
  public getIdSubSection() {
    this.route.params.subscribe(params => {
      this.getListArticle(params['name']);
    });
  }
  public getListArticle(nameArorCode: string) {

    this.articleDetailService.getArticleFiend(nameArorCode, this.dataService.bussineId)
      .subscribe(result => {
        this.dataService.imageLoadPage = false;
            this.listArticleFind = result;
      });
  }




}
