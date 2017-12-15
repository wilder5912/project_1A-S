package com.storeArticle.store.service.accounts;

import com.storeArticle.store.model.accounts.TypeUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import com.storeArticle.store.model.accounts.User;

@Transactional
@Repository
public class UserService implements UserCrup {

    @PersistenceContext
    private EntityManager entityManager;

    private List<TypeUser> ss;

  //  @Override
    public List<TypeUser> getUser(String email, String password){
      //  String hql = "select r FROM RegisterUser as r where r.user.password='"+password+"' and r.user.emailUser='"+email+"' ";
      //  List<RegisterUser> s = entityManager.createQuery(hql).getResultList();
        return null;
    }

    @Override
    public void addUser(User user){
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void updatedUser(int userId, User user) {

    }

    @Override
    public User getUser(int userId) {
        return null;
    }

    @Override
    public Boolean getIsDeleted() {
        return null;
    }

    public List<User> getUserEmail(String email) {
        String user = "select user FROM User as user  where user.emailUser='"+email+"' ";
        return entityManager.createQuery(user).getResultList();
    }

    public boolean isCreateUser(String email){
         List<User> user = getUserEmail(email);
           if(user.size() == 0){
               return true;
           } else{
               return false;
           }

    }
}
