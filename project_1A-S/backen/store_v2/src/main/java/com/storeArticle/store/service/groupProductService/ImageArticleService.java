package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ImageArticle;
import com.storeArticle.store.model.accounts.SubSection;
import com.storeArticle.store.service.accounts.UserService;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.enumPage.ImageArticleQueryEnum;
import com.storeArticle.store.service.enumPage.SectionQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.core.io.Resource;

@Transactional
@Service
public class ImageArticleService implements ImageArticleCrup {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserService userService;
    private Path rootLocation = Paths.get("../webapps/store-0.0.1-SNAPSHOT/upload-dir/article");

    @Override
    public boolean addImageArticle(ImageArticle imageArticle) {
        entityManager.persist(imageArticle);
        return true;
    }

    @Override
    public boolean deleteImageArticle(int imageArticle) {
        boolean isDeleteImage = false;
        ImageArticle imageArticleData =  getImageArticle(imageArticle);
        if(null != imageArticleData) {
            isDeleteImage = true;
            imageArticleData.setDelete(true);
            entityManager.flush();
        }
        return isDeleteImage;
    }

    @Override
    public boolean updatedImageArticle(ImageArticle imageArticle) {
        return false;
    }

    @Override
    public ImageArticle getImageArticle(int imageArticleId) {
        return entityManager.find(ImageArticle.class, imageArticleId);
    }

    @Override
    public Boolean getIsImageArticle() {
        return null;
    }

    public List<ImageArticle> getSubSectionList(){
        return entityManager.createQuery(ImageArticleQueryEnum.getImageArticleList.getHql()).getResultList();
    }
    public List<ImageArticle> getImageArticleList(int articleId){
        return entityManager.createQuery(ImageArticleQueryEnum.getImageArticleIdList.getHql())
                .setParameter(1, articleId)
                .setParameter(2,false)
                .getResultList();
    }
    public List<Object[]> getImageArticleListObject(int articleId){
        return entityManager.createQuery(ImageArticleQueryEnum.getImageArticleIdListObject.getHql())
                .setParameter(1, articleId)
                .setParameter(2,false)
                .getResultList();
    }

    public void addArticleAndSubSection(MultipartFile fileArticle, int imageArticleid){
        try {
            String renameImage= userService.randomString();
            ImageArticle resImageArticle = new ImageArticle();
            Article article = new Article();
            article.setArticleId(imageArticleid);
            resImageArticle.setArticleId(article);
            resImageArticle.setNombreImageActicle(renameImage+fileArticle.getOriginalFilename());
            resImageArticle.setDelete(false);
            boolean EE=  addImageArticle(resImageArticle);
            Files.copy(fileArticle.getInputStream(), this.rootLocation.resolve(renameImage+fileArticle.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }



}
