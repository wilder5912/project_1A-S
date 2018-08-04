package com.storeArticle.store.service.warehouseProductService;

import com.storeArticle.store.model.warehouse.WareHouseMain;
import com.storeArticle.store.service.dto.BussineDTOService;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.WareHouseMainQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.storeArticle.store.service.enumPage.WarehouseQueryEnum.getlookForWarehouseHql;

@Service
@Transactional
public class WareHouseMainService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SelectDTOService selectDTOService;
    public List<Object[]> getWarehouseCodeListAll(){
        return entityManager.createQuery(WareHouseMainQueryEnum.getListWareHouseMainCodeHql.getHql())
                .setParameter(1,false)
                .getResultList();
    }
    public List<SelectVEO> getWareHouserMainListDTO(){
        return selectDTOService.getIdNameDTOAndId(getWarehouseCodeListAll());
    }
    public List<WareHouseMain> getWarehouseMainListAll(){
        return entityManager.createQuery(getlookForWarehouseHql.getListWarehouseHql.getHql())
                .setParameter(1,false)
                .getResultList();

    }

}
