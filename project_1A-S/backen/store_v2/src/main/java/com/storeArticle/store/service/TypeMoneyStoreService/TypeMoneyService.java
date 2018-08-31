package com.storeArticle.store.service.TypeMoneyStoreService;

import com.storeArticle.store.model.TypeMoneyModel.TypeMoney;
import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.service.enumPage.typeMoneyEmun.TypeMoneyQueryEnum;
import com.storeArticle.store.service.groupProductService.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class TypeMoneyService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private BusinessService businessService;

    public boolean addTypeMoney(TypeMoney typeMoney){
        boolean isTypeMoney = false;
        if(isCreateTypeMoney(typeMoney.getBusinessId().getBusinessId(), typeMoney.getNameTypeMoney())){
            entityManager.persist(typeMoney);
            isTypeMoney = true;
        }
        return isTypeMoney;
    }

    public TypeMoney getTypeMoney(int typeMoney){
        return entityManager.find(TypeMoney.class, typeMoney);
    }

    public boolean isCreateTypeMoney(int businessId, String nameTypeMoney){
        List<TypeMoney> typeMoneyList = getNameTypeMoney(businessId, nameTypeMoney);
        if(typeMoneyList.size() == 0){
            return true;
        } else{
            return false;
        }
    }
    public List<TypeMoney> getNameTypeMoney(int businessId, String nameTypeMoney){
        return entityManager.createQuery(TypeMoneyQueryEnum.getListTypeMoneyHql.getHql())
                .setParameter(1, businessId)
                .setParameter(2, nameTypeMoney)
                .setParameter(3,false)
                .getResultList();
    }
    public List<TypeMoney> getNameTypeMoneybusinessId(int businessId){
        return entityManager.createQuery(TypeMoneyQueryEnum.getListTypeMoneyBusinessIdHql.getHql())
                .setParameter(1, businessId)
                .setParameter(2,false)
                .getResultList();
    }

    public boolean updatedTypeMoney(TypeMoney typeMoneyNew){
        TypeMoney typeMoney = getTypeMoney(typeMoneyNew.getTypeMoneyId());
        Business business = businessService.getBusiness(typeMoneyNew.getBusinessId().getBusinessId());
        typeMoney.setBusinessId(business);
        typeMoney.setTypeChangeTypemoney(typeMoneyNew.getTypeChangeTypemoney());
        typeMoney.setNameTypeMoney(typeMoneyNew.getNameTypeMoney());
        typeMoney.setDelete(false);
        entityManager.flush();
        return null != typeMoney;
    }
    public boolean deleteTypeMoney(int warehouseId){
        TypeMoney typeMoney = getTypeMoney(warehouseId);
        typeMoney.setDelete(true);
        entityManager.flush();
        return null != typeMoney;
    }
}
