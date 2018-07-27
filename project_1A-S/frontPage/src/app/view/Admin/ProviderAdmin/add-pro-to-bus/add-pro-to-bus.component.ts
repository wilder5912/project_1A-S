import { Component, TemplateRef , OnInit} from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { ValidateNumber } from '../../../../service/validate/validateNumber.directive';

@Component({
  selector: 'app-add-pro-to-bus',
  templateUrl: './add-pro-to-bus.component.html',
  styleUrls: ['./add-pro-to-bus.component.css']
})
export class AddProToBusComponent implements OnInit {

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

  public dataProvider;
  public filterQuery;
  public rowsOnPage = 10;
  public sortBy: string;
  public sortOrder: string;
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService  ) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }
  ngOnInit() {
  }

}
