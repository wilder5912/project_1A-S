package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.GroupProduct;
import com.storeArticle.store.model.accounts.Section;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.SectionQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class SectionService implements SectionCrup {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SelectDTOService selectDTOService;
    @Autowired
    private GroupProductService groupProductService;


    @Override
    public boolean addSection(Section section) {
        boolean isSection=false;
        if(isSection(section.getGroupId().getGroupId(),section.getNameSection())) {
            isSection=true;
            entityManager.persist(section);
        }
        return isSection;
    }

    @Override
    public boolean deleteSection(int sectionId) {
        Section section = getSection(sectionId);
        section.setDelete(true);
        return null != section;
    }

    @Override
    public boolean updatedGroupProductName(Section section) {
        Section sectionData = getSection(section.getSectionId());
        GroupProduct groupProduct = groupProductService.getGroupProductName(section.getGroupId().getGroupId());
        boolean iscorrectSectionName = false;
        boolean iscorrectSectiionIdGroup=false;
        if(sectionData.getGroupId().getGroupId() == section.getGroupId().getGroupId() && !section.getNameSection().equals(sectionData.getNameSection()) ) {
            if(isSection(section.getGroupId().getGroupId(),section.getNameSection())) {
                iscorrectSectionName = true;
                sectionData.setNameSection(section.getNameSection());
            }
        }
         if(section.getGroupId().getGroupId() != sectionData.getGroupId().getGroupId() && section.getNameSection().equals(sectionData.getNameSection())) {
            if(isSection(section.getGroupId().getGroupId(),section.getNameSection())) {
                iscorrectSectiionIdGroup = true;
                sectionData.setGroupId(groupProduct);
            }
        }
        entityManager.flush();
        return  iscorrectSectiionIdGroup || iscorrectSectionName;
    }

    @Override
    public Section getSection(int SectionId) {
        return entityManager.find(Section.class, SectionId);
    }

    @Override
    public Boolean getIsSection() {
        return null;
    }

    public List<Section> getSection( int groupId, String nameSection ) {

        return entityManager.createQuery(SectionQueryEnum.getSectionHql.getHql())
                .setParameter(1,groupId)
                .setParameter(2,nameSection)
                .setParameter(3,false)
                .getResultList();
    }

    public boolean  isSection(int groupId, String nameSection){
        List<Section> section = getSection(groupId,nameSection);
        if(section.size() == 0){
            return true;
        } else{
            return false;
        }
    }
    public List<Section> getSubSectionList(){
        return entityManager.createQuery(SectionQueryEnum.getSectionList.getHql()).getResultList();
    }

    public List<Object[]> getListSectionId(int idGroup){
        return entityManager.createQuery(SectionQueryEnum.getSectionIdHql.getHql())
                .setParameter(1,idGroup)
                .setParameter(2,false).getResultList();
    }

    public List<SelectVEO> getListSelectDTO(int groupId){
        return  selectDTOService.getIdNameDTO(getListSectionId(groupId));
    }

}
