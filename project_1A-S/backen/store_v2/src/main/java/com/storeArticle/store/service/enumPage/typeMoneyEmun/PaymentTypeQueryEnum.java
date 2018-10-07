package com.storeArticle.store.service.enumPage.typeMoneyEmun;

public enum PaymentTypeQueryEnum {

    getListPaimentTypeHql("select paymentType.paymentTypeId, paymentType.namePaymentType FROM PaymentType as paymentType " +
            " where " +
            " paymentType.isDelete = ?")
    ;

    private String hql;

    PaymentTypeQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
