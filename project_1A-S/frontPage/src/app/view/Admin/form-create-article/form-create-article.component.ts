import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ValidateNumber } from '../../../service/validate/validateNumber.directive';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../../service/dataService/data.service';
import { BussineService } from '../../../service/product/bussineService';
import { GroupProductService } from '../../../service/product/groupProductService';
import { SectionService } from '../../../service/product/SectionService';
import { SubSectionService } from '../../../service/product/SubSectionService';
import { ArticleService } from '../../../service/product/ArticleService';
import { Article } from '../../../model/product/Article';
import { HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-form-create-article',
  templateUrl: './form-create-article.component.html',
  styleUrls: ['./form-create-article.component.css'],
  providers: [BussineService, GroupProductService, SectionService, SubSectionService , ArticleService]
})
export class FormCreateArticleComponent implements OnInit {
  @Input() articleDetail: string;
  @Input() articleDetailId: number;
  public selectedFilesArticle;
  public currentFileUpload: File;
  public selectedFiles: FileList;
  public form: FormGroup;
  public article;
  public editArticle: Article;
  public bussineSelect;
  public imageArticle;
  public groupSelect;
  public sectionSelect;
  public subSectionSelect;
  constructor(public formBuilder: FormBuilder, public translate: TranslateService,
              public dataService: DataService, public bussineService: BussineService,
              public groupProductService: GroupProductService, public sectionService: SectionService,
              public subSectionService: SubSectionService, public articleService: ArticleService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.article = this.articleDetail;
    this.imageArticle = this.article;
    this.formValidateModal();
    this.addInfoArticleForm();
    console.log(this.articleDetail);
  }

  public formValidateModal() {
    this.form = this.formBuilder.group({
      businessId: ['', Validators.compose([
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
      precyAr: ['', Validators.compose([
        Validators.required,
        Validators.minLength(1),
        ValidateNumber.verificateNumber
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
  public addInfoArticleForm() {
    this.form.controls['nameAr'].setValue(this.article.nameAr);
    this.form.controls['codigoAr'].setValue(this.article.codigoAr);
    this.form.controls['precyAr'].setValue(this.article.precyAr);
    this.form.controls['detailAr'].setValue(this.article.detailAr);
  }

  public editArticleInfo() {
    this.editArticle = new Article();
    this.editArticle.articleId = this.article.articleId;
    this.editArticle.nameAr = this.form.value['nameAr'];
    this.editArticle.codigoAr = this.form.value['codigoAr'];
    this.editArticle.precyAr = this.form.value['precyAr'];
    this.editArticle.detailAr = this.form.value['detailAr'];
    if (this.selectedFilesArticle) {
      this.currentFileUpload = this.selectedFiles.item(0);
    }
    this.articleService.editImageAndArticle(this.currentFileUpload, this.editArticle)
      .subscribe( result => {
        if (result instanceof HttpResponse) {
          this.imageArticle = JSON.parse(result.body + '');
        }
      });
   }

  selectFileOne(event) {
    this.selectedFilesArticle = true;
    const file = event.target.files.item(0);
    if (file.type.match('image.*')) {
      this.selectedFiles = event.target.files;
    } else {
      console.log('formato invalido');
    }
  }



}
