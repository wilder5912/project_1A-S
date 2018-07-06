package com.storeArticle.store.service.enumPage;

public enum BussineQueryEnum {

    getListBussineHql("select business FROM Business as business where business.isDelete = false"),
    getlookForBusiness("select business FROM Business as business " +
                        "where business.nameBu = ? " +
                        "and business.isDelete = ? ")
    ;

    private String hql;

    BussineQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
