package com.storeArticle.store.service.enumPage;

public enum WareHouseMainQueryEnum {

    getListWareHouseMainCodeHql("select wareHouseMain.wnameId, wareHouseMain.codeWarehouse FROM WareHouseMain as wareHouseMain " +
            "where wareHouseMain.isDelete = ? " ),
   ;

    private String hql;

    WareHouseMainQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
