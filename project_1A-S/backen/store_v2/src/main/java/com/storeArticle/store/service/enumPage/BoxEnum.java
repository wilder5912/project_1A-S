package com.storeArticle.store.service.enumPage;

public enum BoxEnum {
    getBox("select box.boxId FROM Box as box " +
                "where box.userID.userID = ? and " +
                " box.codeBox = ? and " +
                " boxId.isDelete = ? "),
    getBoxUser("select box FROM Box as box " +
            "where box.userID.userID = ? and " +
            " box.businessId.businessId = ? and " +
            " box.isSelectBox = ? and " +
            " box.isDelete = ? ");

    private String hql;

    BoxEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
