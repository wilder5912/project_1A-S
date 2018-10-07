package com.storeArticle.store.service.enumPage.roleEmun;

public enum BusinessCurrentUserQueryEnum {

    getListBusinessCurrentUserHql("select businessCurrentUser from BusinessCurrentUser as businessCurrentUser " +
            " where businessCurrentUser.userID.userID = ? and  " +
            " businessCurrentUser.businessId.businessId = ? and " +
            " businessCurrentUser.isDelete = ?")
    ;

    private String hql;

    BusinessCurrentUserQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
