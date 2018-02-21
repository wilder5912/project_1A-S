package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.Banner;
import com.storeArticle.store.model.accounts.ReviewArticle;

public interface BannerCrup {

    boolean addBanner(Banner banner);

    boolean deleteBanner(int bannerId);

    boolean updatedBanner(Banner banner);

    Banner getBanner(int bannerId);

    Boolean getIsBanner();
}
