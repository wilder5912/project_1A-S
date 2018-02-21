package com.storeArticle.store.controller.product;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.accounts.Banner;
import com.storeArticle.store.model.accounts.Comment;
import com.storeArticle.store.service.dto.CommentVEO;
import com.storeArticle.store.service.groupProductService.BannerService;
import com.storeArticle.store.service.groupProductService.CommentService;
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
@RequestMapping(value="/comment")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class CommentController {

    @Autowired
    private CommentService commentService;
    protected ObjectMapper mapper;
    public CommentController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/addComment")
    public List<CommentVEO> getListBanner(@RequestBody String comment)throws  IOException{
        this.mapper = new ObjectMapper();
        Comment commentData = this.mapper.readValue(comment, Comment.class);
        return commentService.addAndGetComment(commentData);
    }

   /* @PostMapping(value ="/updateImageArticle")
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
    }*/

}
