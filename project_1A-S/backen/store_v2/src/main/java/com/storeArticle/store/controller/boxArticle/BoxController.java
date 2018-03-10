package com.storeArticle.store.controller.boxArticle;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Box;
import com.storeArticle.store.model.accounts.ListProduct;
import com.storeArticle.store.service.boxArticle.BoxService;
import com.storeArticle.store.service.dto.BoxVEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RestController
@RequestMapping(value="/box")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class BoxController {


    @Autowired
    private BoxService boxService ;
    protected ObjectMapper mapper;
    public BoxController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/getBox")
    public BoxVEO getBox(@RequestBody Box BoxUser)throws IOException {
        return boxService.getBoxArticle(BoxUser);
    }

    @PostMapping(value = "/addBoxArticle")
    public boolean addBoxArticle(@RequestBody ListProduct articleList )throws IOException{
        this.mapper = new ObjectMapper();
        return boxService.addArticleBoxOrCreateBox(articleList);
    }

}
