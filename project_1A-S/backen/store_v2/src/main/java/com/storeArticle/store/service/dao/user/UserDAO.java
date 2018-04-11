package com.storeArticle.store.service.dao.user;

import com.storeArticle.store.model.accounts.User;
import com.storeArticle.store.service.dao.groupProductDTO.InfoCrup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDAO implements InfoCrup {
    @PersistenceContext
    private EntityManager entityManager;
    private User user;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addObject(Object object) {
        this.user = (User) object;
            this.user.setTypeUser("User");
        this.entityManager.persist(this.user);
    }
}