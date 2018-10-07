import { Component, TemplateRef, OnInit, Input } from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../../../../service/accounts/userService';

import { User } from '../../../../model/usuario/User';
import { LoginService } from '../../../../service/accounts/loginService';

@Component({
  selector: 'app-info-user',
  templateUrl: './info-user.component.html',
  styleUrls: ['./info-user.component.css'],
  providers: [ UserService, LoginService ]
})
export class InfoUserComponent implements OnInit {
  @Input() userId: number;
  public form: FormGroup;
  public user: User;
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, private route: ActivatedRoute,
              public userService: UserService, public loginService: LoginService) {
    translate.setDefaultLang(dataService.languagePage );
    translate.use(dataService.languagePage);
  }
  ngOnInit() {
    this.formValidateModal();
    this.getUserInfoId(this.userId);
  }
  public getUserInfoId(userId: number) {
      this.userService.getUserId(userId)
        .subscribe( result => {
         /* console.log(result);*/
          this.user = result;
          this.form.controls['firtNameUser'].setValue(this.user.firtNameUser);
          this.form.controls['lastNameUser'].setValue(this.user.lastNameUser);
          this.form.controls['emailUser'].setValue(this.user.emailUser);
          this.dataService.userRoleCurren = result;
        });
  }


  public formValidateModal() {
    this.form = this.formBuilder.group({
      firtNameUser: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3)
      ])],
      lastNameUser: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3)
      ])],
      emailUser: ['', Validators.compose([
        Validators.required,
        Validators.minLength(3),
        Validators.email
      ])]
    });
  }
}
