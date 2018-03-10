package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Section;
import com.storeArticle.store.model.accounts.SubSection;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.SubSectionQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class SubSectionService implements SubSectionCrup {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SectionService sectionService;

    @Autowired
    private SelectDTOService selectDTOService;

    @Override
    public boolean addSubSection(SubSection subSection) {
        boolean isSubSection=false;
        if(isSubSection(subSection.getSectionId().getSectionId(),subSection.getNameSubSection())) {
            isSubSection = true;
            entityManager.persist(subSection);
        }
        return isSubSection;
    }

    @Override
    public boolean deleteSubSection(int subSectionId) {
        SubSection subSection = getSubSection(subSectionId);
        subSection.setDelete(true);
        entityManager.flush();
        return null != subSection;
    }

    @Override
    public boolean updatedGroupProductName(SubSection subSection) {

        SubSection subSectionData = getSubSection(subSection.getSubSectionId());
        Section section = sectionService.getSection(subSection.getSectionId().getSectionId());
        boolean iscorrectSubSectionName = false;
        boolean iscorrectsubSectiionIdGroup=false;

        if(subSectionData.getSectionId().getSectionId() == subSection.getSectionId().getSectionId() && !subSection.getNameSubSection().equals(subSectionData.getNameSubSection()) ) {
            if(isSubSection(subSection.getSectionId().getSectionId(),subSection.getNameSubSection())) {
                iscorrectSubSectionName = true;
                subSectionData.setNameSubSection(subSection.getNameSubSection());
            }
        }
        if(subSection.getSectionId().getSectionId() != subSectionData.getSectionId().getSectionId() && subSection.getNameSubSection().equals(subSectionData.getNameSubSection())) {
            if(isSubSection(subSection.getSectionId().getSectionId(),subSection.getNameSubSection())) {
                iscorrectsubSectiionIdGroup = true;
                subSectionData.setSectionId(section);
            }
        }
        entityManager.flush();
        return  iscorrectsubSectiionIdGroup || iscorrectSubSectionName;
    }

    @Override
    public SubSection getSubSection(int subSectionId) {
        return entityManager.find(SubSection.class, subSectionId);    }

    @Override
    public Boolean getIsSubSection() {
        return null;
    }

    public boolean  isSubSection(int sectionId, String nameSubSection){
        List<SubSection> subSection = getSubSection(sectionId,nameSubSection);
        if(subSection.size() == 0){
            return true;
        } else{
            return false;
        }
    }

    public List<SubSection> getSubSection( int subSectionId, String nameSubSection ) {
        return entityManager.createQuery(SubSectionQueryEnum.getSubSectionHql.getHql())
                .setParameter(1,subSectionId)
                .setParameter(2,nameSubSection)
                .setParameter(3,false)
                .getResultList();
    }

    public List<Object[]> getSubSectionIdList( int sectionId) {
        return entityManager.createQuery(SubSectionQueryEnum.getSubSectionIdListHql.getHql())
                .setParameter(1,sectionId)
                .setParameter(2,false)
                .getResultList();
    }

    public List<SubSection> getSubSectionList(){
        return entityManager.createQuery(SubSectionQueryEnum.getSubSectionList.getHql()).getResultList();
    }

    public List<SelectVEO> getListSelectDTO(int sectionId){
        return  selectDTOService.getIdNameDTO(getSubSectionIdList(sectionId));
    }

}
