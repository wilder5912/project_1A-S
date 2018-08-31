package com.storeArticle.store.service.enumPage.typeMoneyEmun;

public enum TypeMoneyQueryEnum {

    getListTypeMoneyHql("select typeMoney FROM TypeMoney as typeMoney " +
            " where typeMoney.businessId.businessId = ? and  " +
            " typeMoney.nameTypeMoney = ? and  " +
            " typeMoney.isDelete = ?"),
    getListTypeMoneyBusinessIdHql("select typeMoney FROM TypeMoney as typeMoney " +
            " where typeMoney.businessId.businessId = ? and  " +
            " typeMoney.isDelete = ?")
    ;

    private String hql;

    TypeMoneyQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
