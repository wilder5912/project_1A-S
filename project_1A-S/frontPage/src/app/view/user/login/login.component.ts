import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { User } from '../../../model/usuario/User';
import { LoginService } from '../../../service/accounts/loginService';
import { DataService } from '../../../service/dataService/data.service';
import { Router, CanActivate } from '@angular/router';
import { AuthHttp, AuthConfig ,JwtHelper} from 'angular2-jwt';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})

export class LoginComponent implements OnInit {

  public model: User = new User();
  public user: User = new User();
  public form: FormGroup;
  public  loading = false;
  public jwtHelper: JwtHelper = new JwtHelper();

  constructor(public loginService: LoginService , public router: Router, public dataService: DataService ) {
  }
  ngOnInit() {
    this.iniPage();
  }

  public iniPage(){
  }

  public login() {
    this.dataService.imageLoadPage = true;
    this.user = this.model;
    this.user.password= window.btoa(this.model.password);
      this.loginService.login(this.user)
      .subscribe(result => {
        if (null !== result) {
          sessionStorage.setItem('token',result.tokenUser);
          localStorage.setItem('currentUser', JSON.stringify({ emailUser: result.emailUser, token: 'fake-jwt-token' }));
        }else{
          sessionStorage.setItem('token',null);
        }
        window.location.reload();

      }, e => {
        console.log('errrr');
      });
  }
}
