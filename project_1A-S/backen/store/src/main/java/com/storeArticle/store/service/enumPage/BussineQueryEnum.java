package com.storeArticle.store.service.enumPage;

public enum BussineQueryEnum {

    getListBussineHql("select bussine FROM Bussine as bussine");

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
