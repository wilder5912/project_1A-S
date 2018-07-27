package com.storeArticle.store.service.enumPage;

public enum ProviderQueryEnum {

    getListProviderHql("select provider FROM Provider as provider where provider.isDelete = false"),
    getListProviderIdCodeHql("select provider.providerId, provider.codeProvider  FROM Provider as provider where provider.isDelete = false"),
    getlookForProvider("select provider FROM Provider as provider " +
                               "where provider.codeProvider = ? " +
                                "and provider.isDelete = ? ")
    ;

    private String hql;

    ProviderQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
