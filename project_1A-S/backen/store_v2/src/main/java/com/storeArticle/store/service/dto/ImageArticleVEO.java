package com.storeArticle.store.service.dto;

import java.io.Serializable;


public class ImageArticleVEO implements Serializable {



    private int imageArticleId;
    private String nombreImageActicle;
    private String sizeImageArticle;
    private String typeImageArticle;

    public int getImageArticleId() {
        return imageArticleId;
    }

    public void setImageArticleId(int imageArticleId) {
        this.imageArticleId = imageArticleId;
    }

    public String getNombreImageActicle() {
        return nombreImageActicle;
    }

    public void setNombreImageActicle(String nombreImageActicle) {
        this.nombreImageActicle = nombreImageActicle;
    }

    public String getSizeImageArticle() {
        return sizeImageArticle;
    }

    public void setSizeImageArticle(String sizeImageArticle) {
        this.sizeImageArticle = sizeImageArticle;
    }

    public String getTypeImageArticle() {
        return typeImageArticle;
    }

    public void setTypeImageArticle(String typeImageArticle) {
        this.typeImageArticle = typeImageArticle;
    }
}

