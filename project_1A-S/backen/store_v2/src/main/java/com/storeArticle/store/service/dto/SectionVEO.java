package com.storeArticle.store.service.dto;

import java.io.Serializable;
import java.util.List;


public class SectionVEO implements Serializable {

    private int sectionId;
    private String nameSection;
    private List<SubSectionVEO> subSectionVEO;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getNameSection() {
        return nameSection;
    }

    public void setNameSection(String nameSection) {
        this.nameSection = nameSection;
    }

    public List<SubSectionVEO> getSubSectionVEO() {
        return subSectionVEO;
    }

    public void setSubSectionVEO(List<SubSectionVEO> subSectionVEO) {
        this.subSectionVEO = subSectionVEO;
    }
}

