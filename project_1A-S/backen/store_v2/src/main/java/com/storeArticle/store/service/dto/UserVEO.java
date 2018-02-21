package com.storeArticle.store.service.dto;

import java.io.Serializable;


public class UserVEO implements Serializable {

    private String firtNameUser;
    private String lastNameUser;
    private String imagenUser;

    public String getFirtNameUser() {
        return firtNameUser;
    }

    public void setFirtNameUser(String firtNameUser) {
        this.firtNameUser = firtNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getImagenUser() {
        return imagenUser;
    }

    public void setImagenUser(String imagenUser) {
        this.imagenUser = imagenUser;
    }
}

