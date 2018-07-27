import { Injectable, Component } from '@angular/core';
import { User } from '../../model/usuario/User';
import { LoginService } from '../../service/accounts/loginService';
import { BsModalService } from 'ngx-bootstrap/modal';
import { Router } from '@angular/router';
import { defineLocale } from 'ngx-bootstrap/chronos';
import { esLocale } from 'ngx-bootstrap/locale';
import { enGbLocale } from 'ngx-bootstrap/locale';
import { csLocale } from 'ngx-bootstrap/locale';
import { frLocale } from 'ngx-bootstrap/locale';

@Injectable()
export class DataService {
 private _apiUrl = 'http://localhost:8080';
 public urlPage = '/' ;
 private _languagePage = 'es';
 public imageLoadPage: boolean;
 public bussineId: number;
 public islogin = false;
 public imageUserPage;
 public stateUserPage = null;
 public imageActicle = '';
 public getListArticle;
 public articleValue: number;
 public boxIdUser = 0;
 public detailArticle;
 public AUTH_CONFIG: User = {
    userID: 0,
    firtNameUser: '',
    lastNameUser: '',
    emailUser: '',
    password: '',
    typeUser: '',
    imagenUser: '',
    tokenUser: '',
    codeUser: '',
    idBoxUser: 0
  };
 public rantingMax = 5;
 public typeImageSelect = [
   {value: 'Publico', label: 'Publico'},
   {value: 'Privado', label: 'Privado'},

 ];
  constructor( private modalService: BsModalService , private router: Router ) {
   this.getLanguagePage();
    this.initPage();
 }
  public headerSend = {
    'Content-Type': 'application/json; charset=utf-8',
    'access-token': sessionStorage.getItem('token'),
  };
 public initPage() {
    this.imageLoadPage = true;
    this.bussineId = 1;
    this.articleValue = 0;
 }
  public getUrl(modelo: string) {
    return this.getApiUrl() + modelo;
  }

  public redirectUrlWithName(modelo: string) {
   return this.router.navigate([modelo]);
  }

  public redirectUser(userA: User, urlPageN: string ) {
    this.router.navigate([urlPageN]);
  }

  public redirectTypeUser() {
    if (this.AUTH_CONFIG.typeUser !== 'Admin' ) {
      this.router.navigate(['/home']);
    }
  }

  public getApiUrl(): string {
    return this._apiUrl;
  }

  public showModal(template, config) {
    return  this.modalService.show(
            template,
            Object.assign({}, config, { class: 'modal-sm' })
          );
  }
  public showModalBig(template, config) {
    return  this.modalService.show(
            template,
            Object.assign({}, config, { class: 'gray modal-lg' })
          );
  }

  get languagePage(): string {
    return this._languagePage;
  }

  set languagePage(value: string) {
    this._languagePage = value;
  }

  public getFormatDate(value: string): string {
   const date: Date =  new Date(value);
   return date.getFullYear() + '-' + (date.getMonth() + 1 ) + '-' + (date.getUTCDay() + 1 );
 }

 public getDateAndHour(value: string): string {
   const date: Date = new Date(value);
   return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' +
     '' + (date.getUTCDay() + 1) + ' ' + date.getHours() + ':' +
     '' + date.getUTCMinutes() + ':' + date.getSeconds();
 }

public getLanguagePage() {
  defineLocale('es', esLocale);
  defineLocale('en', enGbLocale);
  defineLocale('cs', csLocale);
  defineLocale('fr', frLocale);

}



}
