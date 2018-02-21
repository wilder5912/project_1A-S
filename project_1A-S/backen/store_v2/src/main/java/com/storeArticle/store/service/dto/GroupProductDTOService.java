package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Bussine;
import com.storeArticle.store.service.groupProductService.GroupProductService;
import com.storeArticle.store.service.groupProductService.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupProductDTOService {

    @Autowired
    private SectionService sectionService;
    @Autowired
    private SectionDTOService sectionDTOService;

    public List<GroupProductVEO> getGroupProductDTO(List<Object[]> groupProductList){
        List<GroupProductVEO> GroupProductDTOList = new ArrayList<GroupProductVEO>();
        try{
            groupProductList.forEach(SelectData->{
                GroupProductVEO groupProductVEOInfo = new GroupProductVEO();
                groupProductVEOInfo.setNameGroupId(Integer.parseInt(SelectData[0].toString()));
                groupProductVEOInfo.setNameGroup(SelectData[1].toString());
                groupProductVEOInfo.setSectionGroup(sectionDTOService.getSectionDTO(sectionService.getListSectionId(groupProductVEOInfo.getNameGroupId())));
                GroupProductDTOList.add(groupProductVEOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return GroupProductDTOList;
    }

}
