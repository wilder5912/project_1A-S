import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from '../../../model/usuario/User';
import { UserService } from '../../../service/accounts/userService';
import { DataService } from '../../../service/dataService/data.service';
import { LoginService } from '../../../service/accounts/loginService';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [UserService,LoginService]
})
export class RegisterComponent implements OnInit {
  public model: User = new User();
  public user: User = new User();
  public form: FormGroup;
  public emailExist;


  constructor(public userService:UserService ,public dataService:DataService,public translate: TranslateService, public loginService:LoginService, private formBuilder: FormBuilder) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.model =this.dataService.AUTH_CONFIG;
    this.formValidateModal();
  }

  public registerUser() {
    if(this.getValidateInfo()) {
      this.dataService.imageLoadPage = true;
      this.user = new User();
      this.user.firtNameUser = this.form.value['firtNameUser'];
      this.user.lastNameUser = this.form.value['lastNameUser'];
      this.user.emailUser = this.form.value['emailUser'];
      this.user.password = window.btoa(this.form.value['password']);

      this.userService.register(this.user)
        .subscribe(result => {
          if (result) {
            //this.user = result;
            this.emailExist = true;
            sessionStorage.setItem('token',result.tokenUser);
            localStorage.setItem('currentUser', JSON.stringify({ emailUser: result.emailUser, token: 'fake-jwt-token' }));
            window.location.reload();
          } else {
            this.emailExist=false;
          }
          this.dataService.imageLoadPage = false;
        }, e => {
          console.log("errrr")
        });
    }
  }


  public formValidateModal(){
    this.form = this.formBuilder.group({
      firtNameUser:['',Validators.compose([
        Validators.required,
        Validators.minLength(3)
      ])],
      lastNameUser:['',Validators.compose([
        Validators.required,
        Validators.minLength(3)
      ])],
      emailUser:['',Validators.compose([
        Validators.required,
        Validators.minLength(3),
        Validators.email
      ])],
      password:['',Validators.compose([
        Validators.required,
        Validators.minLength(3)
      ])]
    });
  }

  public getValidateInfo():boolean{
    let stateBaoolean= true;
    let sectionInfo = [
      {"SectionInformation":this.form.controls.firtNameUser.errors},
      {"SectionInformation":this.form.controls.lastNameUser.errors},
      {"SectionInformation":this.form.controls.emailUser.errors},
      {"SectionInformation":this.form.controls.password.errors}
    ];
    sectionInfo.forEach(function(keyForm: any,i){
      if(null !== keyForm.SectionInformation){
        stateBaoolean=false;
      }
    });
    return stateBaoolean;
  }
}
