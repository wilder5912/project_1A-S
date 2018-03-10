package com.storeArticle.store.service.enumPage;

public enum ListProductEnum {
    getArticleBox("select listProduct.numProduct, listProduct.articleId FROM ListProduct as listProduct " +
                "where listProduct.boxId.boxId = ? and " +
                " listProduct.isDelete = ? and " +
                " listProduct.numProduct > 0 "),
    getArticleNumberBox("select listProduct FROM ListProduct as listProduct " +
            "where listProduct.boxId.boxId = ? and " +
            " listProduct.articleId.articleId = ?  and " +
            " listProduct.isDelete = ? "),
    updateMumberArticleHql("update ListProduct as listProduct  " +
            " set listProduct.numProduct = ? " +
            " where listProduct.boxId.boxId = ? and " +
            " listProduct.articleId.articleId = ? and " +
            " listProduct.isDelete = ?  " )
    ;

    private String hql;

    ListProductEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
