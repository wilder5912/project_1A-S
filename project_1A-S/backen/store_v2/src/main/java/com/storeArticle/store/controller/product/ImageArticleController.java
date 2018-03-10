package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.ArticleDetail;
import com.storeArticle.store.model.accounts.ImageArticle;
import com.storeArticle.store.service.groupProductService.ImageArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/imageArticle")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ImageArticleController {

    @Autowired
    private ImageArticleService imageArticleService;

    protected ObjectMapper mapper;


    public ImageArticleController(){
        mapper = new ObjectMapper();
    }

    @GetMapping(value="/getImageArticle")
    public List<ImageArticle> getSection() throws IOException {
        return imageArticleService.getSubSectionList();
    }

    @PostMapping(value ="/updateArticleImageDetailOne")
    public ResponseEntity<String> updateArticleImageDetailOne(@RequestParam("fileArticle") MultipartFile fileArticle, @RequestParam("idArticle") String idArticle) throws IOException{
        String message = "";
        ArticleDetail resArticleDetail=null;
        this.mapper = new ObjectMapper();
        imageArticleService.addArticleAndSubSection(fileArticle,Integer.parseInt(idArticle));
        return ResponseEntity.status(HttpStatus.OK).body("Done");
    }

    @GetMapping(value="/getImageArticleIdList/{articleId}")
    public List<ImageArticle> getImageArticleIdList(@PathVariable("articleId") int articleId) throws IOException {
        return imageArticleService.getImageArticleList(articleId);
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile2(@PathVariable String filename) {
        Resource file = imageArticleService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "-\"")
                .body(file);
    }




}
