package com.storeArticle.store.service.groupProductService;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.Banner;
import com.storeArticle.store.model.accounts.ReviewArticle;
import com.storeArticle.store.service.accounts.UserService;
import com.storeArticle.store.service.dto.BussineDTOService;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.enumPage.BannerQueryEnum;
import com.storeArticle.store.service.enumPage.ReviewArticleQueryEnum;
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
public class BannerService implements BannerCrup{
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserService userService;
    private Path rootLocation = Paths.get("../webapps/store-0.0.1-SNAPSHOT/upload-dir/article");


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


}
