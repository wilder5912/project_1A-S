import { Component, TemplateRef , OnInit} from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { ValidateNumber } from '../../../../service/validate/validateNumber.directive';
import { Provider } from '../../../../model/provider/Provider';
import { ProviderService} from '../../../../service/product/ProviderService';
@Component({
  selector: 'app-provider',
  templateUrl: './provider.component.html',
  styleUrls: ['./provider.component.css'],
  providers: [ProviderService]
})
export class ProviderComponent implements OnInit {

  public form: FormGroup;
  public modalRefProvider: BsModalRef;
  public options;
  public isEditForm: boolean;
  public provider: Provider;
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
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, public providerService: ProviderService ) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.filterQuery = '';
    this.sortBy = 'codeProvider';
    this.sortOrder = 'asc';
    this.formValidateModal();
    this.isEditForm = true;
    this.getListProvider();
  }

  public formValidateModal() {
    this.form = this.formBuilder.group({
      providerId: ['', Validators.compose([
      ])],
      nameProvider: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      codeProvider: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
      ])],
      numberPhoneProvider: ['', Validators.compose([
        Validators.required,
        Validators.minLength(5),
        ValidateNumber.verificateNumber
      ])]
    });
  }

  openModalWithClass(template: TemplateRef<any>) {
   /* this.isEditForm = true;
    this.form.controls['businessId'].setValue('');
    this.form.controls['nameBu'].setValue('');*/
    this.modalRefProvider = this.dataService.showModal(template, this.config);
  }

  public registerProvider() {
    if (true === this.getValidateInfo() ) {
      this.provider = new Provider();
      this.provider.nameProvider = this.form.value['nameProvider'];
      this.provider.codeProvider = this.form.value['codeProvider'];
      this.provider.numberPhoneProvider = this.form.value['numberPhoneProvider'];
      this.providerService.addProvider(this.provider)
        .subscribe(result => {
          if (result) {
            this.getListProvider();
            this.modalRefProvider.hide();
          }
        });
    }
  }

  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.nameProvider.errors},
      {'SectionInformation': this.form.controls.codeProvider.errors},
      {'SectionInformation': this.form.controls.numberPhoneProvider.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }
  public getListProvider(): void {
    this.providerService.getProvidesList()
      .subscribe(result => {
        this.dataProvider = result;
      }, error => {
        console.log(error );
      });
  }
}
