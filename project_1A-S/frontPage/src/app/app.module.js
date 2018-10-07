"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var platform_browser_1 = require("@angular/platform-browser");
var core_1 = require("@angular/core");
var angular2_datatable_1 = require("angular2-datatable");
var group_product_pipe_1 = require("./service/pipe/group-product.pipe");
var section_pipe_1 = require("./service/pipe/section.pipe");
var business_pipe_1 = require("./service/pipe/business.pipe");
var sub_section_pipe_1 = require("./service/pipe/sub-section.pipe");
var list_article_pipe_1 = require("./service/pipe/list-article.pipe");
var providerPhone_pipe_1 = require("./service/pipe/providerPhone.pipe");
var Article_pipe_1 = require("./service/pipe/Article.pipe");
var string_filter_pipe_1 = require("./service/pipe/string-filter.pipe");
var provider_pipe_1 = require("./service/pipe/provider.pipe");
var http_1 = require("@angular/http");
var angular2_jwt_1 = require("angular2-jwt");
var forms_1 = require("@angular/forms");
var app_routing_module_1 = require("./app-routing.module");
var http_2 = require("@angular/common/http");
var app_component_1 = require("./app.component");
var login_component_1 = require("./view/user/login/login.component");
var home_component_1 = require("./view/user/home/home.component");
var angular2_fontawesome_1 = require("angular2-fontawesome/angular2-fontawesome");
var ngx_bootstrap_1 = require("ngx-bootstrap");
var index_1 = require("./service/sesion/index");
var shared_service_1 = require("./service/sesion/shared.service");
var data_service_1 = require("./service/dataService/data.service");
var register_component_1 = require("./view/user/register/register.component");
var home_admin_component_1 = require("./view/Admin/home-admin/home-admin.component");
var create_product_admin_component_1 = require("./view/Admin/create-product-admin/create-product-admin.component");
var core_2 = require("@ngx-translate/core");
var http_loader_1 = require("@ngx-translate/http-loader");
var angular2_select_1 = require("angular2-select");
var section_product_component_1 = require("./view/Admin/section-product/section-product.component");
var sub_section_product_component_1 = require("./view/Admin/sub-section-product/sub-section-product.component");
var article_component_1 = require("./view/Admin/article/article.component");
var header_user_component_1 = require("./view/headerPage/header-user/header-user.component");
var header_carousel_component_1 = require("./view/headerPage/header-carousel/header-carousel.component");
var best_review_product_carousel_component_1 = require("./view/bodyPage/best-review-product-carousel/best-review-product-carousel.component");
var footer_user_component_1 = require("./view/footerPage/footer-user/footer-user.component");
var login_and_register_component_1 = require("./view/user/login-and-register/login-and-register.component");
var list_article_component_1 = require("./view/bodyPage/list-article/list-article.component");
var detail_article_component_1 = require("./view/bodyPage/detail-article/detail-article.component");
var blog_page_component_1 = require("./view/bodyPage/blog-page/blog-page.component");
var information_page_component_1 = require("./view/bodyPage/information-page/information-page.component");
var ngx_pagination_1 = require("ngx-pagination");
var article_detail_component_1 = require("./view/bodyPage/article-detail/article-detail.component");
var ng2_carouselamos_1 = require("ng2-carouselamos");
var create_banner_component_1 = require("./view/Admin/create-banner/create-banner.component");
var load_page_component_1 = require("./view/bodyPage/load-page/load-page.component");
var common_1 = require("@angular/common");
var home_admin_page_component_1 = require("./view/Admin/home-admin-page/home-admin-page.component");
var chat_page_component_1 = require("./view/bodyPage/chat-page/chat-page.component");
var websocket_service_1 = require("./service/webSocketServicePage/websocket.service");
var contact_us_component_1 = require("./view/bodyPage/contact-us/contact-us.component");
var help_page_component_1 = require("./view/bodyPage/help-page/help-page.component");
var angular2_useful_swiper_1 = require("angular2-useful-swiper");
var ngx_carousel_1 = require("ngx-carousel");
require("hammerjs");
var carousel_article_page_component_1 = require("./view/bodyPage/carousel-article-page/carousel-article-page.component");
var carousel_image_article_component_1 = require("./view/bodyPage/carousel-image-article/carousel-image-article.component");
var show_image_modal_component_1 = require("./view/bodyPage/show-image-modal/show-image-modal.component");
var article_relational_component_1 = require("./view/Admin/article-relational/article-relational.component");
var list_article_fiend_component_1 = require("./view/bodyPage/list-article-fiend/list-article-fiend.component");
var list_page_article_component_1 = require("./view/bodyPage/list-page-article/list-page-article.component");
var fiend_article_page_component_1 = require("./view/bodyPage/fiend-article-page/fiend-article-page.component");
var add_information_article_component_1 = require("./view/Admin/add-information-article/add-information-article.component");
var group_product_component_1 = require("./view/Admin/group-product/group-product.component");
var view_detail_article_component_1 = require("./view/Admin/view-detail-article/view-detail-article.component");
var form_create_article_component_1 = require("./view/Admin/form-create-article/form-create-article.component");
var form_list_article_image_component_1 = require("./view/Admin/form-list-article-image/form-list-article-image.component");
var form_list_article_information_component_1 = require("./view/Admin/form-list-article-information/form-list-article-information.component");
var sub_section_and_article_component_1 = require("./view/Admin/sub-section-and-article/sub-section-and-article.component");
var business_component_1 = require("./view/Admin/business/business.component");
var provider_component_1 = require("./view/Admin/ProviderAdmin/provider/provider.component");
var article_provider_component_1 = require("./view/Admin/ProviderAdmin/article-provider/article-provider.component");
var warehouse_component_1 = require("./view/Admin/WarehouseAdmin/warehouse/warehouse.component");
var add_pro_to_bus_component_1 = require("./view/Admin/ProviderAdmin/add-pro-to-bus/add-pro-to-bus.component");
var code_ar_pipe_1 = require("./service/pipe/warehouse/code-ar.pipe");
var code_article_provider_pipe_1 = require("./service/pipe/warehouse/code-article-provider.pipe");
var id_warehouse_pipe_1 = require("./service/pipe/warehouse/id-warehouse.pipe");
var name_ar_pipe_1 = require("./service/pipe/warehouse/name-ar.pipe");
var name_bus_pipe_1 = require("./service/pipe/warehouse/name-bus.pipe");
var name_sub_section_pipe_1 = require("./service/pipe/warehouse/name-sub-section.pipe");
var precy_ar_pipe_1 = require("./service/pipe/warehouse/precy-ar.pipe");
var quantyti_currect_pipe_1 = require("./service/pipe/warehouse/quantyti-currect.pipe");
var quantyti_provider_pipe_1 = require("./service/pipe/warehouse/quantyti-provider.pipe");
var main_warehouse_code_pipe_1 = require("./service/pipe/warehouse/main-warehouse-code.pipe");
var fature_warehouse_pipe_1 = require("./service/pipe/warehouse/fature-warehouse.pipe");
var home_cashier_page_component_1 = require("./view/cashier/home-cashier-page/home-cashier-page.component");
var home_cashier_component_1 = require("./view/cashier/home-cashier/home-cashier.component");
var type_money_component_1 = require("./view/Admin/type-money/type-money.component");
var type_money_id_pipe_1 = require("./service/pipe/typeMoney/type-money-id.pipe");
var name_type_money_pipe_1 = require("./service/pipe/typeMoney/name-type-money.pipe");
var type_change_type_money_pipe_1 = require("./service/pipe/typeMoney/type-change-type-money.pipe");
var role_user_component_1 = require("./view/Admin/role-user/role-user.component");
var role_user_id_pipe_1 = require("./service/pipe/roleUser/role-user-id.pipe");
var name_role_pipe_1 = require("./service/pipe/roleUser/name-role.pipe");
var detaill_role_component_1 = require("./view/Admin/DetailRoleUser/detaill-role/detaill-role.component");
var look_for_user_component_1 = require("./view/Admin/DetailRoleUser/look-for-user/look-for-user.component");
var detail_role_user_component_1 = require("./view/Admin/DetailRoleUser/detail-role-user/detail-role-user.component");
var info_user_component_1 = require("./view/Admin/DetailRoleUser/info-user/info-user.component");
function createTranslateLoader(http) {
    return new http_loader_1.TranslateHttpLoader(http, './assets/i18n/', '.json');
}
exports.createTranslateLoader = createTranslateLoader;
function authHttpServiceFactory(http, options) {
    return new angular2_jwt_1.AuthHttp(new angular2_jwt_1.AuthConfig({
        tokenName: 'token',
        tokenGetter: (function () { return sessionStorage.getItem('token'); }),
        globalHeaders: [{ 'Content-Type': 'application/json' }],
    }), http, options);
}
exports.authHttpServiceFactory = authHttpServiceFactory;
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            declarations: [
                app_component_1.AppComponent,
                login_component_1.LoginComponent,
                home_component_1.HomeComponent,
                register_component_1.RegisterComponent,
                home_admin_component_1.HomeAdminComponent,
                create_product_admin_component_1.CreateProductAdminComponent,
                group_product_component_1.GroupProductComponent,
                group_product_pipe_1.GroupProductPipe,
                section_pipe_1.SectionPipe,
                sub_section_pipe_1.SubSectionPipe,
                list_article_pipe_1.ListArticlePipe,
                Article_pipe_1.ArticlePipe,
                business_pipe_1.BusinnesPipe,
                provider_pipe_1.ProviderPipe,
                providerPhone_pipe_1.ProviderPhonePipe,
                string_filter_pipe_1.StringFilterPipe,
                section_product_component_1.SectionProductComponent,
                sub_section_product_component_1.SubSectionProductComponent,
                article_component_1.ArticleComponent,
                header_user_component_1.HeaderUserComponent,
                header_carousel_component_1.HeaderCarouselComponent,
                best_review_product_carousel_component_1.BestReviewProductCarouselComponent,
                footer_user_component_1.FooterUserComponent,
                login_and_register_component_1.LoginAndRegisterComponent,
                list_article_component_1.ListArticleComponent,
                detail_article_component_1.DetailArticleComponent,
                blog_page_component_1.BlogPageComponent,
                information_page_component_1.InformationPageComponent,
                article_detail_component_1.ArticleDetailComponent,
                create_banner_component_1.CreateBannerComponent,
                load_page_component_1.LoadPageComponent,
                home_admin_page_component_1.HomeAdminPageComponent,
                chat_page_component_1.ChatPageComponent,
                contact_us_component_1.ContactUsComponent,
                help_page_component_1.HelpPageComponent,
                carousel_article_page_component_1.CarouselArticlePageComponent,
                carousel_image_article_component_1.CarouselImageArticleComponent,
                show_image_modal_component_1.ShowImageModalComponent,
                article_relational_component_1.ArticleRelationalComponent,
                list_article_fiend_component_1.ListArticleFiendComponent,
                list_page_article_component_1.ListPageArticleComponent,
                fiend_article_page_component_1.FiendArticlePageComponent,
                add_information_article_component_1.AddInformationArticleComponent,
                view_detail_article_component_1.ViewDetailArticleComponent,
                form_create_article_component_1.FormCreateArticleComponent,
                form_list_article_image_component_1.FormListArticleImageComponent,
                form_list_article_information_component_1.FormListArticleInformationComponent,
                sub_section_and_article_component_1.SubSectionAndArticleComponent,
                business_component_1.BusinessComponent,
                provider_component_1.ProviderComponent,
                article_provider_component_1.ArticleProviderComponent,
                warehouse_component_1.WarehouseComponent,
                add_pro_to_bus_component_1.AddProToBusComponent,
                code_ar_pipe_1.CodeArPipe,
                code_article_provider_pipe_1.CodeArticleProviderPipe,
                id_warehouse_pipe_1.IdWarehousePipe,
                name_ar_pipe_1.NameArPipe,
                name_bus_pipe_1.NameBusPipe,
                name_sub_section_pipe_1.NameSubSeccionPipe,
                precy_ar_pipe_1.PrecyArPipe,
                quantyti_currect_pipe_1.QuantytiCurrectPipe,
                quantyti_provider_pipe_1.QuantytiProviderPipe,
                main_warehouse_code_pipe_1.MainWarehouseCodePipe,
                fature_warehouse_pipe_1.FatureWarehousePipe,
                home_cashier_page_component_1.HomeCashierPageComponent,
                home_cashier_component_1.HomeCashierComponent,
                type_money_component_1.TypeMoneyComponent,
                type_money_id_pipe_1.TypeMoneyIdPipe,
                name_type_money_pipe_1.NameTypeMoneyPipe,
                type_change_type_money_pipe_1.TypeChangeTypeMoneyPipe,
                role_user_component_1.RoleUserComponent,
                role_user_id_pipe_1.RoleUserIdPipe,
                name_role_pipe_1.NameRolePipe,
                detaill_role_component_1.DetaillRoleComponent,
                look_for_user_component_1.LookForUserComponent,
                detail_role_user_component_1.DetailRoleUserComponent,
                info_user_component_1.InfoUserComponent,
            ],
            imports: [
                platform_browser_1.BrowserModule,
                forms_1.FormsModule,
                forms_1.ReactiveFormsModule,
                app_routing_module_1.AppRoutingModule,
                angular2_select_1.SelectModule,
                ngx_bootstrap_1.AlertModule.forRoot(),
                ngx_bootstrap_1.ModalModule.forRoot(),
                ngx_bootstrap_1.BsDropdownModule.forRoot(),
                ngx_pagination_1.NgxPaginationModule,
                ngx_bootstrap_1.TabsModule.forRoot(),
                ngx_bootstrap_1.PopoverModule.forRoot(),
                ngx_bootstrap_1.RatingModule.forRoot(),
                ngx_bootstrap_1.BsDatepickerModule.forRoot(),
                http_2.HttpClientModule,
                angular2_fontawesome_1.Angular2FontawesomeModule,
                angular2_datatable_1.DataTableModule,
                ng2_carouselamos_1.Ng2CarouselamosModule,
                angular2_useful_swiper_1.SwiperModule,
                ngx_carousel_1.NgxCarouselModule,
                core_2.TranslateModule.forRoot({
                    loader: {
                        provide: core_2.TranslateLoader,
                        useFactory: (createTranslateLoader),
                        deps: [http_2.HttpClient]
                    }
                }),
            ],
            providers: [
                websocket_service_1.WebSocketService,
                index_1.AuthGuard,
                shared_service_1.SharedService,
                data_service_1.DataService,
                [{ provide: common_1.LocationStrategy, useClass: common_1.HashLocationStrategy }],
                angular2_jwt_1.JwtHelper,
                {
                    provide: angular2_jwt_1.AuthHttp,
                    useFactory: authHttpServiceFactory,
                    deps: [http_1.Http, http_1.RequestOptions]
                }
            ],
            bootstrap: [app_component_1.AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
