package com.storeArticle.store.service.dao.user;

import com.storeArticle.store.model.accounts.User;
import com.storeArticle.store.service.dao.groupProductDTO.InfoCrup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AdminDAO implements InfoCrup {
    @PersistenceContext
    private EntityManager entityManager;
    private User admin;

    public AdminDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addObject(Object object) {
        this.admin = (User) object;
        this.admin.setTypeUser("Admin");
        this.entityManager.persist(this.admin);
    }
}