package com.storeArticle.store.controller.product;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.groupProductModel.Banner;
import com.storeArticle.store.service.groupProductService.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping(value="/banner")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class BannerController {

    @Autowired
    private BannerService bannerService ;
    protected ObjectMapper mapper;
    public BannerController(){
        mapper = new ObjectMapper();
    }
    @GetMapping(value = "/getListBanner")
    public List<Banner> getListBanner(){
        return bannerService.getBannerList();
    }

    @PostMapping(value ="/updateImageArticle")
    public ResponseEntity<String> editImageUserOne(@RequestParam("fileBanner") MultipartFile fileBanner, @RequestParam("banner") String banner) throws  IOException {
        String message = "";
        this.mapper = new ObjectMapper();
        try {
            Banner bannerData = this.mapper.readValue(banner, Banner.class);
            bannerService.addbannerImage(fileBanner,bannerData);
            message = "You successfully uploaded " + fileBanner.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + fileBanner.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

}
