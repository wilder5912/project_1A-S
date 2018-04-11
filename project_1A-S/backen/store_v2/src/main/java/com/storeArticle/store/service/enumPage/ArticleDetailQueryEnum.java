package com.storeArticle.store.service.enumPage;

public enum ArticleDetailQueryEnum {
    getArticleDetailList("select articleDetail FROM ArticleDetail as articleDetail where articleDetail.isDelete = false"),
    getArticleDetailSubSectionArticleIdHql("select articleDetail FROM ArticleDetail as articleDetail  " +
                            " WHERE articleDetail.subSectionId.subSectionId = ? and " +
                            " articleDetail.articleId.articleId = ? and " +
                            " articleDetail.isDelete = ? "),
    getArticleDetailIdSubSectionHql("select articleDetail.articleId.articleId,articleDetail.subSectionId.subSectionId " +
                            " FROM ArticleDetail as articleDetail  " +
                            " WHERE articleDetail.subSectionId.subSectionId = ? and " +
                            " articleDetail.isDelete = ? "),
    getFiendArticleOfBussineHql("select articleDetail.articleId " +
                            " FROM ArticleDetail as articleDetail " +
                            " WHERE (articleDetail.articleId.nameAr like ? or " +
                            " articleDetail.articleId.codigoAr like ? ) and " +
                            " ( articleDetail.subSectionId.sectionId.groupId.bussineId.bussineId = ? and " +
                            "  articleDetail.articleId.isDelete = ? and " +
                            "  articleDetail.isDelete = ? ) "),
    getArticledetailBussineHql("select articleDetail.articleId.articleId, articleDetail.articleId.nameAr" +
                            " FROM ArticleDetail as articleDetail " +
                            " WHERE  articleDetail.subSectionId.sectionId.groupId.bussineId.bussineId = ? and " +
                            "  articleDetail.articleId.isDelete = ? and " +
                            "  articleDetail.isDelete = ? "),
    getArticleBussineHql("select articleDetail " +
                            " FROM ArticleDetail as articleDetail " +
                            " WHERE articleDetail.articleId.isDelete = ? and " +
                            "  articleDetail.isDelete = ? "),
    getSubSectionListArticleIdHql("select articleDetail.articleId.articleId FROM ArticleDetail as articleDetail  " +
                            " WHERE articleDetail.subSectionId.subSectionId = ? and " +
                            " articleDetail.isDelete = ? "),
    updateStateArticleIdDetailHql("update ArticleDetail as articleDetail  " +
            " set articleDetail.isDelete = ? " +
            " where articleDetail.subSectionId.subSectionId = ? "  ),
    getSubSectionArticleIdHql("select articleDetail.articleDetailId FROM ArticleDetail as articleDetail  " +
            " WHERE articleDetail.subSectionId.subSectionId = ? and " +
            " articleDetail.articleId.articleId = ? " );

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
