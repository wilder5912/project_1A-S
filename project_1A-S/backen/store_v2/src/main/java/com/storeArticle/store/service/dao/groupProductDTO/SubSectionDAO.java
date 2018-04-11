package com.storeArticle.store.service.dao.groupProductDTO;

import com.storeArticle.store.model.accounts.Section;
import com.storeArticle.store.model.accounts.SubSection;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SubSectionDAO implements InfoCrup {
    @PersistenceContext
    private EntityManager entityManager;
    private SubSection subSection;

    public SubSectionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addObject(Object object) {
        this.subSection =  (SubSection) object;
        this.entityManager.persist(this.subSection);
    }
}
