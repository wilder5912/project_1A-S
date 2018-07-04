import { Component, OnInit, Input , TemplateRef } from '@angular/core';
import { DataService } from '../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { Information } from '../../../model/product/Information';
import { Article } from '../../../model/product/Article';
import { InformationService } from '../../../service/product/InformacionService';
import { ArticleService } from '../../../service/product/ArticleService';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

@Component({
  selector: 'app-form-list-article-information',
  templateUrl: './form-list-article-information.component.html',
  styleUrls: ['./form-list-article-information.component.css'],
  providers: [InformationService, ArticleService]
})
export class FormListArticleInformationComponent implements OnInit {
  @Input() articleDetailData: string;
  @Input() articleDetailId: number;
  public articleSelect;
  public form: FormGroup;
  public isEditForm: boolean;
  public information: Information;
  public article: Article;
  public articleDetail;
  public modalRef: BsModalRef;
  config = {
    backdrop: true,
    ignoreBackdropClick: true,
    class: 'modal-lg'
  };
  constructor(public dataService: DataService, public formBuilder: FormBuilder,
              public translate: TranslateService, public informationService: InformationService,
              public articleService: ArticleService, private modalService: BsModalService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.articleDetail = this.articleDetailData;
    this.formValidateModal();
    this.isEditForm = true;
  }
  public formValidateModal() {
    this.form = this.formBuilder.group({
      businessId: [ '', Validators.compose([
        Validators.required
      ])],
      articleId: [ '', Validators.compose([
        Validators.required
      ])],
      nameInformation: [ '', Validators.compose([
        Validators.required
      ])],
      detailInformation: [ '', Validators.compose([
        Validators.required
      ])]
    });
  }


  public registerInformationArticle() {
    if (this.getValidateInfo()) {
      this.information = new Information();
      this.article = new Article();
      this.article.articleId = this.articleDetail.articleId;
      this.information.articleId = this.article;
      this.information.nameInformation = this.form.value['nameInformation'];
      this.information.detailInformation = this.form.value['detailInformation'];

      this.informationService.addInformationArticle(this.information)
        .subscribe(result => {
          this.getArticle(this.article);
          this.form.controls['nameInformation'].setValue('');
          this.form.controls['detailInformation'].setValue('');
        });
    }
  }
  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.nameInformation.errors},
      {'SectionInformation': this.form.controls.detailInformation.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }
  public getArticle(article) {
    this.articleService.getArticleDetailData(article)
      .subscribe( result => {
        this.articleDetail = result;
      });
  }

  public removeInformation(itemInfo) {
    console.log(itemInfo);
    this.informationService.deleteInformationArticle(itemInfo.informationId)
      .subscribe( result => {
        this.article = new Article();
        this.article.articleId = this.articleDetail.articleId;
        this.getArticle(this.article);
      });
  }
  public editSubSectionInfo() {
    this.article = new Article();
    this.article.articleId = this.articleDetail.articleId;
    this.information.articleId = this.article;
    this.information.nameInformation = this.form.value['nameInformation'];
    this.information.detailInformation = this.form.value['detailInformation'];
    this.informationService.editInformationArticle(this.information)
      .subscribe( result => {
        this.article = new Article();
        this.article.articleId = this.articleDetail.articleId;
        this.getArticle(this.article);
        this.closeFirstModal();
      });
  }


  public openModalEdit(template: TemplateRef<any>, informationArticle) {
    this.modalRef = this.modalService.show(template, this.config);
    this.form.controls['nameInformation'].setValue(informationArticle.nameInformation);
    this.form.controls['detailInformation'].setValue(informationArticle.detailInformation);
    this.information = new Information();
    this.information.informationId = informationArticle.informationId;
    this.article = new Article();
    this.article.articleId = this.articleDetail.articleId;
    this.information.articleId = this.article;
    this.information.nameInformation = this.form.value['nameInformation'];
    this.information.detailInformation = this.form.value['detailInformation'];

  }

  public closeFirstModal() {
    this.modalRef.hide();
    this.modalRef = null;
    this.form.controls['nameInformation'].setValue('');
    this.form.controls['detailInformation'].setValue('');
  }

}
