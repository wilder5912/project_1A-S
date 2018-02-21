package com.storeArticle.store.model.accounts;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="banner")
public class Banner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "banner_id")
    private int bannerId;

    @ManyToOne
    @JoinColumn(name = "articledetail_id")
    private ArticleDetail articledetailId;

    @Column(name = "tittle_banner")
    private String tittleBanner;

    @Column(name = "detall_banner")
    private String detallBanner;

    @Column(name = "name_image_banner")
    private String nameImageBanner;

    @Column(name = "start_banner")
    private String startBanner;

    @Column(name = "end_banner")
    private String endBanner;

    @Column(name = "url_banner")
    private String urlBanner;

    @Column(name = "type_banner")
    private String typeBanner;

    @Column (name = "is_delete_banner")
    private boolean isDelete;


    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public ArticleDetail getArticledetailId() {
        return articledetailId;
    }

    public void setArticledetailId(ArticleDetail articledetailId) {
        this.articledetailId = articledetailId;
    }

    public String getTittleBanner() {
        return tittleBanner;
    }

    public void setTittleBanner(String tittleBanner) {
        this.tittleBanner = tittleBanner;
    }

    public String getDetallBanner() {
        return detallBanner;
    }

    public void setDetallBanner(String detallBanner) {
        this.detallBanner = detallBanner;
    }

    public String getNameImageBanner() {
        return nameImageBanner;
    }

    public void setNameImageBanner(String nameImageBanner) {
        this.nameImageBanner = nameImageBanner;
    }

    public String getStartBanner() {
        return startBanner;
    }

    public void setStartBanner(String startBanner) {
        this.startBanner = startBanner;
    }

    public String getEndBanner() {
        return endBanner;
    }

    public void setEndBanner(String endBanner) {
        this.endBanner = endBanner;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public String getTypeBanner() {
        return typeBanner;
    }

    public void setTypeBanner(String typeBanner) {
        this.typeBanner = typeBanner;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}