package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ReviewArticle;
import com.storeArticle.store.model.accounts.SubSection;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.dto.SubSectionVEO;
import com.storeArticle.store.service.groupProductService.ArticleRelationalService;
import com.storeArticle.store.service.groupProductService.ArticleService;
import com.storeArticle.store.service.groupProductService.ReviewArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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




}
