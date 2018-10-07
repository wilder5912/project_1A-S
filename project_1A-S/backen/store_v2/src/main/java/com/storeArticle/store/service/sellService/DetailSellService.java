package com.storeArticle.store.service.sellService;

import com.storeArticle.store.model.SellModel.DetailSell;
import com.storeArticle.store.model.SellModel.SellProduct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Service
@Transactional
public class DetailSellService {
    @PersistenceContext
    private EntityManager entityManager;
    public DetailSell addSellProduct(DetailSell detailSell){
        detailSell.setDateDetailSell("");
        detailSell.setDateRegisterDetailSell("");
        detailSell.setDelete(false);
        entityManager.persist(detailSell);
        return detailSell;
    }


}
