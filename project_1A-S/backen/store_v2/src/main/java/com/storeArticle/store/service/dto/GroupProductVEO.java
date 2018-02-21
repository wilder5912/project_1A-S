package com.storeArticle.store.service.dto;

import java.io.Serializable;
import java.util.List;


public class GroupProductVEO implements Serializable {

    private int nameGroupId;
    private String nameGroup;
    private List<SectionVEO> SectionGroup;

    public int getNameGroupId() {
        return nameGroupId;
    }

    public void setNameGroupId(int nameGroupId) {
        this.nameGroupId = nameGroupId;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public List<SectionVEO> getSectionGroup() {
        return SectionGroup;
    }

    public void setSectionGroup(List<SectionVEO> sectionGroup) {
        SectionGroup = sectionGroup;
    }
}

