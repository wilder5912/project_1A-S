package com.storeArticle.store.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.GroupProduct;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.groupProductService.GroupProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
        public boolean addGroupProduct(@RequestBody String groupProductData)throws  IOException {
            this.mapper = new ObjectMapper();
            GroupProduct groupProduct = this.mapper.readValue(groupProductData, GroupProduct.class);
            return groupProductService.addGroupProductName(groupProduct);
    }
     @GetMapping(value = "/getGroupProduct")
        public List<GroupProduct> getGroupProduct()throws IOException {
            return groupProductService.getGroupProduct();
    }

    @PostMapping(value = "/editGroupProduct")
    public boolean editGroupProduct(@RequestBody String groupProductData)throws IOException {
        this.mapper = new ObjectMapper();
        GroupProduct groupProduct = this.mapper.readValue(groupProductData, GroupProduct.class);
        return groupProductService.updatedGroupProductName(groupProduct);
    }

    @PostMapping(value = "/deleteGroupProduct")
    public boolean deleteGroupProduct(@RequestBody String groupProductData)throws IOException {
        this.mapper = new ObjectMapper();
        GroupProduct groupProduct = this.mapper.readValue(groupProductData, GroupProduct.class);
        return groupProductService.deleteGroupProductName(groupProduct.getGroupId());
    }

    @GetMapping(value = "/getBussineGroupList/{idBussine}")
    public List<SelectVEO> getBussineGroupList(@PathVariable("idBussine") String idBussine){
            return groupProductService.getListGroupDTO(Integer.parseInt(idBussine));
    }
}



