import { Component, TemplateRef, OnInit} from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../service/dataService/data.service';
import { LoginService } from '../../../service/accounts/loginService';
import { GroupProductService } from '../../../service/product/groupProductService';
import { SectionService } from '../../../service/product/SectionService';
import { BussineService } from '../../../service/product/bussineService';
import { Section } from '../../../model/product/Section';
import { Bussine } from '../../../model/bussine/Bussine';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import {GroupProduct} from '../../../model/product/GroupProduct';

@Component({
  selector: 'app-section-product',
  templateUrl: './section-product.component.html',
  styleUrls: ['./section-product.component.css'],
  providers: [LoginService, SectionService, BussineService, GroupProductService],
})
export class SectionProductComponent implements OnInit {
  public form: FormGroup;
  public groupProduct: GroupProduct = new GroupProduct();
  public bussine: Bussine = new Bussine();
  public isEditForm: boolean;
  public modalRefSection: BsModalRef;
  public bussineSelect;
  public groupSelect;
  public config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  public section: Section = new Section();
  public data;
  public filterQuery = '';
  public rowsOnPage: number;
  public sortBy: string;
  public sortOrder: string;

  constructor(private router: Router , private formBuilder: FormBuilder, public dataService: DataService,
              public bussineService: BussineService, public translate: TranslateService,
              public loginService: LoginService, public sectionService: SectionService,
              public groupProductService: GroupProductService,
              private modalService: BsModalService ) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.filterQuery = '';
    this.rowsOnPage = 10;
    this.sortBy = 'nameSection';
    this.sortOrder = 'asc';
    this.isEditForm = true;
    this.dataService.redirectTypeUser();
    this.getListBussine();
    this.dataService.urlPage = this.router.url;
    this.getSectionList();
    this.formValidateModal();
    this.groupSelect = [
      {value: '', label: ''},
    ];
  }

public getSectionList() {
  this.sectionService.getSectionList()
    .subscribe(result => {
      this.data = result;
    }, error => {
      console.log(error);
    });
}

public getListBussine(): void {
    this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;
        this.getSectionList();
      }, error => {
        console.log(error );
      });
  }

  public formValidateModal() {
    this.form = this.formBuilder.group({
      sectionId: [ '', Validators.compose([
      ])],
      bussineId: [ '', Validators.compose([
        Validators.required
      ])],
      groupId: [ '', Validators.compose([
        Validators.required
      ])],
      nameSection: [ '', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])]
    });
  }

  public registerSection() {
   if (null === this.form.controls.bussineId.errors && null === this.form.controls.groupId.errors &&
     null === this.form.controls.nameSection.errors  ) {
      this.section = new Section();
      this.groupProduct.groupId = this.form.value['groupId'];
      this.section.nameSection = this.form.value['nameSection'];
      this.section.groupId = this.groupProduct;
      this.sectionService.addSection(this.section)
        .subscribe(result => {
          this.getSectionList();
        }, error => {
          console.log(error );
        });
      this.modalRefSection.hide();
    }
  }

 public onSelectBussine(event) {
   this.groupProductService.getProductGroupBussineId(event.value)
      .subscribe(result => {
        this.groupSelect = result;
      }, error => {
        console.log(error);
      });
  }
public onSelectGroup(event) {
    console.log(event);
}

  openModalWithClass(template: TemplateRef<any>) {
    this.isEditForm = true;
    this.form.controls['sectionId'].setValue(null);
    this.form.controls['bussineId'].setValue('');
    this.form.controls['groupId'].setValue('');
    this.form.controls['nameSection'].setValue('');
    this.modalRefSection = this.dataService.showModal(template, this.config);
  }

  public remove(itemTableSection) {
    this.sectionService.deleteSectionId(itemTableSection.sectionId)
      .subscribe(result => {
        if (result) {
          this.getSectionList();
        }
      } , error => {
        console.log(error);
      });

}
public edit(itemTableSection, template: TemplateRef<any>) {
   this.isEditForm = false;
  this.form.controls['sectionId'].setValue(itemTableSection.sectionId + '');
  this.form.controls['bussineId'].setValue(itemTableSection.groupId.bussineId.bussineId + '');

  this.groupProductService.getProductGroupBussineId(itemTableSection.groupId.bussineId.bussineId)
    .subscribe(result => {
      this.groupSelect = result;
      this.form.controls['groupId'].setValue(itemTableSection.groupId.groupId + '');
      this.form.controls['nameSection'].setValue(itemTableSection.nameSection);
      this.modalRefSection = this.dataService.showModal(template, this.config);
    }, error => {
      console.log(error);
    });
}

  public editSectionInfo() {
    if (null === this.form.controls.bussineId.errors && null === this.form.controls.groupId.errors &&
      null === this.form.controls.nameSection.errors  ) {
      this.section = new Section();
      this.section.sectionId = this.form.value['sectionId'];
      this.groupProduct.groupId = this.form.value['groupId'];
      this.section.nameSection = this.form.value['nameSection'];
      this.section.groupId = this.groupProduct;
      this.sectionService.updateSection(this.section)
        .subscribe(result => {
          this.getSectionList();
        }, error => {
          console.log(error );
        });
      this.modalRefSection.hide();
    }
  }

  public toInt(num: string) {
    return +num;
  }
  public sortByWordLength = (a: any) => {
    return a.city.length;
  }


}
