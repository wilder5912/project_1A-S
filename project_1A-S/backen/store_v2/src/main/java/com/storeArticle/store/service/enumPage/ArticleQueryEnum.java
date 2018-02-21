package com.storeArticle.store.service.enumPage;

public enum ArticleQueryEnum {
    getArticle("select article FROM Article as article where article.codigoAr = ? and article.isDelete = ?"),
    getSubSectionList("select section FROM Section as section where section.groupId.isDelete = false and section.isDelete = false"),
    getSubSectionHql("select section FROM Section as section  " +
                            "where section.groupId.groupId = ? and " +
                            "section.nameSection = ? and " +
                            "section.isDelete = ? ");

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
