package com.storeArticle.store.controller.product;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.GroupProduct;
import com.storeArticle.store.service.dto.BussineDTO;
import com.storeArticle.store.service.dto.GroupProductDTO;
import com.storeArticle.store.service.groupProductService.BussineService;
import com.storeArticle.store.service.groupProductService.GroupProductService;
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

    @GetMapping(value = "/getBussineDTO")
    public List<BussineDTO> getBussineDTO()throws JsonParseException, JsonMappingException, IOException {
        return bussineService.getBussineDTO();
    }


}
