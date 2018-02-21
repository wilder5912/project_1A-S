package com.storeArticle.store.service.groupProductService;
import com.storeArticle.store.model.accounts.Section;

public interface sectionCrup {

    boolean addSection(Section section);

    boolean deleteSection(int sectionId);

    boolean updatedGroupProductName(Section section);

    Section getSection(int SectionId);

    Boolean getIsSection();
}
