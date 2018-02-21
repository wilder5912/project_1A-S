package com.storeArticle.store.service.enumPage;

public enum SectionQueryEnum {
    getSectionList("select section FROM Section as section where section.groupId.isDelete = false and section.isDelete = false"),
    getSectionHql("select section FROM Section as section  " +
                            "where section.groupId.groupId = ? and " +
                            "section.nameSection = ? and " +
                            "section.isDelete = ? ");

    private String hql;

    SectionQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
