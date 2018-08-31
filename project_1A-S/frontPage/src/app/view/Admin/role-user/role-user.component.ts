import { Component, TemplateRef, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { RoleUserService } from '../../../service/accounts/roleUserService';
import { RoleUser} from '../../../model/usuario/RoleUser';

@Component({
  selector: 'app-role-user',
  templateUrl: './role-user.component.html',
  styleUrls: ['./role-user.component.css'],
  providers: [ RoleUserService ]
})
export class RoleUserComponent implements OnInit {
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
  public moneyTypeList;

  public roleUserList;
  public roleUser: RoleUser;
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, public roleUserService: RoleUserService ) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.isEditForm = true;
    this.filterQuery = '';
    this.sortBy = 'typeMoneyId';
    this.sortOrder = 'asc';
    this.formValidateModal();
    this.getListRoleUser();
  }
  public formValidateModal() {
    this.form = this.formBuilder.group({
      roleUserId: ['', Validators.compose([
      ])],
      nameRole: [ '', Validators.compose([
        Validators.required
      ])]
    });
  }

  openModalWithClass(template: TemplateRef<any>) {
    this.isEditForm = true;
    /*  this.form.controls['warehouseId'].setValue('');*/
    this.modalRefRoleUser = this.dataService.showModal(template, this.config);
  }

  public getListRoleUser() {
    this.roleUserService.listRoleUser()
      .subscribe(result => {
        this.roleUserList = result;
      });
  }

  public registerRoleUser() {
    this.isEditForm = true;
    if (true === this.getValidateInfo() ) {
      this.roleUser = new RoleUser();
      this.roleUser.nameRole = this.form.value['nameRole'];
      this.roleUserService.addRoleUser(this.roleUser)
        .subscribe(result => {
          this.getListRoleUser();
          this.modalRefRoleUser.hide();

        });
    }
  }
  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'SectionInformation': this.form.controls.roleUserId.errors},
      {'SectionInformation': this.form.controls.nameRole.errors}
    ];
    sectionInfo.forEach(function(keyForm: any, i){
      if ( null !== keyForm.SectionInformation) {
        stateBaoolean = false;
      }
    });
    return stateBaoolean;
  }

  public edit(itemTableRoleUser: RoleUser , template: TemplateRef<any>) {
    this.isEditForm = false;
    this.formValidateModal();
    this.form.controls['roleUserId'].setValue(itemTableRoleUser.roleUserId + '');
    this.form.controls['nameRole'].setValue(itemTableRoleUser.nameRole + '');
    this.modalRefRoleUser = this.dataService.showModal(template, this.config);
  }



  public updateRoleUser() {
    if (true === this.getValidateInfo() ) {
      this.roleUser = new RoleUser();
      this.roleUser.roleUserId = this.form.value['roleUserId'];
      this.roleUser.nameRole = this.form.value['nameRole'];
      this.roleUserService.editRoleUser(this.roleUser)
        .subscribe(result => {
          this.getListRoleUser();
        });
    }
  }

  public remove(itemTableRoleUser: RoleUser) {
    this.roleUser = new RoleUser();
    this.roleUser.roleUserId = this.form.value['roleUserId'];
    this.roleUser.nameRole = this.form.value['nameRole'];
    this.roleUserService.deleteRoleUser(this.roleUser)
      .subscribe(result => {
        this.getListRoleUser();
      });
  }
}
