package com.storeArticle.store.service.TypeMoneyStoreService;

import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.typeMoneyEmun.PaymentTypeQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class PaymentTypeService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SelectDTOService selectDTOService;

    public List<Object[]> getListPaimentTypeRole(){
        return entityManager.createQuery(PaymentTypeQueryEnum.getListPaimentTypeHql.getHql())
                .setParameter(1,false)
                .getResultList();
    }

    public List<SelectVEO> getListSelectDTO(){
        return  selectDTOService.getIdNameDTO(getListPaimentTypeRole());
    }

}
