package com.storeArticle.store.service.dao.groupProductDTO;


import com.storeArticle.store.model.accounts.GroupProduct;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class GroupProductDAO implements InfoCrup {
    @PersistenceContext
    private EntityManager entityManager;
    private GroupProduct groupProduct;

    public GroupProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addObject(Object object) {
        this.groupProduct =  (GroupProduct) object;
        this.entityManager.persist(this.groupProduct);
    }
}
