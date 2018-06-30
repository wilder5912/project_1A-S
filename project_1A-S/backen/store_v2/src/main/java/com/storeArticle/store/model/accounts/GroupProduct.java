package com.storeArticle.store.model.accounts;
import lombok.*;
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
    private Bussine bussineId;

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

    public Bussine getBussineId() {
        return bussineId;
    }

    public void setBussineId(Bussine bussineId) {
        this.bussineId = bussineId;
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