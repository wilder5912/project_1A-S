package com.storeArticle.store.service.enumPage;

public enum CommentQueryEnum {

    getRantingHql("select AVG(comment.rating) as sumranting FROM Comment as comment " +
                "where comment.articleId.articleId = ? and  " +
                "comment.isDelete = ?"),
    getCommentHql("select comment.nameComment, comment.rating, " +
                " comment.dateComment, comment.userId.firtNameUser, " +
                " comment.userId.lastNameUser, comment.userId.imagenUser " +
                " FROM Comment as comment " +
                " where comment.articleId.articleId = ? and  " +
                " comment.isDelete = ?");

    private String hql;

    CommentQueryEnum(String hql) {
        this.hql = hql;
    }

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }
}
