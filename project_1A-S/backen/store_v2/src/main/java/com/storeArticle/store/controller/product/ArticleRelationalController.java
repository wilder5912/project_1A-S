package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.ArticleRelational;
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


    @GetMapping(value = "/getArticleRelational/{bussineId}/{articleId}")
    public List<ArticleVEO> getBestArticleReview(@PathVariable("bussineId") int bussineId,@PathVariable("articleId") int articleId){
        return articleRelationalService.getArticleRelational(bussineId,articleId);
    }

    @GetMapping(value = "/getArticleIdRelational/{bussineId}/{articleId}")
    public List<Object> getArticleIdRelational(@PathVariable("bussineId") int bussineId,@PathVariable("articleId") int articleId){
        return articleRelationalService.getArticleId(bussineId,articleId);
    }

    @PostMapping(value="/addArticleRelation")
    public boolean addArticleRelation(@RequestBody List<ArticleRelational> articleRelationalData )throws IOException{
        this.mapper = new ObjectMapper();
        return articleRelationalService.addArticleRelational(articleRelationalData);
    }




}
