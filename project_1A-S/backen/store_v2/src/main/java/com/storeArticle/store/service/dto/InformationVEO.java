package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Information;

import java.io.Serializable;
import java.util.List;


public class InformationVEO implements Serializable {


    private String nameInformation;

    private String detailInformation;

    public String getNameInformation() {
        return nameInformation;
    }

    public void setNameInformation(String nameInformation) {
        this.nameInformation = nameInformation;
    }

    public String getDetailInformation() {
        return detailInformation;
    }

    public void setDetailInformation(String detailInformation) {
        this.detailInformation = detailInformation;
    }
}

