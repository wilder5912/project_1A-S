package com.storeArticle.store.service.enumPage;

public enum BannerQueryEnum {

    getListBannerHql("select banner FROM Banner as banner " +
                "where banner.isDelete = false");

    private String hql;

    BannerQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
