package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ArticleRelational;
import com.storeArticle.store.model.accounts.ReviewArticle;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.dto.BussineDTOService;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.enumPage.ArticleRelationalQueryEnum;
import com.storeArticle.store.service.enumPage.ReviewArticleQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class ArticleRelationalService implements ArticleRelationalCrup{

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ArticleDTOService articleDTOService;

    @Override
    public boolean addArticleRelational(ArticleRelational articleRelational) {
        boolean isArticleRelational=false;
        entityManager.persist(articleRelational);
        return isArticleRelational;
    }

    @Override
    public boolean deleteArticleRelational(int articleRelationalId) {
        return false;
    }

    @Override
    public boolean updatedArticleRelational(ArticleRelational articleRelational) {
        return false;
    }

    @Override
    public ArticleRelational getArticleRelational(int articleRelationalId) {
        return null;
    }

    @Override
    public Boolean getIsArticleRelational() {
        return null;
    }

    public List<Object[]> getArticleRelationalArticleId(int bussineId ,int articleId) {
        return entityManager.createQuery(ArticleRelationalQueryEnum.getArticleRelationalHqlArticleId.getHql())
                .setParameter(1, bussineId)
                .setParameter(2, articleId)
                .setMaxResults(10)
                .getResultList();
    }

    public List<ArticleVEO> getArticleRelational(int bussineId, int articleId){
        return articleDTOService.getArticleDTOBest(getArticleRelationalArticleId(bussineId,articleId));
    }







}
