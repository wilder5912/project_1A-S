package com.storeArticle.store.service.accounts;

import com.storeArticle.store.model.accounts.TypeUser;
import com.storeArticle.store.model.accounts.User;

import java.util.Date;
import java.util.List;

//import com.storeArticle.store.entity.Article;

 interface UserCrup {

    void addUser(User user);

    void deleteUser(int userId);

    void updatedUser(int userId, User user);

    User getUser(int userId);

    Boolean getIsDeleted();

}
