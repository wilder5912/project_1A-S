package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.groupProductModel.SubSection;
import com.storeArticle.store.service.groupProductService.ArticleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubSectionDTOService {
    @Autowired
    private ArticleDetailService articleDetailService;
    @Autowired
    private  ArticleDTOService articleDTOService;

    public List<SubSectionVEO> getSubSectionDTO(List<Object[]> subSectionList){
        List<SubSectionVEO> SubSectionVEOVEODTOList = new ArrayList<SubSectionVEO>();
        try{
            subSectionList.forEach(SelectData->{
                SubSectionVEO subSectionVEOInfo = new SubSectionVEO();
                subSectionVEOInfo.setIdSubSection(Integer.parseInt(SelectData[0].toString()));
                subSectionVEOInfo.setNameSubSection(SelectData[1].toString());
                SubSectionVEOVEODTOList.add(subSectionVEOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return SubSectionVEOVEODTOList;
    }

    public SubSectionVEO getSubSectionArticleDTO(SubSection subSection){
        SubSectionVEO subSectionVEO = new SubSectionVEO();
        subSectionVEO.setIdSubSection(subSection.getSubSectionId());
        subSectionVEO.setNameSubSection(subSection.getNameSubSection());
        subSectionVEO.setArticleVEO(articleDTOService.getArticleDTO(articleDetailService.getArticleDetaileListArticleId(subSectionVEO.getIdSubSection())));
        return subSectionVEO;
    }




}
