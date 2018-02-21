package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ReviewArticle;

public interface ReviewArticleCrup {

    boolean addReviewArticle(ReviewArticle article);

    boolean deleteReviewArticle(int reviewArticleId);

    boolean updatedReviewArticle(ReviewArticle reviewArticle);

    Article getReviewArticle(int reviewArticleId);

    Boolean getIsReviewArticle();
}
