package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.SubSection;

public interface SubSectionCrup {

    boolean addSubSection(SubSection subSection);

    boolean deleteSubSection(int subSectionId);

    boolean updatedGroupProductName(SubSection subSection);

    SubSection getSubSection(int SubSectionId);

    Boolean getIsSubSection();
}
