import { Component, TemplateRef , OnInit} from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../service/dataService/data.service';
import { LoginService } from '../../../service/accounts/loginService';
import { GroupProductService } from '../../../service/product/groupProductService';
import { BussineService } from '../../../service/product/bussineService';
import { Business } from '../../../model/business/Business';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.css'],
  providers: [LoginService, GroupProductService , BussineService]
})
export class BusinessComponent implements OnInit {
  public form: FormGroup;
  public business: Business = new Business();
  public modalRefBusiness: BsModalRef;
  public options;
  public isEditForm: boolean;
  public config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  modalRef: BsModalRef;

  public dataBusiness;
  public filterQuery;
  public rowsOnPage = 10;
  public sortBy: string;
  public sortOrder: string;
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public bussineService: BussineService,
              public modalService: BsModalService, public translate: TranslateService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.filterQuery = '';
    this.sortBy = 'nameBu';
    this.sortOrder = 'asc';
    this.formValidateModal();
    this.isEditForm = true;
    this.getListBussine();
  }


  public formValidateModal() {
    this.form = this.formBuilder.group({
      businessId: ['', Validators.compose([
      ])],
      nameBu: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])]
    });
  }
  public getListBussine(): void {
    this.bussineService.getBussineList()
      .subscribe(result => {
        this.dataBusiness = result;
       }, error => {
        console.log(error );
      });
  }

  public registerBusiness() {
     if (true === this.getValidateInfo() ) {
      this.business = new Business();
      this.business.nameBu = this.form.value['nameBu'];
        this.bussineService.addBusiness(this.business)
          .subscribe(result => {
             if (result) {
              this.getListBussine();
              this.modalRefBusiness.hide();
            }
          });
    }
  }

  public editBusiness() {
     if (true === this.getValidateInfo() ) {

      this.business = new Business();
      this.business.businessId = this.form.value['businessId'];
      this.business.nameBu = this.form.value['nameBu'];
      this.bussineService.editBusiness(this.business)
        .subscribe(result => {
           if (null === result) {
             this.getListBussine();
             this.modalRefBusiness.hide();
           }
        });
    }
  }
  public remove(itemTableGroup) {
    this.business.businessId = itemTableGroup.businessId;
    this.bussineService.deleteBusiness(this.business)
      .subscribe(result => {
        if (null === result) {
          this.getListBussine();
        }
      }, error => {
        console.log(error);
      });
  }

  openModalWithClass(template: TemplateRef<any>) {
    this.isEditForm = true;
    this.form.controls['businessId'].setValue('');
    this.form.controls['nameBu'].setValue('');
    this.modalRefBusiness = this.dataService.showModal(template, this.config);
  }

  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.nameBu.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }

  public edit(itemTableBusiness, template: TemplateRef<any>) {
    this.isEditForm = false;
    this.form.controls['businessId'].setValue(itemTableBusiness.businessId + '');
    this.form.controls['nameBu'].setValue(itemTableBusiness.nameBu);
    this.modalRefBusiness = this.dataService.showModal(template, this.config);
  }
}
