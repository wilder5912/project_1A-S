package com.storeArticle.store.service.dto;

import java.io.Serializable;
import java.util.List;


public class BusinessVEO implements Serializable {

    private int idBusiness;
    private String nameBusssine;
    private List<GroupProductVEO> groupProductVEO;

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
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

