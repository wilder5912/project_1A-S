import { Component, TemplateRef, OnInit, Input } from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../../../../service/accounts/userService';
import { DetailRoleService } from '../../../../service/accounts/detailRoleService';
import { RoleUserService } from '../../../../service/accounts/roleUserService';
import { User} from '../../../../model/usuario/User';
import { RoleUser } from '../../../../model/usuario/RoleUser';
import { DetailRole } from '../../../../model/usuario/DetailRole';
import { BussineService } from '../../../../service/product/bussineService';
import { BusinessCurrentUserService } from '../../../../service/accounts/businessCurrentUserService';
import { BusinessCurrentUser } from '../../../../model/usuario/BusinessCurrentUser';
import { Business } from '../../../../model/business/Business';

@Component({
  selector: 'app-detaill-role',
  templateUrl: './detaill-role.component.html',
  styleUrls: ['./detaill-role.component.css'],
  providers: [ DetailRoleService, RoleUserService, BussineService, BusinessCurrentUserService ]
})
export class DetaillRoleComponent implements OnInit {
  @Input() userId: number;
  public form: FormGroup;
  public isEditForm: boolean;
  public listRole;
  public listRoleUserAllData;
  public user: User;
  public roleUser: RoleUser;
  public detailRole: DetailRole;
  public listRoleUserAdd;
  public bussineSelect;
  public businessCurrentUser: BusinessCurrentUser;
  public business: Business;
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, private route: ActivatedRoute,
              public userService: UserService, public detailRoleService: DetailRoleService,
              public roleUserService: RoleUserService, public bussineService: BussineService,
              public businessCurrentUserService: BusinessCurrentUserService) {
    translate.setDefaultLang(dataService.languagePage );
    translate.use(dataService.languagePage);
  }
  ngOnInit() {
    this.isEditForm = true;
    this.formValidateModal();
    this.listAllRole();
  }
  public listRoleUserAll(userId: number) {
    this.detailRoleService.listAllRoleUser(userId)
      .subscribe( result => {
        const listRelational = [];
        result.forEach(function(sectioninforData) {
          listRelational.push(sectioninforData + '');
        });
        this.form.controls['roleUserId'].setValue(listRelational);
        this.listRoleUser(userId);
      });
  }

  public listAllRole() {
    this.roleUserService.listAllRole()
      .subscribe( result => {
        this.listRole = result;
        this.getListBussine();
        this.listRoleUserAll(this.userId);
      });
  }
  public listRoleUser(userId: number) {
    this.detailRoleService.listRoleUser(userId)
      .subscribe( result => {
        this.listRoleUserAllData = result;
        this.form.controls['bussineIdUser'].setValue(this.dataService.userRoleCurren.bussineIdUser + '' );
      });
  }


  public formValidateModal() {
    this.form = this.formBuilder.group({
      roleUserId: ['', Validators.compose([
        Validators.required,
        Validators.minLength(1)
      ])],
      roleUserIdRadio: ['', Validators.compose([
        Validators.required
      ])],
      bussineIdUser: ['', Validators.compose([
        Validators.required
      ])]
    });
  }
  public registerRole() {
    this.user = new User();
    this.user.userID = this.userId;
    this.user.typeUser = this.form.value['roleUserIdRadio'];
    this.userService.editUserRol(this.user)
      .subscribe( result => {
      });
  }
  public addRoleList() {
    const roleIdList = this.form.value['roleUserId'];
    this.listRoleUserAdd = [];
    for (let i = 0; i < roleIdList.length; i++) {
      this.user = new User();
      this.user.userID = this.userId;
      this.roleUser = new RoleUser();
      this.roleUser.roleUserId = roleIdList[i];
      this.detailRole = new DetailRole();
      this.detailRole.roleUserId = this.roleUser;
      this.detailRole.userID = this.user;
      this.listRoleUserAdd.push(this.detailRole);
    }
    this.detailRoleService.addlistRoleUser(this.listRoleUserAdd)
      .subscribe( result => {
        this.listRoleUser( this.userId);
      });
  }
  public getListBussine() {
    this.bussineService.getBussine()
      .subscribe(result => {
        this.bussineSelect = result;

   }, error => {
        console.log(error );
      });
  }

  public editBussine() {
    this.businessCurrentUser = new BusinessCurrentUser();
    this.user = new User();
    this.user.userID = this.userId;
    this.businessCurrentUser.userID = this.user;
    this.business = new Business();
    this.business.businessId =  this.form.value['bussineIdUser'];
    this.businessCurrentUser.businessId = this.business;
    this.businessCurrentUserService.addBusinessCurrentUser(this.businessCurrentUser)
      .subscribe( result => {
        /*console.log(result);*/
      });

  }
}
