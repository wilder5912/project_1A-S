package com.storeArticle.store.service.dto;

import java.io.Serializable;
import java.util.List;


public class BussineVEO implements Serializable {

    private int idBussine;
    private String nameBusssine;
    private List<GroupProductVEO> groupProductVEO;

    public int getIdBussine() {
        return idBussine;
    }

    public void setIdBussine(int idBussine) {
        this.idBussine = idBussine;
    }

    public String getNameBusssine() {
        return nameBusssine;
    }

    public void setNameBusssine(String nameBusssine) {
        this.nameBusssine = nameBusssine;
    }

    public List<GroupProductVEO> getGroupProductVEO() {
        return groupProductVEO;
    }

    public void setGroupProductVEO(List<GroupProductVEO> groupProductVEO) {
        this.groupProductVEO = groupProductVEO;
    }
}

