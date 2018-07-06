package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.groupProductModel.Article;
import com.storeArticle.store.model.groupProductModel.ArticleDetail;
import com.storeArticle.store.model.groupProductModel.SubSection;
import com.storeArticle.store.service.accounts.UserService;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.ArticleDetailQueryEnum;
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
public class ArticleDetailService implements ArticleDetailCrup {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SelectDTOService selectDTOService;
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleDTOService articleDTOService;


    @Override
    public boolean addArticleDetail(ArticleDetail articleDetail) {
        articleDetail.setDelete(false);
        entityManager.persist(articleDetail);
        return true;
    }

    @Override
    public boolean deleteArticleDetail(int articleDetailId) {
        return false;
    }

    @Override
    public boolean updatedArticleDetail(ArticleDetail articleDetail) {
        return false;
    }

    @Override
    public ArticleDetail getArticleDetail(int articleDetailId) {

        return entityManager.find(ArticleDetail.class, articleDetailId);
    }

    @Override
    public Boolean getIsArticleDetail() {
        return null;
    }

    private Path rootLocation = Paths.get("../webapps/store-0.0.1-SNAPSHOT/upload-dir/article");


    public List<ArticleDetail> getArticleDetailList(){
        return entityManager.createQuery(ArticleDetailQueryEnum.getArticleDetailList.getHql()).getResultList();
    }

    public ArticleDetail addArticleAndSubSection(MultipartFile fileArticle, Article article, SubSection subSection){
        ArticleDetail resArticleDetail = new ArticleDetail();
        Article resArticle = new Article();
        try {
            String renameImage = userService.randomString();

            if(articleService.verificateArticleCode(article)){
                article.setImageMainAr(renameImage+fileArticle.getOriginalFilename());
                articleService.addArticle(article);
                resArticle = articleService.getArticle(article).get(0);
                resArticleDetail.setSubSectionId(subSection);
                resArticleDetail.setArticleId(resArticle);
                if(verificarDetatailArticle(resArticleDetail)){
                    addArticleDetail(resArticleDetail);
                    resArticleDetail = getArticleDetaile(resArticleDetail).get(0);
                }
            }
            Files.copy(fileArticle.getInputStream(), this.rootLocation.resolve(renameImage+fileArticle.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }


        return resArticleDetail;
    }


    public Article editArticleData(MultipartFile fileArticle, Article article){
        Article resArticle = new Article();
        try {
            String renameImage = userService.randomString();

                resArticle = articleService.getArticle(article.getArticleId());
                resArticle.setNameAr(article.getNameAr());
                resArticle.setCodigoAr(article.getCodigoAr());
                resArticle.setPrecyAr(article.getPrecyAr());
                resArticle.setDetailAr(article.getDetailAr());
            if(null != fileArticle) {
                resArticle.setImageMainAr(renameImage + fileArticle.getOriginalFilename());
                Files.copy(fileArticle.getInputStream(), this.rootLocation.resolve(renameImage + fileArticle.getOriginalFilename()));
            }
            entityManager.flush();
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }

        return resArticle;
    }


    public boolean verificarDetatailArticle(ArticleDetail articleDetail){
        boolean res=false;
        if(getArticleDetaile(articleDetail).size()==0){
            res=true;
        }
        return res;
    }

    public List<ArticleDetail> getArticleDetaile(ArticleDetail articleDetail){
        return entityManager.createQuery(ArticleDetailQueryEnum.getArticleDetailSubSectionArticleIdHql.getHql())
                .setParameter(1,articleDetail.getSubSectionId().getSubSectionId())
                .setParameter(2,articleDetail.getArticleId().getArticleId())
                .setParameter(3, false)
                .getResultList();
    }
    public List<Object[]> getArticleDetaileListArticleId(int articleDetail){
        return  entityManager.createQuery(ArticleDetailQueryEnum.getArticleDetailIdSubSectionHql.getHql())
                .setParameter(1,articleDetail)
                 .setParameter(2, false)
                .getResultList();
    }
    public List<Object> fiendArticleBussine(String nameArRrCode, int bussineId ){
        return entityManager.createQuery(ArticleDetailQueryEnum.getFiendArticleOfBussineHql.getHql())
                .setParameter(1, "%"+nameArRrCode+"%")
                .setParameter(2, "%"+nameArRrCode+"%")
                .setParameter(3, bussineId)
                .setParameter(4, false)
                .setParameter(5, false)
                .getResultList();
    }
    public List<Object[]> getArticledetailBussineId(int bussineId ){
        return entityManager.createQuery(ArticleDetailQueryEnum.getArticledetailBussineHql.getHql())
                .setParameter(1, bussineId)
                .setParameter(2, false)
                .setParameter(3, false)
                .getResultList();
    }
    public List<Object> getArticleBussineId(){
        return entityManager.createQuery(ArticleDetailQueryEnum.getArticleBussineHql.getHql())
                .setParameter(1, false)
                .setParameter(2, false)
                .getResultList();
    }

    public List<ArticleVEO> getListDTO(String nameArRrCode, int bussineId){
         return this.articleDTOService.getArticleFind(fiendArticleBussine(nameArRrCode,bussineId));
    }
    public List<SelectVEO> getSelectArticleList(int bussineId){
        return selectDTOService.getIdNameDTOAndId(getArticledetailBussineId(bussineId));
    }


    public List<SelectVEO> getSubSelectArticleId(int bussineId){
        return selectDTOService.getIdNameDTOAndId(getArticledetailBussineId(bussineId));
    }
     public List<Object> getSubSelectListArticleId(int subSectionId){
            return entityManager.createQuery(ArticleDetailQueryEnum.getSubSectionListArticleIdHql.getHql())
                 .setParameter(1, subSectionId)
                 .setParameter(2, false)
                 .getResultList();
    }

    public boolean addArticleRelational(List<ArticleDetail> articleDetail){
        try{
            updateArticleId(articleDetail.get(0));
            articleDetail.forEach(selectDatas->{
                isDeleteArticleRelation(selectDatas);
            });
        }catch(Exception e){
            return false;
        }finally{

        }
        return true;
    }

    public void updateArticleId(ArticleDetail articleDetail) {
        entityManager.createQuery(ArticleDetailQueryEnum.updateStateArticleIdDetailHql.getHql())
                .setParameter(1, true)
                .setParameter(2, articleDetail.getSubSectionId().getSubSectionId())
                .executeUpdate();
    }



    public boolean isDeleteArticleRelation(ArticleDetail articleDetailData){
        boolean isCorrecInformation = false;
        Integer ArticleRelationalId =  getArticleRelationId(articleDetailData);
        ArticleDetail articleDetail;
        if(null != ArticleRelationalId){
            articleDetail = getArticleDetail(ArticleRelationalId);
            articleDetail.setDelete(false);
            entityManager.flush();
            isCorrecInformation = true;
        }else{

            isCorrecInformation = addArticleDetail(articleDetailData);

        }
        return isCorrecInformation;
    }

    public Integer getArticleRelationId(ArticleDetail articleDetail) {

        try {
            return (Integer)entityManager.createQuery(ArticleDetailQueryEnum.getSubSectionArticleIdHql.getHql())
                    .setParameter(1, articleDetail.getSubSectionId().getSubSectionId())
                    .setParameter(2, articleDetail.getArticleId().getArticleId())
                    .getSingleResult();

        }catch (RuntimeException e){
            return null;
        }
    }

}
