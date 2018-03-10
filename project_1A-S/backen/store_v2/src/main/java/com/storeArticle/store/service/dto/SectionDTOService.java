package com.storeArticle.store.service.dto;

import com.storeArticle.store.service.groupProductService.SubSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionDTOService {

    @Autowired
    private SubSectionService subSectionService;

    @Autowired
    private SubSectionDTOService subSectionDTOService;

    public List<SectionVEO> getSectionDTO(List<Object[]> sectionList){
        List<SectionVEO> sectionVEODTOList = new ArrayList<SectionVEO>();
        try{
            sectionList.forEach(SelectData->{
                SectionVEO sectionVEOInfo = new SectionVEO();
                sectionVEOInfo.setSectionId(Integer.parseInt(SelectData[0].toString()));
                sectionVEOInfo.setNameSection(SelectData[1].toString());
                sectionVEOInfo.setSubSectionVEO(subSectionDTOService.getSubSectionDTO(subSectionService.getSubSectionIdList(sectionVEOInfo.getSectionId())));
                sectionVEODTOList.add(sectionVEOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return sectionVEODTOList;
    }

}
