package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.ArticleDetail;
import com.storeArticle.store.model.accounts.ImageArticle;
import com.storeArticle.store.model.accounts.SubSection;

public interface ArticleDetailCrup {

    boolean addArticleDetail(ArticleDetail articleDetail);

    boolean deleteArticleDetail(int articleDetailId);

    boolean updatedArticleDetail(ArticleDetail articleDetail);

    ArticleDetail getArticleDetail(int articleDetailId);

    Boolean getIsArticleDetail();
}
