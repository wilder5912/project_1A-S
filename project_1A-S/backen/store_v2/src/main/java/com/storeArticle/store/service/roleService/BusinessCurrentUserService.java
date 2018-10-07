package com.storeArticle.store.service.roleService;

import com.storeArticle.store.model.accounts.BusinessCurrentUser;
import com.storeArticle.store.model.accounts.RoleUser;
import com.storeArticle.store.model.accounts.User;
import com.storeArticle.store.service.accounts.UserService;
import com.storeArticle.store.service.enumPage.roleEmun.BusinessCurrentUserQueryEnum;
import com.storeArticle.store.service.enumPage.roleEmun.RoleUserQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class BusinessCurrentUserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserService userService;

    public boolean addbusinCurreUser(BusinessCurrentUser businessCurrentUser){
        boolean isCreate = false;
        if(isCreateBusinessUser(businessCurrentUser.getUserID().getUserID(),businessCurrentUser.getBusinessId().getBusinessId())){
            entityManager.persist(businessCurrentUser);
            isCreate = true;
        }
        User user = new User();
        user.setUserID(businessCurrentUser.getUserID().getUserID());
        user.setBussineIdUser(businessCurrentUser.getBusinessId().getBusinessId());
        userService.updatedUserBusiness(user);
        return isCreate;
    }
    public BusinessCurrentUser getRoleUser(int BusinessCurrentUserId){
        return entityManager.find(BusinessCurrentUser.class, BusinessCurrentUserId);
    }

    public boolean isCreateBusinessUser(int idUser, int idBusiness){
        List<BusinessCurrentUser> businessCurrentUserList = getbusinessCurrentUser(idUser, idBusiness);
        if(businessCurrentUserList.size() == 0){
            return true;
        } else{
            return false;
        }
    }

    public List<BusinessCurrentUser> getbusinessCurrentUser(int idUser, int idBusiness){
        return entityManager.createQuery(BusinessCurrentUserQueryEnum.getListBusinessCurrentUserHql.getHql())
                .setParameter(1, idUser)
                .setParameter(2, idBusiness)
                .setParameter(3,false)
                .getResultList();
    }

}
