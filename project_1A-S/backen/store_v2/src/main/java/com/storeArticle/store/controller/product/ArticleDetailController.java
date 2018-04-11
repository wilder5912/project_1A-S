package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Article;
import com.storeArticle.store.model.accounts.ArticleDetail;
import com.storeArticle.store.model.accounts.SubSection;
import com.storeArticle.store.service.dto.ArticleVEO;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.groupProductService.ArticleDetailService;
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
    public List<ArticleDetail> getSection() throws IOException {
        return articleDetailService.getArticleDetailList();
    }

    @GetMapping(value="/getFindArticleBussineId/{nameArRrCode}/{bussineId}")
    public List<ArticleVEO> getFindArticleBussineId(@PathVariable("nameArRrCode") String  nameArRrCode, @PathVariable("bussineId") int  bussineId ) throws IOException {
        return articleDetailService.getListDTO(nameArRrCode, bussineId);
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

    @PostMapping(value ="/editArticleDetailOne")
    public ResponseEntity<Article> editArticleDetailOne(@RequestParam("fileArticle") MultipartFile fileArticle, @RequestParam("articleData") String articleData) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
        Article article = this.mapper.readValue(articleData, Article.class);
        Article articleNewData = articleDetailService.editArticleData(fileArticle, article);
        return ResponseEntity.status(HttpStatus.OK).body(articleNewData);
    }

    @PostMapping(value ="/editArticleData")
    public ResponseEntity<Article> editArticleData( @RequestParam("articleData") String articleData) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
        Article article = this.mapper.readValue(articleData, Article.class);
        Article articleNewData = articleDetailService.editArticleData(null, article);
        return ResponseEntity.status(HttpStatus.OK).body(articleNewData);
    }


    @GetMapping(value = "/getArticleBussine/{bussineId}")
    public List<SelectVEO> getArticleBussine(@PathVariable("bussineId") int  bussineId) throws  IOException {
      return  articleDetailService.getSelectArticleList(bussineId);
    }

    @GetMapping(value = "/getArticleBussineId")
    public List<Object> getArticleBussineId(){
        return articleDetailService.getArticleBussineId();
    }


    @GetMapping(value = "/getSubSectionListArticle/{subSectionId}")
    public List<Object> getSubSectionListArticle(@PathVariable("subSectionId") int subSectionId){
        return articleDetailService.getSubSelectListArticleId(subSectionId);
    }

    @PostMapping(value="/addArticleDetail")
    public boolean addArticleDetail(@RequestBody List<ArticleDetail> articleDetailData )throws IOException{
        return articleDetailService.addArticleRelational(articleDetailData);
    }


}
