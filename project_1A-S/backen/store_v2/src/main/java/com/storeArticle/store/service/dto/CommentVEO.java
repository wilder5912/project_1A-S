package com.storeArticle.store.service.dto;

import java.io.Serializable;


public class CommentVEO implements Serializable {

    private UserVEO userVEO;

    private String nameComment;

    private int rating;

    private String dateComment;


    public UserVEO getUserVEO() {
        return userVEO;
    }

    public void setUserVEO(UserVEO userVEO) {
        this.userVEO = userVEO;
    }

    public String getNameComment() {
        return nameComment;
    }

    public void setNameComment(String nameComment) {
        this.nameComment = nameComment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDateComment() {
        return dateComment;
    }

    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }
}

