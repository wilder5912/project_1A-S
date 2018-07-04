import { Component, TemplateRef , OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../../service/dataService/data.service';
import { ArticleDetailService } from '../../../service/product/ArticleDetailService';
import { ArticleService } from '../../../service/product/ArticleService';
import { BussineService } from '../../../service/product/bussineService';
import { Article } from '../../../model/product/Article';
import { Business } from '../../../model/business/Business';
import { ArticleRelational } from '../../../model/product/ArticleRelational';
@Component({
  selector: 'app-article-relational',
  templateUrl: './article-relational.component.html',
  styleUrls: ['./article-relational.component.css'],
  providers: [ ArticleService, ArticleDetailService, BussineService]
})
export class ArticleRelationalComponent implements OnInit {
  public form: FormGroup;
  public isEditForm;
  public articleSelect;
  public articleDetail;
  public bussineSelect;
  public article: Article;
  public artArticleId: Article;
  public business: Business;
  public articleRelarionaData: ArticleRelational;
  public articleRelational: any;
  public modalRefArticleRelation: BsModalRef;
  public config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  constructor(public formBuilder: FormBuilder, public translate: TranslateService ,
              public dataService: DataService ,
              public articleDetailService: ArticleDetailService ,
              public articleService: ArticleService, public bussineService: BussineService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.artArticleId = new Article();
    this.dataService.redirectTypeUser();
    this.isEditForm = true;
    this.formValidateModal();
    this.getListBussine();
  }

  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.articleId.errors},
      {'SectionInformation': this.form.controls.artArticleId.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }

  public formValidateModal() {
    this.form = this.formBuilder.group({
      bussineId: [ '', Validators.compose([
        Validators.required
      ])],
      articleId: [ '', Validators.compose([
        Validators.required
      ])],
      artArticleId: [ '', Validators.compose([
        Validators.required
      ])]
    });
  }

  public openModalWithClass(template: TemplateRef<any>) {
    this.modalRefArticleRelation = this.dataService.showModalBig(template, this.config);
  }

  getListBussine(): void {
    this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;
      }, error => {
        console.log(error );
      });
  }

  public getSelectArticle() {
    this.articleDetailService.getArticleDetailBussine(this.dataService.bussineId)
      .subscribe(result => {
        this.articleSelect = result;
      });
  }
  public onSelectArticle(event) {
    this.articleService.getArticleId(event.value)
      .subscribe( result => {
        this.articleDetail = result;
        this.getArticleIdRelational(event.value, this.dataService.bussineId);
      });
  }
  public getArticleIdRelational(articleId, bussineId) {
    this.articleService.getArticleIdRelational(bussineId, articleId )
      .subscribe(result => {
        const listRelational = [];
        result.forEach(function(sectioninforData) {
          listRelational.push(sectioninforData + '');
        });
         this.form.controls['artArticleId'].setValue(listRelational);
      });
  }
  onSelectBussine(event) {
    this.dataService.bussineId = event.value;
    this.getSelectArticle();
  }

  public onSelectArticleRelational(event) { }


  public registerRelationalArticle() {
    if (this.getValidateInfo()) {
      this.articleRelational = [];
      this.article = new Article();
      this.business = new Business();
      this.business.businessId = this.dataService.bussineId;
      this.article.articleId =  this.form.value['articleId'];
      const articleIdList = this.form.value['artArticleId'];
      for (let i = 0; i < articleIdList.length; i++) {
        this.artArticleId = new Article();
        this.articleRelarionaData = new ArticleRelational();
        this.artArticleId.articleId = articleIdList[i];
        this.articleRelarionaData.articleId = this.article;
        this.articleRelarionaData.artArticleId = this.artArticleId;
        this.articleRelarionaData.businessId = this.business;
        this.articleRelational.push(this.articleRelarionaData);
      }
    this.articleService.addArticleRelationalList(this.articleRelational)
    .subscribe( result => {
    });
    }
  }



}
