package com.storeArticle.store.model.groupProductModel;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "article")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="article_id")
    private int articleId;

    @Column(name="name_ar")
    private String nameAr;

    @Column(name="codigo_ar")
    private String codigoAr;

    @Column(name="precy_ar")
    private Double precyAr;

    @Column(name="detail_ar")
    private String detailAr;

    @Column(name="image_main_ar")
    private String imageMainAr;

    @Column(name="is_delete_ar")
    private boolean isDelete;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getCodigoAr() {
        return codigoAr;
    }

    public void setCodigoAr(String codigoAr) {
        this.codigoAr = codigoAr;
    }

    public Double getPrecyAr() {
        return precyAr;
    }

    public void setPrecyAr(Double precyAr) {
        this.precyAr = precyAr;
    }

    public String getDetailAr() {
        return detailAr;
    }

    public void setDetailAr(String detailAr) {
        this.detailAr = detailAr;
    }

    public String getImageMainAr() {
        return imageMainAr;
    }

    public void setImageMainAr(String imageMainAr) {
        this.imageMainAr = imageMainAr;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}