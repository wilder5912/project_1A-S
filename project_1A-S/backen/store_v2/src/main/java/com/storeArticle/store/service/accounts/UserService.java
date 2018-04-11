package com.storeArticle.store.service.accounts;

import com.storeArticle.store.model.accounts.User;
import com.storeArticle.store.service.JwtGenerator.JwtGeneratorService;
import com.storeArticle.store.service.JwtGenerator.JwtValidatorService;
import com.storeArticle.store.service.dao.groupProductDTO.InfoCrup;
import com.storeArticle.store.service.dao.user.UserDAO;
import com.storeArticle.store.service.enumPage.UserQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Transactional
@Repository
public class UserService implements UserCrup {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private JwtGeneratorService jwtGeneratorService;
    @Autowired
    private JwtValidatorService jwtValidatorService;

    private  Path rootLocation = Paths.get("../webapps/store-0.0.1-SNAPSHOT/upload-dir/userImage");
    private InfoCrup infoCrup;

    @Override
    public void addUser(User user){
        user.setCodeUser(randomString());
        user.setImagenUser("user-local.png");
        user.setTokenUser(jwtGeneratorService.generate(user));
        user.setIdBoxUser(0);
        infoCrup = new UserDAO(entityManager);
        infoCrup.addObject(user);
        ///entityManager.persist(user);
    }

    @Override
    public void deleteUser(int userId) {
    }

    @Override
    public void updatedUser(User userNew) {
        User user = getUser(userNew.getUserID());
        if(null != userNew.getImagenUser()){
            user.setImagenUser(userNew.getImagenUser());
        }

        entityManager.flush();
    }

    @Override
    public User getUser(int userId) {
        return entityManager.find(User.class, userId);    }

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
         User user;
        try{
             user = (User)entityManager.createQuery( UserQueryEnum.getAutentificationHql.getHql())
                                                            .setParameter(1,email)
                                                            .setParameter(2,password)
                                                            .getSingleResult();
            User userActial = getUser(user.getUserID());
            userActial.setTokenUser(randomString());
            userActial.setTokenUser(jwtGeneratorService.generate(user));
            entityManager.flush();
            user = userActial;

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
        if(null != user && null != user.getEmailUser()) {
            if (user.getEmailUser().equals(userNew.getEmailUser())) {
                isUser = true;
            }else{
                isUser = false;
            }
        }
        return isUser;
    }

    public User getUserActual(User user, User userNew, String token){
        User userToken = jwtValidatorService.validate(token);
         List<User> userList = getUserToke(userToken);
        if(!isUserActual(userToken, userNew) || userList.size() == 0) {
                user = null;
         }else{
            user = userList.get(0);
        }
           return user;
    }

    public List<User> getUserToke(User user){

       return entityManager.createQuery(UserQueryEnum.getAutentificationTokenHql.getHql()).setParameter(1,user.getTokenUser())
                .setParameter(2, user.getCodeUser())
                .getResultList();
    }



    public boolean isCreateUser(String email){
         List<User> user = getUserEmail(email);
           if(user.size() == 0){
               return true;
           } else{
               return false;
           }
    }



    public User editImageUserOne(MultipartFile file, User user) {
        try {
            String renameImage=randomString();
            Path fileData = rootLocation.resolve(user.getImagenUser());
            Resource resource = new UrlResource(fileData.toUri());
            if (resource.exists() && !user.getImagenUser().equals("user-local.png")) {
                Files.delete(fileData);
            }
            user.setImagenUser(renameImage+file.getOriginalFilename());
            updatedUser(user);
            Files.copy(file.getInputStream(), this.rootLocation.resolve(renameImage+file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        return user;
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public String randomString() {
        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        String cadena = "";
        int numero;
        int forma;
        forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
        numero=(int)(aleatorio.nextDouble() * 99+100);
      return cadena+alfa.charAt(forma)+numero;
    }

}
