package com.storeArticle.store.service.enumPage;

public enum ArticleDetailQueryEnum {
    getArticleDetailList("select articleDetail FROM ArticleDetail as articleDetail where articleDetail.isDelete = false"),
    getArticleDetailSubSectionArticleIdHql("select articleDetail FROM ArticleDetail as articleDetail  " +
                            "where articleDetail.subSectionId.subSectionId = ? and " +
                            "articleDetail.articleId.articleId = ? and " +
                            "articleDetail.isDelete = ? "),
    getArticleDetailIdSubSectionHql("select articleDetail.articleId.articleId,articleDetail.subSectionId.subSectionId FROM ArticleDetail as articleDetail  " +
                            "where articleDetail.subSectionId.subSectionId = ? and " +
                            "articleDetail.isDelete = ? ");

    private String hql;

    ArticleDetailQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
