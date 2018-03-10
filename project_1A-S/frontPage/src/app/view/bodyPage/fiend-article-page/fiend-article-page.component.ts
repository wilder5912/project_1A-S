import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DataService } from '../../../service/dataService/data.service';

@Component({
  selector: 'app-fiend-article-page',
  templateUrl: './fiend-article-page.component.html',
  styleUrls: ['./fiend-article-page.component.css']
})
export class FiendArticlePageComponent implements OnInit {
  public form: FormGroup;

  constructor(private formBuilder: FormBuilder, public dataService: DataService) { }

  ngOnInit() {
    this.formValidateModal();
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
