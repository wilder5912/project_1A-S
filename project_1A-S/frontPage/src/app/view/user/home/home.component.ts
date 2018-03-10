import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../../../service/dataService/data.service';
import { LoginService } from '../../../service/accounts/loginService';
import { User } from '../../../model/usuario/User';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [LoginService]}
  )
export class HomeComponent implements OnInit {
  private user: User = new User();
  constructor(private router: Router , public dataService: DataService, public loginService: LoginService ) {
  }
  ngOnInit() {
  }
  public logout() {
    this.loginService.logout()
      .subscribe(result => {
        window.location.reload();
      }, e => {
        console.log(e);
      });
  }
}
