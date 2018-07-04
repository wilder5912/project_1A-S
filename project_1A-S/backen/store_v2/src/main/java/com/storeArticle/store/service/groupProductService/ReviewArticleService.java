package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ReviewArticle;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.enumPage.ReviewArticleQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class ReviewArticleService implements ReviewArticleCrup{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ArticleDTOService articleDTOService;

    @Override
    public boolean addReviewArticle(ReviewArticle reviewArticle) {
        boolean isReviewArticle=false;
        entityManager.persist(reviewArticle);
        return isReviewArticle;
    }

    @Override
    public boolean deleteReviewArticle(int reviewArticleId) {
        return false;
    }

    @Override
    public boolean updatedReviewArticle(ReviewArticle reviewArticle) {
        return false;
    }

    @Override
    public Article getReviewArticle(int reviewArticleId) {
        return null;
    }

    @Override
    public Boolean getIsReviewArticle() {
        return null;
    }

    public List<Object[]> getReviewArticleNum(int bussineId) {
        return entityManager.createQuery(ReviewArticleQueryEnum.getNumReviewArticleHql.getHql())
                .setParameter(1,bussineId)
                .setMaxResults(10)
                .getResultList();
    }

    public List<ArticleVEO> getArticleBest(int bussineId){
        return articleDTOService.getArticleDTOBest(getReviewArticleNum(bussineId));
    }









}
