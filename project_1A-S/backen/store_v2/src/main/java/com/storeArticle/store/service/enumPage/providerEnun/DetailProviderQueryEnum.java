package com.storeArticle.store.service.enumPage.providerEnun;

public enum DetailProviderQueryEnum {

    getListDetailProviderHql("select detailProvider FROM DetailProvider as detailProvider where detailProvider.isDelete = false"),
    getlookForDetailProvider("select detailProvider FROM DetailProvider as detailProvider " +
                               "where detailProvider.providerId.providerId = ? " +
                               "and detailProvider.businessId.businessId = ? " +
                               "and detailProvider.isDelete = ? ");

    private String hql;

    DetailProviderQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
