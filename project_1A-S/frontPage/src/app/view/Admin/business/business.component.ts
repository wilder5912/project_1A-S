import { Component, TemplateRef , OnInit} from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../service/dataService/data.service';
import { LoginService } from '../../../service/accounts/loginService';
import { GroupProductService } from '../../../service/product/groupProductService';
import { BussineService } from '../../../service/product/bussineService';
import { User } from '../../../model/usuario/User';
import { GroupProduct } from '../../../model/product/GroupProduct';
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
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public bussineService: BussineService,
              public modalService: BsModalService, public translate: TranslateService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.formValidateModal();
    this.isEditForm = true;
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


  public registerBusiness() {
    /*if (null === this.form.controls.nameGroup.errors && null === this.form.controls.bussineId.errors ) {
      this.groupProduct.nameGroup = this.form.value['nameGroup'];
      this.bussine.bussineId = this.form.value['bussineId'];
      this.groupProduct.bussineId = this.bussine;
      this.groupProductService.addProductGroup(this.groupProduct)
        .subscribe(result => {
          if (result) {
            this.getListProduct();
            this.groupProduct.nameGroup = '';
          }
        }, e => {
          console.log('' + e);
        });
      this.modalRefProductGroup.hide();
    }*/
  }

  public editBusiness() {
    /*if (null === this.form.controls.nameGroup.errors && null === this.form.controls.bussineId.errors ) {
      this.groupProduct.groupId = this.form.value['groupId'];
      this.groupProduct.nameGroup = this.form.value['nameGroup'];
      this.bussine.bussineId = this.form.value['bussineId'];
      this.groupProduct.bussineId = this.bussine;
      this.groupProductService.editProductGroup(this.groupProduct)
        .subscribe(result => {
          if (result) {
            this.getListProduct();
          }
        }, error => {
          console.log(error);
        });
      this.modalRefProductGroup.hide();
    }*/
  }
  openModalWithClass(template: TemplateRef<any>) {
   /* this.isEditForm = true;
    this.form.controls['bussineId'].setValue('1');
    this.form.controls['groupId'].setValue('');
    this.form.controls['nameGroup'].setValue('');
   */ this.modalRefBusiness = this.dataService.showModal(template, this.config);
  }

}
