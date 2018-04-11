package com.storeArticle.store.service.dto;

import com.storeArticle.store.service.groupProductService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationDTOService {

    @Autowired
    private ArticleService articleService;

    public List<InformationVEO> getInformationDTO(List<Object[]> informationList){
        List<InformationVEO> informationDTOList = new ArrayList<InformationVEO>();
       try{
           informationList.forEach(SelectData->{
                InformationVEO informationVEOInfo = new InformationVEO();
                informationVEOInfo.setNameInformation((SelectData[0].toString()));
                informationVEOInfo.setDetailInformation(SelectData[1].toString());
                informationVEOInfo.setInformationId(Integer.parseInt(SelectData[2].toString()));
                informationDTOList.add(informationVEOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return informationDTOList;
    }

}
