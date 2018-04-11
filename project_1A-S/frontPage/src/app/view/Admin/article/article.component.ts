import { Component, TemplateRef, OnInit } from '@angular/core';
import { DataService } from '../../../service/dataService/data.service';
import { Router} from '@angular/router';
import { Section } from '../../../model/product/Section';
import { SubSection } from '../../../model/product/SubSection';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GroupProductService } from '../../../service/product/groupProductService';
import { SectionService } from '../../../service/product/SectionService';
import { SubSectionService } from '../../../service/product/SubSectionService';
import { ArticleDetailService } from '../../../service/product/ArticleDetailService';
import { TranslateService } from '@ngx-translate/core';
import { BussineService } from '../../../service/product/bussineService';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css'],
  providers: [SectionService, BussineService, GroupProductService, SubSectionService, ArticleDetailService]
})
export class ArticleComponent implements OnInit {

  public listArticleData;
  public filterQuery = '';
  public rowsOnPage = 10;
  public sortBy = 'email';
  public sortOrder = 'asc';
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public bussineService: BussineService,
              public translate: TranslateService, public sectionService: SectionService,
              public groupProductService: GroupProductService, public subSectionService: SubSectionService,
              public articleDetailService: ArticleDetailService, private modalService: BsModalService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.getListArticleBussine();
  }

  public getListArticleBussine() {
    this.articleDetailService.getArticleBussine()
      .subscribe(result => {
        this.listArticleData = result;
      });
  }
   public toInt(num: string) {
       return +num;
   }

   public sortByWordLength = (a: any) => {
       return a.city.length;
   }

   public redirectArticle(detailArticle){


   }
}
