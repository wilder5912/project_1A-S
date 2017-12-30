package com.storeArticle.store.service.accounts;

import com.storeArticle.store.model.accounts.User;
import com.storeArticle.store.service.enumPage.UserQueryEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserService implements UserCrup {

    @PersistenceContext
    private EntityManager entityManager;

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
        String userHql= UserQueryEnum.getUserEmailHql.getHql();
        return entityManager.createQuery(userHql).setParameter(1,email)
                                                .getResultList();
    }
    public User getAutentification(String email, String password) {
        String userHql= UserQueryEnum.getAutentificationHql.getHql();
        User user;
        try{
             user = (User)entityManager.createQuery(userHql).setParameter(1,email)
                                                            .setParameter(2,password)
                                                            .getSingleResult();
        }catch (RuntimeException e){
            user=null;
        }

        return user;
    }

    public User getUserData(User user) {
        return getAutentification(user.getEmailUser(),user.getPassword());
    }

    public Boolean isUserActual(User user, User userNew){
        Boolean isUser = false;
        if(null != user) {
            if (user.getEmailUser().equals(userNew.getEmailUser())) {
                isUser = true;
            }else{
                isUser = false;
            }
        }
        return isUser;
    }

    public User getUserActual(User user, User userNew){
           if(!isUserActual(user, userNew)) {
                user = null;
           }
           return user;
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
