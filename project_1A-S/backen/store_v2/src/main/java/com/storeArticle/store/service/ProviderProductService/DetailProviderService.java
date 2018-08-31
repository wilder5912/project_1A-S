package com.storeArticle.store.service.ProviderProductService;

import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.model.provider.DetailProvider;
import com.storeArticle.store.model.provider.Provider;
import com.storeArticle.store.service.enumPage.providerEnun.DetailProviderQueryEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class DetailProviderService {


    @PersistenceContext
    private EntityManager entityManager;

    public boolean addDetailProvider(DetailProvider detailProvider){

        boolean isDetailProvider = false;
        if(isCreateDetailProvider(detailProvider.getProviderId().getProviderId(), detailProvider.getBusinessId().getBusinessId())) {
            detailProvider.setDelete(false);
            entityManager.persist(detailProvider);
            isDetailProvider = true;
        }
        return isDetailProvider;
    }
    public boolean isCreateDetailProvider(int providerId, int businessId){
        List<DetailProvider> providerList = getDetailProviderListCode(providerId,businessId);
        if(providerList.size() == 0){
            return true;
        } else{
            return false;
        }
    }
    public List<DetailProvider> getDetailProviderListCode(int providerId, int businessId){
        return entityManager.createQuery(DetailProviderQueryEnum.getlookForDetailProvider.getHql())
                .setParameter(1, providerId)
                .setParameter(2, businessId)
                .setParameter(3,false)
                .getResultList();

    }

    public DetailProvider getDetailProvider(int Provider){
        return entityManager.find(DetailProvider.class, Provider);
    }

    public boolean deleteDetailProvider(int detailProviderId){
        DetailProvider detailProvider = getDetailProvider(detailProviderId);
        detailProvider.setDelete(true);
        entityManager.flush();
        return null != detailProvider;
    }


    public boolean updatedDetailProviderForId(DetailProvider detailProviderNew){
        DetailProvider detailProvider = getDetailProvider(detailProviderNew.getDetailProviderId());
        Business business = detailProviderNew.getBusinessId();
        detailProvider.setBusinessId(business);
        Provider provider = detailProviderNew.getProviderId();
        detailProvider.setProviderId(provider);
        entityManager.flush();
        return null != detailProvider;
    }
    public List<DetailProvider> getDetailProviderListAll(){
        return entityManager.createQuery(DetailProviderQueryEnum.getListDetailProviderHql.getHql())
                .getResultList();
    }
}
