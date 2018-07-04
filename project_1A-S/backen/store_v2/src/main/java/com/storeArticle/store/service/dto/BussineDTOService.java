package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Business;
import com.storeArticle.store.service.groupProductService.GroupProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BussineDTOService {

    @Autowired
    private GroupProductService groupProductService;
    @Autowired
    private GroupProductDTOService groupProductDTOService;

    public BusinessVEO listGroupAll(Business business){
        BusinessVEO bussineVeo= new BusinessVEO();
        try{
            bussineVeo.setIdBusiness(business.getBusinessId());
            bussineVeo.setNameBusssine(business.getNameBu());
            bussineVeo.setGroupProductVEO(groupProductDTOService.getGroupProductDTO(groupProductService.getListGroupProductBussineId(business.getBusinessId())));
        }catch(Exception e){
        }finally{
        }
        return bussineVeo;
    }
}
