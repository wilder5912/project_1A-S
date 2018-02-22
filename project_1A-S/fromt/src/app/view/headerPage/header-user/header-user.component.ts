import { Component, OnInit ,ChangeDetectionStrategy, Input} from '@angular/core';
import { FormGroup } from '@angular/forms';
import { User } from '../../../model/usuario/User';
import { LoginService } from '../../../service/accounts/loginService';
import { DataService } from '../../../service/dataService/data.service';
import { Router, CanActivate } from '@angular/router';
import { Bussine } from '../../../model/bussine/Bussine';
import { SubSectionService } from '../../../service/product/SubSectionService';
import { BussineService } from '../../../service/product/bussineService';

@Component({
  selector: 'app-header-user',
  templateUrl: './header-user.component.html',
  styleUrls: ['./header-user.component.css'],
  providers: [LoginService,SubSectionService,BussineService]
})
export class HeaderUserComponent implements OnInit {

  public menuData;
  public stateCss;
  public model: User = new User();
  public bussine: Bussine = new Bussine();
  public form: FormGroup;
  public loading = false;
  public isLogin = true;
  public logoPage =  this.dataService.getApiUrl()+"/user/files/logo.png";
  items: string[] = [
    'Español'
      ];

  onHidden(): void {
    console.log('Dropdown is hidden');
  }
  onShown(): void {
    console.log('Dropdown is shown');
  }
  isOpenChange(): void {
    console.log('Dropdown state is changed');
  }

  constructor(public loginService: LoginService , public router: Router, public dataService: DataService, public subSectionService:SubSectionService, public bussineService: BussineService) { }

  ngOnInit() {
    this.stateCss = true;
    this.iniPage();
    this.getBussineAllList();

  }
  public iniPage(){

  }

public setStyle(){
  this.stateCss = !this.stateCss;
}
  logout() {
    this.loginService.logout()
      .subscribe(result => {
        window.location.reload();
      }, e => {
        console.log( "errrr" );
      });
  }

  public getBussineAllList(){
    this.bussine =  new Bussine();
    this.bussine.bussineId=this.dataService.bussineId;
    this.bussineService.getBussineAll(this.bussine)
      .subscribe(result => {
        this.menuData=result;
      }, error => {
        console.log(error);
      });
  }


}
