import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import { Article } from "../../../model/product/Article";
import { User } from "../../../model/usuario/User";
import { Comment } from "../../../model/product/Comment";
import { ArticleService } from "../../../service/product/ArticleService";
import { CommentService } from "../../../service/product/CommentService";
import { DataService } from '../../../service/dataService/data.service';
import { TranslateService } from '@ngx-translate/core';
declare var $:any;

import { WebSocketService } from "../../../service/webSocketServicePage/websocket.service";
import { PaginationInstance } from '../../../../../node_modules/ngx-pagination/dist/ngx-pagination.module';

import { BoxService } from '../../../service/boxArticle/BoxService';
import { Box } from '../../../model/boxArticle/Box';
import { ListProduct } from '../../../model/boxArticle/ListProduct';
import { Bussine } from '../../../model/bussine/Bussine';
import { ValidateNumberPositive } from '../../../service/validate/validateNumberPositive.directive';
import { ValidateNumber } from '../../../service/validate/validateNumber.directive';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css'],
  providers:[ ArticleService, CommentService , BoxService]
})
export class ArticleDetailComponent implements OnInit {
  public form: FormGroup;
  public id;
  public article: Article= new Article();
  public user: User= new User();
  public detailArticle;
  public imageActicle;
  public commentArticle;
  public items;
  public articleRelational;
  public max = 10;
  public comment: Comment = new Comment();
  public isReadonly = true;
  public overStar: number;
  public percent: number;
  public filter: string = '';
  public maxSize: number = 7;
  public directionLinks: boolean = true;
  public autoHide: boolean = false;
  public config: PaginationInstance = {
    id: 'advanced',
    itemsPerPage: 6,
    currentPage: 1
  };
  public titleArticleRelational = "Producto Relacionado";
  public box: Box = new Box();
  public listProduct: ListProduct = new ListProduct();

  public bussine: Bussine = new Bussine();


constructor(private route: ActivatedRoute , public boxService:BoxService , public webSocketService: WebSocketService, public articleService:ArticleService,private formBuilder: FormBuilder ,public commentService:CommentService, public dataService:DataService, public translate: TranslateService,) {
    translate.setDefaultLang(dataService.languagePage);
    translate.use(dataService.languagePage);

  }

  ngOnInit() {
     this.dataService.imageLoadPage = true;
     this.getIdArticleDetail();
     this.formValidateModal();
     this.sokectComment();

  }

  public sokectComment(){
    let stompClient = this.webSocketService.connect();
    stompClient.connect({}, frame => {
      stompClient.subscribe('/topic/listComment', listComment => {
        if(null !== this.id){
          this.comment =  new Comment();
          this.article.articleId = this.id;
          this.comment.articleId = this.article;
          this.commentService.getCommentArticleId(this.comment)
            .subscribe(result=>{
              this.commentArticle = result;
            });
        }

      });

    });
  }

  private popped = [];
  onPageChange(number: number) {
    this.config.currentPage = number;
  }

  public labels: any = {
    previousLabel: 'Previous',
    nextLabel: 'Next',
    screenReaderPaginationLabel: 'Pagination',
    screenReaderPageLabel: 'page',
    screenReaderCurrentLabel: 'tu pagina'
  };


  public hoveringOver(value: number): void {
    this.overStar = value;
    this.percent = (value / this.max) * 100;
  }
  public getIdArticleDetail(){
    this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.getArticleDetailData(this.id);
    });
  }

  public formValidateModal(){
    this.form = this.formBuilder.group({
      ratingP:['', Validators.compose([
        Validators.required,
      ])],
      nameComment:['', Validators.compose([
        Validators.required,
        Validators.minLength(3)
      ])],
      numberArtcle:['', Validators.compose([
        Validators.required,
        ValidateNumberPositive.verificateNumberpositive,
        ValidateNumber.verificateNumber
      ])]
    });
  }

  public getValidateInfo():boolean{
    let stateBaoolean= true;
    let sectionInfo = [
      {"SectionInformation":this.form.controls.ratingP.errors},
      {"SectionInformation":this.form.controls.nameComment.errors},
    ];
    sectionInfo.forEach(function(keyForm: any,i){
      if(null !== keyForm.SectionInformation){
        stateBaoolean=false;
      }
    });
    return stateBaoolean;
  }



  public getArticleDetailData(idArticle:number){
    this.article = new Article();
    this.article.articleId=idArticle;
    this.articleService.getArticleDetailData(this.article)
      .subscribe(result=>{
       this.detailArticle=result;
        this.commentArticle = this.detailArticle.commentVEOS;
        this.dataService.imageActicle = this.getImage(this.detailArticle.imageMainAr);
         let ListImae=[];
         ListImae.push({"name":this.detailArticle.imageMainAr})
         this.detailArticle.imageArticleVEOS.forEach(function(dataArray, index) {
          let nameimage = {"name": dataArray.nombreImageActicle};
          ListImae.push({"name": dataArray.nombreImageActicle});
        });
        this.items = ListImae;
        this.getArticleRelational(this.dataService.bussineId,idArticle);
        this.dataService.imageLoadPage=false;
  });

  }


  public getImage(imageActicle){
    return  this.dataService.getApiUrl()+'/imageArticle/files/'+imageActicle;
  }

  public imageClick(image) {
    this.dataService.imageActicle = this.getImage(image.name);
  }
  public showImage(){
  }

  public getArticleRelational(bussineId: number, articleId:number){
  this.articleService.getArticleRelationalArticleIdBussineId(bussineId,articleId)
    .subscribe(result=>{
        this.articleRelational = result;
        if(this.articleRelational.length == 0){
          this.articleRelational = null;
        }

    });

  }

  public addComment(){
    if(this.getValidateInfo()){
      let date=  new Date();
      this.comment= new Comment();
      this.comment.rating = this.form.value['ratingP'];
      this.comment.nameComment = this.form.value['nameComment'];
      this.comment.dateComment = this.dataService.getDateAndHour(date+"");
      this.user.userID=this.dataService.AUTH_CONFIG.userID;
      this.comment.userId=this.user;
      this.article.articleId= this.id;
      this.comment.articleId= this.article;
      this.commentService.addCommentAndGetCommentList(this.comment)
        .subscribe(result=>{
          this.commentArticle = result;
          this.form.controls['ratingP'].setValue(0);
          this.form.controls['nameComment'].setValue('');

        });


    }


  }

  public getBoxArticle(box: Box) {

    this.boxService.getBoxListArticle(box)
      .subscribe( result =>{
        this.dataService.getListArticle = result;
        this.dataService.articleValue = 0;
        let coste = 0;
        this.dataService.getListArticle.listProductVEO.articleVEO.forEach(function(keyForm: any,i){
          coste = coste + (keyForm.numProduct * keyForm.precyAr);
        });

        this.dataService.articleValue = coste;
      });
  }
  public addArticle(articleData) {

    if(null == this.form.controls.numberArtcle.errors) {
      this.box = new Box();
      this.user = new User();
      this.article = new Article();
      this.bussine = new Bussine();
      this.listProduct = new ListProduct();
      this.bussine.bussineId = this.dataService.bussineId;
      this.user.userID = this.dataService.AUTH_CONFIG.userID;
      this.box.boxId = this.dataService.boxIdUser;
      this.box.userID = this.user;
      this.box.bussineId = this.bussine;
      this.listProduct.boxId = this.box;
      this.article.articleId = articleData.articleId;
      this.listProduct.articleId = this.article;
      this.listProduct.numProduct = this.form.value['numberArtcle'];
      this.boxService.addBoxArticle(this.listProduct)
        .subscribe(result => {
          console.log(result);
          this.getBoxArticle(this.box);
        });
    }
  }

}
