import { Component, OnInit, Input } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../../service/dataService/data.service';
import { ArticleVEO } from '../../../dto/ArticleVEO';
import { HttpResponse} from '@angular/common/http';
import { ImageArticleSevice } from '../../../service/product/ImageArticleService';

@Component({
  selector: 'app-form-list-article-image',
  templateUrl: './form-list-article-image.component.html',
  styleUrls: ['./form-list-article-image.component.css'],
  providers: [ImageArticleSevice]
})
export class FormListArticleImageComponent implements OnInit {
  @Input() articleDetail: string;
  @Input() articleData: string;
  public articleDetailListImage;
  public selectedFilesArticle;
  public selectedFilesTwo: FileList;
  public currentFileUploadOne: File;
  public article;
  constructor( public translate: TranslateService, public dataService: DataService,
               public imageArticleSevice: ImageArticleSevice) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.articleDetailListImage = this.articleDetail;
    this.article = this.articleData;
  }

  selectFiletwo(event) {
    this.selectedFilesArticle = true;
    const file = event.target.files.item(0);
    if (file.type.match('image.*')) {
      this.selectedFilesTwo = event.target.files;
    } else {
      console.log('formato invalido');
    }
  }
  uploadArticleImage() {
    this.currentFileUploadOne = this.selectedFilesTwo.item(0);
    this.imageArticleSevice.updateImageArticleId(this.currentFileUploadOne, (this.article.articleId + ''))
      .subscribe(event => {
        if (event instanceof HttpResponse) {
          this.imageListArticle(this.article.articleId);
        }
      }, e => {
        console.log( '', e );
      });
    this.selectedFilesArticle = undefined;
  }
  public imageListArticle(articleId: number) {
    this.imageArticleSevice.getImageArticleIdList(articleId)
      .subscribe(rest => {
        this.articleDetailListImage = rest;
      }, e => {
        console.log( '', e );
      });
  }
  public deleteImage(imageData) {
    this.imageArticleSevice.deleteImageArticle(imageData.imageArticleId)
      .subscribe( result => {
        this.imageListArticle(this.article.articleId);
      });
  }
}
