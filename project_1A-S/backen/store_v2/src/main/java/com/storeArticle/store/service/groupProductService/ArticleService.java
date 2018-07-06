package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.Article;
import com.storeArticle.store.model.groupProductModel.SubSection;
import com.storeArticle.store.service.accounts.UserService;
import com.storeArticle.store.service.dto.*;
import com.storeArticle.store.service.enumPage.ArticleQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Transactional
@Service
public class ArticleService implements ArticleCrup {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserService userService;
    @Autowired
    private SubSectionDTOService subSectionDTOService;
    @Autowired
    private SelectDTOService selectDTOService;

    private Path rootLocation = Paths.get("../webapps/store-0.0.1-SNAPSHOT/upload-dir/userImage");


    @Override
    public boolean addArticle(Article article) {
        boolean isRegisterGroupProduct=false;
        entityManager.persist(article);
        return isRegisterGroupProduct;

    }

    @Override
    public boolean deleteArticle(int articleId) {
        return false;
    }

    @Override
    public boolean updatedArticle(Article article) {
        return false;
    }

    @Override
    public Article getArticle(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @Override
    public Boolean getIsArticle() {
        return null;
    }


    public boolean verificateArticleCode(Article article){
        boolean res = false;
        if(getArticle(article).size()==0){
            res= true;
        }
        return res;
    }
    public List<Article> getArticle(Article article){
        return entityManager.createQuery(ArticleQueryEnum.getArticle.getHql())
                .setParameter(1,article.getCodigoAr())
                .setParameter(2, false)
                .getResultList();

    }


    public Article CreateImageAndArticle(MultipartFile fileArticle, Article article) {
        try {
            String renameImage= userService.randomString();
            Files.copy(fileArticle.getInputStream(), this.rootLocation.resolve(renameImage+fileArticle.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        return article;
    }


    public SubSectionVEO getArticleSubArticle(SubSection subSection){
        return subSectionDTOService.getSubSectionArticleDTO(subSection);
    }

    public List<Object[]> getListArticle(){
        return entityManager.createQuery(ArticleQueryEnum.getArticleList.getHql())
                .setParameter(1, false)
                .getResultList();
    }

    public List<SelectVEO> getSelectArticleList(){
        return selectDTOService.getIdNameDTOAndIdCode(getListArticle());
    }

}
