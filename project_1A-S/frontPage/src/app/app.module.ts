import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { DataTableModule} from 'angular2-datatable';
import { GroupProductPipe } from './service/pipe/group-product.pipe';
import { SectionPipe } from './service/pipe/section.pipe';
import { SubSectionPipe } from './service/pipe/sub-section.pipe';
import { ArticlePipe } from './service/pipe/Article.pipe';
import { StringFilterPipe } from './service/pipe/string-filter.pipe';
import { Http, RequestOptions } from '@angular/http';
import { AuthHttp, AuthConfig , JwtHelper } from 'angular2-jwt';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule , HttpClient } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './view/user/login/login.component';
import { HomeComponent } from './view/user/home/home.component';
import { Angular2FontawesomeModule } from 'angular2-fontawesome/angular2-fontawesome';
import { AlertModule, ModalModule, PopoverModule, RatingModule , BsDropdownModule, TabsModule, BsDatepickerModule } from 'ngx-bootstrap';
import { AuthGuard } from './service/sesion/index';
import { SharedService } from './service/sesion/shared.service';
import { DataService } from './service/dataService/data.service';
import { RegisterComponent } from './view/user/register/register.component';
import { HomeAdminComponent } from './view/Admin/home-admin/home-admin.component';
import { CreateProductAdminComponent } from './view/Admin/create-product-admin/create-product-admin.component';
import { TranslateModule, TranslateLoader} from '@ngx-translate/core';
import { TranslateHttpLoader} from '@ngx-translate/http-loader';
import { SelectModule} from 'angular2-select';
import { SectionProductComponent } from './view/Admin/section-product/section-product.component';
import { SubSectionProductComponent } from './view/Admin/sub-section-product/sub-section-product.component';
import { ArticleComponent } from './view/Admin/article/article.component';
import { HeaderUserComponent } from './view/headerPage/header-user/header-user.component';
import { HeaderCarouselComponent } from './view/headerPage/header-carousel/header-carousel.component';
import { BestReviewProductCarouselComponent } from './view/bodyPage/best-review-product-carousel/best-review-product-carousel.component';
import { FooterUserComponent } from './view/footerPage/footer-user/footer-user.component';
import { LoginAndRegisterComponent } from './view/user/login-and-register/login-and-register.component';
import { ListArticleComponent } from './view/bodyPage/list-article/list-article.component';
import { DetailArticleComponent } from './view/bodyPage/detail-article/detail-article.component';
import { BlogPageComponent } from './view/bodyPage/blog-page/blog-page.component';
import { InformationPageComponent } from './view/bodyPage/information-page/information-page.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { ArticleDetailComponent } from './view/bodyPage/article-detail/article-detail.component';
import { Ng2CarouselamosModule } from 'ng2-carouselamos';
import { CreateBannerComponent } from './view/Admin/create-banner/create-banner.component';
import { LoadPageComponent } from './view/bodyPage/load-page/load-page.component';
import { HashLocationStrategy, LocationStrategy} from '@angular/common';
import { HomeAdminPageComponent } from './view/Admin/home-admin-page/home-admin-page.component';
import { ChatPageComponent } from './view/bodyPage/chat-page/chat-page.component';
import { WebSocketService } from './service/webSocketServicePage/websocket.service';
import { ContactUsComponent } from './view/bodyPage/contact-us/contact-us.component';
import { HelpPageComponent } from './view/bodyPage/help-page/help-page.component';
import { SwiperModule } from 'angular2-useful-swiper';
import { NgxCarouselModule } from 'ngx-carousel';
import 'hammerjs';
import { CarouselArticlePageComponent } from './view/bodyPage/carousel-article-page/carousel-article-page.component';
import { CarouselImageArticleComponent } from './view/bodyPage/carousel-image-article/carousel-image-article.component';
import { ShowImageModalComponent } from './view/bodyPage/show-image-modal/show-image-modal.component';
import { ArticleRelationalComponent } from './view/Admin/article-relational/article-relational.component';
import { ListArticleFiendComponent } from './view/bodyPage/list-article-fiend/list-article-fiend.component';
import { ListPageArticleComponent } from './view/bodyPage/list-page-article/list-page-article.component';
import { FiendArticlePageComponent } from './view/bodyPage/fiend-article-page/fiend-article-page.component';
import { AddInformationArticleComponent } from './view/Admin/add-information-article/add-information-article.component';
import { GroupProductComponent } from './view/Admin/group-product/group-product.component';

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig({
    tokenName: 'token',
    tokenGetter: (() => sessionStorage.getItem('token')),
    globalHeaders: [{'Content-Type': 'application/json'}],
  }), http, options);
}

@NgModule({
  declarations: [
    AppComponent,
     LoginComponent,
    HomeComponent,
    RegisterComponent,
    HomeAdminComponent,
    CreateProductAdminComponent,
    GroupProductComponent,
    GroupProductPipe,
    SectionPipe,
    SubSectionPipe,
    ArticlePipe,
    StringFilterPipe,
    SectionProductComponent,
    SubSectionProductComponent,
    ArticleComponent,
    HeaderUserComponent,
    HeaderCarouselComponent,
    BestReviewProductCarouselComponent,
    FooterUserComponent,
    LoginAndRegisterComponent,
    ListArticleComponent,
    DetailArticleComponent,
    BlogPageComponent,
    InformationPageComponent,
    ArticleDetailComponent,
    CreateBannerComponent,
    LoadPageComponent,
    HomeAdminPageComponent,
    ChatPageComponent,
    ContactUsComponent,
    HelpPageComponent,
    CarouselArticlePageComponent,
    CarouselImageArticleComponent,
    ShowImageModalComponent,
    ArticleRelationalComponent,
    ListArticleFiendComponent,
    ListPageArticleComponent,
    FiendArticlePageComponent,
    AddInformationArticleComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    SelectModule,
    AlertModule.forRoot(),
    ModalModule.forRoot(),
    BsDropdownModule.forRoot(),
    NgxPaginationModule,
    TabsModule.forRoot(),
    PopoverModule.forRoot(),
    RatingModule.forRoot(),
    BsDatepickerModule.forRoot(),
    HttpClientModule,
    Angular2FontawesomeModule,
    DataTableModule,
    Ng2CarouselamosModule,
    SwiperModule,
    NgxCarouselModule,
      TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [HttpClient]
      }
    }),
    ],
  providers: [
    WebSocketService,
    AuthGuard,
    SharedService,
    DataService,
    [{provide: LocationStrategy, useClass: HashLocationStrategy}],
    JwtHelper,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions]
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
