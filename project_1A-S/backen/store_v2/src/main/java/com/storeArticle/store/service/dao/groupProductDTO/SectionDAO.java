package com.storeArticle.store.service.dao.groupProductDTO;

import com.storeArticle.store.model.accounts.Section;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SectionDAO implements InfoCrup {
    @PersistenceContext
    private EntityManager entityManager;
    private Section section;

    public SectionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addObject(Object object) {
        this.section =  (Section) object;
        this.entityManager.persist(this.section);
    }
}
