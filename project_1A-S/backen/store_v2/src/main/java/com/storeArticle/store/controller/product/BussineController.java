package com.storeArticle.store.controller.product;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Bussine;
import com.storeArticle.store.service.dto.BussineVEO;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.groupProductService.BussineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/bussine")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class BussineController {


    @Autowired
    private BussineService bussineService ;

    protected ObjectMapper mapper;
    public BussineController(){
        mapper = new ObjectMapper();
    }

    @GetMapping(value = "/getBussineDTO")
    public List<SelectVEO> getBussineDTO()throws IOException {
        return bussineService.getBussineDTO();
    }

    @PostMapping(value = "/getBussineListAllDTO")
    public BussineVEO getBussineListAllDTO(@RequestBody String bussineData)throws IOException {
        this.mapper = new ObjectMapper();
        Bussine bussine = this.mapper.readValue(bussineData, Bussine.class);
        return bussineService.getBussineAll(bussine);
    }




}
