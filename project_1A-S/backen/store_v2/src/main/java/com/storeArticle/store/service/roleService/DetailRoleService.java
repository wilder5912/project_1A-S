package com.storeArticle.store.service.roleService;

import com.storeArticle.store.model.accounts.DetailRole;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.roleEmun.DetailRoleQueryEmum;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private SelectDTOService selectDTOService;

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
    public List<Object[]> getListUserRoleDetail(int roleId){
        return entityManager.createQuery(DetailRoleQueryEmum.getListRoleUserDetailHql.getHql())
                .setParameter(1, roleId)
                .setParameter(2,false)
                .getResultList();
    }
    public int getListUserIdRoleId(int userId, int roleId){
        return (int)entityManager.createQuery(DetailRoleQueryEmum.getListDetailRoleIdUserIdHql.getHql())
                .setParameter(1, userId)
                .setParameter(2, roleId)
                .setParameter(3,false)
                .getSingleResult();
    }

    public List<Object> getDetailRoleUserId(int userId){
        return entityManager.createQuery(DetailRoleQueryEmum.getListOfDetailRoleUsersIdHql.getHql())
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

    public List<Object> getAllDetailRoleUserId(int userId){
        return getDetailRoleUserId(userId);
    }

    public List<SelectVEO> getListSelectDTO(int userId){
        return  selectDTOService.getIdNameDTO(getDetailRoleUser(userId));
    }
    public List<SelectVEO> getListSelectUserRoleDTO(int roleId){
        return  selectDTOService.getTreeDataDTO(getListUserRoleDetail(roleId));
    }

    public int getUserIdAndRoleId(DetailRole detailRole){
        return  getListUserIdRoleId(detailRole.getUserID().getUserID(), detailRole.getRoleUserId().getRoleUserId());
    }

    public boolean addDetailRoleRelational(List<DetailRole> detailRoleData){
        try {
            detailRoleData.forEach(selectDatas->{
                this.addDetailRole(selectDatas);
             });
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
