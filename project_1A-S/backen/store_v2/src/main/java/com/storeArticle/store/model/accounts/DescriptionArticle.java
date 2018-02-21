package com.storeArticle.store.model.accounts;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="descriptionarticle")
public class DescriptionArticle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "descriptionarticle_id")
    private int descriptionarticleId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articleId;

    @Column(name = "name_descriptionarticle")
    private String nameDescriptionarticle;

    public int getDescriptionarticleId() {
        return descriptionarticleId;
    }

    public void setDescriptionarticleId(int descriptionarticleId) {
        this.descriptionarticleId = descriptionarticleId;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public String getNameDescriptionarticle() {
        return nameDescriptionarticle;
    }

    public void setNameDescriptionarticle(String nameDescriptionarticle) {
        this.nameDescriptionarticle = nameDescriptionarticle;
    }
}