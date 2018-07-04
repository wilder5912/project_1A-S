package com.storeArticle.store.service.enumPage;

public enum ArticleRelationalQueryEnum {

    getArticleRelationalHqlArticleId("select articleRelational.artArticleId.articleId, articleRelational.businessId.businessId  FROM ArticleRelational as articleRelational " +
                          " where articleRelational.businessId.businessId= ? and " +
                          " articleRelational.articleId.articleId = ? and " +
                          " articleRelational.isDelete = ?"),
    getArticleIdRelationalHql("select articleRelational.artArticleId.articleId" +
                        " FROM ArticleRelational as articleRelational " +
                        " where articleRelational.businessId.businessId= ? and " +
                        " articleRelational.articleId.articleId = ? and " +
                        " articleRelational.isDelete = ? "),
    isArticleIdRelationalHql("select articleRelational.articleRelationalId" +
                        " FROM ArticleRelational as articleRelational " +
                        " where articleRelational.businessId.businessId= ? and " +
                        " articleRelational.articleId.articleId = ? and " +
                        " articleRelational.artArticleId.articleId = ? " ),
    updateStateArticleIdRelationalHql("update ArticleRelational as articleRelational  " +
                        " set articleRelational.isDelete = ? " +
                        " where articleRelational.businessId.businessId = ? and " +
                        " articleRelational.articleId.articleId = ?  " ) ;

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
