package com.storeArticle.store.service.dto;

import com.storeArticle.store.service.groupProductService.ArticleService;
import com.storeArticle.store.service.groupProductService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentDTOService {

    @Autowired
    private CommentService commentService;

    public List<CommentVEO> getCommentDTO(List<Object[]> commentList){
        List<CommentVEO> commentDTOList = new ArrayList<CommentVEO>();
       try{
            commentList.forEach(SelectData->{
                UserVEO userVEO = new UserVEO();
                CommentVEO commentVEOInfo = new CommentVEO();
                commentVEOInfo.setNameComment(SelectData[0].toString());
                commentVEOInfo.setDateComment(SelectData[2].toString());
                commentVEOInfo.setRating(Integer.parseInt(SelectData[1].toString()));
                userVEO.setFirtNameUser(SelectData[3].toString());
                userVEO.setLastNameUser(SelectData[4].toString());
                userVEO.setImagenUser(SelectData[5].toString());
                commentVEOInfo.setUserVEO(userVEO);
                commentDTOList.add(commentVEOInfo);
            });
        }catch(Exception e){
        }finally{
        }
        return commentDTOList;
    }

}
