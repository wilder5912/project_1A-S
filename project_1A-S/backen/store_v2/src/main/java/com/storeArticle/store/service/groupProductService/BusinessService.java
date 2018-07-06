package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.model.groupProductModel.GroupProduct;
import com.storeArticle.store.service.dto.*;
import com.storeArticle.store.service.enumPage.BussineQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class BusinessService implements GroupBusinessCrup{

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SelectDTOService selectDTOService;
    @Autowired
    private BussineDTOService bussineDTOService;

    @Override
    public boolean addBusiness(Business business) {
        boolean isBusiness = false;
        if(isCreateBusiness(business.getNameBu())) {
            business.setDelete(false);
            entityManager.persist(business);
            isBusiness = true;
        }
        return isBusiness;
    }

    @Override
    public boolean deleteBusiness(int businessId) {
        Business business = getBusiness(businessId);
        business.setDelete(true);
        entityManager.flush();
        return null != business;
    }

    @Override
    public boolean updatedBusiness(Business businessNew) {
        Business business = getBusiness(businessNew.getBusinessId());
        business.setNameBu(businessNew.getNameBu());
        entityManager.flush();
        return null != business;
    }

    @Override
    public Business getBusiness(int businessId) {
        return entityManager.find(Business.class, businessId);
    }

    @Override
    public Boolean getIsBusiness() {
        return null;
    }



    public List<Business> lookForBussine(String business){
        String groupProductHql = BussineQueryEnum.getlookForBusiness.getHql();
        return entityManager.createQuery(groupProductHql)
                .setParameter(1, business)
                .setParameter(2,false)
                .getResultList();
    }

    public boolean isCreateBusiness(String businessData){
        List<Business> businessList = lookForBussine(businessData);
        if(businessList.size() == 0){
            return true;
        } else{
            return false;
        }

    }
    public List<SelectVEO> getBussineDTO(){
       return selectDTOService.getBussineDTO(getBusiness());
    }
    public List<Object> getBusiness() {
        return entityManager.createQuery(BussineQueryEnum.getListBussineHql.getHql()).getResultList();
    }
    public List<Business> getBusinessList() {
        return entityManager.createQuery(BussineQueryEnum.getListBussineHql.getHql()).getResultList();
    }

    public BusinessVEO getBusinessAll(Business bussine) {
        return  bussineDTOService.listGroupAll(bussine);
    }






}
