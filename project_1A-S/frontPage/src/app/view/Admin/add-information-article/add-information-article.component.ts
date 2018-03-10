import { Component, TemplateRef , OnInit , ViewChild} from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../../service/dataService/data.service';
import { ArticleDetailService } from '../../../service/product/ArticleDetailService';
import { ArticleService } from '../../../service/product/ArticleService';
import { BussineService } from '../../../service/product/bussineService';
import { Article } from '../../../model/product/Article';
import { Bussine } from '../../../model/bussine/Bussine';
import { Information } from '../../../model/product/Information';
import { ArticleRelational } from '../../../model/product/ArticleRelational';
import { InformationService } from '../../../service/product/InformacionService';

@Component({
  selector: 'app-add-information-article',
  templateUrl: './add-information-article.component.html',
  styleUrls: ['./add-information-article.component.css'],
  providers: [ ArticleService, ArticleDetailService, BussineService, InformationService]
})
export class AddInformationArticleComponent implements OnInit {
  public form: FormGroup;
  public isEditForm;
  public articleSelect;
  public articleDetail;
  public bussineSelect;
  public article: Article;
  public information: Information;
  public artArticleId: Article = new Article();
  public bussine: Bussine;
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
              private modalService: BsModalService , public dataService: DataService ,
              public articleDetailService: ArticleDetailService ,
              public articleService: ArticleService, public bussineService: BussineService ,
              public informationService: InformationService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.isEditForm = true;
    this.formValidateModal();
    this.getListBussine();
  }

  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.articleId.errors},
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

  public formValidateModal() {
    this.form = this.formBuilder.group({
      bussineId: [ '', Validators.compose([
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
    this.form.controls['nameInformation'].setValue('');
    this.form.controls['detailInformation'].setValue('');
    this.article = new Article();
    this.article.articleId = event.value;
    this.articleService.getArticleDetailData(this.article)
      .subscribe( result => {
        this.articleDetail = result;
         });
  }

  public onSelectBussine(event) {
    this.dataService.bussineId = event.value;
    this.getSelectArticle();
  }

  public onSelectArticleRelational(event) { }


  public registerRelationalArticle() {
    if (this.getValidateInfo()) {
      this.information = new Information();
      this.article = new Article();
      this.article.articleId = this.form.value['articleId'];
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

  public getArticle(article) {
    this.articleService.getArticleDetailData(article)
      .subscribe( result => {
        this.articleDetail = result;
      });
  }

}
