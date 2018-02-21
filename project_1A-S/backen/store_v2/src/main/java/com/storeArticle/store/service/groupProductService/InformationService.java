package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.ArticleRelational;
import com.storeArticle.store.model.accounts.DescriptionArticle;
import com.storeArticle.store.model.accounts.Information;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.enumPage.DescriptionArticleQueryEnum;
import com.storeArticle.store.service.enumPage.InformationQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ArticleDTOService articleDTOService;

    @Override
    public boolean addInformation(Information information) {
        boolean isInformation=false;
        entityManager.persist(information);
        return isInformation;
    }

    @Override
    public boolean deleteInformation(int informationId) {
        return false;
    }

    @Override
    public boolean updatedInformation(Information information) {
        return false;
    }

    @Override
    public Information getInformation(int InformationId) {
        return null;
    }

    @Override
    public Boolean getIsInformation() {
        return null;
    }

    public List<Object[]> getDescriptionArticleId(int articleId) {
        return entityManager.createQuery(InformationQueryEnum.getInformationArticleId.getHql())
                .setParameter(1, articleId)
                .getResultList();
    }


}
