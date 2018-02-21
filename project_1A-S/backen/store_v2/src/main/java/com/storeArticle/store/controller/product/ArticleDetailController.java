package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ArticleDetail;
import com.storeArticle.store.model.accounts.ImageArticle;
import com.storeArticle.store.model.accounts.SubSection;
import com.storeArticle.store.service.groupProductService.ArticleDetailService;
import com.storeArticle.store.service.groupProductService.ImageArticleService;
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
@RequestMapping(value="/articleDetail")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ArticleDetailController {

    @Autowired
    private ArticleDetailService articleDetailService;

    protected ObjectMapper mapper;


    public ArticleDetailController(){
        mapper = new ObjectMapper();
    }

    @GetMapping(value="/getArticleDetail")
    public List<ArticleDetail> getSection() throws JsonParseException, JsonMappingException, IOException {
        return articleDetailService.getArticleDetailList();
    }

    @PostMapping(value ="/updateArticleDetailOne")
    public ResponseEntity<Integer> updateArticleDetailOne(@RequestParam("fileArticle") MultipartFile fileArticle, @RequestParam("articleData") String articleData, @RequestParam("subSectionData") String subSectionData ) throws JsonParseException, JsonMappingException, IOException{
        String message = "";
        ArticleDetail resArticleDetail=null;
        this.mapper = new ObjectMapper();
        Article article = this.mapper.readValue(articleData, Article.class);
        SubSection subSection = this.mapper.readValue(subSectionData, SubSection.class);
        resArticleDetail = articleDetailService.addArticleAndSubSection(fileArticle,article,subSection);
        return ResponseEntity.status(HttpStatus.OK).body(resArticleDetail.getArticleId().getArticleId());
    }


  /*  @PostMapping(value ="/getArticleDetailOne")
    public ResponseEntity<Integer> getArticleList(@RequestParam("fileArticle") MultipartFile fileArticle, @RequestParam("articleData") String articleData, @RequestParam("subSectionData") String subSectionData ) throws JsonParseException, JsonMappingException, IOException{
        String message = "";
        ArticleDetail resArticleDetail=null;
        this.mapper = new ObjectMapper();
        Article article = this.mapper.readValue(articleData, Article.class);
        SubSection subSection = this.mapper.readValue(subSectionData, SubSection.class);
        resArticleDetail = articleDetailService.addArticleAndSubSection(fileArticle,article,subSection);
        return ResponseEntity.status(HttpStatus.OK).body(resArticleDetail.getArticleId().getArticleId());
    }
    */

}
