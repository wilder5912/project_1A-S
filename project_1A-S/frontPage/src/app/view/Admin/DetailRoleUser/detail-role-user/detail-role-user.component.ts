import { Component, TemplateRef, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from '../../../../service/dataService/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TranslateService } from '@ngx-translate/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-detail-role-user',
  templateUrl: './detail-role-user.component.html',
  styleUrls: ['./detail-role-user.component.css']
})
export class DetailRoleUserComponent implements OnInit {
  public idUser: number;
  constructor(private router: Router , private formBuilder: FormBuilder,
              public dataService: DataService, public modalService: BsModalService,
              public translate: TranslateService, private route: ActivatedRoute) {
    translate.setDefaultLang(dataService.languagePage );
    translate.use(dataService.languagePage);
  }

  ngOnInit() {
    this.dataService.redirectTypeUser();
    this.getIdArticleDetail();
  }

  public getIdArticleDetail() {
    this.route.params.subscribe(params => {
      this.idUser = +params['idUser'];
      console.log(this.idUser);
    });
  }

}
