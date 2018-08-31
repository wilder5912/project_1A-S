package com.storeArticle.store.model.accounts;

import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roleuser")
public class RoleUser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "roleuser_id")
    private int roleUserId;

    @Column(name = "name_role")
    private String nameRole;

    @Column(name = "is_delete_role")
    private boolean isDelete;

    public int getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(int roleUserId) {
        this.roleUserId = roleUserId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
