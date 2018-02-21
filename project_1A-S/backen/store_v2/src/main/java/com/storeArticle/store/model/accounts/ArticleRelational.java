package com.storeArticle.store.model.accounts;

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
    @JoinColumn(name = "bussine_id")
    private Bussine bussineId;

    @ManyToOne
    @JoinColumn(name = "art_article_id")
    private Article artArticleId;

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

    public Bussine getBussineId() {
        return bussineId;
    }

    public void setBussineId(Bussine bussineId) {
        this.bussineId = bussineId;
    }

    public Article getArtArticleId() {
        return artArticleId;
    }

    public void setArtArticleId(Article artArticleId) {
        this.artArticleId = artArticleId;
    }
}