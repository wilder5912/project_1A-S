import { Component, TemplateRef , OnInit} from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { ValidateNumber } from '../../../../service/validate/validateNumber.directive';
@Component({
  selector: 'app-provider',
  templateUrl: './provider.component.html',
  styleUrls: ['./provider.component.css']
})
export class ProviderComponent implements OnInit {

  public form: FormGroup;
  public modalRefProvider: BsModalRef;
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
              public dataService: DataService,  public modalService: BsModalService,
              public translate: TranslateService) {
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
      numbrePhoneProvider: ['', Validators.compose([
        Validators.required,
        Validators.minLength(5),
        ValidateNumber.verificateNumber
      ])]
    });
  }
}
