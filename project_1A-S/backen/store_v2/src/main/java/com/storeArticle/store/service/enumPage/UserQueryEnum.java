package com.storeArticle.store.service.enumPage;

public enum UserQueryEnum {

    getUserEmailHql("select user FROM User as user  where user.emailUser = ? "),
    getAutentificationHql("select user FROM User as user  where user.emailUser = ? and user.password = ? "),
    getAutentificationTokenHql("select user FROM User as user  where user.tokenUser = ? and user.codeUser = ? ");

    private String hql;

    UserQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
