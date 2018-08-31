package com.storeArticle.store.service.roleService;

import com.storeArticle.store.model.accounts.DetailRole;
import com.storeArticle.store.service.enumPage.roleEmun.DetailRoleQueryEmum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class DetailRoleService {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean addDetailRole(DetailRole detailRole){
        boolean isDetailRole = false;
        if(isCreateDetailRoleUser(detailRole.getUserID().getUserID(), detailRole.getRoleUserId().getRoleUserId())){
            entityManager.persist(detailRole);
            isDetailRole = true;
        }
        return isDetailRole;
    }
    public DetailRole getRoleUser(int detailRoleId){
        return entityManager.find(DetailRole.class, detailRoleId);
    }

    public boolean isCreateDetailRoleUser(int userId, int roleUserId){
        List<DetailRole> detailRoleList = getDetailRoleUsRo(userId, roleUserId);
        if(detailRoleList.size() == 0){
            return true;
        } else{
            return false;
        }
    }

    public List<DetailRole> getDetailRoleUsRo(int userId, int roleUserId){
        return entityManager.createQuery(DetailRoleQueryEmum.getListDetailRoleUserHql.getHql())
                .setParameter(1, userId)
                .setParameter(2, roleUserId)
                .setParameter(3,false)
                .getResultList();
    }
    public List<Object[]> getDetailRoleUser(int userId){
        return entityManager.createQuery(DetailRoleQueryEmum.getListOfDetailRoleUsersHql.getHql())
                .setParameter(1, userId)
                .setParameter(2,false)
                .getResultList();
    }

    public List<DetailRole> getListDetailRole(String lookforUser){
        return entityManager.createQuery(DetailRoleQueryEmum.getListUserForUserHql.getHql())
                .setParameter(1,"%" + lookforUser + "%")
                .setParameter(2,"%" + lookforUser + "%")
                .setParameter(3,false)
                .getResultList();
    }

}
