package com.storeArticle.store.model.groupProductModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="articlerelational")
public class ArticleRelational implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "articlerelational_id")
    private int articleRelationalId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articleId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @ManyToOne
    @JoinColumn(name = "art_article_id")
    private Article artArticleId;

    @Column(name = "is_delete_articlerelational")
    private boolean isDelete;

    public int getArticleRelationalId() {
        return articleRelationalId;
    }

    public void setArticleRelationalId(int articleRelationalId) {
        this.articleRelationalId = articleRelationalId;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public Article getArtArticleId() {
        return artArticleId;
    }

    public void setArtArticleId(Article artArticleId) {
        this.artArticleId = artArticleId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}