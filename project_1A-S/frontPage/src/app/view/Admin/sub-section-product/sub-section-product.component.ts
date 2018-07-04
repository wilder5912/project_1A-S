import { Component, TemplateRef, OnInit } from '@angular/core';
import { DataService } from '../../../service/dataService/data.service';
import { Router} from '@angular/router';
import { Section } from '../../../model/product/Section';
import { SubSection } from '../../../model/product/SubSection';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GroupProductService } from '../../../service/product/groupProductService';
import { SectionService } from '../../../service/product/SectionService';
import { SubSectionService } from '../../../service/product/SubSectionService';
import { TranslateService } from '@ngx-translate/core';
import { BussineService } from '../../../service/product/bussineService';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';


@Component({
  selector: 'app-sub-section-product',
  templateUrl: './sub-section-product.component.html',
  styleUrls: ['./sub-section-product.component.css'],
  providers: [SectionService, BussineService, GroupProductService, SubSectionService],
})
export class SubSectionProductComponent implements OnInit {
  public form: FormGroup;
  public section: Section = new Section();
  public subSection: SubSection = new SubSection();
  public data;
  public dataSection;
  public filterQuery: string;
  public rowsOnPage: number;
  public sortBy: string;
  public sortOrder: string;
  public bussineSelect;
  public groupSelect;
  public sectionSelect;
  public groupProductSelect;
  public config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  public isEditForm: boolean;

  public modalRefSection: BsModalRef;


  constructor(private router: Router , private formBuilder: FormBuilder, public dataService: DataService,
              public bussineService: BussineService, public translate: TranslateService,
              public sectionService: SectionService, public groupProductService: GroupProductService,
              public subSectionService: SubSectionService, private modalService: BsModalService ) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.filterQuery = '';
    this.rowsOnPage = 10;
    this.sortBy = 'nameSubSection';
    this.sortOrder = 'asc';
    this.isEditForm = true;
    this.dataService.redirectTypeUser();
    this.getListBussine();
    this.dataService.urlPage = this.router.url;
    this.getSectionList();
    this.formValidateModal();
    this.groupSelect = [
      {value: '', label: ''}
    ];
    this.sectionSelect = [
      {value: '', label: ''}
    ];
    this.getSubSectionList();
  }



  getListBussine(): void {
    this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;
        this.getSectionList();
      }, error => {
        console.log(error );
      });
  }

  public getSectionList() {
    this.sectionService.getSectionList()
      .subscribe(result => {
        this.dataSection = result;
      }, error => {
        console.log(error);
      });
  }

  public getSubSectionList() {
    this.subSectionService.getSubSectionList()
      .subscribe(result => {
        this.data = result;
      }, error => {
        console.log(error);
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


  public onSubSelectBussine(event) {
    this.groupProductService.getProductGroupBussineId(event.value)
      .subscribe(result => {
        this.groupSelect = result;
      }, error => {
        console.log(error);
      });
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
      nameSubSection: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])]
    });
  }
  openModalWithClass(template: TemplateRef<any>) {
    this.isEditForm = true;
    this.form.controls['sectionId'].setValue(null);
    this.form.controls['businessId'].setValue('');
    this.form.controls['groupId'].setValue('');
    this.form.controls['sectionId'].setValue('');
    this.form.controls['subSectionId'].setValue('');
    this.form.controls['nameSubSection'].setValue('');
    this.modalRefSection = this.dataService.showModal(template, this.config);

  }

  public registerSubSection() {
    if ( null === this.form.controls.sectionId.errors && null === this.form.controls.nameSubSection.errors  ) {
      this.section = new Section();
      this.subSection = new SubSection();
      this.section.sectionId = this.form.value['sectionId'];
      this.subSection.sectionId = this.section;
      this.subSection.nameSubSection = this.form.value['nameSubSection'];
      this.subSectionService.addSubSection(this.subSection)
        .subscribe(result => {
          this.getSubSectionList();
        }, error => {
          console.log(error );
        });
      this.modalRefSection.hide();
    }
  }

  public editSubSectionInfo() {
    if ( null === this.form.controls.sectionId.errors && null === this.form.controls.nameSubSection.errors  ) {
      this.section = new Section();
      this.subSection = new SubSection();
      this.section.sectionId = this.form.value['sectionId'];
      this.subSection.sectionId = this.section;
      this.subSection.nameSubSection = this.form.value['nameSubSection'];
      this.subSection.subSectionId = this.form.value['subSectionId'];
      this.subSectionService.updateSubSection(this.subSection)
        .subscribe(result => {
          this.getSubSectionList();
        }, error => {
          console.log(error );
        });
      this.modalRefSection.hide();
    }
  }


  public remove(itemTableSection) {
    console.log(itemTableSection);

  }
  public edit(itemTableSubSection , template: TemplateRef<any>) {
    this.formValidateModal();
    this.isEditForm = false;
    this.form.controls['businessId'].setValue(itemTableSubSection.sectionId.groupId.businessId.businessId + '');
    this.form.controls['nameSubSection'].setValue(itemTableSubSection.nameSubSection + '');
    this.form.controls['subSectionId'].setValue(itemTableSubSection.subSectionId + '');
     this.groupProductService.getProductGroupBussineId(itemTableSubSection.sectionId.groupId.businessId.businessId)
      .subscribe(result => {
        this.groupSelect = result;
        this.form.controls['groupId'].setValue(itemTableSubSection.sectionId.groupId.groupId + '');
        this.getSectionId(itemTableSubSection, itemTableSubSection.sectionId.sectionId, template);
        }, error => {
        console.log(error);
      });
  }

  public getSectionId(valueId, sectionIdData, template) {
    this.sectionService.getSectionIdList(valueId.sectionId.groupId.groupId)
      .subscribe(result => {
        this.sectionSelect = result;
        this.form.controls['sectionId'].setValue(sectionIdData + '');
        this.modalRefSection = this.dataService.showModal(template, this.config);
      }, error => {
        console.log(error);
      });
  }


}
