package com.storeArticle.store.service.enumPage;

public enum DescriptionArticleQueryEnum {

    getDescriptionArticleArticleId("select descriptionArticle.nameDescriptionarticle" +
                          " FROM DescriptionArticle as descriptionArticle " +
                          " where descriptionArticle.articleId.articleId = ? "  );

    private String hql;

    DescriptionArticleQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
