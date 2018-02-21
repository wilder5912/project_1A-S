package com.storeArticle.store.service.enumPage;

public enum ArticleRelationalQueryEnum {

    getArticleRelationalHqlArticleId("select articleRelational.artArticleId.articleId, articleRelational.bussineId.bussineId  FROM ArticleRelational as articleRelational " +
                          " where articleRelational.bussineId.bussineId= ? and " +
                          " articleRelational.articleId.articleId = ?");

    private String hql;

    ArticleRelationalQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
