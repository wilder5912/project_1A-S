package com.storeArticle.store.service.ProviderProductService;

import com.storeArticle.store.model.provider.ArticleProvider;
import com.storeArticle.store.service.enumPage.providerEnun.ArticleProviderQueryEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ArticleProviderService {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean addArticleProvider(ArticleProvider articleProvider){

        boolean isArticleProvider = false;
        if(isArticleProvider(articleProvider.getCodeArticleProvider())) {
            articleProvider.setDelete(false);
            entityManager.persist(articleProvider);
            isArticleProvider = true;
        }
        return isArticleProvider;
    }

    public boolean deleteArticleProvider(int articleProviderId){
        ArticleProvider articleProvider = getArticleProvider(articleProviderId);
        articleProvider.setDelete(true);
        entityManager.flush();
        return null != articleProvider;
    }

    public boolean updatedArticleProvider(ArticleProvider articleProviderNew){
        ArticleProvider articleProvider = getArticleProvider(articleProviderNew.getArticleProviderId());
        articleProvider.setCodeArticleProvider(articleProviderNew.getCodeArticleProvider());
        articleProvider.setNameArticleProvider (articleProviderNew.getNameArticleProvider());
        articleProvider.setCodeArticleProvider(articleProviderNew.getCodeArticleProvider());
        entityManager.flush();
        return null != articleProvider;
    }

    public ArticleProvider getArticleProvider(int articleProviderId){

        return entityManager.find(ArticleProvider.class, articleProviderId);
    }
    public boolean isArticleProvider(String articleProviderCode){
        List<ArticleProvider> articleProviderList = getArticleProviderList(articleProviderCode);
        if(articleProviderList.size() == 0){
            return true;
        } else{
            return false;
        }
    }

    public ArticleProvider getArticleProviderCode(String articleProviderCode){
        List<ArticleProvider> articleProviderList = getArticleProviderList(articleProviderCode);
        ArticleProvider articleProvider = new ArticleProvider();
        if(articleProviderList.size() > 0){
           articleProvider = articleProviderList.get(0);
        }
        return articleProvider;
    }


    public List<ArticleProvider> getArticleProviderList(String articleProviderCode){
        String groupProductHql =
        ArticleProviderQueryEnum.getlookForArticleProvider.getHql();
        return entityManager.createQuery(groupProductHql)
                .setParameter(1, articleProviderCode)
                .setParameter(2,false)
                .getResultList();
    }

    public List<ArticleProvider> getProviderListAll(){
        return entityManager.createQuery(ArticleProviderQueryEnum.getListArticleProviderHql.getHql())
                .getResultList();
    }

}
