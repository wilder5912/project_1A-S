package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.ArticleRelational;
import com.storeArticle.store.model.accounts.DescriptionArticle;

public interface DescriptionArticleCrup {

    boolean addDescriptionArticle(DescriptionArticle descriptionArticle);

    boolean deleteDescriptionArticle(int descriptionArticleId);

    boolean updatedDescriptionArticle(DescriptionArticle descriptionArticle);

    ArticleRelational getDescriptionArticle(int descriptionArticleId);

    Boolean getIsDescriptionArticle();
}
