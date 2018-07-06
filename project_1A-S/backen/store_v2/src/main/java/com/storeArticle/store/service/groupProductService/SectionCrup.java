package com.storeArticle.store.service.groupProductService;
import com.storeArticle.store.model.groupProductModel.Section;

public interface SectionCrup {

    boolean addSection(Section section);

    boolean deleteSection(int sectionId);

    boolean updatedGroupProductName(Section section);

    Section getSection(int SectionId);

    Boolean getIsSection();
}
