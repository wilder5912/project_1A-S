package com.storeArticle.store.controller.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.provider.ArticleProvider;
import com.storeArticle.store.service.ProviderProductService.ArticleProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/articleProvider")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ArticleProviderController {

    @Autowired
    private ArticleProviderService articleProviderService;

    protected ObjectMapper mapper;
    public ArticleProviderController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/addArticleProvider")
    public boolean addArticleProvider(@RequestBody ArticleProvider articleProvider)throws IOException {
        return articleProviderService.addArticleProvider(articleProvider);
    }

    @GetMapping(value = "/listArticleProvider")
    public List<ArticleProvider> listArticleProvider()throws IOException{
        return articleProviderService.getProviderListAll();
    }

    @PostMapping(value = "/deleteArticleProvider")
    public boolean deleteArticleProvider(@RequestBody ArticleProvider articleProvider)throws IOException {
        return articleProviderService.deleteArticleProvider(articleProvider.getArticleProviderId());
    }

    @PostMapping(value = "/editArticleProvider")
    public boolean editProvider(@RequestBody ArticleProvider articleProvider)throws IOException {
        return articleProviderService.updatedArticleProvider(articleProvider);
    }
}
