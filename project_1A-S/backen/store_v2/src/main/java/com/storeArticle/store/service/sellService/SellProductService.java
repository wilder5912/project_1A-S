package com.storeArticle.store.service.sellService;


import com.storeArticle.store.model.SellModel.DetailSell;
import com.storeArticle.store.model.SellModel.SellProduct;
import com.storeArticle.store.model.TypeMoneyModel.PaymentType;
import com.storeArticle.store.model.clientModel.Client;
import com.storeArticle.store.model.warehouse.Warehouse;
import com.storeArticle.store.service.clientProductService.ClientService;
import com.storeArticle.store.service.warehouseProductService.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SellProductService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private DetailSellService detailSellService;

    @Autowired
    private ClientService clientService;

    private int numberArticleA = 0;
    private SellProduct sellProductA;
    private Client clientA;
    public SellProduct addSellProduct(SellProduct sellProduct){
        boolean isAdd = false;
        int x = this.warehouseService.getWarehouseNumArticle(sellProduct.getWarehouseId().getArticleDetailId().getArticleId().getCodigoAr(), sellProduct.getWarehouseId().getArticleDetailId().getSubSectionId().getSectionId().getGroupId().getBusinessId().getBusinessId());
        if(this.warehouseService.getWarehouseNumArticle(sellProduct.getWarehouseId().getArticleDetailId().getArticleId().getCodigoAr(), sellProduct.getWarehouseId().getArticleDetailId().getSubSectionId().getSectionId().getGroupId().getBusinessId().getBusinessId()) >0){
            isAdd = true;
            if(null == clientA){
                clientA = clientService.addClientAndGet(sellProduct.getClientId());
            }
            Client client = clientA;
            sellProduct.setClientId(client);
            DetailSell detailSell = sellProduct.getDetailSellId();
            detailSell = detailSellService.addSellProduct(detailSell);
            sellProduct.setDetailSellId(detailSell);
            List<Integer> listIdWareHouser = warehouseService.getListWareHouserId(sellProduct.getWarehouseId().getArticleDetailId().getArticleDetailId());
            Warehouse warehouse = this.warehouseService.getWarehouse(listIdWareHouser.get(0));
            sellProduct.setWarehouseId(warehouse);
            entityManager.persist(sellProduct);
        }
        return sellProduct;
    }



    public void discountMount(SellProduct sellProduct ){ //int idDetailArticle,  int numberArticle
        sellProductA = sellProduct;
        List<Integer> listIdWareHouser = warehouseService.getListWareHouserId(sellProductA.getWarehouseId().getArticleDetailId().getArticleDetailId());
        numberArticleA = sellProductA.getNumberPrudctSp();
        listIdWareHouser.forEach(SelectData->{

            Warehouse warehouse = this.warehouseService.getWarehouse(SelectData);
            int numberArticleCurrent = warehouse.getQuantytiCurrectWarehouse() - numberArticleA;
            if(numberArticleA > 0){
                if(numberArticleCurrent == 0){
                    this.warehouseService.updateWarehouser(warehouse, 0,SelectData);
                    numberArticleA = 0;
                }
                if(numberArticleCurrent < 0) {
                    this.warehouseService.updateWarehouser(warehouse, 0,SelectData);
                    numberArticleA  = Math.abs(numberArticleCurrent);
                }
                if(numberArticleCurrent > 0){
                    this.warehouseService.updateWarehouser(warehouse, numberArticleCurrent,SelectData);
                    numberArticleA = 0;
                }

            }
        });

        int x = 0;
    }

    public List<SellProduct> addSellProductLisy(List<SellProduct> sellProductsList ){
        clientA = null;
        for(int i = 0; i< sellProductsList.size();i++ ){
            sellProductsList.set(i, addSellProduct(sellProductsList.get(i))) ;
        }

        for(int i = 0; i< sellProductsList.size();i++ ){
            discountMount(sellProductsList.get(i));
        }




        return sellProductsList;
    }

    public boolean addSellProductLisyD(SellProduct sellProductsList ){
             addSellProduct(sellProductsList);
        return false;
    }


}
