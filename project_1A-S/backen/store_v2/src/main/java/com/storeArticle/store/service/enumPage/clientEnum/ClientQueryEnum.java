package com.storeArticle.store.service.enumPage.clientEnum;

public enum ClientQueryEnum {
    getClientHql("select client from Client as client " +
            " where client.ciNitClient = ? and "  +
            " client.nameClient = ? and " +
            " client.isDelete = ? "),
    getlookForClient("select client.clientId, client.nameClient, client.lastNameClient, client.ciNitClient  " +
            " from Client as client " +
            " where ( client.ciNitClient like ? or " +
            " client.lastNameClient like ? or " +
            " client.dateBirthClient like ? or " +
            " client.nameClient like ?  ) and " +
            " client.isDelete = ? ")
    ;

    private String hql;

    ClientQueryEnum(String hql){
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
