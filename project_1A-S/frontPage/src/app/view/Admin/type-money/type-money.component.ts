import { Component, TemplateRef , OnInit} from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { BussineService } from '../../../service/product/bussineService';
import { ValidateNumber } from '../../../service/validate/validateNumber.directive';
import { TypeMoney } from '../../../model/typeMoney/TypeMoney';
import { Business } from '../../../model/business/Business';
import { TypeMoneyService } from '../../../service/typeMoney/TypeMoneyService';

@Component({
  selector: 'app-type-money',
  templateUrl: './type-money.component.html',
  styleUrls: ['./type-money.component.css'],
  providers: [BussineService, TypeMoneyService]
})
export class TypeMoneyComponent implements OnInit {
  public form: FormGroup;
  public modalRefTypeMoney: BsModalRef;
  public isEditForm: boolean;
  public config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  public bussineSelect;
  public typeMoney: TypeMoney;
  public business: Business;

  public filterQuery;
  public rowsOnPage = 10;
  public sortBy: string;
  public sortOrder: string;
  public moneyTypeList;

  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, public bussineService: BussineService,
              public typeMoneyService: TypeMoneyService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.isEditForm = true;
    this.filterQuery = '';
    this.sortBy = 'typeMoneyId';
    this.sortOrder = 'asc';

    this.typeMoney = new TypeMoney();
    this.business = new Business();
    this.getListBussine();
    this.formValidateModal();
    this.getListTypeMoney(1);
  }
  openModalWithClass(template: TemplateRef<any>) {
    this.isEditForm = true;
  /*  this.form.controls['warehouseId'].setValue('');*/
    this.modalRefTypeMoney = this.dataService.showModal(template, this.config);
  }


  public formValidateModal() {
    this.form = this.formBuilder.group({
      typeMoneyId: ['', Validators.compose([
      ])],
      businessId: [ '', Validators.compose([
        Validators.required
      ])],
      nameTypeMoney: ['', Validators.compose([
        Validators.required,
        Validators.minLength(1)
      ])],
      typeChangeTypemoney: ['', Validators.compose([
        Validators.required,
        Validators.minLength(1),
        ValidateNumber.verificateNumber
       ])]
    });
  }
  getListBussine(): void {
    this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;
        this.getListTypeMoney(1);
      }, error => {
        console.log(error );
      });
  }

  public registerWarehouse() {
    this.isEditForm = true;
    if (true === this.getValidateInfo() ) {
      this.typeMoney = new TypeMoney();
      this.business = new Business();
      this.business.businessId = this.form.value['businessId'];
      this.typeMoney.businessId = this.business;
      this.typeMoney.nameTypeMoney = this.form.value['nameTypeMoney'];
      this.typeMoney.typeChangeTypemoney = this.form.value['typeChangeTypemoney'];

     this.typeMoneyService.addTypeMoney(this.typeMoney)
        .subscribe(result => {
          this.getListTypeMoney(this.form.value['businessId']);
          this.modalRefTypeMoney.hide();
        });
    }
  }
  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.businessId.errors},
      {'SectionInformation': this.form.controls.nameTypeMoney.errors},
      {'SectionInformation': this.form.controls.typeChangeTypemoney.errors},
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }
  public getListTypeMoney(idBusiness: number) {
    this.typeMoneyService.listMoneyBusinessId(idBusiness)
      .subscribe(result => {
        this.moneyTypeList = result;
       });
  }
  onSelectBussine(event) {
    this.dataService.bussineId = event.value;
    this.getListTypeMoney(this.dataService.bussineId);
  }

  public edit(itemTableBusiness: TypeMoney , template: TemplateRef<any>) {
    this.isEditForm = false;
    this.formValidateModal();
    this.form.controls['typeMoneyId'].setValue(itemTableBusiness.typeMoneyId + '');
    this.form.controls['businessId'].setValue(itemTableBusiness.businessId.businessId + '');
    this.form.controls['nameTypeMoney'].setValue(itemTableBusiness.nameTypeMoney + '');
    this.form.controls['typeChangeTypemoney'].setValue(itemTableBusiness.typeChangeTypemoney + '');
    this.modalRefTypeMoney = this.dataService.showModal(template, this.config);
  }


  public updatetypeMoney() {
    if (true === this.getValidateInfo() ) {
      this.typeMoney = new TypeMoney();
      this.business = new Business();
      this.business.businessId = this.form.value['businessId'];
      this.typeMoney.businessId = this.business;
      this.typeMoney.typeMoneyId = this.form.value['typeMoneyId'];
      this.typeMoney.nameTypeMoney = this.form.value['nameTypeMoney'];
      this.typeMoney.typeChangeTypemoney = this.form.value['typeChangeTypemoney'];
      this.typeMoneyService.editTypeMoney(this.typeMoney)
        .subscribe(result => {
          this.getListTypeMoney(this.form.value['businessId']);
        });
    }
  }

  public remove(itemTableSection: TypeMoney) {
      this.typeMoney = new TypeMoney();
      this.typeMoney.typeMoneyId = itemTableSection.typeMoneyId;
      this.typeMoneyService.deleteTypeMoney(this.typeMoney)
        .subscribe(result => {
          this.getListTypeMoney(this.dataService.bussineId);
        });
  }

}
