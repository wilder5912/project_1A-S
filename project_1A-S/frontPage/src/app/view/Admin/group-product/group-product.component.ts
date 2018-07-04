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
  selector: 'app-group-product',
  templateUrl: './group-product.component.html',
  styleUrls: ['./group-product.component.css'],
  providers: [LoginService, GroupProductService , BussineService ]

})
export class GroupProductComponent implements OnInit {
  public form: FormGroup;
  public user: User = new User();
  public groupProduct: GroupProduct = new GroupProduct();
  public business: Business = new Business();
  public modalRefProductGroup: BsModalRef;
  public options;
  public isEditForm: boolean;
  public config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  modalRef: BsModalRef;
  public data;
  public filterQuery;
  public rowsOnPage = 10;
  public sortBy: string;
  public sortOrder: string;
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public bussineService: BussineService,
              public translate: TranslateService, public loginService: LoginService,
              public groupProductService: GroupProductService, private modalService: BsModalService ) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }
  ngOnInit() {
    this.isEditForm = true;
    this.filterQuery = '';
    this.sortBy = 'nameGroup';
    this.sortOrder = 'asc';
    this.dataService.redirectTypeUser();
    this.dataService.urlPage = this.router.url;
    this.getListProduct();
    this.getListBussine();
  }

  openModal(template: TemplateRef<any>) {
    this.modalRefProductGroup = this.modalService.show(template, this.config);
  }
  openModalWithClass(template: TemplateRef<any>) {
        this.isEditForm = true;
        this.form.controls['businessId'].setValue('1');
        this.form.controls['groupId'].setValue('');
        this.form.controls['nameGroup'].setValue('');
        this.modalRefProductGroup = this.dataService.showModal(template, this.config);
  }

  getListProduct(): void {
    this.groupProductService.getGroupProduct()
      .subscribe(result => {
        this.data = result;
      }, error => {
        console.log(error);
      });
 }
 getListBussine(): void {
    this.bussineService.getBussine()
      .subscribe(result => {
        this.options = result;
        this.formValidateModal();
      }, error => {
        console.log(error );
      });
 }
 public formValidateModal() {
   this.form = this.formBuilder.group({
     groupId: ['', Validators.compose([
     ])],
     nameGroup: ['', Validators.compose([
       Validators.required,
       Validators.minLength(3),
     ])],
     businessId: ['', Validators.compose([
       Validators.required
     ])]
   });
 }

  public toInt(num: string) {
    return +num;
  }
  public sortByWordLength = (a: any) => {
    return a.city.length;
  }

  public registerGroup() {
  if (null === this.form.controls.nameGroup.errors && null === this.form.controls.businessId.errors ) {
        this.groupProduct.nameGroup = this.form.value['nameGroup'];
        this.business.businessId = this.form.value['businessId'];
        this.groupProduct.businessId = this.business;
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
      }
  }

  public editGroupInfo() {
    if (null === this.form.controls.nameGroup.errors && null === this.form.controls.businessId.errors ) {
      this.groupProduct.groupId = this.form.value['groupId'];
      this.groupProduct.nameGroup = this.form.value['nameGroup'];
      this.business.businessId = this.form.value['businessId'];
      this.groupProduct.businessId = this.business;
      this.groupProductService.editProductGroup(this.groupProduct)
        .subscribe(result => {
          if (result) {
            this.getListProduct();
          }
        }, error => {
          console.log(error);
        });
      this.modalRefProductGroup.hide();
    }
  }

  public remove(itemTableGroup) {
      this.groupProduct.groupId = itemTableGroup.groupId;
      this.groupProductService.deleteProductGroup(this.groupProduct)
        .subscribe(result => {
          if (result) {
            this.getListProduct();
          }
        }, error => {
          console.log(error);
        });
  }
  public edit(itemTableGroup, template: TemplateRef<any>) {
    this.isEditForm = false;
    this.form.controls['businessId'].setValue(itemTableGroup.businessId.businessId + '');
    this.form.controls['groupId'].setValue(itemTableGroup.groupId);
    this.form.controls['nameGroup'].setValue(itemTableGroup.nameGroup);
    this.modalRefProductGroup = this.dataService.showModal(template, this.config);
  }
}





