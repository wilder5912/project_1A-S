package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.ArticleDetail;

public interface ArticleDetailCrup {

    boolean addArticleDetail(ArticleDetail articleDetail);

    boolean deleteArticleDetail(int articleDetailId);

    boolean updatedArticleDetail(ArticleDetail articleDetail);

    ArticleDetail getArticleDetail(int articleDetailId);

    Boolean getIsArticleDetail();
}
