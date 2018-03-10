import { Component, TemplateRef, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DataService } from '../../../service/dataService/data.service';
import { BannerService } from '../../../service/product/BannerService';
import { Banner } from '../../../model/product/Banner';
import { TranslateService } from '@ngx-translate/core';
import { BsDatepickerConfig, BsLocaleService } from 'ngx-bootstrap/datepicker';


@Component({
  selector: 'app-create-banner',
  templateUrl: './create-banner.component.html',
  styleUrls: ['./create-banner.component.css'],
  providers: [BannerService]
})
export class CreateBannerComponent implements OnInit {
  private form: FormGroup;
  private banner: Banner =  new Banner();
  public minDate: Date;
  public maxDate: Date;
  public bsRangeValue: any;
  private isEditForm: boolean;
  private config = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false
  };
  public modalRefBanner: BsModalRef;
  public selectedFilesbanner: FileList;
  public currentFileUploadOne: File;
  public bsConfig: Partial<BsDatepickerConfig>;
  public colorTheme: string;
  constructor(private formBuilder: FormBuilder, private dataService: DataService,
              private translate: TranslateService, private _localeService: BsLocaleService,
              private bannerService: BannerService) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
         this.isEditForm = true;
         this.colorTheme = 'theme-green';
         this.dataService.redirectTypeUser();
         this.formValidateModal();
         this.bsConfig = Object.assign({}, { containerClass: this.colorTheme });
         this._localeService.use(this.dataService.languagePage);
         this.minDate = new Date();
  }

  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.tittleBanner.errors},
      {'SectionInformation': this.form.controls.detallBanner.errors},
      {'SectionInformation': this.form.controls.startBanner.errors},
      {'SectionInformation': this.form.controls.urlBanner.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if (null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }

  public formValidateModal() {
    this.form = this.formBuilder.group({
      bannerId: ['', Validators.compose([
      ])],
      tittleBanner: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      detallBanner: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      nameImageBanner: ['', Validators.compose([
        Validators.required
      ])],
      startBanner: ['', Validators.compose([
        Validators.required,
      ])],
      endBanner: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      urlBanner: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])]
    });
  }


  openModalWithClass(template: TemplateRef<any>) {
    this.modalRefBanner = this.dataService.showModal(template, this.config);
  }
  public selectFileBanner(event) {
    const file = event.target.files.item(0);
    if (file.type.match('image.*')) {
      this.selectedFilesbanner = event.target.files;
    } else {
      console.log('formato invalido');
    }
  }


  public registerBanner() {
    if (true === this.getValidateInfo() && null !== this.selectedFilesbanner) {
      this.banner = new Banner();
      this.banner.tittleBanner = this.form.value['tittleBanner'];
      this.banner.detallBanner = this.form.value['detallBanner'];
      this.banner.urlBanner = this.form.value['urlBanner'];
      this.banner.nameImageBanner = this.form.value['nameImageBanner'];
      this.banner.startBanner = this.dataService.getFormatDate(this.form.value['startBanner'][0]);
      this.banner.endBanner = this.dataService.getFormatDate(this.form.value['startBanner'][1]);
      this.currentFileUploadOne = this.selectedFilesbanner.item(0);
      this.bannerService.updateImageArticle(this.currentFileUploadOne, this.banner)
        .subscribe( result => {
          this.modalRefBanner.hide();
        });
    }
  }



}
