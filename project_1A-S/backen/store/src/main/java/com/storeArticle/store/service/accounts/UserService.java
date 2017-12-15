package com.storeArticle.store.service.accounts;

import com.storeArticle.store.model.accounts.TypeUser;
import com.storeArticle.store.service.JwtGenerator.JwtGenerator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

import com.storeArticle.store.model.accounts.User;
import org.springframework.web.bind.annotation.PostMapping;

@Transactional
@Repository
public class UserService implements UserCrup {

    @PersistenceContext
    private EntityManager entityManager;


  //  private JwtGenerator jwtGenerator = new JwtGenerator() ;

    private List<TypeUser> ss;

  //  @Override
    public List<TypeUser> getUser(String email, String password){
      //  String hql = "select r FROM RegisterUser as r where r.user.password='"+password+"' and r.user.emailUser='"+email+"' ";
      //  List<RegisterUser> s = entityManager.createQuery(hql).getResultList();
        return null;
    }

    @Override
  //  @PostMapping
    public void addUser(User user){
    //    String ps= jwtGenerator.generate(user);
    //   user.setPassword(ps);
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
    public User getAutentification(String email, String password) {
        String userQuery = "select user FROM User as user  where user.emailUser='"+email+"' and user.password ='"+password+"' ";
        User user;

        try{
             user = (User)entityManager.createQuery(userQuery).getSingleResult();
             //user.setPassword(null);
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
