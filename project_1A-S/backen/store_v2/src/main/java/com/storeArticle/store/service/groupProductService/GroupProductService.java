package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.model.groupProductModel.GroupProduct;
import com.storeArticle.store.service.dao.groupProductDTO.GroupProductDAO;
import com.storeArticle.store.service.dao.groupProductDTO.InfoCrup;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.GroupProductQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class GroupProductService implements GroupProductCrup{

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SelectDTOService selectDTOService;
    @Autowired
    private BusinessService bussineService;

    private InfoCrup infoCrup;

    private GroupProductDAO groupProductDAO;
    @Override
    public boolean addGroupProductName(GroupProduct groupProduct) {
        boolean isRegisterGroupProduct = false;
        if(isCreateGroupProduct(groupProduct.getNameGroup(),groupProduct.getBusinessId().getBusinessId())) {
            isRegisterGroupProduct=true;
            infoCrup = new GroupProductDAO(entityManager);
            infoCrup.addObject(groupProduct);
        }
        return isRegisterGroupProduct;
    }

    @Override
    public boolean deleteGroupProductName(int groupProductId) {
        GroupProduct groupProduct = getGroupProductName(groupProductId);
        groupProduct.setDelete(true);
        return null != groupProduct;
    }

    @Override
    public boolean updatedGroupProductName(GroupProduct groupProductNew) {
        GroupProduct groupProduct = getGroupProductName(groupProductNew.getGroupId());
        Business bussine = bussineService.getBusiness(groupProductNew.getBusinessId().getBusinessId());
        boolean iscorrect = false;
        boolean iscorrectBussine=false;
        if(groupProduct.getBusinessId().getBusinessId() == groupProductNew.getBusinessId().getBusinessId() && !groupProduct.getNameGroup().equals(groupProductNew.getNameGroup()) ) {
            if(isCreateGroupProduct(groupProductNew.getNameGroup(),groupProductNew.getBusinessId().getBusinessId())) {
                iscorrect = true;
                groupProduct.setNameGroup(groupProductNew.getNameGroup());
                entityManager.flush();
            }
        }

        if(groupProduct.getBusinessId().getBusinessId() != groupProductNew.getBusinessId().getBusinessId() && groupProduct.getNameGroup().equals(groupProductNew.getNameGroup())) {
            if(isCreateGroupProduct(groupProductNew.getNameGroup(),groupProductNew.getBusinessId().getBusinessId())) {
                iscorrectBussine = true;
                groupProduct.setBusinessId(bussine);
                entityManager.flush();
            }
        }

        return  iscorrectBussine || iscorrect;

    }

    @Override
    public GroupProduct getGroupProductName(int groupId) {
        return entityManager.find(GroupProduct.class, groupId);
    }

    @Override
    public Boolean getIsGroupProductName() {
        return null;
    }

    public List<GroupProduct> getNameGroupProduct(String nameGroup , int bussineIdData) {
        String groupProductHql = GroupProductQueryEnum.getNameGroupProductHql.getHql();
        return entityManager.createQuery(groupProductHql).setParameter(1,bussineIdData)
                                             .setParameter(2,nameGroup)
                                             .getResultList();
    }

    public List<GroupProduct> getGroupProduct() {
       // List<GroupProduct> x = getProductoIdName();
        return getProductoIdName();
    }

    public List<GroupProduct> getProductoIdName(){
        String groupProductHql= GroupProductQueryEnum.getProductoGroupList.getHql();
        return entityManager.createQuery(groupProductHql).getResultList();
    }

    public boolean isCreateGroupProduct(String nameGroup, int idBussineData ){
        List<GroupProduct> groupProduct = getNameGroupProduct(nameGroup,idBussineData);
        if(groupProduct.size() == 0){
            return true;
        } else{
            return false;
        }
    }
    public List<Object[]> getListGroupProductBussineId(int idBussine){

        return entityManager.createQuery(GroupProductQueryEnum.getGroupProductBsussineIdHql.getHql())
                .setParameter(1,idBussine)
                .setParameter(2,false).getResultList();

    }
    public List<SelectVEO> getListGroupDTO(int BussineId){
       return  selectDTOService.getIdNameDTO(getListGroupProductBussineId(BussineId));
    }





}
