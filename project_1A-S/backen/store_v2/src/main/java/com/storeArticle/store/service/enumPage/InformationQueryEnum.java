package com.storeArticle.store.service.enumPage;

public enum InformationQueryEnum {

    getInformationArticleId("select information.nameInformation , information.detailInformation " +
                          " FROM Information as information " +
                          " where information.articleId.articleId = ? "  );

    private String hql;

    InformationQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
