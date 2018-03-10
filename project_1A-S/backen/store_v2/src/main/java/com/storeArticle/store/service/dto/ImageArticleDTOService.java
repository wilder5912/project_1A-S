package com.storeArticle.store.service.dto;

import com.storeArticle.store.service.groupProductService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageArticleDTOService {

    @Autowired
    private ArticleService articleService;

    public List<ImageArticleVEO> getImageArticleDTO(List<Object[]> imageArticleList){
        List<ImageArticleVEO> imageArticleDTOList = new ArrayList<ImageArticleVEO>();
       try{
           imageArticleList.forEach(SelectData->{
               ImageArticleVEO imageArticleVEOInfo = new ImageArticleVEO();
                imageArticleVEOInfo.setImageArticleId(Integer.parseInt(SelectData[0].toString()));
                imageArticleVEOInfo.setNombreImageActicle(SelectData[1].toString());
                imageArticleDTOList.add(imageArticleVEOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return imageArticleDTOList;
    }

}
