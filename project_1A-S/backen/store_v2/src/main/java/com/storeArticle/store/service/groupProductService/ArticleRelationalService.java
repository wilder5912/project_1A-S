package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.ArticleRelational;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.enumPage.ArticleRelationalQueryEnum;
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
        return entityManager.find(ArticleRelational.class, articleRelationalId);
    }

    @Override
    public Boolean getIsArticleRelational() {
        return null;
    }

    public List<Object[]> getArticleRelationalArticleId(int bussineId ,int articleId) {
        return entityManager.createQuery(ArticleRelationalQueryEnum.getArticleRelationalHqlArticleId.getHql())
                .setParameter(1, bussineId)
                .setParameter(2, articleId)
                .setParameter(3, false)
                .setMaxResults(10)
                .getResultList();
    }

    public List<Object> getArticleId(int bussineId ,int articleId) {
        return entityManager.createQuery(ArticleRelationalQueryEnum.getArticleIdRelationalHql.getHql())
                .setParameter(1, bussineId)
                .setParameter(2, articleId)
                .setParameter(3, false)
                .getResultList();
    }

    public void updateArticleId(ArticleRelational articleRelational) {
         entityManager.createQuery(ArticleRelationalQueryEnum.updateStateArticleIdRelationalHql.getHql())
                .setParameter(1, true)
                .setParameter(2, articleRelational.getBussineId().getBussineId())
                .setParameter(3, articleRelational.getArticleId().getArticleId())
                .executeUpdate();
    }


    public Integer getArticleRelationId(ArticleRelational articleRelational) {

        try {
            return (Integer)entityManager.createQuery(ArticleRelationalQueryEnum.isArticleIdRelationalHql.getHql())
                    .setParameter(1, articleRelational.getBussineId().getBussineId())
                    .setParameter(2, articleRelational.getArticleId().getArticleId())
                    .setParameter(3, articleRelational.getArtArticleId().getArticleId())
                    .getSingleResult();

        }catch (RuntimeException e){
            return null;
        }
    }

    public List<ArticleVEO> getArticleRelational(int bussineId, int articleId){
        return articleDTOService.getArticleDTOBest(getArticleRelationalArticleId(bussineId,articleId));
    }


    public boolean addArticleRelational(List<ArticleRelational> articleRelational){

        try{
            updateArticleId(articleRelational.get(0));
            articleRelational.forEach(selectDatas->{
                addArticleRelational(selectDatas);
            });
        }catch(Exception e){
            return false;
        }finally{

        }
        return true;
    }





    public boolean isDeleteArticleRelation(ArticleRelational articleRelational){
        boolean isCorrecInformation = false;
        Integer ArticleRelationalId =  getArticleRelationId(articleRelational);
        ArticleRelational articleRelational1;
        if(null != ArticleRelationalId){
            articleRelational1 = getArticleRelational(ArticleRelationalId);
            articleRelational1.setDelete(false);
            entityManager.flush();
            isCorrecInformation = true;
        }else{

            isCorrecInformation = addArticleRelational(articleRelational);

        }
        return isCorrecInformation;
    }




}
