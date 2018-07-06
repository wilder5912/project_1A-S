package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.Article;
import com.storeArticle.store.model.groupProductModel.ReviewArticle;

public interface ReviewArticleCrup {

    boolean addReviewArticle(ReviewArticle article);

    boolean deleteReviewArticle(int reviewArticleId);

    boolean updatedReviewArticle(ReviewArticle reviewArticle);

    Article getReviewArticle(int reviewArticleId);

    Boolean getIsReviewArticle();
}
