import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from '../../../model/usuario/User';
import { LoginService } from '../../../service/accounts/loginService';
import { DataService } from '../../../service/dataService/data.service';
import { Router } from '@angular/router';
import { Business } from '../../../model/business/Business';
import { SubSectionService } from '../../../service/product/SubSectionService';
import { BussineService } from '../../../service/product/bussineService';
import { BoxService } from '../../../service/boxArticle/BoxService';
import { Box } from '../../../model/boxArticle/Box';

@Component({
  selector: 'app-header-user',
  templateUrl: './header-user.component.html',
  styleUrls: ['./header-user.component.css'],
  providers: [LoginService, SubSectionService , BussineService , BoxService]
})
export class HeaderUserComponent implements OnInit {
  public box: Box = new Box();
  public user: User =  new User();
  public menuData;
  public stateCss;
  public model: User = new User();
  public business: Business = new Business();
  public form: FormGroup;
  public loading = false;
  public isLogin = true;
  public logoPage =  this.dataService.getApiUrl() + '/user/files/logo.png';
  items: string[] = [
    'Español'
      ];

  onHidden(): void {

  }
  onShown(): void {

  }
  isOpenChange(): void {
  }
  constructor(public loginService: LoginService , public boxService: BoxService,
              private formBuilder: FormBuilder, public router: Router,
              public dataService: DataService, public subSectionService: SubSectionService,
              public bussineService: BussineService) { }

  ngOnInit() {
    this.stateCss = true;
    this.getBussineAllList();
    this.formValidateModal();

  }

public setStyle() {
  this.stateCss = !this.stateCss;
}
  logout() {
    this.loginService.logout()
      .subscribe(result => {
        window.location.reload();
      }, e => {
        console.log( e );
      });
  }

  public getBussineAllList() {
    this.business =  new Business();
    this.business.businessId = this.dataService.bussineId;
    this.box = new Box();
    this.user = new User();
    this.bussineService.getBussineAll(this.business)
      .subscribe(result => {
        this.menuData = result;
        this.user.userID = this.dataService.AUTH_CONFIG.userID;
        this.box.boxId = this.dataService.AUTH_CONFIG.idBoxUser;
        this.box.userID = this.user;
        this.box.businessId =  this.business;
        if (this.dataService.AUTH_CONFIG.userID > 0 && this.dataService.AUTH_CONFIG.typeUser !== 'Admin') {
          this.getBoxArticle(this.box);
        }

      }, error => {
        console.log(error);
      });
  }

  public getBoxArticle(box: Box) {
    this.boxService.getBoxListArticle(box)
      .subscribe( result => {
        this.dataService.getListArticle = result;
        this.dataService.boxIdUser = this.dataService.getListArticle.boxId;
        this.dataService.articleValue = 0;
        let coste = 0;
        this.dataService.getListArticle.listProductVEO.articleVEO.forEach(function(keyForm: any, i){
          coste = coste + (keyForm.numProduct * keyForm.precyAr);
        });

        this.dataService.articleValue = coste;
      });
  }

  public getValidateInfo(): boolean {
    let stateBaoolean = true;
    const sectionInfo = [
      {'fiendArticle': this.form.controls.fiendArticle.errors}
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
      fiendArticle: ['', Validators.compose([
        Validators.required
      ])]
    });
  }

  public fiendArticleOrCode() {
    if (this.getValidateInfo) {
      this.dataService.redirectUrlWithName('ListArticleFiend' + '/' + this.form.value['fiendArticle']);
    }

  }

}
