package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Bussine;

public class GroupProductDTO {

    private int groupId;

    private Bussine bussineId;

    private String nameGroup;

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
}
