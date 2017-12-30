package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Bussine;
import com.storeArticle.store.model.accounts.GroupProduct;
import com.storeArticle.store.service.dto.BussineDTO;
import com.storeArticle.store.service.dto.BussineDTOService;
import com.storeArticle.store.service.enumPage.BussineQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class BussineService implements GroupBussineCrup{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BussineDTOService bussineDTOService ;

    @Override
    public boolean addBussine(GroupProduct groupProduct) {
        return false;
    }

    @Override
    public void deleteBussine(int userId) {

    }

    @Override
    public void updatedBussine(int userId, GroupProduct groupProduct) {

    }

    @Override
    public Bussine getBussine(int bussineId) {
        return entityManager.find(Bussine.class, bussineId);
    }

    @Override
    public Boolean getIsBussine() {
        return null;
    }

    public List<BussineDTO> getBussineDTO(){
       return bussineDTOService.getBussineDTO(getBussine());
    }
    public List<Object> getBussine() {
        String bussinehql= BussineQueryEnum.getListBussineHql.getHql();
        return entityManager.createQuery(bussinehql).getResultList();
    }


}
