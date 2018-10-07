package com.storeArticle.store.service.enumPage.warehouseEmun;

public enum WarehouseQueryEnum {

    getListWarehouseHql("select warehouse FROM Warehouse as warehouse where warehouse.isDelete = false"),
    getListWarehouseCodeHql("select distinct warehouse.codeWarehouse FROM Warehouse as warehouse " +
            "where warehouse.isDelete = ? " ),
    getlookForWarehouseHql("select warehouse FROM Warehouse as warehouse " +
                        "where warehouse.codeWarehouse = ? " +
                        "and warehouse.isDelete = ? "),
    getlookForWarehouseBusAndCodHql("select warehouse FROM Warehouse as warehouse " +
            "where warehouse.codeWarehouse = ? " +
            "and warehouse.isDelete = ? "),
    getNumberOfArticleCodHql("select sum(warehouse.quantytiCurrectWarehouse) FROM Warehouse as warehouse " +
            "where warehouse.articleDetailId.articleId.codigoAr = ? and" +
            " warehouse.articleDetailId.subSectionId.sectionId.groupId.businessId.businessId = ?  " +
            "and warehouse.isDelete = ? "),
    getListIdwareHouseCodHql("select warehouse.warehouseId FROM Warehouse as warehouse " +
            "where warehouse.articleDetailId.articleDetailId = ? " +
            "and warehouse.isDelete = ? and " +
            " warehouse.quantytiCurrectWarehouse > 0 " +
            " ORDER BY warehouse.warehouseId ASC "),
    getUpdateIdwareHouseCodHql(" update Warehouse as warehouse " +
            " set warehouse.quantytiCurrectWarehouse = ? " +
            " where warehouse.warehouseId = ?")
    ;



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
