package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Banner;

public interface BannerCrup {

    boolean addBanner(Banner banner);

    boolean deleteBanner(int bannerId);

    boolean updatedBanner(Banner banner);

    Banner getBanner(int bannerId);

    Boolean getIsBanner();
}
