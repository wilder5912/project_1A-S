package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.ImageArticle;

public interface ImageArticleCrup {

    boolean addImageArticle(ImageArticle imageArticle);

    boolean deleteImageArticle(int articleId);

    boolean updatedImageArticle(ImageArticle imageArticle);

    ImageArticle getImageArticle(int imageArticleId);

    Boolean getIsImageArticle();
}
