package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Bussine;
import com.storeArticle.store.model.accounts.User;

import java.io.Serializable;


public class BoxVEO implements Serializable {


    private int boxId;

    private Bussine bussineId;

    private User userId;

    private String nameBox;

    private String codeBox;

    private boolean isSelectBox;

    private boolean isDelete;

    private ListProductVEO  listProductVEO;

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public Bussine getBussineId() {
        return bussineId;
    }

    public void setBussineId(Bussine bussineId) {
        this.bussineId = bussineId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getNameBox() {
        return nameBox;
    }

    public void setNameBox(String nameBox) {
        this.nameBox = nameBox;
    }

    public String getCodeBox() {
        return codeBox;
    }

    public void setCodeBox(String codeBox) {
        this.codeBox = codeBox;
    }

    public boolean isSelectBox() {
        return isSelectBox;
    }

    public void setSelectBox(boolean selectBox) {
        isSelectBox = selectBox;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public ListProductVEO getListProductVEO() {
        return listProductVEO;
    }

    public void setListProductVEO(ListProductVEO listProductVEO) {
        this.listProductVEO = listProductVEO;
    }
}

