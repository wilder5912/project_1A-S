import { Component, OnInit } from '@angular/core';
 import { Validators, FormControl, FormGroup } from '@angular/forms';
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
  title = 'app';
  idAN = '';
  idBN = '';
  idAN2 = '';
  idBN2= '';
  selectedFiles: FileList;
  currentFileUpload: File
  progress: { percentage: number } = { percentage: 0 }
  imageUser = '';
  imageload = '';


  user: User = new User();
  stateUser: boolean = null;
  stateCss: boolean = true;
  stateCss2: boolean = true;
  constructor( public dataService: DataService , public loginService: LoginService, public userService: UserService,public router: Router) {

  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
  }

  logout() {
    this.loginService.logout()
      .subscribe(result => {
        window.location.reload();
      }, e => {
        console.log( "errrr" );
      });
  }

  selectTodo() {
    if(this.stateCss){
      this.stateCss = false;
      this.idAN = 'antive';
      this.idBN = 'in';
    }else{
      this.stateCss = true;
      this.idAN = '';
      this.idBN = '';
    }
  }  selectTodo2() {
    if(this.stateCss2){
      this.stateCss2 = false;
      this.idAN2 = 'antive';
      this.idBN2 = 'in';
    }else{
      this.stateCss2 = true;
      this.idAN2 = '';
      this.idBN2 = '';
    }
  }

  selectFile(event) {

    const file = event.target.files.item(0);
    if (file.type.match('image.*')) {

      this.selectedFiles = event.target.files;
    } else {
      console.log("formato invalido");
    }
  }

  upload() {
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0)
    this.userService.editImage(this.currentFileUpload).subscribe(event => {
      this.getUserDataServer();
    }, e => {
      console.log( "errrr",e );
    });

    this.selectedFiles = undefined
  }


  getUserDataServer() {
    if (localStorage.getItem('currentUser')) {
      const usersData: any[] = JSON.parse(localStorage.getItem('currentUser')) || [];
      this.user.emailUser = usersData['emailUser'];
    }
    if (!sessionStorage.getItem('token')) {
      sessionStorage.setItem("token","null");
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
          this.imageUser= this.dataService.getApiUrl()+"/user/files/"+this.dataService.AUTH_CONFIG.imagenUser;
          this.dataService.imageUserPage= this.dataService.getApiUrl()+"/user/files/"+this.dataService.AUTH_CONFIG.imagenUser;


          localStorage.setItem('currentUser', JSON.stringify({emailUser: result.emailUser, token: "fake-jwt-token"}));
          this.user = result;
          if (localStorage.getItem('currentUser')) {
            if('/loginRegister'=== this.router.url){
              this.loginService.redirectUser(result, '/homeAdmin');
            }else{
              this.loginService.redirectUser(result, this.dataService.urlPage);

            }
          }
          this.dataService.islogin=true;
        }else {
          //this.loginService.redirectUser(result, this.dataService.urlPage);
          this.dataService.islogin=false;
          this.loginService.redirectUser(this.user, '/home');

        }
        this.dataService.imageLoadPage = false;
      }, e => {
        console.log( "errrr",e );
      });
  }

}
