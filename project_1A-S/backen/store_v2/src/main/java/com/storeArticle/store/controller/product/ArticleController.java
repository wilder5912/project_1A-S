package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ReviewArticle;
import com.storeArticle.store.model.accounts.SubSection;
import com.storeArticle.store.service.dto.ArticleDTOService;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.dto.SubSectionVEO;
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
@RequestMapping(value="/article")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ReviewArticleService reviewArticleService;
    protected ObjectMapper mapper;

    @Autowired
    private ArticleDTOService articleDTOService;


    public ArticleController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value ="/updateImageArticle")
    public ResponseEntity<String> editImageUserOne(@RequestParam("fileArticle") MultipartFile file, @RequestParam("articleId") int articleId) {
        String message = "";
        try {
            this.mapper = new ObjectMapper();
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @PostMapping(value="/getSubSectionArticleListAll")
    public SubSectionVEO getSubSectionArticleListAll(@RequestBody String subSection)throws  IOException {
        this.mapper = new ObjectMapper();
        SubSection subSectionData = this.mapper.readValue(subSection, SubSection.class);
        return articleService.getArticleSubArticle(subSectionData);
    }

    @PostMapping(value="/getArticleDataDetail")
    public ArticleVEO getArticleDataDetail(@RequestBody String article)throws IOException {
        this.mapper = new ObjectMapper();
        Article articleData = this.mapper.readValue(article, Article.class);
        return articleDTOService.getArticleDetailDTO(articleData.getArticleId());
    }

    @GetMapping(value = "/getBestArticleReview/{bussineId}")
    public List<ArticleVEO> getBestArticleReview(@PathVariable("bussineId") int bussineId){
        return reviewArticleService.getArticleBest(bussineId);
    }

    @GetMapping(value = "/getArticleId/{articleId}")
    public Article getArticleId(@PathVariable("articleId") int articleId){
        return articleService.getArticle(articleId);
    }

    @PostMapping(value = "/addReviewArticle")
    public boolean addReviewArticle(@RequestBody String reviewArticle)throws IOException{
        this.mapper = new ObjectMapper();
        ReviewArticle reviewArticle1Data = this.mapper.readValue(reviewArticle, ReviewArticle.class);
        return reviewArticleService.addReviewArticle(reviewArticle1Data);
    }





}
