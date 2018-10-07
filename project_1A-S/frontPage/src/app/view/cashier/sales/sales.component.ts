import { Component, TemplateRef, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { ActivatedRoute } from '@angular/router';
import { Article } from '../../../model/product/Article';
import { SubSection } from '../../../model/product/SubSection';
import { Section } from '../../../model/product/Section';
import { GroupProduct } from '../../../model/product/GroupProduct';
import { Business } from '../../../model/business/Business';
import { ArticleDetail } from '../../../model/product/ArticleDetail';
import { ArticleDetailService } from '../../../service/product/ArticleDetailService';
import { Client } from '../../../model/clientModel/Client';
import { ClientService } from '../../../service/clientProduct/clientService';
import { BussineService } from '../../../service/product/bussineService';
import { DetailRoleService } from '../../../service/accounts/detailRoleService';
import { ValidateNumber } from '../../../service/validate/validateNumber.directive';
import { ValidateText } from '../../../service/validate/validateText.directive';
import { Warehouse } from '../../../model/warehouse/Warehouse';
import { WareHouseMain } from '../../../model/warehouse/WareHouseMain';
import { SellProduct } from '../../../model/SellModel/SellProduct';
import { DetailRole } from '../../../model/usuario/DetailRole';
import { RoleUser } from '../../../model/usuario/RoleUser';
import { DetailSell } from '../../../model/SellModel/DetailSell';
import { PaymentTypeService } from '../../../service/typeMoney/PaymentTypeService';
import { PaymentType } from '../../../model/typeMoney/PaymentType';
import { WarehouseService } from '../../../service/warehouse/warehouseService';
import { SellProductService } from '../../../service/sellProduct/SellProductService';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css'],
  providers: [ ArticleDetailService, ClientService, DetailRoleService, PaymentTypeService, BussineService, WarehouseService, SellProductService ]
})
export class SalesComponent implements OnInit {
  public form: FormGroup;
  public modalVenta: BsModalRef;
  public isEditForm: boolean;

  public config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  public filterQuery;
  public rowsOnPage = 10;
  public sortBy: string;
  public sortOrder: string;
  public roleUserList;

  public article: Article;
  public subSection: SubSection;
  public section: Section;
  public groupProduct: GroupProduct;
  public business: Business;
  public articleDetail: ArticleDetail;
  public client: Client;
  public warehouse: Warehouse;
  public wareHouseMain: WareHouseMain;
  public sellProduct: SellProduct;
  public detailRole: DetailRole;
  public detailRoleID: DetailRole;
  public roleUserID: RoleUser;
  public detailSell: DetailSell;
  public clientSelect;
  public listArticleSell;
  public listSellDetail;
  public roleUserSeller;
  public paymentList;
  public bussineSelect;
  public paymentType: PaymentType;
  public currentArticle: number;
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, private route: ActivatedRoute,
              public articleDetailService: ArticleDetailService, public clientService: ClientService,
              public detailRoleService: DetailRoleService, public paymentTypeService: PaymentTypeService,
              public bussineService: BussineService, public warehouseService: WarehouseService,
              public sellProductService: SellProductService) {
    translate.setDefaultLang(dataService.languagePage );
    translate.use(dataService.languagePage);
  }
  ngOnInit() {
    this.paymentType = new PaymentType();
    this.article = new Article();
    this.client = new Client();
    this.detailSell = new DetailSell();
    this.isEditForm = true;
    this.formValidateModal();
    this.filterQuery = '';
    this.sortBy = 'typeMoneyId';
    this.sortOrder = 'asc';
    this.listArticleSell = [];
    this.roleUserSeller = [];
    this.listSellDetail = [];
    this.paymentList = [];
    this.getLisRoleUser();
    this.idUserRoleIDDetail();
    this.getListPayment();
    this.getListBussine();
    this.currentArticle = 0;
  }

  public formValidateModal() {
    this.form = this.formBuilder.group({
      roleUserId: ['', Validators.compose([
      ])],
      nameRole: [ '', Validators.compose([
        Validators.required
      ])],
      articleDetailId: [ '', Validators.compose([
        Validators.required
      ])],
      codigoAr: [ '', Validators.compose([
        Validators.required,
        ValidateText.isValidateTextComma
      ])],
      nameAr: [ {value: '', disabled: true }, Validators.compose([
        Validators.required
      ])],
      imageMainAr: [ '', Validators.compose([
      ])],
      numberPrudctSp: [ '', Validators.compose([
        Validators.required,
        Validators.minLength(1),
        ValidateNumber.verificateNumber
      ])],
      clienInfo: [ '', Validators.compose([
        Validators.required
      ])],
      clientId: [ '', Validators.compose([
        Validators.required
      ])],
      ciNitClient: [ '', Validators.compose([
        Validators.required
      ])],
      nameClient: [ '', Validators.compose([
        Validators.required
      ])],
      lastNameClient: [ '', Validators.compose([
        Validators.required
      ])],
      dateBirthClient: [ '', Validators.compose([
        Validators.required
      ])],
      phoneClient: [ '', Validators.compose([
        Validators.required
      ])],
      cellPhoneClient: [ '', Validators.compose([
        Validators.required
      ])],
      addressClient: [ '', Validators.compose([
        Validators.required
      ])],
      emailClient: [ '', Validators.compose([
        Validators.required
      ])],
      detailRoleId: [ '', Validators.compose([
        Validators.required
      ])],
      paymentTypeId: [ '', Validators.compose([
        Validators.required
      ])],
      discountClient: [ '', Validators.compose([
        Validators.required
      ])],
      businessId: [ '', Validators.compose([
        Validators.required
      ])]
    });
  }

  public getListBussine(): void {
    this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;
        this.form.controls['businessId'].setValue(this.dataService.bussineId + '' );
      }, error => {
        console.log(error );
      });
  }


  public idUserRoleIDDetail() {
    this.detailRoleID = new DetailRole();
    this.detailRoleID.userID = this.dataService.AUTH_CONFIG;
    this.roleUserID = new RoleUser();
    this.roleUserID.roleUserId = 3;
    this.detailRoleID.roleUserId = this.roleUserID;
    this.detailRoleService.getLisRoleUserIdRoleId(this.detailRoleID)
      .subscribe( result => {
        this.dataService.idDetailRole = result;
      });
  }
  openModalWithClass(template: TemplateRef<any>) {
    this.isEditForm = true;
    this.modalVenta = this.dataService.showModal(template, this.config);
    this.editClientSales();
  }

  public getInfoArticleDetail() {
    if ( null === this.form.controls.codigoAr.errors ) {
       this.articleDetail = new ArticleDetail();
       this.article = new Article();
       this.article.codigoAr = this.form.value['codigoAr'];
       this.articleDetail.articleId = this.article;
       this.business = new Business();
       this.business.businessId = this.form.value['businessId'];
       this.groupProduct = new GroupProduct();
       this.groupProduct.businessId = this.business;
       this.section = new Section();
       this.section.groupId = this.groupProduct;
       this.subSection = new SubSection;
       this.subSection.sectionId = this.section;
       this.articleDetail.subSectionId =  this.subSection;
       this.articleDetailService.getArticleDetailCodBusi(this.form.value['codigoAr'], this.form.value['businessId'])
        .subscribe( result => {
          this.articleDetail = result;
          if (null !== result ) {
            this.form.controls['codigoAr'].setValue(this.articleDetail.articleId.codigoAr);
            this.form.controls['nameAr'].setValue(this.articleDetail.articleId.nameAr);
            this.form.controls['articleDetailId'].setValue(this.articleDetail.articleDetailId);
            this.form.controls['numberPrudctSp'].setValue('');
            this.warehouseService.getNumerOfArticle(this.articleDetail.articleId.codigoAr, this.form.value['businessId'])
              .subscribe( ResultD => {
                this.currentArticle = ResultD;
              });
          } else {
            this.form.controls['nameAr'].setValue('');
            this.form.controls['articleDetailId'].setValue('');
            this.form.controls['numberPrudctSp'].setValue('');
          }
        }, e => {
          console.log(e);
        });
    }
  }
  public getInfoClient() {
    if (null === this.form.controls.clienInfo.errors) {
      this.clientService.getListClient(this.form.value['clienInfo'])
        .subscribe( result => {
          this.clientSelect = result;
          this.client = new Client;
          this.form.controls['clientId'].setValue('');
          this.form.controls['ciNitClient'].setValue('Ninguno');
          this.form.controls['nameClient'].setValue('Ninguno');
          this.form.controls['lastNameClient'].setValue('');
          this.form.controls['dateBirthClient'].setValue('');
          this.form.controls['phoneClient'].setValue('');
          this.form.controls['cellPhoneClient'].setValue('');
          this.form.controls['addressClient'].setValue('');
          this.form.controls['emailClient'].setValue('');
          this.form.controls['discountClient'].setValue('');

        });
    }
  }
  onSelectClient(event) {
    this.clientService.geClientId(event.value)
      .subscribe( result => {
        this.client = result;
        this.form.controls['clientId'].setValue(event.value);
        this.form.controls['ciNitClient'].setValue(this.client.ciNitClient);
        this.form.controls['nameClient'].setValue(this.client.nameClient);
        this.form.controls['lastNameClient'].setValue(this.client.lastNameClient);
        this.form.controls['dateBirthClient'].setValue(this.client.dateBirthClient);
        this.form.controls['phoneClient'].setValue(this.client.phoneClient);
        this.form.controls['cellPhoneClient'].setValue(this.client.cellPhoneClient);
        this.form.controls['addressClient'].setValue(this.client.addressClient);
        this.form.controls['emailClient'].setValue(this.client.emailClient);
        this.form.controls['discountClient'].setValue(this.client.discountClient);

      });
  }

  addArticleListSell(): void {
    if ( null !== this.form.controls.ciNitClient.errors ) {
      this.form.controls['ciNitClient'].setValue('Ninguno');
      this.client.ciNitClient = 'Ninguno';
    }
    if ( null !== this.form.controls.nameClient.errors ) {
      this.form.controls['nameClient'].setValue('Ninguno');
      this.client.nameClient = 'Ninguno';
    }
    if ( true === this.getValidateInfoArticle() ) {
      this.wareHouseMain = new WareHouseMain();
      this.warehouse = new Warehouse();
      this.warehouse.wnameId = this.wareHouseMain;
      this.warehouse.articleDetailId = this.articleDetail;
      this.warehouseService.getNumerOfArticle(this.articleDetail.articleId.codigoAr, this.form.value['businessId'])
        .subscribe( result => {
          this.currentArticle = result;
          if ( this.form.value['numberPrudctSp'] <= result ) {
            this.sellProduct = new SellProduct();
            this.sellProduct.numberPrudctSp = this.form.value['numberPrudctSp'];
            this.sellProduct.costProductCountrySpt = this.articleDetail.articleId.precyAr;
            if (this.articleDetail.articleId.isDiscountAr) {
              this.sellProduct.discountSp = this.articleDetail.articleId.perDiscountAr;
            }
            if (true === this.client.discountClient) {
              this.sellProduct.discountSp = this.articleDetail.articleId.perDiscountAr;
            }
            this.sellProduct.warehouseId = this.warehouse;
            this.sellProduct.clientId = this.client;
            const idArraySales = this.getSales(this.listArticleSell, this.articleDetail);
            if (-1 === idArraySales) {
              this.listArticleSell.push(this.sellProduct);
            } else {
              this.listArticleSell[idArraySales] = this.sellProduct;
            }
          }
        });
    }
  }

  public getSales( sellProduct, articleDetailIn: ArticleDetail): number {
    let posArraySales = -1;
     sellProduct.forEach(function(keyForm: any, i){
       if ( keyForm.warehouseId.articleDetailId.articleId.codigoAr === articleDetailIn.articleId.codigoAr ) {
          posArraySales = i;
       }
  });
    return posArraySales;
  }

  public editClientSales(): void {
    this.client =  new Client();
    this.client.clientId = this.form.value['clientId'];
    this.client.ciNitClient = this.form.value['ciNitClient'];
    this.client.nameClient = this.form.value['nameClient'];
    this.client.lastNameClient = this.form.value['lastNameClient'];
    this.client.dateBirthClient = this.form.value['dateBirthClient'];
    this.client.phoneClient = this.form.value['phoneClient'];
    this.client.cellPhoneClient = this.form.value['cellPhoneClient'];
    this.client.addressClient = this.form.value['addressClient'];
    this.client.emailClient = this.form.value['emailClient'];
    this.client.discountClient = this.form.value['discountClient'];
    for ( let i = 0; i < this.listArticleSell.length; i++ ) {
      this.listArticleSell[i].clientId = this.client;
      this.listArticleSell[i].businessArSp = this.dataService.bussineId;
      if ( true === this.listArticleSell[i].clientId.discountClient ) {
        this.listArticleSell[i].discountSp = this.listArticleSell[i].warehouseId.articleDetailId.articleId.perDiscountAr;
      } else {
        this.sellProduct.discountSp = 0;
      }
    }
  }

  public removeArticle(sellProductTable: SellProduct) {
    const idArraySales = this.getSales(this.listArticleSell, sellProductTable.warehouseId.articleDetailId);
    this.listArticleSell.splice(idArraySales, 1);
    console.log(this.listArticleSell);
  }


  public getValidateInfoArticle(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.numberPrudctSp.errors},
      {'SectionInformation': this.form.controls.codigoAr.errors},
      {'SectionInformation': this.form.controls.ciNitClient.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }
  public getLisRoleUser() {
    this.detailRoleService.getLisRoleUserSelect(4)
      .subscribe( result => {
        this.roleUserSeller = result;
      });
  }
  public getListPayment() {
    this.paymentTypeService.listPaymentType()
      .subscribe( result => {
      this.paymentList = result;
      });
  }
  public registerSeller() {
    if ( null === this.form.controls.paymentTypeId.errors  && null === this.form.controls.detailRoleId.errors ) {
      this.detailSell = new DetailSell();
      this.paymentType = new PaymentType();
      this.paymentType.paymentTypeId = this.form.value['paymentTypeId'];
      this.detailSell.paymentTypeId = this.paymentType;
      this.detailSell.roleSellerId = Number( this.form.value['detailRoleId'] );
      this.detailSell.roleCashierId = this.dataService.idDetailRole;
      for (let i = 0; i < this.listArticleSell.length; i++) {
        this.listArticleSell[i].detailSellId = this.detailSell;
      }
      this.sellProductService.addSell(this.listArticleSell)
        .subscribe( result => {
          this.listArticleSell = result;
          console.log(result);
        } );
    }

  }
}
