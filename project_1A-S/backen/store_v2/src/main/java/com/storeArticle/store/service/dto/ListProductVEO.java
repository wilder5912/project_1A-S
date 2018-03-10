package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Box;

import java.io.Serializable;
import java.util.List;


public class ListProductVEO implements Serializable {


    private int listProductId;

    private Box boxId;

    private int numProduct;

    private List<ArticleVEO> articleVEO;

    private boolean isDeletet;

    public int getListProductId() {
        return listProductId;
    }

    public void setListProductId(int listProductId) {
        this.listProductId = listProductId;
    }

    public Box getBoxId() {
        return boxId;
    }

    public void setBoxId(Box boxId) {
        this.boxId = boxId;
    }

    public boolean isDeletet() {
        return isDeletet;
    }

    public void setDeletet(boolean deletet) {
        isDeletet = deletet;
    }

    public List<ArticleVEO> getArticleVEO() {
        return articleVEO;
    }

    public void setArticleVEO(List<ArticleVEO> articleVEO) {
        this.articleVEO = articleVEO;
    }

    public int getNumProduct() {
        return numProduct;
    }

    public void setNumProduct(int numProduct) {
        this.numProduct = numProduct;
    }
}

