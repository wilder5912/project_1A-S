package com.storeArticle.store.service;

import com.storeArticle.store.entity.TypeUser;

import java.util.List;

//import com.storeArticle.store.entity.Article;

public interface UserServiveI {
    public List<TypeUser> getUser(String email, String password);
}
