package com.storeArticle.store.controller.product;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.groupProductModel.Business;
import com.storeArticle.store.service.dto.BusinessVEO;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.groupProductService.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/business")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class BusinessController {


    @Autowired
    private BusinessService businessService ;

    protected ObjectMapper mapper;
    public BusinessController(){
        mapper = new ObjectMapper();
    }


    @PostMapping(value = "/addBusiness")
    public boolean addBusiness(@RequestBody String businessData)throws  IOException {
        this.mapper = new ObjectMapper();
        Business business = this.mapper.readValue(businessData, Business.class);
        return businessService.addBusiness(business);
    }

    @GetMapping(value= "/getBusinessList")
    public List<Business> getBusinessList(){
        return businessService.getBusinessList();
    }

    @GetMapping(value = "/getBusinessDTO")
    public List<SelectVEO> getBusinessDTO()throws IOException {
        return businessService.getBussineDTO();
    }

    @PostMapping(value = "/getBusinessListAllDTO")
    public BusinessVEO getBusinessListAllDTO(@RequestBody String bussineData)throws IOException {
        this.mapper = new ObjectMapper();
        Business businessI = this.mapper.readValue(bussineData, Business.class);
        return businessService.getBusinessAll(businessI);
    }

    @PutMapping(value = "/deleteBusiness/{businessId}")
    public ResponseEntity<Business> deleteBusiness(@RequestBody String businessData, @PathVariable("businessId") int businessId)throws IOException {
        this.mapper = new ObjectMapper();
        Business business = this.mapper.readValue(businessData, Business.class);
        return businessService.deleteRequest(business,businessId );
    }

    @PutMapping(value = "/editBusiness/{businessId}")
    public ResponseEntity<Business> editBusiness(@RequestBody String businessData, @PathVariable("businessId") int businessId )throws IOException {
        this.mapper = new ObjectMapper();
        Business business = this.mapper.readValue(businessData, Business.class);
        return businessService.UpdateRequest(business, businessId);
    }




}
