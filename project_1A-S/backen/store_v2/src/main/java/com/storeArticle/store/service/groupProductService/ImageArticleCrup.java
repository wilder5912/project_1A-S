package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.ImageArticle;
import com.storeArticle.store.model.accounts.SubSection;

public interface ImageArticleCrup {

    boolean addImageArticle(ImageArticle imageArticle);

    boolean deleteArticle(int articleId);

    boolean updatedArticle(ImageArticle imageArticle);

    SubSection getImageArticle(int imageArticleId);

    Boolean getIsImageArticle();
}
