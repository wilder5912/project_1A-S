package com.storeArticle.store.service.enumPage;

public enum SubSectionQueryEnum {
    getSubSectionList("select subSection FROM SubSection as subSection " +
                            "where subSection.isDelete = false and " +
                            "subSection.sectionId.isDelete = false and " +
                            "subSection.sectionId.groupId.isDelete = false "),
    getSubSectionHql("select subSection FROM SubSection as subSection  " +
                            "where subSection.sectionId.sectionId = ? and " +
                            "subSection.nameSubSection = ? and " +
                            "subSection.isDelete = ? "),
    getSubSectionIdListHql("select subSection.subSectionId,subSection.nameSubSection " +
                                " FROM SubSection as subSection  " +
                                "where subSection.sectionId.sectionId = ? and " +
                                "subSection.isDelete = ? ");

    private String hql;

    SubSectionQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
