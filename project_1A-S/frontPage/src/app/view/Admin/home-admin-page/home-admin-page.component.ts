import { Component, OnInit } from '@angular/core';
import { DataService } from '../../../service/dataService/data.service';
import { User } from '../../../model/usuario/User';
import { LoginService } from '../../../service/accounts/loginService';
import { UserService } from '../../../service/accounts/userService';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home-admin-page',
  templateUrl: './home-admin-page.component.html',
  styleUrls: ['./home-admin-page.component.css']
})
export class HomeAdminPageComponent implements OnInit {
  public title = 'app';
  public  idAN = '';
  public idBN = '';
  public idAN2 = '';
  public idBN2= '';
  public selectedFiles: FileList;
  public currentFileUpload: File;
  public progress: { percentage: number } = { percentage: 0 };
  public imageUser = '';
  public user: User = new User();
  public stateUser: boolean;
  public stateCss: boolean;
  public stateCss2: boolean;
  constructor( public dataService: DataService , public loginService: LoginService,
               public userService: UserService, public router: Router) {
  }

  ngOnInit() {
    this.stateUser = null;
    this.stateCss = true;
    this.stateCss2 = true;
    this.dataService.redirectTypeUser();
  }

  public logout() {
    this.loginService.logout()
      .subscribe(result => {
        window.location.reload();
      }, e => {
        console.log( '', e);
      });
  }

  public selectTodo() {
    if (this.stateCss) {
      this.stateCss = false;
      this.idAN = 'antive';
      this.idBN = 'in';
    }else {
      this.stateCss = true;
      this.idAN = '';
      this.idBN = '';
    }
  }
  public selectTodo2() {
    if (this.stateCss2) {
      this.stateCss2 = false;
      this.idAN2 = 'antive';
      this.idBN2 = 'in';
    }else {
      this.stateCss2 = true;
      this.idAN2 = '';
      this.idBN2 = '';
    }
  }

  public selectFile(event) {
    const file = event.target.files.item(0);
    if (file.type.match('image.*')) {
      this.selectedFiles = event.target.files;
    } else {
      console.log('formato invalido');
    }
  }

  public upload() {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.userService.editImage(this.currentFileUpload).subscribe(event => {
      this.getUserDataServer();
    }, e => {
      console.log( '', e );
    });
    this.selectedFiles = undefined;
  }
  public getUserDataServer() {
    if (localStorage.getItem('currentUser')) {
      const usersData: any[] = JSON.parse(localStorage.getItem('currentUser')) || [];
      this.user.emailUser = usersData['emailUser'];
    }
    if (!sessionStorage.getItem('token')) {
      sessionStorage.setItem('token', (null + ''));
      this.user.tokenUser = 'null';
    }
    this.user.tokenUser = sessionStorage.getItem('token');
    this.dataService.urlPage = this.router.url;
    this.loginService.isLogin(this.user)
      .subscribe(result => {
        this.stateUser = true;
        this.dataService.urlPage = this.router.url;
        if (null !== result) {
          this.dataService.AUTH_CONFIG = result;
          this.imageUser = this.dataService.getApiUrl() + '/user/files/' + this.dataService.AUTH_CONFIG.imagenUser;
          this.dataService.imageUserPage = this.dataService.getApiUrl() + '/user/files/' + this.dataService.AUTH_CONFIG.imagenUser;
          localStorage.setItem('currentUser', JSON.stringify({emailUser: result.emailUser, token: 'fake-jwt-token'}));
          this.user = result;
          if (localStorage.getItem('currentUser')) {
            if ('/loginRegister' === this.router.url) {
              this.loginService.redirectUser( '/homeAdmin');
            }else {
              this.loginService.redirectUser( this.dataService.urlPage);

            }
          }
          this.dataService.islogin = true;
        }else {
         this.dataService.islogin = false;
          this.loginService.redirectUser( '/home');

        }
        this.dataService.imageLoadPage = false;
      }, e => {
        console.log( '', e );
      });
  }

}
