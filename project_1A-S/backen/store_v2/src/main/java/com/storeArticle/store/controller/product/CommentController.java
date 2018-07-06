package com.storeArticle.store.controller.product;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeArticle.store.model.groupProductModel.Comment;
import com.storeArticle.store.service.dto.CommentVEO;
import com.storeArticle.store.service.groupProductService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private SimpMessagingTemplate template;

    public CommentController(){
        mapper = new ObjectMapper();
    }

    @PostMapping(value = "/addComment")
    public List<CommentVEO> getListBanner(@RequestBody String comment)throws  IOException{
        this.mapper = new ObjectMapper();
        Comment commentData = this.mapper.readValue(comment, Comment.class);
        List<CommentVEO> listComment = commentService.addAndGetComment(commentData);
        template.convertAndSend("/topic/listComment", "");

        return listComment;
    }

    @PostMapping(value = "/getCommentArticleId")
    public List<CommentVEO> getCommentArticleId(@RequestBody String comment)throws  IOException{
        this.mapper = new ObjectMapper();
        Comment commentData = this.mapper.readValue(comment, Comment.class);
        return commentService.getCommentDTOS(commentData.getArticleId().getArticleId());
    }

}
