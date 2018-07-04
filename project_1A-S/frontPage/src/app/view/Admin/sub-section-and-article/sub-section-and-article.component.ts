import { Component, TemplateRef, OnInit } from '@angular/core';
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
import { GroupProductService } from '../../../service/product/groupProductService';
import { ArticleDetail } from '../../../model/product/ArticleDetail';
import { SectionService } from '../../../service/product/SectionService';
import { SubSection } from '../../../model/product/SubSection';
import { SubSectionService } from '../../../service/product/SubSectionService';
@Component({
  selector: 'app-sub-section-and-article',
  templateUrl: './sub-section-and-article.component.html',
  styleUrls: ['./sub-section-and-article.component.css'],
  providers: [ ArticleService, ArticleDetailService, BussineService, GroupProductService, SectionService, SubSectionService]
})
export class SubSectionAndArticleComponent implements OnInit {
  public form: FormGroup;
  public isEditForm;
  public articleSelect;
  public articleDetail;
  public bussineSelect;
  public article: Article;
  public artArticleId: Article;
  public articleDetailData: ArticleDetail;
  public business: Business;
  public articleRelarionaData: ArticleRelational;
  public groupSelect;
  public sectionSelect;
  public subSectionSelect;
  public subSection: SubSection;
  public articleRelational: any;
  public articleDetailList: any;
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
              public articleService: ArticleService, public bussineService: BussineService,
              public groupProductService: GroupProductService, public sectionService: SectionService,
              public subSectionService: SubSectionService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.artArticleId = new Article();
    this.dataService.redirectTypeUser();
    this.isEditForm = true;
    this.formValidateModal();
    this.getListBussine();
    this.getArticleList();
    this.groupSelect = [
      {value: '', label: ''}
    ];
    this.sectionSelect = [
      {value: '', label: ''}
    ];
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
      businessId: [ '', Validators.compose([
        Validators.required
      ])],
      articleId: [ '', Validators.compose([
        Validators.required
      ])],
      artArticleId: [ '', Validators.compose([
        Validators.required
      ])],
      groupId: ['', Validators.compose([
        Validators.required
      ])],
      sectionId: ['', Validators.compose([
        Validators.required
      ])],
      subSectionId: ['', Validators.compose([
        Validators.required
      ])],
      nameAr: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      codigoAr: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      detailAr: ['', Validators.compose([
        Validators.required,
        Validators.minLength(10),
      ])],
      imageMainAr: ['', Validators.compose([
        Validators.required
      ])],
      typeImageArticle: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      nombreImageActicle: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
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

  public getArticleList() {
    this.articleService.getArticleList()
      .subscribe(result => {
        this.articleSelect = result;
      });
  }
  public onSubSelectArticle(subSectionId) {
    console.log(subSectionId.value);

     this.articleDetailService.getSubSectionListArticle(subSectionId.value)
       .subscribe( result => {
         const listIdArticle = [];
         result.forEach(function(sectioninforData) {
           listIdArticle.push(sectioninforData + '');
         });
         this.form.controls['articleId'].setValue(listIdArticle);
       });



  }
  public onSelectArticle(event) {
    this.articleService.getArticleId(event.value)
      .subscribe( result => {
        this.articleDetail = result;
        this.getArticleIdRelational(event.value, this.dataService.bussineId);
      });
  }
  public getArticleIdRelational(articleId, businessId) {
    this.articleService.getArticleIdRelational(businessId, articleId )
      .subscribe(result => {
        const listRelational = [];
        result.forEach(function(sectioninforData) {
          listRelational.push(sectioninforData + '');
        });
        this.form.controls['artArticleId'].setValue(listRelational);
      });
  }
  public onSelectBussine(event) {
    this.groupProductService.getProductGroupBussineId(event.value)
      .subscribe(result => {
        this.groupSelect = result;
      }, error => {
        console.log(error);
      });
  }
  public onSelectSection(event) {
    this.sectionService.getSectionIdList(event.value)
      .subscribe(result => {
        this.sectionSelect = result;
      }, error => {
        console.log(error);
      });
  }
  public onSubSelect(event) {
    this.subSectionService.getSectionSubSectionIdList(event.value)
      .subscribe(result => {
        this.subSectionSelect = result;
      }, error => {
        console.log(error);
      });
  }

  public onSelectArticleRelational(event) { }


 public registerSubSectionArticle() {
      this.articleDetailList = [];
      this.subSection = new SubSection();
      this.subSection.subSectionId = this.form.value['subSectionId'];
      const articleIdList = this.form.value['articleId'];
      for (let i = 0; i < articleIdList.length; i++ ) {
        this.articleDetailData = new ArticleDetail();
        this.article = new Article();
        this.article.articleId =  articleIdList[i];
        this.articleDetailData.articleId = this.article;
        this.articleDetailData.subSectionId = this.subSection;
        this.articleDetailList.push(this.articleDetailData);
      }
      this.articleDetailService.addArticleDetail(this.articleDetailList)
        .subscribe( result => {

         });
  }




}
