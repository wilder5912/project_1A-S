package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.GroupProduct;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class GroupProductService implements GroupProductCrup{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addGroupProductName(GroupProduct groupProduct) {
        boolean isRegisterGroupProduct=false;
        if(isCreateUser(groupProduct.getNameGroup())) {
            isRegisterGroupProduct=true;
            entityManager.persist(groupProduct);
        }
        return isRegisterGroupProduct;
    }

    @Override
    public void deleteGroupProductName(int userId) {

    }

    @Override
    public void updatedGroupProductName(int userId, GroupProduct groupProduct) {

    }

    @Override
    public GroupProduct getGroupProductName(int userId) {
        return null;
    }

    @Override
    public Boolean getIsGroupProductName() {
        return null;
    }

    public List<GroupProduct> getNameGroupProduct(String nameGroup) {
        String groupProduct = "select groupProduct FROM GroupProduct as groupProduct  where groupProduct.nameGroup ='"+nameGroup+"' ";
        return entityManager.createQuery(groupProduct).getResultList();
    }
    public boolean isCreateUser(String nameGroup){
        List<GroupProduct> groupProduct = getNameGroupProduct(nameGroup);
        if(groupProduct.size() == 0){
            return true;
        } else{
            return false;
        }
    }


}
