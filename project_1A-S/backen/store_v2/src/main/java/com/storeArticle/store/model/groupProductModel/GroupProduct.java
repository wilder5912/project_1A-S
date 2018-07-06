package com.storeArticle.store.model.groupProductModel;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="groupproduct")
public class GroupProduct  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="group_id")
    private int groupId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @Column(name="name_group")
    private String nameGroup;

    @Column(name="is_delete_group")
    private boolean isDelete;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }


    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}