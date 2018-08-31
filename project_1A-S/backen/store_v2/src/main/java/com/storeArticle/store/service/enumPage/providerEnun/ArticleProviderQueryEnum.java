package com.storeArticle.store.service.enumPage.providerEnun;

public enum ArticleProviderQueryEnum {

    getListArticleProviderHql("select articleProvider FROM ArticleProvider as articleProvider where articleProvider.isDelete = false"),
    getlookForArticleProvider("select articleProvider FROM ArticleProvider as articleProvider " +
                               "where articleProvider.codeArticleProvider = ? " +
                                "and articleProvider.isDelete = ? ")
    ;

    private String hql;

    ArticleProviderQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
