package com.storeArticle.store.service.dto;

import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.service.groupProductService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleDTOService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private DescriptionArticleService descriptionArticleService;
    @Autowired
    private ImageArticleService imageArticleService;
    @Autowired
    private ImageArticleDTOService imageArticleDTOService;
    @Autowired

    private CommentService commentService;
    @Autowired

    private CommentDTOService commentDTOService;
    @Autowired

    private InformationService informationService;
    @Autowired
    private InformationDTOService informationDTOService;


    public List<ArticleVEO> getArticleDTO(List<Object[]> articleList){
        List<ArticleVEO> articleDTOList = new ArrayList<ArticleVEO>();
       try{
           articleList.forEach(selectDatas->{
                ArticleVEO articleVEOInfo = new ArticleVEO();
                Article article=  articleService.getArticle(Integer.parseInt(selectDatas[0].toString()));
                articleVEOInfo.setArticleId(article.getArticleId());
                articleVEOInfo.setNameAr(article.getNameAr());
                articleVEOInfo.setCodigoAr(article.getCodigoAr());
                articleVEOInfo.setPrecyAr(article.getPrecyAr());
                articleVEOInfo.setImageMainAr(article.getImageMainAr());
                articleVEOInfo.setArticleId(article.getArticleId());
                articleVEOInfo.setRating(commentService.getRating(article.getArticleId()));
                articleVEOInfo.setImageArticleVEOS(imageArticleDTOService.getImageArticleDTO(imageArticleService.getImageArticleListObject(articleVEOInfo.getArticleId())));
                articleDTOList.add(articleVEOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return articleDTOList;
    }

    public ArticleVEO getArticleDetailDTO(int IdArticle){
        ArticleVEO articleVEOInfo = new ArticleVEO();
        Article article=  articleService.getArticle(IdArticle);
        articleVEOInfo.setArticleId(article.getArticleId());
        articleVEOInfo.setNameAr(article.getNameAr());
        articleVEOInfo.setCodigoAr(article.getCodigoAr());
        articleVEOInfo.setPrecyAr(article.getPrecyAr());
        articleVEOInfo.setImageMainAr(article.getImageMainAr());
        articleVEOInfo.setArticleId(article.getArticleId());
        articleVEOInfo.setDetailAr(article.getDetailAr());
        articleVEOInfo.setImageArticleVEOS(imageArticleDTOService.getImageArticleDTO(imageArticleService.getImageArticleListObject(articleVEOInfo.getArticleId())));
        articleVEOInfo.setRating(commentService.getRating(IdArticle));
        articleVEOInfo.setNameDescriptionarticle(descriptionArticleService.getDescriptionArticleId(IdArticle));
        articleVEOInfo.setInformationVEO(informationDTOService.getInformationDTO(informationService.getDescriptionArticleId(IdArticle)));
        articleVEOInfo.setCommentVEOS(commentDTOService.getCommentDTO(commentService.getCommentArticle(IdArticle)));
        return articleVEOInfo;
    }

    public List<ArticleVEO> getArticleDTOBest(List<Object[]> articleList){
        List<ArticleVEO> articleDTOList = new ArrayList<ArticleVEO>();
        try{
            articleList.forEach(selectDatas->{
                ArticleVEO articleVEOInfo = new ArticleVEO();
                Article article=  articleService.getArticle(Integer.parseInt(selectDatas[0].toString()));
                articleVEOInfo.setArticleId(article.getArticleId());
                articleVEOInfo.setNameAr(article.getNameAr());
                articleVEOInfo.setCodigoAr(article.getCodigoAr());
                articleVEOInfo.setPrecyAr(article.getPrecyAr());
                articleVEOInfo.setImageMainAr(article.getImageMainAr());
                articleVEOInfo.setArticleId(article.getArticleId());
                articleVEOInfo.setRating(commentService.getRating(article.getArticleId()));
                //articleVEOInfo.setImageArticleVEOS(imageArticleDTOService.getImageArticleDTO(imageArticleService.getImageArticleListObject(articleVEOInfo.getArticleId())));
                articleDTOList.add(articleVEOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return articleDTOList;
    }

    public List<ArticleVEO> getArticleFind(List<Object> articleList){
            List<ArticleVEO> articleDTOList = new ArrayList<ArticleVEO>();
            try{
                articleList.forEach(selectDatas->{
                    Article articleData= (Article)selectDatas;
                    ArticleVEO articleVEOInfo = new ArticleVEO();
                    articleVEOInfo.setArticleId(articleData.getArticleId());
                    articleVEOInfo.setNameAr(articleData.getNameAr());
                    articleVEOInfo.setCodigoAr(articleData.getCodigoAr());
                    articleVEOInfo.setPrecyAr(articleData.getPrecyAr());
                    articleVEOInfo.setImageMainAr(articleData.getImageMainAr());
                    articleVEOInfo.setArticleId(articleData.getArticleId());
                    articleVEOInfo.setRating(commentService.getRating(articleData.getArticleId()));
                    articleDTOList.add(articleVEOInfo);
                });
            }catch(Exception e){
            }finally{
            }
            return articleDTOList;
    }
    public List<ArticleVEO> getArticleBox(List<Object[]> articleList){
        List<ArticleVEO> articleDTOList = new ArrayList<ArticleVEO>();
        try{
            articleList.forEach(selectDatas->{
                if(Integer.parseInt(selectDatas[0] + "") > 0) {
                    Article articleData = (Article) selectDatas[1];
                    ArticleVEO articleVEOInfo = new ArticleVEO();
                    articleVEOInfo.setArticleId(articleData.getArticleId());
                    articleVEOInfo.setNumProduct(Integer.parseInt(selectDatas[0] + ""));
                    articleVEOInfo.setNameAr(articleData.getNameAr());
                    articleVEOInfo.setCodigoAr(articleData.getCodigoAr());
                    articleVEOInfo.setPrecyAr(articleData.getPrecyAr());
                    articleVEOInfo.setImageMainAr(articleData.getImageMainAr());
                    articleVEOInfo.setArticleId(articleData.getArticleId());
                    articleVEOInfo.setRating(commentService.getRating(articleData.getArticleId()));
                    articleDTOList.add(articleVEOInfo);
                }
            });
        }catch(Exception e){
        }finally{
        }
        return articleDTOList;
    }

}
