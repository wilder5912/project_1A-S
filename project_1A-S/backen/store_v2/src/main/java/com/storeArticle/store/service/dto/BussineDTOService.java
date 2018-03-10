package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Bussine;
import com.storeArticle.store.service.groupProductService.GroupProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BussineDTOService {

    @Autowired
    private GroupProductService groupProductService;
    @Autowired
    private GroupProductDTOService groupProductDTOService;

    public BussineVEO listGroupAll(Bussine bussine){
        BussineVEO bussineVeo= new BussineVEO();
        try{
            bussineVeo.setIdBussine(bussine.getBussineId());
            bussineVeo.setNameBusssine(bussine.getNameBu());
            bussineVeo.setGroupProductVEO(groupProductDTOService.getGroupProductDTO(groupProductService.getListGroupProductBussineId(1)));
        }catch(Exception e){
        }finally{
        }
        return bussineVeo;
    }
}
