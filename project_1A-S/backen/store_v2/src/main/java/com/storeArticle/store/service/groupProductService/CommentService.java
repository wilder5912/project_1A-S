package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Banner;
import com.storeArticle.store.model.accounts.Comment;
import com.storeArticle.store.service.accounts.UserService;
import com.storeArticle.store.service.dto.CommentDTOService;
import com.storeArticle.store.service.dto.CommentVEO;
import com.storeArticle.store.service.enumPage.BannerQueryEnum;
import com.storeArticle.store.service.enumPage.CommentQueryEnum;
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
public class CommentService implements CommentCrup{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CommentDTOService commentDTOService;

    @Autowired
    private UserService userService;

    @Override
    public boolean addArticle(Comment comment) {
        boolean isDescriptionArticle=false;
        entityManager.persist(comment);
        return isDescriptionArticle;
    }

    @Override
    public boolean deleteComment(int commentId) {
        return false;
    }

    @Override
    public boolean updatedComment(Comment comment) {
        return false;
    }

    @Override
    public Comment getComment(int commentId) {
        return null;
    }

    @Override
    public Boolean getIsComment() {
        return null;
    }

    public int getRating(int articleId){
       int promAVG;
       try {
        double promAVGArticle = (Double)entityManager.createQuery(CommentQueryEnum.getRantingHql.getHql())
                .setParameter(1,articleId)
                .setParameter(2,false)
                .getSingleResult();
          promAVG= (int)(Math.round(promAVGArticle));
    }catch (RuntimeException e){
           promAVG = 0;
    }

        return promAVG;
    }

    public List<Object[]> getCommentArticle(int articleId){
          return entityManager.createQuery(CommentQueryEnum.getCommentHql.getHql())
                    .setParameter(1,articleId)
                    .setParameter(2,false)
                    .getResultList();
    }

    public List<CommentVEO> getCommentDTOS(int articleId){
        return commentDTOService.getCommentDTO(getCommentArticle(articleId));
    }

    public List<CommentVEO> addAndGetComment(Comment comment){
        if(addArticle(comment)){
            return getCommentDTOS(comment.getArticleId().getArticleId());
        }else{
            return getCommentDTOS(comment.getArticleId().getArticleId());
        }
    }



/*

    @Override
    public boolean addBanner(Banner banner) {
        boolean isBanner=false;
        entityManager.persist(banner);
        return isBanner;
    }

    @Override
    public boolean deleteBanner(int bannerId) {
        return false;
    }

    @Override
    public boolean updatedBanner(Banner banner) {
        return false;
    }

    @Override
    public Banner getBanner(int bannerId) {
        return null;
    }

    @Override
    public Boolean getIsBanner() {
        return null;
    }

    public List<Banner> getBannerList() {
        return entityManager.createQuery(BannerQueryEnum.getListBannerHql.getHql()).getResultList();
    }
    public void addbannerImage(MultipartFile fileBanner, Banner banner){
        try {
            Banner bannerNew = new Banner();
            String renameImage= userService.randomString();
            bannerNew.setNameImageBanner(renameImage+fileBanner.getOriginalFilename());
            bannerNew.setDetallBanner(banner.getDetallBanner());
            bannerNew.setStartBanner(banner.getStartBanner());
            bannerNew.setEndBanner(banner.getEndBanner());
            bannerNew.setTittleBanner(banner.getTittleBanner());
            bannerNew.setUrlBanner(banner.getUrlBanner());

            bannerNew.setDelete(false);
            addBanner(bannerNew);
            Files.copy(fileBanner.getInputStream(), this.rootLocation.resolve(renameImage+fileBanner.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }
*/


}
