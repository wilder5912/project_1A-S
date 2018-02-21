package com.storeArticle.store.model.accounts;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="imagearticle")
public class ImageArticle implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="image_article_id")
    private int imageArticleId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articleId;

    @Column(name="nombreImageArticle")
    private String nombreImageActicle;

    @Column(name="size_image_article")
    private String sizeImageArticle;

    @Column(name="type_image_article")
    private String typeImageArticle;

    @Column(name="is_delete_article")
    private boolean isDelete;



    public int getImageArticleId() {
        return imageArticleId;
    }

    public void setImageArticleId(int imageArticleId) {
        this.imageArticleId = imageArticleId;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
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

    public boolean isDelete() {
        return isDelete;
    }

    public String getTypeImageArticle() {
        return typeImageArticle;
    }

    public void setTypeImageArticle(String typeImageArticle) {
        this.typeImageArticle = typeImageArticle;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}