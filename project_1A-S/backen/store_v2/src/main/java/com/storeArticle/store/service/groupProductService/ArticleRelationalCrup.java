package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.ArticleRelational;

public interface ArticleRelationalCrup {

    boolean addArticleRelational(ArticleRelational articleRelational);

    boolean deleteArticleRelational(int articleRelationalId);

    boolean updatedArticleRelational(ArticleRelational articleRelational);

    ArticleRelational getArticleRelational(int articleRelationalId);

    Boolean getIsArticleRelational();
}
