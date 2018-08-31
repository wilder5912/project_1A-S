package com.storeArticle.store.service.ProviderProductService;

import com.storeArticle.store.model.provider.Provider;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.providerEnun.ProviderQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ProviderService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SelectDTOService selectDTOService;
    public boolean addprovider(Provider provider){

        boolean isBusiness = false;
        if(isCreateProvider(provider.getCodeProvider())) {
            provider.setDelete(false);
            entityManager.persist(provider);
            isBusiness = true;
        }
        return isBusiness;
    }

    public boolean deleteProvider(int providerId){
        Provider provider = getProvider(providerId);
        provider.setDelete(true);
        entityManager.flush();
        return null != provider;
    }
    public boolean updatedProviderForId(Provider providerNew){
        Provider provider = getProvider(providerNew.getProviderId());
        provider.setCodeProvider(providerNew.getCodeProvider());
        provider.setNameProvider (providerNew.getNameProvider()); ;
        provider.setNumberPhoneProvider(providerNew.getNumberPhoneProvider());
        entityManager.flush();
        return null != provider;
    }

    public Provider getProvider(int Provider){
        return entityManager.find(Provider.class, Provider);
    }

    public boolean isCreateProvider(String articleProviderCode){
        List<Provider> providerList = getProviderListCode(articleProviderCode);
        if(providerList.size() == 0){
            return true;
        } else{
            return false;
        }
    }
    public List<Provider> getProviderListCode(String articleProviderCode){
        String groupProductHql = ProviderQueryEnum.getlookForProvider.getHql();
        return entityManager.createQuery(groupProductHql)
                .setParameter(1, articleProviderCode)
                .setParameter(2,false)
                .getResultList();
    }
    public List<Provider> getProviderListAll(){
        String groupProductHql = ProviderQueryEnum.getListProviderHql.getHql();
        return entityManager.createQuery(groupProductHql)
                .getResultList();
    }

    public List<Object[]> getProviderIdCodeList(){
        return entityManager.createQuery(ProviderQueryEnum.getListProviderIdCodeHql.getHql())
                .getResultList();
    }

    public List<SelectVEO> getProviderIdCodeDTO(){
     return selectDTOService.getIdNameDTOAndId(getProviderIdCodeList());
    }



}
