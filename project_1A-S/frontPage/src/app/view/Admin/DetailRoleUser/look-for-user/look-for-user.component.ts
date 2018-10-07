import { Component, TemplateRef, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { DetailRoleService } from '../../../../service/accounts/detailRoleService';

@Component({
  selector: 'app-look-for-user',
  templateUrl: './look-for-user.component.html',
  styleUrls: ['./look-for-user.component.css'],
  providers: [ DetailRoleService ]
})
export class LookForUserComponent implements OnInit {
  public form: FormGroup;
  public modalRefRoleUser: BsModalRef;
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

  public detailRoleUserList;

  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, public detailRoleService: DetailRoleService ) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.isEditForm = true;
    this.filterQuery = '';
    this.sortBy = 'typeMoneyId';
    this.sortOrder = 'asc';
    this.formValidateModal();
    this.getlookForDetailRole('Admin');
  }

  public formValidateModal() {
    this.form = this.formBuilder.group({
      lookForUser: [ '', Validators.compose([
        Validators.required
      ])]
    });
  }

public getlookForDetailRole(infoUser: string) {
    this.detailRoleService.lookForDetailRole(infoUser)
      .subscribe( result => {
        this.detailRoleUserList = result;
      });
}
  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.lookForUser.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }
  public lookForUserData() {
    this.getlookForDetailRole(this.form.value['lookForUser']);
  }
}
