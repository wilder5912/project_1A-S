import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../../service/accounts/loginService';
import {DataService } from '../../../service/dataService/data.service';

@Component({
  selector: 'app-login-and-register',
  templateUrl: './login-and-register.component.html',
  styleUrls: ['./login-and-register.component.css'],
  providers: [LoginService]
})
export class LoginAndRegisterComponent implements OnInit {

  constructor(public loginService: LoginService, public dataService: DataService) { }

  ngOnInit() {
    if (this.dataService.islogin){
      this.loginService.redirectUser( '/home');
    }
  }

}
