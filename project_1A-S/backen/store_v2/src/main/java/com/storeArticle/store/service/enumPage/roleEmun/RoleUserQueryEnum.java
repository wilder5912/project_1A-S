package com.storeArticle.store.service.enumPage.roleEmun;

public enum RoleUserQueryEnum {

    getListRoleUserHql("select roleUser from RoleUser as roleUser " +
            " where roleUser.nameRole = ? and  " +
            " roleUser.isDelete = ?"),
    getListOfRoleUsersHql("select roleUser from RoleUser as roleUser " +
            " where roleUser.isDelete = ?"),
    getListOfAllRoleHql("select roleUser.roleUserId, roleUser.nameRole from RoleUser as roleUser " +
                                  " where roleUser.isDelete = ?"),
    getListOfAllRoleSellerHql("select roleUser.roleUserId, roleUser.nameRole from RoleUser as roleUser " +
            " where roleUser.isDelete = ?")
    ;

    private String hql;

    RoleUserQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
