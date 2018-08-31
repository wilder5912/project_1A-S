import { Component, TemplateRef , OnInit} from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { BussineService } from '../../../../service/product/bussineService';
import { ArticleService } from '../../../../service/product/ArticleService';
import { ProviderService } from '../../../../service/product/ProviderService';
import { ArticleRelational } from '../../../../model/product/ArticleRelational';
import { ArticleDetailService } from '../../../../service/product/ArticleDetailService';
import { WarehouseService } from '../../../../service/warehouse/warehouseService';
import { WareHouseMainService } from '../../../../service/warehouse/WareHouseMainService';
import { Provider } from '../../../../model/provider/Provider';
import { Business } from '../../../../model/business/Business';
import { ArticleDetail } from '../../../../model/product/ArticleDetail';
import { Warehouse } from '../../../../model/warehouse/Warehouse';
import { WareHouseMain } from '../../../../model/warehouse/WareHouseMain';
import { ArticleProvider } from '../../../../model/provider/ArticleProvider';

import { ValidateNumber } from '../../../../service/validate/validateNumber.directive';
@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.css'],
  providers: [ ArticleService, ArticleDetailService, BussineService, WarehouseService, ProviderService, WareHouseMainService]
})
export class WarehouseComponent implements OnInit {


  public form: FormGroup;
  public modalRefWarehouser: BsModalRef;
  public options;
  public isEditForm: boolean;

  public config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  modalRef: BsModalRef;

  public dataProvider;
  public filterQuery;
  public rowsOnPage = 10;
  public sortBy: string;
  public sortOrder: string;
  public bussineSelect;
  public articleSelect;
  public providerSelect;
  public provider: Provider;
  public business: Business;
  public articleDetail: ArticleDetail;
  public warehouse: Warehouse;
  public wareHouseMain: WareHouseMain;
  public articleProvider: ArticleProvider;
  public warehouseList;

  public dataWarehouser;

  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, public bussineService: BussineService, public articleDetailService: ArticleDetailService ,
              public articleService: ArticleService, public warehouseService: WarehouseService, public providerService: ProviderService,
              public wareHouseMainService: WareHouseMainService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.filterQuery = '';
    this.sortBy = 'warehouseId';
    this.sortOrder = 'asc';
    this.formValidateModal();
    this.isEditForm = true;
    this.getListBussine();
    this.getListWarehouse();
    this.getProviderCode();
    this.getListWareHouse();
  }


  public formValidateModal() {
    this.form = this.formBuilder.group({
      warehouseId: ['', Validators.compose([
      ])],
      businessId: [ '', Validators.compose([
        Validators.required
      ])],
      articleDetailId: ['', Validators.compose([
        Validators.required
      ])],
      quantytiProviderWarehouse: ['', Validators.compose([
        Validators.required,
        Validators.minLength(1),
      ])],
      articleProviderId: ['', Validators.compose([
      ])],
      codeArticleprovider: ['', Validators.compose([
        Validators.required,
        Validators.minLength(2)
      ])],
      nameArticleprovider: ['', Validators.compose([
        Validators.required,
        Validators.minLength(2)
      ])],
      providerId: ['', Validators.compose([
        Validators.required,
        Validators.minLength(1),
      ])],
      fatureWarehouse: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      dateStartWarehouse: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      dateEndWarehouse: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      wnameId: ['', Validators.compose([
        Validators.required
      ])],
    });
  }

  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.businessId.errors},
      {'SectionInformation': this.form.controls.articleDetailId.errors},
      {'SectionInformation': this.form.controls.wnameId.errors},
      {'SectionInformation': this.form.controls.quantytiProviderWarehouse.errors},
      {'SectionInformation': this.form.controls.codeArticleprovider.errors},
      {'SectionInformation': this.form.controls.nameArticleprovider.errors},
      {'SectionInformation': this.form.controls.providerId.errors},
      {'SectionInformation': this.form.controls.fatureWarehouse.errors},
      {'SectionInformation': this.form.controls.dateStartWarehouse.errors},
      {'SectionInformation': this.form.controls.dateEndWarehouse.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }

  openModalWithClass(template: TemplateRef<any>) {
    this.isEditForm = true;
    this.form.controls['businessId'].setValue('');
    this.form.controls['articleDetailId'].setValue('');
    this.form.controls['wnameId'].setValue('');
    this.form.controls['articleProviderId'].setValue('');
    this.form.controls['quantytiProviderWarehouse'].setValue('');
    this.form.controls['codeArticleprovider'].setValue('');
    this.form.controls['nameArticleprovider'].setValue('');
    this.form.controls['providerId'].setValue('');
    this.form.controls['fatureWarehouse'].setValue('');
    this.form.controls['dateStartWarehouse'].setValue('');
    this.form.controls['dateEndWarehouse'].setValue('');
    this.form.controls['warehouseId'].setValue('');
    this.modalRefWarehouser = this.dataService.showModalBig(template, this.config);
  }
  getListBussine(): void {
    this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;
      }, error => {
        console.log(error );
      });
  }
/*  getListBusiness(businessId: number, articleBusiness: number ): void {
    this.form.controls['businessId'].setValue(businessId + '');
    this.getSelectArticleBusiness(businessId, articleBusiness);
   /!* this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;

      }, error => {
        console.log(error );
      });*!/
  }*/

  onSelectBussine(event) {
    this.dataService.bussineId = event.value;
    this.getSelectArticle();
  }
  public getSelectArticle() {
    this.articleDetailService.getArticleDetailIdBussine(this.dataService.bussineId)
      .subscribe(result => {
        this.articleSelect = result;
      });
  }
  public getSelectArticleBusiness(businessId: number, articleBusiness: number) {
    this.articleDetailService.getArticleDetailIdBussine(businessId)
      .subscribe(result => {
      if ( null !== result ) {
        this.articleSelect = result;
        this.form.controls['articleDetailId'].setValue(articleBusiness + '');


      }


      });
  }
  public getListWarehouse() {
      this.wareHouseMainService.listWarehouseCodeMain()
        .subscribe(result => {
          this.warehouseList = result;
        });
  }

  public getProviderCode() {
    this.providerService.listProviderDTO()
      .subscribe(result => {
        this.providerSelect = result;
      });
  }

  public getListWareHouse() {
   this.warehouseService.listWarehouse()
     .subscribe( result => {
      this.dataWarehouser = result;
     });
  }

  public registerWarehouse() {
        this.isEditForm = true;
    if (true === this.getValidateInfo() ) {
      this.provider = new Provider();
      this.provider.providerId = this.form.value['providerId'];
      this.articleProvider = new ArticleProvider();
      this.articleProvider.codeArticleProvider = this.form.value['codeArticleprovider'];
      this.articleProvider.nameArticleProvider = this.form.value['nameArticleprovider'];
      this.wareHouseMain = new WareHouseMain();
      this.wareHouseMain.wnameId = this.form.value['wnameId'];
      this.wareHouseMain.isDelete = false;
      this.business = new Business();
      this.business.businessId = this.form.value['businessId'];
      this.articleDetail = new ArticleDetail();
      this.articleDetail.articleDetailId = this.form.value['articleDetailId'];
      this.warehouse = new Warehouse();
      this.warehouse.providerId = this.provider;
      this.warehouse.businessId = this.business;
      this.warehouse.articleDetailId = this.articleDetail;
      this.warehouse.articleProviderId  =  this.articleProvider;
      this.warehouse.wnameId  =  this.wareHouseMain;
      this.warehouse.dateStartWarehouse = this.form.value['dateStartWarehouse'];
      this.warehouse.dateEndWarehouse = this.form.value['dateEndWarehouse'];
      this.warehouse.fatureWarehouse = this.form.value['fatureWarehouse'];
      this.warehouse.quantytiProviderWarehouse = this.form.value['quantytiProviderWarehouse'];
      this.warehouse.quantytiCurrectWarehouse = this.form.value['quantytiProviderWarehouse'];
      this.warehouseService.addWarehouse(this.warehouse)
        .subscribe(result => {
          this.getListWareHouse();
          this.modalRefWarehouser.hide();
        });
    }
  }

  public updateWarehouse() {
    if (true === this.getValidateInfo() ) {
      this.provider = new Provider();
      this.provider.providerId = this.form.value['providerId'];
      this.articleProvider = new ArticleProvider();
      this.articleProvider.articleProviderId = this.form.value['articleProviderId'];
      this.articleProvider.codeArticleProvider = this.form.value['codeArticleprovider'];
      this.articleProvider.nameArticleProvider = this.form.value['nameArticleprovider'];
      this.wareHouseMain = new WareHouseMain();
      this.wareHouseMain.wnameId = this.form.value['wnameId'];
      this.wareHouseMain.isDelete = false;
      this.business = new Business();
      this.business.businessId = this.form.value['businessId'];
      this.articleDetail = new ArticleDetail();
      this.articleDetail.articleDetailId = this.form.value['articleDetailId'];
      this.warehouse = new Warehouse();
      this.warehouse.warehouseId = this.form.value['warehouseId']
      this.warehouse.providerId = this.provider;
      this.warehouse.businessId = this.business;
      this.warehouse.articleDetailId = this.articleDetail;
      this.warehouse.articleProviderId  =  this.articleProvider;
      this.warehouse.wnameId  =  this.wareHouseMain;
      this.warehouse.dateStartWarehouse = this.form.value['dateStartWarehouse'];
      this.warehouse.dateEndWarehouse = this.form.value['dateEndWarehouse'];
      this.warehouse.fatureWarehouse = this.form.value['fatureWarehouse'];
      this.warehouse.quantytiProviderWarehouse = this.form.value['quantytiProviderWarehouse'];
      this.warehouseService.editWarehouse( this.warehouse)
        .subscribe( result => {
          this.getListWareHouse();
          this.modalRefWarehouser.hide();
        });
    }
  }

  public edit(itemTableBusiness: Warehouse , template: TemplateRef<any>) {
    this.isEditForm = false;
    this.formValidateModal();
    this.form.controls['businessId'].setValue(itemTableBusiness.businessId.businessId + '');
    this.articleDetailService.getArticleDetailIdBussine(itemTableBusiness.businessId.businessId)
      .subscribe(result => {
        this.articleSelect = result;
        if ( null !== result ) {
          this.form.controls['articleDetailId'].setValue( itemTableBusiness.articleDetailId.articleDetailId + '');
          this.form.controls['wnameId'].setValue(itemTableBusiness.wnameId.wnameId + '');
          this.form.controls['articleProviderId'].setValue(itemTableBusiness.articleProviderId.articleProviderId + '');
          this.form.controls['quantytiProviderWarehouse'].setValue(itemTableBusiness.quantytiProviderWarehouse + '');
          this.form.controls['codeArticleprovider'].setValue(itemTableBusiness.articleProviderId.codeArticleProvider + '');
          this.form.controls['nameArticleprovider'].setValue(itemTableBusiness.articleProviderId.nameArticleProvider + '');
          this.form.controls['providerId'].setValue(itemTableBusiness.providerId.providerId + '');
          this.form.controls['fatureWarehouse'].setValue(itemTableBusiness.fatureWarehouse + '');
          this.form.controls['dateStartWarehouse'].setValue(itemTableBusiness.dateStartWarehouse + '');
          this.form.controls['dateEndWarehouse'].setValue(itemTableBusiness.dateEndWarehouse + '');
          this.form.controls['warehouseId'].setValue(itemTableBusiness.warehouseId + '');
          this.modalRefWarehouser = this.dataService.showModalBig(template, this.config);
        }
      });
  }

  public remove(itemTableSection: Warehouse) {
    this.warehouse = new Warehouse();
    this.warehouse.warehouseId = itemTableSection.articleProviderId.articleProviderId;
    this.warehouseService.deleteWarehouse(this.warehouse)
      .subscribe(result => {
        this.getListWareHouse();
      } , error => {
        console.log(error);
      });
  }
}
