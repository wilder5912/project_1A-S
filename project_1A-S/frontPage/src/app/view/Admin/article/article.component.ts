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

  private form: FormGroup;
  private section: Section = new Section();
  private subSection: SubSection = new SubSection();
  private data;
  private dataSection;
  private filterQuery = "";
  private filterQuery2 = "";
  private rowsOnPage = 10;
  private sortBy = "nameArticle";
  private sortOrder = "asc";

  private bussineSelect;
  private groupSelect;
  private sectionSelect;
  private subSectionSelect;

  private groupProductSelect;
  private config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  private isEditForm:boolean = true;

  private modalRefSection: BsModalRef;

  constructor(private router: Router , private formBuilder: FormBuilder, public dataService: DataService, public bussineService:BussineService,translate: TranslateService, public sectionService:SectionService, public groupProductService:GroupProductService  ,public subSectionService: SubSectionService,public articleDetailService:ArticleDetailService, private modalService: BsModalService ) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.getListBussine();
    this.dataService.urlPage = this.router.url;
    this.getSectionList();
    this.formValidateModal();
    this.groupSelect= [
      {value: '', label: ''}

    ];
    this.sectionSelect= [
      {value: '', label: ''}
    ];
    this.getImageArticleList();
  }

public getImageArticleList(){
  this.articleDetailService.getArticleDetailList()
    .subscribe(result => {
      this.data = result;
    //  console.log(result);
     }, error => {
      console.log(error);
    });
}



  getListBussine(): void{
    this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;
      }, error => {
        console.log(error );
      });
  }

  public getSectionList(){
    this.sectionService.getSectionList()
      .subscribe(result => {
        this.dataSection = result;
      }, error => {
        console.log(error);
      });
  }

  public getSubSectionList(){
    this.subSectionService.getSubSectionList()
      .subscribe(result => {
        this.data = result;
      }, error => {
        console.log(error);
      });
  }

  public onSelectBussine(event){
    this.groupProductService.getProductGroupBussineId(event.value)
      .subscribe(result => {
        this.groupSelect=result;
      }, error => {
        console.log(error);
      });
  }

  public onSelectSection(event){
    this.sectionService.getSectionIdList(event.value)
      .subscribe(result => {
        this.sectionSelect=result;
      }, error => {
        console.log(error);
      });
  }


  public onSubSelect(event){

    this.subSectionService.getSectionSubSectionIdList(event.value)
      .subscribe(result => {
        console.log(result,"--------");
        this.subSectionSelect=result;
      }, error => {
        console.log(error);
      });
  }


  public formValidateModal(){
    this.form = this.formBuilder.group({
      bussineId:['',Validators.compose([
        Validators.required
      ])],
      groupId:['',Validators.compose([
        Validators.required
      ])],
      sectionId:['',Validators.compose([
        Validators.required
      ])],
      subSectionId:['',Validators.compose([
        Validators.required
      ])],
      nameSubSection:['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])]
    });
  }
  openModalWithClass(template: TemplateRef<any>) {
    this.isEditForm = true;
    this.form.controls['sectionId'].setValue(null);
    this.form.controls['bussineId'].setValue('');
    this.form.controls['groupId'].setValue('');
    this.form.controls['sectionId'].setValue('');
    this.form.controls['subSectionId'].setValue('');
    this.form.controls['nameSubSection'].setValue('');
    this.modalRefSection = this.dataService.showModal(template,this.config);

  }

  public registerSubSection(){
    if( null === this.form.controls.sectionId.errors && null === this.form.controls.nameSubSection.errors  ) {
      this.section = new Section();
      this.subSection = new SubSection();
      this.section.sectionId = this.form.value['sectionId'];
      this.subSection.sectionId = this.section;
      this.subSection.nameSubSection=this.form.value['nameSubSection'];
      this.subSectionService.addSubSection(this.subSection)
        .subscribe(result => {
          this.getSubSectionList();
        }, error => {
          console.log(error );
        });
      this.modalRefSection.hide();
    }
  }

  public editSubSectionInfo(){
    if( null === this.form.controls.sectionId.errors && null === this.form.controls.nameSubSection.errors  ) {
      this.section = new Section();
      this.subSection = new SubSection();
      this.section.sectionId = this.form.value['sectionId'];
      this.subSection.sectionId = this.section;
      this.subSection.nameSubSection=this.form.value['nameSubSection'];
      this.subSection.subSectionId=this.form.value['subSectionId'];
      this.subSectionService.updateSubSection(this.subSection)
        .subscribe(result => {
          this.getSubSectionList();
        }, error => {
          console.log(error );
        });
      this.modalRefSection.hide();
    }
  }


  public remove(itemTableSection){
    console.log(itemTableSection)

  }
  public edit(itemTableSubSection ,template: TemplateRef<any>) {
    this.isEditForm = false;
    this.form.controls['bussineId'].setValue(itemTableSubSection.sectionId.groupId.bussineId.bussineId+'');
    this.form.controls['nameSubSection'].setValue(itemTableSubSection.nameSubSection+'');
    this.form.controls['subSectionId'].setValue(itemTableSubSection.subSectionId+'');
    this.groupProductService.getProductGroupBussineId(itemTableSubSection.sectionId.groupId.bussineId.bussineId)
      .subscribe(result => {
        this.groupSelect=result;
        this.form.controls['groupId'].setValue(itemTableSubSection.sectionId.groupId.groupId+'');
        this.getSectionId(itemTableSubSection.sectionId.groupId.groupId+'', itemTableSubSection.sectionId.sectionId, template);
      }, error => {
        console.log(error);
      });
  }

  public getSectionId(valueId,sectionIdData,template){

    this.sectionService.getSectionIdList(valueId)
      .subscribe(result => {
        this.sectionSelect=result;
        this.form.controls['sectionId'].setValue(sectionIdData+'');
        this.modalRefSection = this.dataService.showModal(template,this.config);

      }, error => {
        console.log(error);
      });
  }



}
