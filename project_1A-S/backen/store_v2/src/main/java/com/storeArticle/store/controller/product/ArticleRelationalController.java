package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.groupProductModel.ArticleRelational;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.groupProductService.ArticleRelationalService;
import com.storeArticle.store.service.groupProductService.ReviewArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/articleRelational")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ArticleRelationalController {

    @Autowired
    private ArticleRelationalService articleRelationalService;

    @Autowired
    private ReviewArticleService reviewArticleService;
    protected ObjectMapper mapper;

    @Autowired
    private ArticleDTOService articleDTOService;


    public ArticleRelationalController(){
        mapper = new ObjectMapper();
    }


    @GetMapping(value = "/getArticleRelational/{businessId}/{articleId}")
    public List<ArticleVEO> getBestArticleReview(@PathVariable("businessId") int businessId,@PathVariable("articleId") int articleId){
        return articleRelationalService.getArticleRelational(businessId,articleId);
    }

    @GetMapping(value = "/getArticleIdRelational/{businessId}/{articleId}")
    public List<Object> getArticleIdRelational(@PathVariable("businessId") int businessId,@PathVariable("articleId") int articleId){
        return articleRelationalService.getArticleId(businessId,articleId);
    }

    @PostMapping(value="/addArticleRelation")
    public boolean addArticleRelation(@RequestBody List<ArticleRelational> articleRelationalData )throws IOException{
        this.mapper = new ObjectMapper();
        return articleRelationalService.addArticleRelational(articleRelationalData);
    }




}
