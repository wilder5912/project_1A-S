package com.storeArticle.store.service.enumPage;

public enum ReviewArticleQueryEnum {

    getNumReviewArticleHql("select reviewArticle.articleId.articleId, Count(reviewArticle.articleId.articleId) as num FROM ReviewArticle as reviewArticle " +
                          " where reviewArticle.businessId.businessId = ? " +
                          "GROUP BY reviewArticle.articleId.articleId ORDER BY num DESC ");

    private String hql;

    ReviewArticleQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
