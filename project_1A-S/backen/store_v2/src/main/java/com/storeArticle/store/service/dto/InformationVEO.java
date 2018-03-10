package com.storeArticle.store.service.dto;

import java.io.Serializable;


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

