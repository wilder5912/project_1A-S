package com.storeArticle.store.service.dto;

import java.io.Serializable;
import java.util.List;


public class SubSectionVEO implements Serializable {

    private int idSubSection;
    private String nameSubSection;
    private List<ArticleVEO> articleVEO;


    public int getIdSubSection() {
        return idSubSection;
    }

    public void setIdSubSection(int idSubSection) {
        this.idSubSection = idSubSection;
    }

    public String getNameSubSection() {
        return nameSubSection;
    }

    public void setNameSubSection(String nameSubSection) {
        this.nameSubSection = nameSubSection;
    }

    public List<ArticleVEO> getArticleVEO() {
        return articleVEO;
    }

    public void setArticleVEO(List<ArticleVEO> articleVEO) {
        this.articleVEO = articleVEO;
    }
}

