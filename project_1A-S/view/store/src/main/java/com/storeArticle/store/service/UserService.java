package com.storeArticle.store.service;


import com.storeArticle.store.entity.RegisterUser;
import com.storeArticle.store.entity.TypeUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserService implements UserServiveI {

    @PersistenceContext
    private EntityManager entityManager;

    private List<TypeUser> ss;

    @Override
    public List<TypeUser> getUser(String email, String password){
        String hql = "select r FROM RegisterUser as r where r.user.password='"+password+"' and r.user.emailUser='"+email+"' ";
        List<RegisterUser> s = entityManager.createQuery(hql).getResultList();
        return null;
    }




}
