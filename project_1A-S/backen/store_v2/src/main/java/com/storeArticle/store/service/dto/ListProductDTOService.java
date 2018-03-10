package com.storeArticle.store.service.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductDTOService {

@Autowired
private ArticleDTOService articleDTOService;

    public ListProductVEO getListProductVEO(List<Object[]> listArticle){
        ListProductVEO listProductVEO  =  new ListProductVEO();
        listProductVEO.setArticleVEO(articleDTOService.getArticleBox(listArticle));
        return listProductVEO;
    }

}

