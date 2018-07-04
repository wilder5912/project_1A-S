import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './view/user/login/login.component';
import { HomeComponent } from './view/user/home/home.component';
import { RegisterComponent } from './view/user/register/register.component';
import { HomeAdminComponent } from './view/Admin/home-admin/home-admin.component';
import { BusinessComponent } from './view/Admin/business/business.component';
import { ViewDetailArticleComponent } from './view/Admin/view-detail-article/view-detail-article.component';
import { CreateProductAdminComponent } from './view/Admin/create-product-admin/create-product-admin.component';
import { ArticleRelationalComponent } from './view/Admin/article-relational/article-relational.component';
import { GroupProductComponent } from './view/Admin/group-product/group-product.component';
import { SectionProductComponent } from './view/Admin/section-product/section-product.component';
import { SubSectionProductComponent } from './view/Admin/sub-section-product/sub-section-product.component';
import { CreateBannerComponent } from './view/Admin/create-banner/create-banner.component';
import { ArticleComponent } from './view/Admin/article/article.component';
import { LoginAndRegisterComponent } from './view/user/login-and-register/login-and-register.component';
import { ListArticleComponent } from './view/bodyPage/list-article/list-article.component';
import { InformationPageComponent } from './view/bodyPage/information-page/information-page.component';
import { BlogPageComponent } from './view/bodyPage/blog-page/blog-page.component';
import { ArticleDetailComponent } from './view/bodyPage/article-detail/article-detail.component';
import { ContactUsComponent } from './view/bodyPage/contact-us/contact-us.component';
import { HelpPageComponent } from './view/bodyPage/help-page/help-page.component';
import { ChatPageComponent } from './view/bodyPage/chat-page/chat-page.component';
import { AddInformationArticleComponent } from './view/Admin/add-information-article/add-information-article.component';
import { ListArticleFiendComponent } from './view/bodyPage/list-article-fiend/list-article-fiend.component';
import { SubSectionAndArticleComponent } from './view/Admin/sub-section-and-article/sub-section-and-article.component';

const routes: Routes = [
  { path : 'home', component: HomeComponent},
  { path : 'loginRegister', component: LoginAndRegisterComponent},
  { path : 'ListArticle/:id', component: ListArticleComponent},
  { path : 'ListArticleFiend/:name', component: ListArticleFiendComponent},
  { path : 'articleDetail/:id', component: ArticleDetailComponent},
  { path : 'viewDetailArticle/:idArticle', component: ViewDetailArticleComponent},
  { path : 'subSectionAndArticle', component: SubSectionAndArticleComponent},
  { path : 'createBanner', component: CreateBannerComponent},
  { path : 'information', component: InformationPageComponent},
  { path : 'blog', component: BlogPageComponent},
  { path : 'homeAdmin', component: HomeAdminComponent},
  { path : 'createArticleRelational', component: ArticleRelationalComponent},
  { path : 'createBusiness', component: BusinessComponent},
  { path : 'addInformationArticle', component: AddInformationArticleComponent},
  { path : 'groupProduct', component: GroupProductComponent},
  { path : 'sectionProduct', component: SectionProductComponent},
  { path : 'subSectionProduct', component: SubSectionProductComponent},
  { path : 'acticle', component: ArticleComponent},
  { path : 'productCreate', component: CreateProductAdminComponent},
  { path : 'contactUs', component: ContactUsComponent},
  { path : 'HelpPage', component: HelpPageComponent},
  { path : 'chat', component: ChatPageComponent},
  { path: '', component: HomeComponent },
  { path : '', redirectTo: '/home', pathMatch: 'full'},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
