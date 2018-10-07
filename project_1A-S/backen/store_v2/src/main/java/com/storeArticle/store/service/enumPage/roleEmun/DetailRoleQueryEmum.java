package com.storeArticle.store.service.enumPage.roleEmun;

public enum DetailRoleQueryEmum {
    getListDetailRoleUserHql("select detailRole from DetailRole as detailRole " +
                               " where detailRole.userID.userID = ? and " +
                               " detailRole.roleUserId.roleUserId = ? and " +
                               " detailRole.isDelete = ?"),
    getListOfDetailRoleUsersHql("select detailRole.roleUserId.roleUserId, detailRole.roleUserId.nameRole from DetailRole as detailRole " +
                               " where detailRole.userID.userID = ? and " +
                                " detailRole.isDelete = ?"),
    getListOfDetailRoleUsersIdHql("select detailRole.roleUserId.roleUserId from DetailRole as detailRole " +
                               " where detailRole.userID.userID = ? and " +
                                " detailRole.isDelete = ?"),
    getListUserForUserHql("select distinct detailRole.userID from DetailRole as detailRole " +
                                " where ( " +
                                " detailRole.userID.emailUser like ? or" +
                                " detailRole.roleUserId.nameRole like ?  ) and " +
                                " detailRole.isDelete = ?"),
    getListRoleUserDetailHql("select  detailRole.detailRoleId , detailRole.userID.firtNameUser, detailRole.userID.lastNameUser, detailRole.userID.emailUser  from DetailRole as detailRole " +
                                  " where  " +
                                  " detailRole.roleUserId.roleUserId = ?   and " +
                                  " detailRole.isDelete = ? "),
    getListDetailRoleIdUserIdHql("select detailRole.detailRoleId from DetailRole as detailRole " +
                                " where detailRole.userID.userID = ? and " +
                                " detailRole.roleUserId.roleUserId = ? and " +
                                " detailRole.isDelete = ?")
    ;

    private String hql;

    DetailRoleQueryEmum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
