package com.storeArticle.store.service.roleService;

import com.storeArticle.store.model.accounts.RoleUser;
import com.storeArticle.store.service.enumPage.roleEmun.RoleUserQueryEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class RoleUserService {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean addTypeMoney(RoleUser roleUser){
        boolean isRoleUser = false;
        if(isCreateProvider(roleUser.getNameRole())){
            entityManager.persist(roleUser);
            isRoleUser = true;
        }
        return isRoleUser;
    }
    public RoleUser getRoleUser(int roleUserId){
        return entityManager.find(RoleUser.class, roleUserId);
    }

    public boolean isCreateProvider(String roleUserName){
        List<RoleUser> roleUserList = getRoleUserName(roleUserName);
        if(roleUserList.size() == 0){
            return true;
        } else{
            return false;
        }
    }
    public List<RoleUser> getRoleUserName(String roleUserName){
        return entityManager.createQuery(RoleUserQueryEnum.getListRoleUserHql.getHql())
                .setParameter(1, roleUserName)
                .setParameter(2,false)
                .getResultList();
    }

    public List<RoleUser> getListRoleUser(){
        return entityManager.createQuery(RoleUserQueryEnum.getListOfRoleUsersHql.getHql())
                .setParameter(1,false)
                .getResultList();
    }


    public boolean deleteRoleUser(int warehouseId){
        RoleUser roleUser = getRoleUser(warehouseId);
        roleUser.setDelete(true);
        entityManager.flush();
        return null != roleUser;
    }
    public boolean updatedRoleUser(RoleUser roleUserNew){
        RoleUser roleUser = getRoleUser(roleUserNew.getRoleUserId());
        roleUser.setNameRole(roleUserNew.getNameRole());
        roleUser.setDelete(false);
        entityManager.flush();
        return null != roleUser;
    }

}
