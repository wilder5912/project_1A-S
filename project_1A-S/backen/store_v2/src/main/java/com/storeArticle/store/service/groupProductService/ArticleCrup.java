package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.SubSection;

public interface ArticleCrup {

    boolean addArticle(Article article);

    boolean deleteArticle(int articleId);

    boolean updatedArticle(Article article);

    Article getArticle(int articleId);

    Boolean getIsArticle();
}
