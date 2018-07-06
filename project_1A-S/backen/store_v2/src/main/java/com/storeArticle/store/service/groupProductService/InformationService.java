package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.Information;
import com.storeArticle.store.service.enumPage.InformationQueryEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class InformationService implements InformationCrup{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addInformation(Information information) {
        boolean isInformation=false;
        entityManager.persist(information);
        return isInformation;
    }

    @Override
    public boolean deleteInformation(int informationId) {
        boolean isDeleteInformation = false;
        Information information =  getInformation(informationId);
        if(null != information) {
            isDeleteInformation = true;
            information.setDelete(true);
            entityManager.flush();
        }
        return isDeleteInformation;

    }

    @Override
    public boolean updatedInformation(Information information) {
        boolean isEditInformation = false;
        Information information1Data = getInformation(information.getInformationId());
        if(null != information) {
            isEditInformation = true;
            information1Data.setNameInformation(information.getNameInformation());
            information1Data.setDetailInformation(information.getDetailInformation());
            entityManager.flush();
        }
        return isEditInformation;
    }

    @Override
    public Information getInformation(int InformationId) {

        return entityManager.find(Information.class, InformationId);
    }

    @Override
    public Boolean getIsInformation() {
        return null;
    }

    public List<Object[]> getDescriptionArticleId(int articleId) {
        return entityManager.createQuery(InformationQueryEnum.getInformationArticleId.getHql())
                .setParameter(1, articleId)
                .setParameter(2, false)
                .getResultList();
    }


}
