package com.storeArticle.store.service.enumPage;

public enum WarehouseQueryEnum {

    getListWarehouseHql("select warehouse FROM Warehouse as warehouse where warehouse.isDelete = false"),
    getListWarehouseCodeHql("select distinct warehouse.codeWarehouse FROM Warehouse as warehouse " +
            "where warehouse.isDelete = ? " ),
    getlookForWarehouseHql("select warehouse FROM Warehouse as warehouse " +
                        "where warehouse.codeWarehouse = ? " +
                        "and business.isDelete = ? ");

    private String hql;

    WarehouseQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
