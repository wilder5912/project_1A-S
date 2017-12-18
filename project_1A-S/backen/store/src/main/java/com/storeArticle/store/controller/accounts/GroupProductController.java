package com.storeArticle.store.controller.accounts;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.GroupProduct;
import com.storeArticle.store.service.groupProductService.GroupProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RestController
@RequestMapping(value="/groupProduct")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class GroupProductController {

    @Autowired
    private GroupProductService groupProductService;

    protected ObjectMapper mapper;

    @PostMapping(value = "/addGroupProduct")
        public boolean addGroupProduct(@RequestBody String groupProductData)throws JsonParseException, JsonMappingException, IOException {
            this.mapper = new ObjectMapper();
            GroupProduct groupProduct = this.mapper.readValue(groupProductData, GroupProduct.class);
            return groupProductService.addGroupProductName(groupProduct);
    }
}



