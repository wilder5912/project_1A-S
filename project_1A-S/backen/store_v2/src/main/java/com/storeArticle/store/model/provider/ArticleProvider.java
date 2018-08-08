package com.storeArticle.store.model.provider;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="articleprovider")
public class ArticleProvider implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "articleprovider_id" )
    private int articleProviderId;

    @Column(name = "code_articleprovider" )
    private String codeArticleProvider;

    @Column(name = "name_articleprovider" )
    private String nameArticleProvider;

    @Column(name = "is_delete_articleprovider")
    private boolean isDelete;

    public int getArticleProviderId() {
        return articleProviderId;
    }

    public void setArticleProviderId(int articleProviderId) {
        this.articleProviderId = articleProviderId;
    }

    public String getCodeArticleProvider() {
        return codeArticleProvider;
    }

    public void setCodeArticleProvider(String codeArticleProvider) {
        this.codeArticleProvider = codeArticleProvider;
    }

    public String getNameArticleProvider() {
        return nameArticleProvider;
    }

    public void setNameArticleProvider(String nameArticleProvider) {
        this.nameArticleProvider = nameArticleProvider;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

}
