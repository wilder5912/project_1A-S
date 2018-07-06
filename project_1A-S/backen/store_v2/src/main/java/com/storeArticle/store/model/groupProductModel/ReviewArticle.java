package com.storeArticle.store.model.groupProductModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="reviewarticle")
public class ReviewArticle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reviewarticle_id")
    private int reviewarticleId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articleId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @Column(name= "is_delete_reviewarticle")
    private boolean isDelete;

    public int getReviewarticleId() {
        return reviewarticleId;
    }

    public void setReviewarticleId(int reviewarticleId) {
        this.reviewarticleId = reviewarticleId;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}