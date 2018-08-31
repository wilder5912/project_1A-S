package com.storeArticle.store.model.accounts;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detailrole")
public class DetailRole implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "detailrole_id")
    private int detailRoleId;

    @ManyToOne
    @JoinColumn(name = "roleuser_id")
    private RoleUser roleUserId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userID;

    @Column(name = "detailrole_select")
    private boolean detailRoleSelect;

    @Column(name = "is_delete_detailrole")
    private boolean isDelete;

    public int getDetailRoleId() {
        return detailRoleId;
    }

    public void setDetailRoleId(int detailRoleId) {
        this.detailRoleId = detailRoleId;
    }

    public RoleUser getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(RoleUser roleUserId) {
        this.roleUserId = roleUserId;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public boolean isDetailRoleSelect() {
        return detailRoleSelect;
    }

    public void setDetailRoleSelect(boolean detailRoleSelect) {
        this.detailRoleSelect = detailRoleSelect;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
