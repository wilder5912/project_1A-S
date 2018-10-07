package com.storeArticle.store.service.dto;

import java.io.Serializable;
import java.util.List;


public class ArticleVEO implements Serializable {


    private int articleId;
    private String nameAr;
    private String codigoAr;
    private float precyAr;
    private String detailAr;
    private String imageMainAr;
    private int reviewAr;
    private List<ImageArticleVEO> imageArticleVEOS;
    private int rating;
    private String nameDescriptionarticle;
    private List <InformationVEO> informationVEO;
    private List<CommentVEO> commentVEOS;
    private int numProduct;

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

    public float getPrecyAr() {
        return precyAr;
    }

    public void setPrecyAr(float precyAr) {
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

    public List<ImageArticleVEO> getImageArticleVEOS() {
        return imageArticleVEOS;
    }

    public void setImageArticleVEOS(List<ImageArticleVEO> imageArticleVEOS) {
        this.imageArticleVEOS = imageArticleVEOS;
    }

    public int getReviewAr() {
        return reviewAr;
    }

    public void setReviewAr(int reviewAr) {
        this.reviewAr = reviewAr;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNameDescriptionarticle() {
        return nameDescriptionarticle;
    }

    public void setNameDescriptionarticle(String nameDescriptionarticle) {
        this.nameDescriptionarticle = nameDescriptionarticle;
    }

    public List<InformationVEO> getInformationVEO() {
        return informationVEO;
    }

    public void setInformationVEO(List<InformationVEO> informationVEO) {
        this.informationVEO = informationVEO;
    }

    public List<CommentVEO> getCommentVEOS() {
        return commentVEOS;
    }

    public void setCommentVEOS(List<CommentVEO> commentVEOS) {
        this.commentVEOS = commentVEOS;
    }

    public int getNumProduct() {
        return numProduct;
    }

    public void setNumProduct(int numProduct) {
        this.numProduct = numProduct;
    }
}

