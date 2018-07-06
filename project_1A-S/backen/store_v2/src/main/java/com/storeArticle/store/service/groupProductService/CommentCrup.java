package com.storeArticle.store.service.groupProductService;

 import com.storeArticle.store.model.groupProductModel.Comment;

public interface CommentCrup {

    boolean addArticle(Comment comment);

    boolean deleteComment(int commentId);

    boolean updatedComment(Comment comment);

    Comment getComment(int commentId);

    Boolean getIsComment();
}
