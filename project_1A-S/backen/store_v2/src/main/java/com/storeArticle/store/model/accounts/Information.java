package com.storeArticle.store.model.accounts;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="information")
public class Information implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "information_id")
    private int informationId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articleId;

    @Column(name = "name_information")
    private String nameInformation;

    @Column(name = "detail_information")
    private String detailInformation;

    @Column(name = "is_delete_information")
    private boolean isDelete;

    public int getInformationId() {
        return informationId;
    }

    public void setInformationId(int informationId) {
        this.informationId = informationId;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public String getNameInformation() {
        return nameInformation;
    }

    public void setNameInformation(String nameInformation) {
        this.nameInformation = nameInformation;
    }

    public String getDetailInformation() {
        return detailInformation;
    }

    public void setDetailInformation(String detailInformation) {
        this.detailInformation = detailInformation;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}