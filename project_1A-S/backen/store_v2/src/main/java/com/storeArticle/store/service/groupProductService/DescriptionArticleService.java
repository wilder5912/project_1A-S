package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.ArticleRelational;
import com.storeArticle.store.model.accounts.DescriptionArticle;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.enumPage.ArticleRelationalQueryEnum;
import com.storeArticle.store.service.enumPage.DescriptionArticleQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class DescriptionArticleService implements DescriptionArticleCrup{

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ArticleDTOService articleDTOService;

    @Override
    public boolean addDescriptionArticle(DescriptionArticle descriptionArticle) {
        boolean isDescriptionArticle=false;
        entityManager.persist(descriptionArticle);
        return isDescriptionArticle;
    }

    @Override
    public boolean deleteDescriptionArticle(int descriptionArticleId) {
        return false;
    }

    @Override
    public boolean updatedDescriptionArticle(DescriptionArticle descriptionArticle) {
        return false;
    }

    @Override
    public ArticleRelational getDescriptionArticle(int descriptionArticleId) {
        return null;
    }

    @Override
    public Boolean getIsDescriptionArticle() {
        return null;
    }

    public String getDescriptionArticleId(int articleId) {
        String description;
        try {
            description = entityManager.createQuery(DescriptionArticleQueryEnum.getDescriptionArticleArticleId.getHql())
                    .setParameter(1, articleId)
                    .getSingleResult().toString();
        }catch (RuntimeException e){
            description = new String();
        }
        return description;
    }

}
