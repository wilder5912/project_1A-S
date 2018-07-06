package com.storeArticle.store.service.boxArticle;

import com.storeArticle.store.model.groupProductModel.ListProduct;
import com.storeArticle.store.service.enumPage.ListProductEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class ListProductService implements ListProductCrup {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addListProduct(ListProduct listProduct) {
        boolean isListProduct = false;

        entityManager.persist(listProduct);

        return isListProduct;
    }

    @Override
    public boolean deleteListProduct(int listProductId) {
        return false;
    }

    @Override
    public boolean updatedListProduct(ListProduct listProduct) {
        return false;
    }

    @Override
    public ListProduct getListProduct(int listProductId) {
        return entityManager.find(ListProduct.class, listProductId);
    }

    @Override
    public Boolean getIsListProduct() {
        return null;
    }


    public List<Object[]> getListArticle(int boxId){

        List<Object> c = entityManager.createQuery(ListProductEnum.getArticleBox.getHql())
                .setParameter(1, boxId)
                .setParameter(2, false)
                .getResultList();

        return entityManager.createQuery(ListProductEnum.getArticleBox.getHql())
                .setParameter(1, boxId)
                .setParameter(2, false)
                .getResultList();

    }
    public ListProduct getListArticleData(ListProduct listProduct ){
        ListProduct listProduct1Data;
        try{
            listProduct1Data= (ListProduct)entityManager.createQuery(ListProductEnum.getArticleNumberBox.getHql())
                    .setParameter(1, listProduct.getBoxId().getBoxId())
                    .setParameter(2, listProduct.getArticleId().getArticleId())
                    .setParameter(3, false)
                    .getSingleResult();
    }catch (RuntimeException e){
            listProduct1Data = new ListProduct();
    }
    return listProduct1Data;
    }

    public void updateNumberArticle(ListProduct listProduct) {
        entityManager.createQuery(ListProductEnum.updateMumberArticleHql.getHql())
                .setParameter(1, listProduct.getNumProduct())
                .setParameter(2, listProduct.getBoxId().getBoxId())
                .setParameter(3, listProduct.getArticleId().getArticleId())
                .setParameter(4, false)
                .executeUpdate();
    }
}
