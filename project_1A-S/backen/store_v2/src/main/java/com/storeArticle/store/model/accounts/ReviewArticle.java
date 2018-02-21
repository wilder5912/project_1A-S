package com.storeArticle.store.model.accounts;

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
    @JoinColumn(name = "bussine_id")
    private Bussine bussineId;

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

    public Bussine getBussineId() {
        return bussineId;
    }

    public void setBussineId(Bussine bussineId) {
        this.bussineId = bussineId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}