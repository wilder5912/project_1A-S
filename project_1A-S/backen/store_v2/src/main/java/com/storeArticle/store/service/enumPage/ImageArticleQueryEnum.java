package com.storeArticle.store.service.enumPage;

public enum ImageArticleQueryEnum {
    getImageArticleList("select imageArticle FROM ImageArticle as imageArticle where imageArticle.isDelete = false "),
    getImageArticleIdList("select imageArticle FROM ImageArticle as imageArticle " +
                            "where imageArticle.articleId.articleId = ? and " +
                            "imageArticle.isDelete = ? " ),
    getImageArticleIdListObject("select imageArticle.imageArticleId,imageArticle.nombreImageActicle FROM ImageArticle as imageArticle " +
                            "where imageArticle.articleId.articleId = ? and " +
                            "imageArticle.isDelete = ? " ),
    getSubSectionHql("select section FROM Section as section  " +
                            "where section.groupId.groupId = ? and " +
                            "section.nameSection = ? and " +
                            "section.isDelete = ? ");

    private String hql;

    ImageArticleQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
