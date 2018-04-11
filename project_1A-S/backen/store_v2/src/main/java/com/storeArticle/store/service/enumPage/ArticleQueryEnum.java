package com.storeArticle.store.service.enumPage;

public enum ArticleQueryEnum {
    getArticle("select article FROM Article as article where article.codigoAr = ? and article.isDelete = ?"),
    getArticleList("select article.articleId, article.nameAr, article.codigoAr " +
            " FROM Article as article " +
            " where article.isDelete = ? ");

    private String hql;

    ArticleQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
