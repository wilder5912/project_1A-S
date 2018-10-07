package com.storeArticle.store.service.warehouseProductService;

import com.storeArticle.store.model.groupProductModel.ArticleDetail;
import com.storeArticle.store.model.provider.ArticleProvider;
import com.storeArticle.store.model.provider.Provider;
import com.storeArticle.store.service.ProviderProductService.ArticleProviderService;
import com.storeArticle.store.service.ProviderProductService.ProviderService;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.enumPage.warehouseEmun.WarehouseQueryEnum;
import com.storeArticle.store.service.groupProductService.ArticleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.storeArticle.store.model.warehouse.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.storeArticle.store.service.enumPage.warehouseEmun.WarehouseQueryEnum.getlookForWarehouseHql;

@Service
@Transactional
public class WarehouseService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ArticleDetailService articleDetailService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ArticleProviderService articleProviderService;

    @Autowired
    private SelectDTOService selectDTOService;

    public boolean addWarehouse(Warehouse warehouse){
        boolean isWarehouse = false;
        if(this.articleProviderService.addArticleProvider(warehouse.getArticleProviderId())) {
            ArticleProvider articleProvider = this.articleProviderService.getArticleProviderCode(warehouse.getArticleProviderId().getCodeArticleProvider());
            warehouse.setArticleProviderId(articleProvider);
            warehouse.setDelete(false);
            entityManager.persist(warehouse);
            isWarehouse = true;
        }else{
            ArticleProvider articleProvider = this.articleProviderService.getArticleProviderCode(warehouse.getArticleProviderId().getCodeArticleProvider());
            warehouse.setArticleProviderId(articleProvider);
            warehouse.setDelete(false);
            entityManager.persist(warehouse);
            isWarehouse = true;
        }
        return isWarehouse;
    }

    public boolean isWarehouseList(String articleProviderCode){
        List<Warehouse> warehouseList = getWarehouseList(articleProviderCode);
        if(warehouseList.size() == 0){
            return true;
        } else{
            return false;
        }
    }
    public Warehouse getWarehouse(int warehouseId){
        return entityManager.find(Warehouse.class, warehouseId);
    }
    public boolean updatedWarehouse(Warehouse warehouseNew){
        Warehouse warehouse = getWarehouse(warehouseNew.getWarehouseId());
        warehouse.setCodeWarehouse(warehouseNew.getCodeWarehouse());
        warehouse.setFatureWarehouse(warehouseNew.getFatureWarehouse());
        warehouse.setFatureWarehouse(warehouseNew.getFatureWarehouse());
        warehouse.setFatureWarehouse (warehouseNew.getFatureWarehouse());
        warehouse.setQuantytiProviderWarehouse(warehouseNew.getQuantytiProviderWarehouse());
        warehouse.setDateStartWarehouse(warehouseNew.getDateStartWarehouse());
        warehouse.setDateEndWarehouse(warehouseNew.getDateEndWarehouse());
        warehouse.setCodeWarehouse(warehouseNew.getCodeWarehouse());
        ArticleDetail articleDetailIdNew = articleDetailService.getArticleDetail(warehouseNew.getArticleDetailId().getArticleDetailId());
        warehouse.setArticleDetailId(articleDetailIdNew);
        Provider providerNew =  providerService.getProvider(warehouseNew.getProviderId().getProviderId());
        warehouse.setProviderId(providerNew);
        ArticleProvider articleProvider = articleProviderService.getArticleProvider(warehouseNew.getArticleProviderId().getArticleProviderId());
        warehouse.setArticleProviderId(articleProvider);
        entityManager.flush();
        return null != warehouse;
    }

    public List<Warehouse> getWarehouseList(String articleProviderCode){
        return entityManager.createQuery(WarehouseQueryEnum.getlookForWarehouseHql.getHql())
                .setParameter(1, articleProviderCode)
                .setParameter(2,false)
                .getResultList();

    }

    public boolean deleteWarehouseList(int warehouseId){
        Warehouse warehouse = getWarehouse(warehouseId);
        warehouse.setDelete(true);
        entityManager.flush();
        return null != warehouse;
    }

    public List<Warehouse> getWarehouseListAll(){
        return entityManager.createQuery(WarehouseQueryEnum.getListWarehouseHql.getHql())
                .getResultList();

    }
    public List<String> getWarehouseCodeListAll(){
        return entityManager.createQuery(WarehouseQueryEnum.getListWarehouseCodeHql.getHql())
                .setParameter(1,false)
                .getResultList();
    }
    public int getWarehouseNumArticle(String codeArticle, int businessId){
        try{
            Object d =entityManager.createQuery(WarehouseQueryEnum.getNumberOfArticleCodHql.getHql())
                    .setParameter(1,codeArticle)
                    .setParameter(2,businessId)
                    .setParameter(3,false)
                    .getSingleResult();
            Object d2 =entityManager.createQuery(WarehouseQueryEnum.getNumberOfArticleCodHql.getHql())
                    .setParameter(1,codeArticle)
                    .setParameter(2,businessId)
                    .setParameter(3,false)
                    .getSingleResult().hashCode();

        return entityManager.createQuery(WarehouseQueryEnum.getNumberOfArticleCodHql.getHql())
                .setParameter(1,codeArticle)
                .setParameter(2,businessId)
                .setParameter(3,false)
                .getSingleResult().hashCode();
        }catch (RuntimeException e){
            return 0;
        }
    }

    public List<Integer> getListWareHouserId(int detailArticleId){
        return entityManager.createQuery(WarehouseQueryEnum.getListIdwareHouseCodHql.getHql())
                .setParameter(1,detailArticleId)
                .setParameter(2,false)
                .getResultList();

    }

    public void updateWarehouser(Warehouse warehouse, int numerWarehouser, int idWarehouser){
       int  x =  entityManager.createQuery(WarehouseQueryEnum.getUpdateIdwareHouseCodHql.getHql())
                .setParameter(1,numerWarehouser)
                .setParameter(2,idWarehouser)
                .executeUpdate();
    }

}
