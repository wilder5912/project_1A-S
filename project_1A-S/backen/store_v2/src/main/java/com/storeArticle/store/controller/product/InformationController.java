package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Information;
import com.storeArticle.store.service.groupProductService.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RestController
@RequestMapping(value="/information")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class InformationController {

    @Autowired
    private InformationService informationService;

    protected ObjectMapper mapper;


    public InformationController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/addInformationArticle")
    public boolean addInformationArticle(@RequestBody String information)throws IOException{
        this.mapper = new ObjectMapper();
        Information informacionData = this.mapper.readValue(information, Information.class);
        return informationService.addInformation(informacionData);
    }

}
