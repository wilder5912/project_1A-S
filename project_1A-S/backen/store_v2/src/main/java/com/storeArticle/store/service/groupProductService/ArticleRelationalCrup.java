package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ArticleRelational;
import com.storeArticle.store.model.accounts.ReviewArticle;

public interface ArticleRelationalCrup {

    boolean addArticleRelational(ArticleRelational articleRelational);

    boolean deleteArticleRelational(int articleRelationalId);

    boolean updatedArticleRelational(ArticleRelational articleRelational);

    ArticleRelational getArticleRelational(int articleRelationalId);

    Boolean getIsArticleRelational();
}
