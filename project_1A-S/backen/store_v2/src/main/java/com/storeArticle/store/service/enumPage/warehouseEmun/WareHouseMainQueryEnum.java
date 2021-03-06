package com.storeArticle.store.service.enumPage.warehouseEmun;

public enum WareHouseMainQueryEnum {

    getListWareHouseMainCodeHql("select wareHouseMain.wnameId, wareHouseMain.codeWarehouse " +
            "FROM WareHouseMain as wareHouseMain " +
            "where wareHouseMain.isDelete = ? " ),
    getListWarehouseHql("select warehouse FROM Warehouse as warehouse where warehouse.isDelete = false"),
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
